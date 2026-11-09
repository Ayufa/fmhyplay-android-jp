# Changelog

Only the current version is kept here: each `vX.Y.Z` tag publishes the TV and Android APKs, and this section becomes the release notes. Older notes are on the [Releases page](https://github.com/fmhyplay/android/releases).

## 2.18.5

Everything new since 2.17.1 (2.18.0 to 2.18.5 together).

### ✨ New
- **Back to Home in one step**: a house button at the top right of the player and of a website (phone), in the same place. On a TV: *More, Home* in the player and *Menu, Back to home* on a website. Everything open closes and the place in the video is saved.
- **A loading screen for everything the app does on a site**: while it loads the page, searches for the title, opens the episode, presses play and waits for the stream, a translucent dark screen with the title, the current step and a cat covers the site's own pages until the player is up: a spinning cat while the app works, a jumping one when the stream is found, a staring one when a step is stuck (then the page is yours). The cats are fetched once from Tenor and kept on the device. Tap it or press Back to see the page; it comes down by itself, with a note to pick the episode by hand, if a step gets stuck for 40 seconds.
- **Debug overlay in the player** (*More, Debug overlay*, off by default): resolution and frame rate, codec and decoder (hardware or software), video and audio bitrate, network speed (last download, estimate, 30-second average, total), buffer, dropped frames, stream type, host, WARP, how long the video took to open, and memory. It refreshes every second and stays as you set it.
- **Hold Back for 3 seconds to go Home** from the player, a website or any list screen, with a "Going to Home…" note. A short press still goes back one screen.
- **Series and anime in the player**: Episodes list (seasons, pictures, names), Previous and Next, and the next episode starts by itself.
- **Skip intro, recap and credits**, with a Next episode button at the credits (OK on the remote presses it). Settings, Skip intros skips them without asking.
- **Sub / Dub button** for anime: one press switches, each site remembers your pick.
- **Episodes open directly** on 34 TV sites and 22 anime sites. Elsewhere the app presses the episode on the site for you, also behind a player's Episodes menu (Cinefork, Aether, Basement).
- **A title's own page** opens on about 70 sites; the others are searched and the match opened. Anime opens on anime sites only, wherever you open it from.
- **Title page**: the sites in one row with the episodes right below, plus cast, director, seasons and episodes, still running or ended, country and awards.
- **Subtitles in any language** (Arabic and others that never showed), converted so every script shows right, and lined up with the speech by themselves when a file is off.
- **Picture in picture** on phones, and **hold for 2x**: right side forward, left side back.
- **Site pop-ups** like "Join our Discord" and "What's new" close by themselves; movies opened from the catalog start playing by themselves.

### 🔧 Changed
- The subtitles button shows **CC**, and the Home house is in the app's accent colour.
- **Updates are looked for every hour and at every boot** (it was every 12 hours, only when the app was opened). The hourly check also runs with the app closed, so the Install line is already there when you open Home. *Settings, Check automatically* turns it off.
- Subtitles now sit **20 dp from the bottom** by default (they were 100 dp up). *Subtitles, Position* still moves them, and a position you had set keeps its exact spot.
- **New player look**: one row of icons (Previous, Next, Quality, Audio, Sub / Dub, Episodes, Servers, Subtitles, More, Cast, Full screen) and what is picked under the title. Speed, boosts, zoom and From the start are in More. On a TV the button the remote is on shows its name.
- **FMHYPlayer**: the player has a name; its button sits on the site's own player.
- **Anime tab**: its big grid is Popular anime (real anime only) and keeps loading more.
- **WARP connects on more networks**, says why when it can't, and stops at once when Cloudflare limits sign-ups (HTTP 429). **Settings, WARP DNS** takes your provider's DNS.
- **Movies, TV, Anime and the update alert** no longer wait for WARP; new site addresses arrive within the hour.
- **Phone top bar**: the logo alone, so Search gets the room.

### 🐞 Fixed
- **The name above the focused player button went stale**: turn subtitles off and it still said "English" until you moved away and back. It now changes the moment the setting does (subtitles, audio, quality, Sub / Dub, server).
- **Subtitles you had on were off after resuming**: a subtitle track of the stream itself was never remembered, and a pick was filed under an IMDb id that Continue watching does not have. Both kinds are now remembered by title as well, so resuming turns the same subtitles on. (A pick made by an earlier version comes back after you open that title from its page once.)
- **Continue watching places were sometimes lost**: the place was only saved when the player closed. It is now saved every 10 seconds while playing (and when leaving), leaving right after resuming no longer wipes it, and a video the page had not recorded yet gets its entry.
- **Episodes opened several seconds late**: the app pressed your Sub / Dub choice even when the page was already in it, then waited 6 seconds for a change that never came. It now waits at most 3.5 seconds, and once a press changed nothing it skips the press for the rest of the visit (a real switch is unchanged, about a second). Next episode went from about 11 seconds to about 5 on the test phone.
- **Home and its tiles looked zoomed** after a video or page in landscape on a phone: the tiles were sized for the landscape width and never redrawn when the phone turned back.
- **"Next episode" showed near the start of an episode** (Death Note and others) instead of Skip intro: opening titles listed as credits in the skip data are now ignored.
- **Next episode no longer starts by itself during the credits**: the 10 second countdown is gone, only your press moves on before the video ends.
- **Next from a resumed anime** opens the episode's own page and returns to the player, instead of hunting for the episode on the site.
- **Resuming an anime on AnimeX** (and other players that load their playlist under an address without ".m3u8") stayed on the site: the playlist is noticed again, and a remembered Sub / Dub that was already playing no longer holds the video back.
- **The site's own Settings / quality menu** no longer opens by itself while FMHYPlay looks for servers, when the page already lists them.
- **Resuming an anime** could leave you on the site with "No video found" when the site remembered Dub (or Sub) and the episode didn't have it.
- **Anime opened from the general catalog** (Death Note and others) listed movie and TV sites.
- **App closed on start on Android 8 and 9** (many TV boxes, Fire OS 7, older Sony TVs).
- **StreamCorner** showed a blank page and its live streams never reached the player.
- **NekoWatch and other sites behind one proxy address**: a new episode or the Dub version now reaches the player.
- **Servers on Cinejoy** listed the player's skip buttons.
- **IPTV on a TV**: a channel tile kept its ring after the remote moved to the chips.
- **Subtitle settings in landscape**: Reset and Done stay on screen.
