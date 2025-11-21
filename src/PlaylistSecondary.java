import components.simplewriter.SimpleWriter;

/**
 * Abstract class for Playlist that implements secondary methods using just the
 * kernel methods.
 *
 * @param <T>
 *            type of songs in the playlist type T
 */
public abstract class PlaylistSecondary<T> implements PlaylistKernel<T> {

    @Override
    public final void clear() {
        while (this.getSize() > 0) {
            this.removeSong(0);
        }
    }

    @Override
    public final boolean contains(T s) {
        assert s != null : "Violation of: s is not null";

        boolean found = false;
        int size = this.getSize();

        for (int i = 0; i < size; i++) {
            T x = this.removeSong(0);
            if (x.equals(s)) {
                found = true;
            }
            this.addSong(x);
        }

        return found;
    }

    @Override
    public final void shuffle() {
        // Simple rotate shuffle
        if (this.getSize() > 0) {
            T first = this.removeSong(0);
            this.addSong(first);
        }
    }

    @Override
    public final void printPlaylist(SimpleWriter out) {
        assert out != null && out.isOpen() : "Violation of: out is open";

        out.println("Current Playlist:");
        int size = this.getSize();

        for (int i = 0; i < size; i++) {
            T x = this.removeSong(0);
            out.println((i + 1) + ". " + x);
            this.addSong(x);
        }
    }

    @Override
    public final String toString() {
        String result = "[";
        int size = this.getSize();

        for (int i = 0; i < size; i++) {
            T x = this.removeSong(0);
            result += x;
            if (i < size - 1) {
                result += ", ";
            }
            this.addSong(x);
        }

        result += "]";
        return result;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlaylistKernel<?>)) {
            return false;
        }

        PlaylistKernel<T> other = (PlaylistKernel<T>) obj;

        int size = this.getSize();
        if (size != other.getSize()) {
            return false;
        }

        boolean same = true;
        for (int i = 0; i < size; i++) {
            T a = this.removeSong(0);
            T b = other.removeSong(0);

            if (!a.equals(b)) {
                same = false;
            }

            this.addSong(a);
            other.addSong(b);
        }

        return same;
    }

    @Override
    public final int hashCode() {
        int hash = 1;
        int size = this.getSize();

        for (int i = 0; i < size; i++) {
            T x = this.removeSong(0);
            hash = 31 * hash + x.hashCode();
            this.addSong(x);
        }

        return hash;
    }
}
