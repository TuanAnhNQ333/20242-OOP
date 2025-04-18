import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED && !itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
        }
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }

    public float totalCost() {
        return itemsOrdered.stream().mapToFloat(Media::getCost).sum();
    }

    public void printCart() {
        System.out.println("***** CART *****");
        for (Media media : itemsOrdered) {
            media.print();
        }
        System.out.println("Total cost: " + totalCost() + "$");
    }

    public void sortByTitleCost() {
        itemsOrdered.sort(Comparator.comparing(Media::getTitle).thenComparing(Media::getCost));
    }

    public void sortByCostTitle() {
        itemsOrdered.sort(Comparator.comparing(Media::getCost).thenComparing(Media::getTitle));
    }
}
