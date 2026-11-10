# Changelog

Only the current version is kept here: each `vX.Y.Z` tag publishes the TV and Android APKs, and this section becomes the release notes. Older notes are on the [Releases page](https://github.com/fmhyplay/android/releases).

## Unreleased

### ✨ New
- **New look on every screen**: darker, calmer colours; one bar on top with the tabs, Search, voice, WARP and Settings (a phone keeps its tabs at the bottom, now six, with Settings as the gear on top); posters with their name and year underneath instead of on the picture; a white focus ring with a slight grow on a TV; app-coloured pop-ups.
- **A big picture on top of Home**: one of the first row's titles, a different one each day. Press play to open it.
- **Your country first**: Home starts with Movies and TV rows from your country (India: Hindi, Tamil, Telugu, Malayalam, Kannada taken in turns), and the Movies and TV tabs get a chip per language. The country is found from the mobile network or the time zone; change it or switch it off in Settings, Your country. Lists come from TMDB through the public Stremio TMDB addon.
- **Title pages** have the title's wide picture behind the top.
- Rows show grey placeholders while they load, so the page does not jump.

### 🔧 Changed
- **Search waits until you pause typing** (about half a second) before it searches and redraws. Pressing Search on the keyboard searches at once.
- The ad block switch is in Settings only; the top bar shows WARP's state as one icon (words appear when it is connecting or failed).

### 🐞 Fixed
- **Crash on pages with a long number after "episode"** in the address or title (ten digits or more): saving it to Continue watching overflowed. Such a number is now treated as an id, not an episode.
- Posters and pictures nobody opened for 60 days are removed from storage (they used to pile up forever).
- A download that broke half way no longer leaves its connection open.

## 2.18.6

### 🐞 Fixed
- **No loading screen after pressing OK on Next episode** (TV remote): the player acts on the key going down and closes, and the key coming back up reached the site, whose loading screen counts OK as "dismiss" and took itself down at once. Only an OK press that began on the loading screen dismisses it now.
- **Next episode could get stuck on the old episode** for a resumed anime when the catalog had no address for it: the app now swaps the episode number in the page's own address (`…episode-3` becomes `…episode-4`) before trying to press the episode in the site's list.
- **A page that fails to load** (no network, timed out) now ends the loading screen in a few seconds with the staring cat, instead of waiting 40 seconds.
