/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Admin
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
    }
    FrmLibro frmL;
    FrmEditorial frmEd;
    FrmEmpleado frmEmp;
    FrmAutor frmAutor;
    FrmCategoria frmCatg;
    
    public static String tipoUser;
    
    public void rol(){
        if((FrmPrincipal.tipoUser).equals("2")){
            this.mEmpleado.setVisible(false);
        }else{
            this.mEmpleado.setVisible(true);
        }   
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mLibro = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mEmpleado = new javax.swing.JMenu();
        mAutor = new javax.swing.JMenu();
        mCategoria = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 720));
        setSize(new java.awt.Dimension(800, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        mLibro.setText("Libro");
        mLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mLibroMouseClicked(evt);
            }
        });
        jMenuBar1.add(mLibro);

        jMenu2.setText("Editorial");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        mEmpleado.setText("Empleado");
        mEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mEmpleadoMouseClicked(evt);
            }
        });
        jMenuBar1.add(mEmpleado);

        mAutor.setText("Autor");
        mAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mAutorMouseClicked(evt);
            }
        });
        jMenuBar1.add(mAutor);

        mCategoria.setText("Genero");
        mCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mCategoriaMouseClicked(evt);
            }
        });
        jMenuBar1.add(mCategoria);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mLibroMouseClicked
        if(frmL == null){
            try {
                frmL = new FrmLibro();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.jDesktopPane1.add(frmL);
            frmL.setVisible(true);
        }else if(frmL.isClosed()){
            try {
                frmL = new FrmLibro();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.jDesktopPane1.add(frmL);
            frmL.setVisible(true);
        }
    }//GEN-LAST:event_mLibroMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        if(frmEd == null){
            try {
                frmEd = new FrmEditorial();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.jDesktopPane1.add(frmEd);
            frmEd.setVisible(true);
        }else if(frmEd.isClosed()){
            try {
                frmEd = new FrmEditorial();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.jDesktopPane1.add(frmEd);
            frmEd.setVisible(true);
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        rol();
    }//GEN-LAST:event_formWindowOpened

    private void mEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mEmpleadoMouseClicked
       if(frmEmp == null){
           frmEmp = new FrmEmpleado();
            this.jDesktopPane1.add(frmEmp);
            frmEmp.setVisible(true);
        }else if(frmEmp.isClosed()){
            frmEmp = new FrmEmpleado();
            this.jDesktopPane1.add(frmEmp);
            frmEmp.setVisible(true);
        }
    }//GEN-LAST:event_mEmpleadoMouseClicked

    private void mAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mAutorMouseClicked
        if(frmAutor == null){
            try {
                frmAutor = new FrmAutor();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.jDesktopPane1.add(frmAutor);
            frmAutor.setVisible(true);
        }else if(frmAutor.isClosed()){
            try {
                frmAutor = new FrmAutor();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.jDesktopPane1.add(frmAutor);
            frmAutor.setVisible(true);
        }
    }//GEN-LAST:event_mAutorMouseClicked

    private void mCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCategoriaMouseClicked
       if(frmCatg == null){
           frmCatg = new FrmCategoria();
            this.jDesktopPane1.add(frmCatg);
            frmCatg.setVisible(true);
        }else if(frmCatg.isClosed()){
            frmCatg = new FrmCategoria();
            this.jDesktopPane1.add(frmCatg);
            frmCatg.setVisible(true);
        }
    }//GEN-LAST:event_mCategoriaMouseClicked

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mAutor;
    private javax.swing.JMenu mCategoria;
    private javax.swing.JMenu mEmpleado;
    private javax.swing.JMenu mLibro;
    // End of variables declaration//GEN-END:variables
}
