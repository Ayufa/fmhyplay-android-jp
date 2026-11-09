# Changelog

Each `vX.Y.Z` tag publishes the TV and Android APKs; its section below becomes the release notes.

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

## 2.18.4

Everything new since 2.17.1 (2.18.0 to 2.18.4 together).

### ✨ New
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
- **New player look**: one row of icons (Previous, Next, Quality, Audio, Sub / Dub, Episodes, Servers, Subtitles, More, Cast, Full screen) and what is picked under the title. Speed, boosts, zoom and From the start are in More. On a TV the button the remote is on shows its name.
- **FMHYPlayer**: the player has a name; its button sits on the site's own player.
- **Anime tab**: its big grid is Popular anime (real anime only) and keeps loading more.
- **WARP connects on more networks**, says why when it can't, and stops at once when Cloudflare limits sign-ups (HTTP 429). **Settings, WARP DNS** takes your provider's DNS.
- **Movies, TV, Anime and the update alert** no longer wait for WARP; new site addresses arrive within the hour.
- **Phone top bar**: the logo alone, so Search gets the room.

### 🐞 Fixed
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

## 2.18.3

Everything new since 2.17.1 (2.18.0 to 2.18.3 together).

### ✨ New
- **Series and anime in the player**: Episodes list (seasons, pictures, names), Previous and Next, and the next episode starts by itself.
- **Skip intro, recap and credits**, with a Next episode countdown at the credits (OK on the remote presses it). Settings, Skip intros skips them without asking.
- **Sub / Dub button** for anime: one press switches, each site remembers your pick.
- **Episodes open directly** on 34 TV sites and 22 anime sites. Elsewhere the app presses the episode on the site for you, also behind a player's Episodes menu (Cinefork, Aether, Basement).
- **A title's own page** opens on about 70 sites; the others are searched and the match opened. Anime opens on anime sites only, wherever you open it from.
- **Title page**: the sites in one row with the episodes right below, plus cast, director, seasons and episodes, still running or ended, country and awards.
- **Subtitles in any language** (Arabic and others that never showed), converted so every script shows right, and lined up with the speech by themselves when a file is off.
- **Picture in picture** on phones, and **hold for 2x**: right side forward, left side back.
- **Site pop-ups** like "Join our Discord" and "What's new" close by themselves; movies opened from the catalog start playing by themselves.

### 🔧 Changed
- **New player look**: one row of icons (Previous, Next, Quality, Audio, Sub / Dub, Episodes, Servers, Subtitles, More, Cast, Full screen) and what is picked under the title. Speed, boosts, zoom and From the start are in More. On a TV the button the remote is on shows its name.
- **FMHYPlayer**: the player has a name; its button sits on the site's own player.
- **Anime tab**: its big grid is Popular anime (real anime only) and keeps loading more.
- **WARP connects on more networks**, says why when it can't, and stops at once when Cloudflare limits sign-ups (HTTP 429). **Settings, WARP DNS** takes your provider's DNS.
- **Movies, TV, Anime and the update alert** no longer wait for WARP; new site addresses arrive within the hour.
- **Phone top bar**: the logo alone, so Search gets the room.

### 🐞 Fixed
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

## 2.18.2

Everything new since 2.17.1 (2.18.0, 2.18.1 and 2.18.2 together).

### ✨ New
- **Series and anime in the player**: Episodes list (seasons, pictures, names), Previous and Next, and the next episode starts by itself.
- **Skip intro, recap and credits**, with a Next episode countdown at the credits (OK on the remote presses it). Settings, Skip intros skips them without asking.
- **Sub / Dub button** for anime: one press switches, each site remembers your pick.
- **Episodes open directly** on 34 TV sites and 22 anime sites. Elsewhere the app presses the episode on the site for you, also behind a player's Episodes menu (Cinefork, Aether, Basement).
- **A title's own page** opens on about 70 sites; the others are searched and the match opened. Anime opens on anime sites only, wherever you open it from.
- **Title page**: the sites in one row with the episodes right below, plus cast, director, seasons and episodes, still running or ended, country and awards.
- **Subtitles in any language** (Arabic and others that never showed), converted so every script shows right, and lined up with the speech by themselves when a file is off.
- **Picture in picture** on phones, and **hold for 2x**: right side forward, left side back.
- **Site pop-ups** like "Join our Discord" and "What's new" close by themselves; movies opened from the catalog start playing by themselves.

