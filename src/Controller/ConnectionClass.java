/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;

/**
 *
 * @author nischalniroula
 */
public class ConnectionClass 
{
    public Connection con;
    public Statement stm;
    
    public ConnectionClass ()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_db?serverTimezone=UTC","root","password");
            stm=con.createStatement();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
        new ConnectionClass();
    }
}