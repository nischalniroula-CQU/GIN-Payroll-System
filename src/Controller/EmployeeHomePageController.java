package Controller;

import View.EmployeeHomePageView;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for the employee's home page.
 */
public class EmployeeHomePageController {
    
    private EmployeeHomePageView view;
    private String e_id;

    /**
     * Constructs an instance of the EmployeeHomePageController.
     *
     * @param e_id The employee ID.
     */
    public EmployeeHomePageController(String e_id) {
        this.e_id = e_id;
        view = new EmployeeHomePageView(e_id);
        view.setVisible(true);

        // Add ActionListener to menu items
        view.addMenuItemListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                
                if (command.equals("Update Hours")) {
                    new EUpdateHours(e_id);
                } else if (command.equals("View Payslip")) {
                    new ESearchPayslip(e_id);
                } else if (command.equals("Edit Profile")) {
                    new EEditProfileController(e_id);
                } else if (command.equals("Exit")) {
                    System.exit(0);
                }
            }
        });
    }

    /**
     * Main method to start the EmployeeHomePageController.
     *
     * @param args The command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        new EmployeeHomePageController("Print Data");
    }
}
