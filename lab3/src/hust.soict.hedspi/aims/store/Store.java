import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
        }
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }

    public void printStore() {
        System.out.println("***** STORE *****");
        for (Media m : itemsInStore) {
            System.out.println(m.toString());
        }
    }
}
