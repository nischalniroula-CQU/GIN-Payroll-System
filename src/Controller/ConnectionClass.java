package Controller;

import java.sql.*;

/**
 * A utility class for establishing a connection to a MySQL database and creating tables if necessary.
 */
public class ConnectionClass {
    public Connection con;
    public Statement stm;

    /**
     * Constructs a ConnectionClass instance and establishes a connection to the MySQL server.
     */
    public ConnectionClass() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the MySQL server without specifying a database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=UTC", "root", "password");
            stm = con.createStatement();

            // Check if the database 'payroll_db' exists
            ResultSet resultSet = stm.executeQuery("SHOW DATABASES LIKE 'payroll_db'");

            if (!resultSet.next()) {
                // If 'payroll_db' does not exist, create it
                stm.executeUpdate("CREATE DATABASE payroll_db");

                // Switch to 'payroll_db'
                con.setCatalog("payroll_db");
                stm = con.createStatement();

                // Create 'employee' table
                stm.executeUpdate("CREATE TABLE employee (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR(255)," +
                        "dob DATE," +
                        "phone VARCHAR(255)," +
                        "email VARCHAR(255)," +
                        "address VARCHAR(255)," +
                        "position VARCHAR(255)," +
                        "password VARCHAR(255)" +
                        ")");

                // Create 'loginidata' table
                stm.executeUpdate("CREATE TABLE loginidata (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "username VARCHAR(255)," +
                        "password VARCHAR(255)," +
                        "role VARCHAR(255)" +
                        ")");

                // Create 'employeePayroll' table
                stm.executeUpdate("CREATE TABLE employeePayroll (" +
                        "id INT PRIMARY KEY," +
                        "startdate DATE," +
                        "enddate DATE," +
                        "hours DECIMAL(10, 2)," +
                        "wage DECIMAL(10, 2)," +
                        "totalgross DECIMAL(10, 2)," +
                        "tax DECIMAL(10, 2)," +
                        "super DECIMAL(10, 2)," +
                        "totalpayable DECIMAL(10, 2)" +
                        ")");
            } else {
                // If 'payroll_db' exists, switch to it
                con.setCatalog("payroll_db");
                stm = con.createStatement();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * The main method to initialize a ConnectionClass instance.
     *
     * @param args The command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        new ConnectionClass();
    }
}
