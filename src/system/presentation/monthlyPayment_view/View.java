package system.presentation.monthlyPayment_view;

import static java.lang.Integer.parseInt;
import java.util.List;
import system.presentation.monthlyPayment_view.*;
import java.util.Observable;
import javax.swing.JOptionPane;
import system.logic.Client;
import system.logic.MonthlyPayment;

public class View extends javax.swing.JFrame implements java.util.Observer {
    Controller controller;
    Model model;
    String clientId;
    int loanIndex;
    
    public View() {
        initComponents();
    }
    
    public void baseConfiguration(String id, int index) {
        if (id.isEmpty() || !controller.userExist(id)) {
            showErrorDialog("No es posible ver la pantalla de prestamos.\nVerifique lo siguiente:\n1. El campo de cedula no puede estar vacio.\n2.No existe un cliente asociado a este numero de cedula.");
            controller.showLoanView(id);
        } else {
            clientId = id;
            loanIndex = index;
            controller.getClient(id);
        }
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
            if(client.getLoans() != null && client.getLoans().size() > 0){
                List<MonthlyPayment> mps = client.getLoans().get(loanIndex).getMonthlyPayments();
                jtMonthlyPayments.setModel(new MonthlyPaymentTableModel(mps));
            }
        }
    }
    
    public void cleanFields(){
          tfExtraordinaryPayments.setText("");
    }

     private boolean isNumeric(String strNum) {
        if (strNum == null || strNum.isEmpty()) {
            return false;
        }

        try {
            parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMonthlyPayments = new javax.swing.JTable();
        jpUserInformation = new javax.swing.JPanel();
        jbExtraordinaryPayments = new javax.swing.JButton();
        tfExtraordinaryPayments = new javax.swing.JTextField();
        jlExtraordinaryPayment = new javax.swing.JLabel();
        jbPaidMonth = new javax.swing.JButton();
        jbTotalPay = new javax.swing.JButton();
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

        jtMonthlyPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Saldo", "Intéres", "Amortización", "Cuota", "Fecha", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jtMonthlyPayments);

        jpMain.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 600, 370));

        jpUserInformation.setBackground(new java.awt.Color(238, 248, 255));
        jpUserInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(153, 153, 153))); // NOI18N

        jbExtraordinaryPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/loan.png"))); // NOI18N
        jbExtraordinaryPayments.setText("Pago Extraordinario");
        jbExtraordinaryPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExtraordinaryPaymentsActionPerformed(evt);
            }
        });

        jlExtraordinaryPayment.setText("Pago Extraordinario:");

        jbPaidMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/loan.png"))); // NOI18N
        jbPaidMonth.setText("Pagar Mes Actual");
        jbPaidMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPaidMonthActionPerformed(evt);
            }
        });

        jbTotalPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/loan.png"))); // NOI18N
        jbTotalPay.setText("Pagar Totalidad");
        jbTotalPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTotalPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpUserInformationLayout = new javax.swing.GroupLayout(jpUserInformation);
        jpUserInformation.setLayout(jpUserInformationLayout);
        jpUserInformationLayout.setHorizontalGroup(
            jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUserInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbExtraordinaryPayments, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(tfExtraordinaryPayments)
                    .addComponent(jbPaidMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpUserInformationLayout.createSequentialGroup()
                        .addComponent(jlExtraordinaryPayment)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbTotalPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpUserInformationLayout.setVerticalGroup(
            jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUserInformationLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlExtraordinaryPayment)
                .addGap(18, 18, 18)
                .addComponent(tfExtraordinaryPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jbExtraordinaryPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbPaidMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jpMain.add(jpUserInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 240, 370));

        jbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/loan.png"))); // NOI18N
        jbBack.setText("Regresar");
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });
        jpMain.add(jbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 620, 210, 55));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
         controller.showLoanView(clientId);
         cleanFields();
    }//GEN-LAST:event_jbBackActionPerformed

    private void jbExtraordinaryPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExtraordinaryPaymentsActionPerformed
        String extraordinaryPayment = tfExtraordinaryPayments.getText();
        
        if(isNumeric(extraordinaryPayment)){
            double extPay = Double.parseDouble(extraordinaryPayment);
            
            if(extPay > 0){
                controller.payExtraordinaryPayment( loanIndex, extPay);
                showMessageDialog("El abono extraordinario ha sido realizado exitosamente.");
                cleanFields();
            } else {
                 showErrorDialog("El campo de abono extraordinario no puede estar vacio, y debe ser númerico.");
            }
        } else {
           showErrorDialog("El campo de abono extraordinario no puede estar vacio, y debe ser númerico.");
        }
    }//GEN-LAST:event_jbExtraordinaryPaymentsActionPerformed

    private void jbPaidMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPaidMonthActionPerformed
        controller.payCurrentMonth(loanIndex);
        showMessageDialog("El pago del mes actual se ha realizado exitosamente");
    }//GEN-LAST:event_jbPaidMonthActionPerformed

    private void jbTotalPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTotalPayActionPerformed
        controller.payTotal(loanIndex);
        showMessageDialog("La totalidad del préstamo ha sido cancelado exitosamente");
        jbExtraordinaryPayments.setEnabled(false);
        jbPaidMonth.setEnabled(false);
        jbTotalPay.setEnabled(false);
    }//GEN-LAST:event_jbTotalPayActionPerformed

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
    private javax.swing.JButton jbExtraordinaryPayments;
    private javax.swing.JButton jbPaidMonth;
    private javax.swing.JButton jbTotalPay;
    private javax.swing.JLabel jlExtraordinaryPayment;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JPanel jpMain;
    private javax.swing.JPanel jpUserInformation;
    private javax.swing.JTable jtMonthlyPayments;
    private javax.swing.JTextField tfExtraordinaryPayments;
    // End of variables declaration//GEN-END:variables
}
