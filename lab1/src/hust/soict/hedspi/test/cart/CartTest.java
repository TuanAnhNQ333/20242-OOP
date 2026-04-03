package hust.soict.hedspi.aims.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DVD; // Corrected import for DVD
import org.junit.Test; // Added import for JUnit Test
import static org.junit.Assert.assertEquals; // Added import for JUnit Assert

public class CartTest {
    @Test
    public void testAddMedia() {
        Cart cart = new Cart();
        Media dvd = new Book(1, "The Lion King", "Animation", 19.95f);
        cart.addMedia(dvd);
        assertEquals(1, cart.getItemsOrdered().size());
    }
    @Test
    public void testRemoveMedia() {
        Cart cart = new Cart();
        Media book = new Book(2, "Effective Java", "Programming", 45.00f);
        cart.addMedia(book);
        cart.removeMedia(book);
        assertEquals(0, cart.getItemsOrdered().size());
    }

    @Test
    public void testTotalCost() {
        Cart cart = new Cart();
        Media dvd = new DVD(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f); // Corrected to use DVD
        Media book = new Book(2, "Effective Java", "Programming", 45.00f);
        cart.addMedia(dvd);
        cart.addMedia(book);
        assertEquals(64.95f, cart.totalCost(), 0.0);
    }
}
