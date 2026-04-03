package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class Cart {
    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Added to cart: " + media.getTitle());
        } else {
            System.out.println("Media already in cart: " + media.getTitle());
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed from cart: " + media.getTitle());
        } else {
            System.out.println("Media not found in cart: " + media.getTitle());
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void clear() {
        itemsOrdered.clear();
        System.out.println("Cart has been cleared.");
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return media;
            }
        }
        return null;
    }

    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public void filterMediaById(int id) {
        Media found = searchById(id);
        if (found != null) {
            itemsOrdered.setAll(found);
        }
    }

    public void filterMediaByTitle(String title) {
        ObservableList<Media> filtered = FXCollections.observableArrayList();
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                filtered.add(media);
            }
        }
        if (!filtered.isEmpty()) {
            itemsOrdered.setAll(filtered);
        }
    }

    public void resetFilter() {
        itemsOrdered.setAll(new ArrayList<>(itemsOrdered));
    }

    public void placeOrder() {
        itemsOrdered.clear();
        System.out.println("Order placed successfully!");
    }
}
