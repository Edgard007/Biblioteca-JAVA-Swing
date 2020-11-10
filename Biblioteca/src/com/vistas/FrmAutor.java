/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.conexion.Conexion;
import com.dao.DaoAutor;
import com.modelo.Autor;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class FrmAutor extends javax.swing.JInternalFrame {

    DaoAutor dao = new DaoAutor();
    Autor a = new Autor();
    Conexion con = new Conexion();
    
    public FrmAutor() throws ClassNotFoundException {
        initComponents();
        tablaAutor();
        cargarPais();
        cargarLibro();
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
    
    
    
    public void tablaAutor()
   {
       String [] columnas={"idAutor","nombre","Genero","fechaNacimiento",
           "fecha de defuncion","Genero literario","Pais"};
       Object[] obj=new Object[7];
       DefaultTableModel tabla=new DefaultTableModel(null,columnas);
       List ls;
       try
       {
           ls = dao.mostrarAutor();
           for(int i=0;i<ls.size();i++)
           {
               a=(Autor)ls.get(i);
            obj[0]= a.getIdAutor();
            obj[1]=a.getNombre();
            obj[2]=a.getSexo();
            obj[3]=a.getFechaNacimiento();
            obj[4]=a.getFechaDefuncion();
            obj[5]=a.getGenero();
            obj[6]=a.getPais();    
            tabla.addRow(obj);
           }
           ls=dao.mostrarAutor();
           this.jtblAutor.setModel(tabla);          
       }
       catch(Exception e)
               {
                   JOptionPane.showMessageDialog(this, "error al mostrar datos del Autor" +
                           e.toString());
               }
   }
    
public void cargarLibro() throws ClassNotFoundException{
        this.cmbLibro.removeAllItems();
        ArrayList ls = dao.comboGenero();
        try {
            for(int i=0;i<ls.size();i++){
                this.cmbLibro.addItem(ls.get(i).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar combo libro "+e.getLocalizedMessage());
        }
    }
    
public void cargarPais() throws ClassNotFoundException{
        this.cmbPais.removeAllItems();
        ArrayList ls = dao.comboPais();
        try {
            for(int i=0;i<ls.size();i++){
                this.cmbPais.addItem(ls.get(i).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar combo pais "+e.getLocalizedMessage());
        }
    }
    
    public void insertar() throws Exception
    {
        a.setNombre(this.txtNombre.getText());
        
        if(rMasculino.isSelected()){
            a.setSexo("Masculino");
        }
        if(rFemenino.isSelected()){
            a.setSexo("Femenino");
        }
        
        a.setFechaNacimiento(Integer.parseInt(this.sNac.getValue().toString()));
        a.setFechaDefuncion(Integer.parseInt(this.sF.getValue().toString()));

        
        a.setGenero(this.cmbLibro.getSelectedItem().toString());
        a.setPais(this.cmbPais.getSelectedItem().toString());
        dao.insertarAutor(a);
        JOptionPane.showMessageDialog(null, "Datos insertados con exito");
        limpiar();
    }
    public void limpiar()
    {
        this.txtCodigo.setText("");
        this.txtNombre.setText("");
        this.cmbLibro.setSelectedIndex(0);
        this.cmbPais.setSelectedIndex(0);
    }
    //-----------------------------------------------------------------//
    public void modificar()
    {
        try
        {
        a.setIdAutor(Integer.parseInt(this.txtCodigo.getText()));
        a.setNombre(this.txtNombre.getText());
        
        if(rMasculino.isSelected()){
            a.setSexo("Masculino");
        }
        if(rFemenino.isSelected()){
            a.setSexo("Femenino");
        }
        
        a.setFechaNacimiento(Integer.parseInt(this.sNac.getValue().toString()));
        a.setFechaDefuncion(Integer.parseInt(this.sF.getValue().toString()));

        
        a.setGenero(this.cmbLibro.getSelectedItem().toString());
        a.setPais(this.cmbPais.getSelectedItem().toString());
    
        //pregunta de validacion!
            int SioNo=JOptionPane.showConfirmDialog(this,
                    "Desea modificar al Autor?",
                    "Modificar Autor",JOptionPane.YES_NO_OPTION);
            if(SioNo==0)
            {
                dao.modificarAutor(a);
                JOptionPane.showMessageDialog(rootPane,
                        "Autor modificado con exito",
                        "Confirmacion:",
                        JOptionPane.INFORMATION_MESSAGE);
                tablaAutor();
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
            a.setIdAutor(Integer.parseInt(this.txtCodigo.getText()));
            int SioNo=JOptionPane.showConfirmDialog(this, 
                    "Desea eliminar al Producto?",
                    "Eliminar Producto",JOptionPane.YES_NO_OPTION);
            if(SioNo==0)
            {
                dao.eliminarAutor(a);
                JOptionPane.showMessageDialog(rootPane,
                        "Eliminado con exito", "Confirmacion",
                        JOptionPane.INFORMATION_MESSAGE);
                tablaAutor();
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
           int fila=this.jtblAutor.getSelectedRow();
           
         this.txtCodigo.setText(String.valueOf
        (this.jtblAutor.getValueAt(fila, 0)));
           
           this.txtNombre.setText(String.valueOf
        (this.jtblAutor.getValueAt(fila, 1)));

           
          
           if (String.valueOf(this.jtblAutor.getValueAt(fila, 2)).equals("Masculino")){
           rMasculino.setSelected(true);
           }else if (String.valueOf(this.jtblAutor.getValueAt(fila, 2)).equals("Femenino")){
           rFemenino.setSelected(true);
           }
           
           this.sNac.setValue(
           (this.jtblAutor.getValueAt(fila, 3)));
           
           this.sF.setValue(
           (this.jtblAutor.getValueAt(fila, 4)));
           
           
           //para los select
           
           
            String Libro = String.valueOf(this.jtblAutor.getValueAt(fila, 5));
          this.cmbLibro.getModel().setSelectedItem(Libro);
     
           String  Pais = String.valueOf(this.jtblAutor.getValueAt(fila, 6));
          this.cmbPais.getModel().setSelectedItem(Pais);
          
          
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAutor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        rMasculino = new javax.swing.JRadioButton();
        rFemenino = new javax.swing.JRadioButton();
        cmbPais = new javax.swing.JComboBox<>();
        cmbLibro = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        sNac = new javax.swing.JSpinner();
        sF = new javax.swing.JSpinner();

        setClosable(true);

        jtblAutor.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblAutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblAutor);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("AUTOR:");

        jLabel2.setText("Id Autor:");

        jLabel3.setText("nombre:");

        jLabel4.setText("Genero:");

        jLabel5.setText("fecha de Nacimiento:");

        jLabel6.setText("fecha De defuncion:");

        jLabel7.setText("Genero de Libros:");

        jLabel8.setText("Pais:");

        txtCodigo.setEditable(false);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        buttonGroup1.add(rMasculino);
        rMasculino.setText("Masculino");

        buttonGroup1.add(rFemenino);
        rFemenino.setText("Femenino");

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

        btnAgregar.setText("AGREGAR");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(189, 189, 189)
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(sNac, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(sF, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rMasculino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(10, 10, 10)
                                            .addComponent(rFemenino))))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rMasculino)
                                    .addComponent(rFemenino)
                                    .addComponent(jLabel4))))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(sNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(sF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnReporte))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        try
        {
            modificar();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        tablaAutor();
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
        tablaAutor();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        try
        {
            insertar();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        tablaAutor();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void jtblAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblAutorMouseClicked
llenarTabla();
    }//GEN-LAST:event_jtblAutorMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
       Character s = evt.getKeyChar();
        if(!s.isLetter(s) && s != KeyEvent.VK_SPACE){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

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
        ("src/com/reportes/ReporteAutor.jrxml");
         JasperPrint jp=JasperFillManager.fillReport
        (repor,null,con);
         JasperViewer.viewReport(jp,false);
         
     } 
     catch (JRException e) 
     {
         Logger.getLogger(FrmAutor.class.getName()).log(Level.SEVERE,null,e);
     }
 }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReporte;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbLibro;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtblAutor;
    private javax.swing.JRadioButton rFemenino;
    private javax.swing.JRadioButton rMasculino;
    private javax.swing.JSpinner sF;
    private javax.swing.JSpinner sNac;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
