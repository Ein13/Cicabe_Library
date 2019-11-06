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
          
        loginFrame.addActionListener(this);
        mainFrame.addActionListener(this);
        peminjamanFrame.addActionListener(this);
        pengembalianFrame.addActionListener(this);
        editmember.addActionListener(this);
        managebukuFrame.addActionListener(this);
        settingFrame.addActionListener(this);
        laporanFrame.addActionListener(this);
        listmemberFrame.addActionListener(this);
         
        loginFrame.getRootPane().setDefaultButton(loginFrame.getloginBtn());
        listmemberFrame.getRootPane().setDefaultButton(listmemberFrame.getsearchBtn());
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
                
                int baris = peminjamanFrame.getkeranjangTable().getSelectedRow();
                String idBuku = model.getValueAt(baris, 0).toString();
                int jml = Integer.parseInt(model.getValueAt(baris, 2).toString());
                con.tambahiStokBuku(idBuku, jml);
                peminjamanFrame.setTableBuku(con.loadTableBuku());
                model.removeRow(baris);
                
                
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
                boolean ada = false;
                int temp = 0;
                
                
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
                    model2.setValueAt(jmlPinjam+(Integer)model2.getValueAt(temp, 2), temp, 2);
                    model.removeRow(baris);
                }else{
                    model.removeRow(baris);
                    model2.addRow(new Object[]{idBuku,judulBuku,jmlPinjam});
                }
                
                
            }
            else if(source.equals(pengembalianFrame.getpilihBtn())){
                int i = pengembalianFrame.getbukuTable().getSelectedRow();
                DefaultTableModel model1 = (DefaultTableModel) pengembalianFrame.getkeranjangTable().getModel();
                TableModel model2 = pengembalianFrame.getbukuTable().getModel();
                DefaultTableModel model3 = (DefaultTableModel) pengembalianFrame.getbukuTable().getModel();
                TableModel model4 = pengembalianFrame.getkeranjangTable().getModel();
                
                
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
                        }else{
                            jumlah = jumlah-(Integer)pengembalianFrame.getbukuSpinner().getValue();
                            model1.addRow(new Object[]{idBuku,Judul,(Integer)pengembalianFrame.getbukuSpinner().getValue()});
                            model3.setValueAt(jumlah, i, 2);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(peminjamanFrame, "Jumlah salah", "Pengembalian", JOptionPane.ERROR_MESSAGE);
                    }
                }else if((Integer)pengembalianFrame.getbukuSpinner().getValue()==jumlah){
                    boolean ada = false;
                    int temp = 0;
                    for(int row = 0;row<model2.getRowCount();row++){
                        if(idBuku.equals(model2.getValueAt(row, 0))){
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
                }
                else{
                    JOptionPane.showMessageDialog(peminjamanFrame, "Jumlah salah", "Pengembalian", JOptionPane.ERROR_MESSAGE);
                }
                
                
                pengembalianFrame.getjudulField().setText("");
                pengembalianFrame.getbukuSpinner().setValue(0);
                
            }
            else if(source.equals(pengembalianFrame.getsubmitBtn())) {
                
            }
            
            if(source.equals(laporanFrame.getbackBtn())){
                laporanFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            else if(source.equals(laporanFrame.getlogoutBtn())){
                logoutEvent();
            }
            
            if (source.equals(settingFrame.getupdateBtn())){
                settingFrame.setVisible(false);
                mainFrame.setVisible(false);
                loginFrame.setVisible(true);
            }
            else if (source.equals(settingFrame.getcloseBtn())){
                settingFrame.setVisible(false);
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
            if(con.cekLogin(usr, pwd)) {
                loginFrame.setVisible(false);
                JOptionPane.showMessageDialog(null, "Selamat Datang, " + usr +".");
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
                Buku lastbuku = buku.get(buku.size() - 1);
                int temp = Integer.parseInt(lastbuku.getIdbuku());
                int count = temp + 1;
                managebukuFrame.getidField().setText(Integer.toString(count));
                
            }
        }
        
        public void incrementPeminjaman(){
            ArrayList<Peminjaman> pinjam = con.loadPeminjaman();
            if(pinjam.isEmpty()){
                peminjamanFrame.getidpinjamField().setText("1");
            }
            else {
                Peminjaman lastpinjam = pinjam.get(pinjam.size() - 1);
                int temp = Integer.parseInt(lastpinjam.getId_pinjam());
                int count = temp + 1;
                peminjamanFrame.getidpinjamField().setText(Integer.toString(count));
            }
        }
        
        public void incrementPengembalian(){
            ArrayList<Peminjaman> pinjam = con.loadPeminjaman();
            if(pinjam.isEmpty()){
                peminjamanFrame.getidpinjamField().setText("1");
            }
            else {
                Peminjaman lastpinjam = pinjam.get(pinjam.size() - 1);
                int temp = Integer.parseInt(lastpinjam.getId_pinjam());
                int count = temp + 1;
                peminjamanFrame.getidpinjamField().setText(Integer.toString(temp));
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
            mainFrame.setVisible(false);
            peminjamanFrame.setVisible(false);
            pengembalianFrame.setVisible(false);
            editmember.setVisible(false);
            managebukuFrame.setVisible(false);
            laporanFrame.setVisible(false);
            settingFrame.setVisible(false);
            listmemberFrame.setVisible(false);
            JOptionPane.showMessageDialog(null, "Berhasil Logout!", "Logout", JOptionPane.INFORMATION_MESSAGE);
            loginFrame.setVisible(true);
            loginFrame.getusernameField().requestFocus();
        }
        
        public void emptyPeminjamanDetTable(){
            DefaultTableModel model = (DefaultTableModel) pengembalianFrame.getbukuTable().getModel();
            if(model.getRowCount() > 0){
                for (int i = 0; i <= model.getRowCount(); i++){
                    model.removeRow(0);
                }
            }
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
