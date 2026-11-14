// javac -encoding UTF-8 -cp $SDK/platforms/android-34/android.jar:libs/androidx-webkit-1.12.1.jar:json.jar -sourcepath src -d /tmp/jat src/me/champdev/weblock/JaTitles.java test/JaTitlesTest.java && java -cp /tmp/jat:json.jar me.champdev.weblock.JaTitlesTest
package me.champdev.weblock;

import java.util.Arrays;
import java.util.Map;

public class JaTitlesTest {
    static int fails;
    static void check(String name, boolean ok) { if (!ok) { fails++; System.out.println("FAIL " + name); } }

    public static void main(String[] a) {
        String q = JaTitles.query(Arrays.asList("tt1375666", "tt2560140"));
        check("query has both ids", q.contains("\"tt1375666\"") && q.contains("\"tt2560140\""));
        check("query filters to japanese labels", q.contains("LANG(?label) = \"ja\""));
        check("query matches on imdb property", q.contains("wdt:P345"));

        String json = "{\"results\":{\"bindings\":["
            + "{\"imdb\":{\"value\":\"tt1375666\"},\"label\":{\"value\":\"インセプション\",\"xml:lang\":\"ja\"}},"
            + "{\"imdb\":{\"value\":\"tt2560140\"},\"label\":{\"value\":\"進撃の巨人\",\"xml:lang\":\"ja\"}},"
            + "{\"imdb\":{\"value\":\"kitsu:1\"},\"label\":{\"value\":\"x\",\"xml:lang\":\"ja\"}}"
            + "]}}";
        Map<String, String> m = JaTitles.parse(json);
        check("parse keeps imdb entries", m.size() == 2);
        check("parse reads japanese label", "インセプション".equals(m.get("tt1375666")));
        check("parse drops non-imdb ids", !m.containsKey("kitsu:1"));
        check("parse of junk is empty", JaTitles.parse("not json").isEmpty());
        check("parse of empty results is empty", JaTitles.parse("{\"results\":{\"bindings\":[]}}").isEmpty());

        Catalog.Title t = new Catalog.Title();
        t.name = "Inception";
        check("displayName falls back to english", t.displayName().equals("Inception"));
        t.nameJa = "インセプション";
        check("displayName prefers japanese", t.displayName().equals("インセプション"));
        check("name itself stays english", t.name.equals("Inception"));

        if (fails == 0) System.out.println("all ja-title expectations pass");
        System.exit(fails == 0 ? 0 : 1);
    }
}
