package Controller;

import javax.swing.SwingUtilities;

public class ProjectLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Initialize the database connection
                ConnectionClass connectionClass = new ConnectionClass();

                // Start the login controller
                LoginController loginController = new LoginController();
            }
        });
    }
}
