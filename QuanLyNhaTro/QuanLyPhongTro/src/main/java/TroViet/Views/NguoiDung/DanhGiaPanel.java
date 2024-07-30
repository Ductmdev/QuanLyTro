/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TroViet.Views.NguoiDung;

import static TroViet.Connect.SQL_Connection.con;
import TroViet.DAO.DanhGiaDAO;
import TroViet.DAO.SessionDAO;
import TroViet.Model.DanhGia;
import TroViet.Model.SessionEntity;
import TroViet.Model.UserEntity;
import TroViet.Utils.SessionManager;
import static TroViet.Utils.SessionManager.setSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS
 */
public class DanhGiaPanel extends javax.swing.JPanel {

    /**
     * Creates new form DanhGiaPanel
     */
    
    DefaultTableModel tblModel;
    DanhGiaDAO dgDAO = new DanhGiaDAO();
    DanhGia dg = new DanhGia();
    UserEntity user = SessionManager.getSession().getUser();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = currentDateTime.format(formatterTime);
    UserEntity userSS = SessionManager.getSession().getUser();
    static SessionDAO sessionDao = new SessionDAO();
    
    public DanhGiaPanel() throws SQLException {
        initComponents();
        initTable();
        fillToDanhGia();
        now();
        
    }
    
    public void initTable() {
        tblModel = (DefaultTableModel) tblDanhGia.getModel();
        String[] columns = {"ID", "ID phòng trọ", "ID người thuê", "Đánh giá (Sao)", "Nội dung", "Người ĐG"};
        tblModel.setColumnIdentifiers(columns);
    }
    
    public void fillToDanhGia() throws SQLException {
        tblModel.setRowCount(0); 
        for (DanhGia dg : dgDAO.getAll()) {
            Vector<Object> vec = new Vector<>();
            vec.add(dg.getId());
            vec.add(dg.getIdPhongTro());
            vec.add(dg.getIdNguoiDung());
            vec.add(dg.getDanhGia()+"");
            vec.add(dg.getNoiDung());
            vec.add(dg.getNguoiTao());
            tblModel.addRow(vec);
        }
    }
    
