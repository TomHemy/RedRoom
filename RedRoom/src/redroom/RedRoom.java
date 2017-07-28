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
    private static ArrayList<String> allTeachers = new ArrayList<String>();
    private static ArrayList<String> allDepartments = new ArrayList<String>();
    
    static final ZoneId zi = ZoneId.of("Australia/Brisbane");
    private static final ZonedDateTime currentDate = ZonedDateTime.now(zi);
    private static final ZonedDateTime maximumDate = currentDate.plusDays(14);
    
    // Modify with new username or password
    // TODO automate login
    static final String DB_USER = "admin";
    static final String DB_PASS = "last2bmoed@";
    
    static final String USERNAME = System.getProperty("user.name");
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        try {
            Statement stmt = null;
            ResultSet rs = null;
            // Load driver
            Class.forName(JDBC_DRIVER).newInstance();
            
            // Connect to RedRoom DB
            CONN = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            
            stmt = CONN.createStatement();
            
            String sql = "SELECT EQID, YEAR_LEVEL FROM STUDENT";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                allStudents.add(rs.getString("EQID"));
            }
            
            sql = "SELECT CLASS_CODE FROM SUBJECT";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                allSubjects.add(rs.getString("CLASS_CODE"));
            }
            
            sql = "SELECT TEACHER_ID, FIRST_NAME, LAST_NAME FROM TEACHER ORDER BY LAST_NAME";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                allTeachers.add(rs.getString("TEACHER_ID"));
                //allTeachers.add(rs.getString("LAST_NAME")+", "+rs.getString("FIRST_NAME"));
            }
            
            sql = "SELECT DEPARTMENT_NAME FROM DEPARTMENT ORDER BY DEPARTMENT_NAME";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                allDepartments.add(rs.getString("DEPARTMENT_NAME"));
            }
                      
            displayUI();
            while (true) {
                
            }
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
     * Returns a list of dates or strings that will be used by a button group on newEntry form
     * @return String[] of next 10 school days
     */
    public static String[] dateRange() {
        String[] range = new String[10];
        int j = 0;
        for (int i = 0; i<14; i++) {
            ZonedDateTime offsetDate = currentDate.plusDays(i);
            if (!offsetDate.getDayOfWeek().toString()
                    .matches("SATURDAY|SUNDAY")) {
                range[j] = String.format("%1$s - %2$s-%3$s-%4$s", 
                        offsetDate.getDayOfWeek().toString(), 
                        offsetDate.getDayOfMonth(), offsetDate.getMonthValue(), 
                        offsetDate.getYear());
                j++;
            }           
        }       
        return range;
    }
    
    /**
    * TODO create a GUI for the program
    */
    static void displayUI() {
        View form = new View();
        form.setVisible(true);
    }
    
    public static final Object[] getAllStudents() {
        return allStudents.toArray();
        //return allStudents;
    }
    
    public static final Object[] getAllSubjects() {
        return allSubjects.toArray();
    }
    
    public static final Object[] getAllTeachers() {
        return allTeachers.toArray();
    }
    
    public static final Object[] getAllDepartments() {
        return allDepartments.toArray();
    }
    
    public static final String getCurrentDate() {
        String date = String.format("%1$d-%2$d-%3$d", currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth());
        return date;
    }
    
    public static final ZonedDateTime getMaxDate() {
        return maximumDate;
    }
    
    public static final String[] getDateRange() {
        return dateRange();
    }
    
    public static String[] getStudentYear(String studentID) {
        Statement stmt = null;
        ResultSet rs = null;
        String[] year = new String[3];
        try {
            stmt = CONN.createStatement();
            
            rs = stmt.executeQuery("SELECT YEAR_LEVEL FROM STUDENT WHERE EQID='"
                    +studentID+"'");
            while (rs.next()) {
                year[0] = rs.getString("YEAR_LEVEL");
            }
            rs = stmt.executeQuery("SELECT FIRST_NAME, LAST_NAME FROM TEACHER "
                    + "WHERE TEACHER_ID=(SELECT YLC_ID FROM YEAR WHERE YEAR="
                    +year[0]+")");
            while (rs.next()) {
                year[1] = rs.getString("LAST_NAME")+", "+
                        rs.getString("FIRST_NAME");
            }
            rs = stmt.executeQuery("SELECT FIRST_NAME, LAST_NAME FROM TEACHER "
                    + "WHERE TEACHER_ID=(SELECT DEPUTY_ID FROM YEAR WHERE YEAR="
                    +year[0]+")");
            while (rs.next()) {
                year[2] = rs.getString("LAST_NAME")+", "+
                        rs.getString("FIRST_NAME");
            }
        } catch (SQLException se) {
            System.out.println("Error: "+se.getMessage());
        }
        return year;
    }
    
    public static final String getHOD(String department) {
        Statement stmt = null;
        ResultSet rs = null;
        String HoD = null;
        try {
            stmt = CONN.createStatement();
            String sql = "SELECT FIRST_NAME, LAST_NAME FROM TEACHER WHERE "
                    + "TEACHER_ID=(SELECT HOD_ID FROM DEPARTMENT WHERE "
                    + "DEPARTMENT_NAME='"
                    +department+"')";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoD = rs.getString("LAST_NAME")+", "+rs.getString("FIRST_NAME");
            }
        } catch (SQLException se) {
            System.out.print("Error: "+se.getMessage());
        }
        return HoD;
    }
}
