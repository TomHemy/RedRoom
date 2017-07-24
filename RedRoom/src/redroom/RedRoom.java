/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redroom;

import java.sql.*;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author themy0
 */
public class RedRoom {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/RedRoom";
    public static Connection CONN = null;
    
    private static ArrayList<String> allStudents = new ArrayList<String>();
    private static ArrayList<String> allSubjects = new ArrayList<String>();
    
    static final ZoneId zi = ZoneId.of("Australia/Brisbane");
    private static final ZonedDateTime currentDate = ZonedDateTime.now(zi);
    private static final ZonedDateTime maximumDate = currentDate.plusDays(14);
    
    // Modify with new username or password
    // TODO automate login
    static final String DB_USER = "admin";
    static final String DB_PASS = "last2bmoed@";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Load driver
            Class.forName(JDBC_DRIVER).newInstance();
            
            // Connect to RedRoom DB
            CONN = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            
            stmt = CONN.createStatement();
            
            String sql = "SELECT EQID FROM STUDENT";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                allStudents.add(rs.getString("EQID"));
            }
            
            sql = "SELECT CLASS_CODE FROM SUBJECT";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                allStudents.add(rs.getString("SUBJECT_CODE"));
            }
                      
            displayUI();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException 
                | InstantiationException e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            try {
                if(CONN != null)
                    CONN.close();
            } catch (SQLException se4) {
                System.out.println("Error: Unable to close connection");
            }
        }
        // TODO code application logic here
    }
    
    public static String dateToString(ZonedDateTime dt) {
        return Date.valueOf(dt.toLocalDate()).toString();
        /*return (Integer.toString(dt.getYear())+"-"+
                Integer.toString(dt.getMonthValue())+"-"+
                Integer.toString(dt.getDayOfMonth()));*/
    }
    
    /**
    * TODO create a GUI for the program
    */
    static void displayUI() {
        
    }
    
    static public ArrayList<String> getAllStudents() {
        return allStudents;
    }
    
    static public ArrayList<String> getAllSubjects() {
        return allSubjects;
    }
    
    static public ZonedDateTime getCurrentDate() {
        return currentDate;
    }
    
    static public ZonedDateTime getMaxDate() {
        return maximumDate;
    }
    
}
