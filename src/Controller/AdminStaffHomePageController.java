package Controller;

import View.AdminStaffHomePageView;
import Model.EmployeeModel;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller class for the Admin Staff Home Page.
 */
public class AdminStaffHomePageController implements ActionListener {
    private AdminStaffHomePageView view;

    /**
     * Constructs an instance of the AdminStaffHomePageController.
     *
     * @param view The AdminStaffHomePageView instance to control.
     */
    public AdminStaffHomePageController(AdminStaffHomePageView view) {
        this.view = view;
        view.setVisible(true);
        view.addMenuItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Register New Employee")) {
            ARegisterEmployeeView registerEmployeeView = new ARegisterEmployeeView();
            EmployeeModel employeeModel = new EmployeeModel();
            ARegisterEmployeeController registerEmployeeController = new ARegisterEmployeeController(registerEmployeeView, employeeModel);
        } else if (command.equals("Search Employee")) {
            ASearchEmployeeView searchEmployeeView = new ASearchEmployeeView();
            ASearchEmployeeController searchEmployeeController = new ASearchEmployeeController(searchEmployeeView);
        } else if (command.equals("View Payroll Information")) {
            APayrollSearchView payrollSearchView = new APayrollSearchView();
            new APayrollSearchController(payrollSearchView);
        } else if (command.equals("Exit")) {
            System.exit(0);
        }
    }

    /**
     * The main method to start the AdminStaffHomePageController.
     *
     * @param args The command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        new AdminStaffHomePageController(new AdminStaffHomePageView());
    }
}
