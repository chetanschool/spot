import components.simplewriter.SimpleWriter;

/**
 * Playlist interface extending PlaylistKernel with additional functionalities.
 *
 * @param <T>
 *            Types of songs in playlist
 */
public interface Playlist<T> extends PlaylistKernel<T> {

    /**
     * Shuffles the order of songs in the playlist randomly.
     *
     * @updates this
     * @ensures the order of songs in this playlist is randomized
     */
    void shuffle();

    /**
     * Clears all songs from the playlist.
     *
     * @updates this
     * @ensures this = <>
     */
    @Override
    void clear();

    /**
     * Checks if a song exists in the playlist.
     *
     * @param s
     *            the song to check
     * @return true if the song exists in the playlist, false otherwise
     * @ensures contains = [true if s is in this, false otherwise]
     */
    boolean contains(T s);

    /**
     * Prints the playlist to standard output.
     *
     * @param out
     *            the playlist that will print
     *
     * @ensures prints all songs in the playlist in order
     */
    void printPlaylist(SimpleWriter out);
}
