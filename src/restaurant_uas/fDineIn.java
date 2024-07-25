/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_uas;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Agung Yuda
 */
public class fDineIn extends javax.swing.JFrame {

    /**
     * Creates new form fDineIn
     */
    // Prices of the items
    private final int[] prices = {80000, 60000, 42000, 30000, 15000, 15000};

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date now = new Date();

    // Constructor
    public fDineIn() {
        initComponents();

        jTextArea1.setText("***********************Restaurant Kita****************************\n" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss \n ").format(new Date()) + "\n");

        nofaktur();
        noFaktur.setVisible(false);
        noFakturCetak.setVisible(false);
        tf_namaPelangganCetak.setVisible(false);
        tf_noMejaMakanCetak.setVisible(false);
    }

    private void nofaktur() {
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tb_penjualan ORDER by no_faktur desc";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String nofak = r.getString("no_faktur").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";
                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }
                noFaktur.setText("F" + Nol + AN);
            } else {
                noFaktur.setText("F0001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private String getUniqueFilePath(String directoryPath, String baseFileName) {
        File file = new File(directoryPath, baseFileName);
        if (!file.exists()) {
            return file.getAbsolutePath();
        }

        String nameWithoutExtension = baseFileName.substring(0, baseFileName.lastIndexOf('.'));
        String extension = baseFileName.substring(baseFileName.lastIndexOf('.'));
        int count = 1;

        while (file.exists()) {
            String newFileName = nameWithoutExtension + "(" + count + ")" + extension;
            file = new File(directoryPath, newFileName);
            count++;
        }

        return file.getAbsolutePath();
    }

    private void calculateTotal() {
        int subTotal = 0;
        JCheckBox[] checkboxes = {purchaseCheckbox, purchaseCheckbox1, purchaseCheckbox2, purchaseCheckbox3, purchaseCheckbox4, purchaseCheckbox5};
        JSpinner[] spinners = {spinnerJumlah1, spinnerJumlah, spinnerJumlah2, spinnerJumlah3, spinnerJumlah4, spinnerJumlah5};
        String[] itemNames = {"Ikan Gurame", "Ayam Bakar", "Ramen", "Croissant", "Dimsum", "Kimchi"};

        jTextArea1.setText("***********************Restaurant Kita**************************\n\n"
                + sdf.format(now) + "\n"
                + "Invoice No: " + noFaktur.getText() + "\n"
                + "*****************************************************************\n\n");

        int itemNumber = 1;
        for (int i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].isSelected()) {
                int quantity = (Integer) spinners[i].getValue();
                int totalItemPrice = quantity * prices[i];
                subTotal += totalItemPrice;
                jTextArea1.append(itemNumber + ". " + itemNames[i] + " x " + quantity + " = Rp. " + totalItemPrice + "\n");
                itemNumber++;
            }
        }

