/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Luthfi
 */
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class main extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    public main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        managePanel = new javax.swing.JPanel();
        manageBtn = new javax.swing.JButton();
        memberBtn = new javax.swing.JButton();
        ManageBukuPNG = new javax.swing.JLabel();
        DataPeminjamPNG = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pinjamBtn = new javax.swing.JButton();
        kembaliBtn = new javax.swing.JButton();
        PeminjamanPNG = new javax.swing.JLabel();
        PengembalianPNG = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        laporanBtn = new javax.swing.JButton();
        settingBtn = new javax.swing.JButton();
        LaporanPNG = new javax.swing.JLabel();
        SettingPNG = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        bgrnd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library App");
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        managePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        managePanel.setOpaque(false);

        manageBtn.setText("Manage Buku");

        memberBtn.setText("Data Peminjam");

        ManageBukuPNG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/books.png"))); // NOI18N

        DataPeminjamPNG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/learning.png"))); // NOI18N

        javax.swing.GroupLayout managePanelLayout = new javax.swing.GroupLayout(managePanel);
        managePanel.setLayout(managePanelLayout);
        managePanelLayout.setHorizontalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePanelLayout.createSequentialGroup()
                .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managePanelLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(managePanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(DataPeminjamPNG))
                    .addGroup(managePanelLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(ManageBukuPNG)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        managePanelLayout.setVerticalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(ManageBukuPNG)
                .addGap(18, 18, 18)
                .addComponent(manageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(DataPeminjamPNG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(memberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        getContentPane().add(managePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setOpaque(false);

        pinjamBtn.setText("Peminjaman");

        kembaliBtn.setText("Pengembalian");

        PeminjamanPNG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reading.png"))); // NOI18N

        PengembalianPNG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hand-holding-up-a-book.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(PeminjamanPNG)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kembaliBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinjamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(PengembalianPNG)
                        .addGap(139, 139, 139))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(PeminjamanPNG)
                .addGap(18, 18, 18)
                .addComponent(pinjamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(PengembalianPNG)
                .addGap(57, 57, 57)
                .addComponent(kembaliBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 101, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setOpaque(false);

        laporanBtn.setText("Laporan");

        settingBtn.setText("Setting");

        LaporanPNG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/test.png"))); // NOI18N

        SettingPNG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/two-big-gears.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(settingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laporanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(LaporanPNG)))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(SettingPNG)
                        .addGap(124, 124, 124))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LaporanPNG)
                .addGap(18, 18, 18)
                .addComponent(laporanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(SettingPNG)
                .addGap(47, 47, 47)
                .addComponent(settingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(846, 101, -1, -1));

        logoutBtn.setText("Logout");
        getContentPane().add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1131, 28, 115, 35));

        bgrnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/TestHD_2.jpg"))); // NOI18N
        getContentPane().add(bgrnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public JButton getlogoutBtn(){
        return logoutBtn;
    }
    public JButton getmanageBtn(){
        return manageBtn;
    }
    public JButton getmemberBtn(){
        return memberBtn;
    }
    public JButton getpinjamBtn(){
        return pinjamBtn;
    }
    public JButton getkembaliBtn(){
        return kembaliBtn;
    }
    public JButton getlaporanBtn(){
        return laporanBtn;
    }
    public JButton getsettingBtn(){
        return settingBtn;
    }
    public void addActionListener(ActionListener ae){
        logoutBtn.addActionListener(ae);
        manageBtn.addActionListener(ae);
        memberBtn.addActionListener(ae);
        pinjamBtn.addActionListener(ae);
        kembaliBtn.addActionListener(ae);
        laporanBtn.addActionListener(ae);
        settingBtn.addActionListener(ae);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataPeminjamPNG;
    private javax.swing.JLabel LaporanPNG;
    private javax.swing.JLabel ManageBukuPNG;
    private javax.swing.JLabel PeminjamanPNG;
    private javax.swing.JLabel PengembalianPNG;
    private javax.swing.JLabel SettingPNG;
    private javax.swing.JLabel bgrnd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton kembaliBtn;
    private javax.swing.JButton laporanBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton manageBtn;
    private javax.swing.JPanel managePanel;
    private javax.swing.JButton memberBtn;
    private javax.swing.JButton pinjamBtn;
    private javax.swing.JButton settingBtn;
    // End of variables declaration//GEN-END:variables
}
