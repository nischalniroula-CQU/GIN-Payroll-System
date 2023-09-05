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
    
    EmployeeHomePage()
    {
        super("Employee Home Page");
        setSize(1200,800);
        setLocation(0,0);
        
        //fonts
        f=new Font("Lucida Fax",Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f1=new Font("MS UI Gothic",Font.BOLD,18);
        
       
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("View/Icon/ehomepage.jpg"));
        Image img=ic.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        //System.out.println(ic.exists());
        
        
       
       //Menu and Menu Item
       
       JMenuBar m1 = new JMenuBar();
       JMenu men1 = new JMenu("Schedule");
       JMenuItem men1item1 = new JMenuItem ("Update Hours");
       
       JMenu men2 = new JMenu("Roster");
       JMenuItem men2item1 = new JMenuItem ("View Roaster");
       
       JMenu men3 = new JMenu("Profile");
       JMenuItem men3item1 = new JMenuItem ("Edit Profile");
       
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
        m1.setBackground(Color.DARK_GRAY);
        
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

    public void actionPerformed(ActionEvent e) {
        
    }
    
    public static void main (String[] args){
        new EmployeeHomePage().setVisible(true);
    }
    
}





/*

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

*/