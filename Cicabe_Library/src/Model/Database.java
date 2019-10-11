/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Zara
 */
public class Database {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    public void connect() {
        try {
            String msAccDB = " ";
            String url = "jdbc:ucanaccess://" + msAccDB;
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            System.out.println("Connected");
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void disconnect() {
        try {
            if(con != null) {
                con.close();
                stmt.close();
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
