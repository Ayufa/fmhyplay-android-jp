# Changelog

Only the current version is kept here: each `vX.Y.Z` tag publishes the TV and Android APKs, and this section becomes the release notes. Older notes are on the [Releases page](https://github.com/fmhyplay/android/releases).

## 2.18.5

### ✨ New
- **Home in one step**: a house button at the top right of the player and of a website (phone); on a TV, *More, Home* in the player and *Menu, Back to home* on a site. Or **hold Back for 3 seconds** on any screen.
- **A loading screen while the app works on a site** (loading, searching, opening the episode, waiting for the stream): a translucent screen with the title, the step and a cat. Tap it or press Back to see the page; it gives up by itself if a step is stuck for 40 seconds.
- **Debug overlay** (*More, Debug overlay*, off by default): resolution, frame rate, codec and decoder, bitrates, network speed, buffer, frames shown and dropped, and more.

### 🔧 Changed
- **Updates are looked for every hour and at every boot** (it was every 12 hours, with the app open), also with the app closed. *Settings, Check automatically* turns it off.
- Subtitles sit **20 dp from the bottom** by default (they were 100 dp up); a position you had set keeps its spot. The subtitles button shows **CC** and the Home house uses the accent colour.

### 🐞 Fixed
- **Episodes opened several seconds late**: the app pressed your Sub / Dub choice even when the page was already in it, then waited 6 seconds. It now waits at most 3.5 seconds and skips the press once it saw it changes nothing. Next episode went from about 11 s to about 5 s on the test phone.
- **Subtitles you had on were off after resuming**: picks are now remembered by title too (also a track of the stream itself), so resuming turns them on. A pick from an earlier version comes back after you open that title from its page once.
- **Continue watching places were sometimes lost**: the place is now saved every 10 seconds while playing, leaving right after resuming no longer wipes it, and a video the page had not recorded yet gets its entry.
- **The name above the focused player button went stale** (it said "English" after subtitles went off): it now follows the setting at once.
- **Home and its tiles looked zoomed** after a video or page in landscape on a phone.
