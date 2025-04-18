package hust.soict.hedspi.test;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StoreTest {
    @Test
    public void testAddMedia() {
        Store store = new Store();
        Media dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd);
        assertEquals(1, store.getItemsInStore().size());
    }

    @Test
    public void testRemoveMedia() {
        Store store = new Store();
        Media dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd);
        store.removeMedia(dvd);
        assertEquals(0, store.getItemsInStore().size());
    }

    @Test
    public void testPrintStore() {
        Store store = new Store();
        Media dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd);
        store.printStore();
        // This test is more of a visual verification as it prints to the console
    }
}
