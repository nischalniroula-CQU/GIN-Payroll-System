package View;

import Controller.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Locale;


public class EmployeeHomePage extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Font f,f1,f2;
    JPanel p1;
    
    public EmployeeHomePage()
    {
        super("Employee Home Page");
        setSize(1200,800);
        setLocation(0,0);
        
       
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("View/Icon/ehomepage.jpg"));
        Image img=ic.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        //System.out.println(ic.exists());
        
        
       
       //Menu and Menu Item
       
       JMenuBar m1 = new JMenuBar();
       JMenu men1 = new JMenu("Schedule");
       JMenuItem men1item1 = new JMenuItem ("Update Hours");
       
       JMenu men2 = new JMenu("Roaster");
       JMenuItem men2item1 = new JMenuItem ("View Roaster");
       
       JMenu men3 = new JMenu("Profile");
       JMenuItem men3item1 = new JMenuItem ("Edit Profile");
       
       JMenu men4 = new JMenu("Exit");
       
        //Adding MenuItem in Menu
        men1.add(men1item1);
        men2.add(men2item1);
        men3.add(men3item1);
        
        //Adding Menu in menubar
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        
        //Updatefonts
        
        //Adding Background to the menu
        m1.setBackground(Color.DARK_GRAY);
        
        men1.setForeground(Color.WHITE);
        men2.setForeground(Color.WHITE);
        men3.setForeground(Color.WHITE);
        men4.setForeground(Color.RED);
        
        //Updating color of the menu items
          men1item1.setBackground(Color.WHITE); 
          men2item1.setBackground(Color.WHITE); 
          men3item1.setBackground(Color.WHITE);
          
          men1item1.setForeground(Color.BLACK);  
          men2item1.setForeground(Color.BLACK); 
          men3item1.setForeground(Color.BLACK); 
          
          
          men1item1.addActionListener(this);
          men2item1.addActionListener(this);
          men3item1.addActionListener(this);
          men4.addActionListener(this);
          
          setJMenuBar(m1);
          add(l1);
          
    }

    public void actionPerformed(ActionEvent e) {
        
        String comnd=e.getActionCommand();
        
        if(comnd.equals("Update Hours"))
        {
            new EUpdateHours();
        }
        else if (comnd.equals("View Roaster"))
        {
            new EViewRoaster();
        }
        
        else if (comnd.equals("Edit Profile"))
            
        {
            new EEditProfile();
        }
        else if (comnd.equals("Exit"))
        {
            System.exit(0);
        }
        
    }
    
    
    
}