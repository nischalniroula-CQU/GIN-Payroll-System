
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
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class APayrollReport implements ActionListener {
    
    JFrame frame;
    JLabel id1, aid1, aid2, aid3, aid4, aid5, aid6, aid7, aid8;
    JButton b1, b2;
    String totalGrossPaid, totalPayablePaid, totalTaxPaid, totalSuperPaid, startdate, enddate, hours, wage, totalgross, tax, superannuam, totalpayable;

    public APayrollReport(String startDateString, String endDateString)
    {
        try
        {
            ConnectionClass obj = new ConnectionClass();
             String s = "SELECT SUM(totalgross) AS total_gross_paid, " +
                       "SUM(totalpayable) AS total_payable_paid, " +
                       "SUM(tax) AS total_tax_paid, " +
                       "SUM(super) AS total_super_paid " +
                       "FROM employeePayroll " +
                       "WHERE startdate >= '" + startDateString + "' AND enddate <= '" + endDateString + "'";
            ResultSet rs = obj.stm.executeQuery(s); 
            
            while (rs.next())
            {
                totalGrossPaid = rs.getString("total_gross_paid");
                totalPayablePaid = rs.getString("total_payable_paid");
                totalTaxPaid = rs.getString("total_tax_paid");
                totalSuperPaid = rs.getString("total_super_paid");
            }
            
            startdate = startDateString;
            enddate = endDateString;
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        frame = new JFrame("Total Payslip Details");
        frame.setVisible(true);
        frame.setSize(1200, 800);
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);

        JLabel img = new JLabel();
        img.setBounds(0, 0, 1200, 800);
        img.setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("View/Icon/ainnerpage.jpg"));
        img.setIcon(img1);
        frame.add(img);

        id1 = new JLabel("Payslip Details from "+startDateString+ " to "+endDateString);
        id1.setBounds(50, 50, 500, 50);
        id1.setFont(new Font("Poppins", Font.BOLD, 20));
        id1.setForeground(Color.WHITE);
        img.add(id1);
        
                aid1 = new JLabel("Total Gross Paid: " + totalGrossPaid);
        aid1.setBounds(50, 150, 400, 20);
        aid1.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid1.setForeground(Color.WHITE);
        img.add(aid1);

        aid2 = new JLabel("Total Bank Transfers: " + totalPayablePaid);
        aid2.setBounds(50, 190, 400, 20);
        aid2.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid2.setForeground(Color.WHITE);
        img.add(aid2);

        aid3 = new JLabel("Total Tax Paid: " + totalTaxPaid);
        aid3.setBounds(50, 230, 400, 20);
        aid3.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid3.setForeground(Color.WHITE);
        img.add(aid3);

        aid4 = new JLabel("Total Super Paid: " + totalSuperPaid);
        aid4.setBounds(50, 270, 400, 20);
        aid4.setFont(new Font("Poppins", Font.PLAIN, 15));
        aid4.setForeground(Color.WHITE);
        img.add(aid4);
        
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
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == b1) {
            // Save the payslip details to a text file
            saveReportToFile();
        } else if (e.getSource() == b2) {
            frame.dispose(); // Close the frame when cancel is clicked
        }
        
    }
    public static void main (String[] args){
        new APayrollReport("start date", "enddate");
    }
        private void saveReportToFile() {
        try {
            String payslipFileName = "PayslipReport.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(payslipFileName));
            writer.write("Payslip Details");
            writer.newLine();
            writer.write("Start Date: " + startdate);
            writer.newLine();
            writer.write("End Date: " + enddate);
            writer.newLine();
            writer.write("Total Gross Paid: " + totalGrossPaid);
            writer.newLine();
            writer.write("Total Amount Transferred: " + totalPayablePaid);
            writer.newLine();
            writer.write("Total Tax Paid: " + totalTaxPaid);
            writer.newLine();
            writer.write("Total Super Paid: " + totalSuperPaid);
            writer.close();
            System.out.println("Payslip saved to " + payslipFileName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
