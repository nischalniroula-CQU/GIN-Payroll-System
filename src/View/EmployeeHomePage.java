package View;

import Controller.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Locale;

public class EmployeeHomePage extends JFrame {
    // Define components for the Employee HomePage
    private JFrame f;
    private JLabel welcomeLabel;
    private JButton viewProfileButton;
    private JButton enterHoursButton;
    private JButton viewPayslipButton;

    public EmployeeHomePage() {
        f = new JFrame("Employee Home Page");
        f.setLayout(new BorderLayout());

        // Welcome message
        welcomeLabel = new JLabel("Welcome, Employee!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        f.add(welcomeLabel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        viewProfileButton = new JButton("View Profile");
        enterHoursButton = new JButton("Enter Hours");
        viewPayslipButton = new JButton("View Payslip");
        buttonPanel.add(viewProfileButton);
        buttonPanel.add(enterHoursButton);
        buttonPanel.add(viewPayslipButton);
        f.add(buttonPanel, BorderLayout.CENTER);

        // Frame settings
        f.setSize(1200, 800);
        f.setLocationRelativeTo(null); // Center the frame
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new EmployeeHomePage();
    }
}