### 🔧 Changed
- **New player look**: one row of icons (Previous, Next, Quality, Audio, Sub / Dub, Episodes, Servers, Subtitles, More, Cast, Full screen) and what is picked under the title. Speed, boosts, zoom and From the start are in More. On a TV the button the remote is on shows its name.
- **FMHYPlayer**: the player has a name; its button sits on the site's own player.
- **Anime tab**: its big grid is Popular anime (real anime only) and keeps loading more.
- **WARP connects on more networks**, says why when it can't, and stops at once when Cloudflare limits sign-ups (HTTP 429). **Settings, WARP DNS** takes your provider's DNS.
- **Movies, TV, Anime and the update alert** no longer wait for WARP; new site addresses arrive within the hour.
- **Phone top bar**: the logo alone, so Search gets the room.

### 🐞 Fixed
- **Resuming an anime** could leave you on the site with "No video found" when the site remembered Dub (or Sub) and the episode didn't have it.
- **Anime opened from the general catalog** (Death Note and others) listed movie and TV sites.
- **App closed on start on Android 8 and 9** (many TV boxes, Fire OS 7, older Sony TVs).
- **StreamCorner** showed a blank page and its live streams never reached the player.
- **NekoWatch and other sites behind one proxy address**: a new episode or the Dub version now reaches the player.
- **Servers on Cinejoy** listed the player's skip buttons.
- **IPTV on a TV**: a channel tile kept its ring after the remote moved to the chips.
- **Subtitle settings in landscape**: Reset and Done stay on screen.

## 2.18.1

### 🔧 Changed
- **Title page**: the sites sit in one row, so the episodes are right below; more about the title (cast, director, seasons and episodes, still running or ended, country, awards).
- **Anime tab**: its big grid is now Popular anime (real anime only), and keeps loading more.

### 🐞 Fixed
- **Anime opened from the general catalog** (Death Note and others) listed movie and TV sites: animated titles the anime databases know now get the anime sites.
- **New site addresses** reach the app within the hour, not only with the 12-hour channel refresh.

## 2.18.0

### ✨ New
- **Series and anime in the player**: Episodes list (seasons, pictures, names), Previous and Next, and the next episode starts by itself.
- **Skip intro, recap and credits**, with a Next episode countdown at the credits (OK on the remote presses it). Settings, Skip intros skips them without asking.
- **Sub / Dub button** for anime: one press switches, each site remembers your pick.
- **Episodes open directly** on 34 TV sites and 22 anime sites. Elsewhere the app presses the episode on the site for you, also behind a player's Episodes menu (Cinefork, Aether, Basement).
- **A title's own page** opens on about 70 sites; the others are searched and the match opened. Anime opens on anime sites only.
- **Subtitles in any language** (Arabic and others that never showed), converted so every script shows right, and lined up with the speech by themselves when a file is off.
- **Picture in picture** on phones, and **hold for 2x**: right side forward, left side back.
- **Site pop-ups** like "Join our Discord" and "What's new" close by themselves; movies opened from the catalog start playing by themselves.

### 🔧 Changed
- **New player look**: one row of icons (Previous, Next, Quality, Audio, Sub / Dub, Episodes, Servers, Subtitles, More, Cast, Full screen) and what is picked under the title. Speed, boosts, zoom and From the start are in More. On a TV the button the remote is on shows its name.
- **FMHYPlayer**: the player has a name; its button sits on the site's own player.
- **WARP connects on more networks**, says why when it can't, and stops at once when Cloudflare limits sign-ups (HTTP 429). **Settings, WARP DNS** takes your provider's DNS.
- **Movies, TV, Anime and the update alert** no longer wait for WARP.
- **Phone top bar**: the logo alone, so Search gets the room.

