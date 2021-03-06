/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.presentation.splash_view;

import java.util.Observable;
import javax.swing.JOptionPane;



public class View extends javax.swing.JFrame implements java.util.Observer {
    Controller controller;
    Model model;
    
    public void setController(Controller controller){
        this.controller=controller;
    }

    public Controller getController() {
        return controller;
    }
    
    public void setModel(Model model){
        this.model=model;
         model.addObserver(this);
    }

    public Model getModel() {
        return model;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
    }
    
    public void progressBarSetUp () {
        try {
            for(int i = 0; i <= 1; i++) {
                Thread.sleep(40);
                loadingBar.setValue(i);
                jlProgress.setText(i + "%");
            }
            
            controller.showClientView();
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
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

        jpBackground = new javax.swing.JPanel();
        jlProgress = new javax.swing.JLabel();
        jlTitle = new javax.swing.JLabel();
        jlLoading = new javax.swing.JLabel();
        loadingBar = new javax.swing.JProgressBar();
        jlBackgroundFamily = new javax.swing.JLabel();
        jlBackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpBackground.setBackground(new java.awt.Color(0, 255, 255));
        jpBackground.setForeground(new java.awt.Color(255, 255, 255));
        jpBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlProgress.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        jlProgress.setForeground(new java.awt.Color(255, 255, 255));
        jpBackground.add(jlProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 40, 30));

        jlTitle.setFont(new java.awt.Font("Malayalam Sangam MN", 1, 32)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlTitle.setText("Sistema de Gesti??n de Pr??stamos");
        jpBackground.add(jlTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jlLoading.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        jlLoading.setForeground(new java.awt.Color(255, 255, 255));
        jlLoading.setText("Loading...");
        jpBackground.add(jlLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 30));
        jpBackground.add(loadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 640, 10));

        jlBackgroundFamily.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/bg/family.png"))); // NOI18N
        jpBackground.add(jlBackgroundFamily, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jlBackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/bg/sky.png"))); // NOI18N
        jpBackground.add(jlBackgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlBackgroundFamily;
    private javax.swing.JLabel jlBackgroundImage;
    private javax.swing.JLabel jlLoading;
    private javax.swing.JLabel jlProgress;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JProgressBar loadingBar;
    // End of variables declaration//GEN-END:variables

}
