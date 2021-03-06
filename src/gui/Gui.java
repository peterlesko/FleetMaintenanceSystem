/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import fleet.FleetCoord;
import java.awt.event.*; 
import java.io.*;

/**
 * @author Peter Lesko
 */
public class Gui extends javax.swing.JFrame implements Serializable
{
    private SignInPanel signInPan;
    private WorkerSelect workerSelct;
    private ManagerPanel managPan;
    private DriverPanel driverPan;
    private MechanicPanel mechPan;
    private FleetCoord flCoord;       
    private File file;
    
    /**
     * Creates new form GuiTwo
     */
    Gui()
    {            
        flCoord = FleetCoord.getFleetCoordObject();           
        signInPan = new SignInPanel(this, flCoord);
        workerSelct = new WorkerSelect(this);        
        driverPan = new DriverPanel(this, flCoord);                
        managPan = new ManagerPanel(this, flCoord, driverPan);
        mechPan = new MechanicPanel(this, flCoord);
        managPan.displayNotifPeriod();
        
        setContentPane(workerSelct);
        pack();
        setVisible(true);        
        addWindowListener(new EndProgram());             
        initComponents();              
    }
            
    private class EndProgram extends WindowAdapter  
    {
        /**
         * After window is closed by the user, the state of the application is saved.
         * @param e 
         */
        public void windowClosing(WindowEvent e)
        {
            flCoord.saveFleetCoordObject();
        }                
    }
    
    /**
     * Returns coordinating object 
     */
    public FleetCoord getFleetCoord()
    {
        return flCoord;
    }

    void removeManagerPanel()
    {
        remove(managPan);
        setContentPane(workerSelct);
        pack();
        setVisible(true);        
    }
       
    void removeDriverPanel()
    {
        remove(driverPan);
        setContentPane(workerSelct);
        pack();
        setVisible(true);        
    }

     void removeMechanicPanel()
    {
        remove(mechPan);
        setContentPane(workerSelct);
        pack();
        setVisible(true);        
    }
        
    void showGuiFourPanel()
    {
        remove(signInPan);
        setContentPane(workerSelct);
        pack();
        setVisible(true);
    }
    
    void showSignInPanel(String posSelIn)    
    {
        signInPan.checkSelectPos(posSelIn);
        remove(workerSelct);
        setContentPane(signInPan);
        pack();
        setVisible(true);      
    }

    void showManagerPanel()
    {
        remove(signInPan);
        setContentPane(managPan);
        pack();
        setVisible(true);
    }
    
    void showDriverPanel()
    {
        remove(signInPan);
        setContentPane(driverPan);
        pack();
        setVisible(true);
        driverPan.resetPreCheckReportForm();
    }

    void showMechanicPanel()
    {
        remove(workerSelct);
        setContentPane(mechPan);
        pack();
        setVisible(true);
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

        jPanelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Gui().setVisible(true);                                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelMain;
    // End of variables declaration//GEN-END:variables
}
