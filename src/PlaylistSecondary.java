import java.util.Random;

import components.simplewriter.SimpleWriter;

/**
 * Abstract class implementing secondary methods for Playlist.
 *
 * @param <T>
 *            the type of elements (songs) stored in the playlist
 */
public abstract class PlaylistSecondaryAbstract<T>
        implements PlaylistSecondary<T> {

    // ---------------------------------------------------------
    // Secondary methods implemented using only kernel + Standard
    // ---------------------------------------------------------

    @Override
    public void shuffle() {
        assert this.getSize() >= 0 : "Violation of: playlist exists";

        int size = this.getSize();
        if (size <= 1) {
            return; // nothing to shuffle
        }

        Random rand = new Random();
        // Simple shuffle by removing and reinserting in random positions
        for (int i = 0; i < size; i++) {
            int randomIndex = rand.nextInt(this.getSize());
            T song = this.removeSong(randomIndex);
            this.addSong(song);
        }
    }

    @Override
    public void clear() {
        // remove all songs
        while (this.getSize() > 0) {
            this.removeSong(0);
        }
    }

    @Override
    public boolean contains(T s) {
        assert s != null : "Violation of: s is not null";

        boolean found = false;
        int size = this.getSize();
        Playlist<T> temp = this.newInstance(); // temporary copy to preserve state

        // Search using kernel operations
        for (int i = 0; i < size; i++) {
            T song = this.removeSong(0);
            if (song.equals(s)) {
                found = true;
            }
            temp.addSong(song);
        }

        // restore playlist
        for (int i = 0; i < size; i++) {
            this.addSong(temp.removeSong(0));
        }

        return found;
    }

    @Override
    public void printPlaylist(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out must be open";

        out.println("Current Playlist:");
        int size = this.getSize();
        Playlist<T> temp = this.newInstance();

        for (int i = 0; i < size; i++) {
            T song = this.removeSong(0);
            out.println("  " + (i + 1) + ". " + song);
            temp.addSong(song);
        }

        // restore original playlist
        for (int i = 0; i < size; i++) {
            this.addSong(temp.removeSong(0));
        }
    }

    // ---------------------------------------------------------
    // Common Object methods (implemented using kernel methods)
    // ---------------------------------------------------------

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: [");

        int size = this.getSize();
        Playlist<T> temp = this.newInstance();

        for (int i = 0; i < size; i++) {
            T song = this.removeSong(0);
            sb.append(song);
            if (i < size - 1) {
                sb.append(", ");
            }
            temp.addSong(song);
        }

        // restore playlist
        for (int i = 0; i < size; i++) {
            this.addSong(temp.removeSong(0));
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Playlist<T> other = (Playlist<T>) obj;

        if (this.getSize() != other.getSize()) {
            return false;
        }

        boolean equal = true;
        int size = this.getSize();
        Playlist<T> temp1 = this.newInstance();
        Playlist<T> temp2 = other.newInstance();

        for (int i = 0; i < size; i++) {
            T song1 = this.removeSong(0);
            T song2 = other.removeSong(0);

            if (!song1.equals(song2)) {
                equal = false;
            }

            temp1.addSong(song1);
            temp2.addSong(song2);
        }

        // restore both
        for (int i = 0; i < size; i++) {
            this.addSong(temp1.removeSong(0));
            other.addSong(temp2.removeSong(0));
        }

        return equal;
    }

    protected abstract Playlist<T> newInstance();
}
