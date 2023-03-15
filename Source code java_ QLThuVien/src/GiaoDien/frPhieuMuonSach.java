package GiaoDien;

import ConnectDB.DBConnect;
import java.sql.*;
import java.util.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class frPhieuMuonSach extends javax.swing.JFrame {

    String driver = "com.microsoft.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://DESKTOP-DRIHG7H\\SQLEXPRESS:1433;DatabaseName=QLTV; "
            + "user=sa; password=SA ;encrypt=true;trustServerCertificate=true;";
    Statement st;
    ResultSet rs;

    private int flag = 0;

    public frPhieuMuonSach() {
        initComponents();
        txtMaPMS.setEditable(false);
        txtMaSach.setEditable(false);
        txtTenSach.setEditable(false);
        showDataSach();
        showData();
    }

    public void showData() {
        try {
            String[] columnNames = {"Mã PMS", "Mã Sách", "Tên Sách", "Số Lượng Mượn", "Ngày Mượn", "Thời Gian Mượn", "Tiền Cọc (ngàn đồng)", "Mã Đọc Giả", "Tên Đọc Giả"};
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);

            tbPMS.setModel(model);

            String maPMS = "";
            String ngayMuon = "";
            String thoiGianMuon = "";
            String tienCoc = "";
            String soLuongMuon = "";
            String maSach = "";
            String tenSach = "";
            String maDocGia = "";
            String tenDocGia = "";

            rs = getData("select PMS.MaPhieuMuonSach, CTPMS.MaSach, S.TenSach, CTPMS.SoLuongMuon,  CTPMS.NgayMuon, CTPMS.ThoiGianMuon, CTPMS.TienCoc,  DG.MaDocGia, DG.TenĐocGia\n"
                    + "from PhieuMuonSach PMS, CT_PhieuMuonSach CTPMS, Sach S, DocGia DG \n"
                    + "where PMS.MaDocGia = DG.MaDocGia and CTPMS.MaSach = S.MaSach  "
                    + "and CTPMS.MaPhieuMuonSach = PMS.MaPhieuMuonSach and  CTPMS.MaPhieuMuonSach = " + txtMaPMS.getText() + " ");
            while (rs.next()) {
                maPMS = rs.getString("MaPhieuMuonSach");
                maSach = rs.getString("MaSach");
                tenSach = rs.getString("TenSach");
                soLuongMuon = rs.getString("SoLuongMuon");
                ngayMuon = rs.getString("NgayMuon");
                thoiGianMuon = rs.getString("ThoiGianMuon");
                tienCoc = rs.getString("TienCoc");
                maDocGia = rs.getString("MaDocGia");
                tenDocGia = rs.getString("TenĐocGia");

                model.addRow(new Object[]{maPMS, maSach, tenSach, soLuongMuon, ngayMuon, thoiGianMuon, tienCoc, maDocGia, tenDocGia});

            }
        } catch (SQLException ex) {
            Logger.getLogger(frQLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showDataSach() {
        try {
            String[] columnNames = {"Mã Sách", "Tên Sách", };
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);

            tbSach.setModel(model);

            String maSach = "";
            String tenSach = "";
            

            rs = getData("select S.MaSach, S.TenSach  from Sach S  ");
            while (rs.next()) {

                maSach = rs.getString("MaSach");
                tenSach = rs.getString("TenSach");
                
                model.addRow(new Object[]{maSach, tenSach});

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cbSoLuongMuon = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JButton();
        txtMaDocGia = new javax.swing.JTextField();
        txtTienCoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenDocGia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNgayMuon = new javax.swing.JTextPane();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        cbThoiGianMuon = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnTaoPMS = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtMaPMS = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPMS = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 865));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("PHIẾU MƯỢN SÁCH");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu mượn sách"));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Tên Sách");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Thời Gian Mượn");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tiền Cọc");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Ngày Mượn ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Số Lượng Mượn");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Mã Đôc Giả");

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

        cbSoLuongMuon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbSoLuongMuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtMaDocGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtMaDocGiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtMaDocGiaMouseExited(evt);
            }
        });

        txtTienCoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Tên Độc Giả");

        txtTenDocGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Mã Sách");

        txtNgayMuon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(txtNgayMuon);

        txtMaSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTenSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cbThoiGianMuon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbThoiGianMuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7 Ngày", "14 Ngày ", "21 Ngày" }));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("(*Ngàn đồng)");

        btnTaoPMS.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTaoPMS.setText("Tạo Phiếu Mượn Sách Mới");
        btnTaoPMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPMSActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Mã PMS");

        txtMaPMS.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaPMS.setText("2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(78, 78, 78)
                        .addComponent(txtMaPMS))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSoLuongMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSach)
                            .addComponent(txtTenSach)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTaoPMS)
                        .addGap(161, 161, 161))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbThoiGianMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addGap(119, 119, 119))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(146, 146, 146)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTenDocGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMaDocGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(88, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbThoiGianMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtMaPMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(cbSoLuongMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtTenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(btnTaoPMS, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        tbPMS.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbPMS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbPMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPMSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPMS);

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
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnQuayLai)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(547, 547, 547))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuayLai)))
                .addGap(875, 875, 875))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "insert into CT_PhieuMuonSach (MaPhieuMuonSach , NgayMuon, ThoiGianMuon, TienCoc, SoLuongMuon, MaSach) values (?,?,?,?,?,?);";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtMaPMS.getText());
            ps.setString(2, txtNgayMuon.getText());
            ps.setString(3, cbThoiGianMuon.getSelectedItem().toString());
            ps.setString(4, txtTienCoc.getText());
            ps.setString(5, cbSoLuongMuon.getSelectedItem().toString());
            ps.setString(6, txtMaSach.getText());

            int n = ps.executeUpdate();

            if (txtMaPMS.getText().equals("")
                    | txtNgayMuon.getText().equals("") | txtTienCoc.getText().equals("") | txtMaSach.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (n != 0) {
                JOptionPane.showMessageDialog(this, "Thêm sách thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Thêm sách thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbPMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPMSMouseClicked
        int row = tbPMS.getSelectedRow();

        if (row >= 0) {
            txtMaPMS.setText(tbPMS.getValueAt(row, 0).toString());
            txtMaSach.setText(tbPMS.getValueAt(row, 1).toString());
            txtTenSach.setText(tbPMS.getValueAt(row, 2).toString());
            cbSoLuongMuon.setSelectedItem(tbPMS.getModel().getValueAt(tbPMS.getSelectedRow(), 3) + "");
            txtNgayMuon.setText(tbPMS.getValueAt(row, 4).toString());
            cbThoiGianMuon.setSelectedItem(tbPMS.getModel().getValueAt(tbPMS.getSelectedRow(), 5) + "");
            txtTienCoc.setText(tbPMS.getValueAt(row, 6).toString());
            txtMaDocGia.setText(tbPMS.getValueAt(row, 7).toString());
            txtTenDocGia.setText(tbPMS.getValueAt(row, 8).toString());

        }


    }//GEN-LAST:event_tbPMSMouseClicked

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        frAdmin ad = new frAdmin();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void tbSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSachMouseClicked
        int row = tbSach.getSelectedRow();

        if (row >= 0) {

            txtMaSach.setText(tbSach.getValueAt(row, 0).toString());
            txtTenSach.setText(tbSach.getValueAt(row, 1).toString());

        }
    }//GEN-LAST:event_tbSachMouseClicked

    private void btnTaoPMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPMSActionPerformed
        if (txtMaDocGia.getText().equals("") | txtTenDocGia.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống ô Mã Độc Giả và Tên Độc Giả", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Connection con = DriverManager.getConnection(url);
                String sql = "insert into PhieuMuonSach (MaDocGia) values (?);";

                PreparedStatement ps = con.prepareCall(sql);

                ps.setString(1, txtMaDocGia.getText());

                int n = ps.executeUpdate();

                if (txtMaDocGia.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Không được bỏ trống", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else if (n != 0) {
                    JOptionPane.showMessageDialog(this, "Tạo Phiếu Mượn Sách Mới thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);

                    String maPMS = "";

                    rs = getData("select max (PMS.MaPhieuMuonSach) as N'MaPMS' from PhieuMuonSach PMS ;");
                    while (rs.next()) {
                        maPMS = rs.getString("MaPMS");
                        txtMaPMS.setText(maPMS);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm sách thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        showData();
    }//GEN-LAST:event_btnTaoPMSActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "delete from CT_PhieuMuonSach  where CT_PhieuMuonSach.MaPhieuMuonSach = ? and CT_PhieuMuonSach.MaSach = ?;";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtMaPMS.getText());
            ps.setString(2, txtMaSach.getText());

            int n = ps.executeUpdate();

            // int n = ps.executeUpdate();
            if (txtMaPMS.getText().equals("") | txtMaSach.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống ô mã nhân viên ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (n != 0) {

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
            String sql = "update CT_PhieuMuonSach set NgayMuon = ? , ThoiGianMuon = ?, TienCoc = ?, SoLuongMuon= ? where MaPhieuMuonSach =  ? and MaSach = ?; ";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtNgayMuon.getText());
            ps.setString(2, cbThoiGianMuon.getSelectedItem().toString());
            ps.setString(3, txtTienCoc.getText());
            ps.setString(4, cbSoLuongMuon.getSelectedItem().toString());
            ps.setString(5, txtMaPMS.getText());
            ps.setString(6, txtMaSach.getText());

            int n = ps.executeUpdate();

            if (txtNgayMuon.getText().equals("") | txtTienCoc.getText().equals("") | txtMaPMS.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (n != 0) {

                JOptionPane.showMessageDialog(this, "Cập nhập thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhập thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showData();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtMaDocGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaDocGiaMouseEntered

    }//GEN-LAST:event_txtMaDocGiaMouseEntered

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
            java.util.logging.Logger.getLogger(frPhieuMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frPhieuMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frPhieuMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frPhieuMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frPhieuMuonSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoPMS;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbSoLuongMuon;
    private javax.swing.JComboBox<String> cbThoiGianMuon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbPMS;
    private javax.swing.JTable tbSach;
    private javax.swing.JTextField txtMaDocGia;
    private javax.swing.JTextField txtMaPMS;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextPane txtNgayMuon;
    private javax.swing.JTextField txtTenDocGia;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTienCoc;
    // End of variables declaration//GEN-END:variables

}
