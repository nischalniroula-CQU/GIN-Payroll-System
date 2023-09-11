package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeHomePageView extends JFrame {
    
    private String e_id;
    private JMenuItem men1item1;
    private JMenuItem men2item1;
    private JMenuItem men3item1;

    public EmployeeHomePageView(String e_id) {
        super("Employee Home Page");
        setSize(1200, 800);
        setLocation(0, 0);
        
        this.e_id = e_id;

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("View/Icon/ehomepage.jpg"));
        Image img = ic.getImage().getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel l1 = new JLabel(ic1);

        // Menu and Menu Item
        JMenuBar m1 = new JMenuBar();
        JMenu men1 = new JMenu("Schedule");
        men1item1 = new JMenuItem("Update Hours");

        JMenu men2 = new JMenu("Payslip");
        men2item1 = new JMenuItem("View Payslip");

        JMenu men3 = new JMenu("Profile");
        men3item1 = new JMenuItem("Edit Profile");

        JMenu men4 = new JMenu("Exit");

        // Adding MenuItem in Menu
        men1.add(men1item1);
        men2.add(men2item1);
        men3.add(men3item1);

        // Adding Menu in menubar
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);

        // Adding Background to the menu
        m1.setBackground(Color.DARK_GRAY);

        men1.setForeground(Color.WHITE);
        men2.setForeground(Color.WHITE);
        men3.setForeground(Color.WHITE);
        men4.setForeground(Color.RED);

        // Updating color of the menu items
        men1item1.setBackground(Color.WHITE);
        men2item1.setBackground(Color.WHITE);
        men3item1.setBackground(Color.WHITE);

        men1item1.setForeground(Color.BLACK);
        men2item1.setForeground(Color.BLACK);
        men3item1.setForeground(Color.BLACK);

        setJMenuBar(m1);
        add(l1);
    }
    
    public void addMenuItemListener(ActionListener listener) {
        // Add ActionListener to menu items
        men1item1.addActionListener(listener);
        men2item1.addActionListener(listener);
        men3item1.addActionListener(listener);
    }

    public static void main(String[] args) {
        new EmployeeHomePageView("Print Data").setVisible(true);
    }
}