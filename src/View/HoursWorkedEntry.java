package View;

import javax.swing.*;
import java.awt.*;

public class HoursWorkedEntry {
    private JFrame frame;
    private JTextField employeeIdField, weekEndingDateField;
    private JTextField[] hoursWorkedFields;
    private JButton submitButton;

    public HoursWorkedEntry() {
        frame = new JFrame("Enter Hours Worked");
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocation(300, 100);
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);

        JLabel img = new JLabel();
        img.setBounds(0, 0, 800, 600);
        img.setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("View/Icon/your_image.jpg"));
        img.setIcon(img1);
        frame.add(img);

        JLabel id1 = new JLabel("Employee ID:");
        id1.setBounds(50, 50, 150, 25);
        id1.setFont(new Font("Poppins", Font.PLAIN, 20));
        id1.setForeground(Color.BLACK);
        img.add(id1);

        employeeIdField = new JTextField();
        employeeIdField.setBounds(200, 50, 200, 25);
        employeeIdField.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(employeeIdField);

        JLabel id2 = new JLabel("Week Ending Date (YYYY-MM-DD):");
        id2.setBounds(50, 100, 300, 25);
        id2.setFont(new Font("Poppins", Font.PLAIN, 20));
        id2.setForeground(Color.BLACK);
        img.add(id2);

        weekEndingDateField = new JTextField();
        weekEndingDateField.setBounds(350, 100, 200, 25);
        weekEndingDateField.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(weekEndingDateField);

        JLabel id3 = new JLabel("Hours Worked (per day):");
        id3.setBounds(50, 150, 250, 25);
        id3.setFont(new Font("Poppins", Font.PLAIN, 20));
        id3.setForeground(Color.BLACK);
        img.add(id3);

        hoursWorkedFields = new JTextField[7];
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i = 0; i < 7; i++) {
            JLabel dayLabel = new JLabel(daysOfWeek[i] + ":");
            dayLabel.setBounds(50, 200 + i * 50, 100, 25);
            dayLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
            dayLabel.setForeground(Color.BLACK);
            img.add(dayLabel);

            hoursWorkedFields[i] = new JTextField();
            hoursWorkedFields[i].setBounds(150, 200 + i * 50, 100, 25);
            hoursWorkedFields[i].setFont(new Font("Poppins", Font.PLAIN, 15));
            img.add(hoursWorkedFields[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.setForeground(Color.BLACK);
        submitButton.setBounds(50, 500, 150, 40);
        submitButton.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(submitButton);
    }

    public JTextField getEmployeeIdField() {
        return employeeIdField;
    }

    public JTextField getWeekEndingDateField() {
        return weekEndingDateField;
    }

    public JTextField[] getHoursWorkedFields() {
        return hoursWorkedFields;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JFrame getFrame() {
        return frame;
    }
}
