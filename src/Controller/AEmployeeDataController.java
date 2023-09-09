package Controller;

import View.AdminStaffHomePage;

import View.AEmployeeDataView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AEmployeeDataController implements ActionListener {
    private AEmployeeDataView view;
    private String e_id;

    public AEmployeeDataController(String eid) {
        this.e_id = eid;
        try {
            ConnectionClass obj = new ConnectionClass();
            String s = "select * from employee where id = '" + eid + "'";
            ResultSet rs = obj.stm.executeQuery(s);

            String name = "", dob = "", phone = "", email = "", address = "", position = "";

            while (rs.next()) {
                name = rs.getString("name");
                dob = rs.getString("dob");
                phone = rs.getString("phone");
                email = rs.getString("email");
                address = rs.getString("address");
                position = rs.getString("position");
            }

            view = new AEmployeeDataView(e_id, name, dob, phone, email, address, position);

            view.getSaveButton().addActionListener(this);
            view.getCancelButton().addActionListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSaveButton()) {
            // Get the edited values from the view and update the database
            String editedName = view.getNameField().getText();
            String editedDob = view.getDobField().getText();
            String editedPhone = view.getPhoneField().getText();
            String editedEmail = view.getEmailField().getText();
            String editedAddress = view.getAddressField().getText();
            String editedPosition = view.getPositionField().getText();

            try {
                ConnectionClass obj = new ConnectionClass();
                String updateQuery = "UPDATE employee SET name = '" + editedName + "', dob = '" + editedDob
                        + "', phone = '" + editedPhone + "', email = '" + editedEmail + "', address = '"
                        + editedAddress + "', position = '" + editedPosition + "' WHERE id = '" + e_id + "'";
                obj.stm.executeUpdate(updateQuery);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
            } catch (Exception ex) {
                System.out.println("The error is: " + ex);
            }
        }
        if (e.getSource() == view.getCancelButton()) {
            view.getFrame().setVisible(false);
            new AdminStaffHomePage();
        }
    }
}
