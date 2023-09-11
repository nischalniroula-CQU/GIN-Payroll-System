package Controller;

import View.EEditProfileView;
import View.EmployeeHomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Controller class for editing employee profiles.
 */
public class EEditProfileController implements ActionListener {
    private EEditProfileView view;
    private String e_id;

    /**
     * Constructs an instance of the EEditProfileController.
     *
     * @param eid The employee ID to edit.
     */
    public EEditProfileController(String eid) {
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

            view = new EEditProfileView(e_id, name, dob, phone, email, address, position);

            view.getSaveButton().addActionListener(this);
            view.getCancelButton().addActionListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles button click events.
     *
     * @param e The action event.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSaveButton()) {
            // Get the edited values from JTextFields and update the database
            String editedDob = view.getDobField().getText();
            String editedPhone = view.getPhoneField().getText();
            String editedEmail = view.getEmailField().getText();
            String editedAddress = view.getAddressField().getText();

            try {
                ConnectionClass obj = new ConnectionClass();
                String updateQuery = "UPDATE employee SET dob = '" + editedDob
                        + "', phone = '" + editedPhone + "', email = '" + editedEmail + "', address = '"
                        + editedAddress + "' WHERE id = '" + e_id + "'";
                obj.stm.executeUpdate(updateQuery);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
            } catch (Exception ex) {
                System.out.println("The error is: " + ex);
            }
        }
        if (e.getSource() == view.getCancelButton()) {
            view.getFrame().setVisible(false);
            new EmployeeHomePage(e_id);
        }
    }
}
