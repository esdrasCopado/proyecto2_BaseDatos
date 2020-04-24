/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import entities.Category;
import entities.Product;
import entities.Provider;
import entities.Sale;
import entities.Saleitem;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;
import persistence.EntityManageRepository;
import persistence.ManagerFactoryRepository;
import persistence.ProductRepositoryImp;
import persistence.SaleItemRepositoryImp;
import persistence.SaleRepositoryImp;

/**
 *
 * @author copad
 */
public class windowSaleItem extends javax.swing.JFrame {

    /**
     * Creates new form windowSaleItem
     */
    
    private EntityManager entityManager;
    private DefaultTableModel modelo = new DefaultTableModel();
    private List<Product> obProduct = new ArrayList<>();
    private List<Sale> obSale = new ArrayList<>();
    private ManagerFactoryRepository managerFactory;
    
    
    public windowSaleItem(ManagerFactoryRepository managerFactory) {
        initComponents();
        EntityManageRepository entityManager = new EntityManageRepository();
        this.managerFactory=managerFactory;
        this.entityManager = entityManager.getEntityManager();
        this.entityManager = this.managerFactory.createEntityManager();
        getProduct();
        getSale();
        ModeloTabla();
        actualizarTabla();
    }

    public void actualizarTabla() {

        SaleItemRepositoryImp SaleItemRepository = new SaleItemRepositoryImp(entityManager);
        String datos[] = new String[6];
        try {
            List<Saleitem> ob = new ArrayList<>();
            ob = SaleItemRepository.findAll();

            for (int i = 0; i < ob.size(); i++) {
                Saleitem saleitem = new Saleitem();
                saleitem = (Saleitem) ob.get(i);
                datos[0] = String.valueOf(saleitem.getId());
                datos[1] = String.valueOf(saleitem.getPrice());
                datos[2] = String.valueOf(saleitem.getQuantity());
                datos[3] = String.valueOf(saleitem.getTotal());
                datos[4] = String.valueOf(saleitem.getProduct().getId());
                datos[5] = String.valueOf(saleitem.getSale().getId());

                modelo.addRow(datos);
            }
            TablaProduct.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

    }

    public void limpiarTabla() {
        for (int i = 0; i < TablaProduct.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void ModeloTabla() {

        modelo.addColumn("id");
        modelo.addColumn("precio");
        modelo.addColumn("cantidad");
        modelo.addColumn("total");
        modelo.addColumn("producto");
        modelo.addColumn("sale");
        TablaProduct.setModel(modelo);

    }

    public void getProduct() {
        ProductRepositoryImp productRepository = new ProductRepositoryImp(entityManager);
        obProduct = productRepository.findAll();
        Product product;
        try {
            for (int i = 0; i < obProduct.size(); i++) {
                product = (Product) obProduct.get(i);

                jComboBoxProduct.addItem(product);
            }
        } catch (Exception e) {
            System.out.println("ocurrio un problema " + e.getMessage());
        }

    }

    public void getSale() {

        SaleRepositoryImp saleRepositoryImp=new SaleRepositoryImp(entityManager);
        obSale=saleRepositoryImp.findAll();
        Sale sale;
        try {
            for (int i = 0; i < obSale.size(); i++) {
                sale = (Sale) obSale.get(i);
                jComboBoxSale.addItem(sale);
            }
        } catch (Exception e) {
            System.out.println("ocurrio un problema " + e.getMessage());
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
        jLabel5 = new javax.swing.JLabel();
        jComboBoxSale = new javax.swing.JComboBox<Sale>();
        jComboBoxProduct = new javax.swing.JComboBox<Product>();
        jTextFieldPrice = new javax.swing.JTextField();
        jTextFieldQuantity = new javax.swing.JTextField();
        jTextFieldTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProduct = new javax.swing.JTable();
        jTextID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setText("Product");

        jLabel2.setText("Sale");

        jLabel3.setText("Precio");

        jLabel4.setText("Cantidad");

        jLabel5.setText("Total");

        jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TablaProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProduct);

        jTextID.setEditable(false);

        jLabel8.setText("ID");

        jTextBuscar.setText("Buscar por ID ");
        jTextBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextBuscarMouseClicked(evt);
            }
        });
        jTextBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("Buscar");

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Refresh Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(100, 100, 100)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxSale, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(168, 168, 168))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SaleItemRepositoryImp saleItemRepository = new SaleItemRepositoryImp(entityManager);
        Saleitem saleItem = new Saleitem();
        saleItem.setProduct((Product) jComboBoxProduct.getSelectedItem());
        saleItem.setSale((Sale) jComboBoxSale.getSelectedItem());
        saleItem.setPrice(Float.parseFloat(jTextFieldPrice.getText()));
        saleItem.setQuantity(Integer.parseInt(jTextFieldQuantity.getText()));
        saleItem.setTotal(Float.parseFloat(jTextFieldTotal.getText()));

