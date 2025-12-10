import components.queue.Queue;
import components.queue.Queue1L;
import components.standard.Standard;

/**
 * kernel implementation of playlist using a queue as my representation.
 *
 * @param <T>
 *            type of songs in the playlist
 *
 *
 *            Convention : The playlist is represented as a queue and it has no
 *            null values and the order of the songs in the queue is in the
 *            order in which the way the user adds it originally.
 *
 *            Correspondence : Every element in the queue directly corresponds
 *            to a song in the playlist and the front of the queue represents
 *            the first song in the playlist, and second represents the second,
 *            and so on.. They all have a position in the queue to show the next
 *            order.
 *
 */

public final class Playlist1L<T> extends PlaylistSecondary<T>
        implements Standard {

    /**
     * The queue that stores the playlists in order.
     */
    private Queue<T> rep;

    public Playlist1L() {
        this.createNewRep();
    }

    private void createNewRep() {
        this.rep = new Queue1L<>();
    }

    @Override
    public void newInstance() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(Standard s) {

        Playlist1L<T> input = (Playlist1L<T>) s;

        this.rep = input.rep;
        input.createNewRep();
    }

    @Override
    public void addSong(T s) {
        this.rep.enqueue(s);
    }

    @Override
    public T removeSong(int idx) {

        Queue<T> tmp = new Queue1L<>();
        T removed = null;

        for (int i = 0; i < this.rep.length(); i++) {
            T x = this.rep.dequeue();
            if (i == idx) {
                //remove all null
                removed = x;
            } else {
                tmp.enqueue(x);
            }
        }

        this.rep.transferFrom(tmp);

        return removed;
    }

    @Override
    public int getSize() {
        return this.rep.length();
    }
}
