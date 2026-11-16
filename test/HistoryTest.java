// SDK=~/Library/Android/sdk; org.json from maven (json-20231013.jar):
// javac -implicit:none -cp "$SDK/platforms/android-34/android.jar:json.jar" -sourcepath src:build -d /tmp/history src/me/champdev/weblock/History.java test/HistoryTest.java && java -cp /tmp/history:json.jar me.champdev.weblock.HistoryTest
package me.champdev.weblock;

public class HistoryTest {
    static int fails;

    static void check(String name, Object got, Object want) {
        if (!String.valueOf(got).equals(String.valueOf(want))) { fails++; System.out.println("FAIL " + name + ": got " + got + " want " + want); }
    }

    public static void main(String[] a) {
        // a long number is an id, not an episode: no crash (it used to overflow an int), no episode
        check("huge episode id in the address", History.episode("https://x.tv/watch/episode-20261110123456", "Show"), "");
        check("huge episode number in the title", History.episode("https://x.tv/w", "Show Episode 99999999999"), "");
        check("huge season/episode query", History.episode("https://x.tv/w?s=99999999999&e=99999999999", "Show"), "");
        check("normal episode address still read", History.episode("https://x.tv/anime-1535-episode-3", "Show"), "E3");
        check("anime page", History.episodeUrl("https://anime.example/watch/anime-1535-episode-3", 3, 4), "https://anime.example/watch/anime-1535-episode-4");
        check("padding kept, query kept", History.episodeUrl("https://x.com/watch/show-ep-03?x=1", 3, 10), "https://x.com/watch/show-ep-10?x=1");
        check("the last one is swapped", History.episodeUrl("https://x.com/season-3/episode-3", 3, 4), "https://x.com/season-3/episode-4");
        check("not a longer number", History.episodeUrl("https://x.com/episode-31", 3, 4), null);
        check("no episode in the address", History.episodeUrl("https://x.com/movie/123", 3, 4), null);
        check("same episode", History.episodeUrl("https://x.com/episode-3", 3, 3), null);
        check("no address", History.episodeUrl(null, 3, 4), null);
        check("number from the address", History.episodeNumber("https://anime.example/watch/anime-1535-episode-3", ""), 3);
        check("number from the title", History.episodeNumber("https://x.com/watch/abc", "Death Note Episode 7"), 7);
        check("no number", History.episodeNumber("https://x.com/movie", "A Movie"), 0);
        // Watch on a series: where it was left, the next episode after a finished one, else nothing (the caller starts the first)
        java.util.List<int[]> eps = new java.util.ArrayList<>();
        for (int sn = 1; sn <= 2; sn++) for (int n = 1; n <= 3; n++) eps.add(new int[]{sn, n});
        History.Entry w = new History.Entry();
        w.title = "Show"; w.episode = "S1 E2";
        check("never watched", History.resume(new java.util.ArrayList<>(), "Show", eps), null);
        check("left at S1 E2", java.util.Arrays.toString(History.resume(java.util.Collections.singletonList(w), "show (2020)", eps)), "[1, 2]");
        w.done = true; w.posEpisode = "S1 E2";
        check("finished: the next", java.util.Arrays.toString(History.resume(java.util.Collections.singletonList(w), "Show", eps)), "[1, 3]");
        w.episode = "S1 E3"; w.posEpisode = "S1 E3";
        check("finished the season: the next season", java.util.Arrays.toString(History.resume(java.util.Collections.singletonList(w), "Show", eps)), "[2, 1]");
        w.episode = "S2 E3"; w.posEpisode = "S2 E3";
        check("finished the last: it stays", java.util.Arrays.toString(History.resume(java.util.Collections.singletonList(w), "Show", eps)), "[2, 3]");
        w.episode = "S2 E1"; w.posEpisode = "S1 E3";
        check("done belongs to another episode: this one", java.util.Arrays.toString(History.resume(java.util.Collections.singletonList(w), "Show", eps)), "[2, 1]");
        w.episode = "E2"; w.done = false;
        check("no season on the page: the first season with it", java.util.Arrays.toString(History.resume(java.util.Collections.singletonList(w), "Show", eps)), "[1, 2]");
        w.episode = "S5 E1";
        check("not in the list", History.resume(java.util.Collections.singletonList(w), "Show", eps), null);
        w.title = "Other"; w.episode = "S1 E2";
        check("another title", History.resume(java.util.Collections.singletonList(w), "Show", eps), null);
        System.out.println(fails == 0 ? "all passed" : fails + " failed");
        if (fails > 0) System.exit(1);
    }
}
