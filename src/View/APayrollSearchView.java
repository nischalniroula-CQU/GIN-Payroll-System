package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class APayrollSearchView extends JFrame {
    private JFrame frame;
    private JTextField startYearField, startMonthField, startDayField,
            endYearField, endMonthField, endDayField;
    private JButton b1, b2;

    public APayrollSearchView() {
        frame = new JFrame("Search Payslip");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel img = new JLabel();
        img.setBounds(0, 0, 500, 350);
        img.setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("View/Icon/searchpayslipreport.jpg"));
        img.setIcon(img1);
        frame.add(img);

        // Start Date
        JLabel id2 = new JLabel("Start Date:");
        id2.setBounds(50, 50, 150, 25);
        id2.setFont(new Font("Poppins", Font.PLAIN, 20));
        id2.setForeground(Color.WHITE);
        img.add(id2);

        startYearField = new JTextField();
        startYearField.setBounds(110, 85, 80, 30);
        img.add(startYearField);

        JLabel startYearLabel = new JLabel("Year:");
        startYearLabel.setBounds(50, 90, 60, 15);
        startYearLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        startYearLabel.setForeground(Color.WHITE);
        img.add(startYearLabel);

        startMonthField = new JTextField();
        startMonthField.setBounds(260, 85, 60, 30);
        img.add(startMonthField);

        JLabel startMonthLabel = new JLabel("Month:");
        startMonthLabel.setBounds(200, 90, 60, 15);
        startMonthLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        startMonthLabel.setForeground(Color.WHITE);
        img.add(startMonthLabel);

        startDayField = new JTextField();
        startDayField.setBounds(410, 85, 60, 30);
        img.add(startDayField);

        JLabel startDayLabel = new JLabel("Day:");
        startDayLabel.setBounds(350, 90, 60, 15);
        startDayLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        startDayLabel.setForeground(Color.WHITE);
        img.add(startDayLabel);

        // End Date
        JLabel id3 = new JLabel("End Date:");
        id3.setBounds(50, 140, 150, 25);
        id3.setFont(new Font("Poppins", Font.PLAIN, 20));
        id3.setForeground(Color.WHITE);
        img.add(id3);

        endYearField = new JTextField();
        endYearField.setBounds(110, 175, 80, 30);
        img.add(endYearField);

        JLabel endYearLabel = new JLabel("Year:");
        endYearLabel.setBounds(50, 180, 60, 15);
        endYearLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        endYearLabel.setForeground(Color.WHITE);
        img.add(endYearLabel);

        endMonthField = new JTextField();
        endMonthField.setBounds(260, 175, 60, 30);
        img.add(endMonthField);

        JLabel endMonthLabel = new JLabel("Month:");
        endMonthLabel.setBounds(200, 180, 60, 15);
        endMonthLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        endMonthLabel.setForeground(Color.WHITE);
        img.add(endMonthLabel);

        endDayField = new JTextField();
        endDayField.setBounds(410, 175, 60, 30);
        img.add(endDayField);

        JLabel endDayLabel = new JLabel("Day:");
        endDayLabel.setBounds(350, 180, 60, 15);
        endDayLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        endDayLabel.setForeground(Color.WHITE);
        img.add(endDayLabel);

        // Buttons
        b1 = new JButton("Submit");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(50, 250, 150, 40);
        b1.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK);
        b2.setBounds(225, 250, 150, 40);
        b2.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(b2);

        frame.setSize(500, 350);
        frame.setLocation(450, 250);
        frame.setVisible(true);
    }

    public void addSubmitButtonListener(ActionListener listener) {
        b1.addActionListener(listener);
    }

    public void addCancelButtonListener(ActionListener listener) {
        b2.addActionListener(listener);
    }

    public String getStartYear() {
        return startYearField.getText();
    }

    public String getStartMonth() {
        return startMonthField.getText();
    }

    public String getStartDay() {
        return startDayField.getText();
    }

    public String getEndYear() {
        return endYearField.getText();
    }

    public String getEndMonth() {
        return endMonthField.getText();
    }

    public String getEndDay() {
        return endDayField.getText();
    }
}
