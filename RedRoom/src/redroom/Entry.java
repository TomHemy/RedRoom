/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redroom;

import java.sql.*;
import redroom.RedRoom;

/**
 *
 * @author themy0
 */
public class Entry {
    
    static final Connection CONNECTION = RedRoom.CONN;
    
    public static String studentFirst;
    public static String studentLast;
    public static int yearLevel;
    public static String teacherFirst;
    public static String teacherLast;
    public static String category;
    public static String description;
    static String deputyCode;
    static String ylcCode;
    static String className;
    static String department;
    
    public static void main(String[] args) {
        
    }
    
    private int createEntry(String studentID, String subjectCode, 
            String teacherCode, int startDate, int numDays, 
            /*depending on drop down lists, could use int*/String category, 
            String description, String comment) {
            Statement stmt = null;
            String sql = null;
            ResultSet rs = null;
        
        try{
            stmt = CONNECTION.createStatement();
            
            // Retrieve student data
            sql = "SELECT FIRST_NAME, LAST_NAME, YEAR_LEVEL FROM STUDENT"
                    + " WHERE EQID="+studentID;
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                studentFirst = rs.getString("FIRST_NAME");
                studentLast = rs.getString("LAST_NAME");
                yearLevel = rs.getInt("YEAR_LEVEL");
            }
            
            sql = "SELECT YLC_CODE, DEPUTY_CODE FROM YEAR WHERE YEAR="+
                    yearLevel;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                deputyCode = rs.getString("DEPUTY_CODE");
                ylcCode = rs.getString("YLC_CODE");
            }
            
            sql="SELECT CLASS_NAME, DEPARTMENT FROM SUBJECT WHERE "
                    + "CLASS_CODE="+subjectCode;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                className = rs.getString("CLASS_NAME");
                department = rs.getString("DEPARTMENT");
            }
            
        } catch (SQLException se) {
            System.out.println("SQLException: " + se.getMessage());
            System.out.println("SQLState: " + se.getSQLState());
            System.out.println("VendorError: " + se.getErrorCode());
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        } finally {
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if(rs != null)
                    rs.close();
            } catch (SQLException se3){  
            }
        }
        return 0;
    }
}
