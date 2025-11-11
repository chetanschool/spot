import components.standard.Standard;

/**
 * @param <T>
 *            Types of songs in playlist
 */

public interface PlaylistKernel<T> extends Standard {

    /**
     * Adds a song to playlist
     *
     * @param s
     *            the song to enqueue
     * @updates this
     * @ensures this = #this * <s>
     */
    void addSong(T s);

    /**
     * Removes song and returns song at index i
     *
     * @param index
     *            position in song
     * @requires 0<= index < |this|
     * @updates this
     * @ensures <pre>
     * removes song at given index
     * </pre>
     *
     * @return removed song
     */
    T removeSong(int index);

    /**
     * returns size of playlist
     *
     * @return size of playlist
     * @ensures getSize = |this|
     */
    int getSize();

}
