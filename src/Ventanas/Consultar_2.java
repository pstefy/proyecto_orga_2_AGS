/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Lista;
import Clases.Nodo;
import static Ventanas.Principal.codigos;
import static Ventanas.Principal.palabras;
import static Ventanas.Principal.peliculas;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefani
 */
public class Consultar_2 extends javax.swing.JFrame {

    /**
     * Creates new form Consultar_2
     */
    public static Principal principal_11;
    public Consultar_2(Principal princ) {
        initComponents();
        principal_11 = princ;
        principal_11.setVisible(false);
        todas_las_peliculas.setText(peliculas.DatosPeliculas());
        this.setLocationRelativeTo(null);
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        todas_las_peliculas = new javax.swing.JTextArea();
        palabras_buscadas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        todas_las_peliculas.setEditable(false);
        todas_las_peliculas.setColumns(20);
        todas_las_peliculas.setRows(5);
        jScrollPane1.setViewportView(todas_las_peliculas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 280, 260));

        palabras_buscadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palabras_buscadasActionPerformed(evt);
            }
        });
        jPanel1.add(palabras_buscadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 160, -1));

        jLabel2.setText("Palabras");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jButton2.setText("Consultar pelicula");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        principal_11.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void palabras_buscadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palabras_buscadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palabras_buscadasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (palabras_buscadas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una o mas palabras para la busqueda.");
            palabras_buscadas.setText("");
        }else{
            try {
                String[] todas_las_palabras = palabras_buscadas.getText().split(" ");
                if (todas_las_palabras.length != 0) {
                    int buscar = palabras.BusquedaBinaria(todas_las_palabras[0]);
                    if (buscar > -1) {
                        Lista titulos = palabras.getPalabras()[buscar].getLista();
                        String peliculas_encontradas = "Peliculas encontradas: \n";
                        Nodo actual = titulos.getFirst();
                        int contador = 1;
                        while(actual != null){
                            boolean contiene =  true;
                            for (int i = 0; i < todas_las_palabras.length; i++) {
                                if (!actual.getTitulo().contains(todas_las_palabras[i])) {
                                    contiene = false;
                                }
                            }
                            if (contiene) {
                                int posicion = codigos.BusquedaBinaria(actual.getCodigo());
                                if (posicion > -1) {
                                    String datos = peliculas.DatoPelicula(Integer.parseInt(codigos.getCodigos()[posicion][2]));
                                    peliculas_encontradas += "\n-> Película " + contador + " <-\n" + datos + "\n";
                                    contador++;
                                }
                            }
                            actual = actual.getSiguiente();
                        }
                        if (peliculas_encontradas.equals("Peliculas encontradas: \n")) {
                            JOptionPane.showMessageDialog(this, "No existen peliculas para esa busqueda.");
                        }else{
                            todas_las_peliculas.setText(peliculas_encontradas);
                            JOptionPane.showMessageDialog(this, "Puede ver las peliculas encontradas en la parte derecha.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "No existen peliculas con esa palabra.");
                        palabras_buscadas.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Debe ingresar una o mas palabras para la busqueda.");
                    palabras_buscadas.setText("");
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(this, "Error en la busqueda.");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Consultar_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultar_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultar_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultar_2(principal_11).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField palabras_buscadas;
    private javax.swing.JTextArea todas_las_peliculas;
    // End of variables declaration//GEN-END:variables
}