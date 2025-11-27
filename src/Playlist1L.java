import components.queue.Queue;
import components.queue.Queue1L;
import components.standard.Standard;

/**
 * kernel implementation of playlist using a queue as my representation.
 *
 * @param <T>
 *            type of songs in the playlist
 */
public final class Playlist1L<T> extends PlaylistSecondary<T>
        implements Standard {

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
