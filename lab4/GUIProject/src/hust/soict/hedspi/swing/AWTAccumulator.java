package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
    private Label lblInput;
    private TextField tfInput;
    private Label lblOutput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout());
        
        lblInput = new Label("Enter an Integer: ");
        add(lblInput);
        
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);

        lblOutput = new Label("The Accumulated Sum is: ");
        add(lblOutput);
        
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);
        
        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn;
                tfInput.setText("");
                tfOutput.setText(sum + "");
            }
        });
        
        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AWTAccumulator();
    }
    
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn;
                tfInput.setText("");
                tfOutput.setText(sum + "");
            
        }
    }
}
