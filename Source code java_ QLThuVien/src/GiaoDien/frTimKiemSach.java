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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class frTimKiemSach extends javax.swing.JFrame {

    
    public frTimKiemSach() {
        initComponents();
        showData();
        loadDataToComboBox();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiemTheoTenSach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbTimKiemTheoLoaiSach = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        btTimKiemTheoTen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("TÌM KIẾM SÁCH");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setText("Tìm kiếm theo tên Sách");

        txtTimKiemTheoTenSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setText("Tìm kiếm theo Loại Sách");

        cbTimKiemTheoLoaiSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbTimKiemTheoLoaiSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTimKiemTheoLoaiSachMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbTimKiemTheoLoaiSachMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbTimKiemTheoLoaiSachMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbTimKiemTheoLoaiSachMouseReleased(evt);
            }
        });
        cbTimKiemTheoLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTimKiemTheoLoaiSachActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tbSach);

        btnQuayLai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        btTimKiemTheoTen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btTimKiemTheoTen.setText("Tìm kiếm theo tên");
        btTimKiemTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemTheoTenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnQuayLai)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTimKiemTheoLoaiSach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(txtTimKiemTheoTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btTimKiemTheoTen)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiemTheoTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimKiemTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTimKiemTheoLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuayLai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    String driver = "com.microsoft.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://DESKTOP-DRIHG7H\\SQLEXPRESS:1433;DatabaseName=QLTV; "
            + "user=sa; password=SA ;encrypt=true;trustServerCertificate=true;";
    Statement st;
    ResultSet rs;
    
    public void showData() {
        try {
            String[] columnNames = {"Mã sách", "Tên sách", "Tên tác giả", "Tên Nhà Xuất Bản", "Năm Xuất Bản", "Số trang", "Số lượng sách", "Loại sách"};
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);

            tbSach.setModel(model);

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
    
    
    private void loadDataToComboBox() {
        try {
            Connection con = DriverManager.getConnection(url);
            st = con.createStatement();
            String sql = "select LS.TenLoaiSach from LoaiSach LS";
            rs = st.executeQuery(sql);
            while (rs.next()){
                String s = rs.getString(1);
                cbTimKiemTheoLoaiSach.addItem(s);
            }
            con.close();
            
        } catch (Exception e) {
        }
        
    }
    
    
    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        frAdmin ad = new frAdmin();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void tbSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSachMouseClicked
        
    }//GEN-LAST:event_tbSachMouseClicked

    private void btTimKiemTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemTheoTenActionPerformed
        
        try {
            String[] columnNames = {"Mã sách", "Tên sách", "Tên tác giả", "Tên Nhà Xuất Bản", "Năm Xuất Bản", "Số trang", "Số lượng sách", "Loại sách"};
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);

            tbSach.setModel(model);

            String maSach = "";
            String tenSach = "";
            String tenDocGia = "";
            String tenNhaXuatBan = "";
            String namXuatBan = "";
            String soTrang = "";
            String soLuongSach = "";
            String maLoaiSach = "";

            rs = getData("select * from Sach S, LoaiSach LS where s.MaLoaiSach = LS.MaLoaiSach AND s.TenSach like '%"+txtTimKiemTheoTenSach.getText()+"%'");
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
        
    }//GEN-LAST:event_btTimKiemTheoTenActionPerformed

    private void cbTimKiemTheoLoaiSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTimKiemTheoLoaiSachMouseClicked
        
    }//GEN-LAST:event_cbTimKiemTheoLoaiSachMouseClicked

    private void cbTimKiemTheoLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTimKiemTheoLoaiSachActionPerformed
        
    }//GEN-LAST:event_cbTimKiemTheoLoaiSachActionPerformed

    private void cbTimKiemTheoLoaiSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTimKiemTheoLoaiSachMousePressed
        
    }//GEN-LAST:event_cbTimKiemTheoLoaiSachMousePressed

    private void cbTimKiemTheoLoaiSachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTimKiemTheoLoaiSachMouseExited
        try {
            String[] columnNames = {"Mã sách", "Tên sách", "Tên tác giả", "Tên Nhà Xuất Bản", "Năm Xuất Bản", "Số trang", "Số lượng sách", "Loại sách"};
            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(columnNames);

            tbSach.setModel(model);

            String maSach = "";
            String tenSach = "";
            String tenDocGia = "";
            String tenNhaXuatBan = "";
            String namXuatBan = "";
            String soTrang = "";
            String soLuongSach = "";
            String maLoaiSach = "";

            rs = getData("select * from Sach S, LoaiSach LS where s.MaLoaiSach = LS.MaLoaiSach AND LS.TenLoaiSach = N'"+cbTimKiemTheoLoaiSach.getSelectedItem()+"'");
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
    }//GEN-LAST:event_cbTimKiemTheoLoaiSachMouseExited

    private void cbTimKiemTheoLoaiSachMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTimKiemTheoLoaiSachMouseReleased
        
    }//GEN-LAST:event_cbTimKiemTheoLoaiSachMouseReleased

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
            java.util.logging.Logger.getLogger(frTimKiemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frTimKiemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frTimKiemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frTimKiemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frTimKiemSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btTimKiemTheoTen;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JComboBox<String> cbTimKiemTheoLoaiSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSach;
    private javax.swing.JTextField txtTimKiemTheoTenSach;
    // End of variables declaration//GEN-END:variables

    
}
