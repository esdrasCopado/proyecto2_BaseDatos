/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import entities.Category;
import entities.Costumer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;
import persistence.CategoryRepositoryImp;
import persistence.CostumerRepositoryImp;
import persistence.EntityManageRepository;

/**
 *
 * @author copad
 */
public class windowCostumer extends javax.swing.JFrame {

    private DefaultTableModel modelo=new DefaultTableModel();
    EntityManager entityManage;
    /**
     * Creates new form windowCostumer
     */
    public windowCostumer() {
        initComponents();
        EntityManageRepository entityManage=new EntityManageRepository();
        this.entityManage=entityManage.getEntityManager();
        ModeloTabla();
        actualizarTabla();
    }
    public void actualizarTabla(){

        
        CostumerRepositoryImp costumerRepository=new CostumerRepositoryImp(entityManage);
        String datos[] =new String[5];
        try {
            List<Costumer> ob = new ArrayList<>();
            ob=costumerRepository.findAll();
            
            for(int i=0;i<ob.size();i++){
                Costumer costumer=new Costumer();
                costumer=ob.get(i);
                datos[0]=String.valueOf(costumer.getId());
                datos[1]=String.valueOf(costumer.getRfc());
                datos[2]=String.valueOf(costumer.getName());
                datos[3]=String.valueOf(costumer.getAddress());
                datos[4]=String.valueOf(costumer.getPhone());
                modelo.addRow(datos);
            }
            TablaCostumer.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    
    }
    public void ModeloTabla() {

        modelo.addColumn("id");
        modelo.addColumn("RFC");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        TablaCostumer.setModel(modelo);

    }

    public void limpiarTabla() {
        for (int i = 0; i < TablaCostumer.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextRfc = new javax.swing.JTextField();
        jTextAddress = new javax.swing.JTextField();
        jTextPhone = new javax.swing.JTextField();
        jTextName = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCostumer = new javax.swing.JTable();
        jButtonActualizar = new javax.swing.JButton();
        jTextBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jTextID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("RFC");

        jLabel2.setText("Nombre");

        jLabel3.setText("Direccion");

        jLabel4.setText("Phone");

        jTextPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPhoneActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        TablaCostumer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaCostumer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCostumerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaCostumer);

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jTextBuscar.setText("Buscar Nombre o ID");
        jTextBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextBuscarMouseClicked(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("ID");

        jButton5.setText("Refresh Table");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonActualizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscar)))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(124, 124, 124))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBuscar))
                    .addComponent(jTextID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jTextAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGuardar)
                            .addComponent(jButtonActualizar))
                        .addGap(37, 37, 37))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPhoneActionPerformed

        
    }//GEN-LAST:event_jTextPhoneActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        
        EntityManageRepository entitiManage = new EntityManageRepository();
        CostumerRepositoryImp costomer = new CostumerRepositoryImp(entitiManage.getEntityManager());
        Costumer costumer = new Costumer();
        costumer.setName(jTextName.getText());
        costumer.setRfc(jTextRfc.getText());
        costumer.setAddress(jTextAddress.getText());
        costumer.setPhone(jTextPhone.getText());
        
        costomer.Save(costumer);
        costomer.commit();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void TablaCostumerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCostumerMouseClicked
        int seleccion=TablaCostumer.rowAtPoint(evt.getPoint());
        jTextID.setText(String.valueOf(TablaCostumer.getValueAt(seleccion, 0)));
        jTextRfc.setText(String.valueOf(TablaCostumer.getValueAt(seleccion,1)));
        jTextName.setText(String.valueOf(TablaCostumer.getValueAt(seleccion,2)));
        jTextAddress.setText(String.valueOf(TablaCostumer.getValueAt(seleccion,3)));
        jTextPhone.setText(String.valueOf(TablaCostumer.getValueAt(seleccion,4)));
        
    }//GEN-LAST:event_TablaCostumerMouseClicked

    private void jTextBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextBuscarMouseClicked
        jTextBuscar.setText("");
    }//GEN-LAST:event_jTextBuscarMouseClicked

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        
        CostumerRepositoryImp CostumerRepository = new CostumerRepositoryImp(entityManage);
        Costumer costumer;
        costumer = CostumerRepository.fine(Integer.valueOf(jTextID.getText()));
        System.out.println(costumer);
        costumer.setName(jTextName.getText());
        costumer.setAddress(jTextAddress.getText());
        costumer.setPhone(jTextPhone.getText());
        
        
        CostumerRepository.Save(costumer);
        CostumerRepository.commit();
        limpiarTabla();
        actualizarTabla();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        List<Costumer> costumer=new ArrayList<>();
        Costumer costumerID;
        CostumerRepositoryImp categoryRepository=new CostumerRepositoryImp(entityManage);
        try {
            int id = Integer.parseInt(jTextBuscar.getText());
            costumerID = categoryRepository.fine(id);
            limpiarTabla();
            Object[] ob=new Object[5];
                ob[0]=String.valueOf(costumerID.getId());
                ob[1]=String.valueOf(costumerID.getRfc());
                ob[2]=String.valueOf(costumerID.getName());
                ob[3]=String.valueOf(costumerID.getAddress());
                ob[4]=String.valueOf(costumerID.getPhone());
                
            modelo.addRow(ob);
            
        } catch (Exception e) {
            String name = jTextBuscar.getText();
            costumer = categoryRepository.findByName(name);
            for (int i = 0; i < costumer.size(); i++) {
                limpiarTabla();
                Object[] ob = new Object[5];
                ob[0] = String.valueOf(costumer.get(i).getId());
                ob[1] = String.valueOf(costumer.get(i).getRfc());
                ob[2] = String.valueOf(costumer.get(i).getName());
                ob[3] = String.valueOf(costumer.get(i).getAddress());
                ob[4] = String.valueOf(costumer.get(i).getPhone());

                modelo.addRow(ob);
            }
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpiarTabla();
        actualizarTabla();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCostumer;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextAddress;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextID;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextPhone;
    private javax.swing.JTextField jTextRfc;
    // End of variables declaration//GEN-END:variables
}
