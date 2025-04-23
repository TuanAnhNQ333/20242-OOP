package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList; 
import java.util.Collection;

public class Store {
    private final ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added media: " + media.getTitle());
        } else {
            System.out.println("Media already exists in store: " + media.getTitle());
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed media: " + media.getTitle());
        } else {
            System.out.println("Media not found in store: " + media.getTitle());
        }
    }

    public void displayStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
        } else {
            System.out.println("*************** STORE ***************");
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
            System.out.println("*************************************");
        }
    }

    public Media findByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void printStore() {

    }

    public Media searchByTitle(String title) {
        return findByTitle(title);
    }

    public Collection<Media> getItemsInStore() {
        return new ArrayList<>(itemsInStore);
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
}
