/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.TableModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
//import java.util.Calendar;



/**
 *
 * @author Zara
 */
public class Handler extends MouseAdapter implements ActionListener {
    private login loginFrame;
    private main mainFrame;
    private peminjaman peminjamanFrame;
    private pengembalian pengembalianFrame;
    private editmember editmember;
    private managebuku managebukuFrame;
    private laporan laporanFrame;
    private setting settingFrame;
    private listmember listmemberFrame;
    
    private Controller con = new Controller();
    public Handler() {
        loginFrame = new login();
        mainFrame = new main();
        peminjamanFrame = new peminjaman();
        pengembalianFrame = new pengembalian();
        editmember = new editmember();
        managebukuFrame = new managebuku();
        settingFrame = new setting();
        laporanFrame = new laporan();
        listmemberFrame = new listmember();
            
        loginFrame.setVisible(true);
        mainFrame.setVisible(false);
        peminjamanFrame.setVisible(false);
        pengembalianFrame.setVisible(false);
        editmember.setVisible(false);
        managebukuFrame.setVisible(false);
        laporanFrame.setVisible(false);
        settingFrame.setVisible(false);
        listmemberFrame.setVisible(false);
        
        //mainFrame.getlaporanBtn().setEnabled(false);
          
        loginFrame.addActionListener(this);
        mainFrame.addActionListener(this);
        peminjamanFrame.addActionListener(this);
        pengembalianFrame.addActionListener(this);
        editmember.addActionListener(this);
        managebukuFrame.addActionListener(this);
        settingFrame.addActionListener(this);
        laporanFrame.addActionListener(this);
        listmemberFrame.addActionListener(this);
        pengembalianFrame.getpeminjamanTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String pattern = "dd-MM-yyyy";
                DateFormat df = new SimpleDateFormat(pattern);
                int row = pengembalianFrame.getpeminjamanTable().rowAtPoint(evt.getPoint());
                int col = pengembalianFrame.getpeminjamanTable().columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    int i = pengembalianFrame.getpeminjamanTable().getSelectedRow();
                    TableModel model = pengembalianFrame.getpeminjamanTable().getModel();
                    // Kalau fail, kemungkinan urutan table beda dengan database 
                    pengembalianFrame.getidpinjamField().setText(model.getValueAt(i,0).toString());
                    pengembalianFrame.getindukField().setText(model.getValueAt(i,1).toString());
                    Date dateNow = new java.util.Date();
                    pengembalianFrame.getkembaliDateChooserField().setDate(dateNow);
                    //namaField.setText(model.getValueAt(i,2).toString());
                    pengembalianFrame.setTableBuku(con.loadTablePeminjamanDet(model.getValueAt(i,0).toString()));
                    pengembalianFrame.getdendaField().setText("0");
                    if(pengembalianFrame.getbukuTable().getRowCount()==0){
                        pengembalianFrame.getsubmitBtn().setEnabled(false);
                    }
                    else{
                        pengembalianFrame.getsubmitBtn().setEnabled(true);
                    }

                    //test2, gk tau bisa atau enggak.
                    try {
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i, 2).toString());
                        pengembalianFrame.getpinjamDateChooserField().setDate(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(editmember.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        //jdateChooser
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i, 3).toString());
                        pengembalianFrame.getJanjiField().setText(df.format(date));
                        
                    } catch (ParseException ex) {
                        Logger.getLogger(editmember.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    ArrayList<Member> member = con.loadMember();
                    for(Member x : member){
                        if(x.getNIS().equals(model.getValueAt(i, 1))){
                            pengembalianFrame.getnamaField().setText(x.getNama());
                            break;
                        }
                    }
                    emptyKeranjangPengembalianTable();
                }
            }
        });
         
        laporanFrame.getLaporanTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableModel model = laporanFrame.getLaporanTable().getModel();
                 String id = model.getValueAt(laporanFrame.getLaporanTable().getSelectedRow(), 0).toString();
                if (laporanFrame.getlaporanComboBox().equals("Peminjaman")){
                    laporanFrame.setDetailTable(con.loadTablePeminjamanDet(id));
                }
                else{
                    laporanFrame.setDetailTable(con.loadTablePengembalianDet(id));
                }
            }
        });
                
        laporanFrame.getLaporanCombo().addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if (laporanFrame.getlaporanComboBox().equals("Peminjaman")){
                    laporanFrame.setLaporanTable(con.loadTablePeminjaman());
                }
                else{
                    laporanFrame.setLaporanTable(con.loadTablePengembalian());
                }
                DefaultTableModel model = (DefaultTableModel) laporanFrame.getDetailTable().getModel();
                if(model.getRowCount() > 0){
                    for (int i = 0; i <= model.getRowCount(); i++) {
                        model.removeRow(0);
                    }
                }
            }
        });
        loginFrame.getRootPane().setDefaultButton(loginFrame.getloginBtn());
        listmemberFrame.getRootPane().setDefaultButton(listmemberFrame.getsearchBtn());
        settingFrame.getRootPane().setDefaultButton(settingFrame.getupdateBtn());
        peminjamanFrame.getnomorindukField().setEditable(false);
        
        settingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        loginFrame.setLocationRelativeTo(null);
        mainFrame.setLocationRelativeTo(null);
        peminjamanFrame.setLocationRelativeTo(null);
        pengembalianFrame.setLocationRelativeTo(null);
        editmember.setLocationRelativeTo(null);
        managebukuFrame.setLocationRelativeTo(null);
        settingFrame.setLocationRelativeTo(null);
        laporanFrame.setLocationRelativeTo(null);
        listmemberFrame.setLocationRelativeTo(null);
        
        JFormattedTextField bukuSpinnerTF = ((JSpinner.DefaultEditor) managebukuFrame.getstokspinner().getEditor()).getTextField();
        bukuSpinnerTF.setEditable(false);
        JFormattedTextField memberSpinnerTF = ((JSpinner.DefaultEditor) editmember.getjumlahpinjam().getEditor()).getTextField();
        memberSpinnerTF.setEditable(false);
        JFormattedTextField pinjamSpinnerTF = ((JSpinner.DefaultEditor) peminjamanFrame.getjumlahSpinner().getEditor()).getTextField();
        pinjamSpinnerTF.setEditable(false);
        
        managebukuFrame.getstokspinner().addChangeListener(new SpinnerListener());
        editmember.getjumlahpinjam().addChangeListener(new SpinnerListener());
        peminjamanFrame.getjumlahSpinner().addChangeListener(new SpinnerListener());
        
        managebukuFrame.getidField().setPreferredSize(new Dimension(6, 20));
        managebukuFrame.getjudulField().setPreferredSize(new Dimension(6, 20));
        managebukuFrame.getpenerbitField().setPreferredSize(new Dimension(6, 20));
        managebukuFrame.getpenulisField().setPreferredSize(new Dimension(6, 20));
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Buku","Judul Buku","Jumlah Pinjam"},0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        pengembalianFrame.setTableBuku(model);

    }
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(loginFrame.getloginBtn())) {
            login(loginFrame.getusernameField().getText(), loginFrame.getpasswordField().getText());
            loginFrame.getpasswordField().setText("");
            //loginFrame.getusernameField().setText("");
        }
        
        if(source.equals(mainFrame.getlogoutBtn())) {
            logoutEvent();
        }
        else if(source.equals(mainFrame.getmanageBtn())) {
            managebukuFrame.setTable(con.loadTableBuku());
            incrementBuku();
            managebukuFrame.getupdateBtn().setVisible(false);
            managebukuFrame.getdeleteBtn().setVisible(false);
            managebukuFrame.setVisible(true);            
            mainFrame.setVisible(false);
        }
        else if(source.equals(mainFrame.getmemberBtn())) {
            editmember.getdeleteBtn().setVisible(false);
            editmember.getupdateBtn().setVisible(false);
            Date dateNow = new java.util.Date();
            editmember.gettglDateChooser().setDate(dateNow);
            editmember.setTable(con.loadTableMember());
            editmember.setVisible(true);
            mainFrame.setVisible(false);
        }
        else if(source.equals(mainFrame.getpinjamBtn())) {
            //peminjamanFrame.setTable(con.loadTablePeminjaman());
            //peminjamanFrame.setTable(con.loadTableBuku());
            incrementPeminjaman();
            Date dateNow = new java.util.Date();
            peminjamanFrame.getpinjamDateChooser().setDate(dateNow);
            peminjamanFrame.getkembaliDateChooser().setDate(dateNow);
            peminjamanFrame.setVisible(true);
            mainFrame.setVisible(false);
            peminjamanFrame.setTableBuku(con.loadTableBuku());
            peminjamanFrame.setTable(con.loadTablePeminjaman());
        }
        else if(source.equals(mainFrame.getkembaliBtn())) {
            //pengembalianFrame.setTable(con.loadTablePeminjaman());
            //pengembalianFrame.setTable(con.loadTableBuku());
            incrementPengembalian();
            Date dateNow = new java.util.Date();
            pengembalianFrame.getpinjamDateChooserField().setDate(dateNow);
            pengembalianFrame.getkembaliDateChooserField().setDate(dateNow);
            pengembalianFrame.setVisible(true);
            mainFrame.setVisible(false);
            pengembalianFrame.setTable(con.loadTablePeminjaman());
        }
        else if(source.equals(mainFrame.getlaporanBtn())){
            //laporanFrame.setTable(con.loadTableLaporan());
            laporanFrame.setLaporanTable(con.loadTablePeminjaman());
            laporanFrame.setVisible(true);
            mainFrame.setVisible(false);
        }
        else if(source.equals(mainFrame.getsettingBtn())){
            //mainFrame.setVisible(false);
            settingFrame.setVisible(true);
        }
             
        if(source.equals(managebukuFrame.getlogoutBtn())) {
            resetUiBuku();
            logoutEvent();
        }
        else if(source.equals(managebukuFrame.getbackBtn())) {
            resetUiBuku();
            mainFrame.setVisible(true);
            managebukuFrame.setVisible(false);
        }
        else if(source.equals(managebukuFrame.getsearchBtn())) {
            String category = (String) managebukuFrame.getsearchCombo().getSelectedItem();
            managebukuFrame.setTable(con.searchBuku(category, managebukuFrame.getsearchField().getText()));
        }
        else if(source.equals(managebukuFrame.getdeleteBtn())) {
            if(con.deleteBuku(managebukuFrame.getidField().getText())){
                JOptionPane.showMessageDialog(managebukuFrame, "Berhasil menghapus buku dengan Id " + managebukuFrame.getidField().getText(), "Hapus Buku", JOptionPane.INFORMATION_MESSAGE);
                resetUiBuku();
                
            }
            else{
                JOptionPane.showMessageDialog(managebukuFrame, "Gagal hapus buku", "Hapus Buku", JOptionPane.ERROR_MESSAGE);
            }
            managebukuFrame.setTable(con.loadTableBuku());
        
            }
        else if(source.equals(managebukuFrame.getaddBtn())) {
            addBuku();
        }
        else if(source.equals(managebukuFrame.getupdateBtn())) {
            updateBuku();
            resetUiBuku();
        }
        else if(source.equals(managebukuFrame.getresetBtn())) {
            resetUiBuku();
            managebukuFrame.setTable(con.loadTableBuku());
        }
         
        if(source.equals(editmember.getlogoutBtn())) {
            resetUiMember();
            logoutEvent();
        }
        else if(source.equals(editmember.getbackBtn())) {
            resetUiMember();
            editmember.setVisible(false);
            mainFrame.setVisible(true);
        }
        else if(source.equals(editmember.getsearchBtn())) {
            String category = (String) editmember.getsearchCombo().getSelectedItem();
            editmember.setTable(con.searchMember(category, editmember.getsearchField().getText()));
        }
        else if(source.equals(editmember.getdeleteBtn())) {
            if(editmember.getnomorindukField().getText().isEmpty()){
                JOptionPane.showMessageDialog(editmember, "Pilih data pada tabel terlebih dahulu", "Hapus Member", JOptionPane.ERROR_MESSAGE);                        
            }
            else{
                if(con.deleteMember(editmember.getnomorindukField().getText())){
                    JOptionPane.showMessageDialog(editmember, "Berhasil menghapus member dengan NIS " + editmember.getnomorindukField().getText(), "Hapus Member", JOptionPane.INFORMATION_MESSAGE);
                    resetUiMember();
                }
                else{
                    JOptionPane.showMessageDialog(editmember, "Gagal hapus member", "Hapus Member", JOptionPane.ERROR_MESSAGE);
                }
                editmember.setTable(con.loadTableMember());
            }
        }
        else if(source.equals(editmember.getaddBtn())) {
            addMember();
        }
        else if(source.equals(editmember.getupdateBtn())) {
            updateMember();
            resetUiMember();
        }
        else if(source.equals(editmember.getresetBtn())) {
            resetUiMember();
            editmember.setTable(con.loadTableMember());
        }
          
        if(source.equals(peminjamanFrame.getlogoutBtn())) {
            peminjamanFrame.getidpinjamField().setText("");
            peminjamanFrame.getnomorindukField().setText("");
            Date dateNow = new java.util.Date();
            peminjamanFrame.getpinjamDateChooser().setDate(dateNow);
            peminjamanFrame.getkembaliDateChooser().setDate(dateNow);
            peminjamanFrame.getsearchField().setText("");
            peminjamanFrame.getjudulField().setText("");
            logoutEvent();
        }
        else if(source.equals(peminjamanFrame.getbackBtn())) {
            if(peminjamanFrame.getkeranjangTable().getRowCount() == 0){
                peminjamanFrame.getidpinjamField().setText("");
                peminjamanFrame.getnomorindukField().setText("");
                Date dateNow = new java.util.Date();
                peminjamanFrame.getpinjamDateChooser().setDate(dateNow);
                peminjamanFrame.getkembaliDateChooser().setDate(dateNow);
                peminjamanFrame.getsearchField().setText("");
                peminjamanFrame.getjudulField().setText("");
                peminjamanFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(peminjamanFrame, "Hapus isi table keranjang terlebih dahulu!", "Peminjaman", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(source.equals(peminjamanFrame.getaddBtn())) {
            String idBuku = peminjamanFrame.getidBukuField().getText();
            int jml = (int) peminjamanFrame.getjumlahSpinner().getValue();
            boolean ada = false;
            int rowada = 0;
            if(con.cekStok(idBuku, jml)){
                if(jml>0){
                    DefaultTableModel model = (DefaultTableModel)peminjamanFrame.getkeranjangTable().getModel();
                    for (int i = 0; i<model.getRowCount(); i++){
                        if (idBuku.equals(model.getValueAt(i, 0).toString())){
                            ada = true;
                            rowada = i;
                        }
                    }
                    if (!ada){
                        model.addRow(new Object[]{idBuku, peminjamanFrame.getjudulField().getText(), jml});
                    }
                    else{
                        int currentjml = Integer.parseInt(model.getValueAt(rowada, 2).toString());
                        model.setValueAt(currentjml+jml, rowada, 2);
                    }
                    con.kurangiStokBuku(idBuku, jml);
                    peminjamanFrame.setTableBuku(con.loadTableBuku());

                    peminjamanFrame.getjudulField().setText("");
                    peminjamanFrame.getidBukuField().setText("");
                    peminjamanFrame.getjumlahSpinner().setValue(0);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Jumlah pinjam harus lebih dari 0", "Peminjaman", JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Stok buku tidak cukup", "Peminjaman", JOptionPane.WARNING_MESSAGE);
                
                peminjamanFrame.getjumlahSpinner().setValue(0);
                peminjamanFrame.getjumlahSpinner().requestFocus();
            }
        }
            else if(source.equals(peminjamanFrame.getsearchBtn())){
                String category = (String) peminjamanFrame.getsearchComboBox().getSelectedItem();
                peminjamanFrame.setTableBuku(con.searchBuku(category, peminjamanFrame.getsearchField().getText()));
            }
            
            else if(source.equals(peminjamanFrame.getsubmitBtn())) {
                int totalPinjam = 0;
                for (int i = 0; i < peminjamanFrame.getkeranjangTable().getRowCount(); i++){
                    totalPinjam = totalPinjam + Integer.parseInt(peminjamanFrame.getkeranjangTable().getValueAt(i, 2).toString());
                }
                 
                if (totalPinjam>0 && !peminjamanFrame.getnomorindukField().getText().isEmpty()){
                    Peminjaman p = new Peminjaman(peminjamanFrame.getidpinjamField().getText(), peminjamanFrame.getnomorindukField().getText(), 
                        peminjamanFrame.getpinjamDateChooser().getDate(), peminjamanFrame.getkembaliDateChooser().getDate(), totalPinjam);

                    if(con.addPeminjaman(p) && con.tambahiJumlahPinjamMember(p.getNis(), p.getTotal_pinjam())){
                        peminjamanFrame.setTable(con.loadTablePeminjaman());

                        DefaultTableModel model = (DefaultTableModel) peminjamanFrame.getkeranjangTable().getModel();
                        /*for (int i = 0; i < peminjamanFrame.getkeranjangTable().getRowCount(); i++){
                            Peminjaman_det pdet = new Peminjaman_det(peminjamanFrame.getidpinjamField().getText(), model.getValueAt(i, 0).toString(), 
                                    Integer.parseInt(model.getValueAt(i, 2).toString()));
                            if(con.addPeminjamanDet(pdet)){
                                model.removeRow(i);         
                            }
                            else{
                                JOptionPane.showMessageDialog(peminjamanFrame, "Error peminjaman detail", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                            System.out.println("a");
                        }*/
                        int rowcount = peminjamanFrame.getkeranjangTable().getRowCount();
                        for (int i = 0; i < rowcount; i++){
                            Peminjaman_det pdet = new Peminjaman_det(peminjamanFrame.getidpinjamField().getText(), model.getValueAt(0, 0).toString(), 
                                        Integer.parseInt(model.getValueAt(0, 2).toString()));
                            if(con.addPeminjamanDet(pdet)){
                                model.removeRow(0);
                            }
                        }
                        peminjamanFrame.getnomorindukField().setText("");
                        int currentID = Integer.parseInt(peminjamanFrame.getidpinjamField().getText()) + 1;
                        incrementPeminjaman();
                        JOptionPane.showMessageDialog(peminjamanFrame, "Berhasil input data peminjaman", "Peminjaman", JOptionPane.INFORMATION_MESSAGE);
                    }

                    else{
                        JOptionPane.showMessageDialog(null, "Gagal Insert Peminjaman", "Peminjaman", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    if(peminjamanFrame.getnomorindukField().getText().isEmpty()){
                        JOptionPane.showMessageDialog(peminjamanFrame, "Member belum dipilih", "Peminjaman", JOptionPane.ERROR_MESSAGE);               
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(peminjamanFrame, "Belum ada buku yang dipilih", "Peminjaman", JOptionPane.ERROR_MESSAGE);    
                    
                    }
                }
            }
            
            else if(source.equals(peminjamanFrame.getdeleteBtn())){
                DefaultTableModel model = (DefaultTableModel) peminjamanFrame.getkeranjangTable().getModel();
                
                if (model.getRowCount() > 0){
                    int baris = peminjamanFrame.getkeranjangTable().getSelectedRow();
                    if (baris >= 0){
                        String idBuku = model.getValueAt(baris, 0).toString();
                        int jml = Integer.parseInt(model.getValueAt(baris, 2).toString());
                        con.tambahiStokBuku(idBuku, jml);
                        peminjamanFrame.setTableBuku(con.loadTableBuku());
                        model.removeRow(baris);
                    }
                    else{
                        JOptionPane.showMessageDialog(peminjamanFrame, "Pilih buku yang mau dihapus dari Table Keranjang di kiri", "Peminjaman", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(peminjamanFrame, "Table Keranjang sudah kosong", "Peminjaman", JOptionPane.INFORMATION_MESSAGE);
                }
                //int[] rows = peminjamanFrame.getkeranjangTable().getSelectedRows();
                //for(int i=0;i<rows.length;i++){
                //    model.removeRow(rows[i]-i);
                //}
            }
            else if(source.equals(peminjamanFrame.getlistmemberBtn())){
                listmemberFrame.setTable(con.loadTableMember());
                listmemberFrame.setVisible(true);
                
            }
            
            if(source.equals(pengembalianFrame.getlogoutBtn())) {
                pengembalianFrame.getidpinjamField().setText("");
                pengembalianFrame.getidpengembalianField().setText("");
                pengembalianFrame.getindukField().setText("");
                pengembalianFrame.getnamaField().setText("");
                Date dateNow = new java.util.Date();
                pengembalianFrame.getpinjamDateChooserField().setDate(dateNow);
                pengembalianFrame.getkembaliDateChooserField().setDate(dateNow);
                pengembalianFrame.getdendaField().setText("");
                pengembalianFrame.getstatusField().setText("");
                logoutEvent();
            }
            else if(source.equals(pengembalianFrame.getbackBtn())) {
                this.emptyKeranjangPengembalianTable();
                this.emptyPeminjamanDetTable();
                pengembalianFrame.getidpinjamField().setText("");
                pengembalianFrame.getidpengembalianField().setText("");
                pengembalianFrame.getindukField().setText("");
                pengembalianFrame.getnamaField().setText("");
                Date dateNow = new java.util.Date();
                pengembalianFrame.getpinjamDateChooserField().setDate(dateNow);
                pengembalianFrame.getkembaliDateChooserField().setDate(dateNow);
                pengembalianFrame.getdendaField().setText("");
                pengembalianFrame.getstatusField().setText("");
                pengembalianFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            
            else if(source.equals(pengembalianFrame.getsearchBtn())) {
                String category = (String) pengembalianFrame.getCategory().getSelectedItem();
                String keyword = pengembalianFrame.getsearchField().getText().toString();
                
                pengembalianFrame.setTable(con.searchPeminjaman(category, keyword));
            }
            
            else if(source.equals(pengembalianFrame.getdelBtn())){
                DefaultTableModel model = (DefaultTableModel) pengembalianFrame.getkeranjangTable().getModel();
                DefaultTableModel model2 = (DefaultTableModel) pengembalianFrame.getbukuTable().getModel();
                TableModel model3 = pengembalianFrame.getpeminjamanTable().getModel();
                boolean ada = false;
                int temp = 0;
                int temp2 = 0;
                
                
                int baris = pengembalianFrame.getkeranjangTable().getSelectedRow();
                String idBuku = model.getValueAt(baris, 0).toString();
                String judulBuku = model.getValueAt(baris, 1).toString();
                int jmlPinjam = Integer.parseInt(model.getValueAt(baris, 2).toString());
                
                for(int row = 0;row<model2.getRowCount();row++){
                    if(idBuku.equals(model2.getValueAt(row, 0))){
                        ada = true;
                        temp = row;
                        break;
                    }
                }
                
                if(ada){
                    model2.setValueAt(jmlPinjam+Integer.parseInt(model2.getValueAt(temp, 2).toString()), temp, 2);
                    model.removeRow(baris);
                    
                }else{
                    model.removeRow(baris);
                    model2.addRow(new Object[]{idBuku,judulBuku,jmlPinjam});
                }
                Date dateNow = new java.util.Date();
                try {
                    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse((String)model3.getValueAt(baris, 3).toString());
                    long difference = (pengembalianFrame.getkembaliDateChooserField().getDate().getTime()-date1.getTime())/86400000;
                    temp2 = this.totalBuku(model);
                    System.out.println(difference);
                    temp2 = temp2 * Math.toIntExact(difference)*500;
                    if(difference>0){
                        pengembalianFrame.getdendaField().setText(Integer.toString(temp2));
                    }else{
                        pengembalianFrame.getdendaField().setText("0");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println(temp2);
                
                
            }
            else if(source.equals(pengembalianFrame.getpilihBtn())){
                int i = pengembalianFrame.getbukuTable().getSelectedRow();
                DefaultTableModel model1 = (DefaultTableModel) pengembalianFrame.getkeranjangTable().getModel();
                TableModel model2 = pengembalianFrame.getbukuTable().getModel();
                DefaultTableModel model3 = (DefaultTableModel) pengembalianFrame.getbukuTable().getModel();
                TableModel model4 = pengembalianFrame.getkeranjangTable().getModel();
                TableModel model5 = pengembalianFrame.getpeminjamanTable().getModel();
                
                
                String idBuku = model2.getValueAt(i, 0).toString();
                String Judul = model2.getValueAt(i, 1).toString();
                String jml = model2.getValueAt(i, 2).toString();
                int jumlah =  Integer.parseInt(jml);
                
                if((Integer)pengembalianFrame.getbukuSpinner().getValue()<jumlah){
                    if((Integer)pengembalianFrame.getbukuSpinner().getValue()>0){
                        boolean ada = false;
                        int temp = 0;
                        for(int row = 0;row<model4.getRowCount();row++){
                            if(idBuku.equals(model4.getValueAt(row, 0))){
                                ada = true;
                                temp = row;
                                break;
                            }
                        }
                        
                        if(ada){
                            String jmlkeranjang = model4.getValueAt(temp, 2).toString();
                            int jmlah = Integer.parseInt(jmlkeranjang);
                            jmlah = jmlah + (Integer)pengembalianFrame.getbukuSpinner().getValue();
                            model4.setValueAt(jmlah, temp, 2);
                            jumlah = jumlah-(Integer)pengembalianFrame.getbukuSpinner().getValue();
                            model3.setValueAt(jumlah, i, 2);
                            //System.out.println("echo");
                        }else{
                            jumlah = jumlah-(Integer)pengembalianFrame.getbukuSpinner().getValue();
                            model1.addRow(new Object[]{idBuku,Judul,(Integer)pengembalianFrame.getbukuSpinner().getValue()});
                            model3.setValueAt(jumlah, i, 2);
                            //System.out.println("echo");
                        }
                        
                        Date dateNow = new java.util.Date();
                        try {
                            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse((String)model5.getValueAt(i, 3).toString());
                            long difference = (pengembalianFrame.getkembaliDateChooserField().getDate().getTime()-date1.getTime())/86400000;
                            int temp2 = this.totalBuku(model4);
                            System.out.println(difference);
                            temp2 = temp2 * Math.toIntExact(difference)*500;
                            if(difference>0){
                                pengembalianFrame.getdendaField().setText(Integer.toString(temp2));
                            }else{
                                pengembalianFrame.getdendaField().setText("0");
                            }
                        } catch (ParseException ex) {
                            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(peminjamanFrame, "Jumlah salah", "Pengembalian", JOptionPane.ERROR_MESSAGE);
                    }
                }else if((Integer)pengembalianFrame.getbukuSpinner().getValue()==jumlah){
                    
                    boolean ada = false;
                    int temp = 0;
                    if(model4.getRowCount()!=0){
                        for(int row = 0;row<model4.getRowCount();row++){
                            if(idBuku.equals(model4.getValueAt(row, 0))){
                                ada = true;
                                temp = row;
                                break;
                            }
                        }
                        if(ada){
                            String jmlkeranjang = model4.getValueAt(temp, 2).toString();
                            int jmlah = Integer.parseInt(jmlkeranjang);
                            jmlah = jmlah + (Integer)pengembalianFrame.getbukuSpinner().getValue();
                            model4.setValueAt(jmlah, temp, 2);
                            model3.removeRow(i);
                        
                        }else{
                            model1.addRow(new Object[]{idBuku,Judul,jml});
                            model3.removeRow(i);   
                        }
                    }else{
                        model1.addRow(new Object[]{idBuku,Judul,jml});
                        model3.removeRow(i);
                    }
                    
                    Date dateNow = new java.util.Date();
                    try {
                        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse((String)model5.getValueAt(i, 3).toString());
                        long difference = (pengembalianFrame.getkembaliDateChooserField().getDate().getTime()-date1.getTime())/86400000;
                        System.out.println(difference);
                        int temp2 = this.totalBuku(model4);
                        temp2 = temp2 * Math.toIntExact(difference)*500;
                        if(difference>0){
                            pengembalianFrame.getdendaField().setText(Integer.toString(temp2));
                        }else{
                            pengembalianFrame.getdendaField().setText("0");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(peminjamanFrame, "Jumlah salah", "Pengembalian", JOptionPane.ERROR_MESSAGE);
                }
                
                
                pengembalianFrame.getjudulField().setText("");
                pengembalianFrame.getbukuSpinner().setValue(0);
                
            }
            else if(source.equals(pengembalianFrame.getsubmitBtn())) {
                
                TableModel model = pengembalianFrame.getkeranjangTable().getModel();
                int totalKembali = totalBuku(model);
                
                
                 
                if (!pengembalianFrame.getidpengembalianField().getText().isEmpty() && !pengembalianFrame.getindukField().getText().isEmpty()){
                    Pengembalian p = new Pengembalian(pengembalianFrame.getidpengembalianField().getText(), pengembalianFrame.getidpinjamField().getText(), 
                        pengembalianFrame.getkembaliDateChooserField().getDate(), Integer.parseInt(pengembalianFrame.getdendaField().getText()), totalKembali);

                    if(con.addPengembalian(p)){
                        
                        
                        DefaultTableModel modelKeranjang = (DefaultTableModel) pengembalianFrame.getkeranjangTable().getModel();
                        
                        int rowcount = pengembalianFrame.getkeranjangTable().getRowCount();
                        for (int i = 0; i < rowcount; i++){
                            Pengembalian_det pdet = new Pengembalian_det(pengembalianFrame.getidpengembalianField().getText(), model.getValueAt(0, 0).toString(), 
                                        Integer.parseInt(model.getValueAt(0, 2).toString()));
                            if(con.addPengembalianDet(pdet)){
                                if(con.delPeminjamanDet(model.getValueAt(0, 0).toString(), pengembalianFrame.getidpinjamField().getText())){
                                    modelKeranjang.removeRow(0);
                                }
                            } else {
                            }
                        }
                        JOptionPane.showMessageDialog(peminjamanFrame, "Berhasil input data pengembalian", "Pengembalian", JOptionPane.INFORMATION_MESSAGE);
                        pengembalianFrame.getindukField().setText("");
                        pengembalianFrame.getnamaField().setText("");
                        pengembalianFrame.getdendaField().setText("0");
                        Date dateNow = new java.util.Date();
                        pengembalianFrame.getkembaliDateChooserField().setDate(dateNow);
                        pengembalianFrame.getpinjamDateChooserField().setDate(dateNow);
                        incrementPengembalian();
                        
                        
                    }

                    else{
                        JOptionPane.showMessageDialog(null, "Gagal Insert Pengembalian", "Pengembalian", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    if(pengembalianFrame.getindukField().getText().isEmpty()){
                        JOptionPane.showMessageDialog(pengembalianFrame, "Peminjam belum dipilih", "Pengembalian", JOptionPane.ERROR_MESSAGE);               
                        
                    }
                    else if (model.getRowCount()==0){
                        JOptionPane.showMessageDialog(pengembalianFrame, "Belum ada buku yang dipilih", "Pengembalian", JOptionPane.ERROR_MESSAGE);    
                    
                    }
                }
            }
            
            if(source.equals(laporanFrame.getbackBtn())){
                laporanFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            else if(source.equals(laporanFrame.getlogoutBtn())){
                logoutEvent();
            }
            else if(source.equals(laporanFrame.getsearchBtn())){
                if (laporanFrame.getlaporanComboBox().equals("Peminjaman")){
                    int bulan = laporanFrame.getBulanComboBox().getSelectedIndex() + 1;
                    String tahun = laporanFrame.getTahunComboBox().getSelectedItem().toString();
                    laporanFrame.setLaporanTable(con.searchTglPeminjaman(bulan, tahun));
                }
                else if (laporanFrame.getlaporanComboBox().equals("Pengembalian")){
                    int bulan = laporanFrame.getBulanComboBox().getSelectedIndex() + 1;
                    String tahun = laporanFrame.getTahunComboBox().getSelectedItem().toString();
                    laporanFrame.setLaporanTable(con.searchTglPengembalian(bulan, tahun));
                }
                DefaultTableModel model = (DefaultTableModel) laporanFrame.getDetailTable().getModel();
                if(model.getRowCount() > 0){
                    for (int i = 0; i <= model.getRowCount(); i++) {
                        model.removeRow(0);
                    }
                }
            }
            
            if (source.equals(settingFrame.getupdateBtn())){
                Petugas p = new Petugas(settingFrame.getIdField().getText(),settingFrame.getusernameField().getText(),
                        settingFrame.getusernameField().getText(),settingFrame.getnewpasswordField().getText());
                boolean cek = con.updateAdmin(p, settingFrame.getoldpasswordField().getText());
                System.out.println(cek);
                if(!cek){
                    JOptionPane.showMessageDialog(settingFrame, "Password Lama Salah", "Setting", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(settingFrame,
                            "Data berhasil diubah", "Setting", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("echo");
                    settingFrame.setVisible(false);
                    
                }
                settingFrame.getnewpasswordField().setText("");
                //settingFrame.getusernameField().setText("");
                settingFrame.getoldpasswordField().setText("");
                
                
            }
            else if (source.equals(settingFrame.getcloseBtn())){
                settingFrame.setVisible(false);
                settingFrame.getnewpasswordField().setText("");
                settingFrame.getusernameField().setText("");
                settingFrame.getoldpasswordField().setText("");
            }
            
            if(source.equals(listmemberFrame.getbackBtn())){
                listmemberFrame.setVisible(false);
            }
            else if(source.equals(listmemberFrame.getsearchBtn())){
                String keyword = listmemberFrame.getsearchField().getText();
                String kategori = listmemberFrame.getsearchCombo().getSelectedItem().toString();
                listmemberFrame.setTable(con.searchMember(kategori, keyword));
            }
            else if(source.equals(listmemberFrame.getokBtn())){
                this.emptyKeranjangPeminjamanTable();
                DefaultTableModel model = (DefaultTableModel) listmemberFrame.getsearchTable().getModel();
                int baris = listmemberFrame.getsearchTable().getSelectedRow();
                String nis = model.getValueAt(baris, 0).toString();
                peminjamanFrame.getnomorindukField().setText(nis);
                listmemberFrame.getsearchField().setText("");
                listmemberFrame.setVisible(false);
            }
        }
        public void mousePressed(MouseEvent me) {
                Object sc = me.getSource();
                if(sc.equals(pengembalianFrame.getpeminjamanTable())){
                    int i = pengembalianFrame.getpeminjamanTable().getSelectedRow();
                    TableModel model = pengembalianFrame.getpeminjamanTable().getModel();
                    // Kalau fail, kemungkinan urutan table beda dengan database 
                    pengembalianFrame.getidpinjamField().setText(model.getValueAt(i,0).toString());
                    pengembalianFrame.getindukField().setText(model.getValueAt(i,1).toString());
                    pengembalianFrame.getnamaField().setText(model.getValueAt(i,2).toString());
        
                    //test2, gk tau bisa atau enggak.
                try {
                    Date date = new SimpleDateFormat("MM-dd-yyyy").parse((String)model.getValueAt(i, 3).toString());
                    pengembalianFrame.getpinjamDateChooserField().setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(editmember.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                try {
                   //jdateChooser
                    Date date = new SimpleDateFormat("MM-dd-yyyy").parse((String)model.getValueAt(i, 4).toString());
                    pengembalianFrame.getkembaliDateChooserField().setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(editmember.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                pengembalianFrame.getdendaField().setText(model.getValueAt(i,5).toString());
                pengembalianFrame.getstatusField().setText(model.getValueAt(i,6).toString());
                
                
                }
        }
        
        public void login(String usr, String pwd) {
            String id = con.cekLogin(usr, pwd);
            if(!id.isEmpty()) {
                loginFrame.setVisible(false);
                JOptionPane.showMessageDialog(null, "Selamat Datang, " + usr +".");
                settingFrame.getIdField().setText(id);
                mainFrame.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Username/Password Salah", "Login", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        public void incrementBuku(){
            ArrayList<Buku> buku = con.loadBuku();
            if(buku.isEmpty()){
                managebukuFrame.getidField().setText("1");
            }
            else {
                int count = 0;
                for(Buku b : buku){
                    count = count + 1;
                }
                managebukuFrame.getidField().setText(Integer.toString(count+1));
                
            }
        }
        
        public void incrementPeminjaman(){
            ArrayList<Peminjaman> pinjam = con.loadPeminjaman();
            if(pinjam.isEmpty()){
                peminjamanFrame.getidpinjamField().setText("1");
            }
            else {
                int x = 0;
                for (Peminjaman p : pinjam){
                    x = x + 1;
                }
                peminjamanFrame.getidpinjamField().setText(Integer.toString(x+1));
            }
        }
        
        public void incrementPengembalian(){
            ArrayList<Pengembalian> kembali = con.loadPengembalian();
            if(kembali.isEmpty()){
                pengembalianFrame.getidpengembalianField().setText("1");
            }
            else {
                ArrayList<Pengembalian> last = con.loadPengembalian();
                int x = 0;
                for (Pengembalian p : last){
                    x = x + 1;
                }
                Pengembalian lastkembali= kembali.get(kembali.size() - 1);
                int temp = Integer.parseInt(lastkembali.getId_kembali());
                int count = temp + 1;
                pengembalianFrame.getidpengembalianField().setText(Integer.toString(x+1));
            }
        }
        
        public void addMember(){
            if((editmember.getnomorindukField().getText().isEmpty())||
                        (editmember.getnamaField().getText().isEmpty())||
                        (editmember.gettempatField().getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Field tidak boleh ada yang kosong", "Edit Member", JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    editmember.getjumlahpinjam().commitEdit();
                } catch (java.text.ParseException e){

                }
                int value = (Integer) editmember.getjumlahpinjam().getValue();
               // Date temp = editmember.gettglDateChooser().getDate();
                //System.out.println(date);
                //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                //String strDate = dateFormat.format(temp);
                //System.out.println(strDate);
                Member m = new Member(editmember.getnomorindukField().getText(),
                        editmember.getnamaField().getText(),
                        editmember.gettempatField().getText(),
                        editmember.gettglDateChooser().getDate(),value);
                
                if(con.addMember(m)){
                    editmember.getnomorindukField().setText("");
                    editmember.getnamaField().setText("");
                    editmember.gettempatField().setText("");
                    Date dateNow = new java.util.Date();
                    editmember.gettglDateChooser().setDate(dateNow);
                    editmember.getjumlahpinjam().setValue(0);
                    editmember.setTable(con.loadTableMember());
                    JOptionPane.showMessageDialog(null, "Member berhasil ditambahkan", "Tambah Member", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "NIS " + editmember.getnomorindukField() + "sudah terdaftar", "Tambah Member", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        public void addBuku(){
            if((managebukuFrame.getidField().getText().equals(""))||
                    (managebukuFrame.getjudulField().getText().equals(" "))||
                    (managebukuFrame.getpenulisField().getText().equals(""))||
                    (managebukuFrame.getpenerbitField().getText().equals(""))||
                    (managebukuFrame.gettahunField().getText().equals(""))||
                    (managebukuFrame.getstokspinner().getValue().equals(""))){
                JOptionPane.showMessageDialog(null, "Field tidak boleh ada yang kosong", "Edit Buku", JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    managebukuFrame.getstokspinner().commitEdit();
                } catch (java.text.ParseException e){}
                int value = (Integer) managebukuFrame.getstokspinner().getValue();
                Buku b = new Buku(managebukuFrame.getidField().getText(),
                        managebukuFrame.getjudulField().getText(),
                        managebukuFrame.getpenulisField().getText(),
                        managebukuFrame.getpenerbitField().getText(),
                        managebukuFrame.gettahunField().getText(),value);
                
                if(con.addBuku(b)){
                    incrementBuku();
                    managebukuFrame.getjudulField().setText("");
                    managebukuFrame.getpenulisField().setText("");
                    managebukuFrame.getpenerbitField().setText("");
                    managebukuFrame.gettahunField().setText("");
                    managebukuFrame.getstokspinner().setValue(0);
                    managebukuFrame.setTable(con.loadTableBuku());
                    JOptionPane.showMessageDialog(null, "Buku berhasil ditambahkan", "Tambah Buku", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "ID Buku" + managebukuFrame.getidField().getText() + "sudah terdaftar", "Tambah Buku", JOptionPane.ERROR_MESSAGE);                    
                }
            }
        }
        
/*        public void submitPeminjaman(String idPeminjaman){
            if((peminjamanFrame.getidpinjamField().equals(""))||
                    (peminjamanFrame.getnamaField().equals(""))||
                    (peminjamanFrame.getnomorindukField().equals(""))){
                JOptionPane.showMessageDialog(null, "Field tidak boleh ada yang kosong", "Edit Peminjaman", JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    peminjamanFrame.getjumlahSpinner().commitEdit();
                }catch (java.text.ParseException e){}
                int value = (Integer) peminjamanFrame.getjumlahSpinner().getValue();
                Peminjaman peminjaman = new Peminjaman(peminjamanFrame.getidpinjamField().getText(),
                        peminjamanFrame.getnamaField().getText(),
                        peminjamanFrame.getnomorindukField().getText(),
                        peminjamanFrame.getpinjamDateChooser().getDate(),
                        peminjamanFrame.getkembaliDateChooser().getDate(),value);
                
                if(con.submitPeminjaman(peminjaman)){
                    incrementPeminjaman();
                    peminjamanFrame.getidpinjamField().setText("");
                    peminjamanFrame.getnamaField().setText("");
                    peminjamanFrame.getnomorindukField().setText("");
                    java.util.Date date = new java.util.Date();
                    peminjamanFrame.getpinjamDateChooser().setDate(date);
                    peminjamanFrame.getkembaliDateChooser().setDate(date);
                    peminjamanFrame.getjumlahSpinner().setValue(0);
                    JOptionPane.showMessageDialog(null, "Peminjaman berhasil dilakukan", "Submit Peminjaman", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "" + peminjamanFrame.getidField().getText() + "sudah terdaftar", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        public void submitPengembalian(String idPeminjaman){
            if((pengembalianFrame.getidpinjamField().equals(""))||
                    (pengembalianFrame.getindukField().equals(""))||
                    (pengembalianFrame.getnamaField().equals(""))||
                    (pengembalianFrame.getdendaField().equals(""))||
                    (pengembalianFrame.getstatusField().equals(""))){
                JOptionPane.showMessageDialog(null, "Field tidak boleh ada yang kosong", "Pengembalian", JOptionPane.WARNING_MESSAGE);
            }
            else{
                Pengembalian pengembalian = new Pengembalian(pengembalianFrame.getidpinjamField().getText(),
                        pengembalianFrame.getindukField().getText(),
                        pengembalianFrame.getnamaField().getText(),
                        pengembalianFrame.getpinjamDateChooserField().getDate(),
                        pengembalianFrame.getkembaliDateChooserField().getDate(),
                        pengembalianFrame.getdendaField().getText(),
                        pengembalianFrame.getstatusField().getText());
                
                if(con.submitPengembalian(pengembalian)){
                    incrementPengembalian();
                    pengembalianFrame.getindukField().setText("");
                    pengembalianFrame.getnamaField().setText("");
                    java.util.Date date = new java.util.Date();
                    pengembalianFrame.getpinjamDateChooserField().setDate(date);
                    pengembalianFrame.getkembaliDateChooserField().setDate(date);
                    pengembalianFrame.getdendaField().setText("");
                    pengembalianFrame.getstatusField().setText("");
                    JOptionPane.showMessageDialog(null, "Pengembalian berhasil dilakukan", "Submit Pengembalian", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "" + pengembalianFrame.getidField().getText() + "sudah terdaftar", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        }*/
        
        public void updateMember(){
            if((editmember.getnomorindukField().getText().equals(""))||
                        (editmember.getnamaField().getText().equals(""))||
                        (editmember.gettempatField().getText().equals(""))){
                JOptionPane.showMessageDialog(null, "Field tidak boleh ada yang kosong", "Edit Member", JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    editmember.getjumlahpinjam().commitEdit();
                } catch (java.text.ParseException e){

                }
                int value = (Integer) editmember.getjumlahpinjam().getValue();
                Member m = new Member(editmember.getnomorindukField().getText(),
                        editmember.getnamaField().getText(),
                        editmember.gettempatField().getText(),
                        editmember.gettglDateChooser().getDate(),value);
                
                if(con.updateMember(m)){
                    JOptionPane.showMessageDialog(null, "Data member berhasil diupdate", "Update Member", JOptionPane.INFORMATION_MESSAGE);                    
                    editmember.getnomorindukField().setText("");
                    editmember.getnamaField().setText("");
                    editmember.gettempatField().setText("");
                    java.util.Date date = new java.util.Date();
                    editmember.gettglDateChooser().setDate(date);
                    editmember.getjumlahpinjam().setValue(0);
                    editmember.setTable(con.loadTableMember());
                }
                else{
                    
                }
            }
        }
        
        public void updateBuku(){
            if((managebukuFrame.getidField().equals(""))||
                    (managebukuFrame.getjudulField().equals(""))||
                    (managebukuFrame.getpenulisField().equals(""))||
                    (managebukuFrame.getpenerbitField().equals(""))||
                    (managebukuFrame.gettahunField().equals(""))||
                    (managebukuFrame.getstokspinner().getValue().equals(""))){
                JOptionPane.showMessageDialog(null, "Field tidak boleh ada yang kosong", "Edit Buku", JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    managebukuFrame.getstokspinner().commitEdit();
                } catch (java.text.ParseException e){}
                int value = (Integer) managebukuFrame.getstokspinner().getValue();
                Buku b = new Buku(managebukuFrame.getidField().getText(),
                        managebukuFrame.getjudulField().getText(),
                        managebukuFrame.getpenulisField().getText(),
                        managebukuFrame.getpenerbitField().getText(),
                        managebukuFrame.gettahunField().getText(),value);
                
                if(con.updateBuku(b)){
                    JOptionPane.showMessageDialog(null, "Data buku berhasil diupdate", "Update Buku", JOptionPane.INFORMATION_MESSAGE);                    
                    incrementBuku();
                    managebukuFrame.getjudulField().setText("");
                    managebukuFrame.getpenulisField().setText("");
                    managebukuFrame.getpenerbitField().setText("");
                    managebukuFrame.gettahunField().setText("");
                    managebukuFrame.getstokspinner().setValue(0);
                    managebukuFrame.setTable(con.loadTableBuku());
                }
                else{
                                        
                }
            }
        }
        public void resetUiMember(){
            editmember.getnomorindukField().setText("");
            editmember.getnamaField().setText("");
            editmember.gettempatField().setText("");
            Date dateNow = new java.util.Date();
            editmember.gettglDateChooser().setDate(dateNow);
            editmember.getjumlahpinjam().setValue(0);
            editmember.getsearchField().setText("");
            editmember.getnomorindukField().setEditable(true);
            editmember.getaddBtn().setVisible(true);
            editmember.getdeleteBtn().setVisible(false);
            editmember.getupdateBtn().setVisible(false);
        }
        public void resetUiBuku(){
            incrementBuku();
            managebukuFrame.getjudulField().setText("");
            managebukuFrame.getpenulisField().setText("");
            managebukuFrame.getpenerbitField().setText("");
            managebukuFrame.gettahunField().setText("");
            managebukuFrame.getstokspinner().setValue(0);
            managebukuFrame.getsearchField().setText("");
            managebukuFrame.getaddBtn().setVisible(true);
            managebukuFrame.getdeleteBtn().setVisible(false);
            managebukuFrame.getupdateBtn().setVisible(false);
        }
           
        public void logoutEvent(){
            if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin logout?", "Logout", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                if(peminjamanFrame.getkeranjangTable().getRowCount() == 0){
                    resetUiMember();
                    resetUiBuku();
                    emptyPeminjamanDetTable();
                    mainFrame.setVisible(false);
                    peminjamanFrame.setVisible(false);
                    pengembalianFrame.setVisible(false);
                    editmember.setVisible(false);
                    managebukuFrame.setVisible(false);
                    laporanFrame.setVisible(false);
                    settingFrame.setVisible(false);
                    settingFrame.getIdField().setText("");
                    listmemberFrame.setVisible(false);
                    //JOptionPane.showMessageDialog(null, "Berhasil Logout!", "Logout", JOptionPane.INFORMATION_MESSAGE);
                    loginFrame.setVisible(true);
                    loginFrame.getusernameField().requestFocus();
                }
                else{
                    JOptionPane.showMessageDialog(peminjamanFrame, "Hapus isi table keranjang terlebih dahulu!", "Peminjaman", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        public void emptyPeminjamanDetTable(){
            DefaultTableModel model = (DefaultTableModel) pengembalianFrame.getbukuTable().getModel();
            if(model.getRowCount() > 0){
                for (int i = 0; i <= model.getRowCount(); i++){
                    model.removeRow(0);
                }
            }
            emptyKeranjangPengembalianTable();
        }
        
        public void emptyKeranjangPengembalianTable(){
            DefaultTableModel modelkeranjang = (DefaultTableModel) pengembalianFrame.getkeranjangTable().getModel();
            if(modelkeranjang.getRowCount() > 0){
                for (int i = 0; i <= modelkeranjang.getRowCount(); i++){
                    modelkeranjang.removeRow(0);
                }
            }
        }
        
        public void emptyKeranjangPeminjamanTable(){
            DefaultTableModel modelkeranjang = (DefaultTableModel) peminjamanFrame.getkeranjangTable().getModel();
            if(modelkeranjang.getRowCount() > 0){
                for (int i = 0; i <= modelkeranjang.getRowCount(); i++) {
                    modelkeranjang.removeRow(0);
                }
            }
        }
        public int totalBuku(TableModel model){
            int jumlah = 0;
            for(int row = 0;row<model.getRowCount();row++){
                jumlah = jumlah + Integer.parseInt(model.getValueAt(row, 2).toString());
            }
            return jumlah;
        }
        
    class SpinnerListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent evt) {
            JSpinner spinner = (JSpinner) evt.getSource();

            Object value = spinner.getValue();
            int isi = Integer.parseInt(value.toString());
            
            if(isi < 0){
                spinner.setValue(0);
                try{spinner.commitEdit();}
                catch (ParseException e){}
            }
        }
    }
}
