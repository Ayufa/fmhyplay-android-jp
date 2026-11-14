# 翻訳方針

## 前提

v1.3.0 から方式を変更した。上流 v2.16.0 が UI 文字列を Android 文字列リソース（res/values/strings_*.xml、英語450件）へ移行したため、日本語化は「res/values-ja/ に同じ name で日本語訳を置く」方式が正になった。端末の言語が日本語のとき自動で適用される。
Java ソース内の直書き文字列は原則として翻訳しない（上流がリソース化し残したものは照合用・データ由来がほとんど）。例外は docs/UPSTREAM.md に記録した表示専用の仕組み（JaTitles / JaLabels / Iptv.country と Subs.language の日本語ロケール）だけ。
（v1.2.0 までは文字列リソースが無く、Java 直書きを直接置換する方式だった。）

## 翻訳するもの

- 画面に表示されるラベル、ボタン、メニュー項目、設定項目名とその説明
- ダイアログのタイトル・本文・ボタン
- トースト、スナックバー等のユーザー向け通知文
- 入力欄のヒント（hint）、contentDescription
- 更新確認・ダウンロード等の状態表示文

## 翻訳しないもの（英語のまま）

- ブランド名・固有名詞: FMHYPlay、FMHY、ExoPlayer、Cloudflare WARP、OpenSubtitles、Simkl、Cinemeta、Kitsu、IPTV 等
- SharedPreferences のキー名、JSON のキー名、Intent の action 文字列
- コード内で照合に使われる文字列（equals / switch / contains 等で比較されるもの）
- WebView に注入する JavaScript コード内の文字列
- assets/roles.js、assets/frame.js、assets/spatnav.js 内の文字列（サイト側のボタンテキスト等を照合するためのもの）
- URL、ホスト名、正規表現
- ログ出力、例外メッセージ等の内部文字列（ユーザー向けに表示される失敗通知は翻訳する）
- サイト名・チャンネル名等のデータそのもの

## データのタイトル（UI文字列とは別）

- 作品タイトルはデータ元の都合で英語で届くため、JaTitles.java が Wikidata（キー不要）から邦題を取得して表示にだけ使う。元の英語名は照合・検索用に保持する（Title.displayName() が表示名）。
- ジャンル名・IPTV カテゴリ名のような固定語彙は、JaLabels.java の対応表で表示だけ日本語化する（値は英語のまま保持）。国名・字幕の言語名は Locale.JAPANESE で生成する。
- あらすじ・ポスター等のデータは日本語ソースが無いため英語のまま。API キーが必要なデータ元（TMDB 等）は使わない方針（2026-11-07 決定）。

## 書式の注意

- `%s` `%d` 等の書式指定子、`%` の数と順序を変えない
- `\n` 等のエスケープ、文字列連結の構造を変えない
- 文字列の前後の空白がレイアウトで意味を持つ場合は保持する
- 単位や記号（dB、% 等）はそのまま使う
