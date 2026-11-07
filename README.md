<p align="center">
  <img src="docs/banner.png" alt="FMHYPlay" width="560">
</p>

<p align="center">
  <b>FMHYPlay 日本語化版</b><br>
  FMHYPlay（任意のストリーミングサイトを開き、動画をネイティブプレイヤーで再生するTV向けAndroidアプリ）の、非公式の日本語化コピーです。
</p>

<p align="center">
  <a href="https://github.com/Ayufa/fmhyplay-android-jp/releases/latest"><img alt="Release" src="https://img.shields.io/github/v/release/Ayufa/fmhyplay-android-jp?color=ff3b5c"></a>
  <a href="https://github.com/Ayufa/fmhyplay-android-jp/actions/workflows/build.yml"><img alt="Build" src="https://img.shields.io/github/actions/workflow/status/Ayufa/fmhyplay-android-jp/build.yml?branch=main"></a>
  <img alt="Android 8.0+" src="https://img.shields.io/badge/Android-8.0%2B-3ddc84">
  <img alt="License" src="https://img.shields.io/badge/license-MIT-blue">
</p>

<p align="center">
  <a href="https://github.com/Ayufa/fmhyplay-android-jp/releases/latest">ダウンロード</a> ·
  <a href="README.en.md">English README (上流の原文)</a> ·
  <a href="https://github.com/fmhyplay/android">上流リポジトリ</a>
</p>

## このリポジトリについて

- 上流 [fmhyplay/android](https://github.com/fmhyplay/android) の**クローン＋翻訳のみ**のコピーです。機能・動作は上流そのままで、独自機能は追加していません。
- 上流とは独立したリポジトリで、上流への干渉（PR・Issue等）は一切行いません。取り込みは取得（fetch）のみの一方向です。運用ルールは [docs/UPSTREAM.md](docs/UPSTREAM.md)、翻訳方針は [docs/LOCALIZATION.md](docs/LOCALIZATION.md) にまとめています。
- 翻訳しているのは画面に表示されるUI文字列と説明文です。ブランド名（FMHYPlay、ExoPlayer、Cloudflare WARP 等）、設定キー、サイト側ボタンの照合用文字列、内部ログ等は動作を壊さないため英語のまま残しています。
- 作品タイトルは Wikidata から邦題を取得して日本語表示します（v1.1.0〜。表示のみで、サイト検索等は英語タイトルのまま動作します）
- バージョンはこのリポジトリ独自の番号（v1.0.0〜）で、上流のバージョン番号とは対応しません。初回リリース v1.0.0 のベースは上流 v2.15.0 です。
- アプリ内アップデートはこのリポジトリのリリースを参照します。

## インストール

[Releases](https://github.com/Ayufa/fmhyplay-android-jp/releases/latest) から端末に合うAPKをダウンロードしてください。

| ファイル | 用途 |
| --- | --- |
| `FMHYPlay-TV-vX.Y.Z.apk` | Android TV、Google TV、Fire TV、TVボックス（TVランチャー項目付き） |
| `FMHYPlay-Android-vX.Y.Z.apk` | スマートフォン、タブレット |

- Android 8.0（API 26）以上が必要です。
- **上流版とは署名が異なるため、上流版の上書きインストールはできません。** 上流版を使っている場合は、先にアンインストールしてからインストールしてください（設定等のデータは引き継がれません）。
- このリポジトリのリリース同士は同じ署名なので、上書き更新できます。

## 上流の機能概要

- WebViewで開いたページの動画ストリーム（HLS / DASH）を検出し、ExoPlayer（ハードウェアデコーダ）でネイティブ再生
- サイト側プレイヤーのサーバー切替・画質ボタンをプレイヤー側から操作
- 広告・ポップアップ・トラッカーブロック
- アプリ内 Cloudflare WARP（アプリの通信のみを通すユーザースペース WireGuard、VPN権限・root不要）
- FMHYのサイトリストと連携するストリーミングサイトディレクトリ、Cinemetaの映画・シリーズカタログ
- OpenSubtitles連携、Simklの視聴記録（任意）
- IPTV対応（iptv-orgの公開チャンネル11,000以上、プレイリスト・Xtream Codes追加可）
- TVリモコン（D-pad）とタッチの両対応

詳しい使い方は上流の [ドキュメント](https://fmhyplay.github.io/android/) と [ユーザーガイド](https://fmhyplay.github.io/android/guide.html) を参照してください。

## ソースからビルド

```sh
git clone https://github.com/Ayufa/fmhyplay-android-jp
cd fmhyplay-android-jp
warp/build.sh      # WARPヘルパーのビルド（Go と Android NDK が必要）
./build.sh         # Android SDK（platform 34、build-tools）と JDK 17+ が必要
```

## ライセンスとクレジット

- MIT ライセンス（[LICENSE](LICENSE)）。原著作権表記は保持しています。
- FMHYPlay 本体は [fmhyplay/android](https://github.com/fmhyplay/android) の開発者・貢献者によるものです。このリポジトリは非公式の翻訳コピーであり、上流プロジェクトとは関係ありません。
- サードパーティについては [THIRD_PARTY.md](THIRD_PARTY.md) を参照してください。
