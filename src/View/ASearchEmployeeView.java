package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ASearchEmployeeView {
    private JFrame frame;
    private JTextField textField;
    private JButton searchButton;
    private JButton cancelButton;

    public ASearchEmployeeView() {
        frame = new JFrame("Search Employee");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 500, 250);
        backgroundLabel.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("View/Icon/loginbg.jpg"));
        Image img1 = img.getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img1);
        backgroundLabel.setIcon(ic1);

        JLabel employeeIdLabel = new JLabel("Employee Id: ");
        employeeIdLabel.setVisible(true);
        employeeIdLabel.setBounds(40, 50, 250, 30);
        employeeIdLabel.setForeground(Color.WHITE);
        Font font = new Font("Poppins", Font.BOLD, 20);
        employeeIdLabel.setFont(font);
        backgroundLabel.add(employeeIdLabel);

        textField = new JTextField();
        textField.setBounds(40, 100, 220, 30);
        backgroundLabel.add(textField);

        searchButton = new JButton("Search");
        searchButton.setBounds(40, 150, 100, 30);
        searchButton.setBackground(Color.GREEN);
        searchButton.setForeground(Color.BLACK);
        backgroundLabel.add(searchButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 150, 100, 30);
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.BLACK);
        backgroundLabel.add(cancelButton);

        frame.add(backgroundLabel);
        frame.setSize(500, 250);
        frame.setLocation(450, 250);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
