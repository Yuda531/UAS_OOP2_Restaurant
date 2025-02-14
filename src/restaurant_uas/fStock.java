/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_uas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agung Yuda
 */
public class fStock extends javax.swing.JFrame {

    /**
     * Creates new form fStock
     */
    private DefaultTableModel model;
    
    public fStock() {
        initComponents();
        model = new DefaultTableModel();
        tabelinput.setModel(model);

        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah Barang");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        loadData();
        kode();
    }
    
    public final void loadData() {
        btn_simpan.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_edit.setEnabled(true);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM barang";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[5];
                o[0] = r.getString("kd_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("jumlah_barang");
                o[3] = r.getString("harga_beli");
                o[4] = r.getString("harga_jual");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Terjadi kesalahan saat load data !");
            JOptionPane.showMessageDialog(null, "terjadi kesalahan");
        }
    }
    
    private void kode() {
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM barang ORDER by kd_barang desc";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String nofak = r.getString("kd_barang").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";
                switch (AN.length()) {
                    case 1:
                        Nol = "000";
                        break;
                    case 2:
                        Nol = "00";
                        break;
                    case 3:
                        Nol = "0";
                        break;
                    case 4:
                        Nol = "";
                        break;
                    default:
                        break;
                }
                txt_kdbarang.setText("B" + Nol + AN);
            } else {
                txt_kdbarang.setText("B0001");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Terjadi kesalahan pada method kode !");
            JOptionPane.showMessageDialog(null, "terjadi kesalahan");
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
        jLabel1 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        txt_kdbarang = new javax.swing.JTextField();
        txt_hargajual = new javax.swing.JTextField();
        txt_hargabeli = new javax.swing.JTextField();
        txt_namabarang = new javax.swing.JTextField();
        txt_jumlahbarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelinput = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 172, 247));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 28)); // NOI18N
        jLabel1.setText("Pengolahan Data Barang");

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_back)
                    .addComponent(jLabel1))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kode Barang");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah Barang");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Harga Beli");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Harga Jual");

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        txt_kdbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kdbarangActionPerformed(evt);
            }
        });

        txt_hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargajualActionPerformed(evt);
            }
        });

        txt_hargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargabeliActionPerformed(evt);
            }
        });

        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });

        txt_jumlahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahbarangActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cari");

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });

        tabelinput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelinput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelinputMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelinput);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(293, 293, 293))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_kdbarang)
                            .addComponent(txt_hargabeli)
                            .addComponent(txt_namabarang)
                            .addComponent(txt_jumlahbarang)
                            .addComponent(txt_hargajual))
                        .addGap(43, 43, 43)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_simpan)
                        .addGap(18, 18, 18)
                        .addComponent(btn_hapus)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cari)))
                .addGap(25, 25, 25))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_kdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_jumlahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_simpan)
                            .addComponent(btn_hapus)
                            .addComponent(btn_edit))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_hargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_hargajual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        fmenu fb = new fmenu();
        fb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        System.out.println(txt_kdbarang.getText());
        System.out.println(txt_namabarang.getText());
        System.out.println(txt_jumlahbarang.getText());
        System.out.println(txt_hargabeli.getText());
        System.out.println(txt_hargajual.getText());

        if (txt_jumlahbarang.getText().equals("") || txt_namabarang.getText().equals("")
            || txt_hargabeli.getText().equals("") || txt_hargajual.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "Restaurant", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String kbarang = txt_kdbarang.getText();
            String nbarang = txt_namabarang.getText();
            String jbarang = txt_jumlahbarang.getText();
            String hbeli = txt_hargabeli.getText();
            String hjual = txt_hargajual.getText();

            try {
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                System.out.println(date);
                String tgl = date.toString();
                Connection c = koneksi.getKoneksi();
                String sql = "INSERT INTO barang (kd_barang, nama_barang, jumlah_barang, harga_beli, harga_jual, tanggal_masuk) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kbarang);
                p.setString(2, nbarang);
                p.setInt(3, Integer.parseInt(jbarang));
                p.setInt(4, Integer.parseInt(hbeli));
                p.setInt(5, Integer.parseInt(hjual));
                p.setString(6, tgl);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Terjadi kesalahan pada method tambah !");
                JOptionPane.showMessageDialog(null, "terjadi kesalahan");
            } finally {
                loadData();
                kode();
                txt_namabarang.setText("");
                txt_jumlahbarang.setText("");
                txt_hargabeli.setText("");
                txt_hargajual.setText("");
                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "Pratama Shop", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if (txt_kdbarang.getText().equals(txt_namabarang.getText().equals(txt_jumlahbarang.getText().equals(
            txt_hargabeli.getText().equals("") || txt_hargajual.getText().equals(""))))) {
JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "Pratama Shop", JOptionPane.INFORMATION_MESSAGE);
} else {
    int i = tabelinput.getSelectedRow();
    if (i == -1) {
        return;
        }
        String kd = (String) model.getValueAt(i, 0);
        String nama = txt_namabarang.getText();
        String jumlah = txt_jumlahbarang.getText();
        String beli = txt_hargabeli.getText();
        String jual = txt_hargajual.getText();

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "UPDATE tb_barang SET nama_barang = ?, jumlah_barang = ?, harga_beli = ?, harga_jual = ? WHERE kd_barang = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nama);
            p.setString(2, jumlah);
            p.setString(3, beli);
            p.setString(4, jual);
            p.setString(5, kd);
            p.executeUpdate();
            p.close();
            loadData();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Terjadi kesalahan pada method btn_edit !");
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan");
        } finally {
            txt_kdbarang.setEnabled(true);
            txt_namabarang.setText("");
            txt_jumlahbarang.setText("");
            txt_hargabeli.setText("");
            txt_hargajual.setText("");
            btn_simpan.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Pratama Shop", JOptionPane.INFORMATION_MESSAGE);
        }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "delete from tb_barang where kd_barang='" + txt_kdbarang.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        loadData();
        txt_kdbarang.setText("");
        txt_namabarang.setText("");
        txt_jumlahbarang.setText("");
        txt_hargabeli.setText("");
        txt_hargajual.setText("");
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_kdbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdbarangActionPerformed

    private void txt_hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargajualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargajualActionPerformed

    private void txt_hargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargabeliActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_jumlahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahbarangActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tb_barang WHERE kd_barang LIKE '%" + txt_cari.getText() + "%' "
            + "OR nama_barang LIKE '%" + txt_cari.getText() + "%' "
            + "OR jumlah_barang LIKE '%" + txt_cari.getText() + "%' "
            + "OR harga_beli LIKE '%" + txt_cari.getText() + "%' "
            + "OR harga_jual LIKE '%" + txt_cari.getText() + "%'";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[5];
                o[0] = r.getString("kd_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("jumlah_barang");
                o[3] = r.getString("harga_beli");
                o[4] = r.getString("harga_jual");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error: " + e.getMessage());
        }
    }//GEN-LAST:event_txt_cariKeyReleased

    private void tabelinputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelinputMouseClicked
        // TODO add your handling code here:
        btn_simpan.setEnabled(false);
        btn_edit.setEnabled(true);
        btn_hapus.setEnabled(true);
        int i = tabelinput.getSelectedRow();
        if (i == -1) {
            return;
        }
        String kbarang = (String) model.getValueAt(i, 0);
        txt_kdbarang.setText(kbarang);
        txt_kdbarang.setEnabled(false);
        String nbarang = (String) model.getValueAt(i, 1);
        txt_namabarang.setText(nbarang);
        String jumlah = (String) model.getValueAt(i, 2);
        txt_jumlahbarang.setText(jumlah);
        String hbeli = (String) model.getValueAt(i, 3);
        txt_hargabeli.setText(hbeli);
        String hjual = (String) model.getValueAt(i, 4);
        txt_hargajual.setText(hjual);
    }//GEN-LAST:event_tabelinputMouseClicked

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
            java.util.logging.Logger.getLogger(fStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelinput;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_hargabeli;
    private javax.swing.JTextField txt_hargajual;
    private javax.swing.JTextField txt_jumlahbarang;
    private javax.swing.JTextField txt_kdbarang;
    private javax.swing.JTextField txt_namabarang;
    // End of variables declaration//GEN-END:variables
}
