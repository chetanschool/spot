import components.standard.Standard;

/**
 * @param <T>
 *            Types of songs in playlist
 */

public interface PlaylistKernel<T> extends Standard<Playlist> {

    /**
     * Adds a song to playlist
     *
     * @param s
     *            the song to enqueue
     * @updates this
     * @ensures this = #this * <s>
     */

}
