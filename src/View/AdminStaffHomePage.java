package View;

import Controller.*;
import java.awt.*;
import javax.swing.*;

public class AdminStaffHomePage extends JFrame {
    // Define components for the Admin Staff HomePage
    private JFrame f;
    private JLabel welcomeLabel;
    private JButton registerEmployeeButton;
    private JButton searchEmployeeButton;
    private JButton generateReportsButton;

    public AdminStaffHomePage() {
        f = new JFrame("Admin Staff Home Page");
        f.setLayout(new BorderLayout());

        // Welcome message
        welcomeLabel = new JLabel("Welcome, Admin Staff!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        f.add(welcomeLabel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        registerEmployeeButton = new JButton("Register Employee");
        searchEmployeeButton = new JButton("Search Employee");
        generateReportsButton = new JButton("Generate Reports");
        buttonPanel.add(registerEmployeeButton);
        buttonPanel.add(searchEmployeeButton);
        buttonPanel.add(generateReportsButton);
        f.add(buttonPanel, BorderLayout.CENTER);

        // Frame settings
        f.setSize(1200, 800);
        f.setLocationRelativeTo(null); // Center the frame
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AdminStaffHomePage();
    }
}
