package GiaoDien;

import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frQLSach extends javax.swing.JFrame {

    public frQLSach() {
        initComponents();
        txtMaSach.setEditable(false);
        txtMaLoaiSach1.setEditable(false);
        showData();
        showDataLoaiSach();
        
       
    }

    String driver = "com.microsoft.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://DESKTOP-DRIHG7H\\SQLEXPRESS:1433;DatabaseName=QLTV; "
            + "user=sa; password=SA ;encrypt=true;trustServerCertificate=true;";
    Statement st;
    ResultSet rs;

    private int flag = 0;

    @SuppressWarnings("unchecked")

    public void showDataLoaiSach() {
        try {
            String[] columnNames = {"Mã loại sách", "Tên loại sách"};
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);

            tbLoaiSach.setModel(model);

            String maLoaiSach = "";
            String tenLoaiSach = "";
            
            rs = getData("select * from LoaiSach ");
            while (rs.next()) {
                maLoaiSach = rs.getString("MaLoaiSach");
                tenLoaiSach = rs.getString("TenLoaiSach");
                
                model.addRow(new Object[]{maLoaiSach, tenLoaiSach});

            }
        } catch (SQLException ex) {
            Logger.getLogger(frQLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // load dư liệu lên table
    public void showData() {
        try {
            String[] columnNames = {"Mã sách", "Tên sách", "Tên tác giả", "Tên Nhà Xuất Bản", "Năm Xuất Bản", "Số trang", "Số lượng sách", "Loại sách"};
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);

            tbQLS.setModel(model);

            String maSach = "";
            String tenSach = "";
            String tenDocGia = "";
            String tenNhaXuatBan = "";
            String namXuatBan = "";
            String soTrang = "";
            String soLuongSach = "";
            String maLoaiSach = "";

            rs = getData("select * from Sach S , LoaiSach LS where S.MaLoaiSach = LS.MaLoaiSach ");
            while (rs.next()) {
                maSach = rs.getString("MaSach");
                tenSach = rs.getString("TenSach");
                tenDocGia = rs.getString("TenDocGia");
                tenNhaXuatBan = rs.getString("TenNhaXuatBan");
                namXuatBan = rs.getString("NamXuatBan");
                soTrang = rs.getString("SoTrang");
                soLuongSach = rs.getString("SoLuongSach");
                maLoaiSach = rs.getString("TenLoaiSach");

                model.addRow(new Object[]{maSach, tenSach, tenDocGia, tenNhaXuatBan, namXuatBan, soTrang, soLuongSach, maLoaiSach});

            }
        } catch (SQLException ex) {
            Logger.getLogger(frQLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void InsertData() {
        try {
            String[] stringSQL = {txtMaSach.getText(), txtTenSach.getText(), txtTenTacGia.getText(), txtNhaXuatBan.getText(),
                txtNamXuatBan.getText(), txtSoTrang.getText(), txtSoLuongSach.getText(), txtMaLoaiSach.getText()};

            Connection con = DriverManager.getConnection(url);
            int isInsert = 0;
            isInsert = ExcuteSQLInsert(stringSQL);
            if (isInsert > 0) {
                JOptionPane.showConfirmDialog(this, "Da them du lieu thanh cong");
            } else {
                JOptionPane.showConfirmDialog(this, "Da them du lieu khong thanh cong");

            }
        } catch (SQLException ex) {
            Logger.getLogger(frQLSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        showData();
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

    public int ExcuteSQLInsert(String[] stringSQL) {
        int rowsInserted = 0;
        String sql = "insert into Sach (MaSach, TenSach, TenDocGia, TenNhaXuatBan, NamXuatBan, SoTrang, SoLuongSach, MaLoaiSach) values ( ?,?,?,?,?,?,?,? );";
        PreparedStatement statement;
        try {
            Connection con = DriverManager.getConnection(url);

            statement = con.prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
            statement.setString(5, stringSQL[4]);
            statement.setString(6, stringSQL[5]);
            statement.setString(7, stringSQL[6]);
            statement.setString(8, stringSQL[7]);

            rowsInserted = statement.executeUpdate();

        } catch (Exception ex) {
        }
        return rowsInserted;
    }

    public int ExcuteSQLUpdate(String[] stringSQL) {
        int rowsInserted = 0;
        String sql = "update Sach set  TenSach=?, TenDocGia =?, TenNhaXuatBan=?, NamXuatBan=?, SoTrang=?, SoLuongSach=?, MaLoaiSach=? where MaSach=?";
        PreparedStatement statement;
        try {
            Connection con = DriverManager.getConnection(url);

            statement = con.prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
            statement.setString(5, stringSQL[4]);
            statement.setString(6, stringSQL[5]);
            statement.setString(7, stringSQL[6]);
            statement.setString(8, stringSQL[7]);

            rowsInserted = statement.executeUpdate();

        } catch (Exception ex) {
        }
        return rowsInserted;
    }

    public int ExcuteSQLDelete(String[] stringSQL) {
        int rowsInserted = 0;
        String sql = "delete from Sach where MaSach=?";
        PreparedStatement statement;
        try {
            Connection con = DriverManager.getConnection(url);

            statement = con.prepareStatement(sql);
            statement.setString(1, stringSQL[0]);

            rowsInserted = statement.executeUpdate();

        } catch (Exception ex) {
        }
        return rowsInserted;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtNhaXuatBan = new javax.swing.JTextField();
        txtTenTacGia = new javax.swing.JTextField();
        txtSoTrang = new javax.swing.JTextField();
        txtNamXuatBan = new javax.swing.JTextField();
        txtMaLoaiSach = new javax.swing.JTextField();
        txtSoLuongSach = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQLS = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLoaiSach = new javax.swing.JTable();
        txtMaLoaiSach1 = new javax.swing.JTextField();
        txtTenLoaiSach1 = new javax.swing.JTextField();
        btnThemLoaiHang = new javax.swing.JButton();
        btnXoaLoaiHang = new javax.swing.JButton();
        btnSuaLoaiHang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Mã Sách");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Tên Sách");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Tên Tác Giả ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Nhà Xuất Bản");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Năm Xuất Bản");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Số Trang");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Số Lượng Sách");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Loại Sách");

        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThem.setText("Thêm ");
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

        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("THÔNG TIN QUẢN LÝ SÁCH");

        txtMaSach.setBackground(new java.awt.Color(204, 204, 204));
        txtMaSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });

        txtTenSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtNhaXuatBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTenTacGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtSoTrang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtNamXuatBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtMaLoaiSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtSoLuongSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tbQLS.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbQLS.setModel(new javax.swing.table.DefaultTableModel(
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
        tbQLS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbQLSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbQLS);

        btnQuayLai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Mã Loại Sách");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Tên Loại Sách");

        tbLoaiSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbLoaiSach.setModel(new javax.swing.table.DefaultTableModel(
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
        tbLoaiSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLoaiSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbLoaiSach);

        txtMaLoaiSach1.setBackground(new java.awt.Color(204, 204, 204));
        txtMaLoaiSach1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTenLoaiSach1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnThemLoaiHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemLoaiHang.setText("Thêm");
        btnThemLoaiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiHangActionPerformed(evt);
            }
        });

        btnXoaLoaiHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoaLoaiHang.setText("Xóa");
        btnXoaLoaiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLoaiHangActionPerformed(evt);
            }
        });

        btnSuaLoaiHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSuaLoaiHang.setText("Sửa");
        btnSuaLoaiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLoaiHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel9)
                .addContainerGap(528, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnThemLoaiHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaLoaiSach, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(txtSoLuongSach, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(txtSoTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(txtNamXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(txtTenTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(txtMaLoaiSach1)
                            .addComponent(txtTenLoaiSach1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnXoaLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuaLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuayLai)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaLoaiSach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenLoaiSach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemLoaiHang)
                            .addComponent(btnXoaLoaiHang)
                            .addComponent(btnSuaLoaiHang)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuongSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuayLai)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnThem))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // hàm thêm 1 quyển sách
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "insert into Sach ( TenSach, TenDocGia, TenNhaXuatBan, NamXuatBan, SoTrang, SoLuongSach, MaLoaiSach) values ( ?, ?, ?, ?, ?, ?,? );";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtTenSach.getText());
            ps.setString(2, txtTenTacGia.getText());
            ps.setString(3, txtNhaXuatBan.getText());
            ps.setString(4, txtNamXuatBan.getText());
            ps.setString(5, txtSoTrang.getText());
            ps.setString(6, txtSoLuongSach.getText());
            ps.setString(7, txtMaLoaiSach.getText());
            
            int n = ps.executeUpdate();

            // int n = ps.executeUpdate();
            

            if (txtTenSach.getText().equals("") | txtTenTacGia.getText().equals("")
                    | txtNhaXuatBan.getText().equals("") | txtNamXuatBan.getText().equals("") 
                    | txtSoTrang.getText().equals("") | txtSoLuongSach.getText().equals("")| txtMaLoaiSach.getText().equals("")) {
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
            String sql = "delete from sach where masach = ?;";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtMaSach.getText());
            
            int n = ps.executeUpdate();

            // int n = ps.executeUpdate();
            

            if (txtMaSach.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống ô mã sách ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
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

    // lệnh sửa 
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       
         try {

            Connection con = DriverManager.getConnection(url);
            String sql = "update sach set TenSach = ? , TenDocGia= ? ,TenNhaXuatBan= ?,NamXuatBan = ?, SoTrang= ?,SoLuongSach= ?,MaLoaiSach = ? where MaSach = ?;";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtTenSach.getText());
            ps.setString(2, txtTenTacGia.getText());
            ps.setString(3, txtNhaXuatBan.getText());
            ps.setString(4, txtNamXuatBan.getText());
            ps.setString(5, txtSoTrang.getText());
            ps.setString(6, txtSoLuongSach.getText());
            ps.setString(7, txtMaLoaiSach.getText());
            ps.setString(8, txtMaSach.getText());
             
            int n = ps.executeUpdate();

            // int n = ps.executeUpdate();
            

            if (txtMaSach.getText().equals("") /*|   txtTenSach.getText().equals("") | txtTenTacGia.getText().equals("")
                    | txtNhaXuatBan.getText().equals("") | txtNamXuatBan.getText().equals("") 
                    | txtSoTrang.getText().equals("") | txtSoLuongSach.getText().equals("")| txtMaLoaiSach.getText().equals("")*/) {
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

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        frAdmin ad = new frAdmin();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    
    
    private void tbQLSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQLSMouseClicked
        int row = tbQLS.getSelectedRow();
        
        if(row >= 0){
            txtMaSach.setText(tbQLS.getValueAt(row, 0).toString());
            txtTenSach.setText(tbQLS.getValueAt(row, 1).toString());
            txtTenTacGia.setText(tbQLS.getValueAt(row, 2).toString());
            txtNhaXuatBan.setText(tbQLS.getValueAt(row, 3).toString());
            txtNamXuatBan.setText(tbQLS.getValueAt(row, 4).toString());
            txtSoTrang.setText(tbQLS.getValueAt(row, 5).toString());
            txtSoLuongSach.setText(tbQLS.getValueAt(row, 6).toString());
            txtMaLoaiSach.setText(tbQLS.getValueAt(row, 7).toString());    
        }        
    }//GEN-LAST:event_tbQLSMouseClicked
    
    
    
   
    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void tbLoaiSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLoaiSachMouseClicked
        int row = tbLoaiSach.getSelectedRow();
        
        if(row >= 0){
            txtMaLoaiSach1.setText(tbLoaiSach.getValueAt(row, 0).toString());
            txtTenLoaiSach1.setText(tbLoaiSach.getValueAt(row, 1).toString());  
        }
    }//GEN-LAST:event_tbLoaiSachMouseClicked

    private void btnThemLoaiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiHangActionPerformed
        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "insert into LoaiSach (TenLoaiSach) values (?);";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtTenLoaiSach1.getText());
                        
            int n = ps.executeUpdate();
            
            if (txtTenLoaiSach1.getText().equals("")) {
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
        showDataLoaiSach();
    }//GEN-LAST:event_btnThemLoaiHangActionPerformed

    private void btnXoaLoaiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLoaiHangActionPerformed
        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "delete from LoaiSach where  MaLoaiSach = ?;";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtMaLoaiSach1.getText());
            
            int n = ps.executeUpdate();

            if (txtMaLoaiSach1.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống ô mã sách ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (n != 0 ) {
                
                JOptionPane.showMessageDialog(this, "Xóa sách thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sách thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showDataLoaiSach();

    }//GEN-LAST:event_btnXoaLoaiHangActionPerformed

    private void btnSuaLoaiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLoaiHangActionPerformed
         try {
            Connection con = DriverManager.getConnection(url);
            String sql = "update LoaiSach  set LoaiSach.TenLoaiSach = ?  where LoaiSach.MaLoaiSach = ?";

            PreparedStatement ps = con.prepareCall(sql);

            ps.setString(1, txtTenLoaiSach1.getText());
            ps.setString(2, txtMaLoaiSach1.getText());
        
            int n = ps.executeUpdate();

            if (txtMaLoaiSach1.getText().equals("")|| txtTenLoaiSach1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không được bỏ trống", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (n != 0 ) {
                
                JOptionPane.showMessageDialog(this, "Cập nhập thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhập thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showDataLoaiSach();


    }//GEN-LAST:event_btnSuaLoaiHangActionPerformed

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
            java.util.logging.Logger.getLogger(frQLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frQLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frQLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frQLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frQLSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaLoaiHang;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemLoaiHang;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaLoaiHang;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbLoaiSach;
    private javax.swing.JTable tbQLS;
    private javax.swing.JTextField txtMaLoaiSach;
    private javax.swing.JTextField txtMaLoaiSach1;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNamXuatBan;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextField txtSoLuongSach;
    private javax.swing.JTextField txtSoTrang;
    private javax.swing.JTextField txtTenLoaiSach1;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenTacGia;
    // End of variables declaration//GEN-END:variables
}
