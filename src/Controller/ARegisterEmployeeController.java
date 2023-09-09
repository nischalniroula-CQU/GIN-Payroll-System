package Controller;

import Model.EmployeeModel;
import View.ARegisterEmployeeView;
import View.AdminStaffHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.sql.*;

public class ARegisterEmployeeController implements ActionListener {
    private ARegisterEmployeeView view;
    private EmployeeModel model;

    public ARegisterEmployeeController(ARegisterEmployeeView view, EmployeeModel model) {
        this.view = view;
        this.model = model;

        // Attach action listeners to buttons
        view.getB1().addActionListener(this);
        view.getB2().addActionListener(this);

        // Initialize the ID field and label with the next available ID
        int nextId = getNextAvailableId();
        view.getT7().setText(Integer.toString(nextId));
        view.getIdLabel().setText("ID: " + nextId);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getB1()) {
            // Get data from the view and update the model
            model.setName(view.getT1().getText());
            model.setDob(view.getT2().getText());
            model.setPhone(view.getT3().getText());
            model.setEmail(view.getT4().getText());
            model.setAddress(view.getT5().getText());
            model.setPosition(view.getT6().getText());
            model.setId(view.getT7().getText());
            model.setPassword(model.getPhone() + model.getId());

            try {
                // Insert data into the database
                ConnectionClass obj = new ConnectionClass();
                String detailsQuery = "INSERT INTO employee (name, dob, phone, email, address, position) VALUES('" + model.getName() + "','" + model.getDob() + "','" + model.getPhone() + "','" + model.getEmail() + "','" + model.getAddress() + "','" + model.getPosition() + "')";
                obj.stm.executeUpdate(detailsQuery);

                // Get the last auto-incremented ID
                String getLastInsertedIdQuery = "SELECT LAST_INSERT_ID()";
                ResultSet rs = obj.stm.executeQuery(getLastInsertedIdQuery);
                int lastInsertedId = 0;
                if (rs.next()) {
                    lastInsertedId = rs.getInt(1);
                }

                // Update the ID field and label with the next available ID
                int nextId = getNextAvailableId();
                view.getT7().setText(Integer.toString(nextId));
                view.getIdLabel().setText("ID: " + nextId);

                String loginQuery = "INSERT INTO logindata (username, password, role) VALUES('" + lastInsertedId + "','" + model.getPassword() + "','employee')";
                obj.stm.executeUpdate(loginQuery);

                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                view.getF().setVisible(false);
                new AdminStaffHomePage();
            } catch (Exception ex) {
                System.out.println("The error is:" + ex);
            }
        } else if (e.getSource() == view.getB2()) {
            view.getF().setVisible(false);
            new AdminStaffHomePage();
        }
    }

    // Helper method to get the next available ID
    private int getNextAvailableId() {
        try {
            ConnectionClass obj = new ConnectionClass();
            String countQuery = "SELECT COUNT(*) FROM employee";
            ResultSet rs = obj.stm.executeQuery(countQuery);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            return rowCount + 1001;
        } catch (Exception ex) {
            System.out.println("Error getting next available ID: " + ex);
            return 0; // Default to 0 if an error occurs
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ARegisterEmployeeView view = new ARegisterEmployeeView();
            EmployeeModel model = new EmployeeModel();
            new ARegisterEmployeeController(view, model);
        });
    }
}
