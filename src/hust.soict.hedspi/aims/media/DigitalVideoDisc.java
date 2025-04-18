import aims.media.Media;
import aims.media.Playable;

public class DigitalVideoDisc extends Media implements Playable {
    private int length;
    private String director;

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.length);
    }

    @Override
    public String toString() {
        return "[DVD] " + super.toString() + " - Length: " + length;
    }
}
