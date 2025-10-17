import java.util.Random;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * creates a playlist
 */
public final class Playlist<T> {

    private final Sequence<T> rep;

    /**
     * creates empty playlist
     */
    public Playlist() {
        this.rep = new Sequence1L<>();
    }

    //kernel

    /**
     * adds song to the end of playlist
     */
    public void addSong(T s) {
        this.rep.add(this.rep.length(), s);
    }

    /**
     * removes and returns the song at index
     *
     */
    public T removeSong(int index) {
        assert index >= 0 && index < this.rep.length() : "Index out of bounds";
        return this.rep.remove(index);
    }

    /**
     * returns the number of songs in the playlist.
     */
    public int getSize() {
        return this.rep.length();
    }

    /**
     * shuffles the playlist
     */
    public void shuffle() {
        Random r = new Random();
        for (int i = 0; i < this.rep.length(); i++) {
            int swapIndex = r.nextInt(this.rep.length());
            T temp = this.rep.entry(i);
            this.rep.replaceEntry(i, this.rep.entry(swapIndex));
            this.rep.replaceEntry(swapIndex, temp);
        }
    }

    /**
     * clears all songs from playlist
     */
    public void clear() {
        while (this.rep.length() > 0) {
            this.rep.remove(this.rep.length() - 1);
        }
    }

    /**
     * checks whether a song is in the playlist.
     *
     */
    public boolean contains(T s) {
        boolean found = false;
        for (int i = 0; i < this.rep.length(); i++) {
            if (this.rep.entry(i).equals(s)) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Prints all songs in order.
     */
    public void printPlaylist(SimpleWriter out) {
        out.println("Current Playlist:");
        for (int i = 0; i < this.rep.length(); i++) {
            out.println("  " + (i + 1) + ". " + this.rep.entry(i));
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        Playlist<String> playlist = new Playlist<>();
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        playlist.addSong("Song C");

        out.println("Before shuffle:");
        playlist.printPlaylist(out);
        out.println("");

        playlist.shuffle();
        out.println("After shuffle:");
        playlist.printPlaylist(out);
        out.println("");

        out.println("Contains 'Song B'? " + playlist.contains("Song B"));
        out.println("");

        playlist.removeSong(1);
        out.println("After removing index 1:");
        playlist.printPlaylist(out);
        out.println("");

        playlist.clear();
        out.println("After clear:");
        out.println("Playlist size = " + playlist.getSize());
        out.println("");

        out.close();
    }
}
