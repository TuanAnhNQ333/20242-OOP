package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {
    private final List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add null media.");
            return;
        }
        
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Media added: " + media.getTitle());
        } else {
            System.out.println("Media already exists in store.");
        }
    }

    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot remove null media.");
            return;
        }

        if (itemsInStore.remove(media)) {
            System.out.println("Media removed: " + media.getTitle());
        } else {
            System.out.println("Media not found in store.");
        }
    }

    public List<Media> getItemsInStore() {
        return Collections.unmodifiableList(itemsInStore);
    }

    public boolean containsMedia(Media media) {
        return itemsInStore.contains(media);
    }

    public int getNumberOfItems() {
        return itemsInStore.size();
    }
}
