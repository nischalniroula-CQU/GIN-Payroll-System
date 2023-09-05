/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author nischalniroula
 */
public class LoginPage extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    JComboBox<String> roleComboBox;
    
    LoginPage()
    {
        
        f=new JFrame("Welcome to GIN Payroll System");
        
        f.setBackground(Color.white);
        f.setLayout(null);
        
        roleComboBox = new JComboBox<>(new String[]{"Employee", "Admin Staff"});
        roleComboBox.setBounds(40, 20, 150, 30);
        f.add(roleComboBox);


        l1 = new JLabel("Username");
        l1.setBounds(40,70,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,120,100,30);
        f.add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,70,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,120,150,30);
        f.add(t2);
        

        b1 = new JButton("Login");
        b1.setBounds(40,170,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        //b1.setBackground(Color.BLACK);
        b1.setForeground(Color.DARK_GRAY);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,170,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setForeground(Color.DARK_GRAY);
        f.add(b2);
        b2.addActionListener(this);
        

        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(500,250);
        f.setLocation(400,300);
    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
        try {
            String username = t1.getText();
            String password = t2.getText();
            String selectedRole = roleComboBox.getSelectedItem().toString(); 

            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM logindata WHERE username='" + username + "' AND password='" + password + "' AND role='" + selectedRole + "'";
            ResultSet rs = obj.stm.executeQuery(q);

            if (rs.next()) {
                if (selectedRole.equals("Employee")) {
                    new EmployeeHomePage().setVisible(true);
                    f.setVisible(false);
                    
                } else if (selectedRole.equals("Admin Staff")) {
                    new AdminStaffHomePage().setVisible(true);
                    f.setVisible(false);
                }
                f.setVisible(false); 
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Login. Please check role, username and password.");
                t1.setText(""); 
                t2.setText(""); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    if (ee.getSource() == b2) {
        this.f.setVisible(false);
    }

    }
    public static void main(String[] args) 
    {
        new LoginPage();
    }

}
