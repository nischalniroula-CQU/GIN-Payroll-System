/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EUpdateHours implements ActionListener{
    
    private JFrame frame;
    private JLabel startWeek, endWeek, l1,l2, id2, id3, id4;
    private JTextField startDate, endDate, hours;
    private JButton b1, b2;
    
    
    public EUpdateHours(){
        frame = new JFrame("Enter Hours Worked");
        frame.setVisible(true);
        frame.setSize(1200,800);
        frame.setLocation(300,100);
        //frame.setBackground(Color.WHITE);
        
        JLabel img = new JLabel();
        img.setBounds(0, 0, 1200, 800);
        img.setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("View/Icon/einnerpage.jpg"));
        img.setIcon(img1);
        frame.add(img);
        
        l1 = new JLabel("This is Update Hours Screen");
        l1.setBounds(50, 50, 500, 50);
        l1.setFont(new Font("Poppins",Font.BOLD,20));
        l1.setForeground(Color.WHITE);
        img.add(l1);
        
        id2 = new JLabel("Star Date:");
        id2.setBounds(50,150,100,15);
        id2.setFont(new Font("Poppins",Font.PLAIN,20));
        id2.setForeground(Color.WHITE);
        img.add(id2);
        
        startDate=new JTextField();
        startDate.setBounds(150,135,300,40);
        img.add(startDate);
        
        id3 = new JLabel("End Date:");
        id3.setBounds(600,150,100,15);
        id3.setFont(new Font("Poppins",Font.PLAIN,20));
        id3.setForeground(Color.WHITE);
        img.add(id3);
        
        endDate=new JTextField();
        endDate.setBounds(700,135,300,40);
        img.add(endDate);
        
        id4 = new JLabel("Hours:");
        id4.setBounds(50,225,100,15);
        id4.setFont(new Font("Poppins",Font.PLAIN,20));
        id4.setForeground(Color.WHITE);
        img.add(id4);
        
        hours=new JTextField();
        hours.setBounds(150,210,300,40);
        img.add(hours);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(50,300,150,40);
        b1.setFont(new Font("Poppins",Font.BOLD,15));
        //b1.setOpaque(true);
        
        img.add(b1);

        b2=new JButton("Cancel");   
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK);
        b2.setBounds(225,300,150,40);
        b2.setFont(new Font("Poppins",Font.BOLD,15));
        //b2.setOpaque(true);

        img.add(b2);
        
        
        
        
        
        frame.setVisible(true);
        
    }
    
    public static void main (String[] args)
    {
        new EUpdateHours();
    }


    public void actionPerformed(ActionEvent e) {

    }
    
    
    
}
