import components.simplewriter.SimpleWriter;

/**
 * Abstract class for Playlist thats implements secondary methods using kernel
 * methods.
 *
 * @param <T>
 *            type of song objects in playlist
 */
public abstract class PlaylistSecondary<T> implements PlaylistKernel<T> {
    ---------------------------------------------------------

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
            T song = this.removeSong(0);
            if (song.equals(s))
                found = true;
            this.addSong(song);
        }

        return found;
    }

    @Override
    public final void shuffle() {
        int size = this.getSize();
        for (int i = 0; i < size; i++) {
            T song = this.removeSong(0);
            this.addSong(song);
        }
    }

    @Override
    public final void printPlaylist(SimpleWriter out) {
        assert out.isOpen() : "Violation of: out is open";

        out.println("Current Playlist:");
        int size = this.getSize();

        for (int i = 0; i < size; i++) {
            T song = this.removeSong(0);
            out.println((i + 1) + ". " + song);
            this.addSong(song);
        }
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int size = this.getSize();

        for (int i = 0; i < size; i++) {
            T song = this.removeSong(0);
            sb.append(song);
            if (i < size - 1)
                sb.append(", ");
            this.addSong(song);
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof PlaylistSecondary))
            return false;

        PlaylistSecondary<T> other = (PlaylistSecondary<T>) obj;
        int size = this.getSize();
        if (size != other.getSize())
            return false;

        boolean equal = true;
        for (int i = 0; i < size; i++) {
            T song1 = this.removeSong(0);
            T song2 = other.removeSong(0);

            if (!song1.equals(song2))
                equal = false;

            this.addSong(song1);
            other.addSong(song2);
        }

        return equal;
    }

    @Override
    public final int hashCode() {
        int hash = 1;
        int size = this.getSize();

        for (int i = 0; i < size; i++) {
            T song = this.removeSong(0);
            hash = 31 * hash + (song == null ? 0 : song.hashCode());
            this.addSong(song);
        }

        return hash;
    }
}
