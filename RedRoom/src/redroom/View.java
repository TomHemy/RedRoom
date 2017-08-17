/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redroom;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author themy0
 */
public class View extends javax.swing.JFrame {
    public static String studentID = null;
    public static String teacher = null;
    public static String classCode = null;
    public static String startDate = null;
    public static String category = null;
    public static String comment = null;
    public static Object[][] dates = new Object[10][2];
    
    /**
     * Creates new form View
     */
    public View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        newEntryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dateSelector = new javax.swing.JSpinner();
        today = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        entriesList = new javax.swing.JTable();
        markRollButton = new javax.swing.JButton();
        emailButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        openButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        jDialog1.setSize(new java.awt.Dimension(150, 120));

        jLabel3.setText("Are you sure?");

        jButton2.setText("Yes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("No");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Red Room");

        newEntryButton.setText("New");
        newEntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Referrals for");

        dateSelector.setModel(new javax.swing.SpinnerDateModel());
        dateSelector.setEditor(new javax.swing.JSpinner.DateEditor(dateSelector, "dd/MM/yyyy"));
        dateSelector.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dateChanged(evt);
            }
        });

        today.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        today.setText("Today");
        today.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayActionPerformed(evt);
            }
        });

        entriesList.setAutoCreateRowSorter(true);
        entriesList.setModel(new javax.swing.table.DefaultTableModel(
            RedRoom.allEntries(new SimpleDateFormat("yyyy-MM-dd").format(dateSelector.getValue())),
            new String [] {
                "Student", "Teacher", "Subject", "Start Date", "Category", "Description", "Roll"
            }
        )
        {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(entriesList);

        markRollButton.setText("Mark Roll");

        emailButton.setText("Email");

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Red Room Referrals");

        openButton.setText("Edit");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(today)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(newEntryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(markRollButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dateSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(today))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEntryButton)
                    .addComponent(markRollButton)
                    .addComponent(emailButton)
                    .addComponent(closeButton)
                    .addComponent(openButton)
                    .addComponent(jButton1)
                    .addComponent(errorLabel))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newEntryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryButtonActionPerformed
        NewEntry newEntry = new NewEntry();
        this.setVisible(false);
        newEntry.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newEntryButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        Entry.closeConnection();
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void dateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dateChanged
        refreshEntryTable();
        /*entriesList.setModel(new javax.swing.table.DefaultTableModel(
            RedRoom.allEntries(new SimpleDateFormat("yyyy-MM-dd").format(dateSelector.getValue())),
            new String [] {
                "Student", "Teacher", "Subject", "Category", "Description", "Roll"
            }
        )
        {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        }
        );*/
    }//GEN-LAST:event_dateChanged

    private void todayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayActionPerformed
        dateSelector.setModel(new javax.swing.SpinnerDateModel());
        dateSelector.setEditor(new javax.swing.JSpinner.DateEditor(dateSelector, "dd/MM/yyyy"));
        refreshEntryTable();
        /*entriesList.setModel(new javax.swing.table.DefaultTableModel(
            RedRoom.allEntries(new SimpleDateFormat("yyyy-MM-dd").format(dateSelector.getValue())),
            new String [] {
                "Student", "Teacher", "Subject", "Category", "Description", "Roll"
            }
        )
        {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        }
        );*/
    }//GEN-LAST:event_todayActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        if (entriesList.getSelectedRow() != -1) {
            errorLabel.setText("");
            int row = entriesList.getSelectedRow();
            studentID = entriesList.getValueAt(row, 0).toString().split(" - ")[1];
            teacher = entriesList.getValueAt(row, 1).toString();
            classCode = entriesList.getValueAt(row, 2).toString().split(" - ")[1];
            startDate = RedRoom.toSQLDate(entriesList.getValueAt(row, 3).toString());
            category = entriesList.getValueAt(row, 4).toString();
            comment = entriesList.getValueAt(row, 5).toString();
            dates = RedRoom.getEntryDates(studentID, classCode, startDate);

            ModifyEntry modifyEntry = new ModifyEntry();
            modifyEntry.setVisible(true);
            this.setVisible(false);
        }
        else {
            errorLabel.setText("Please select a redroom entry.");
        }
    }//GEN-LAST:event_openButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = entriesList.getSelectedRow();
        Entry.deleteEntry(entriesList.getValueAt(row, 0).toString().split(" - ")[1], entriesList.getValueAt(row, 2).toString().split(" - ")[1], RedRoom.toSQLDate(entriesList.getValueAt(row, 3).toString()));// TODO add your handling code here:       
        refreshEntryTable();
        this.jDialog1.setVisible(false);
        this.jDialog1.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.jDialog1.setVisible(false);
        this.jDialog1.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void refreshEntryTable() {
        entriesList.setModel(new javax.swing.table.DefaultTableModel(
            RedRoom.allEntries(new SimpleDateFormat("yyyy-MM-dd").format(dateSelector.getValue())),
            new String [] {
                "Student", "Teacher", "Subject", "Start Date", "Category", "Description", "Roll"
            }
        )
        {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    public static Object[][] getDates() {
        return dates;
    }
    
    public static String getStudentID() {
        return studentID;
    }
    public static String getClassCode() {
        return classCode;
    }
    
    public static String getDepartment() {
        return RedRoom.getDepartment(studentID, classCode, startDate);
    }
    
    public static String getPeriod() {
        return RedRoom.getPeriod(studentID, classCode, startDate);
    }
    
    public static String getDate() {
        return RedRoom.getDate(studentID, classCode, startDate);
    }
    
    public static String getTeacher() {
        return teacher;
    }
    
    public static String getCategory(){
        return category;
    }
    
    public static String getComment() {
        return comment;
    }
    
    public static String getStartDate() {
        return startDate;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JSpinner dateSelector;
    private javax.swing.JButton emailButton;
    private javax.swing.JTable entriesList;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton markRollButton;
    private javax.swing.JButton newEntryButton;
    private javax.swing.JButton openButton;
    private javax.swing.JButton today;
    // End of variables declaration//GEN-END:variables
}