        saleItemRepository.Save(saleItem);
        saleItemRepository.commit();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void TablaProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductMouseClicked
        Product product;
        Sale sale;

        int seleccion = TablaProduct.rowAtPoint(evt.getPoint());
        jTextID.setText(String.valueOf(TablaProduct.getValueAt(seleccion, 0)));
        jTextFieldPrice.setText(String.valueOf(TablaProduct.getValueAt(seleccion, 1)));
        jTextFieldQuantity.setText(String.valueOf(TablaProduct.getValueAt(seleccion, 2)));
        jTextFieldTotal.setText(String.valueOf(TablaProduct.getValueAt(seleccion, 3)));

        int number;
        if (obProduct.size() > obProduct.size()) {
            number = obProduct.size();
        } else {
            number = obProduct.size();
        }

        for (int i = 0; i < number; i++) {
            if (obSale.size() > i) {

                product = (Product) obProduct.get(i);
                String ob = String.valueOf(TablaProduct.getValueAt(seleccion, 4));
                if (product.getId() == Integer.valueOf(ob)) {
                    jComboBoxProduct.setSelectedItem(product);
                }
            }
            if (obSale.size() > i) {
                sale = (Sale) obSale.get(i);

                String ob = String.valueOf(TablaProduct.getValueAt(seleccion, 5));
                if (sale.getId() == Integer.valueOf(ob)) {
                    jComboBoxSale.setSelectedItem(sale);
                }
            }

        }
    }//GEN-LAST:event_TablaProductMouseClicked

    private void jTextBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextBuscarMouseClicked
        jTextBuscar.setText("");
    }//GEN-LAST:event_jTextBuscarMouseClicked

    private void jTextBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBuscarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Saleitem saleItem;
        SaleItemRepositoryImp SaleItemRepository = new SaleItemRepositoryImp(entityManager);
        int id = Integer.parseInt(jTextBuscar.getText());
        saleItem = SaleItemRepository.fine(id);
        limpiarTabla();
        Object[] ob = new Object[6];
        ob[0] = String.valueOf(saleItem.getId());
        ob[1] = String.valueOf(saleItem.getPrice());
        ob[2] = String.valueOf(saleItem.getQuantity());
        ob[3] = String.valueOf(saleItem.getTotal());
        ob[4] = String.valueOf(saleItem.getProduct().getId());
        ob[5] = String.valueOf(saleItem.getSale().getId());
        modelo.addRow(ob);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpiarTabla();
        actualizarTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SaleItemRepositoryImp saleItemRepository = new SaleItemRepositoryImp(entityManager);
        Saleitem saleItem;
        saleItem = saleItemRepository.fine(Integer.valueOf(jTextID.getText()));
        
        saleItem.setProduct((Product) jComboBoxProduct.getSelectedItem());
        saleItem.setSale((Sale) jComboBoxSale.getSelectedItem());
        saleItem.setPrice(Float.parseFloat(jTextFieldPrice.getText()));
        saleItem.setQuantity(Integer.parseInt(jTextFieldQuantity.getText()));
        saleItem.setTotal(Float.parseFloat(jTextFieldTotal.getText()));

        saleItemRepository.Save(saleItem);
        saleItemRepository.commit();
        limpiarTabla();
        actualizarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        jTextBuscar.setText("Buscar por ID");
        jTextFieldPrice.setText("");
        jTextFieldQuantity.setText("");
        jTextFieldTotal.setText("");
        jTextID.setText("");
        
    }//GEN-LAST:event_jPanel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<Product> jComboBoxProduct;
    private javax.swing.JComboBox<Sale> jComboBoxSale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldQuantity;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextID;
    // End of variables declaration//GEN-END:variables
}
