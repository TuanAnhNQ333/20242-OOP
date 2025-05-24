package hust.soict.hedspi.aims.media;

import java.util.Comparator;


public abstract class Media {
    public static final Comparator COMPARE_BY_TITLE_COST = null;
    public static final Comparator COMPARE_BY_COST_TITLE = null;
    private int id;
    private String title;
    private String category;
    private float cost;


    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost) { this.cost = cost; }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Media m) {
            return this.id == m.id && this.title.equalsIgnoreCase(m.title) && this.category.equalsIgnoreCase(m.category) && this.cost == m.cost;
        }
        return false;
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("1. Add to cart");
        System.out.println("2. Play"); // Chỉ cho CD/DVD
        System.out.println("0. Back");
        System.out.println("Please choose a number: 0-1-2");
    }
}