package hust.soict.hedspi.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGrid extends JFrame {
    private static final int GRID_SIZE = 10;
    private final JButton[] btnNumbers = new JButton[GRID_SIZE];
    private JButton btnDelete, btnReset;
    private final JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField(10);
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tfDisplay.setEditable(false);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("NumberGrid");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();
        
        // Add numbers 1-9
        for (int i = 1; i < GRID_SIZE; i++) {
            btnNumbers[i] = createButton(String.valueOf(i), btnListener);
            panelButtons.add(btnNumbers[i]);
        }
        
        // Add Delete button
        btnDelete = createButton("DEL", btnListener);
        panelButtons.add(btnDelete);
        
        // Add 0
        btnNumbers[0] = createButton("0", btnListener);
        panelButtons.add(btnNumbers[0]);
        
        // Add Reset button
        btnReset = createButton("C", btnListener);
        panelButtons.add(btnReset);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (Character.isDigit(button.charAt(0))) {
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (button.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(NumberGrid::new);
    }
}