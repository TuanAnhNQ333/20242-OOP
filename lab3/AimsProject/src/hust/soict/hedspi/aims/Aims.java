package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media; 
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);

        store.wait();
        store.wait(new Book(2, "Effective Java", "Programming", 45.00f).getId());

        int choice;
        do {
            showMainMenu();
            choice = sc.nextInt();
            sc.nextLine(); // bỏ dòng trống
            switch (choice) {
                case 1:
                    store.printStore();
                    break;
                case 2:
                    System.out.println("Enter media title to add to cart:");
                    String title = sc.nextLine();
                    Media found = store.searchByTitle(title);
                    if (found != null) {
                        cart.addMedia(found);
                        System.out.println("Added to cart.");
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3:
                    cart.printCart();
                    break;
                case 4:
                    System.out.println("Enter title of media to remove from cart:");
                    String removeTitle = sc.nextLine();
                    Media mediaToRemove = cart.searchByTitle(removeTitle);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                        System.out.println("Removed.");
                    } else {
                        System.out.println("Not found in cart.");
                    }
                    break;
                case 5:
                    System.out.println("Enter title to play:");
                    String playTitle = sc.nextLine();
                    Media mediaToPlay = store.searchByTitle(playTitle);
                    if (mediaToPlay instanceof Playable) {
                        ((Playable) mediaToPlay).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 6:
                    System.out.println("Placing order...");
                    cart.printCart();
                    System.out.println("Thank you! Order placed.");
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }

    public static void showMainMenu() {
        System.out.println("\n===== AIMS MENU =====");
        System.out.println("1. View Store");
        System.out.println("2. Add media to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Remove media from Cart");
        System.out.println("5. Play a media");
        System.out.println("6. Place Order");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }
}
