package Controller;

import View.*;
import View.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Controller class for the login view.
 */
public class LoginController {
    private LoginView view;

    /**
     * Constructs an instance of the LoginController.
     */
    public LoginController() {
        view = new LoginView();

        view.getLoginButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ee) {
                if (ee.getSource() == view.getLoginButton()) {
                    try {
                        String username = view.getUsernameField().getText();
                        String password = new String(view.getPasswordField().getPassword());
                        String selectedRole = view.getRoleComboBox().getSelectedItem().toString();

                        ConnectionClass obj = new ConnectionClass();
                        String q = "SELECT * FROM logindata WHERE username='" + username + "' AND password='" + password + "' AND role='" + selectedRole + "'";
                        ResultSet rs = obj.stm.executeQuery(q);

                        if (rs.next()) {
                            if (selectedRole.equals("Employee")) {
                                String e_id = rs.getString("username");
                                new EmployeeHomePageController(e_id);
                                view.setVisible(false);
                            } else if (selectedRole.equals("Admin Staff")) {
                                AdminStaffHomePageView adminStaffHomePageView = new AdminStaffHomePageView();
                                new AdminStaffHomePageController(adminStaffHomePageView);
                                view.setVisible(false);
                            }
                            view.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Login. Please check role, username, and password.");
                            view.getUsernameField().setText("");
                            view.getPasswordField().setText("");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (ee.getSource() == view.getCancelButton()) {
                    view.dispose();
                }
            }
        });
    }

    /**
     * Main method to start the LoginController.
     *
     * @param args The command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginController();
            }
        });
    }
}
