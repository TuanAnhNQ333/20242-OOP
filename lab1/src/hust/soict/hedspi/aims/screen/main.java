package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class main {
    public static void main(String[] args) {
        Store store = new Store();

        // Thêm DVD
        store.addMedia(new DVD(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));

        // Thêm Book
        Book book = new Book(2, "The Art of War", "Philosophy", 10.99f);
        book.addAuthor("Sun Tzu");
        store.addMedia(book);

        // Thêm CD
        CD cd = new CD(3, "Greatest Hits", "Pop", "Adele", 29.99f);
        cd.addTrack(new Track("Hello", 4));
        cd.addTrack(new Track("Someone Like You", 5));
        store.addMedia(cd);

        new StoreScreen(store, new Cart());
    }
}
