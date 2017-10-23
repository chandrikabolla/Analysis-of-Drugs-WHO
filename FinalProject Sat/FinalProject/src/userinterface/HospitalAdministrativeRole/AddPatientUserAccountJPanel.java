/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdministrativeRole;

import Business.Enterprise.Enterprise;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author chand
 */
public class AddPatientUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddPatientUserAccount
     */
    JPanel userProcessContainer;
    Patient patient;
    Enterprise enterprise;
    PatientOrganization organization;
    public AddPatientUserAccountJPanel(JPanel userProcessContainer,Patient patient,Enterprise enterprise,PatientOrganization organization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.patient=patient;
        this.enterprise=enterprise;
        this.organization=organization;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        useraccountCreationBtn = new javax.swing.JButton();
        usernameTextFld = new javax.swing.JTextField();
        pwdTextFld = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();

        jLabel1.setText("UserName:");

        jLabel2.setText("PAtient USerAccount");

        jLabel3.setText("Password:");

        useraccountCreationBtn.setText("CreateUSerAccount");
        useraccountCreationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useraccountCreationBtnActionPerformed(evt);
            }
        });

        backBtn.setText("<<GoBack");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(useraccountCreationBtn)
                            .addComponent(usernameTextFld, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(pwdTextFld)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(backBtn)))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTextFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pwdTextFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(useraccountCreationBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addGap(69, 69, 69))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void useraccountCreationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useraccountCreationBtnActionPerformed
        // TODO add your handling code here:
        
         boolean isValid = true;
        String userName=usernameTextFld.getText();
        String password=pwdTextFld.getText();
        
         if (userName.isEmpty()) {
            int messageType = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, "User Name cannot be empty", "Error", messageType);
            usernameTextFld.setBackground(Color.red);
            isValid = false;
        } else {
            usernameTextFld.setBackground(Color.white);
        }

        String pswd = pwdTextFld.getText();
        String passwordRegEx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if (pswd.isEmpty()) {
            int messageType = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, "Password cannot be empty", "Error", messageType);
            pwdTextFld.setBackground(Color.red);
            isValid = false;
        } else if (!pswd.isEmpty() && !pswd.matches(passwordRegEx)) {
            int messageType = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, "Password not valid (Rules for password start-of-string\n" + "a digit must occur at least once\n"
                    + "a lower case letter must occur at least once\n"
                    + "an upper case letter must occur at least once\n"
                    + "a special character must occur at least once\n"
                    + "no whitespace allowed in the entire string\n"
                    + "anything, at least eight places though\n"
                    + "end-of-string", "Error", messageType);
            pwdTextFld.setBackground(Color.red);
            isValid = false;
        } else {
            pwdTextFld.setBackground(Color.white);
        }
        
        if(isValid){
        String RoleString="Patient";
        usernameTextFld.setText("");
        pwdTextFld.setText("");
        organization.getPatientDiretcory().createAndAddPatient(patient);
        UserAccount userAccount=organization.getUserAccountDirectory().createPatientUserAccount(userName, password, patient,organization.getSupportedRole().get(0));
    }  
    }//GEN-LAST:event_useraccountCreationBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 2];
      HospitalAdminWorkAreaJPanel hawjp = (HospitalAdminWorkAreaJPanel) component;
        hawjp.populatePatientsTable();
       
        layout.previous(userProcessContainer);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField pwdTextFld;
    private javax.swing.JButton useraccountCreationBtn;
    private javax.swing.JTextField usernameTextFld;
    // End of variables declaration//GEN-END:variables
}