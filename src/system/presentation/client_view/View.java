package system.presentation.client_view;

import java.util.List;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import system.logic.Canton;
import system.logic.Client;
import system.logic.District;
import system.logic.Province;

public class View extends javax.swing.JFrame implements java.util.Observer {
    static final String ALAJUELA = "Alajuela";
    static final String CARTAGO = "Cartago";
    static final String GUANACASTE = "Guanacaste";
    static final String HEREDIA = "Heredia";
    static final String LIMON = "Limón";
    static final String PUNTARENAS = "Puntarenas";
    static final String SAN_JOSE = "San José";
    static final String[] PROVINCES = {ALAJUELA, CARTAGO, GUANACASTE, HEREDIA, LIMON, PUNTARENAS, SAN_JOSE};
    
    Controller controller;
    Model model;
    
    public View() {
        initComponents();
        setProvinceLabels();
    }
    
    public void baseConfiguration() {
        // Add any base configuration
    }
    
    private void setProvinceLabels() {
        jlAlajuela.setText(PROVINCES[0]);
        jlCartago.setText(PROVINCES[1]);
        jlGuanacaste.setText(PROVINCES[2]);
        jlHeredia.setText(PROVINCES[3]);
        jlLimon.setText(PROVINCES[4]);
        jlPuntarenas.setText(PROVINCES[5]);
        jlSanJose.setText(PROVINCES[6]);
    }
    
    public void setController(Controller controller){
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }
    
    public void setModel(Model model){
        this.model = model;
         model.addObserver(this);
    }

    public Model getModel() {
        return model;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Client client = model.getClient();
        tfId.setText(client.getId());
        tfName.setText(client.getName());
        String provinceName = client.getProvince().getName();
        String cantonName = client.getCanton().getName();
        String distritoName = client.getDistrict().getName();
        tfProvince.setText(provinceName);
        updateCbCantons(provinceName);
        jlSelectedMap.setIcon(getMapImageIcon(provinceName));
        cbCanton.setSelectedItem(cantonName);
        cbDistrict.setSelectedItem(distritoName);
    }
    
    private ImageIcon createImageIcon(String path) {
        if(path != null && !path.isEmpty()) {
            return new javax.swing.ImageIcon(getClass().getResource(path));
        }
        
        return null;
    }
    
    private ImageIcon getMapImageIcon(String province) {
        if(province.equals(PROVINCES[0])) {
            return createImageIcon("/system/assets/maps/alajuela.png");
        } else if(province.equals(PROVINCES[1])) {
            return createImageIcon("/system/assets/maps/cartago.png");
        } else if(province.equals(PROVINCES[2])) {
            return createImageIcon("/system/assets/maps/guanacaste.png");
        } else if(province.equals(PROVINCES[3])) {
            return createImageIcon("/system/assets/maps/heredia.png");
        } else if(province.equals(PROVINCES[4])) {
            return createImageIcon("/system/assets/maps/limon.png");
        } else if(province.equals(PROVINCES[5])) {
            return createImageIcon("/system/assets/maps/puntarenas.png");
        } else if(province.equals(PROVINCES[6])) {
            return createImageIcon("/system/assets/maps/san-jose.png");
        }
        
        return null;
    }
    
    private void updateCbCantons(String provinceLabel) {
        cbCanton.removeAllItems();
        cbDistrict.removeAllItems();
        if(!provinceLabel.isEmpty()) {
            List<Canton> cantons = controller.getCantons(provinceLabel);
            
            for(int i = 0; i < cantons.size(); i++) {
                cbCanton.addItem(cantons.get(i).getName());
            }
        }
    }
    
    private void updateCbDistricts(String cantonName) {
        cbDistrict.removeAllItems();
        if(!cantonName.isEmpty()) {
            List<District> districts = controller.getDistricts(tfProvince.getText(), cantonName);

            for(int i = 0; i < districts.size(); i++) {
                cbDistrict.addItem(districts.get(i).getName());
            }
        }
    }
    
