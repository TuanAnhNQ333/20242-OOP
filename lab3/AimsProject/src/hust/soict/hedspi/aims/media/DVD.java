package hust.soict.hedspi.aims.media;

public class DVD extends Media implements Playable {
    private final int length;

    public DVD(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
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
