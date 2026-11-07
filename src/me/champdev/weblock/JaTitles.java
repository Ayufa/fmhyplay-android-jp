package me.champdev.weblock;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Japanese display titles from Wikidata, keyed by IMDb id (property P345). Keyless and read-only.
 * Display only: Title.name stays the English original everywhere it is matched or sent to a site;
 * screens show Title.displayName() instead. Results (and misses) are cached on disk, so a title is
 * looked up once, not on every visit. Any failure leaves the English name in place.
 */
final class JaTitles {
    private static final String ENDPOINT = "https://query.wikidata.org/sparql";
    private static final long HIT_TTL = 90L * 24 * 3600 * 1000, MISS_TTL = 7L * 24 * 3600 * 1000;
    private static final int CHUNK = 40;
    private static final Object LOCK = new Object();
    private static JSONObject cache;   // imdb id -> [japanese title ("" = none), fetched-at millis]

    private JaTitles() { }

    /** Sets nameJa from the on-disk cache only (no network): safe on the main thread. */
    static void applyCached(List<Catalog.Title> titles) {
        synchronized (LOCK) {
            load();
            long now = System.currentTimeMillis();
            for (Catalog.Title t : titles) {
                String ja = fresh(t.id, now);
                if (ja != null && !ja.isEmpty()) t.nameJa = ja;
            }
        }
    }

    /** applyCached, plus one batched Wikidata lookup for every id not fresh in the cache. Call off the main thread. */
    static void enrich(List<Catalog.Title> titles) {
        List<String> want = new ArrayList<>();
        synchronized (LOCK) {
            load();
            long now = System.currentTimeMillis();
            for (Catalog.Title t : titles) {
                String ja = fresh(t.id, now);
                if (ja != null) { if (!ja.isEmpty()) t.nameJa = ja; }
                else if (t.id.matches("tt\\d+") && !want.contains(t.id)) want.add(t.id);
            }
        }
        for (int i = 0; i < want.size(); i += CHUNK) {
            Map<String, String> found = fetch(want.subList(i, Math.min(i + CHUNK, want.size())));
            if (found == null) continue;   // lookup failed: cache nothing, so a later visit retries
            synchronized (LOCK) {
                long now = System.currentTimeMillis();
                for (String id : want.subList(i, Math.min(i + CHUNK, want.size()))) {
                    String ja = found.containsKey(id) ? found.get(id) : "";
                    try {
                        cache.put(id, new JSONArray().put(ja).put(now));
                    } catch (Exception ignored) { }
                    for (Catalog.Title t : titles) if (t.id.equals(id) && !ja.isEmpty()) t.nameJa = ja;
                }
                save();
            }
        }
    }

    static void enrichOne(Catalog.Title t) {
        List<Catalog.Title> one = new ArrayList<>();
        one.add(t);
        enrich(one);
    }

    /** The cached title for an id, "" for a cached miss, null when absent or stale. Caller holds LOCK. */
    private static String fresh(String id, long now) {
        if (cache == null || !id.matches("tt\\d+")) return null;
        JSONArray a = cache.optJSONArray(id);
        if (a == null) return null;
        String ja = a.optString(0);
        long at = a.optLong(1);
        return now - at < (ja.isEmpty() ? MISS_TTL : HIT_TTL) ? ja : null;
    }

    /** One SPARQL round trip for a chunk of ids; null when the request itself failed. */
    private static Map<String, String> fetch(List<String> ids) {
        try {
            String url = ENDPOINT + "?query=" + URLEncoder.encode(query(ids), "UTF-8") + "&format=json";
            HttpURLConnection c = Warp.open(url);
            c.setConnectTimeout(8000);
            c.setReadTimeout(10000);
            c.setRequestProperty("User-Agent", "FMHYPlayJP/1.1 (https://github.com/Ayufa/fmhyplay-android-jp)");
            c.setRequestProperty("Accept", "application/sparql-results+json");
            if (c.getResponseCode() != 200) return null;
            return parse(Sites.readAll(c.getInputStream()));
        } catch (Exception e) {
            return null;
        }
    }

    static String query(List<String> ids) {
        StringBuilder q = new StringBuilder("SELECT ?imdb ?label WHERE { VALUES ?imdb {");
        for (String id : ids) q.append(" \"").append(id).append('"');
        return q.append(" } ?item wdt:P345 ?imdb . ?item rdfs:label ?label . FILTER (LANG(?label) = \"ja\") }").toString();
    }

    static Map<String, String> parse(String json) {
        Map<String, String> out = new HashMap<>();
        try {
            JSONArray rows = new JSONObject(json).getJSONObject("results").getJSONArray("bindings");
            for (int i = 0; i < rows.length(); i++) {
                JSONObject r = rows.getJSONObject(i);
                String id = r.getJSONObject("imdb").optString("value");
                String label = r.getJSONObject("label").optString("value").trim();
                if (id.matches("tt\\d+") && !label.isEmpty()) out.put(id, label);
            }
        } catch (Exception ignored) { }
        return out;
    }

    private static File file() {
        return new File(App.app.getFilesDir(), "jatitles.json");
    }

    private static void load() {
        if (cache != null) return;
        try {
            File f = file();
            cache = f.exists() ? new JSONObject(Sites.readAll(new java.io.FileInputStream(f))) : new JSONObject();
        } catch (Exception e) {
            cache = new JSONObject();
        }
    }

    private static void save() {
        try (FileOutputStream out = new FileOutputStream(file())) {
            out.write(cache.toString().getBytes(StandardCharsets.UTF_8));
        } catch (Exception ignored) { }
    }
}