    private void handleJLabelClicked(String province) {
        tfProvince.setText(province);
        jlSelectedMap.setIcon(getMapImageIcon(province));
        updateCbCantons(province);
    }
    
    private void handleJLabelEntered(String province) {
        jlFocusMap.setIcon(getMapImageIcon(province));
    }
    
    private void handleJLabelExited() {
        jlFocusMap.setIcon(null);
    }
    
    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
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
        jpMap = new javax.swing.JPanel();
        jlGuanacaste = new javax.swing.JLabel();
        jlAlajuela = new javax.swing.JLabel();
        jlHeredia = new javax.swing.JLabel();
        jlSanJose = new javax.swing.JLabel();
        jlCartago = new javax.swing.JLabel();
        jlLimon = new javax.swing.JLabel();
        jlPuntarenas = new javax.swing.JLabel();
        jlSelectedMap = new javax.swing.JLabel();
        jlFocusMap = new javax.swing.JLabel();
        jlMainMap = new javax.swing.JLabel();
        jpUserInformation = new javax.swing.JPanel();
        jlId = new javax.swing.JLabel();
        jlName = new javax.swing.JLabel();
        jlProvince = new javax.swing.JLabel();
        jsConton = new javax.swing.JLabel();
        jlDistrict = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfProvince = new javax.swing.JTextField();
        cbCanton = new javax.swing.JComboBox<>();
        cbDistrict = new javax.swing.JComboBox<>();
        jpButtonGroup = new javax.swing.JPanel();
        jbSave = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jbSearch = new javax.swing.JButton();
        jbLoan = new javax.swing.JButton();
        jpHeader = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jlLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpMain.setBackground(new java.awt.Color(238, 248, 255));
        jpMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpMap.setBackground(new java.awt.Color(238, 248, 255));
        jpMap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlGuanacaste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlGuanacasteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlGuanacasteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlGuanacasteMouseExited(evt);
            }
        });
        jpMap.add(jlGuanacaste, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 120, 40));

        jlAlajuela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAlajuelaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlAlajuelaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlAlajuelaMouseExited(evt);
            }
        });
        jpMap.add(jlAlajuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 80, 80));

        jlHeredia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlHerediaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlHerediaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlHerediaMouseExited(evt);
            }
        });
        jpMap.add(jlHeredia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 50, 70));

        jlSanJose.setToolTipText("");
        jlSanJose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSanJoseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlSanJoseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlSanJoseMouseExited(evt);
            }
        });
        jpMap.add(jlSanJose, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 210, 60, 40));

        jlCartago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCartagoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlCartagoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlCartagoMouseExited(evt);
            }
        });
        jpMap.add(jlCartago, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 80, 40));

        jlLimon.setToolTipText("");
        jlLimon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlLimonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlLimonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlLimonMouseExited(evt);
            }
        });
        jpMap.add(jlLimon, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 60, 90));

        jlPuntarenas.setToolTipText("");
        jlPuntarenas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlPuntarenasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlPuntarenasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlPuntarenasMouseExited(evt);
            }
        });
        jpMap.add(jlPuntarenas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 80, 60));
        jpMap.add(jlSelectedMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 526, 506));
        jpMap.add(jlFocusMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 526, 506));

        jlMainMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/maps/costa-rica.png"))); // NOI18N
        jpMap.add(jlMainMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jpMain.add(jpMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, -1));

        jpUserInformation.setBackground(new java.awt.Color(238, 248, 255));
        jpUserInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(153, 153, 153))); // NOI18N

        jlId.setText("Cedula:");

        jlName.setText("Nombre:");

        jlProvince.setText("Província:");
        jlProvince.setToolTipText("");

        jsConton.setText("Canton:");
        jsConton.setToolTipText("");

        jlDistrict.setText("Distrito:");
        jlDistrict.setToolTipText("");

        tfProvince.setEditable(false);

        cbCanton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCantonItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jpUserInformationLayout = new javax.swing.GroupLayout(jpUserInformation);
        jpUserInformation.setLayout(jpUserInformationLayout);
        jpUserInformationLayout.setHorizontalGroup(
            jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUserInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpUserInformationLayout.createSequentialGroup()
                        .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlName)
                            .addComponent(jlProvince)
                            .addComponent(jsConton)
                            .addComponent(jlDistrict))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbCanton, 0, 200, Short.MAX_VALUE)
                                .addComponent(cbDistrict, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tfProvince, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpUserInformationLayout.createSequentialGroup()
                        .addComponent(jlId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpUserInformationLayout.setVerticalGroup(
            jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUserInformationLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlProvince))
                .addGap(20, 20, 20)
                .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsConton))
                .addGap(18, 18, 18)
                .addGroup(jpUserInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDistrict))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jpMain.add(jpUserInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 325, -1));

        jpButtonGroup.setBackground(new java.awt.Color(238, 248, 255));
        jpButtonGroup.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpButtonGroup.setToolTipText("");

        jbSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/diskette.png"))); // NOI18N
        jbSave.setText("Guardar");
        jbSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveActionPerformed(evt);
            }
        });

        jbUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/edit.png"))); // NOI18N
        jbUpdate.setText("Actualizar");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/search.png"))); // NOI18N
        jbSearch.setText("Buscar");
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jbLoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/assets/icons/loan.png"))); // NOI18N
        jbLoan.setText("Prestamos");
        jbLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpButtonGroupLayout = new javax.swing.GroupLayout(jpButtonGroup);
        jpButtonGroup.setLayout(jpButtonGroupLayout);
        jpButtonGroupLayout.setHorizontalGroup(
            jpButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonGroupLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jbSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jpButtonGroupLayout.setVerticalGroup(
            jpButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSave, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpMain.add(jpButtonGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, -1));

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
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpMain.add(jpHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed
        String id = tfId.getText();
        String name = tfName.getText();
        String provinceName = tfProvince.getText();
        String cantonName = String.valueOf(cbCanton.getSelectedItem());
        String districtName = String.valueOf(cbDistrict.getSelectedItem());
        if(id.isEmpty() || name.isEmpty() || provinceName.isEmpty() || cantonName.isEmpty() || districtName.isEmpty()) {
            showErrorDialog("Todos los campos son requeridos.");
        } else {
            Province province = controller.getProvince(provinceName);
            Canton canton = controller.getCanton(provinceName, cantonName);
            District district = controller.getDistrict(provinceName, cantonName, districtName);
            controller.addClient(new Client(id, name, province, canton, district));
        }
    }//GEN-LAST:event_jbSaveActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        String id = tfId.getText();
        if(id.isEmpty()) {
            showErrorDialog("Para buscar un cliente debe digitar la cedula.");
        } else {
            controller.getClient(tfId.getText());
        }
        
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLoanActionPerformed

    private void jlGuanacasteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGuanacasteMouseClicked
        handleJLabelClicked(jlGuanacaste.getText());
    }//GEN-LAST:event_jlGuanacasteMouseClicked

    private void jlGuanacasteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGuanacasteMouseEntered
        handleJLabelEntered(jlGuanacaste.getText());
    }//GEN-LAST:event_jlGuanacasteMouseEntered

    private void jlGuanacasteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGuanacasteMouseExited
        handleJLabelExited();
    }//GEN-LAST:event_jlGuanacasteMouseExited

    private void jlAlajuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAlajuelaMouseClicked
        handleJLabelClicked(jlAlajuela.getText());
    }//GEN-LAST:event_jlAlajuelaMouseClicked

    private void jlAlajuelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAlajuelaMouseEntered
        handleJLabelEntered(jlAlajuela.getText());
    }//GEN-LAST:event_jlAlajuelaMouseEntered

    private void jlAlajuelaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAlajuelaMouseExited
        handleJLabelExited();
    }//GEN-LAST:event_jlAlajuelaMouseExited

    private void jlHerediaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlHerediaMouseClicked
        handleJLabelClicked(jlHeredia.getText());
    }//GEN-LAST:event_jlHerediaMouseClicked

    private void jlHerediaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlHerediaMouseEntered
        handleJLabelEntered(jlHeredia.getText());
    }//GEN-LAST:event_jlHerediaMouseEntered

    private void jlHerediaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlHerediaMouseExited
        handleJLabelExited();
    }//GEN-LAST:event_jlHerediaMouseExited

    private void jlSanJoseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSanJoseMouseClicked
        handleJLabelClicked(jlSanJose.getText());
    }//GEN-LAST:event_jlSanJoseMouseClicked

    private void jlSanJoseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSanJoseMouseEntered
        handleJLabelEntered(jlSanJose.getText());
    }//GEN-LAST:event_jlSanJoseMouseEntered

    private void jlSanJoseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSanJoseMouseExited
        handleJLabelExited();
    }//GEN-LAST:event_jlSanJoseMouseExited

    private void jlCartagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCartagoMouseClicked
        handleJLabelClicked(jlCartago.getText());
    }//GEN-LAST:event_jlCartagoMouseClicked

    private void jlCartagoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCartagoMouseEntered
        handleJLabelEntered(jlCartago.getText());
    }//GEN-LAST:event_jlCartagoMouseEntered

    private void jlCartagoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCartagoMouseExited
        handleJLabelExited();
    }//GEN-LAST:event_jlCartagoMouseExited

    private void jlLimonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlLimonMouseClicked
        handleJLabelClicked(jlLimon.getText());
    }//GEN-LAST:event_jlLimonMouseClicked

    private void jlLimonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlLimonMouseEntered
        handleJLabelEntered(jlLimon.getText());
    }//GEN-LAST:event_jlLimonMouseEntered

    private void jlLimonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlLimonMouseExited
        handleJLabelExited();
    }//GEN-LAST:event_jlLimonMouseExited

    private void jlPuntarenasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPuntarenasMouseClicked
        handleJLabelClicked(jlPuntarenas.getText());
    }//GEN-LAST:event_jlPuntarenasMouseClicked

    private void jlPuntarenasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPuntarenasMouseEntered
        handleJLabelEntered(jlPuntarenas.getText());
    }//GEN-LAST:event_jlPuntarenasMouseEntered

    private void jlPuntarenasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPuntarenasMouseExited
        handleJLabelExited();
    }//GEN-LAST:event_jlPuntarenasMouseExited

    private void cbCantonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCantonItemStateChanged
        if(cbCanton.getSelectedItem() != null) {
            updateCbDistricts(cbCanton.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbCantonItemStateChanged

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
    private javax.swing.JComboBox<String> cbCanton;
    private javax.swing.JComboBox<String> cbDistrict;
    private javax.swing.JButton jbLoan;
    private javax.swing.JButton jbSave;
    private javax.swing.JButton jbSearch;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JLabel jlAlajuela;
    private javax.swing.JLabel jlCartago;
    private javax.swing.JLabel jlDistrict;
    private javax.swing.JLabel jlFocusMap;
    private javax.swing.JLabel jlGuanacaste;
    private javax.swing.JLabel jlHeredia;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlLimon;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlMainMap;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlProvince;
    private javax.swing.JLabel jlPuntarenas;
    private javax.swing.JLabel jlSanJose;
    private javax.swing.JLabel jlSelectedMap;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpButtonGroup;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JPanel jpMain;
    private javax.swing.JPanel jpMap;
    private javax.swing.JPanel jpUserInformation;
    private javax.swing.JLabel jsConton;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfProvince;
    // End of variables declaration//GEN-END:variables
}
