package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD");
        setupForm();
    }

    @Override
    protected void setupForm() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JTextField tfId = new JTextField();
        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfArtist = new JTextField();
        JTextField tfCost = new JTextField();
        JTextField tfTracks = new JTextField();

        panel.add(new JLabel("ID:")); panel.add(tfId);
        panel.add(new JLabel("Title:")); panel.add(tfTitle);
        panel.add(new JLabel("Category:")); panel.add(tfCategory);
        panel.add(new JLabel("Artist:")); panel.add(tfArtist);
        panel.add(new JLabel("Cost:")); panel.add(tfCost);
        panel.add(new JLabel("Tracks (format: name:length,...):")); panel.add(tfTracks);

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> {
            try {
                CompactDisc cd = new CompactDisc(
                        Integer.parseInt(tfId.getText()),
                        tfTitle.getText(),
                        tfCategory.getText(),
                        tfArtist.getText(),
                        Float.parseFloat(tfCost.getText())
                );
                Arrays.stream(tfTracks.getText().split(","))
                        .map(String::trim)
                        .forEach(s -> {
                            String[] parts = s.split(":");
                            if (parts.length == 2) {
                                String name = parts[0];
                                int length = Integer.parseInt(parts[1]);
                                cd.addTrack(new Track(name, length));
                            }
                        });
                store.addMedia(cd);
                JOptionPane.showMessageDialog(this, "CD added!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers for ID, Cost and Track lengths",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(addBtn);
        add(panel);
    }
}
