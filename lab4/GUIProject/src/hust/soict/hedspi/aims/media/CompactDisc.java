package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, String artist, float cost) {
        super(id, title, category, cost, 0, ""); // director không cần
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
