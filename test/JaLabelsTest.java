// Needs JaLabels/Iptv compiled (e.g. the full-app compile output): javac -encoding UTF-8 -cp $SDK/platforms/android-37/android.jar:libs/*.jar:json.jar:<app-classes> -d /tmp/jal test/JaLabelsTest.java && java -cp /tmp/jal:json.jar:<app-classes> me.champdev.weblock.JaLabelsTest
package me.champdev.weblock;

public class JaLabelsTest {
    static int fails;
    static void check(String name, boolean ok) { if (!ok) { fails++; System.out.println("FAIL " + name); } }

    public static void main(String[] a) {
        check("genre translated", "アクション".equals(JaLabels.genre("Action")));
        check("genre sci-fi", "SF".equals(JaLabels.genre("Sci-Fi")));
        check("unknown genre passes through", "Klingon".equals(JaLabels.genre("Klingon")));
        check("genres joined", "アクション · ドラマ".equals(JaLabels.genres("Action · Drama")));
        check("genres single", "ホラー".equals(JaLabels.genres("Horror")));
        check("genres empty stays empty", "".equals(JaLabels.genres("")));
        check("genres null stays null", JaLabels.genres(null) == null);
        check("iptv category translated", "ニュース".equals(JaLabels.iptvCategory("News")));
        check("iptv mature", "成人向け".equals(JaLabels.iptvCategory("Mature")));
        check("iptv mine key", "マイプレイリスト".equals(JaLabels.iptvCategory(Iptv.MINE)));
        check("iptv streams key", "マイストリーム".equals(JaLabels.iptvCategory(Iptv.STREAMS)));
        check("unknown iptv category passes through", "Regional".equals(JaLabels.iptvCategory("Regional")));

        if (fails > 0) { System.out.println(fails + " FAILURES"); System.exit(1); }
        System.out.println("JaLabelsTest: all checks passed");
    }
}
