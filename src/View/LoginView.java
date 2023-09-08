package View;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JComboBox<String> roleComboBox;
    private JLabel l1, l2, l3;
    private JTextField t1;
    private JPasswordField t2;
    private JButton b1, b2;

    public LoginView() {
        setTitle("Welcome to GIN Payroll System");
        setLayout(null);
        

        roleComboBox = new JComboBox<>(new String[]{"Employee", "Admin Staff"});
        roleComboBox.setBounds(40, 20, 150, 30);
        add(roleComboBox);

        l1 = new JLabel("Username");
        l1.setBounds(40, 70, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 120, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 70, 150, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 120, 150, 30);
        add(t2);

        b1 = new JButton("Login");
        b1.setBounds(40, 170, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setForeground(Color.DARK_GRAY);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 170, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setForeground(Color.DARK_GRAY);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setSize(500, 250);
        setLocation(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }

    public JComboBox<String> getRoleComboBox() {
        return roleComboBox;
    }

    public JTextField getUsernameField() {
        return t1;
    }

    public JPasswordField getPasswordField() {
        return t2;
    }

    public JButton getLoginButton() {
        return b1;
    }

    public JButton getCancelButton() {
        return b2;
    }
}
