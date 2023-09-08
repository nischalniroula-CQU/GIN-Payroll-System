package View;

import Controller.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewEmployeeData implements ActionListener {

    JFrame f;
    JLabel img, id, id1, id2, id3, id4, id5, id6, id7;
    JTextField aid2, aid3, aid4, aid5, aid6, aid7;
    JButton b1, b2;
    ImageIcon icon;
    String e_id, name, dob, phone, email, address, position;

    public ViewEmployeeData(String eid) {
        try {
            ConnectionClass obj = new ConnectionClass();
            String s = "select * from employee where id = '" + eid + "'";
            ResultSet rs = obj.stm.executeQuery(s);

            while (rs.next()) {
                name = rs.getString("name");
                dob = rs.getString("dob");
                phone = rs.getString("phone");
                email = rs.getString("email");
                address = rs.getString("address");
                position = rs.getString("position");
                e_id = rs.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        f = new JFrame("Employee Details");
        f.setVisible(true);
        f.setSize(1200, 800);
        f.setLocation(300, 100);
        f.setLayout(null);
        f.setBackground(Color.WHITE);

        img = new JLabel();
        img.setBounds(0, 0, 1200, 800);
        img.setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("View/Icon/ainnerpage.jpg"));
        img.setIcon(img1);
        f.add(img);

        id1 = new JLabel("Details for Employee Id: " + e_id);
        id1.setBounds(50, 50, 500, 50);
        id1.setFont(new Font("Poppins", Font.BOLD, 20));
        id1.setForeground(Color.WHITE);
        img.add(id1);

        id2 = new JLabel("Name:");
        id2.setBounds(50, 150, 100, 15);
        id2.setFont(new Font("Poppins", Font.PLAIN, 20));
        id2.setForeground(Color.WHITE);
        img.add(id2);

        aid2 = new JTextField(name);
        aid2.setBounds(150, 150, 150, 25);
        aid2.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(aid2);

        id3 = new JLabel("DOB:");
        id3.setBounds(600, 150, 100, 15);
        id3.setFont(new Font("Poppins", Font.PLAIN, 20));
        id3.setForeground(Color.WHITE);
        img.add(id3);

        aid3 = new JTextField(dob);
        aid3.setBounds(700, 150, 100, 25);
        aid3.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(aid3);

        id4 = new JLabel("Phone:");
        id4.setBounds(50, 225, 100, 15);
        id4.setFont(new Font("Poppins", Font.PLAIN, 20));
        id4.setForeground(Color.WHITE);
        img.add(id4);

        aid4 = new JTextField(phone);
        aid4.setBounds(150, 225, 100, 25);
        aid4.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(aid4);

        id5 = new JLabel("Email:");
        id5.setBounds(600, 225, 100, 15);
        id5.setFont(new Font("Poppins", Font.PLAIN, 20));
        id5.setForeground(Color.WHITE);
        img.add(id5);

        aid5 = new JTextField(email);
        aid5.setBounds(700, 225, 200, 25);
        aid5.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(aid5);

        id6 = new JLabel("Address:");
        id6.setBounds(50, 300, 100, 15);
        id6.setFont(new Font("Poppins", Font.PLAIN, 20));
        id6.setForeground(Color.WHITE);
        img.add(id6);

        aid6 = new JTextField(address);
        aid6.setBounds(150, 300, 250, 25);
        aid6.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(aid6);

        id7 = new JLabel("Position:");
        id7.setBounds(600, 300, 100, 15);
        id7.setFont(new Font("Poppins", Font.PLAIN, 20));
        id7.setForeground(Color.WHITE);
        img.add(id7);

        aid7 = new JTextField(position);
        aid7.setBounds(700, 300, 150, 25);
        aid7.setFont(new Font("Poppins", Font.PLAIN, 15));
        img.add(aid7);

        b1 = new JButton("Save");
        b1.setForeground(Color.BLACK);
        b1.setBounds(50, 450, 150, 40);
        b1.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(b1);

        b2 = new JButton("Cancel");
        b2.setForeground(Color.BLACK);
        b2.setBounds(225, 450, 150, 40);
        b2.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public static void main(String[] args) {
        new ViewEmployeeData("Print Data");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            // Get the edited values from JTextFields and update the database
            String editedName = aid2.getText();
            String editedDob = aid3.getText();
            String editedPhone = aid4.getText();
            String editedEmail = aid5.getText();
            String editedAddress = aid6.getText();
            String editedPosition = aid7.getText();

            try {
                ConnectionClass obj = new ConnectionClass();
                String updateQuery = "UPDATE employee SET name = '" + editedName + "', dob = '" + editedDob
                        + "', phone = '" + editedPhone + "', email = '" + editedEmail + "', address = '"
                        + editedAddress + "', position = '" + editedPosition + "' WHERE id = '" + e_id + "'";
                obj.stm.executeUpdate(updateQuery);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
            } catch (Exception ex) {
                System.out.println("The error is: " + ex);
            }
        }
        if (e.getSource() == b2) {
            f.setVisible(false);
            new AdminStaffHomePage();
        }
    }
}
