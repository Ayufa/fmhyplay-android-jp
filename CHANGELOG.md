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

## 2.19.0

### ✨ New
- **New look on every screen**: darker, calmer colours; on a TV a rail down the left side with Search, the tabs, WARP and Settings, one Left press from any row (OK on a tab puts the focus on its first card); on a phone a top bar with Search, voice, WARP and Settings, and six tabs at the bottom; posters with their name and year underneath instead of on the picture; a white focus ring with a slight grow on a TV; app-coloured pop-ups.
- **A big picture on top of Home**: one of the first row's titles, a different one each day. Press play to open it.
- **Your country first**: Home starts with Movies and TV rows from your country (India: Hindi, Tamil, Telugu, Malayalam, Kannada taken in turns), and the Movies and TV tabs open on your first language, with a chip per language. The country is found from the mobile network or the time zone; change it or switch it off in Settings, Your country. Lists come from TMDB through the public Stremio TMDB addon.
- **Title pages** have the title's wide picture behind the top.
- **More on one screen**: smaller margins, a slim line of sites on the Movies, TV and Anime tabs, smaller Continue watching cards on a TV.
- **Phone title page** for a movie: the sites to watch on are a two-across grid instead of a sideways row. Cast, director and country sit beside the poster.
- **Trailer** button on title pages (YouTube).
- **Settings in sections** that open and close (Connection, Your data, IPTV, Player, Updates, Sites), each one card with an icon, so the tab starts as a short list.
- **Donate and About** in Settings: ways to support the app, the website, source code and where to report a problem. Links open in the device's browser.
- **Clear website data** (Settings, Your data): cookies, logins, cache and saved data of every site.
- **Turning WARP off asks first**, so a stray press does not show sites your real address.
- The app's name is on the TV rail and the phone's top bar.
- **Smaller tiles on a TV**: eight posters across in grids, more in every row.
- **Pull down to refresh** on a phone: reloads the open tab (catalog lists, sites on Sports, channels on IPTV).
- **IPTV tab redone**: what you watched and your favorites first, then your playlists and pins, then your country's channels with its own categories (India: News, Movies, Kids...), then all countries and all categories as compact cards. Channel logos sit on one quiet tone.
- **Navigation on every screen**: title pages, search and lists keep the tabs (bottom bar on a phone, rail on a TV); pressing one goes Home on that tab.
- **Player menus are a side panel** (along the bottom on an upright phone) instead of pop-ups in the middle of the picture: name on the left, its value on the right, a tick on the one in use.
- **Player buttons in two groups**: Previous, Next and Episodes/Channels on the left; quality, audio, subtitles, More, Cast and Full screen on the right. Focus is the white ring.
- **Live channels in the player**: Previous / Next and the remote's Channel + / − move through the channel's category in its country, and Channels (or Down from the buttons) opens a strip of those channels along the bottom while the video keeps playing; the buttons move up and stay on screen.
- **Episodes and More to watch use the same strip**: a series' episodes with their pictures, and for a movie other movies (picking one opens its page).
- **Watch on a series starts episode one** with the loading screen, instead of only opening the show's page.
- Rows show grey placeholders while they load, so the page does not jump.

### 🔧 Changed
- **Search waits until you pause typing** (about half a second) before it searches and redraws. Pressing Search on the keyboard searches at once.
- The ad block switch is in Settings only; WARP's state is one icon (green on, amber connecting, red failed, grey off).
- **Pictures load faster and stay loaded**: their own download threads, one download per picture however many cards show it, decoded at the card's size, and a memory cache sized to the device (it held about 17 posters before, so scrolling back loaded them again). A missing picture is not asked for again for ten minutes. The picture folder is capped at 200 MB.
- **Tabs switch without the lag**: the pressed tab lights up at once, site lists and catalog pages are parsed once instead of on every switch, and the rows below the first screen are added a frame later.
- **Less memory**: pictures are fetched and decoded only when their card comes near the screen, at the size they are shown, and photos take half the memory; the web engine loads when a site is opened instead of at app start; the player's strips size their pictures to the cards.
- **TV remote keeps its place**: Up and Down stay inside the page (they no longer jump into the side rail at the end of a page), and coming back from a video or a title puts the focus on the card you left from, not on Search.

### 🐞 Fixed
- **Crash on pages with a long number after "episode"** in the address or title (ten digits or more): saving it to Continue watching overflowed. Such a number is now treated as an id, not an episode.
- **A series with thousands of episodes in one season** (daily soaps) could close the app: every episode got a row and a picture at once. Episodes now come 50 at a time, with Load more.
- Posters and pictures nobody opened for 60 days are removed from storage (they used to pile up forever).
- A download that broke half way no longer leaves its connection open.
