package me.champdev.weblock;

import java.util.HashMap;
import java.util.Map;

/**
 * Japanese labels for fixed English vocabularies that double as data:
 * catalog genres (Cinemeta query values) and IPTV group names (playlist
 * group-title values and Xtream category names). Display only — callers
 * keep using the English value for queries, keys, matching and storage,
 * exactly like JaTitles keeps Title.name in English.
 */
final class JaLabels {
    private JaLabels() {}

    private static final Map<String, String> GENRES = new HashMap<>();
    static {
        String[] g = {
            "Action", "アクション", "Adventure", "アドベンチャー", "Animation", "アニメーション",
            "Biography", "伝記", "Comedy", "コメディ", "Crime", "クライム", "Documentary", "ドキュメンタリー",
            "Drama", "ドラマ", "Family", "ファミリー", "Fantasy", "ファンタジー", "History", "歴史",
            "Horror", "ホラー", "Kids", "キッズ", "Music", "音楽", "Mystery", "ミステリー",
            "News", "ニュース", "Reality", "リアリティ", "Romance", "ロマンス", "Sci-Fi", "SF",
            "Soap", "ソープオペラ", "Sport", "スポーツ", "Talk", "トーク", "Thriller", "スリラー",
            "War", "戦争", "Western", "西部劇",
        };
        for (int i = 0; i < g.length; i += 2) GENRES.put(g[i], g[i + 1]);
    }

    /** One genre name for display; unknown values pass through unchanged. */
    static String genre(String en) {
        String ja = GENRES.get(en);
        return ja == null ? en : ja;
    }

    /** A Title.genres string ("Action · Drama") with each part translated. */
    static String genres(String joined) {
        if (joined == null || joined.isEmpty()) return joined;
        String[] parts = joined.split(" · ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) sb.append(" · ");
            sb.append(genre(parts[i]));
        }
        return sb.toString();
    }

    private static final Map<String, String> IPTV_CATS = new HashMap<>();
    static {
        String[] c = {
            "General", "総合", "Other", "その他", "News", "ニュース", "Entertainment", "エンタメ",
            "Religious", "宗教", "Music", "音楽", "Movies", "映画", "Series", "シリーズ",
            "Sports", "スポーツ", "Kids", "キッズ", "Documentary", "ドキュメンタリー", "Legislative", "議会",
            "Education", "教育", "Comedy", "コメディ", "Culture", "文化", "Lifestyle", "ライフスタイル",
            "Shop", "ショッピング", "Shopping", "ショッピング", "Business", "ビジネス", "Animation", "アニメ",
            "Outdoor", "アウトドア", "Classic", "クラシック", "Travel", "旅行", "Family", "ファミリー",
            "Cooking", "料理", "Auto", "自動車", "Weather", "天気", "Science", "科学",
            "Public", "公共", "Mature", "成人向け", "Relax", "リラックス", "Interactive", "インタラクティブ",
            "Live", "ライブ", "Undefined", "その他",
            Iptv.MINE, "マイプレイリスト", Iptv.STREAMS, "マイストリーム",
        };
        for (int i = 0; i < c.length; i += 2) IPTV_CATS.put(c[i], c[i + 1]);
    }

    /** One IPTV category/group name for display; unknown values pass through unchanged. */
    static String iptvCategory(String en) {
        String ja = IPTV_CATS.get(en);
        return ja == null ? en : ja;
    }
}
