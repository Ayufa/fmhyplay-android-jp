# Changelog

Only the current version is kept here: each `vX.Y.Z` tag publishes the TV and Android APKs, and this section becomes the release notes.

## 1.9.1

- 上流 v2.23.1 を取り込み。**タイトルページがすぐ開くように戻りました**（v2.23.0 では開くのに数秒かかり、一部のTVではアプリが終了していました）。リストで表示していたポスターがページにも即座に表示されます。
- **IPTV**: 再生に失敗したチャンネルがリストから消えなくなりました（隠すのはバックグラウンド確認だけに）。IPTVタブの「オフラインを表示」から、オフラインとして隠されたチャンネルを1つずつ、またはすべて戻せます（戻したチャンネルは以後隠されません）。
- **プレイヤー設定に「スワイプで明るさ・音量」を追加**（スマートフォンのみ、初期はオン）。画面左側の上下スワイプで明るさ、右側で音量を変える操作をオフにできます。その他、スマートフォンで上部バーの下に余白を追加。
- 日本語化: 新規文字列7件を翻訳し、文字列リソース全601件に追随。邦題表示（Wikidata）・ジャンル名等の日本語化も従来どおり維持。

## 1.9.0

- 上流 v2.23.0 を取り込み。**ダウンロードを大幅強化**: DASH ストリームのダウンロードに対応し、HLS も含めダウンロードはシーク可能な MP4 として保存されるように（.ts の断片は完了時に変換。旧 .ts ダウンロードにはダウンロード画面に「シーク可能にする」ボタンを追加）。音声のないストリーム等、保存できない場合はダウンロードを押した時点で理由を表示。DASH の音声は設定した音声言語の主トラックを選択（音声解説・コメンタリーは選ばない）。
- **映画／TV の言語行**: 言語チップを開くと「新着」「人気」の行が先に表示されるように（毎日更新）。プラットフォーム／ブランドページでは「トレンド」が「新着」に置き換え。
- **ズーム変更**: Fit／切り抜き（Crop）／引き伸ばしの3種に整理（16:9 と 4:3 は廃止）。切り抜きは映像内の黒帯も除去。**シリーズの続き再生**: サイトをタップしても再生せず選択だけになり、「視聴」で前回の続き（見終わった回の次）から再生（#22）。TV の検索は Enter を押したときに実行されるように。
- その他の修正: システムアニメーションがオフのTVで読み込みスピナーが回らない、ダウンロードした映画にシークバーが無い／LIVE表示になる（#23）、映像と音声の結合失敗時に理由が出ない、等の修正。ダウンロード時の一時空き容量が半分で済むようにもなった。
- 日本語化: 新規文字列8件を翻訳、削除された4件を除去、ズームの「画面いっぱい（Fill）」を「切り抜き（Crop）」に変更し、文字列リソース全594件に追随。邦題表示（Wikidata）・ジャンル名等の日本語化も従来どおり維持。

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

## 2.23.1

### 🐛 Fixed
- **A movie or series page opens at once again.** In 2.23.0 it took seconds to open, and on some TVs the app closed. The poster from the list now shows on the page right away.
- An IPTV channel that fails to play is no longer hidden; only the background check hides channels.
- On a phone, the Home banner picture no longer spills over the row under it.

### ✨ New
- **Show offline** on the IPTV tab lists the channels hidden as offline: bring one back, or all of them, and they stay.
- *Settings, Player, Swipe for brightness and volume* turns those player swipes off (phones).
- A little space under the phone's top bar.
