# Changelog

Only the current version is kept here: each `vX.Y.Z` tag publishes the TV and Android APKs, and this section becomes the release notes. Older notes are on the [Releases page](https://github.com/fmhyplay/android/releases).

## 2.20.0

### ✨ New
- **Downloads.** While a movie, series or anime plays, the new **Download** button (the arrow next to More) saves it. It asks first and shows the file name, the folder and the number of connections. Files are named like `Crawlers.2024.1080p.FMHYPlay.mp4`, with the quality and dots between the parts. Several connections at once (4 by default, 1 to 8 in *Settings, Downloads*), pause and resume, progress in a notification, and downloads carry on in the background. HLS streams are saved with a seek index, so the video can be skipped through. A **Downloads** screen lists them with their path and a pause, play and bin button each. DASH, live and protected streams cannot be downloaded.
- **Home banner** changes by itself every 20 seconds: the world's top 5 films and series, taken in turns, with a fade and five dots to show where you are. On a wide screen it keeps the whole picture instead of cropping it.
- **No more "Load more".** Movies, TV, Anime and a season's episodes keep adding titles as you scroll, so the remote stays where it was; a "Loading…" tile shows at the end while the next ones come. The Movies, TV and Anime tabs open on the first poster, not on a site.
- **Volume boost and Dialog boost go from 0 to 20**, with − and + buttons, in *Settings, Player* and in the player's *More*.
- **Movie pages show the sites in a grid** (a series keeps one row). The slim site row on the Movies, TV and Anime tabs shows FMHY's tags (4K, Dual Audio...) so you can see where the quality is.
- **IPTV in the player:** the Channels strip and Channel + / − go on into the country's other categories instead of going back to the start.
- **Icons** in Settings (every row), in the player's *More*, on the title page buttons and in the confirmation dialogs; the Settings list is more compact. Screens and tabs fade in and out.

### 🐞 Fixed
- **Movy, Cinejoy, 7Movies and the other main sites were missing** from movie and TV pages: FMHY changed the tags on its lists and the app no longer put those sites under Movies and TV.
- **Settings jumped back to the top** after every change (a row you changed, a switch, a confirmation). A change now keeps the scroll and the remote where they were.
