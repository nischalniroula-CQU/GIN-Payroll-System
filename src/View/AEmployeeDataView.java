package View;

import javax.swing.*;
import java.awt.*;

public class AEmployeeDataView {
    private JFrame frame;
    private JTextField nameField, dobField, phoneField, emailField, addressField, positionField;
    private JButton saveButton, cancelButton;

    public AEmployeeDataView(String e_id, String name, String dob, String phone, String email, String address, String position) {
        frame = new JFrame("Employee Details");
        frame.setSize(1200, 800);
        frame.setLocation(300, 100);
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);

        JLabel img = new JLabel();
        img.setBounds(0, 0, 1200, 800);
        img.setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("View/Icon/ainnerpage.jpg"));
        img.setIcon(img1);
        frame.add(img);

        JLabel id1 = new JLabel("Details for Employee Id: " + e_id);
        id1.setBounds(50, 50, 500, 50);
        id1.setFont(new Font("Poppins", Font.BOLD, 20));
        id1.setForeground(Color.WHITE);
        img.add(id1);

        JLabel id2 = new JLabel("Name:");
        id2.setBounds(50, 150, 100, 15);
        id2.setFont(new Font("Poppins", Font.PLAIN, 20));
        id2.setForeground(Color.WHITE);
        img.add(id2);

        nameField = new JTextField(name);
        nameField.setBounds(150, 150, 150, 25);
        nameField.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(nameField);

        JLabel id3 = new JLabel("DOB:");
        id3.setBounds(600, 150, 100, 15);
        id3.setFont(new Font("Poppins", Font.PLAIN, 20));
        id3.setForeground(Color.WHITE);
        img.add(id3);

        dobField = new JTextField(dob);
        dobField.setBounds(700, 150, 100, 25);
        dobField.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(dobField);

        JLabel id4 = new JLabel("Phone:");
        id4.setBounds(50, 225, 100, 15);
        id4.setFont(new Font("Poppins", Font.PLAIN, 20));
        id4.setForeground(Color.WHITE);
        img.add(id4);

        phoneField = new JTextField(phone);
        phoneField.setBounds(150, 225, 100, 25);
        phoneField.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(phoneField);

        JLabel id5 = new JLabel("Email:");
        id5.setBounds(600, 225, 100, 15);
        id5.setFont(new Font("Poppins", Font.PLAIN, 20));
        id5.setForeground(Color.WHITE);
        img.add(id5);

        emailField = new JTextField(email);
        emailField.setBounds(700, 225, 200, 25);
        emailField.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(emailField);

        JLabel id6 = new JLabel("Address:");
        id6.setBounds(50, 300, 100, 15);
        id6.setFont(new Font("Poppins", Font.PLAIN, 20));
        id6.setForeground(Color.WHITE);
        img.add(id6);

        addressField = new JTextField(address);
        addressField.setBounds(150, 300, 250, 25);
        addressField.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(addressField);

        JLabel id7 = new JLabel("Position:");
        id7.setBounds(600, 300, 100, 15);
        id7.setFont(new Font("Poppins", Font.PLAIN, 20));
        id7.setForeground(Color.WHITE);
        img.add(id7);

        positionField = new JTextField(position);
        positionField.setBounds(700, 300, 150, 25);
        positionField.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(positionField);

        saveButton = new JButton("Save");
        saveButton.setForeground(Color.BLACK);
        saveButton.setBounds(50, 450, 150, 40);
        saveButton.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(saveButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBounds(225, 450, 150, 40);
        cancelButton.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(cancelButton);

        frame.setVisible(true);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getDobField() {
        return dobField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JTextField getPositionField() {
        return positionField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JFrame getFrame() {
        return frame;
    }
}
