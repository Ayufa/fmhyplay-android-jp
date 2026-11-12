# Changelog

Each `vX.Y.Z` tag publishes the TV and Android APKs; its section below becomes the release notes.

## 1.5.0

- 上流 v2.19.0 を取り込みました。主な新機能: 全画面のデザイン刷新（TVは左側のサイドレール、スマホは上部バーと下部タブ）、ホーム上部の大きなヘッダー画像、「あなたの国」の映画・シリーズをホームの先頭に表示（TMDBの公開Stremioアドオン経由でキー不要、国は設定で変更・無効化できます）、タイトルページの背景画像と予告編ボタン、設定のセクション化と「寄付」「このアプリについて」の追加、ウェブサイトデータの消去、WARPをオフにする際の確認、IPTVタブの刷新（自国のカテゴリを先頭に）、プレイヤーのサイドパネルメニューとライブチャンネルの切替ストリップ、スマホでの引っぱり更新。変更: 画像キャッシュの刷新とメモリ使用量の削減、タブ切替の高速化、検索の入力待ち（デバウンス）。修正: 「episode」の後に長い数字があるページでのクラッシュ、エピソード数が数千あるシーズンでのメモリ不足（50件ずつの読み込みに変更）など
- 新規の文字列17件（あなたの国、寄付、このアプリについて、予告編、チャンネルなど）を翻訳しました。文字列リソースは英語版と同数の506件です
- 邦題表示（Wikidata）、ジャンル名・IPTVカテゴリ名・国名・字幕言語名の日本語表示は従来どおり維持しています。新デザインのポスターカードやホームのヘッダーなど、上流の新しい表示箇所にも邦題・ジャンル名の日本語表示を適用しました

## 1.4.1

- 上流 v2.18.5〜v2.18.6 を取り込みました。主な新機能: プレイヤーとWebサイトから1ステップでホームへ戻るボタン（戻るボタンの3秒長押しでも可）、サイト操作中に表示される読み込み画面（タイトル・現在のステップ・猫のアニメーション付き）、プレイヤーのデバッグオーバーレイ（解像度・フレームレート・コーデック・ビットレート等を右端に表示、その他メニューから有効化）。変更: アップデート確認が1時間ごとと起動ごとに（従来は12時間ごと）、字幕のデフォルト位置が下から20dpに、字幕ボタンにCC表示。修正: エピソード開始の遅延、再開時に字幕が消える問題、「続きから見る」の位置が失われる問題、次エピソード操作後に読み込み画面が残る問題など
- 新規の文字列10件（ホームへ移動、デバッグオーバーレイ、読み込み画面のステップ表示など）を翻訳し、文言変更2件（アップデートの自動確認）にも追随しました。文字列リソースは英語版と同数の489件です
- 邦題表示（Wikidata）、ジャンル名・IPTVカテゴリ名・国名・字幕言語名の日本語表示は従来どおり維持しています

## 1.4.0

- 上流 v2.18.0〜v2.18.4 を取り込みました。主な新機能: プレイヤー内のエピソード一覧と前／次のエピソード移動、イントロ・リキャップ・クレジットのスキップ（TheIntroDB／AniSkip、設定で自動スキップも可能）、アニメの字幕／吹替（Sub / Dub）切替、スマホでのピクチャインピクチャと長押し2倍速、字幕の全言語対応・自動同期、タイトルページの詳細情報（キャスト・監督・シーズン／エピソード数など）、WARP DNS の設定、プレイヤー名の FMHYPlayer への変更など
- 新規の文字列31件（スキップ、エピソード操作、タイトル詳細、WARP DNS設定など）を翻訳し、名称変更1件と文言変更にも追随しました。文字列リソースは英語版と同数の479件です
- 邦題表示（Wikidata）、ジャンル名・IPTVカテゴリ名・国名・字幕言語名の日本語表示は従来どおり維持しています

## 1.3.0

- 上流 v2.16.0〜v2.17.1 を取り込みました。主な新機能: TV へのキャスト（FMHYPlay 同士／Chromecast／DLNA）、Stalker ポータル（MAC ログイン）、PunchPlay 視聴トラッキング、IPTV のカテゴリ/言語フィルタとピン留め、音声言語の記憶、ダイアログブーストの修正など
- 日本語化の方式を変更しました。上流が UI 文字列を文字列リソースに移行したのに合わせ、日本語訳も res/values-ja（450件）に移行。端末の言語設定が日本語なら自動で日本語表示になります（従来の日本語訳の文言は引き継いでいます）
- 邦題表示（Wikidata）、ジャンル名・IPTV カテゴリ名・国名・字幕言語名の日本語表示は従来どおり維持しています

## 2.19.1

### ✨ New
- **United Kingdom, United States, Canada, Australia, New Zealand and Ireland** are in Settings, Your country (their rows are English-language titles).

### 🐞 Fixed
- **Servers and Sub / Dub dropdowns were skipped** on sites whose choices are plain words (Sub, Dub, Vidstream): a faulty check took them for numbers, so the player's Servers and Sub / Dub buttons had nothing to show there.
- **A stream whose address carries the page's address** (`master.m3u8?ref=https://site…`) was not recognised, so it never went to the player.
- **A show with "master" in its name** (MasterChef, Masters of the Air) could open in the wrong quality: every quality playlist under that folder was taken for the main one.
- **Titles not written in Latin letters** (Hindi, Korean, Japanese): opening one on a site without a direct link pressed a random link instead of searching for it.
- **A page could go blank** in its first half minute: a pop-up closer mistook the whole page for a pop-up on sites that mark the page while one is open.
- **WARP would not connect on a fresh install or after clearing data** ("Cloudflare is limiting new WARP sign-ups", HTTP 429), on mobile data and on Wi-Fi: since 2.18.0 the sign-up went out in a form Cloudflare refuses. It uses HTTP/2 again, and one connection at a time instead of one per address at once.
