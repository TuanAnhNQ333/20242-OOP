import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private String director;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, String director, String artist, float cost) {
        super(id, title, category, cost);
        this.director = director;
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.artist);
        for (Track t : tracks) {
            System.out.println(" - " + t);
        }
    }

    @Override
    public String toString() {
        return "[CD] " + super.toString() + " - Artist: " + artist + " - Tracks: " + tracks.size();
    }
}
