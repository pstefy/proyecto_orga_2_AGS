/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Codigos;
import Clases.Peliculas;
import Clases.Titulos;
import Clases.Palabras;
import Clases.Socios;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author Stefani
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    public static Peliculas peliculas;
    public static Codigos codigos;
    public static Titulos titulos;
    public static Palabras palabras;
    public static Socios socios;
    
    public Principal() {
        initComponents();
        peliculas = new Peliculas();
        codigos = new Codigos();
        titulos = new Titulos();
        palabras = new Palabras();
        socios = new Socios();
        this.leer_txt();
        this.setLocationRelativeTo(null);
    }
    
    public void leer_txt(){
        String line;
        String peliculas_socios_txt = "";
        String path = "test\\peliculas_socios.txt";
        File file = new File(path);
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        peliculas_socios_txt += line + "\n";
                    }
                }
                
                if (!"".equals(peliculas_socios_txt)) {
                    String[] peliculas_socios_split = peliculas_socios_txt.split("\n");
                    boolean caso = true;
                    for (int i = 0; i < peliculas_socios_split.length; i++) {
                        if (peliculas_socios_split[i].isEmpty()) {
                            
                        }else{
                            if (peliculas_socios_split[i].equals("Pelicula")) {
                            }else if(peliculas_socios_split[i].equals("Socios")){
                                caso = false;
                            }else if(peliculas_socios_split[i].contains(",")){
                                if (caso) {
                                    String[] datos_pelicula = peliculas_socios_split[i].split(",");
                                    peliculas.Añadir_2(datos_pelicula[0], datos_pelicula[1], datos_pelicula[2], datos_pelicula[3], datos_pelicula[4], datos_pelicula[5]);
                                }else if(!caso){
                                    String[] datos_socio = peliculas_socios_split[i].split(",");
                                    socios.Añadir_2(datos_socio[0], datos_socio[1], datos_socio[2]);
                                }
                            }
                        }
                    }
                    if (peliculas.getPeliculas().length != 0 || peliculas.getPeliculas() != null) {
                        codigos.CargarDesdePeliculas(peliculas);
                        titulos.CargarDesdePeliculas(peliculas);
                        palabras.CargarDesdePeliculas(peliculas);
                    }
                }
                br.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer.");
        }
    }
    
    public void guardar_txt(){
        String todas_las_peliculas = "";
        String todos_los_socios = "";
        String[][] todo = peliculas.getPeliculas();
        String[][] todo_2 = socios.getSocios();
        if (todo.length != 0) {
            for (int i = 0; i < todo.length; i++) {
                String eliminada = todo[i][0];
                if (eliminada.isEmpty()) {
                    eliminada = " ";
                }
                todas_las_peliculas += eliminada + "," + todo[i][1] + "," + todo[i][2] + "," + todo[i][3] + "," + todo[i][4] + "," + todo[i][5] + "\n";
            }
        }
        if (todo_2.length != 0) {
            for (int i = 0; i < todo_2.length; i++) {
                if (todo_2[i][0].equals("") || todo_2[i][0].equals(" ")) {
                    todos_los_socios += " " + "," + todo_2[i][1] + "," + todo_2[i][2] + "\n";
                }else{
                   todos_los_socios += todo_2[i][0] + "," + todo_2[i][1] + "," + todo_2[i][2] + "\n"; 
                }
                
            }
        }
        try {
                PrintWriter pw = new PrintWriter("test\\peliculas_socios.txt");
                pw.print("Peliculas\n");
                pw.append(todas_las_peliculas);
                pw.print("Socios\n");
                pw.append(todos_los_socios);
                pw.close();
                JOptionPane.showMessageDialog(this, "Cambios guardados con exito.");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(this, "Error al guardar.");
            }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lista_socios = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        eliminar_socio = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        consultar = new javax.swing.JButton();
        devolver = new javax.swing.JButton();
        devolver2 = new javax.swing.JButton();
        lista_peliculas1 = new javax.swing.JButton();
        agregar1 = new javax.swing.JButton();
        agregar_socio = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        alquilar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lista_socios.setText("Ver lista de socios");
        lista_socios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista_sociosActionPerformed(evt);
            }
        });
        jPanel1.add(lista_socios, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 170, 39));

        salir.setText("X");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 10, -1, 20));

        eliminar_socio.setText("Eliminar socio");
        eliminar_socio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_socioActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar_socio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 170, 39));

        eliminar.setText("Eliminar pelicula");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 170, 39));

        consultar.setText("Consultar pelicula");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        jPanel1.add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 170, 39));

        devolver.setText("Devolver pelicula");
        devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverActionPerformed(evt);
            }
        });
        jPanel1.add(devolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 170, 39));

        devolver2.setText("Compactar y reindexar");
        devolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolver2ActionPerformed(evt);
            }
        });
        jPanel1.add(devolver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 170, 39));

        lista_peliculas1.setText("Ver lista de peliculas");
        lista_peliculas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista_peliculas1ActionPerformed(evt);
            }
        });
        jPanel1.add(lista_peliculas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 170, 39));

        agregar1.setText("Agregar pelicula");
        agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar1ActionPerformed(evt);
            }
        });
        jPanel1.add(agregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 170, 39));

        agregar_socio.setText("Agregar socio");
        agregar_socio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_socioActionPerformed(evt);
            }
        });
        jPanel1.add(agregar_socio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 170, 39));

        guardar.setText("Guardar cambios");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 170, 39));

        alquilar1.setText("Alquilar pelicula");
        alquilar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alquilar1ActionPerformed(evt);
            }
        });
        jPanel1.add(alquilar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 170, 39));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Eliminar_pelicula ep = new Eliminar_pelicula(this);
        ep.setVisible(true);
    }//GEN-LAST:event_eliminarActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        String opcion = JOptionPane.showInputDialog(this, "Desea consultar por codigo (1) o por palabras del titulo (2) de la pelicula?");
        try {
            int opcion_int = Integer.parseInt(opcion);
            if (opcion_int == 1) {
                Consultar_1 cp = new Consultar_1(this);
                cp.setVisible(true);
            }else if(opcion_int == 2){
                Consultar_2 cp2 = new Consultar_2(this);
                cp2.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Por favor ingrese 1 o 2 segun la consulta deseada.");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese 1 o 2 segun la consulta deseada.");
        }
        
    }//GEN-LAST:event_consultarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.guardar_txt();
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void alquilar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alquilar1ActionPerformed
        Alquilar_pelicula alq = new Alquilar_pelicula(this);
        alq.setVisible(true);
    }//GEN-LAST:event_alquilar1ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        this.guardar_txt();
    }//GEN-LAST:event_guardarActionPerformed

    private void agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar1ActionPerformed
        Agregar_pelicula ap = new Agregar_pelicula(this);
        ap.setVisible(true);
    }//GEN-LAST:event_agregar1ActionPerformed

    private void devolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolver2ActionPerformed
        peliculas.CompactadorReindexador();
        codigos.CompactadorReindexador();
        titulos.Vaciar();
        titulos.CargarDesdePeliculas(peliculas);
        palabras.Vaciar();
        palabras.CargarDesdePeliculas(peliculas);
        palabras.CompactadorReindexador();
        socios.CompactadorReindexador();
        JOptionPane.showMessageDialog(this, "Peliculas y socios eliminados fisicamente con exito.");
    }//GEN-LAST:event_devolver2ActionPerformed

    private void lista_peliculas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista_peliculas1ActionPerformed
        Ver_peliculas vp = new Ver_peliculas(this);
        vp.setVisible(true);
    }//GEN-LAST:event_lista_peliculas1ActionPerformed

    private void devolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverActionPerformed
        Devolver_pelicula dp = new Devolver_pelicula(this);
        dp.setVisible(true);
    }//GEN-LAST:event_devolverActionPerformed

    private void agregar_socioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_socioActionPerformed
        Agregar_socio as = new Agregar_socio(this);
        as.setVisible(true);
    }//GEN-LAST:event_agregar_socioActionPerformed

    private void eliminar_socioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_socioActionPerformed
        Eliminar_socio es = new Eliminar_socio(this);
        es.setVisible(true);
    }//GEN-LAST:event_eliminar_socioActionPerformed

    private void lista_sociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista_sociosActionPerformed
        Ver_socios vs = new Ver_socios(this);
        vs.setVisible(true);
    }//GEN-LAST:event_lista_sociosActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar1;
    private javax.swing.JButton agregar_socio;
    private javax.swing.JButton alquilar1;
    private javax.swing.JButton consultar;
    private javax.swing.JButton devolver;
    private javax.swing.JButton devolver2;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton eliminar_socio;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton lista_peliculas1;
    private javax.swing.JButton lista_socios;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
