package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book");
        setupForm();
    }

    @Override
    protected void setupForm() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField tfId = new JTextField();
        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfCost = new JTextField();
        JTextField tfAuthors = new JTextField();

        panel.add(new JLabel("ID:")); panel.add(tfId);
        panel.add(new JLabel("Title:")); panel.add(tfTitle);
        panel.add(new JLabel("Category:")); panel.add(tfCategory);
        panel.add(new JLabel("Cost:")); panel.add(tfCost);
        panel.add(new JLabel("Authors (comma-separated):")); panel.add(tfAuthors);

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> {
            Book book = new Book(
                    Integer.parseInt(tfId.getText()),
                    tfTitle.getText(),
                    tfCategory.getText(),
                    Float.parseFloat(tfCost.getText())
            );
            Arrays.stream(tfAuthors.getText().split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .forEach(book::addAuthor);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added!");
        });

        panel.add(addBtn);
        add(panel);
    }
}
