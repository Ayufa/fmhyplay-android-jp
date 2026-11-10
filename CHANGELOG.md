# Changelog

Only the current version is kept here: each `vX.Y.Z` tag publishes the TV and Android APKs, and this section becomes the release notes. Older notes are on the [Releases page](https://github.com/fmhyplay/android/releases).

## Unreleased

### ✨ New
- **New look on every screen**: darker, calmer colours; on a TV a rail down the left side with Search, the tabs, WARP and Settings, one Left press from any row; on a phone a top bar with Search, voice, WARP and Settings, and six tabs at the bottom; posters with their name and year underneath instead of on the picture; a white focus ring with a slight grow on a TV; app-coloured pop-ups.
- **A big picture on top of Home**: one of the first row's titles, a different one each day. Press play to open it.
- **Your country first**: Home starts with Movies and TV rows from your country (India: Hindi, Tamil, Telugu, Malayalam, Kannada taken in turns), and the Movies and TV tabs open on your first language, with a chip per language. The country is found from the mobile network or the time zone; change it or switch it off in Settings, Your country. Lists come from TMDB through the public Stremio TMDB addon.
- **Title pages** have the title's wide picture behind the top.
- **More on one screen**: smaller margins, a slim line of sites on the Movies, TV and Anime tabs, smaller Continue watching cards on a TV.
- **Phone title page**: the sites to watch on are a two-across grid instead of a sideways row.
- **Trailer** button on title pages (YouTube).
- **Settings in sections** that open and close (Home, Connection, Your data, IPTV, Player, Updates, Sites, Donate, About), so the tab starts as a short list.
- **Donate and About**: ways to support the app, the website, source code and where to report a problem.
- **Clear website data** (Settings, Your data): cookies, logins, cache and saved data of every site.
- **Turning WARP off asks first**, so a stray press does not show sites your real address.
- The app's name is on the TV rail and the phone's top bar.
- **Smaller tiles on a TV**: eight posters across in grids, more in every row.
- **Pull down to refresh** on a phone: reloads the open tab (catalog lists, sites on Sports, channels on IPTV).
- **IPTV tab redone**: what you watched and your favorites first, then your playlists and pins, then your country's channels, then categories and countries as compact cards (your country first). Channel logos sit on one quiet tone.
- Rows show grey placeholders while they load, so the page does not jump.

### 🔧 Changed
- **Search waits until you pause typing** (about half a second) before it searches and redraws. Pressing Search on the keyboard searches at once.
- The ad block switch is in Settings only; the top bar shows WARP's state as one icon (words appear when it is connecting or failed).

- **Pictures load faster and stay loaded**: their own download threads, one download per picture however many cards show it, decoded at the card's size, and a memory cache sized to the device (it held about 17 posters before, so scrolling back loaded them again). A missing picture is not asked for again for ten minutes. The picture folder is capped at 200 MB.
- **Tabs switch without the lag**: the pressed tab lights up at once, site lists and catalog pages are parsed once instead of on every switch, and the rows below the first screen are added a frame later.

### 🐞 Fixed
- **Crash on pages with a long number after "episode"** in the address or title (ten digits or more): saving it to Continue watching overflowed. Such a number is now treated as an id, not an episode.
- Posters and pictures nobody opened for 60 days are removed from storage (they used to pile up forever).
- A download that broke half way no longer leaves its connection open.

## 2.18.6

### 🐞 Fixed
- **No loading screen after pressing OK on Next episode** (TV remote): the player acts on the key going down and closes, and the key coming back up reached the site, whose loading screen counts OK as "dismiss" and took itself down at once. Only an OK press that began on the loading screen dismisses it now.
- **Next episode could get stuck on the old episode** for a resumed anime when the catalog had no address for it: the app now swaps the episode number in the page's own address (`…episode-3` becomes `…episode-4`) before trying to press the episode in the site's list.
- **A page that fails to load** (no network, timed out) now ends the loading screen in a few seconds with the staring cat, instead of waiting 40 seconds.
