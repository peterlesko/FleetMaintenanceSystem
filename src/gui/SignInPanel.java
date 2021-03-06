/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import fleet.FleetCoord;

/**
 *
 * @author Peter Lesko
 */
public class SignInPanel extends javax.swing.JPanel  
{
    private Gui mainFrame;   
    private String posSelect;    
    private FleetCoord flCoord;       
    
    SignInPanel(Gui frameIn, FleetCoord flCoordIn )
    {
        mainFrame = frameIn;
        flCoord = flCoordIn;        
        initComponents();
    }
           
    /**
     * Add the selected position to a variable.
     * @param posSelectIn 
     */
    public void checkSelectPos(String posSelectIn)
    {
        posSelect = posSelectIn;
    }
                
    private void checkPasword()
    {
        char[] strPassw  = jPasswordField.getPassword();   
        String passwString = new String(strPassw); 

        if(posSelect.equals("manager") && flCoord.checkPassword(posSelect, passwString))
        {
            mainFrame.showManagerPanel();
        }        
        else if(posSelect.equals("driver") && flCoord.checkPassword(posSelect, passwString))
        {
            mainFrame.showDriverPanel(); 
        }
        else if(posSelect.equals("mechanic") && flCoord.checkPassword(posSelect, passwString))
        {
            mainFrame.showMechanicPanel();
        }                           
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelEntPassw = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonSignIn = new javax.swing.JButton();
        jButtonReturn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(681, 392));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setPreferredSize(new java.awt.Dimension(681, 392));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Fleet management system");

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabelEntPassw.setText("Enter password");

        jPasswordField.setText("jPasswordField1");
        jPasswordField.setMinimumSize(new java.awt.Dimension(220, 120));
        jPasswordField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jButtonSignIn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSignIn.setText("Sign in");
        jButtonSignIn.setMaximumSize(new java.awt.Dimension(99, 23));
        jButtonSignIn.setMinimumSize(new java.awt.Dimension(99, 23));
        jButtonSignIn.setPreferredSize(new java.awt.Dimension(99, 23));
        jButtonSignIn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSignInActionPerformed(evt);
            }
        });

        jButtonReturn.setText("Return");
        jButtonReturn.setMaximumSize(new java.awt.Dimension(99, 23));
        jButtonReturn.setMinimumSize(new java.awt.Dimension(99, 23));
        jButtonReturn.setPreferredSize(new java.awt.Dimension(99, 23));
        jButtonReturn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelEntPassw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEntPassw)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSignInActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSignInActionPerformed
    {//GEN-HEADEREND:event_jButtonSignInActionPerformed
        this.checkPasword();
    }//GEN-LAST:event_jButtonSignInActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jPasswordFieldActionPerformed
    {//GEN-HEADEREND:event_jPasswordFieldActionPerformed

    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonReturnActionPerformed
    {//GEN-HEADEREND:event_jButtonReturnActionPerformed
        mainFrame.showGuiFourPanel(); 
    }//GEN-LAST:event_jButtonReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JButton jButtonSignIn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEntPassw;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField;
    // End of variables declaration//GEN-END:variables
}
