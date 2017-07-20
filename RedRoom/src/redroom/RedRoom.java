/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redroom;

import java.sql.*;

/**
 *
 * @author themy0
 */
public class RedRoom {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/RedRoom";
    public static Connection CONN = null;
    
    // Modify with new username or password
    // TODO automate login
    static final String DB_USER = "admin";
    static final String DB_PASS = "last2bmoed@";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Statement stmt = null;
        
        try {
            // Load driver
            Class.forName(JDBC_DRIVER).newInstance();
            
            // Connect to RedRoom DB
            CONN = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            
            stmt = CONN.createStatement();
            
            String sql = "";
            
        } catch (Exception e) {
            
        }
        // TODO code application logic here
    }
    
}
