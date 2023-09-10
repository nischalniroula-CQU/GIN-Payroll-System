package View;

import Controller.ConnectionClass;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EViewPayslip implements ActionListener {

    JFrame frame;
    JLabel id1, aid1, aid2, aid3, aid4, aid5, aid6, aid7, aid8;
    JButton b1, b2;
    String e_id, startdate, enddate, hours, wage, totalgross, tax, superannuam, totalpayable;

    public EViewPayslip(String e_id, String startDateString, String endDateString) {
        
        this.e_id = e_id;
        try {
            ConnectionClass obj = new ConnectionClass();
            String s = "SELECT * FROM employeePayroll WHERE id = " + e_id + " AND startdate = '" + startDateString + "' AND enddate = '" + endDateString + "'";
            ResultSet rs = obj.stm.executeQuery(s);

            while (rs.next()) {
                startdate = rs.getString("startdate");
                enddate = rs.getString("enddate");
                hours = rs.getString("hours");
                wage = rs.getString("wage");
                totalgross = rs.getString("totalgross");
                tax = rs.getString("tax");
                superannuam = rs.getString("super");
                totalpayable = rs.getString("totalpayable");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame("Payslip Details");
        frame.setVisible(true);
        frame.setSize(1200, 800);
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);

        JLabel img = new JLabel();
        img.setBounds(0, 0, 1200, 800);
        img.setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("View/Icon/einnerpage.jpg"));
        img.setIcon(img1);
        frame.add(img);

        id1 = new JLabel("Payslip Details for:" +e_id);
        id1.setBounds(50, 50, 500, 50);
        id1.setFont(new Font("Poppins", Font.BOLD, 20));
        id1.setForeground(Color.WHITE);
        img.add(id1);

        aid1 = new JLabel("Start Date: " + startdate);
        aid1.setBounds(50, 150, 400, 20);
        aid1.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid1.setForeground(Color.WHITE);
        img.add(aid1);

        aid2 = new JLabel("End Date: " + enddate);
        aid2.setBounds(50, 190, 400, 20);
        aid2.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid2.setForeground(Color.WHITE);
        img.add(aid2);

        aid3 = new JLabel("Hours: " + hours);
        aid3.setBounds(50, 230, 400, 20);
        aid3.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid3.setForeground(Color.WHITE);
        img.add(aid3);

        aid4 = new JLabel("Wage: " + wage);
        aid4.setBounds(50, 270, 400, 20);
        aid4.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid4.setForeground(Color.WHITE);
        img.add(aid4);

        aid5 = new JLabel("Total Gross: " + totalgross);
        aid5.setBounds(50, 310, 400, 20);
        aid5.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid5.setForeground(Color.WHITE);
        img.add(aid5);

        aid6 = new JLabel("Tax: " + tax);
        aid6.setBounds(50, 350, 400, 20);
        aid6.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid6.setForeground(Color.WHITE);
        img.add(aid6);

        aid7 = new JLabel("Superannuation: " + superannuam);
        aid7.setBounds(50, 390, 400, 20);
        aid7.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid7.setForeground(Color.WHITE);
        img.add(aid7);

        aid8 = new JLabel("Total Payable: " + totalpayable);
        aid8.setBounds(50, 430, 400, 20);
        aid8.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid8.setForeground(Color.WHITE);
        img.add(aid8);

        b1 = new JButton("Save");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(50, 500, 150, 40); // Adjusted position
        b1.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK);
        b2.setBounds(225, 500, 150, 40); // Adjusted position
        b2.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EViewPayslip("1", "20190404", "20190411");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            // Save the payslip details to a text file
            savePayslipToFile();
        } else if (e.getSource() == b2) {
            frame.dispose(); // Close the frame when cancel is clicked
        }
    }

    private void savePayslipToFile() {
        try {
            String payslipFileName = "payslip.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(payslipFileName));
            writer.write("Payslip Details");
            writer.newLine();
            writer.write("Employee ID: " + e_id); 
            writer.newLine();
            writer.write("Start Date: " + startdate);
            writer.newLine();
            writer.write("End Date: " + enddate);
            writer.newLine();
            writer.write("Hours: " + hours);
            writer.newLine();
            writer.write("Wage: " + wage);
            writer.newLine();
            writer.write("Total Gross: " + totalgross);
            writer.newLine();
            writer.write("Tax: " + tax);
            writer.newLine();
            writer.write("Superannuation: " + superannuam);
            writer.newLine();
            writer.write("Total Payable: " + totalpayable);
            writer.close();
            System.out.println("Payslip saved to " + payslipFileName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
