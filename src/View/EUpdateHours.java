package View;

import Controller.ConnectionClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EUpdateHours implements ActionListener {
    private JFrame frame;
    private JLabel l1, id2, id3, id4;
    private JLabel startYearLabel, startMonthLabel, startDayLabel,
            endYearLabel, endMonthLabel, endDayLabel, hoursLabel;
    private JTextField startYearField, startMonthField, startDayField,
            endYearField, endMonthField, endDayField, hoursField;
    private JButton b1, b2;
    private String e_id;
    
    

    public EUpdateHours(String e_id) {
        this.e_id = e_id;
        frame = new JFrame("Enter Hours Worked");
        frame.setVisible(true);
        frame.setSize(1200, 800);
        frame.setLocation(300, 100);

        JLabel img = new JLabel();
        img.setBounds(0, 0, 1200, 800);
        img.setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("View/Icon/einnerpage.jpg"));
        img.setIcon(img1);
        frame.add(img);

        l1 = new JLabel("Update Your Hours");
        l1.setBounds(50, 50, 500, 50);
        l1.setFont(new Font("Poppins", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        img.add(l1);

        // Start Date
        id2 = new JLabel("Start Date:");
        id2.setBounds(50, 150, 150, 15);
        id2.setFont(new Font("Poppins", Font.PLAIN, 20));
        id2.setForeground(Color.WHITE);
        img.add(id2);

        startYearLabel = new JLabel("Year:");
        startYearLabel.setBounds(110, 190, 100, 15);
        startYearLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        startYearLabel.setForeground(Color.WHITE);
        img.add(startYearLabel);

        startYearField = new JTextField();
        startYearField.setBounds(150, 170, 80, 40);
        img.add(startYearField);

        startMonthLabel = new JLabel("Month:");
        startMonthLabel.setBounds(250, 190, 100, 15);
        startMonthLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        startMonthLabel.setForeground(Color.WHITE);
        img.add(startMonthLabel);

        startMonthField = new JTextField();
        startMonthField.setBounds(300, 170, 60, 40);
        img.add(startMonthField);

        startDayLabel = new JLabel("Day:");
        startDayLabel.setBounds(420, 190, 100, 15);
        startDayLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        startDayLabel.setForeground(Color.WHITE);
        img.add(startDayLabel);

        startDayField = new JTextField();
        startDayField.setBounds(450, 170, 60, 40);
        img.add(startDayField);

        // End Date
        id3 = new JLabel("End Date:");
        id3.setBounds(50, 250, 100, 15);
        id3.setFont(new Font("Poppins", Font.PLAIN, 20));
        id3.setForeground(Color.WHITE);
        img.add(id3);

        endYearLabel = new JLabel("Year:");
        endYearLabel.setBounds(110, 290, 100, 15);
        endYearLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        endYearLabel.setForeground(Color.WHITE);
        img.add(endYearLabel);

        endYearField = new JTextField();
        endYearField.setBounds(150, 270, 80, 40);
        img.add(endYearField);

        endMonthLabel = new JLabel("Month:");
        endMonthLabel.setBounds(250, 290, 100, 15);
        endMonthLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        endMonthLabel.setForeground(Color.WHITE);
        img.add(endMonthLabel);

        endMonthField = new JTextField();
        endMonthField.setBounds(300, 270, 60, 40);
        img.add(endMonthField);

        endDayLabel = new JLabel("Day:");
        endDayLabel.setBounds(420, 290, 100, 15);
        endDayLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        endDayLabel.setForeground(Color.WHITE);
        img.add(endDayLabel);

        endDayField = new JTextField();
        endDayField.setBounds(450, 270, 60, 40);
        img.add(endDayField);

        // Hours
        id4 = new JLabel("Hours:");
        id4.setBounds(50, 350, 100, 15);
        id4.setFont(new Font("Poppins", Font.PLAIN, 20));
        id4.setForeground(Color.WHITE);
        img.add(id4);

        hoursLabel = new JLabel("Enter Hours:");
        hoursLabel.setBounds(150, 390, 100, 15);
        hoursLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        hoursLabel.setForeground(Color.WHITE);
        img.add(hoursLabel);

        hoursField = new JTextField();
        hoursField.setBounds(250, 370, 300, 40);
        img.add(hoursField);

        // Buttons
        b1 = new JButton("Submit");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(50, 450, 150, 40);
        b1.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK);
        b2.setBounds(225, 450, 150, 40);
        b2.setFont(new Font("Poppins", Font.BOLD, 15));
        img.add(b2);

        // Action Listener
        b1.addActionListener(this);
        b2.addActionListener(this);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EUpdateHours("Print Data");
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
        String hours = hoursField.getText();
        String wage = "23.00";
        
        
        
        
        if (e.getSource() == b1)
        {
            try
            {
                
                java.sql.Date startDate = java.sql.Date.valueOf(startDateString);
                java.sql.Date endDate = java.sql.Date.valueOf(endDateString);
                double hoursWorked = Double.parseDouble(hours);
                double hourlyWage = Double.parseDouble(wage);
                
                double totalGross = hoursWorked * hourlyWage;
                double tax = 0.25 * totalGross; // 25% tax
                double superAmount = 0.11 * totalGross; // 11% super
                double totalPayable = totalGross - tax;
                
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into employeePayroll values('"+e_id+"','"+startDate+"','"+endDate+"','"+hoursWorked+"','"+hourlyWage+"','"+totalGross+"','"+tax+"','"+superAmount+"','"+totalPayable+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                frame.setVisible(false);
                new EmployeeHomePage("Print Data").setVisible(true);
                
            }
            catch(Exception ex)
            {
                System.out.println("The error is:" +ex);
            }
        }
        else if (e.getSource() == b2)
        {
            frame.setVisible(false);
            new EmployeeHomePage("e_id");
        }
    }
}