    public void now() throws SQLException {
        String query = "select IdMaPhongTro, IdNguoiDung from HopDong where IdNguoiDung=?;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, user.getId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            txtMPT.setText(rs.getString(1));
            txtMaNguoiDung.setText(rs.getString(2));
        }
    }
    
    public long getSelectedID() {
        long selectedRow = tblDanhGia.getSelectedRow();
        if (selectedRow < 0) {
            return -1;
        }
        long id = (long) tblDanhGia.getValueAt((int) selectedRow, 0);
        return id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMPT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaNguoiDung = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbSaoDanhGia = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhGia = new javax.swing.JTable();

        setBackground(new java.awt.Color(40, 46, 62));

        jPanel2.setBackground(new java.awt.Color(207, 243, 243));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 46, 62));
        jLabel1.setText("ĐÁNH GIÁ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 46, 62));
        jLabel2.setText("Mã phòng trọ:");

        txtMPT.setEditable(false);
        txtMPT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 46, 62));
        jLabel3.setText("Mã người dùng:");

        txtMaNguoiDung.setEditable(false);
        txtMaNguoiDung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(40, 46, 62));
        jLabel10.setText("Đánh giá:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(40, 46, 62));
        jLabel11.setText("Nội dung:");

        cbSaoDanhGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbSaoDanhGia.setForeground(new java.awt.Color(40, 46, 62));
        cbSaoDanhGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tùy chọn", "1 Sao", "2 Sao", "3 Sao", "4 Sao", "5 Sao" }));

        txtNoiDung.setColumns(20);
        txtNoiDung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNoiDung.setForeground(new java.awt.Color(40, 46, 62));
        txtNoiDung.setRows(5);
        txtNoiDung.setDisabledTextColor(new java.awt.Color(40, 46, 62));
        txtNoiDung.setSelectedTextColor(new java.awt.Color(40, 46, 62));
        txtNoiDung.setSelectionColor(new java.awt.Color(255, 205, 31));
        jScrollPane1.setViewportView(txtNoiDung);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMPT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbSaoDanhGia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(txtMaNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(252, 252, 252))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbSaoDanhGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtMaNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(46, 56, 86));

        btnSua.setBackground(new java.awt.Color(255, 205, 31));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua.setForeground(new java.awt.Color(40, 46, 62));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/paper-plane.png"))); // NOI18N
        btnSua.setText("Gửi");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 205, 31));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(40, 46, 62));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TroViet/Icon/return.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDanhGia.setBackground(new java.awt.Color(207, 243, 243));
        tblDanhGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDanhGia.setForeground(new java.awt.Color(40, 46, 62));
        tblDanhGia.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhGia.setGridColor(new java.awt.Color(255, 255, 255));
        tblDanhGia.setSelectionBackground(new java.awt.Color(46, 56, 86));
        tblDanhGia.setSelectionForeground(new java.awt.Color(255, 205, 31));
        tblDanhGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhGiaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhGia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (cbSaoDanhGia.getSelectedItem().equals("Tùy chọn")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn điểm sao cho phòng trọ!");
            return;
        }
        int ret = JOptionPane.showConfirmDialog(null, "Tạo đánh giá?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (ret == JOptionPane.NO_OPTION) {
            return;
        }
        DanhGia dgia = new DanhGia();
        dgia.setIdPhongTro(Long.parseLong(txtMPT.getText()));
        dgia.setIdNguoiDung(Long.parseLong(txtMaNguoiDung.getText()));
        dgia.setDanhGia(cbSaoDanhGia.getSelectedIndex());
        dgia.setNoiDung(txtNoiDung.getText());
        dgia.setNgayTao(formattedDateTime);
        dgia.setNguoiTao(user.getHoTen());
        try {
            dgDAO.add(dgia);
            JOptionPane.showMessageDialog(null, "Thêm đánh giá thành công");
            SessionEntity ss = new SessionEntity();
            ss.setUser(userSS);
            ss.setMessage("Đã gửi đánh giá phòng trọ");
            ss.setStartTime(new Timestamp(System.currentTimeMillis()));
            sessionDao.save(ss);
            SessionEntity sss = sessionDao.getLast(userSS.getId());
            setSession(sss);
        } catch (SQLException ex) {
            Logger.getLogger(DanhGiaPanel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Thêm đánh giá thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        try {
            now();
            cbSaoDanhGia.setSelectedIndex(0);
            txtNoiDung.setText("");
            cbSaoDanhGia.setEnabled(true);
            txtNoiDung.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(DanhGiaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblDanhGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhGiaMouseClicked
        // TODO add your handling code here:
        try {
            cbSaoDanhGia.setEnabled(false);
            txtNoiDung.setEnabled(false);
            long selectedId = getSelectedID();
            if (selectedId < 0) {
                JOptionPane.showMessageDialog(null, "Chọn hợp đồng cần edit");
            }
            DanhGia dgia = dgDAO.get(selectedId);
            if (dgia == null) {
                JOptionPane.showMessageDialog(null, "Hợp đồng bạn chọn không hợp lệ");
            }
            txtMPT.setText(dgia.getIdPhongTro()+"");
            txtMaNguoiDung.setText(dgia.getIdNguoiDung()+"");
            cbSaoDanhGia.setSelectedIndex(dgia.getDanhGia());
            txtNoiDung.setText(dgia.getNoiDung());
            
        } catch (SQLException ex) {
            Logger.getLogger(DanhGiaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDanhGiaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JComboBox<String> cbSaoDanhGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDanhGia;
    private javax.swing.JTextField txtMPT;
    private javax.swing.JTextField txtMaNguoiDung;
    private javax.swing.JTextArea txtNoiDung;
    // End of variables declaration//GEN-END:variables
}