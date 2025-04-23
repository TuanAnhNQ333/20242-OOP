package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.Track;

public class CD extends Media {
    private final String artist; 
    private final List<Track> tracks = new ArrayList<>();

    public CD(int id, String title, String category, String artist, float cost) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

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
