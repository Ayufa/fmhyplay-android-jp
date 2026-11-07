# 翻訳方針

## 前提

このアプリには文字列リソース（res/values/strings.xml）が無く、UI文字列は Java ソース内に直書きされている。
そのため翻訳は「ソース内の表示文字列を直接日本語に置換」する方式（Equicord JA と同じ）。

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
- あらすじ・ジャンル名・ポスター等のデータは日本語ソースが無いため英語のまま。

## 書式の注意

- `%s` `%d` 等の書式指定子、`%` の数と順序を変えない
- `\n` 等のエスケープ、文字列連結の構造を変えない
- 文字列の前後の空白がレイアウトで意味を持つ場合は保持する
- 単位や記号（dB、% 等）はそのまま使う
