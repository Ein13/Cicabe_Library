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
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableModel;
public class pengembalian extends javax.swing.JFrame {

    /**
     * Creates new form pengembalianFrame
     */
    public pengembalian() {
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

        logoutPanel = new javax.swing.JPanel();
        logoutBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        pengembalianLabel = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        searchComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        peminjamanTable = new javax.swing.JTable();
        dataPanel = new javax.swing.JPanel();
        namaLabel = new javax.swing.JLabel();
        nomorindukLabel = new javax.swing.JLabel();
        tglpinjamLabel = new javax.swing.JLabel();
        tanggalbalikLabel = new javax.swing.JLabel();
        dendaLabel = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        indukField = new javax.swing.JTextField();
        dendaField = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idpinjamField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        searchTextArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        statusField = new javax.swing.JTextField();
        pinjamDateChooser = new com.toedter.calendar.JDateChooser();
        kembaliDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        idpengembalianField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bukuTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 0));

        logoutPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(1));

        logoutBtn.setText("Logout");

        backBtn.setText("Back");

        pengembalianLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pengembalianLabel.setText("PENGEMBALIAN");

        javax.swing.GroupLayout logoutPanelLayout = new javax.swing.GroupLayout(logoutPanel);
        logoutPanel.setLayout(logoutPanelLayout);
        logoutPanelLayout.setHorizontalGroup(
            logoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pengembalianLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(371, 371, 371)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        logoutPanelLayout.setVerticalGroup(
            logoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(logoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pengembalianLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        searchPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(1));

        searchBtn.setText("Search");

        searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nomor Induk", "Nama" }));

        peminjamanTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(peminjamanTable);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        dataPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(1));

        namaLabel.setText("Nama");

        nomorindukLabel.setText("Nomor Induk");

        tglpinjamLabel.setText("Tanggal Pinjam");

        tanggalbalikLabel.setText("Tanggal Pengembalian");

        dendaLabel.setText("Denda");

        submitBtn.setText("Submit");

        jLabel1.setText("ID Peminjaman");

        idpinjamField.setEditable(false);

        searchTextArea.setColumns(20);
        searchTextArea.setRows(5);
        jScrollPane3.setViewportView(searchTextArea);

        jLabel6.setText("Status");

        pinjamDateChooser.setDateFormatString("yyyy-MM-dd");

        kembaliDateChooser.setDateFormatString("yyyy-MM-dd");

        jLabel2.setText("ID Pengembalian");

        idpengembalianField.setEditable(false);

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitBtn))
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataPanelLayout.createSequentialGroup()
                                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tanggalbalikLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(tglpinjamLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(namaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nomorindukLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(kembaliDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                        .addComponent(pinjamDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(dataPanelLayout.createSequentialGroup()
                                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(indukField, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                            .addComponent(namaField)
                                            .addComponent(idpinjamField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))
                                .addGap(18, 18, 18))
                            .addGroup(dataPanelLayout.createSequentialGroup()
                                .addComponent(dendaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dendaField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(31, 31, 31)))
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idpengembalianField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idpinjamField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(idpengembalianField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomorindukLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(indukField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tglpinjamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinjamDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggalbalikLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kembaliDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dendaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dendaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submitBtn)))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(1));

        bukuTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(bukuTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Daftar Buku Peminjam");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void pengembalianTableClicked (java.awt.event.MouseEvent evt){
        int i = peminjamanTable.getSelectedRow();
        TableModel model = peminjamanTable.getModel();
        // Kalau fail, kemungkinan urutan table beda dengan database 
        idpinjamField.setText(model.getValueAt(i,0).toString());
        indukField.setText(model.getValueAt(i,1).toString());
        namaField.setText(model.getValueAt(i,2).toString());
        
        try {
            //jdateChooser Format belum fix
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse((String)model.getValueAt(i, 3).toString());
            pinjamDateChooser.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(editmember.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //jdateChooser Format belum fix
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse((String)model.getValueAt(i, 4).toString());
            kembaliDateChooser.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(editmember.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dendaField.setText(model.getValueAt(i,5).toString());
        statusField.setText(model.getValueAt(i,6).toString());
    }
    
    
    
    public JButton getlogoutBtn(){
        return logoutBtn;
    }
    public JButton getbackBtn(){
        return backBtn;
    }
    public JButton getsearchBtn(){
        return searchBtn;
    }
    public JButton getsubmitBtn(){
        return submitBtn;
    }

    public void addActionListener(ActionListener ae){
        logoutBtn.addActionListener(ae);
        backBtn.addActionListener(ae);
        searchBtn.addActionListener(ae);
        submitBtn.addActionListener(ae);
    }

    public JTextField getsearchField(){
       return searchField;
   }
    public JTextField getidpinjamField(){
        return idpinjamField;
    }
    public JTextField getindukField(){
        return indukField;
    }
    public JTextField getnamaField(){
        return namaField;
    }
    public JDateChooser getpinjamDateChooserField(){
        return pinjamDateChooser;
    }
    public JDateChooser getkembaliDateChooserField(){
        return kembaliDateChooser;
    }
    public JTextField getdendaField(){
        return dendaField;
    }
    public JTextField getstatusField(){
        return statusField;
    }
    public JTextField getidpengembalianField(){
        return idpengembalianField;
    }
    public JTable getpeminjamanTable(){
        return peminjamanTable;
    }
    public JComboBox getCategory(){
        return searchComboBox;
    }
    public JTable getbukuTable(){
        return bukuTable;
    }
    
    public void setTable(TableModel model){
        this.peminjamanTable.setModel(model);
        this.bukuTable.setModel(model);
    }
    
    public void addMouseAdapter(MouseAdapter ma){
        peminjamanTable.addMouseListener(ma);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable bukuTable;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JTextField dendaField;
    private javax.swing.JLabel dendaLabel;
    private javax.swing.JTextField idpengembalianField;
    private javax.swing.JTextField idpinjamField;
    private javax.swing.JTextField indukField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser kembaliDateChooser;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JTextField namaField;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JLabel nomorindukLabel;
    private javax.swing.JTable peminjamanTable;
    private javax.swing.JLabel pengembalianLabel;
    private com.toedter.calendar.JDateChooser pinjamDateChooser;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox<String> searchComboBox;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextArea searchTextArea;
    private javax.swing.JTextField statusField;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel tanggalbalikLabel;
    private javax.swing.JLabel tglpinjamLabel;
    // End of variables declaration//GEN-END:variables
}
