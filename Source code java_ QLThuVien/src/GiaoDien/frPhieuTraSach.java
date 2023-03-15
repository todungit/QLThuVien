/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GiaoDien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class frPhieuTraSach extends javax.swing.JFrame {

    String driver = "com.microsoft.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://DESKTOP-DRIHG7H\\SQLEXPRESS:1433;DatabaseName=QLTV; "
            + "user=sa; password=SA ;encrypt=true;trustServerCertificate=true;";
    Statement st;
    ResultSet rs;

    private int flag = 0;
    
    public frPhieuTraSach() {
        initComponents();
        txtMaPTS.setEditable(false);
        txtMaSach.setEditable(false);
        txtTenSach.setEditable(false);
        
        showData() ;
        showDataSach();
    }

    public void showData() {
        try {
            String[] columnNames = {"Mã PTS","Mã Sách","Tên Sách","Số Lượng Trả","Tình Trạng", "Tiền Phạt (ngàn đồng)", "Ngày Trả",  "Mã Đọc Giả", "Tên Đọc Giả"};
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);

            tbPTS.setModel(model);

            String maPTS = "";
            String ngayTra = "";
            String tinhTrang = "";
            String tienPhat = "";
            String soLuongTra = "";
            String maSach = "";
            String tenSach ="";
            String maDocGia = "";
            String tenDocGia = "";
                
            rs = getData("select PTS.MaPhieuTraSach, CTPTS.MaSach, S.TenSach, CTPTS.SoLuongTra,CTPTS.TinhTrang, CTPTS.TienPhat,"
                        + "CTPTS.NgayTra, DG.MaDocGia, DG.TenĐocGia\n" +
                        "from PhieuTraSach PTS, CT_PhieuTraSach CTPTS, Sach S, DocGia DG \n" +
                        "where PTS.MaDocGia = DG.MaDocGia and CTPTS.MaSach = S.MaSach  and CTPTS.MaPhieuTraSach ="
                        + " PTS.MaPhieuTraSach and  CTPTS.MaPhieuTraSach = "+txtMaPTS.getText()+" ");
            while (rs.next()) {
                maPTS = rs.getString("MaPhieuTraSach");
                maSach = rs.getString("MaSach");
                tenSach = rs.getString("TenSach");
                tinhTrang = rs.getString("TinhTrang");
                soLuongTra = rs.getString("SoLuongTra");
                ngayTra = rs.getString("NgayTra");
                tienPhat = rs.getString("TienPhat");
                maDocGia = rs.getString("MaDocGia");
                tenDocGia = rs.getString("TenĐocGia");

                model.addRow(new Object[]{maPTS, maSach, tenSach, soLuongTra, tinhTrang, tienPhat, ngayTra, maDocGia, tenDocGia});
            }
        } catch (SQLException ex) {
            Logger.getLogger(frQLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cbSoLuongTra = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaPTS = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMaDocGia = new javax.swing.JTextField();
        txtTenDocGia = new javax.swing.JTextField();
        txtNgayTra = new javax.swing.JTextField();
        txtTienPhat = new javax.swing.JTextField();
        btnTaoPhieuTraSach = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbTinhTrang = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPTS = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("PHIẾU TRẢ SÁCH");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu mượn sách"));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Tên Sách");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tiền Phạt");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Ngày Trả ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Số Lượng Trả");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Tên Độc Giả");

        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        cbSoLuongTra.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbSoLuongTra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cbSoLuongTra.setMinimumSize(new java.awt.Dimension(91, 30));

        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Mã PTS");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Mã Sách");

        txtMaPTS.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaPTS.setText("1");

        txtTenSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });

        txtMaSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Mã Độc Giả");

        txtMaDocGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtMaDocGiaMouseExited(evt);
            }
        });

        txtTenDocGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDocGiaActionPerformed(evt);
            }
        });

        txtNgayTra.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtNgayTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayTraActionPerformed(evt);
            }
        });

        txtTienPhat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnTaoPhieuTraSach.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnTaoPhieuTraSach.setText("Tạo Phiếu Trả Sách");
        btnTaoPhieuTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuTraSachActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Tình Trạng");

        cbTinhTrang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không Hư Hỏng", "Hư Hỏng Nhẹ", "Hư Hỏng Nặng" }));
        cbTinhTrang.setMinimumSize(new java.awt.Dimension(91, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbTinhTrang, 0, 226, Short.MAX_VALUE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(131, 131, 131)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel11)))
                                    .addComponent(txtMaPTS, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(167, 167, 167))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnThem)
                .addGap(32, 32, 32)
                .addComponent(btnXoa)
                .addGap(31, 31, 31)
                .addComponent(btnSua)
                .addGap(81, 81, 81)
                .addComponent(btnTaoPhieuTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaPTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnTaoPhieuTraSach, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tbPTS.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbPTS.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPTSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPTS);

        btnQuayLai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        tbSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbSach.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSachMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuayLai, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(623, 623, 623)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuayLai))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void showDataSach() {
        try {
            String[] columnNames = {"Mã Sách", "Tên Sách"};
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);

            tbSach.setModel(model);

            String maSach = "";
            String tenSach ="";
            
                

            rs = getData("select S.MaSach, S.TenSach from Sach S  ");
            while (rs.next()) {
                
                maSach = rs.getString("MaSach");
                tenSach = rs.getString("TenSach");
               
                model.addRow(new Object[]{ maSach, tenSach});

            }
        } catch (SQLException ex) {
            Logger.getLogger(frQLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getData(String stringSQL) {
        rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            st = con.createStatement();
            rs = st.executeQuery(stringSQL);
        } catch (Exception ex) {
        }
        return rs;
    }
    
    
    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        frAdmin ad = new frAdmin();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void tbSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSachMouseClicked
        int row = tbSach.getSelectedRow();

        if(row >= 0){

            txtMaSach.setText(tbSach.getValueAt(row, 0).toString());
            txtTenSach.setText(tbSach.getValueAt(row, 1).toString());

        }
    }//GEN-LAST:event_tbSachMouseClicked

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed

    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void txtTenDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDocGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDocGiaActionPerformed

    private void txtNgayTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayTraActionPerformed

    private void tbPTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPTSMouseClicked
        int row = tbPTS.getSelectedRow();
        
        if(row >= 0){
            txtMaPTS.setText(tbPTS.getValueAt(row, 0).toString());
            txtMaSach.setText(tbPTS.getValueAt(row, 1).toString());
            txtTenSach.setText(tbPTS.getValueAt(row, 2).toString());        
            cbTinhTrang.setSelectedItem(tbPTS.getModel().getValueAt(tbPTS.getSelectedRow(), 4)+"");
            
            
            txtTienPhat.setText(tbPTS.getValueAt(row, 5).toString());
            txtNgayTra.setText(tbPTS.getValueAt(row, 6).toString());
            txtMaDocGia.setText(tbPTS.getValueAt(row, 7).toString());
            txtTenDocGia.setText(tbPTS.getValueAt(row, 8).toString());
            cbSoLuongTra.setSelectedItem(tbPTS.getModel().getValueAt(tbPTS.getSelectedRow(), 3)+"");
        }
    }//GEN-LAST:event_tbPTSMouseClicked

    private void btnTaoPhieuTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuTraSachActionPerformed
        if (txtMaDocGia.getText().equals("") | txtTenDocGia.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống ô Mã Độc Giả và Tên Độc Giả", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
            Connection con = DriverManager.getConnection(url);
            String sql = "insert into PhieuTraSach (MaDocGia) values (?);";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtMaDocGia.getText());
                        
            int n = ps.executeUpdate();

            if (txtMaDocGia.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (n != 0 ) {                
                JOptionPane.showMessageDialog(this, "Tạo Phiếu Trả Sách Mới thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
               
                String maPTS = "";
                
                rs  = getData( "select max (PTS.MaPhieuTraSach) as N'MaPTS' from PhieuTraSach PTS ;");
                while (rs.next())
                {
                    maPTS = rs.getString("MaPTS");
                    txtMaPTS.setText(maPTS);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sách thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
        showData();
    }//GEN-LAST:event_btnTaoPhieuTraSachActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            
            Connection con = DriverManager.getConnection(url);
            String sql = "insert into CT_PhieuTraSach (MaPhieuTraSach , NgayTra, TinhTrang, TienPhat, SoLuongTra, MaSach) values (?,?,?,?,?,?);";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtMaPTS.getText());
            ps.setString(2, txtNgayTra.getText());
            ps.setString(3, cbTinhTrang.getSelectedItem().toString());
            ps.setString(4, txtTienPhat.getText());
            ps.setString(5, cbSoLuongTra.getSelectedItem().toString());
            ps.setString(6, txtMaSach.getText());
              
            int n = ps.executeUpdate();

            if ( txtMaPTS.getText().equals("")
                    | txtNgayTra.getText().equals("") | txtMaSach.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (n != 0 ) {
                
                JOptionPane.showMessageDialog(this, "Thêm sách thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sách thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "delete from CT_PhieuTraSach  where CT_PhieuTraSach.MaPhieuTraSach = ? and CT_PhieuTraSach.MaSach = ?;";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtMaPTS.getText());
            ps.setString(2, txtMaSach.getText());
            
            int n = ps.executeUpdate();

            // int n = ps.executeUpdate();
            

            if (txtMaPTS.getText().equals("") |txtMaSach.getText().equals("")  ) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống ô mã nhân viên ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (n != 0 ) {
                
                JOptionPane.showMessageDialog(this, "Xóa sách thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sách thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showData();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "update CT_PhieuTraSach set NgayTra = ? , TinhTrang = ?, TienPhat = ?, SoLuongTra= ? where MaPhieuTraSach =  ? and MaSach = ?; ";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtNgayTra.getText());
            ps.setString(2, cbTinhTrang.getSelectedItem().toString());
            ps.setString(3, txtTienPhat.getText());
            ps.setString(4, cbSoLuongTra.getSelectedItem().toString());
            ps.setString(5, txtMaPTS.getText());
            ps.setString(6, txtMaSach.getText());


            int n = ps.executeUpdate();

            if (txtNgayTra.getText().equals("") | txtTienPhat.getText().equals("")|  txtMaPTS.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (n != 0 ) {

                JOptionPane.showMessageDialog(this, "Cập nhập thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhập thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showData();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtMaDocGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaDocGiaMouseExited
        try {
            String tenDocGia = "";

            rs = getData("select DG.TenĐocGia from DocGia DG where DG.MaDocGia = " + txtMaDocGia.getText() + "");

            if (rs.next()) {

                tenDocGia = rs.getString("TenĐocGia");

                txtTenDocGia.setText(tenDocGia);
            } else {

                JOptionPane.showMessageDialog(this, "Không tìm thấy tên có mã độc giả: " + txtMaDocGia.getText() + "", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frQLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtMaDocGiaMouseExited

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
            java.util.logging.Logger.getLogger(frPhieuTraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frPhieuTraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frPhieuTraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frPhieuTraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frPhieuTraSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoPhieuTraSach;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbSoLuongTra;
    private javax.swing.JComboBox<String> cbTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbPTS;
    private javax.swing.JTable tbSach;
    private javax.swing.JTextField txtMaDocGia;
    private javax.swing.JTextField txtMaPTS;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtTenDocGia;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTienPhat;
    // End of variables declaration//GEN-END:variables
}
