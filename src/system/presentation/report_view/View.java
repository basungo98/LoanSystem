package system.presentation.report_view;

import java.util.ArrayList;
import system.presentation.report_view.*;
import java.util.Observable;
import javax.swing.JOptionPane;
import system.logic.Client;
import system.presentation.loan_view.LoanTableModel;

public class View extends javax.swing.JFrame implements java.util.Observer {
    Controller controller;
    Model model;
    String clientId;
    
    public View() {
        initComponents();
        cleanView();
    }
      
    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Aviso", JOptionPane.PLAIN_MESSAGE);
    }
    
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
        
        Client client = model.getClient();
        if (client != null) {
            jlNameClient.setText(client.getName());
            if(client.getLoans() != null && client.getLoans().size() > 0){
                jtLoans.setModel(new LoanTableModel(client.getLoans()));
                jbLoansReport.setEnabled(true);
            }
        }
    }
    
    private void cleanView(){
        jbLoansReport.setEnabled(false);
        jbMPReport.setEnabled(false);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMain = new javax.swing.JPanel();
        jpHeader = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jlLogo = new javax.swing.JLabel();
        jpUserInformation = new javax.swing.JPanel();
        jbClientsReport = new javax.swing.JButton();
        tfId = new javax.swing.JTextField();
        jlIdText = new javax.swing.JLabel();
        jbLoansReport = new javax.swing.JButton();
        jbMPReport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLoans = new javax.swing.JTable();
        jbSearch = new javax.swing.JButton();
        jlNameClient = new javax.swing.JLabel();
        jbBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpMain.setBackground(new java.awt.Color(238, 248, 255));
        jpMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpHeader.setBackground(new java.awt.Color(102, 204, 255));

        jlTitle.setFont(new java.awt.Font("Malayalam Sangam MN", 1, 36)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlTitle.setText("Sistema de Préstamos");

        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/logo.png"))); // NOI18N
        jlLogo.setToolTipText("");

        javax.swing.GroupLayout jpHeaderLayout = new javax.swing.GroupLayout(jpHeader);
        jpHeader.setLayout(jpHeaderLayout);
        jpHeaderLayout.setHorizontalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLogo)
                .addGap(175, 175, 175)
                .addComponent(jlTitle)
                .addGap(0, 303, Short.MAX_VALUE))
        );
        jpHeaderLayout.setVerticalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jlTitle))
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlLogo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpMain.add(jpHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 80));

        jpUserInformation.setBackground(new java.awt.Color(238, 248, 255));
        jpUserInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reportes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(153, 153, 153))); // NOI18N

        jbClientsReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/clients-report.png"))); // NOI18N
        jbClientsReport.setText("Reporte de Clientes");
        jbClientsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClientsReportActionPerformed(evt);
            }
        });

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        jlIdText.setText("Cédula del cliente::");

        jbLoansReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/loans-report.png"))); // NOI18N
        jbLoansReport.setText("Reporte de Prestamos");
        jbLoansReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoansReportActionPerformed(evt);
            }
        });

        jbMPReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/monthly-payments-report.png"))); // NOI18N
        jbMPReport.setText("Reporte de Mensualidades");
        jbMPReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMPReportActionPerformed(evt);
            }
        });

        jtLoans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plazo", "Saldo", "Interes", "Cuota Mensual", "N° Abonos", "Total Abonos", "Fecha", "Estado"
            }
        ));
        jtLoans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLoansMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLoans);

        jbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/search.png"))); // NOI18N
        jbSearch.setText("Buscar");
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jlNameClient.setBackground(new java.awt.Color(0, 0, 0));
        jlNameClient.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlNameClient.setForeground(new java.awt.Color(153, 204, 255));
        jlNameClient.setToolTipText("");

        javax.swing.GroupLayout jpUserInformationLayout = new javax.swing.GroupLayout(jpUserInformation);
        jpUserInformation.setLayout(jpUserInformationLayout);
        jpUserInformationLayout.setHorizontalGroup(
            jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUserInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbClientsReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jpUserInformationLayout.createSequentialGroup()
                        .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlIdText)
                            .addGroup(jpUserInformationLayout.createSequentialGroup()
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbSearch)))
                        .addGap(58, 58, 58)
                        .addComponent(jlNameClient, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbLoansReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbMPReport, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpUserInformationLayout.setVerticalGroup(
            jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUserInformationLayout.createSequentialGroup()
                .addComponent(jbClientsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpUserInformationLayout.createSequentialGroup()
                        .addComponent(jlIdText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlNameClient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLoansReport, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbMPReport, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpMain.add(jpUserInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 830, 550));

        jbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/back.png"))); // NOI18N
        jbBack.setText("Regresar");
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });
        jpMain.add(jbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 640, 125, 55));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpMain, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbClientsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClientsReportActionPerformed
        
        boolean success = controller.generateClientReport();
        if(success){
            showMessageDialog("El reporte fue generado exitosamente.");
        } else {
            showErrorDialog("No fue posible generar el reporte.");
        }
    }//GEN-LAST:event_jbClientsReportActionPerformed

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
        jtLoans.setModel(new LoanTableModel(new ArrayList<>()));
        controller.showClientView();
        tfId.setText("");
        cleanView();
    }//GEN-LAST:event_jbBackActionPerformed

    private void jtLoansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLoansMouseClicked
        if(evt.getClickCount() == 1){
            jbMPReport.setEnabled(true);
        }
    }//GEN-LAST:event_jtLoansMouseClicked

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        clientId = tfId.getText();
        if(clientId.isEmpty()) {
            showErrorDialog("Para buscar un cliente debe digitar la cédula.");
        } else if(!controller.userExist(clientId)) {
            showErrorDialog("No existe un cliente con el número de cédula: " + clientId);
        } else {
            cleanView();
            controller.getClient(clientId);
        }

    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbLoansReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoansReportActionPerformed
        if(clientId.isEmpty()) {
            showErrorDialog("Para buscar un cliente debe digitar la cédula.");
        } else if(!controller.userExist(clientId)) {
            showErrorDialog("No existe un cliente con el número de cédula: " + clientId);
        } else {
            boolean success = controller.generateLoanReport(clientId);
            if(success){
                showMessageDialog("El reporte fue generado exitosamente.");
            } else {
                showErrorDialog("No fue posible generar el reporte.");
            }
        }
    }//GEN-LAST:event_jbLoansReportActionPerformed

    private void jbMPReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMPReportActionPerformed
        if(clientId.isEmpty()) {
            showErrorDialog("Para buscar un cliente debe digitar la cédula.");
        } else if(!controller.userExist(clientId)) {   
            showErrorDialog("No existe un cliente con el número de cédula: " + clientId);
        } else {
            int selectedRow = jtLoans.getSelectedRow();
            
            if(selectedRow >= 0){
               boolean success = controller.generateMonthlyPaymentReport(clientId, selectedRow);
                if(success){
                    showMessageDialog("El reporte fue generado exitosamente.");
                } else {
                    showErrorDialog("No fue posible generar el reporte.");
                }
            } else{
                 showErrorDialog("Debe seleccionar un préstamo de la lista.");
                 jbMPReport.setEnabled(false);
            }
                } 
    }//GEN-LAST:event_jbMPReportActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbClientsReport;
    private javax.swing.JButton jbLoansReport;
    private javax.swing.JButton jbMPReport;
    private javax.swing.JButton jbSearch;
    private javax.swing.JLabel jlIdText;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlNameClient;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JPanel jpMain;
    private javax.swing.JPanel jpUserInformation;
    private javax.swing.JTable jtLoans;
    private javax.swing.JTextField tfId;
    // End of variables declaration//GEN-END:variables
}
