package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.DVD;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD");
        setupForm();
    }

    @Override
    protected void setupForm() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JTextField tfId = new JTextField();
        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfCost = new JTextField();

        panel.add(new JLabel("ID:")); panel.add(tfId);
        panel.add(new JLabel("Title:")); panel.add(tfTitle);
        panel.add(new JLabel("Category:")); panel.add(tfCategory);
        panel.add(new JLabel("Director:")); panel.add(tfDirector);
        panel.add(new JLabel("Length:")); panel.add(tfLength);
        panel.add(new JLabel("Cost:")); panel.add(tfCost);

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> {
            try {
                DVD dvd = new DVD(
                        Integer.parseInt(tfId.getText()),
                        tfTitle.getText(),
                        tfCategory.getText(),
                        tfDirector.getText(),
                        Integer.parseInt(tfLength.getText()),
                        Float.parseFloat(tfCost.getText())
                );
                store.addMedia(dvd);
                JOptionPane.showMessageDialog(this, "DVD Added!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers for ID, Length and Cost",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(addBtn);
        add(panel);
    }
}
