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

## 2.23.0

### ✨ New
- **New and Popular in every language.** On Movies and TV, each language chip (Hindi, Tamil, Telugu...) opens on a **New** row (every release of the last year, newest first) and a **Popular** row, then the whole list. Refreshed every day.
- **DASH downloads**, and HLS streams that keep all their pieces in one file.
- **Downloads are MP4 files you can seek in**: streams made of `.ts` pieces are converted when they finish. Old `.ts` downloads get a **Make seekable** button on the Downloads screen.
- **Search on a TV runs when you press Enter**, so the page stays still while you type with the remote; the remote then lands on the first result.

### 🔧 Changed
- **Zoom is Fit, Crop and Stretch.** Crop fills the screen without squashing the picture and also removes black bars that are part of the video; Stretch fills it by stretching. 16:9 and 4:3 are gone.
- On a series, pressing a site only picks it; **Watch carries on where you stopped** (the next episode after one you finished) instead of starting at episode 1 (#22). On a movie, pressing a site still plays it.
- In the player on a TV, picking a quality, server, audio or speed takes you back to the video instead of the buttons.
- New replaces Trending on platform and brand pages.
- A stream that cannot be saved (no sound, live, protected) says why as soon as you press Download.
- DASH downloads take the sound in your audio language, never an audio description.

### 🐛 Fixed
- The loading spinner turns on TVs with animations switched off; it stood still and looked frozen.
- Downloaded movies with no seek bar or a LIVE label (#23).
- Picture and sound of some downloads failed to join with no reason given.
- Crop looked like Stretch on some TVs.
- Downloads no longer need twice the free space, and a big on-demand download no longer runs out of memory on small TVs.
- Movies and TV no longer open with the remote on the second row.
- On a phone, the Home banner picture no longer spills over the row under it.
