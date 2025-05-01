package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AIMS - Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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

        JMenu smUpdate = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> new AddBookToStoreScreen(store));
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store));
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));

        smUpdate.add(addBook);
        smUpdate.add(addCD);
        smUpdate.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });

        menu.add(smUpdate);
        menu.add(viewStore);

        JMenuBar mb = new JMenuBar();
        mb.add(menu);
        return mb;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS Store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }
        return center;
    }
}
