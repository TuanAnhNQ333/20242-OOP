package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DVD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AIMS - Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreItem = new JMenuItem("View store");
        // Placeholder for future: Go to view store screen (this screen)
        menu.add(viewStoreItem);

        JMenuItem viewCartItem = new JMenuItem("View cart");
        viewCartItem.addActionListener(e -> {
            // Dispose current screen or hide it
            this.dispose(); 
            // Open CartScreen (You would need to implement CartScreen.java)
            new CartScreen(cart, store); 
        });
        menu.add(viewCartItem);


        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        // Example: smUpdateStore.add(createUpdateStoreMenuItem("Add Book", "Book"));
        smUpdateStore.add(addBookItem);
        JMenuItem addCDItem = new JMenuItem("Add CD");
        smUpdateStore.add(addCDItem);
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            // Open AddDigitalVideoDiscToStoreScreen
            // You would need to implement AddDigitalVideoDiscToStoreScreen.java
             new AddDigitalVideoDiscToStoreScreen(store);
        });
        smUpdateStore.add(addDVDItem);


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        menuBar.add(smUpdateStore);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        cartButton.addActionListener(e -> {
            this.dispose();
            new CartScreen(cart, store);
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 10, 10)); // 3 items per row, adjust as needed

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            center.add(new MediaStore(media, cart)); // MediaStore is a JPanel for each item
        }
        return center;
    }
}
