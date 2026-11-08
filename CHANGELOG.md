# Changelog

Each `vX.Y.Z` tag publishes the TV and Android APKs; its section below becomes the release notes.

## 1.3.0

- 上流 v2.16.0〜v2.17.1 を取り込みました。主な新機能: TV へのキャスト（FMHYPlay 同士／Chromecast／DLNA）、Stalker ポータル（MAC ログイン）、PunchPlay 視聴トラッキング、IPTV のカテゴリ/言語フィルタとピン留め、音声言語の記憶、ダイアログブーストの修正など
- 日本語化の方式を変更しました。上流が UI 文字列を文字列リソースに移行したのに合わせ、日本語訳も res/values-ja（450件）に移行。端末の言語設定が日本語なら自動で日本語表示になります（従来の日本語訳の文言は引き継いでいます）
- 邦題表示（Wikidata）、ジャンル名・IPTV カテゴリ名・国名・字幕言語名の日本語表示は従来どおり維持しています

## 2.17.1

### 🐞 Fixed
- **Dialog boost** made everything quieter: it now lowers rumble and bass and lifts the level, so voices come out louder. Turning a boost off brings the sound fully back at once.

## 2.17.0

### ✨ New
- **DLNA / UPnP casting**: smart TVs from Samsung, LG, Sony, Kodi and others show up in the Cast list ("Name - DLNA"), through the phone like Chromecast.
- **Fire TV**: install with Downloader code 9828006; the link `releases/latest/download/FMHYPlay-TV.apk` always gets the newest version.
- **Stalker portals**: add your IPTV provider's portal address and MAC address (MAG login) next to Xtream; channels get their own row.
- **PunchPlay**: Settings, PunchPlay connects with a code at punchplay.tv/link; movies and episodes you watch are tracked there, like Simkl.
- **IPTV filters and pins**: channel lists have Category and Language chips (movies, TV, kids and news first; Hindi, English, Tamil for India). The pin button keeps a list with its chips (India · News · Hindi) as its own row on the IPTV tab.

### 🔧 Changed
- **Audio language**: the language you pick on the player's Audio button is where every next video starts, when it has it (then your device's language), instead of the stream's default, often English. The list shows language names, not "stream_4".

## 2.16.1

### 🐞 Fixed
- **Dialog boost** is off by default again: it caused sound problems on some devices. Turn it on in Settings or with its button in the player.
- **TV tabs** show a ring when the remote is on them.

## 2.16.0

### ✨ New
- **Cast to TV**: the Cast button in the player sends the video to a TV on your Wi-Fi, from the same spot. The phone becomes the remote (play/pause, seek, volume keys).
- **FMHYPlay on the TV** (recommended): plays every stream the phone can, even when the app is closed. On the TV: Settings → Cast to this TV → allow once.
- **Chromecast**: Google TV and Cast TVs work without FMHYPlay on the TV. The phone relays the stream, so keep it on the same Wi-Fi.
- **Your language**: Hindi, Spanish, Portuguese, Indonesian, Arabic and German, picked from the device.

### 🔧 Changed
- **Dialog boost** is on by default.
- **Pop-ups**: a link a site opens in a new window now opens in the same tab (Back returns). Ad pop-ups are dropped, and the link you tapped opens anyway (CricHD's Watch works in one tap).
- **Continue watching** shows the catalog poster for titles opened from Movies, TV or Anime, also on sites without their own.

### 🐞 Fixed
- Volume boost and Dialog boost had no effect on many phones and TVs.

## 1.2.0

- ジャンル名が日本語で表示されるようになりました（アクション、コメディ、SF など）。作品ページのジャンル表示、ジャンルのチップと見出しが対象で、Cinemeta への問い合わせに使う英語の値は今まで通り保持します
- IPTV のカテゴリ名が日本語になりました（ニュース、スポーツ、映画 など既知のカテゴリ）。国・地域名も日本語で表示され、国旗アイコンもそのまま表示されます。チャンネル名自体は放送局名なので英語等のままです
- 字幕の言語名が日本語で表示されるようになりました（字幕の言語一覧、設定画面の表示）
- ホーム画面の「その他」サイト見出しなど、残っていた見出しの一部も日本語になりました
- あらすじ・ポスターは今まで通り英語です。日本語データを持つ無料のデータ元がなく、API キーが必要な方式は採用しない方針のためです

## 1.1.0

- 映画・シリーズ・アニメのタイトルが日本語で表示されるようになりました（Wikidata から IMDb ID 経由で邦題を取得、キー不要）。邦題がない作品は英語タイトルのままです
- 日本語化は表示だけです。サイト側の検索や照合には今まで通り英語タイトルを使うので、再生までの動作は変わりません
- 取得した邦題は端末内に保存され、同じ作品を毎回問い合わせることはありません。検索結果の並び替えでも邦題が考慮されます
- あらすじ・ポスター・ジャンル名は今まで通り英語です（データ元に日本語がないため）。IPTV のチャンネル名、サイト名、視聴履歴のタイトル（再生元ページ由来）も英語のままです

## 1.0.0

日本語化版の初回リリース（ベースは上流 v2.15.0）。

- アプリのUI文字列 約490件を日本語化（設定画面、プレイヤー、IPTV、検索、字幕パネル等）。ブランド名、設定キー、照合用文字列、内部ログは動作を壊さないため英語のまま。一部のカテゴリ見出し・ジャンル名は照合キー/API値と兼用のため英語のまま残しています
- アプリ内アップデートの参照先をこのリポジトリのリリースに変更（上流版の更新が混ざらないようにするため）
- 署名キーはこのリポジトリ専用のものを新規発行。上流版とは署名が異なるため、上流版の上書きインストールはできません（先にアンインストールが必要です）

## 2.15.0

### ✨ New
- **New Home**: search across the top, tabs, Continue watching, Favorites, and New + Popular for Movies, TV and Anime.
- **One search** for movies, series, channels and sites.
- **Resume anywhere**: carries on where you stopped, on any site or server. Restart button in the player.
- **Sound**: Volume boost and Dialog boost, with defaults in Settings.
- **Subtitles**: color, background, auto subtitles in your language, remembered picks.
- **What's new** in the update alert, **WARP log** to share, **Address bar** on sites, **cursor looks** on TV.

### 🔧 Changed
- Phone player follows the rotation lock and has a Full screen button.
- IPTV Working row shows channels; favorites use a heart.

## 2.14.3

- Search results fill the page as a poster grid.

## 2.14.2

- Faster search, with a spinner; accents don't matter.

## 2.14.1

- Fixed: Check channels showed "0 offline" after a playlist change.

## 2.14.0

### ✨ New
- **Simkl**: marks movies and episodes watched.
- **Xtream Codes** login for IPTV; playlists get names and their own rows.
- **Update check** on start, with Install on Home.
- **Subtitles panel**: size, position and timing.

### 🔧 Changed
- Fewer permissions; WARP helper rebuilt so antivirus apps stop flagging it.

## 2.13.0

- Episodes are picked on the site; the native player follows by itself.
