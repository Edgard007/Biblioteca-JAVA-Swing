/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.conexion.Conexion;
import com.dao.DaoCategoria;
import com.modelo.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author said
 */
public class FrmCategoria extends javax.swing.JInternalFrame {

    DaoCategoria dao = new DaoCategoria();
    Categoria ca = new Categoria();
    Conexion con = new Conexion();
    
    public FrmCategoria() {
        initComponents();
        tablaCategoria();
        rol();
    }
    public void rol(){
       if((FrmPrincipal.tipoUser).equals("2")){
            this.btnEliminar.setEnabled(false);
            this.btnModificar.setEnabled(false);
            this.btnReporte.setEnabled(false);
        }else{
            this.btnEliminar.setEnabled(true);
            this.btnModificar.setEnabled(true);
            this.btnReporte.setEnabled(true);
        }   
    }
    
    public void tablaCategoria()
   {
       String [] columnas={"idCategoria","Nombre","Descripcion"};
       Object[] obj=new Object[6];
       DefaultTableModel tabla=new DefaultTableModel(null,columnas);
       List ls;
       try
       {
           ls = dao.mostrarCategoria();
           for(int i=0;i<ls.size();i++)
           {
            ca =(Categoria)ls.get(i);
            obj[0]= ca.getIdCategoria();
            obj[1]= ca.getNombre();
            obj[2]=ca.getDescripcion();
               tabla.addRow(obj);
           }
           ls=dao.mostrarCategoria();
           this.jblCat.setModel(tabla);          
       }
       catch(Exception e)
               {
                   JOptionPane.showMessageDialog(this, "error al mostrar datos de la Categoria" +
                           e.toString());
               }
   }
    public void insertar() throws Exception
    {

        ca.setNombre(this.txtCategoria.getText());
        
        dao.insertarCategoria(ca);
        JOptionPane.showMessageDialog(null, "Datos insertados con exito");
        limpiar();
            
        }
    public void limpiar()
    {
        this.txtCategoria.setText("");
        this.txtId.setText("");
        this.txtDescripcion.setText("");
        
    }
    //-----------------------------------------------------------------//
    public void modificar()
    {
        try
        {
        ca.setNombre(this.txtCategoria.getText());
        
            int SioNo=JOptionPane.showConfirmDialog(this,
                    "Desea modificar el Genero?",
                    "Modificar Genero",JOptionPane.YES_NO_OPTION);
            if(SioNo==0)
            {
                dao.modificarCategoria(ca);
                JOptionPane.showMessageDialog(rootPane,
                        "Genero modificado con exito",
                        "Confirmacion:",
                        JOptionPane.INFORMATION_MESSAGE);
                tablaCategoria();
                limpiar();
            }
            else
            {
                limpiar();
            }
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void eliminar()
    {
        try
        {
            ca.setIdCategoria(Integer.parseInt(this.txtId.getText()));
            int SioNo=JOptionPane.showConfirmDialog(this, 
                    "Desea eliminar el Genero?",
                    "Eliminar Genero",JOptionPane.YES_NO_OPTION);
            if(SioNo==0)
            {
                dao.eliminarCategoria(ca);
                JOptionPane.showMessageDialog(rootPane,
                        "Eliminado con exito", "Confirmacion",
                        JOptionPane.INFORMATION_MESSAGE);
                tablaCategoria();
                limpiar();
            }
            else
            {
                limpiar();
            }    
        }catch( Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public void llenarTabla()
        {
           int fila=this.jblCat.getSelectedRow();
           
           this.txtId.setText(String.valueOf
        (this.jblCat.getValueAt(fila, 0)));
           
           this.txtCategoria.setText(String.valueOf
        (this.jblCat.getValueAt(fila, 1)));
           
        this.txtDescripcion.setText(String.valueOf
        (this.jblCat.getValueAt(fila, 2)));

        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jblCat = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        setClosable(true);

        jblCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jblCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblCatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jblCat);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Genero:");

        jLabel2.setText("Id Genero:");

        jLabel3.setText("Genero:");

        txtId.setEditable(false);

        btnAgregar.setText("AGREGAR");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        btnReporte.setText("REPORTE");
        btnReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteMouseClicked(evt);
            }
        });

        jLabel4.setText("Descripcion: ");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addGap(38, 38, 38)
                                .addComponent(btnModificar)
                                .addGap(33, 33, 33)
                                .addComponent(btnEliminar)
                                .addGap(27, 27, 27)
                                .addComponent(btnLimpiar)
                                .addGap(40, 40, 40)
                                .addComponent(btnReporte))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel3)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane2))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnReporte))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jblCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblCatMouseClicked
    llenarTabla();
    }//GEN-LAST:event_jblCatMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
    try
        {
            insertar();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        tablaCategoria();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
    try
        {
            modificar();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        tablaCategoria();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        try
        {
            eliminar();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        tablaCategoria();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
    limpiar();        
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteMouseClicked
        mostrarReporteGeneral();
    }//GEN-LAST:event_btnReporteMouseClicked
public void mostrarReporteGeneral()
 {
      Connection con=null;
     JasperReport repor;
     try 
     {
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/Biblioteca",
                 "root","");
     } 
     catch (ClassNotFoundException | SQLException e) 
     {
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
     try 
     {
         repor=JasperCompileManager.compileReport
        ("src/com/reportes/ReporteCat.jrxml");
         JasperPrint jp=JasperFillManager.fillReport
        (repor,null,con);
         JasperViewer.viewReport(jp,false);
         
     } 
     catch (JRException e) 
     {
         Logger.getLogger(FrmCategoria.class.getName()).log(Level.SEVERE,null,e);
     }
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jblCat;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
