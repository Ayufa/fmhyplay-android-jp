# Changelog

Only the current version is kept here: each `vX.Y.Z` tag publishes the TV and Android APKs, and this section becomes the release notes.

## 1.7.0（日本語化版）

- 上流 v2.21.0 を取り込み。**アプリ名が FMHYPlay から AnantPlay に変わりました**（同じアプリとして上書き更新できます。パッケージ名と当リポジトリの署名は従来どおり）。
- 上流の新機能「ソース」に対応: サイト／チャンネル／タイトルリンクは本体同梱ではなくなり、設定の「ソース」からインデックスを追加して取り込む方式になりました。旧版からの更新時は、使っていたソースが自動で追加されます。
- 日本語化: 文字列リソース571件に追随（新規「ソース」画面の33件を翻訳、改称に伴う21件を変更、削除された13件を除去）。邦題表示（Wikidata）・ジャンル名等の日本語化も従来どおり維持。
- 上流が git 履歴を作り直したため、当リポジトリも新しい上流履歴を土台に再構築しました（旧履歴はブランチ archive/fmhyplay-line に保全）。

## 2.21.0

### ✨ New
- **FMHYPlay is now AnantPlay.** Same app, same settings, favorites, history and downloads; it installs over FMHYPlay as an update.
- **Sources.** The app now comes with no sites, channels or title links of its own. *Settings, Sources* lists the AnantPlay index; add it, then add the sources you want from it, each with its own button: streaming sites, channel playlists, title links. *Add an index by link* takes anyone's list (an `index.json`, or an older `sources.txt`).
- **Updating from FMHYPlay** adds the index and the sources you had for you, once, and says so in a short message.
- With nothing added, the Movies, TV, Sports, Anime and IPTV tabs show an **Add sources** button.

### 🔧 Changed
- *Settings, Extra source list* is replaced by *Settings, Sources*; *Refresh FMHY lists* is now *Refresh sources*.
- New downloads go to `Download/AnantPlay` unless you picked a folder before.
- Casting finds TVs on both FMHYPlay and AnantPlay while everyone updates.
