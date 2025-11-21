# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [Unreleased]

## Added
## [2025.11.20]
- Designed abstract class for Playlist component
- Implemented all secondary methods using kernel methods
   -clear ; contains ; shuffle ; printPlaylist
- Implemented object methods using kernel methods




## Added

## [2025.11.20]
- Created PlaylistKernel.java
   -added addSong(T s) - enqueues song to playlist
   -added removeSong(int idx) - removes and returns song at given index
   -added getSize() - returns num of songs in playlist

-Created PlaylistSecondary.java
   -added shuffle() - randomly reorders songs
   -added clear() - removes all songs in playlist
   -added contains(T s) - checks to see if a given song is in the playlist
   -added printPlaylist(SimpleWriter out) - prints the entire playlist in order

[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07
