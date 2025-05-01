package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private final Media media;
    private static final String CURRENCY_SYMBOL = "$";
    private static final String PLAY_BUTTON_TEXT = "Play";
    private static final String PLAYING_MEDIA_TITLE = "Playing Media";

    public MediaStore(Media media) {
        this.media = media;
        initializeLayout();
        addComponents();
    }

    private void initializeLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void addComponents() {
        add(Box.createVerticalGlue());
        add(createCenteredLabel(media.getTitle()));
        add(createCenteredLabel(media.getCost() + CURRENCY_SYMBOL));
        
        if (media instanceof Playable) {
            add(createPlayButton());
        }
        
        add(Box.createVerticalGlue());
    }

    private JLabel createCenteredLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(CENTER_ALIGNMENT);
        return label;
    }

    private JButton createPlayButton() {
        JButton playBtn = new JButton(PLAY_BUTTON_TEXT);
        playBtn.setAlignmentX(CENTER_ALIGNMENT);
        playBtn.addActionListener(e -> showPlayDialog());
        return playBtn;
    }

    private void showPlayDialog() {
        JOptionPane.showMessageDialog(
            this,
            String.format("%s\nLength: %d", media.getTitle(), ((Playable) media).getLength()),
            PLAYING_MEDIA_TITLE,
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
