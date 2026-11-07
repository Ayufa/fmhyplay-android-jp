# 上流（upstream）との関係と運用ルール

## 対象

- 上流: https://github.com/fmhyplay/android （FMHYPlay、MIT）
- 初回取り込み時点の上流バージョン: v2.15.0（コミット 3b0fe52）

## 絶対ルール

- 上流には一切干渉しない。PR / merge / Issue / コメント等は禁止。
- 取り込みは fetch のみの一方向（upstream → このリポジトリ）。upstream remote の push URL は `DISABLED-NO-PUSH-TO-UPSTREAM` に設定し、誤 push を構造的に防ぐ。
- 方式は「クローン＋翻訳のみ」。機能・動作は上流そのまま。独自機能は足さない。

## 上流から意図的に変えている点（翻訳以外）

1. `src/me/champdev/weblock/Update.java` の更新確認先 API を、このリポジトリ（Ayufa/fmhyplay-android-jp）のリリースに変更。上流のままでは英語版の更新が通知され、署名違いでインストールも失敗するため。
2. `build.sh` のデフォルトバージョンを独自採番（1.0.0 / versionCode 10000）に変更。リリース時のバージョンはタグから決まる（上流の release ワークフローと同じ仕組み）。
3. 署名キーはこのリポジトリ専用のものを新規発行（GitHub Secrets の KEYSTORE_B64 / KEYSTORE_PASS）。上流版とは署名が異なる。
4. README は日本語版を正とし、上流の英語 README は README.en.md として保持。
5. CHANGELOG.md の先頭に、このリポジトリのリリース分のセクションを追加していく（上流のセクションはそのまま保持）。
6. `src/me/champdev/weblock/JaTitles.java`（v1.1.0〜、2026-11-07 に本人の承認を得た例外）: 作品タイトルを Wikidata から IMDb ID 経由で取得し、日本語の邦題を「表示専用」に使う。Title.name（英語）は照合・サイト検索・保存データ用に一切変更しない。表示箇所は Title.displayName() を使う。上流マージで JaTitles.java と Catalog.java / Home.java / TitleActivity.java / SearchActivity.java の displayName 呼び出しが消えたら復元する。

## 同期手順

1. `git fetch upstream`
2. `git merge upstream/main`（競合は翻訳済み行でのみ解決する。それ以外で競合したら作業を止めて確認する）
3. 新規・変更された表示文字列を docs/LOCALIZATION.md の方針で翻訳
4. CI（Build ワークフロー）が通ることを確認
5. リリースする場合のみ、独自バージョンのタグ（vX.Y.Z）を打ち、CHANGELOG.md に同バージョンのセクションを用意する

## 停止条件

- 上流が公式に日本語対応したら、定期取り込みを止めて検討する。
