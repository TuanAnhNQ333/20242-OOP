package hust.soict.hedspi.aims.test.disc;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DVD; // Corrected import for DVD
import org.junit.Test; // Added import for JUnit Test
import static org.junit.Assert.assertEquals; // Added import for JUnit Assert

public class TestPassingParameter {
    @Test
    public void testAddMedia() {
        Store store = new Store();
        Media dvd = new DVD(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f); // Corrected to use DVD
        store.addMedia(dvd);
        assertEquals(1, store.getItemsInStore().size());
    }

    @Test
    public void testRemoveMedia() {
        Store store = new Store();
        Media dvd = new DVD(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f); // Corrected to use DVD
        store.addMedia(dvd);
        store.removeMedia(dvd);
        assertEquals(0, store.getItemsInStore().size());
    }

    @Test
    public void testPrintStore() {
        Store store = new Store();
        Media dvd = new DVD(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f); // Corrected to use DVD
        store.addMedia(dvd);
        store.printStore();
        // This test is more of a visual verification as it prints to the console
    }
}
