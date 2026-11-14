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
7. `src/me/champdev/weblock/JaLabels.java` と表示ロケール変更（v1.2.0〜）: 固定語彙（カタログのジャンル名、IPTV のカテゴリ名）は対応表で表示だけ日本語化する（JaLabels.genre / genres / iptvCategory）。問い合わせ値・グループキー等の英語データは変更しない。あわせて `Iptv.country()` の国名生成と `Subs.language()` の言語名生成を Locale.JAPANESE に変更（`Iptv.flag()` の照合キーも country() の返す名前に統一）。TMDB 等の API キーが必要なデータ元は使わない（2026-11-07 本人の方針決定）。上流マージでこれらが消えたら復元する。
8. `8. `res/values-ja/`（v1.3.0〜、2026-11-08 に本人の承認を得た方式変更）: 上流 v2.16.0 が UI 文字列を文字列リソース化したのに合わせ、日本語化の主方式を Java 直訳から values-ja への翻訳追加に移行した。英語リソース（strings_home / strings_player / strings_screens / strings_punchplay / strings_stalker、計450件）と name・書式指定子を一致させること。上流が新しい文字列を足したら values-ja にも訳を足す。Java 側の翻訳差分は 6 / 7 の表示専用の仕組みだけに縮小した。
9. 上流の改称と履歴再作成への追随（v1.7.0、2026-11-14 に本人の承認）: 上流は v2.21.0 で FMHYPlay から AnantPlay へ改称し、git 履歴を新規ルートから作り直した（旧履歴との共通祖先なし）。当リポジトリは旧 main をブランチ `archive/fmhyplay-line` に保全したうえで、新しい上流履歴を土台に main を作り直し、差分 1〜8 を再適用した。以後の同期は再び通常のマージでよい。アプリ名・APK名は上流どおり AnantPlay に追随する。当リポジトリ名（Ayufa/fmhyplay-android-jp）と更新確認先は変更しない（既存インストールの更新経路を維持するため）。

## 同期手順

1. `git fetch upstream`
2. `git merge upstream/main`（競合は翻訳済み行でのみ解決する。それ以外で競合したら作業を止めて確認する）
3. 新規・変更された表示文字列を docs/LOCALIZATION.md の方針で翻訳
4. CI（Build ワークフロー）が通ることを確認
5. リリースする場合のみ、独自バージョンのタグ（vX.Y.Z）を打ち、CHANGELOG.md に同バージョンのセクションを用意する

## 停止条件

- 上流が公式に日本語対応したら、定期取り込みを止めて検討する。