### 🐞 Fixed
- **App closed on start on Android 8 and 9** (many TV boxes, Fire OS 7, older Sony TVs).
- **StreamCorner** showed a blank page and its live streams never reached the player.
- **NekoWatch and other sites behind one proxy address**: a new episode or the Dub version now reaches the player.
- **Servers on Cinejoy** listed the player's skip buttons.
- **IPTV on a TV**: a channel tile kept its ring after the remote moved to the chips.
- **Subtitle settings in landscape**: Reset and Done stay on screen.

## 2.17.1

### 🐞 Fixed
- **Dialog boost** made everything quieter: it now lowers rumble and bass and lifts the level, so voices come out louder. Turning a boost off brings the sound fully back at once.

## 2.17.0

### ✨ New
- **DLNA / UPnP casting**: smart TVs from Samsung, LG, Sony, Kodi and others show up in the Cast list ("Name - DLNA"), through the phone like Chromecast.
- **Fire TV**: install with Downloader code 9828006; the link `releases/latest/download/FMHYPlay-TV.apk` always gets the newest version.
- **Stalker portals**: add your IPTV provider's portal address and MAC address (MAG login) next to Xtream; channels get their own row.
- **PunchPlay**: Settings, PunchPlay connects with a code at punchplay.tv/link; movies and episodes you watch are tracked there, like Simkl.
- **IPTV filters and pins**: channel lists have Category and Language chips (movies, TV, kids and news first; Hindi, English, Tamil for India). The pin button keeps a list with its chips (India · News · Hindi) as its own row on the IPTV tab.

### 🔧 Changed
- **Audio language**: the language you pick on the player's Audio button is where every next video starts, when it has it (then your device's language), instead of the stream's default, often English. The list shows language names, not "stream_4".

## 2.16.1

### 🐞 Fixed
- **Dialog boost** is off by default again: it caused sound problems on some devices. Turn it on in Settings or with its button in the player.
- **TV tabs** show a ring when the remote is on them.

## 2.16.0

### ✨ New
- **Cast to TV**: the Cast button in the player sends the video to a TV on your Wi-Fi, from the same spot. The phone becomes the remote (play/pause, seek, volume keys).
- **FMHYPlay on the TV** (recommended): plays every stream the phone can, even when the app is closed. On the TV: Settings → Cast to this TV → allow once.
- **Chromecast**: Google TV and Cast TVs work without FMHYPlay on the TV. The phone relays the stream, so keep it on the same Wi-Fi.
- **Your language**: Hindi, Spanish, Portuguese, Indonesian, Arabic and German, picked from the device.

### 🔧 Changed
- **Dialog boost** is on by default.
- **Pop-ups**: a link a site opens in a new window now opens in the same tab (Back returns). Ad pop-ups are dropped, and the link you tapped opens anyway (CricHD's Watch works in one tap).
- **Continue watching** shows the catalog poster for titles opened from Movies, TV or Anime, also on sites without their own.

### 🐞 Fixed
- Volume boost and Dialog boost had no effect on many phones and TVs.

## 2.15.0

### ✨ New
- **New Home**: search across the top, tabs, Continue watching, Favorites, and New + Popular for Movies, TV and Anime.
- **One search** for movies, series, channels and sites.
- **Resume anywhere**: carries on where you stopped, on any site or server. Restart button in the player.
- **Sound**: Volume boost and Dialog boost, with defaults in Settings.
- **Subtitles**: color, background, auto subtitles in your language, remembered picks.
- **What's new** in the update alert, **WARP log** to share, **Address bar** on sites, **cursor looks** on TV.

### 🔧 Changed
- Phone player follows the rotation lock and has a Full screen button.
- IPTV Working row shows channels; favorites use a heart.

## 2.14.3

- Search results fill the page as a poster grid.

## 2.14.2

- Faster search, with a spinner; accents don't matter.

## 2.14.1

- Fixed: Check channels showed "0 offline" after a playlist change.

## 2.14.0

### ✨ New
- **Simkl**: marks movies and episodes watched.
- **Xtream Codes** login for IPTV; playlists get names and their own rows.
- **Update check** on start, with Install on Home.
- **Subtitles panel**: size, position and timing.

### 🔧 Changed
- Fewer permissions; WARP helper rebuilt so antivirus apps stop flagging it.

## 2.13.0

- Episodes are picked on the site; the native player follows by itself.
