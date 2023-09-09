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
                String detailsQuery = "INSERT INTO employee VALUES('" + model.getName() + "','" + model.getDob() + "','" + model.getPhone() + "','" + model.getEmail() + "','" + model.getAddress() + "','" + model.getPosition() + "','" + model.getId() + "','" + model.getPassword() + "')";
                obj.stm.executeUpdate(detailsQuery);

                String loginQuery = "INSERT INTO logindata (username, password, role) VALUES('" + model.getId() + "','" + model.getPassword() + "','employee')";
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ARegisterEmployeeView view = new ARegisterEmployeeView();
            EmployeeModel model = new EmployeeModel();
            new ARegisterEmployeeController(view, model);
        });
    }
}
