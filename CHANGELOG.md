# Changelog

Only the current version is kept here: each `vX.Y.Z` tag publishes the TV and Android APKs, and this section becomes the release notes. Older notes are on the [Releases page](https://github.com/fmhyplay/android/releases).

## 2.18.6

### 🐞 Fixed
- **No loading screen after pressing OK on Next episode** (TV remote): the player acts on the key going down and closes, and the key coming back up reached the site, whose loading screen counts OK as "dismiss" and took itself down at once. Only an OK press that began on the loading screen dismisses it now.
- **Next episode could get stuck on the old episode** for a resumed anime when the catalog had no address for it: the app now swaps the episode number in the page's own address (`…episode-3` becomes `…episode-4`) before trying to press the episode in the site's list.
- **A page that fails to load** (no network, timed out) now ends the loading screen in a few seconds with the staring cat, instead of waiting 40 seconds.
