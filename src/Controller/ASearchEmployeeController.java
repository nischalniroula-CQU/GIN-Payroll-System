package Controller;

import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller class for searching employees.
 */
public class ASearchEmployeeController implements ActionListener {
    private ASearchEmployeeView view;

    /**
     * Constructs an instance of the ASearchEmployeeController.
     *
     * @param view The ASearchEmployeeView instance to control.
     */
    public ASearchEmployeeController(ASearchEmployeeView view) {
        this.view = view;

        // Attach action listeners to buttons
        view.getSearchButton().addActionListener(this);
        view.getCancelButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getCancelButton()) {
            // Close the search employee view and return to the admin homepage
            view.getFrame().setVisible(false);
            new AdminStaffHomePage();
        } else if (e.getSource() == view.getSearchButton()) {
            // Get the employee ID entered by the user and open the employee data view
            String employeeId = view.getTextField().getText();
            view.getFrame().setVisible(false);
            new AEmployeeDataController(employeeId);
        }
    }

    /**
     * The main method to start the ASearchEmployeeController.
     *
     * @param args The command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        ASearchEmployeeView view = new ASearchEmployeeView();
        new ASearchEmployeeController(view);
    }
}
