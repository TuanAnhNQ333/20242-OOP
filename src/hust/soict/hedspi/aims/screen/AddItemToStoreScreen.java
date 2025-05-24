package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    protected abstract void setupForm();  // mỗi subclass tự triển khai
}
