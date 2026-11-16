// SDK=~/Library/Android/sdk; json.jar = org.json from maven; LIBS = libs/*.jar:
// javac -nowarn -implicit:none -cp "json.jar:$LIBS$SDK/platforms/android-34/android.jar" -sourcepath src:build -d /tmp/dltest src/me/champdev/weblock/Downloads.java test/DownloadsTest.java && java -cp /tmp/dltest:json.jar me.champdev.weblock.DownloadsTest
package me.champdev.weblock;

public class DownloadsTest {
    static int fails;

    static void check(String name, Object got, Object want) {
        if (!String.valueOf(got).equals(String.valueOf(want))) { fails++; System.out.println("FAIL " + name + ": got " + got + " want " + want); }
    }

    static byte[] cat(byte[] a, byte[] b) {
        byte[] out = java.util.Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, out, a.length, b.length);
        return out;
    }

    public static void main(String[] a) {
        long[] last = {Long.MIN_VALUE, Long.MIN_VALUE}, shift = {0, 0};
        long t = 0;
        // a smooth stream is left alone, B-frame order included
        for (long raw : new long[]{100_000_000L, 100_040_000L, 100_120_000L, 100_080_000L}) { t = Downloads.Timeline.on(raw, last, shift, 0); last[0] = Math.max(last[0], t); }
        check("smooth stays", t, 100_080_000L);
        // the times start over from 0 (a joined segment): carried on from the latest, not back to 0
        t = Downloads.Timeline.on(0, last, shift, 0);
        check("reset goes on", t, 100_120_000L + Downloads.Timeline.STEP);
        last[0] = t;
        t = Downloads.Timeline.on(40_000, last, shift, 0);
        check("and keeps going", t, 100_120_000L + Downloads.Timeline.STEP + 40_000);
        // the sound has its own shift
        long s = Downloads.Timeline.on(100_000_000L, last, shift, 1);
        check("sound unaffected at its start", s, 100_000_000L);
        // a jump forward is a reset too
        last[1] = s;
        s = Downloads.Timeline.on(200_000_000L, last, shift, 1);
        check("a jump forward closes up", s, 100_000_000L + Downloads.Timeline.STEP);
        // HLS: byte ranges (one file holds every piece; no offset means "right after the last one")
        try {
            String pl = "#EXTM3U\n#EXT-X-ENDLIST\n#EXT-X-MAP:URI=\"main.mp4\",BYTERANGE=\"1119@0\"\n#EXTINF:8,\n#EXT-X-BYTERANGE:5000@1119\nmain.mp4\n#EXTINF:8,\n#EXT-X-BYTERANGE:3000\nmain.mp4\n#EXTINF:8,\nplain.ts\n";
            Downloads.Track tr = Downloads.Hls.track(pl, "https://x.test/v/prog.m3u8");
            check("map", tr.map + " " + tr.mapFrom + " " + tr.mapLen, "https://x.test/v/main.mp4 0 1119");
            check("first range", tr.segs.get(0).from + " " + tr.segs.get(0).len, "1119 5000");
            check("range with no offset follows", tr.segs.get(1).from + " " + tr.segs.get(1).len, "6119 3000");
            check("a piece with no range is whole", tr.segs.get(2).from, -1L);
            check("fMP4 is not a .ts", tr.ts, false);
            check("a plain playlist is MPEG-TS", Downloads.Hls.track("#EXTM3U\n#EXT-X-ENDLIST\n#EXTINF:4,\na.ts\n", "https://x.test/p.m3u8").ts, true);
        } catch (Exception e) { fails++; System.out.println("FAIL byte ranges: " + e); }
        try { Downloads.Hls.track("#EXTM3U\n#EXTINF:4,\na.ts\n", "https://x.test/p.m3u8"); fails++; System.out.println("FAIL live playlist accepted"); }
        catch (Downloads.Refused e) { check("live playlist refused", e.res, R.string.dl_live); } catch (Exception e) { fails++; System.out.println("FAIL live: " + e); }

        // DASH: a timeline, a length, ranges, and what is refused
        String mpd = "<MPD type=\"static\" mediaPresentationDuration=\"PT20S\"><BaseURL>https://cdn.test/vod/</BaseURL><Period>"
            + "<AdaptationSet contentType=\"video\" mimeType=\"video/mp4\"><SegmentTemplate timescale=\"1000\" initialization=\"v-$RepresentationID$-init.mp4\" media=\"v-$RepresentationID$-$Time$.m4s\">"
            + "<SegmentTimeline><S t=\"0\" d=\"4000\" r=\"2\"/><S d=\"8000\"/></SegmentTimeline></SegmentTemplate>"
            + "<Representation id=\"low\" bandwidth=\"500000\" width=\"640\" height=\"360\" codecs=\"avc1.4d401e\"/>"
            + "<Representation id=\"hi\" bandwidth=\"2000000\" width=\"1280\" height=\"720\" codecs=\"avc1.64001f\"/></AdaptationSet>"
            + "<AdaptationSet contentType=\"video\" mimeType=\"video/webm\"><Representation id=\"vp9\" bandwidth=\"9000000\" height=\"1080\" codecs=\"vp09.00.40.08\"/></AdaptationSet>"
            + "<AdaptationSet contentType=\"audio\" mimeType=\"audio/mp4\" lang=\"en\"><SegmentTemplate timescale=\"48000\" duration=\"192000\" startNumber=\"1\" initialization=\"a-init.mp4\" media=\"a-$Number%03d$.m4s\"/>"
            + "<Representation id=\"a1\" bandwidth=\"128000\" codecs=\"mp4a.40.2\"/></AdaptationSet></Period></MPD>";
        try {
            Downloads.Dash.Pick p = Downloads.Dash.pick(mpd, "https://cdn.test/vod/manifest.mpd");
            check("best MP4 picture, WebM skipped", p.height, 720);
            check("init", p.video.map, "https://cdn.test/vod/v-hi-init.mp4");
            StringBuilder u = new StringBuilder();
            for (Downloads.Seg sg : p.video.segs) u.append(sg.url.replaceFirst(".*/v-hi-", "")).append(" ").append(sg.dur).append(", ");
            check("timeline pieces", u, "0.m4s 4.0, 4000.m4s 4.0, 8000.m4s 4.0, 12000.m4s 8.0, ");
            check("a length: 20 s in 4 s pieces", p.audio.segs.size(), 5);
            check("padded numbers", p.audio.segs.get(4).url, "https://cdn.test/vod/a-005.m4s");
            check("not a .ts", p.video.ts, false);
        } catch (Exception e) { fails++; System.out.println("FAIL dash: " + e); }
        try {
            String list = "<MPD mediaPresentationDuration=\"PT8S\"><Period><AdaptationSet mimeType=\"video/mp4\"><Representation id=\"v\" bandwidth=\"1\" height=\"480\" codecs=\"avc1.42\"><BaseURL>v/</BaseURL>"
                + "<SegmentList duration=\"4\"><Initialization sourceURL=\"i.mp4\" range=\"0-99\"/><SegmentURL media=\"s1.m4s\"/><SegmentURL media=\"big.mp4\" mediaRange=\"100-199\"/></SegmentList></Representation></AdaptationSet></Period></MPD>";
            Downloads.Track lt = Downloads.Dash.pick(list, "https://cdn.test/m.mpd").video;
            check("list init range", lt.map + " " + lt.mapFrom + " " + lt.mapLen, "https://cdn.test/v/i.mp4 0 100");
            check("list piece with a range", lt.segs.get(1).url + " " + lt.segs.get(1).from + " " + lt.segs.get(1).len, "https://cdn.test/v/big.mp4 100 100");
            check("no sound in the manifest", Downloads.Dash.pick(list, "https://cdn.test/m.mpd").audio, null);
        } catch (Exception e) { fails++; System.out.println("FAIL dash list: " + e); }
        String until = "<MPD mediaPresentationDuration=\"PT10S\"><Period><AdaptationSet mimeType=\"video/mp4\"><SegmentTemplate timescale=\"1\" media=\"$Time$.m4s\"><SegmentTimeline><S t=\"0\" d=\"2\" r=\"-1\"/></SegmentTimeline></SegmentTemplate><Representation id=\"v\" bandwidth=\"1\"/></AdaptationSet></Period></MPD>";
        try { check("r=-1 runs to the end of the period", Downloads.Dash.pick(until, "https://x.test/m.mpd").video.segs.size(), 5); } catch (Exception e) { fails++; System.out.println("FAIL until end: " + e); }
        for (String[] bad : new String[][]{
            {"<MPD type=\"dynamic\"><Period/></MPD>", "" + R.string.dl_live},
            {mpd.replace("<Representation id=\"hi\"", "<ContentProtection schemeIdUri=\"urn:x\"/><Representation id=\"hi\""), "" + R.string.dl_protected},
            {"<MPD mediaPresentationDuration=\"PT8S\"><Period><AdaptationSet mimeType=\"video/mp4\"><Representation id=\"v\" bandwidth=\"1\"/></AdaptationSet></Period></MPD>", "" + R.string.dl_dash_pieces}}) {
            try { Downloads.Dash.pick(bad[0], "https://x.test/m.mpd"); fails++; System.out.println("FAIL accepted: " + bad[0].substring(0, 40)); }
            catch (Downloads.Refused e) { check("refused " + bad[1], e.res, Integer.parseInt(bad[1])); } catch (Exception e) { fails++; System.out.println("FAIL refused with " + e); }
        }
        try { Downloads.Dash.pick("<!DOCTYPE x [<!ENTITY e SYSTEM \"file:///etc/passwd\">]><MPD/>", "https://x.test/m.mpd"); fails++; System.out.println("FAIL doctype accepted"); } catch (java.io.IOException e) { check("no doctype", true, true); }
        String two = "<MPD mediaPresentationDuration=\"PT120S\"><Period duration=\"PT60S\"><AdaptationSet mimeType=\"video/mp4\"><SegmentTemplate media=\"a$Number$.m4s\" duration=\"4\"/><Representation id=\"v\" bandwidth=\"1\"/></AdaptationSet></Period>"
            + "<Period duration=\"PT60S\"><AdaptationSet mimeType=\"video/mp4\"><SegmentTemplate media=\"b$Number$.m4s\" duration=\"4\"/><Representation id=\"v\" bandwidth=\"1\"/></AdaptationSet></Period></MPD>";
        try { Downloads.Dash.pick(two, "https://x.test/m.mpd"); fails++; System.out.println("FAIL two long periods accepted"); }
        catch (Downloads.Refused e) { check("two long periods refused", e.res, R.string.dl_dash_periods); } catch (Exception e) { fails++; System.out.println("FAIL periods: " + e); }
        try {
            Downloads.Track film = Downloads.Dash.pick(two.replaceFirst("PT60S", "PT10S"), "https://x.test/m.mpd").video;   // a 10 s ident, then the film
            check("an ident period is skipped", film.segs.get(0).url, "https://x.test/b1.m4s");
        } catch (Exception e) { fails++; System.out.println("FAIL ident: " + e); }
        try {
            Downloads.Track whole = Downloads.Dash.pick("<MPD mediaPresentationDuration=\"PT8S\"><Period><AdaptationSet mimeType=\"video/mp4\"><Representation id=\"v\" bandwidth=\"1\" height=\"360\"><BaseURL>one.mp4</BaseURL><SegmentBase indexRange=\"0-9\"/></Representation></AdaptationSet></Period></MPD>", "https://x.test/d/m.mpd").video;
            check("one file per quality", whole.whole + " " + whole.segs.get(0).url, "true https://x.test/d/one.mp4");
        } catch (Exception e) { fails++; System.out.println("FAIL one file: " + e); }
        check("iso duration", Downloads.Dash.seconds("PT1H2M3.5S"), 3723.5);
        check("iso with days", Downloads.Dash.seconds("P1DT0H0M10S"), 86410.0);
        check("not a duration", Downloads.Dash.seconds("garbage"), 0.0);
        check("template", Downloads.Dash.fill("a/$RepresentationID$/$Number%05d$-$Bandwidth$-$Time$-$$.m4s", "v1", 500, 7, 9000), "a/v1/00007-500-9000-$.m4s");
        // the best variant is the highest one whose sound an MP4 can hold
        String master = "#EXTM3U\n#EXT-X-STREAM-INF:BANDWIDTH=2000000,CODECS=\"avc1.640020,mp4a.40.2\",RESOLUTION=960x540,AUDIO=\"aud1\"\nlow.m3u8\n"
            + "#EXT-X-STREAM-INF:BANDWIDTH=8000000,CODECS=\"avc1.64002a,mp4a.40.2\",RESOLUTION=1920x1080,AUDIO=\"aud1\"\nhigh.m3u8\n"
            + "#EXT-X-STREAM-INF:BANDWIDTH=8200000,CODECS=\"avc1.64002a,ac-3\",RESOLUTION=1920x1080,AUDIO=\"aud2\"\nac3.m3u8\n"
            + "#EXT-X-STREAM-INF:BANDWIDTH=8300000,CODECS=\"avc1.64002a,ec-3\",RESOLUTION=1920x1080,AUDIO=\"aud3\"\nec3.m3u8\n";
        check("AAC variant over a higher AC-3 one", java.util.Arrays.toString(Downloads.Hls.bestVariant(master)), "[high.m3u8, 1080, aud1, avc1.64002a,mp4a.40.2]");
        check("only AC-3: still the highest", java.util.Arrays.toString(Downloads.Hls.bestVariant(master.replace("mp4a.40.2", "ac-3"))), "[ec3.m3u8, 1080, aud3, avc1.64002a,ec-3]");
        check("no variants", Downloads.Hls.bestVariant("#EXTM3U\n"), null);
        // a stream with no sound is not downloaded: told from CODECS, an fMP4 init segment, or the stream table of a TS piece
        check("codecs with sound", Downloads.Hls.audible("avc1.64001f,mp4a.40.2"), true);
        check("codecs without", Downloads.Hls.audible("avc1.64001f"), false);
        try {
            java.nio.file.Path f = java.nio.file.Paths.get("test/fixtures");
            check("TS with sound", Downloads.Hls.tsAudible(java.nio.file.Files.readAllBytes(f.resolve("head-av.ts"))), true);
            check("TS without", Downloads.Hls.tsAudible(java.nio.file.Files.readAllBytes(f.resolve("head-video.ts"))), false);
            check("junk before a TS with sound", Downloads.Hls.tsAudible(cat(new byte[]{1, 2, 3}, java.nio.file.Files.readAllBytes(f.resolve("head-av.ts")))), true);
            check("not TS: not refused", Downloads.Hls.tsAudible(new byte[4000]), true);
            check("fMP4 with sound", Downloads.Hls.mp4Audible(java.nio.file.Files.readAllBytes(f.resolve("init-av.mp4"))), true);
            check("fMP4 without", Downloads.Hls.mp4Audible(java.nio.file.Files.readAllBytes(f.resolve("init-video.mp4"))), false);
        } catch (java.io.IOException e) { fails++; System.out.println("FAIL fixtures: " + e); }
        // smaller resets: a picture 1.5 s back, a sound any step back (an MP4 cannot take falling sound times)
        long[] l2 = {10_000_000L, 10_000_000L}, s2 = {0, 0};
        check("picture 0.4 s back: B-frames, kept", Downloads.Timeline.on(9_600_000L, l2, s2, 0), 9_600_000L);
        check("picture 1.5 s back: a reset", Downloads.Timeline.on(8_500_000L, l2, s2, 0), 10_000_000L + Downloads.Timeline.STEP);
        check("sound 50 ms back: a reset", Downloads.Timeline.on(9_950_000L, l2, s2, 1), 10_000_000L + Downloads.Timeline.STEP);
        check("sound at the same time: kept", Downloads.Timeline.on(10_000_000L, new long[]{0, 10_000_000L}, new long[]{0, 0}, 1), 10_000_000L);
        // DASH sound: the main one before an audio description, the chosen language before another
        String sounds = "<MPD mediaPresentationDuration=\"PT8S\"><Period><AdaptationSet mimeType=\"video/mp4\"><SegmentTemplate media=\"v$Number$.m4s\" duration=\"4\"/><Representation id=\"v\" bandwidth=\"1\"/></AdaptationSet>"
            + "<AdaptationSet mimeType=\"audio/mp4\" lang=\"en\"><Role schemeIdUri=\"urn:mpeg:dash:role:2011\" value=\"description\"/><SegmentTemplate media=\"ad$Number$.m4s\" duration=\"4\"/><Representation id=\"ad\" bandwidth=\"9\" codecs=\"mp4a.40.2\"/></AdaptationSet>"
            + "<AdaptationSet mimeType=\"audio/mp4\" lang=\"en\"><Role schemeIdUri=\"urn:mpeg:dash:role:2011\" value=\"main\"/><SegmentTemplate media=\"en$Number$.m4s\" duration=\"4\"/><Representation id=\"en\" bandwidth=\"1\" codecs=\"mp4a.40.2\"/></AdaptationSet>"
            + "<AdaptationSet mimeType=\"audio/mp4\" lang=\"hin\"><Role schemeIdUri=\"urn:mpeg:dash:role:2011\" value=\"dub\"/><SegmentTemplate media=\"hi$Number$.m4s\" duration=\"4\"/><Representation id=\"hi\" bandwidth=\"1\" codecs=\"mp4a.40.2\"/></AdaptationSet></Period></MPD>";
        try {
            check("main sound, not the description", Downloads.Dash.pick(sounds, "https://x.test/m.mpd").audio.segs.get(0).url, "https://x.test/en1.m4s");
            check("the chosen language first", Downloads.Dash.pick(sounds, "https://x.test/m.mpd", "hi").audio.segs.get(0).url, "https://x.test/hi1.m4s");
        } catch (Exception e) { fails++; System.out.println("FAIL sounds: " + e); }
        System.out.println(fails == 0 ? "all passed" : fails + " failed");
        if (fails > 0) System.exit(1);
    }
}
