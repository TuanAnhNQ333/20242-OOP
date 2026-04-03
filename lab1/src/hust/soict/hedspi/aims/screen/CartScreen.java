package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store; // Import Store for navigation

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections; // For sorting

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store; // Keep a reference to the store for navigation back

    // Components that might need to be updated
    private JPanel centerPanel;
    private JLabel totalCostLabel;

    public CartScreen(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        centerPanel = createCenter(); // Store reference to update
        cp.add(new JScrollPane(centerPanel), BorderLayout.CENTER); // Make it scrollable
        cp.add(createSouth(), BorderLayout.SOUTH);

        setTitle("Cart");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose when closed to go back
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
        viewStoreItem.addActionListener(e -> {
            this.dispose(); // Close cart screen
            new StoreScreen(store, cart); // Reopen store screen
        });
        menu.add(viewStoreItem);

        JMenuItem viewCartItem = new JMenuItem("View cart");
        // Already in cart screen, could refresh or do nothing
        menu.add(viewCartItem);

        JMenu smUpdateStore = new JMenu("Update Store");
        // (Add items as in StoreScreen if admin features are accessible from cart)
        // For simplicity, we might not allow store updates directly from cart view for a customer.

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        // menuBar.add(smUpdateStore); // Optional

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS Cart");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.ORANGE); // Different color for cart

        JButton storeButton = new JButton("View Store");
        storeButton.setPreferredSize(new Dimension(120, 50));
        storeButton.setMaximumSize(new Dimension(120, 50));
        storeButton.addActionListener(e -> {
            this.dispose();
            new StoreScreen(store, cart);
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(storeButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical list of items

        if (cart.getItemsOrdered().isEmpty()) {
            panel.add(new JLabel("Your cart is empty."));
            return panel;
        }

        for (Media media : cart.getItemsOrdered()) {
            panel.add(createMediaCell(media));
            panel.add(Box.createRigidArea(new Dimension(0,10))); // Spacing
        }
        return panel;
    }
    
    void refreshCenterPanel() {
        centerPanel.removeAll();
        if (cart.getItemsOrdered().isEmpty()) {
            centerPanel.add(new JLabel("Your cart is empty."));
        } else {
            for (Media media : cart.getItemsOrdered()) {
                centerPanel.add(createMediaCell(media));
                centerPanel.add(Box.createRigidArea(new Dimension(0,10)));
            }
        }
        totalCostLabel.setText("Total Cost: " + String.format("%.2f", cart.totalCost()) + " $");
        centerPanel.revalidate();
        centerPanel.repaint();
    }


    JPanel createMediaCell(Media media) {
        JPanel cell = new JPanel(new BorderLayout(10,0));
        cell.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        cell.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100)); // Control height

        JLabel titleLabel = new JLabel(media.getTitle() + " (" + media.getCategory() + ")");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 16));
        
        JLabel costLabel = new JLabel(String.format("%.2f $", media.getCost()));

        cell.add(titleLabel, BorderLayout.CENTER);
        cell.add(costLabel, BorderLayout.EAST);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(e -> {
            cart.removeMedia(media);
            JOptionPane.showMessageDialog(this, "\"" + media.getTitle() + "\" removed from cart.");
            refreshCenterPanel(); // Update the display
        });
        buttonsPanel.add(btnRemove);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
             btnPlay.addActionListener(e -> {
                JDialog playDialog = new JDialog(this, "Playing: " + media.getTitle(), false); // Modeless
                playDialog.setSize(300,150);
                JLabel playingLabel = new JLabel("Playing " + media.getTitle() + "...");
                playingLabel.setHorizontalAlignment(SwingConstants.CENTER);
                playDialog.add(playingLabel);
                playDialog.setLocationRelativeTo(this); // Relative to CartScreen
                playDialog.setVisible(true);
                // ((Playable) media).play(); // This would typically print to console or trigger actual playback
            });
            buttonsPanel.add(btnPlay);
        }
        cell.add(buttonsPanel, BorderLayout.SOUTH);
        return cell;
    }
    

    JPanel createSouth() {
        JPanel south = new JPanel(new BorderLayout());
        south.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        totalCostLabel = new JLabel("Total Cost: " + String.format("%.2f", cart.totalCost()) + " $");
        totalCostLabel.setFont(new Font(totalCostLabel.getFont().getName(), Font.BOLD, 20));
        totalCostLabel.setHorizontalAlignment(JLabel.RIGHT);
        south.add(totalCostLabel, BorderLayout.CENTER);

        JButton btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setFont(new Font(btnPlaceOrder.getFont().getName(), Font.BOLD, 18));
        btnPlaceOrder.addActionListener(e -> {
            if (cart.getItemsOrdered().isEmpty()){
                 JOptionPane.showMessageDialog(this, "Your cart is empty. Cannot place order.", "Order Error", JOptionPane.ERROR_MESSAGE);
                 return;
            }
            // Placeholder for order placement logic
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Do you want to place this order?\nTotal: " + String.format("%.2f", cart.totalCost()) + " $", 
                "Confirm Order", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                // Logic to process the order
                JOptionPane.showMessageDialog(this, "Order placed successfully!");
                cart.makeEmpty(); // Empty the cart after placing order
                refreshCenterPanel(); // Update display
            }
        });
        south.add(btnPlaceOrder, BorderLayout.EAST);
        
        // Sorting options
        JPanel sortPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel sortLabel = new JLabel("Sort by:");
        JButton btnSortByTitle = new JButton("Title");
        btnSortByTitle.addActionListener(e -> {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
            refreshCenterPanel();
        });
        JButton btnSortByCost = new JButton("Cost");
        btnSortByCost.addActionListener(e -> {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
            refreshCenterPanel();
        });

        sortPanel.add(sortLabel);
        sortPanel.add(btnSortByTitle);
        sortPanel.add(btnSortByCost);
        south.add(sortPanel, BorderLayout.WEST);


        return south;
    }
    
    // Example main for testing CartScreen (optional)
    // public static void main(String[] args) {
    //     Store store = new Store(); // Dummy store for navigation
    //     Cart cart = new Cart();
        
    //     DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    //     DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
    //     cart.addMedia(dvd1);
    //     cart.addMedia(dvd2);

    //     SwingUtilities.invokeLater(() -> new CartScreen(cart, store));
    // }
}