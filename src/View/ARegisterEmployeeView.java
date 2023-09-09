package View;

import javax.swing.*;
import java.awt.*;

public class ARegisterEmployeeView extends JFrame {
    private JFrame f;
    private JLabel id, id1, id2, id3, id4, id5, id6, id7;
    private JTextField t1, t2, t3, t4, t5, t6, t7;
    private JButton b1, b2;
    private JLabel idLabel; // Added label for displaying ID

    public ARegisterEmployeeView() {
        f = new JFrame("Register Employee");
        f.setBackground(Color.white);
        f.setLayout(null);

        id=new JLabel();
        id.setBounds(0,0,1200,800);
        id.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("View/Icon/ainnerpage.jpg"));
        Image i1=img.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);
        f.add(id);
        
        id1 = new JLabel("New Employee Details");
        id1.setBounds(50,50,500,50);
        id1.setFont(new Font("Poppins",Font.BOLD,20));
        id1.setForeground(Color.WHITE);
        id.add(id1);
        
        id2 = new JLabel("Name:");
        id2.setBounds(50,150,100,15);
        id2.setFont(new Font("Poppins",Font.PLAIN,20));
        id2.setForeground(Color.WHITE);
        id.add(id2);
        
        t1=new JTextField();
        t1.setBounds(150,135,300,40);
        id.add(t1);
        
        id2 = new JLabel("DOB:");
        id2.setBounds(600,150,100,15);
        id2.setFont(new Font("Poppins",Font.PLAIN,20));
        id2.setForeground(Color.WHITE);
        id.add(id2);
        
        t2=new JTextField();
        t2.setBounds(700,135,300,40);
        id.add(t2);
        
        id3 = new JLabel("Phone:");
        id3.setBounds(50,225,100,15);
        id3.setFont(new Font("Poppins",Font.PLAIN,20));
        id3.setForeground(Color.WHITE);
        id.add(id3);
        
        t3=new JTextField();
        t3.setBounds(150,210,300,40);
        id.add(t3);
        
        id4 = new JLabel("Email:");
        id4.setBounds(600,225,100,15);
        id4.setFont(new Font("Poppins",Font.PLAIN,20));
        id4.setForeground(Color.WHITE);
        id.add(id4);
        
        t4=new JTextField();
        t4.setBounds(700,210,300,40);
        id.add(t4);
        
        id5 = new JLabel("Address:");
        id5.setBounds(50,300,100,15);
        id5.setFont(new Font("Poppins",Font.PLAIN,20));
        id5.setForeground(Color.WHITE);
        id.add(id5);
        
        t5=new JTextField();
        t5.setBounds(150,285,300,40);
        id.add(t5);
        
        id6 = new JLabel("Position:");
        id6.setBounds(600,300,100,15);
        id6.setFont(new Font("Poppins",Font.PLAIN,20));
        id6.setForeground(Color.WHITE);
        id.add(id6);
        
        t6=new JTextField();
        t6.setBounds(700,285,300,40);
        id.add(t6);
        
        id7 = new JLabel("ID:");
        id7.setBounds(50,375,100,15);
        id7.setFont(new Font("Poppins",Font.PLAIN,20));
        id7.setForeground(Color.WHITE);
        id.add(id7);
        
        t7=new JTextField();
        t7.setBounds(150,360,300,40);
        t7.setEditable(false);
        id.add(t7);
        
        
        // Create a label for displaying the ID
        idLabel = new JLabel("");
        idLabel.setBounds(160, 3755, 300, 40);
        idLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
        idLabel.setForeground(Color.WHITE);
        id.add(idLabel);

        
        b1 = new JButton("Submit");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(50,450,150,40);
        b1.setFont(new Font("Poppins",Font.BOLD,15));
        b1.setOpaque(true);
        
        id.add(b1);

        b2=new JButton("Cancel");   
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK);
        b2.setBounds(225,450,150,40);
        b2.setFont(new Font("Poppins",Font.BOLD,15));
        b2.setOpaque(true);

        id.add(b2);

        f.setVisible(true);
        f.setSize(1200, 800);
        f.setLocation(300, 100);
    }

    // Define getter methods for text fields, buttons, etc.
    public JButton getB1() {
        return b1;
    }

    public JButton getB2() {
        return b2;
    }

    public JTextField getT1() {
        return t1;
    }

    public JTextField getT2() {
        return t2;
    }

    public JTextField getT3() {
        return t3;
    }

    public JTextField getT4() {
        return t4;
    }

    public JTextField getT5() {
        return t5;
    }

    public JTextField getT6() {
        return t6;
    }

    public JTextField getT7() {
        return t7;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JFrame getF() {
        return f;
    }

    public void setF(JFrame f) {
        this.f = f;
    }
}