        tf_SubTotal.setText(String.valueOf(subTotal));
        int tax = (int) (subTotal * 0.1);
        tf_Pajak.setText(String.valueOf(tax));
        int total = subTotal + tax;
        tf_TotalHarga.setText(String.valueOf(total));
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
        jPanel2 = new javax.swing.JPanel();
        labelDisplayImage = new javax.swing.JLabel();
        labelNamaBarang = new javax.swing.JLabel();
        labelDua = new javax.swing.JLabel();
        spinnerJumlah = new javax.swing.JSpinner();
        labelHarga6 = new javax.swing.JLabel();
        labelSatu6 = new javax.swing.JLabel();
        labelPurchase1 = new javax.swing.JLabel();
        purchaseCheckbox1 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        labelDisplayImage1 = new javax.swing.JLabel();
        labelNamaBarang1 = new javax.swing.JLabel();
        labelSatu1 = new javax.swing.JLabel();
        labelDua1 = new javax.swing.JLabel();
        labelHarga1 = new javax.swing.JLabel();
        spinnerJumlah1 = new javax.swing.JSpinner();
        labelPurchase = new javax.swing.JLabel();
        purchaseCheckbox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        labelDisplayImage2 = new javax.swing.JLabel();
        labelNamaBarang2 = new javax.swing.JLabel();
        labelDua2 = new javax.swing.JLabel();
        spinnerJumlah2 = new javax.swing.JSpinner();
        labelSatu7 = new javax.swing.JLabel();
        labelHarga7 = new javax.swing.JLabel();
        purchaseCheckbox2 = new javax.swing.JCheckBox();
        labelPurchase2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        labelDisplayImage5 = new javax.swing.JLabel();
        labelNamaBarang5 = new javax.swing.JLabel();
        labelDua5 = new javax.swing.JLabel();
        spinnerJumlah5 = new javax.swing.JSpinner();
        labelHarga10 = new javax.swing.JLabel();
        labelSatu10 = new javax.swing.JLabel();
        purchaseCheckbox5 = new javax.swing.JCheckBox();
        labelPurchase5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelDisplayImage3 = new javax.swing.JLabel();
        labelNamaBarang3 = new javax.swing.JLabel();
        labelDua3 = new javax.swing.JLabel();
        spinnerJumlah3 = new javax.swing.JSpinner();
        labelHarga8 = new javax.swing.JLabel();
        labelSatu8 = new javax.swing.JLabel();
        labelPurchase3 = new javax.swing.JLabel();
        purchaseCheckbox3 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        labelDisplayImage4 = new javax.swing.JLabel();
        labelNamaBarang4 = new javax.swing.JLabel();
        labelDua4 = new javax.swing.JLabel();
        spinnerJumlah4 = new javax.swing.JSpinner();
        labelHarga9 = new javax.swing.JLabel();
        labelSatu9 = new javax.swing.JLabel();
        purchaseCheckbox4 = new javax.swing.JCheckBox();
        labelPurchase4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        tf_TotalHarga = new javax.swing.JTextField();
        tf_Pajak = new javax.swing.JTextField();
        tf_Bayar = new javax.swing.JTextField();
        tf_Kembalian = new javax.swing.JTextField();
        tf_SubTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_SelesaiTransaksi = new javax.swing.JButton();
        btn_CetakInvoice = new javax.swing.JButton();
        noFaktur = new javax.swing.JTextField();
        noFakturCetak = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_noMejaMakan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_namaPelanggan = new javax.swing.JTextField();
        tf_namaPelangganCetak = new javax.swing.JTextField();
        tf_noMejaMakanCetak = new javax.swing.JTextField();
        btn_back1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(230, 230, 230));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Restaurant Menus");

        labelDisplayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ayamBakar.jpg"))); // NOI18N

        labelNamaBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamaBarang.setText("Ayam Bakar");

        labelDua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDua.setText("Jumlah: ");

        spinnerJumlah.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        spinnerJumlah.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        labelHarga6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHarga6.setText("60000");

        labelSatu6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSatu6.setText("Harga: Rp. ");

        labelPurchase1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPurchase1.setText("Purchase:");

        purchaseCheckbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseCheckbox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(labelDisplayImage)
                .addGap(46, 46, 46))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelPurchase1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(purchaseCheckbox1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelSatu6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelHarga6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelDua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(labelNamaBarang)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelDisplayImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNamaBarang)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSatu6)
                    .addComponent(labelHarga6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDua)
                    .addComponent(spinnerJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPurchase1)
                    .addComponent(purchaseCheckbox1))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        labelDisplayImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ikanGurame.jpg"))); // NOI18N

        labelNamaBarang1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamaBarang1.setText("Ikan Gurame");

        labelSatu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSatu1.setText("Harga: Rp. ");

        labelDua1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDua1.setText("Jumlah: ");

        labelHarga1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHarga1.setText("80000");

        spinnerJumlah1.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        spinnerJumlah1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        labelPurchase.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPurchase.setText("Purchase:");

        purchaseCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addComponent(labelDisplayImage1)
                .addGap(36, 36, 36))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(labelDua1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(spinnerJumlah1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(labelSatu1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(labelPurchase)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(purchaseCheckbox)))
                    .addComponent(labelNamaBarang1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelDisplayImage1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNamaBarang1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSatu1)
                    .addComponent(labelHarga1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDua1)
                    .addComponent(spinnerJumlah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPurchase)
                    .addComponent(purchaseCheckbox))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        labelDisplayImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ramen.jpg"))); // NOI18N

        labelNamaBarang2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamaBarang2.setText("Ramen");

        labelDua2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDua2.setText("Jumlah: ");

        spinnerJumlah2.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        spinnerJumlah2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        labelSatu7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSatu7.setText("Harga: Rp. ");

        labelHarga7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHarga7.setText("42000");

        purchaseCheckbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseCheckbox2ActionPerformed(evt);
            }
        });

        labelPurchase2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPurchase2.setText("Purchase:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelPurchase2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(purchaseCheckbox2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelSatu7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelHarga7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelDua2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerJumlah2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelDisplayImage2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(labelNamaBarang2)))
                .addGap(36, 36, 36))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelDisplayImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNamaBarang2)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSatu7)
                    .addComponent(labelHarga7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDua2)
                    .addComponent(spinnerJumlah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPurchase2)
                    .addComponent(purchaseCheckbox2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelDisplayImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kimchi.jpg"))); // NOI18N

        labelNamaBarang5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamaBarang5.setText("Kimchi");

        labelDua5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDua5.setText("Jumlah: ");

        spinnerJumlah5.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        spinnerJumlah5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        labelHarga10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHarga10.setText("15000");

        labelSatu10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSatu10.setText("Harga: Rp. ");

        purchaseCheckbox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseCheckbox5ActionPerformed(evt);
            }
        });

        labelPurchase5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPurchase5.setText("Purchase:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelPurchase5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(purchaseCheckbox5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelSatu10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelHarga10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelDua5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerJumlah5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelDisplayImage5)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(labelNamaBarang5)))
                .addGap(36, 36, 36))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelDisplayImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNamaBarang5)
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSatu10)
                    .addComponent(labelHarga10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDua5)
                    .addComponent(spinnerJumlah5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPurchase5)
                    .addComponent(purchaseCheckbox5))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        labelDisplayImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/croissant (1).jpg"))); // NOI18N

        labelNamaBarang3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamaBarang3.setText("Croissant");

        labelDua3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDua3.setText("Jumlah: ");

        spinnerJumlah3.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        spinnerJumlah3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        labelHarga8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHarga8.setText("30000");

        labelSatu8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSatu8.setText("Harga: Rp. ");

        labelPurchase3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPurchase3.setText("Purchase:");

        purchaseCheckbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseCheckbox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addComponent(labelDisplayImage3)
                .addGap(36, 36, 36))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labelPurchase3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(purchaseCheckbox3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labelDua3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerJumlah3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labelNamaBarang3)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(labelSatu8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelHarga8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelDisplayImage3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNamaBarang3)
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSatu8)
                    .addComponent(labelHarga8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDua3)
                    .addComponent(spinnerJumlah3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPurchase3)
                    .addComponent(purchaseCheckbox3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelDisplayImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dimsum.jpg"))); // NOI18N

        labelNamaBarang4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamaBarang4.setText("Dimsum");

        labelDua4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDua4.setText("Jumlah: ");

        spinnerJumlah4.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        spinnerJumlah4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        labelHarga9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHarga9.setText("15000");

        labelSatu9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSatu9.setText("Harga: Rp. ");

        purchaseCheckbox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseCheckbox4ActionPerformed(evt);
            }
        });

        labelPurchase4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPurchase4.setText("Purchase:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelDisplayImage4)
                .addGap(36, 36, 36))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(labelSatu9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelHarga9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(labelDua4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(spinnerJumlah4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelNamaBarang4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(labelPurchase4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(purchaseCheckbox4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelDisplayImage4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNamaBarang4)
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSatu9)
                    .addComponent(labelHarga9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDua4)
                    .addComponent(spinnerJumlah4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPurchase4)
                    .addComponent(purchaseCheckbox4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(592, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(464, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 900));

        jPanel8.setBackground(new java.awt.Color(220, 220, 220));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        tf_TotalHarga.setEditable(false);
        tf_TotalHarga.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tf_TotalHarga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TotalHarga.setText("0");

        tf_Pajak.setEditable(false);
        tf_Pajak.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tf_Pajak.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_Pajak.setText("10%");

        tf_Bayar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tf_Bayar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_Bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_BayarActionPerformed(evt);
            }
        });
        tf_Bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_BayarKeyReleased(evt);
            }
        });

        tf_Kembalian.setEditable(false);
        tf_Kembalian.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tf_Kembalian.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_Kembalian.setText("0");

        tf_SubTotal.setEditable(false);
        tf_SubTotal.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tf_SubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_SubTotal.setText("0");
        tf_SubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_SubTotalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("Sub Total");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setText("Pajak");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("Total");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("Bayar");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("Kembalian");

        btn_SelesaiTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        btn_SelesaiTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_SelesaiTransaksi.setText("Selesai Transaksi");
        btn_SelesaiTransaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SelesaiTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelesaiTransaksiActionPerformed(evt);
            }
        });

        btn_CetakInvoice.setBackground(new java.awt.Color(255, 255, 255));
        btn_CetakInvoice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_CetakInvoice.setText("Cetak Invoice");
        btn_CetakInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CetakInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CetakInvoiceActionPerformed(evt);
            }
        });

        noFaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noFakturActionPerformed(evt);
            }
        });

        noFakturCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noFakturCetakActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("Nomor Meja Makan");

        tf_noMejaMakan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tf_noMejaMakan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_noMejaMakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_noMejaMakanActionPerformed(evt);
            }
        });
        tf_noMejaMakan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_noMejaMakanKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setText("Nama Pelanggan");

        tf_namaPelanggan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tf_namaPelanggan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_namaPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaPelangganActionPerformed(evt);
            }
        });
        tf_namaPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_namaPelangganKeyReleased(evt);
            }
        });

        tf_namaPelangganCetak.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tf_namaPelangganCetak.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_namaPelangganCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaPelangganCetakActionPerformed(evt);
            }
        });
        tf_namaPelangganCetak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_namaPelangganCetakKeyReleased(evt);
            }
        });

        tf_noMejaMakanCetak.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tf_noMejaMakanCetak.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_noMejaMakanCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_noMejaMakanCetakActionPerformed(evt);
            }
        });
        tf_noMejaMakanCetak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_noMejaMakanCetakKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_CetakInvoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_SelesaiTransaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Pajak, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_TotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_noMejaMakan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_namaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(noFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_noMejaMakanCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_namaPelangganCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noFakturCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_namaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_noMejaMakan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Pajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_TotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(btn_SelesaiTransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_CetakInvoice)
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noFakturCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_namaPelangganCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_noMejaMakanCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 360, 950));

        btn_back1.setBackground(new java.awt.Color(255, 255, 255));
        btn_back1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_back1.setText("Back");
        btn_back1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseCheckboxActionPerformed
        // TODO add your handling code here:
        calculateTotal();
    }//GEN-LAST:event_purchaseCheckboxActionPerformed

    private void purchaseCheckbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseCheckbox1ActionPerformed
        // TODO add your handling code here:
        calculateTotal();
    }//GEN-LAST:event_purchaseCheckbox1ActionPerformed

    private void purchaseCheckbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseCheckbox2ActionPerformed
        // TODO add your handling code here:
        calculateTotal();
    }//GEN-LAST:event_purchaseCheckbox2ActionPerformed

    private void purchaseCheckbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseCheckbox3ActionPerformed
        // TODO add your handling code here:
        calculateTotal();
    }//GEN-LAST:event_purchaseCheckbox3ActionPerformed

    private void purchaseCheckbox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseCheckbox4ActionPerformed
        // TODO add your handling code here:
        calculateTotal();
    }//GEN-LAST:event_purchaseCheckbox4ActionPerformed

    private void purchaseCheckbox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseCheckbox5ActionPerformed
        // TODO add your handling code here:
        calculateTotal();
    }//GEN-LAST:event_purchaseCheckbox5ActionPerformed

    private void btn_SelesaiTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelesaiTransaksiActionPerformed
        // TODO add your handling code here:
        if (tf_Bayar.getText().isEmpty() || tf_Kembalian.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mohon Lengkapi Nominal Bayar!", "Restaurant Kita", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int bayar = Integer.parseInt(tf_Bayar.getText());
        int total = Integer.parseInt(tf_TotalHarga.getText());
        int meja_makan = Integer.parseInt(tf_noMejaMakan.getText());
        String nama_pelanggan = (tf_namaPelanggan.getText());

        if (bayar < total) {
            JOptionPane.showMessageDialog(null, "Uang anda kurang", "Restaurant Kita", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String noFaktur = this.noFaktur.getText();
        String namaPelangganCetak = this.tf_namaPelanggan.getText();
        String noMejaMakanCetak = this.tf_noMejaMakan.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tanggalPenjualan = sdf.format(new java.util.Date());
        int kembalian = Integer.parseInt(tf_Kembalian.getText());
        int pajak = Integer.parseInt(tf_Pajak.getText());

        JCheckBox[] checkboxes = {purchaseCheckbox, purchaseCheckbox1, purchaseCheckbox2, purchaseCheckbox3, purchaseCheckbox4, purchaseCheckbox5};
        JSpinner[] spinners = {spinnerJumlah1, spinnerJumlah, spinnerJumlah2, spinnerJumlah3, spinnerJumlah4, spinnerJumlah5};
        String[] itemNames = {"Ikan Gurame", "Ayam Bakar", "Ramen", "Croissant", "Dimsum", "Kimchi"};

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO tb_penjualan (no_faktur, nama_makanan, harga_satuan, jumlah_makanan, total_harga, bayar, kembalian, tanggal_penjualan, no_meja_makan, nama_pelanggan, pajak) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);

            for (int i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].isSelected()) {
                    int quantity = (Integer) spinners[i].getValue();
                    int totalItemPrice = quantity * prices[i];

                    p.setString(1, noFaktur);
                    p.setString(2, itemNames[i]);
                    p.setInt(3, prices[i]);
                    p.setInt(4, quantity);
                    p.setInt(5, totalItemPrice);
                    p.setInt(6, bayar);
                    p.setInt(7, kembalian);
                    p.setString(8, tanggalPenjualan);
                    p.setInt(9, meja_makan);
                    p.setString(10, nama_pelanggan);
                    p.setInt(11, pajak);

                    p.addBatch();
                }
            }

            p.executeBatch();
            JOptionPane.showMessageDialog(null, "TRANSAKSI SELESAI", "Restaurant Kita", JOptionPane.INFORMATION_MESSAGE);
            for (JCheckBox checkbox : checkboxes) {
                checkbox.setSelected(false);
            }

            for (JSpinner spinner : spinners) {
                spinner.setValue(0);
            }
            noFakturCetak.setText(noFaktur);
            tf_namaPelangganCetak.setText(namaPelangganCetak);
            tf_noMejaMakanCetak.setText(noMejaMakanCetak);
            tf_namaPelanggan.setText("");
            tf_noMejaMakan.setText("");
            tf_TotalHarga.setText("");
            tf_Pajak.setText("");
            tf_SubTotal.setText("");
            tf_Kembalian.setText("");
            tf_Bayar.setText("");
            nofaktur();
        } catch (SQLException e) {
            System.out.println("Terjadi Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btn_SelesaiTransaksiActionPerformed

    private void btn_CetakInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CetakInvoiceActionPerformed
        // TODO add your handling code here:
        try {
            String noFakturYangCetak = noFakturCetak.getText();
            if (noFakturYangCetak.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nomor Faktur kosong!", "Restaurant Kita", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String directoryPath = "C:/Users/adiyo/OneDrive/Documents";
            String filePath = directoryPath + "/Invoice_RestaurantKita_" + noFakturYangCetak + ".pdf";

            filePath = getUniqueFilePath(directoryPath, "Invoice_RestaurantKita_" + noFakturYangCetak + ".pdf");

            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Paragraph title = new Paragraph("INVOICE - Restaurant Kita", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Paragraph noFakturParagraph = new Paragraph("No. Faktur: " + noFakturYangCetak, FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));
            noFakturParagraph.setSpacingBefore(20);
            document.add(noFakturParagraph);

            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            Paragraph dateParagraph = new Paragraph("Tanggal: " + date.toString(), FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));
            document.add(dateParagraph);

            Paragraph namaPelangganParagraph = new Paragraph("Nama Pelanggan: " + tf_namaPelangganCetak.getText() + "\n", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));
            document.add(namaPelangganParagraph);

            Paragraph noMejaMakanParagraph = new Paragraph("Nomor Meja Makan: " + tf_noMejaMakanCetak.getText() + "\n\n", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));
            document.add(noMejaMakanParagraph);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(20f);
            table.setSpacingAfter(20f);

            String[] headers = {"Nama Barang", "Jumlah Jual", "Harga Barang", "Total"};
            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell(new Phrase(header, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(headerCell);
            }

            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tb_penjualan WHERE no_faktur = '" + noFakturYangCetak + "'";
            ResultSet r = s.executeQuery(sql);

            String totalBelanja = "";
            String bayar = "";
            String kembalian = "";

            while (r.next()) {
                table.addCell(new PdfPCell(new Phrase(r.getString("nama_makanan"), FontFactory.getFont(FontFactory.HELVETICA, 12))));
                table.addCell(new PdfPCell(new Phrase(r.getString("jumlah_makanan"), FontFactory.getFont(FontFactory.HELVETICA, 12))));
                table.addCell(new PdfPCell(new Phrase(r.getString("harga_satuan"), FontFactory.getFont(FontFactory.HELVETICA, 12))));
                table.addCell(new PdfPCell(new Phrase(r.getString("total_harga"), FontFactory.getFont(FontFactory.HELVETICA, 12))));
                totalBelanja = r.getString("total_harga");
                bayar = r.getString("bayar");
                kembalian = r.getString("kembalian");
            }

            document.add(table);

            Paragraph totalBelanjaParagraph = new Paragraph("Total Belanja: Rp. " + totalBelanja, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            totalBelanjaParagraph.setAlignment(Element.ALIGN_RIGHT);
            totalBelanjaParagraph.setSpacingBefore(10f);
            document.add(totalBelanjaParagraph);

            Paragraph bayarParagraph = new Paragraph("Uang Tunai: Rp. " + bayar, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            bayarParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(bayarParagraph);

            Paragraph kembalianParagraph = new Paragraph("Kembalian: Rp. " + kembalian, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            kembalianParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(kembalianParagraph);
            document.close();

            JOptionPane.showMessageDialog(null, "Invoice berhasil dicetak!", "Restaurant Kita", JOptionPane.INFORMATION_MESSAGE);

            noFakturCetak.setText("");

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(filePath));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Restaurant Kita", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_CetakInvoiceActionPerformed

    private void tf_SubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_SubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_SubTotalActionPerformed

    private void tf_BayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_BayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_BayarActionPerformed

    private void tf_BayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_BayarKeyReleased
        // TODO add your handling code here:
        int bayar = Integer.parseInt(tf_Bayar.getText());
        int total = Integer.parseInt(tf_TotalHarga.getText());
        int kembalian = bayar - total;
        tf_Kembalian.setText(String.valueOf(kembalian));
    }//GEN-LAST:event_tf_BayarKeyReleased

    private void noFakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noFakturActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noFakturActionPerformed

    private void noFakturCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noFakturCetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noFakturCetakActionPerformed

    private void tf_noMejaMakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_noMejaMakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_noMejaMakanActionPerformed

    private void tf_noMejaMakanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_noMejaMakanKeyReleased
        // TODO add your handling code here:
        String input = tf_noMejaMakan.getText();

        try {
            int tableNumber = Integer.parseInt(input);

            if (tableNumber < 1 || tableNumber > 50) {
                JOptionPane.showMessageDialog(this, "Nomor Meja Makan harus diantara 1 dan 50", "Invalid Table Number", JOptionPane.ERROR_MESSAGE);
                tf_noMejaMakan.setText("");
            }
        } catch (NumberFormatException e) {
            if (!input.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tolong Gunakan Angka", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                tf_noMejaMakan.setText("");
            }
        }
    }//GEN-LAST:event_tf_noMejaMakanKeyReleased

    private void tf_namaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaPelangganActionPerformed

    private void tf_namaPelangganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_namaPelangganKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaPelangganKeyReleased

    private void tf_namaPelangganCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaPelangganCetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaPelangganCetakActionPerformed

    private void tf_namaPelangganCetakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_namaPelangganCetakKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaPelangganCetakKeyReleased

    private void tf_noMejaMakanCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_noMejaMakanCetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_noMejaMakanCetakActionPerformed

    private void tf_noMejaMakanCetakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_noMejaMakanCetakKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_noMejaMakanCetakKeyReleased

    private void btn_back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back1ActionPerformed
        // TODO add your handling code here:
        fmenu fm = new fmenu();
        fm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_back1ActionPerformed

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
            java.util.logging.Logger.getLogger(fDineIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fDineIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fDineIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fDineIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fDineIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CetakInvoice;
    private javax.swing.JButton btn_SelesaiTransaksi;
    private javax.swing.JButton btn_back1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelDisplayImage;
    private javax.swing.JLabel labelDisplayImage1;
    private javax.swing.JLabel labelDisplayImage2;
    private javax.swing.JLabel labelDisplayImage3;
    private javax.swing.JLabel labelDisplayImage4;
    private javax.swing.JLabel labelDisplayImage5;
    private javax.swing.JLabel labelDua;
    private javax.swing.JLabel labelDua1;
    private javax.swing.JLabel labelDua2;
    private javax.swing.JLabel labelDua3;
    private javax.swing.JLabel labelDua4;
    private javax.swing.JLabel labelDua5;
    private javax.swing.JLabel labelHarga1;
    private javax.swing.JLabel labelHarga10;
    private javax.swing.JLabel labelHarga6;
    private javax.swing.JLabel labelHarga7;
    private javax.swing.JLabel labelHarga8;
    private javax.swing.JLabel labelHarga9;
    private javax.swing.JLabel labelNamaBarang;
    private javax.swing.JLabel labelNamaBarang1;
    private javax.swing.JLabel labelNamaBarang2;
    private javax.swing.JLabel labelNamaBarang3;
    private javax.swing.JLabel labelNamaBarang4;
    private javax.swing.JLabel labelNamaBarang5;
    private javax.swing.JLabel labelPurchase;
    private javax.swing.JLabel labelPurchase1;
    private javax.swing.JLabel labelPurchase2;
    private javax.swing.JLabel labelPurchase3;
    private javax.swing.JLabel labelPurchase4;
    private javax.swing.JLabel labelPurchase5;
    private javax.swing.JLabel labelSatu1;
    private javax.swing.JLabel labelSatu10;
    private javax.swing.JLabel labelSatu6;
    private javax.swing.JLabel labelSatu7;
    private javax.swing.JLabel labelSatu8;
    private javax.swing.JLabel labelSatu9;
    private javax.swing.JTextField noFaktur;
    private javax.swing.JTextField noFakturCetak;
    private javax.swing.JCheckBox purchaseCheckbox;
    private javax.swing.JCheckBox purchaseCheckbox1;
    private javax.swing.JCheckBox purchaseCheckbox2;
    private javax.swing.JCheckBox purchaseCheckbox3;
    private javax.swing.JCheckBox purchaseCheckbox4;
    private javax.swing.JCheckBox purchaseCheckbox5;
    private javax.swing.JSpinner spinnerJumlah;
    private javax.swing.JSpinner spinnerJumlah1;
    private javax.swing.JSpinner spinnerJumlah2;
    private javax.swing.JSpinner spinnerJumlah3;
    private javax.swing.JSpinner spinnerJumlah4;
    private javax.swing.JSpinner spinnerJumlah5;
    private javax.swing.JTextField tf_Bayar;
    private javax.swing.JTextField tf_Kembalian;
    private javax.swing.JTextField tf_Pajak;
    private javax.swing.JTextField tf_SubTotal;
    private javax.swing.JTextField tf_TotalHarga;
    private javax.swing.JTextField tf_namaPelanggan;
    private javax.swing.JTextField tf_namaPelangganCetak;
    private javax.swing.JTextField tf_noMejaMakan;
    private javax.swing.JTextField tf_noMejaMakanCetak;
    // End of variables declaration//GEN-END:variables
}
