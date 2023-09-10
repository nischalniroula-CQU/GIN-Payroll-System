/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ESearchPayslip extends JFrame implements ActionListener {
    
    private JFrame frame;
    private JTextField textField;
    private JButton b1, b2;
    
    private JLabel img, id1, id2, id3, startYearLabel, startMonthLabel, startDayLabel,
            endYearLabel, endMonthLabel, endDayLabel, hoursLabel;
    private JTextField startYearField, startMonthField, startDayField,
            endYearField, endMonthField, endDayField, hoursField;
    
    private String e_id;

    public ESearchPayslip (String e_id){
        this.e_id = e_id;
        
        frame=new JFrame("Search Payslip");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        
        JLabel img = new JLabel();
        img.setBounds(0, 0, 500, 350);
        img.setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("View/Icon/searchpayslipbg.jpg"));
        img.setIcon(img1);
        frame.add(img);
        
        // Start Date
id2 = new JLabel("Start Date:");
id2.setBounds(50, 50, 150, 25); // Adjusted position and size
id2.setFont(new Font("Poppins", Font.PLAIN, 20));
id2.setForeground(Color.WHITE);
img.add(id2);

startYearLabel = new JLabel("Year:");
startYearLabel.setBounds(50, 90, 60, 15); // Adjusted position and size
startYearLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
startYearLabel.setForeground(Color.WHITE);
img.add(startYearLabel);

startYearField = new JTextField();
startYearField.setBounds(110, 85, 80, 30); // Adjusted position and size
img.add(startYearField);

startMonthLabel = new JLabel("Month:");
startMonthLabel.setBounds(200, 90, 60, 15); // Adjusted position and size
startMonthLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
startMonthLabel.setForeground(Color.WHITE);
img.add(startMonthLabel);

startMonthField = new JTextField();
startMonthField.setBounds(260, 85, 60, 30); // Adjusted position and size
img.add(startMonthField);

startDayLabel = new JLabel("Day:");
startDayLabel.setBounds(350, 90, 60, 15); // Adjusted position and size
startDayLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
startDayLabel.setForeground(Color.WHITE);
img.add(startDayLabel);

startDayField = new JTextField();
startDayField.setBounds(410, 85, 60, 30); // Adjusted position and size
img.add(startDayField);

// End Date
id3 = new JLabel("End Date:");
id3.setBounds(50, 140, 150, 25); // Adjusted position and size
id3.setFont(new Font("Poppins", Font.PLAIN, 20));
id3.setForeground(Color.WHITE);
img.add(id3);

endYearLabel = new JLabel("Year:");
endYearLabel.setBounds(50, 180, 60, 15); // Adjusted position and size
endYearLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
endYearLabel.setForeground(Color.WHITE);
img.add(endYearLabel);

endYearField = new JTextField();
endYearField.setBounds(110, 175, 80, 30); // Adjusted position and size
img.add(endYearField);

endMonthLabel = new JLabel("Month:");
endMonthLabel.setBounds(200, 180, 60, 15); // Adjusted position and size
endMonthLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
endMonthLabel.setForeground(Color.WHITE);
img.add(endMonthLabel);

endMonthField = new JTextField();
endMonthField.setBounds(260, 175, 60, 30); // Adjusted position and size
img.add(endMonthField);

endDayLabel = new JLabel("Day:");
endDayLabel.setBounds(350, 180, 60, 15); // Adjusted position and size
endDayLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
endDayLabel.setForeground(Color.WHITE);
img.add(endDayLabel);

endDayField = new JTextField();
endDayField.setBounds(410, 175, 60, 30); // Adjusted position and size
img.add(endDayField);

        // Buttons
b1 = new JButton("Submit");
b1.setBackground(Color.GREEN);
b1.setForeground(Color.BLACK);
b1.setBounds(50, 250, 150, 40); // Adjusted position
b1.setFont(new Font("Poppins", Font.BOLD, 15));
img.add(b1);

b2 = new JButton("Cancel");
b2.setBackground(Color.RED);
b2.setForeground(Color.BLACK);
b2.setBounds(225, 250, 150, 40); // Adjusted position
b2.setFont(new Font("Poppins", Font.BOLD, 15));
img.add(b2);

        // Action Listener
        b1.addActionListener(this);
        b2.addActionListener(this);
       
        frame.setSize(500, 350);
        frame.setLocation(450, 250);
        frame.setVisible(true);
    }

 
    public void actionPerformed(ActionEvent e) {
        
        String startYear = startYearField.getText();
        String startMonth = startMonthField.getText();
        String startDay = startDayField.getText();
        String startDateString = startYear + "-" + startMonth + "-" + startDay;
        String endYear = endYearField.getText();
        String endMonth = endMonthField.getText();
        String endDay = endDayField.getText();
        String endDateString = endYear + "-" + endMonth + "-" + endDay;
        
        
        
         if(e.getSource()==b2)
        {
            frame.setVisible(false);
            new EmployeeHomePage(e_id);
        }
        if(e.getSource()==b1)
        {
            frame.setVisible(false);
            new EViewPayslip(e_id, startDateString, endDateString);
        }
        
    }
    
    public static void main (String[] args)
    {
        new ESearchPayslip("").setVisible(true);
    }
    
}
