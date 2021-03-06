/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;


import model.Pengguna;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 *
 * @author GIAT
 */
public class PenggunaViewFrom extends javax.swing.JFrame {
public JPanel panelMain;
    private JPanel panelJudul;
    private JTextField textField1;
    private JButton cariButton;
    private JTable tablePengguna;
    private JButton tambahButton;
    private JButton ubahButton;
    private JButton hapusButton;
    private JButton batalButton;
    private JButton tutupButton;
    private JScrollPane scrollPane1;
    /**
     * Creates new form PenggunaViewFrom
     */
    public PenggunaViewFrom() {
        tutupButton.addActionListener(e -> {
            System.exit(0);
        });
        tambahButton.addActionListener(e -> {
            PenggunaCreateForm f = new PenggunaCreateForm();
            f.setContentPane(f.panelMain);
            f.setTitle("Input Data Pengguna");
            f.pack();
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
        hapusButton.addActionListener(e -> {
            int barisTerpilih = tablePengguna.getSelectedRow();
            int pilihan = JOptionPane.showConfirmDialog(null,
                    "Yakin mau hapus?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
                    );
            if(pilihan == 0){
                if(barisTerpilih >= 0){
                    TableModel tm = tablePengguna.getModel();
                    Pengguna p = new Pengguna();
                    int id = Integer.parseInt(tm.getValueAt(barisTerpilih,0).toString());
                    p.setId(id);
                    p.delete();
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih data dulu");
                }
            }
            refreshTable();
        });
        batalButton.addActionListener(e -> {
            refreshTable();
        });

        ubahButton.addActionListener(e -> {

            int barisTerpilih = tablePengguna.getSelectedRow();
            if(barisTerpilih >= 0){
                TableModel tm = tablePengguna.getModel();
                int id = Integer.parseInt(tm.getValueAt(barisTerpilih,0).toString());

                PenggunaCreateForm f = new PenggunaCreateForm(id);
                f.setContentPane(f.panelMain);
                f.setTitle("Input Data Pengguna");
                f.pack();
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data dulu");
            }


        });
    }

    public void refreshTable(){
        Pengguna p = new Pengguna();
        ArrayList<Pengguna> list = p.read();

        Object[][] row = new Object[list.size()][4];

        for (int i = 0; i < list.size() ; i++) {
            row[i][0]= list.get(i).getId();
            row[i][1]= list.get(i).getUsername();
            row[i][2]= list.get(i).getNamaLengkap();
            row[i][3]= list.get(i).getLevel();
        }

        String penggunaHeader[] = {"Id","Username","Nama Lengkap","Level"};
        TableModel tm = new DefaultTableModel(row,penggunaHeader);
        tablePengguna.setModel(tm);
    }


    private void createUIComponents() {
        Pengguna p = new Pengguna();
        ArrayList<Pengguna> list = p.read();

        Object[][] row = new Object[list.size()][4];

        for (int i = 0; i < list.size() ; i++) {
            row[i][0]= list.get(i).getId();
            row[i][1]= list.get(i).getUsername();
            row[i][2]= list.get(i).getNamaLengkap();
            row[i][3]= list.get(i).getLevel();
        }

        String penggunaHeader[] = {"Id","Username","Nama Lengkap","Level"};
        TableModel tm = new DefaultTableModel(row,penggunaHeader);
        tablePengguna = new JTable(tm);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 309, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PenggunaViewFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenggunaViewFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenggunaViewFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenggunaViewFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenggunaViewFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
