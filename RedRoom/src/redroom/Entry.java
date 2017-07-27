/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redroom;

import java.sql.*;
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
    public static String comment = null;
    static String studentID = null;
    static String teacherID = null;
    static String deputyID = null;
    static String deputyEmail = null;
    static String ylcID = null;
    static String ylcEmail = null;
    static String hodID = null;
    static String hodEmail = null;
    static String username = RedRoom.USERNAME;
    static String userEmail = null;
    static String subjectID = null;
    static String className = null;
    static String department = null;
    static List<String> entryDays = new ArrayList<String>();
    static ZonedDateTime currentDate = RedRoom.getCurrentDate();
    static ZonedDateTime maxDate = RedRoom.getMaxDate();
    
    
    public static void main(String[] args) {
        
    }
    
    /**
     * 
     * @param studentIDIn
     * @param subjectIDIn
     * @param department
     * @param teacherIDIn
     * @param days
     * @param categoryIn
     * @param commentIn
     * @return 
     */
    public static int createEntry(String studentIDIn, String subjectIDIn, String department, 
            String teacherIDIn, List<String> days, 
            /*depending on drop down lists, could use int*/String categoryIn, 
            String commentIn) {
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        studentID = studentIDIn;
        entryDays = days;
        String startDate = days.get(0);
        category = categoryIn;
        comment = commentIn;
        subjectID = subjectIDIn;
        teacherID = teacherIDIn;
        
        try{
            stmt = CONNECTION.createStatement();
            
            
            
            // Retrieve student data
            sql = "SELECT FIRST_NAME, LAST_NAME, YEAR_LEVEL FROM STUDENT"
                    + " WHERE EQID='"+studentID+"'";
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                studentFirst = rs.getString("FIRST_NAME");
                studentLast = rs.getString("LAST_NAME");
                yearLevel = rs.getInt("YEAR_LEVEL");
            }
            
            // Year level information
            sql = "SELECT YLC_ID, DEPUTY_ID FROM YEAR WHERE YEAR="+
                    yearLevel;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                deputyID = rs.getString("DEPUTY_ID");
                ylcID = rs.getString("YLC_ID");
            }
            
            sql = "SELECT HOD_ID FROM DEPARTMENT WHERE DEPARTMENT_NAME='"
                    +department+"'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                hodID = rs.getString("HOD_ID");
            }
            
            // ylc, dp and hod emails
            sql = "SELECT EMAIL FROM TEACHER WHERE TEACHER_ID='"+ylcID+"'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ylcEmail = rs.getString("EMAIL");
            }
            sql = "SELECT EMAIL FROM TEACHER WHERE TEACHER_ID='"+deputyID+"'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                deputyEmail = rs.getString("EMAIL");
            }
            sql = "SELECT EMAIL FROM TEACHER WHERE TEACHER_ID='"+hodID+"'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                hodEmail = rs.getString("EMAIL");
            }
            
            // Teacher information
            sql = "SELECT FIRST_NAME, LAST_NAME FROM TEACHER WHERE "
                    + "TEACHER_ID='"+teacherID+"'";
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
            
            sql = String.format("INSERT INTO ENTRY VALUES (EQID='%1$s', "
                    + "CLASS_CODE='%2$s', START_DATE='%3$s', STUDENT_NAME='%4$s'"
                    + ", SUBJECT='%5$s', TEACHER='%6$s', CATEGORY='%7$s', "
                    + "COMMENT='%8$s')", 
                    studentID, subjectID, startDate, studentFirst+
                            " "+studentLast, className, teacherFirst+" "+
                                    teacherLast, category, comment);
            stmt.executeUpdate(sql);
            for(int i = 0; i<days.size(); i++) {
                sql = String.format("INSERT INTO ENTRY_DATES VALUES (EQID='%1$s', "
                        + "CLASS_CODE='%2$s', START_DATE='%3$s', DATE='%4$s'",studentID, 
                        subjectID, startDate, entryDays.get(i));
                stmt.executeUpdate(sql);
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
        comment = null;
        deputyID = null;
        deputyEmail = null;
        ylcID = null;
        ylcEmail = null;
        hodID = null;
        hodEmail = null;
        className = null;
        department = null;
    }
}
