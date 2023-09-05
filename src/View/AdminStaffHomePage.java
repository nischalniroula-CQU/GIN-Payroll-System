package View;

import Controller.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Locale;


public class AdminStaffHomePage extends JFrame implements ActionListener {
    // Define components for the Admin Staff HomePage
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Font f,f1,f2;
    JPanel p1;
    
    AdminStaffHomePage() {
        
        super("Admin Home Page");
        setSize(1200,800);
        setLocation(0,0);
        
                //fonts
        f=new Font("Lucida Fax",Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f1=new Font("MS UI Gothic",Font.BOLD,18);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("View/Icon/ahomepage.jpg"));
        Image img=ic.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        
        JMenuBar m1 = new JMenuBar();
       JMenu men1 = new JMenu("Employee");
       JMenuItem men1item1 = new JMenuItem ("Register New Employee");
       
       JMenu men2 = new JMenu("Search");
       JMenuItem men2item1 = new JMenuItem ("Search Employee");
       
       JMenu men3 = new JMenu("Report");
       JMenuItem men3item1 = new JMenuItem ("View Payroll Information");
       
        //Adding MenuItem in Menu
        men1.add(men1item1);
        men2.add(men2item1);
        men3.add(men3item1);
        
        //Adding Menu in menubar
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        
        //Updatefonts
        
        //Adding Background to the menu
        m1.setBackground(Color.BLACK);
        
        men1.setForeground(Color.WHITE);
        men2.setForeground(Color.WHITE);
        men3.setForeground(Color.WHITE);
        
        //Updating color of the menu items
          men1item1.setBackground(Color.WHITE); 
          men2item1.setBackground(Color.WHITE); 
          men3item1.setBackground(Color.WHITE);
          
          men1item1.setForeground(Color.BLACK);  
          men2item1.setForeground(Color.BLACK); 
          men3item1.setForeground(Color.BLACK); 
          
          setJMenuBar(m1);
          add(l1);
       
    }

    public static void main(String[] args) {
        new AdminStaffHomePage().setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
