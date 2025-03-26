public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;// Class variable to track number of DVDs
    private int id; // Unique ID for each DVD

    // Constructor 1: Chỉ có title
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // Constructor 2: category, title và cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor 3: director, category, title và cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // Constructor 4: Tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        // Assign a unique ID and increment the counter
        this.id = ++nbDigitalVideoDiscs;
    }

    // Getter for ID
    public int getId() {
        return id;
    }
    // Getter để lấy thông tin
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }
}
