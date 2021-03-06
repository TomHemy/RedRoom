/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redroom;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author themy0
 */
public class ModifyEntry extends javax.swing.JFrame {

    /**
     * Creates new form NewEntry
     */
    public ModifyEntry() {
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        allStudentsCombobox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        subjectCombobox = new javax.swing.JComboBox<>();
        periodCombobox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        teacherCombobox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        YearLevelLabel = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        DPLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        YLCLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        categoryCombobox = new javax.swing.JComboBox<>();
        commentScrollPane = new javax.swing.JScrollPane();
        comment = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        departmentCombobox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        HoDLabel = new javax.swing.JLabel();
        dateSpinner = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jDialog1.setSize(new java.awt.Dimension(150, 120));

        jButton1.setText("Yes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("No");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setText("Are you sure?");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(39, 39, 39))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create a New Entry");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        allStudentsCombobox.setMaximumRowCount(20);
        allStudentsCombobox.setModel(new DefaultComboBoxModel(RedRoom.getAllStudents())
        );
        allStudentsCombobox.setSelectedItem(View.getStudentID());
        allStudentsCombobox.setName(""); // NOI18N
        allStudentsCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeYearLevel(evt);
            }
        });

        jLabel1.setText("Select student");

        jLabel2.setText("Select subject");

        subjectCombobox.setMaximumRowCount(20);
        subjectCombobox.setModel(new DefaultComboBoxModel(RedRoom.getAllSubjects())
        );
        subjectCombobox.setSelectedItem(View.getClassCode());

        periodCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form", "1", "2", "3", "4" }));
        periodCombobox.setSelectedIndex(-1);
        periodCombobox.setSelectedItem(View.getPeriod());

        jLabel3.setText("Period");

        jLabel6.setText("on");

        jLabel7.setText("Teacher");

        teacherCombobox.setModel(new DefaultComboBoxModel(RedRoom.getAllTeachers()));
        teacherCombobox.setSelectedItem(View.getTeacher());

        jLabel8.setText("Year Level:");

        YearLevelLabel.setText(RedRoom.getStudentYear(allStudentsCombobox.toString())[0]);

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Deputy:");

        DPLabel.setText(RedRoom.getStudentYear(allStudentsCombobox.toString())[2]);

        jLabel12.setText("YLC:");

        YLCLabel.setText(RedRoom.getStudentYear(allStudentsCombobox.toString())[1]);

        jLabel14.setText("Department");

        jCheckBox1.setText(RedRoom.getDateRange()[0]);

        jCheckBox2.setText(RedRoom.getDateRange()[1]);

        jCheckBox3.setText(RedRoom.getDateRange()[2]);

        jCheckBox4.setText(RedRoom.getDateRange()[3]);

        jCheckBox5.setText(RedRoom.getDateRange()[4]);

        jCheckBox6.setText(RedRoom.getDateRange()[5]);

        jCheckBox7.setText(RedRoom.getDateRange()[6]);

        jCheckBox8.setText(RedRoom.getDateRange()[7]);

        jCheckBox9.setText(RedRoom.getDateRange()[8]);

        jCheckBox10.setText(RedRoom.getDateRange()[9]);

        categoryCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disruptive behaviour in buddy class", "Disruptive or misbehaviour in Red Room", "Inappropriate filming of other students", "Other", "Pattern of truanting or skipping class", "Persistent failure to work in class", "Persistent inappropriate behaviour or language", "Persistent lateness to class", "Persistent or extreme rudeness to teacher", "Persistent or high level bullying", "Persistent or high level disruptive behaviour", "Persistent or high level harassment", "Persistent or high level misue of technology", "Persistent unsafe practice", "Refusal to follow critical direction from teacher", "Refusal to negotiate ACT plan", "Refusal to negotiate modified program", "Significant or persistent vandalism", "Smoking", "Unresolved gross disobedience", "Unresolved inappropriate behaviour in playground", "Unresolved non compliance with ACT plan" }));
        categoryCombobox.setSelectedIndex(-1);
        categoryCombobox.setSelectedItem(View.getCategory());

        comment.setColumns(20);
        comment.setLineWrap(true);
        comment.setRows(5);
        comment.setTabSize(4);
        comment.setText(View.getComment());
        commentScrollPane.setViewportView(comment);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        departmentCombobox.setModel(new DefaultComboBoxModel(RedRoom.getAllDepartments()));
        departmentCombobox.setSelectedIndex(-1);
        departmentCombobox.setSelectedItem(View.getDepartment());
        departmentCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboboxActionPerformed(evt);
            }
        });

        jLabel9.setText("Head of Department:");

        HoDLabel.setText(RedRoom.getHOD(departmentCombobox.toString()));

        dateSpinner.setModel(getDateModel());
        dateSpinner.setEditor(new javax.swing.JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("New Entry");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            View.getDates(),
            new String [] {
                "Previously chosen dates"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(allStudentsCombobox, 0, 85, Short.MAX_VALUE)
                                    .addComponent(subjectCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(YearLevelLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DPLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(YLCLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(departmentCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(HoDLabel))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(periodCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(teacherCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(427, 427, 427)
                                .addComponent(errorLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoryCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(commentScrollPane)
                                        .addGap(18, 18, 18)
                                        .addComponent(createButton)
                                        .addGap(29, 29, 29)
                                        .addComponent(cancelButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox1)
                                            .addComponent(jCheckBox2)
                                            .addComponent(jCheckBox3)
                                            .addComponent(jCheckBox4)
                                            .addComponent(jCheckBox5)
                                            .addComponent(jCheckBox6)
                                            .addComponent(jCheckBox7)
                                            .addComponent(jCheckBox8)
                                            .addComponent(jCheckBox9)
                                            .addComponent(jCheckBox10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(190, 190, 190)))))))
                .addContainerGap(443, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allStudentsCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(YearLevelLabel)
                    .addComponent(jLabel10)
                    .addComponent(DPLabel)
                    .addComponent(jLabel12)
                    .addComponent(YLCLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14)
                    .addComponent(departmentCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(HoDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(periodCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6)
                        .addComponent(dateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(teacherCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox10))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(categoryCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createButton)
                            .addComponent(cancelButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorLabel))
                    .addComponent(commentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChangeYearLevel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeYearLevel
        String[] year = RedRoom.getStudentYear(allStudentsCombobox.getSelectedItem().toString());
        YearLevelLabel.setText(year[0]);
        YLCLabel.setText(year[1]);
        DPLabel.setText(year[2]);
    }//GEN-LAST:event_ChangeYearLevel

    private void departmentComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboboxActionPerformed
        HoDLabel.setText(RedRoom.getHOD(departmentCombobox.getSelectedItem().toString()));
    }//GEN-LAST:event_departmentComboboxActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        errorLabel.setText("");
        allStudentsCombobox.setBackground(Color.white);
        subjectCombobox.setBackground(Color.white);
        departmentCombobox.setBackground(Color.white);
        periodCombobox.setBackground(Color.white);
        categoryCombobox.setBackground(Color.white);
        teacherCombobox.setBackground(Color.white);
        JCheckBox[] boxes = {jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5, jCheckBox6, jCheckBox7, jCheckBox8, jCheckBox9, jCheckBox10};
        int j = 0;
        for (int i = 0; i < 10; i++) {
            if (boxes[i].isSelected()) { 
                j = 1;
            }
        }
        if (allStudentsCombobox.getSelectedIndex() == -1) {
            allStudentsCombobox.setBackground(Color.red);
            errorLabel.setText("Please select a student.");
        } else if (subjectCombobox.getSelectedIndex() == -1) {
            subjectCombobox.setBackground(Color.red);
            errorLabel.setText("Please select a subject.");
        } else if (departmentCombobox.getSelectedIndex() == -1) {
            departmentCombobox.setBackground(Color.red);
            errorLabel.setText("Please select a department.");
        } else if (periodCombobox.getSelectedIndex() == -1) {
            periodCombobox.setBackground(Color.red);
            errorLabel.setText("Please select a period.");
        } else if (teacherCombobox.getSelectedIndex() == -1) {
            teacherCombobox.setBackground(Color.red);
            errorLabel.setText("Please select a teacher.");
        } else if (categoryCombobox.getSelectedIndex() == -1) {
            categoryCombobox.setBackground(Color.red);
            errorLabel.setText("Please select a category.");
        } else if (j == 0) {
            errorLabel.setText("Please select at least one date.");
        } else {this.jDialog1.setVisible(true);}
    }//GEN-LAST:event_createButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
        View view = new View();
        view.setVisible(true);
        this.dispose();
        //Entry.closeConnection();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<String> days = new ArrayList<>();
        JCheckBox[] boxes = {jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5, jCheckBox6, jCheckBox7, jCheckBox8, jCheckBox9, jCheckBox10};
        for (int i = 0; i < 10; i++) {
            if (boxes[i].isSelected()) {
                //days.add(boxes[i].toString().split(" - ")[1].split("/")[2]+"-"+boxes[i].toString().split(" - ")[1].split("/")[1]+"-"+boxes[i].toString().split(" - ")[1].split("/")[0]);
                days.add(RedRoom.toSQLDate(boxes[i].getText().split(" - ")[1]));
            }
        }
        //String subjectTime = String.format("Period %1$s on %2$s/%3$s/%4$s", periodCombobox.getSelectedItem(), daySpinner.getValue().toString(), monthSpinner.getValue().toString(), yearSpinner.getValue().toString());
        //String subjectTime = String.format("Period %1$s on %2$s", periodCombobox.getSelectedItem(), new SimpleDateFormat("yyyy-MM-dd").format(dateSpinner.getValue()));
        Entry.modifyEntry(View.getStudentID(), View.getClassCode(), View.getStartDate(), allStudentsCombobox.getSelectedItem().toString(), subjectCombobox.getSelectedItem().toString(), departmentCombobox.getSelectedItem().toString(), teacherCombobox.getSelectedItem().toString(), days, categoryCombobox.getSelectedItem().toString(), comment.getText(), periodCombobox.getSelectedItem().toString(), new SimpleDateFormat("yyyy-MM-dd").format(dateSpinner.getValue()));
        this.cancelButtonActionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jDialog1.setVisible(false);
        this.jDialog1.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private javax.swing.SpinnerDateModel getDateModel() {
        javax.swing.SpinnerDateModel model = null;
        try {
            DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
            model = new javax.swing.SpinnerDateModel(df.parse(View.getDate()), null, null, Calendar.DAY_OF_MONTH);
        } catch (ParseException ex) {
            Logger.getLogger(ModifyEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
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
            java.util.logging.Logger.getLogger(ModifyEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DPLabel;
    private javax.swing.JLabel HoDLabel;
    private javax.swing.JLabel YLCLabel;
    private javax.swing.JLabel YearLevelLabel;
    private javax.swing.JComboBox<String> allStudentsCombobox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> categoryCombobox;
    private javax.swing.JTextArea comment;
    private javax.swing.JScrollPane commentScrollPane;
    private javax.swing.JButton createButton;
    private javax.swing.JSpinner dateSpinner;
    private javax.swing.JComboBox<String> departmentCombobox;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> periodCombobox;
    private javax.swing.JComboBox<String> subjectCombobox;
    private javax.swing.JComboBox<String> teacherCombobox;
    // End of variables declaration//GEN-END:variables
}
/*RedRoom.getAllStudents().toArray(new String[RedRoom.getAllStudents().size()])
RedRoom.getAllSubjects().toArray(new String[RedRoom.getAllSubjects().size()])*/
