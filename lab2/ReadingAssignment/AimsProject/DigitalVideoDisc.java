public class DigitalVideoDisc {

    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0; // Class variable to track number of DVDs
    private int id; // Unique ID for each DVD

    // Constructor with all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; // Assign a unique ID and increment the counter
    }

    // Overloaded constructors
    public DigitalVideoDisc(String title) {
        this(title, null, null, 0, 0.0f);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, null, 0, cost);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this(title, category, director, 0, cost);
    }

    // Static getter and setter for nbDigitalVideoDiscs
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
        DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
    }

    // Getters
    public int getId() {
        return id;
    }

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

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }
}

/*  Question: 

If you create a constructor method to build a DVD by title
then create a constructor method to build a DVD by category. Does JAVA allow you to do this?

Lý do: 
   Java không cho phép tạo hai constructor có cùng số lượng và kiểu tham số.
   java sẽ không biết gọi constructor nào, vì cần phân biệt các constructor thông qua số lượng và kiểu của tham số, không phải tên tham số
*/