import components.standard.Standard;

/**
 * @param <T>
 *            Types of songs in playlist
 */

public interface PlaylistSecondary<T> extends Standard {

    /**
     * Randomly shuffles the playlist
     *
     * @updates this
     *
     */
    void shuffle();

    /**
     * Removes all songs from playlist
     *
     * @updates this
     * @ensures this = <>
     */
    @Override
    void clear();

    /**
     * Checks if given song is in playlist
     *
     * @param s
     *          song to check for
     * @return true if s is in playlist, or false if it's not
     *
     */
    boolean contains(T s);

    /**
     * Prints out all songs in playlist
     *
     * @param out
     *      SimpleWriter to output
     * @requires
     *      out is open
     * @ensures
     * Playlist is printed in order
     */
    void printPlaylist(SimpleWriter out);


    //it's not letting me import simpleWriter and keeps removing this so i'm just not going to import it for now


}

