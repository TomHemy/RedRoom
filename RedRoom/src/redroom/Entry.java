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
    static String currentDate = RedRoom.getCurrentDate();
    static ZonedDateTime maxDate = RedRoom.getMaxDate();
    
    public static String getStudentID() {
        return studentID;
    }
    
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
     * @param subjectTime
     * @return 
     */
    public static int createEntry(String studentIDIn, String subjectIDIn, 
            String department, String teacherIDIn, List<String> days, 
            String categoryIn, String commentIn, String subjectTime) {
        /*System.out.print("EQID"+studentIDIn+" subject:"+subjectIDIn+" department:"+department+"teacher:"+teacherIDIn);
        for (int i = 0; i<days.size(); i++) {
            System.out.print("\n"+i+"    "+days.get(i));
        }*/
        
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        
        try{
            
            studentID = studentIDIn;
            entryDays = days;
            String startDate = null;
            if (!days.isEmpty()) {
                startDate = days.get(0);
            } else {
                System.out.print("Error: Please select at least one date");
                return 6;
            }
        
            category = categoryIn;
            comment = commentIn;
            subjectID = subjectIDIn;
            teacherID = teacherIDIn;
            
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
            
            sql = "SELECT CLASS_NAME FROM SUBJECT WHERE CLASS_CODE='"+subjectID+"'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                className = rs.getString("CLASS_NAME");
            }
            
            /*
            Create row in entry with all information except entry dates.
            
            For each date in entryDays, enter a new row in entrydatys table with
            student id, subject code, start date and entry date
            */
                       
            sql = String.format("INSERT INTO ENTRY (EQID, CLASS_CODE, START_DATE"
                    + ", STUDENT_NAME, SUBJECT_NAME, TEACHER, CATEGORY, "
                    + "COMMENT_TEXT, DATE_CREATED, SUBJECT_TIME) VALUES ('%1$s', '%2$s', '%3$s', '%4$s'"
                    + ", '%5$s', '%6$s', '%7$s', '%8$s', '%9$s', '%10$s')", 
                    studentID, subjectID, startDate, studentFirst+
                            " "+studentLast, className, teacherFirst+" "+
                            teacherLast, category, comment, currentDate, subjectTime);
            stmt.executeUpdate(sql);
            for(int i = 0; i<days.size(); i++) {
                sql = String.format("INSERT INTO ENTRY_DATES (EQID, CLASS_CODE, "
                        + "START_DATE, DATE) VALUES ('%1$s', '%2$s', '%3$s', "
                        + "'%4$s')",studentID, subjectID, startDate, 
                        entryDays.get(i));
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
                System.out.println("Error: Unable to close statement\n"
                        + "SQLException: "+se2.getMessage());
                return 3;
            }
            stmt = null;
            try {
                if(rs != null)
                    rs.close();
            } catch (SQLException se3) { 
                System.out.println("Error: Unable to close ResultSet\n"
                        + "SQLException: "+se3.getMessage());
                return 4;
            }
            rs = null;
            
        }
        return 0;
    }
    
    public static int closeConnection() {
        try {
            if(CONNECTION != null)
                CONNECTION.close();
        } catch (SQLException se4) {
            System.out.println("Error: Unable to close connection\n"
                    + "SQLException: "+se4.getMessage());
            return 5;
        }        
        return 0;
    }
    
    // TODO admin functions
    private static void modifyEntry(String studentID, String subjectID, String startDate) {
        deleteEntry(studentID, subjectID, startDate);
    }
    
    private static void deleteEntry(String studentID, String subjectID, String startDate) {
        
    }
}
