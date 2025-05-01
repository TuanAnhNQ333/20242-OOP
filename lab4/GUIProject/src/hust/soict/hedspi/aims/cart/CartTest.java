package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        Book book = new Book(3, "Clean Code", "Programming", 30.0f);
        book.addAuthor("Robert C. Martin");

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(book);

        System.out.println("\n--- Giỏ hàng hiện tại ---");
        cart.printCart();

        System.out.println("\n--- Sắp xếp theo Title rồi Cost ---");
        cart.sortByTitleCost();
        cart.printCart();

        System.out.println("\n--- Tìm kiếm theo title 'Star' ---");
        cart.searchByTitle("Star").forEach(System.out::println);

        System.out.println("\n--- Tìm kiếm theo ID = 3 ---");
        Media m = cart.searchById(3);
        if (m != null) System.out.println("Tìm thấy: " + m.getTitle());
        else System.out.println("Không tìm thấy.");
    }
}
