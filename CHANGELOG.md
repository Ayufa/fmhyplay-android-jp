# Changelog

Only the current version is kept here: each `vX.Y.Z` tag publishes the TV and Android APKs, and this section becomes the release notes.

## 1.8.0

- 上流 v2.22.0 を取り込み。**プラットフォーム**（Netflix、Prime Video、Disney+、HBO Max、Apple TV+、Paramount+、Crunchyroll 等の配信サービス）を行としてホーム／映画／TVに追加し、サービスごとのページと、Disney+ 内のブランド（Disney、Pixar、Marvel、Star Wars、National Geographic）ごとのページを表示。Marvel はチップで作品群を絞り込み可能。
- **スタジオ**（DreamWorks、Illumination、Paramount、Universal、Warner Bros.、Sony Pictures、20th Century、Lionsgate、A24、Studio Ghibli）と**キッズ**のセクションをホームに追加。各行の末尾の「その他」から、その行の全作品をグリッドで表示。
- **検索履歴**: 最近の検索が検索ボックスの下に表示されるように。設定＞あなたのデータから消去可能。プレイヤー設定に**最高画質**（自動画質の上限）と**音声言語**を追加し、自動画質は端末で滑らかに再生できる範囲までに制限。
- その他の変更: ポスターを拡大（TVで横6列）、画面やタブに戻ったときの表示位置を保持、読み込み画面をスピナーに変更（猫GIFを廃止）、小さいTVでのストリームバッファ削減、検索ボックス左へのマイク移動。自動再生されるミュート状態の予告編が止まったままになる等の修正も含む。
- 日本語化: 新規文字列19件を翻訳し、文字列リソース全590件に追随。邦題表示（Wikidata）・ジャンル名等の日本語化も従来どおり維持。

## 1.7.0（日本語化版）

- 上流 v2.21.0 を取り込み。**アプリ名が FMHYPlay から AnantPlay に変わりました**（同じアプリとして上書き更新できます。パッケージ名と当リポジトリの署名は従来どおり）。
- 上流の新機能「ソース」に対応: サイト／チャンネル／タイトルリンクは本体同梱ではなくなり、設定の「ソース」からインデックスを追加して取り込む方式になりました。旧版からの更新時は、使っていたソースが自動で追加されます。
- 日本語化: 文字列リソース571件に追随（新規「ソース」画面の33件を翻訳、改称に伴う21件を変更、削除された13件を除去）。邦題表示（Wikidata）・ジャンル名等の日本語化も従来どおり維持。
- 上流が git 履歴を作り直したため、当リポジトリも新しい上流履歴を土台に再構築しました（旧履歴はブランチ archive/fmhyplay-line に保全）。

## 2.22.0

### ✨ New
- **Platforms.** A row of streaming services on Home, Movies and TV (Netflix, Prime Video, Disney+, HBO Max, Apple TV+, Paramount+, Crunchyroll, and your country's own). A service's page shows what is on it as rows: Popular, Top rated, New, and one row per genre.
- **Brands inside Disney+**: Disney, Pixar, Marvel, Star Wars and National Geographic, each with its own rows (Marvel: MCU, The Infinity Saga, The Multiverse Saga, Avengers, Spider-Man, X-Men, Guardians of the Galaxy, Animation, Documentaries...).
- **Studios** on Home: DreamWorks, Illumination, Paramount, Universal, Warner Bros., Sony Pictures, 20th Century, Lionsgate, A24 and Studio Ghibli.
- **Kids** on Home: the brands children know (Disney, Pixar, DreamWorks, Illumination, Nickelodeon, Cartoon Network), then family movies and series.
- **More** at the end of every row of titles opens the whole list as a grid, in the same order.
- **Search history**: your recent searches drop down under the search box; *Settings, Your data, Clear search history* removes them.
- **Highest quality** and **Audio language** in *Settings, Player*. Auto quality stops at what the device plays smoothly (its screen, memory and heap), and videos start in your language when the stream or the site has it.

### 🔧 Changed
- Posters are bigger everywhere (6 across on a TV instead of 8).
- Coming back to a screen or a tab returns to where you were, with the remote and by touch.
- The player keeps less of the stream in memory on small TVs: a 1 GB TV no longer fills its memory and skips frames.
- The loading screen shows a spinner instead of cat GIFs.
- The mic sits left of the search box.

### 🐛 Fixed
- Sites that start a muted trailer by themselves: it stays stopped, so the page stays quick and its Play button stays visible.
- Back from the player no longer starts the site's own player and opens the video again.
- The Quality list no longer fills with the site's servers when a server offers one quality.
- Audio languages and servers that a site builds late now reach the player's lists.
- The remote no longer jumps to another row at the end of a row.
