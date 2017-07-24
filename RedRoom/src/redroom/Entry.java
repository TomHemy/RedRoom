/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redroom;

import java.sql.*;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

/**
 *
 * @author themy0
 */
public class Entry {
    
    static final Connection CONNECTION = RedRoom.CONN;
    
    public static String studentFirst = null;
    public static String studentLast = null;
    public static int yearLevel = 0;
    public static String teacherFirst = null;
    public static String teacherLast = null;
    public static String category = null;
    public static String description = null;
    public static String comment = null;
    static String deputyCode = null;
    static String deputyEmail = null;
    static String ylcCode = null;
    static String ylcEmail = null;
    static String hodCode = null;
    static String hodEmail = null;
    static String className = null;
    static String department = null;
    static List<String> entryDays = new ArrayList<String>();
    static ZonedDateTime currentDate = RedRoom.getCurrentDate();
    static ZonedDateTime maxDate = RedRoom.getMaxDate();
    
    
    public static void main(String[] args) {
        
    }
    
    int createEntry(String studentID, String subjectCode, 
            String teacherCode, List<String> days, 
            /*depending on drop down lists, could use int*/String categoryIn, 
            String descriptionIn, String commentIn) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        
        entryDays = days;
        String startDate = days.get(0);
        category = categoryIn;
        description = descriptionIn;
        comment = commentIn;
        
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
            
            // Year level information
            sql = "SELECT YLC_CODE, DEPUTY_CODE FROM YEAR WHERE YEAR="+
                    yearLevel;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                deputyCode = rs.getString("DEPUTY_CODE");
                ylcCode = rs.getString("YLC_CODE");
            }
            
            // Department information, including hod code
            sql="SELECT CLASS_NAME, DEPARTMENT FROM SUBJECT WHERE "
                    + "CLASS_CODE="+subjectCode;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                className = rs.getString("CLASS_NAME");
                department = rs.getString("DEPARTMENT");
            }            
            sql = "SELECT HOD_CODE FROM DEPARTMENT WHERE DEPARTMENT_NAME="
                    +department;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                hodCode = rs.getString("HOD_CODE");
            }
            
            // ylc, dp and hod emails
            sql = "SELECT EMAIL FROM TEACHER WHERE TEACHER_CODE="+ylcCode;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ylcEmail = rs.getString("EMAIL");
            }
            sql = "SELECT EMAIL FROM TEACHER WHERE TEACHER_CODE="+deputyCode;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                deputyEmail = rs.getString("EMAIL");
            }
            sql = "SELECT EMAIL FROM TEACHER WHERE TEACHER_CODE="+hodCode;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                hodEmail = rs.getString("EMAIL");
            }
            
            // Teacher information
            sql = "SELECT FIRST_NAME, LAST_NAME FROM TEACHER WHERE "
                    + "TEACHER_CODE="+teacherCode;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                teacherFirst = rs.getString("FIRST_NAME");
                teacherLast = rs.getString("LAST_NAME");
            }
            
            /*
            Create row in entry with all information except entry dates.
            
            For each date in entryDays, enter a new row in entrydatys table with
            student id, subject code, start date and entry date
            */
            
            sql = String.format("INSERT INTO ENTRY VALUES (EQID=%1, "
                    + "CLASS_CODE=%2, START_DATE=%3, STUDENT_NAME=%4, "
                    + "SUBJECT=%5, TEACHER=%6, DESCRIPTION=%7, COMMENT=%7)", 
                    studentID, subjectCode, startDate, studentFirst+
                            " "+studentLast, className, teacherFirst+" "+
                                    teacherLast, description, comment);
            stmt.executeQuery(sql);
            for(int i = 0; i<days.size(); i++) {
                sql = String.format("INSERT INTO ENTRY_DATES VALUES (EQID=%1, "
                        + "CLASS_CODE=%2, START_DATE=%3, DATE=%4",studentID, 
                        subjectCode, startDate, entryDays.get(i));
                stmt.executeQuery(sql);
            }
            
        } catch (SQLException se) {
            System.out.println("SQLException: " + se.getMessage());
            System.out.println("SQLState: " + se.getSQLState());
            System.out.println("VendorError: " + se.getErrorCode());
            return 1;
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
            return 2;
        } finally {
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                System.out.println("Error: Unable to close statement");
                return 3;
            }
            stmt = null;
            try {
                if(rs != null)
                    rs.close();
            } catch (SQLException se3) { 
                System.out.println("Error: Unable to close ResultSet");
                return 4;
            }
            rs = null;
            try {
                if(CONNECTION != null)
                    CONNECTION.close();
            } catch (SQLException se4) {
                System.out.println("Error: Unable to close connection");
                return 5;
            }
        }
        return 0;
    }
    
    private static void modifyEntry() {
        
    }
    
    private static void deleteEntry() {
        studentFirst = null;
        studentLast = null;
        yearLevel = 0;
        teacherFirst = null;
        teacherLast = null;
        category = null;
        description = null;
        comment = null;
        deputyCode = null;
        deputyEmail = null;
        ylcCode = null;
        ylcEmail = null;
        hodCode = null;
        hodEmail = null;
        className = null;
        department = null;
    }
}
