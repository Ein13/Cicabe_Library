/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.*;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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
            
            loginFrame.setVisible(true);
            mainFrame.setVisible(false);
            peminjamanFrame.setVisible(false);
            pengembalianFrame.setVisible(false);
            editmember.setVisible(false);
            managebukuFrame.setVisible(false);
            settingFrame.setVisible(false);
            laporanFrame.setVisible(false);
            
            loginFrame.addActionListener(this);
            mainFrame.addActionListener(this);
            peminjamanFrame.addActionListener(this);
            pengembalianFrame.addActionListener(this);
            editmember.addActionListener(this);
            managebukuFrame.addActionListener(this);
            settingFrame.addActionListener(this);
            laporanFrame.addActionListener(this);
            JSpinner spinner = peminjamanFrame.getjumlahSpinner();
            JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
            tf.setEditable(false);
        }
        public void actionPerformed(ActionEvent ae) {
                Object source = ae.getSource();
                if(source.equals(loginFrame.getloginBtn())) {
                    login(loginFrame.getusernameField().getText(), loginFrame.getpasswordField().getText());
                    loginFrame.getusernameField().setText("");
                    loginFrame.getpasswordField().setText("");
                }
                
                if(source.equals(mainFrame.getlogoutBtn())) {
                    mainFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getmanageBtn())) {
                    managebukuFrame.setTable(con.loadTableBuku());
                    incrementBuku();
                    mainFrame.setVisible(false);
                    managebukuFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getmemberBtn())) {
                    Date dateNow = new java.util.Date();
                    editmember.gettglDateChooser().setDate(dateNow);
                    editmember.setTable(con.loadTableMember());
                    mainFrame.setVisible(false);
                    editmember.setVisible(true);
                }
                else if(source.equals(mainFrame.getpinjamBtn())) {
                    //peminjamanFrame.setTable(con.loadTablePeminjaman());
                    //peminjamanFrame.setTable(con.loadTableBuku());
                    incrementPeminjaman();
                    Date dateNow = new java.util.Date();
                    peminjamanFrame.getpinjamDateChooser().setDate(dateNow);
                    peminjamanFrame.getkembaliDateChooser().setDate(dateNow);
                    mainFrame.setVisible(false);
                    peminjamanFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getkembaliBtn())) {
                    //pengembalianFrame.setTable(con.loadTablePeminjaman());
                    //pengembalianFrame.setTable(con.loadTableBuku());
                    incrementPeminjaman();
                    Date dateNow = new java.util.Date();
                    pengembalianFrame.getpinjamDateChooserField().setDate(dateNow);
                    pengembalianFrame.getkembaliDateChooserField().setDate(dateNow);
                    mainFrame.setVisible(false);
                    pengembalianFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getlaporanBtn())){
                    //laporanFrame.setTable(con.loadTableLaporan());
                    mainFrame.setVisible(false);
                    laporanFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getsettingBtn())){
                    mainFrame.setVisible(false);
                    settingFrame.setVisible(true);
                }
                
                if(source.equals(managebukuFrame.getlogoutBtn())) {
                    managebukuFrame.getidField().setText("");
                    managebukuFrame.getjudulField().setText("");
                    managebukuFrame.getpenulisField().setText("");
                    managebukuFrame.getpenerbitField().setText("");
                    managebukuFrame.gettahunField().setText("");
                    managebukuFrame.getstokspinner().setValue(0);
                    managebukuFrame.getsearchField().setText("");
                    managebukuFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(managebukuFrame.getbackBtn())) {
                    managebukuFrame.getidField().setText("");
                    managebukuFrame.getjudulField().setText("");
                    managebukuFrame.getpenulisField().setText("");
                    managebukuFrame.getpenerbitField().setText("");
                    managebukuFrame.gettahunField().setText("");
                    managebukuFrame.getstokspinner().setValue(0);
                    managebukuFrame.getsearchField().setText("");
                    managebukuFrame.setVisible(false);
                    mainFrame.setVisible(true);
                }
                else if(source.equals(managebukuFrame.getsearchBtn())) {
                    String category = (String) managebukuFrame.getsearchCombo().getSelectedItem();
                    managebukuFrame.setTable(con.searchBuku(category, managebukuFrame.getsearchField().getText()));
                    //managebukuFrame.setTable(con.loadTableBuku());
                }
                else if(source.equals(managebukuFrame.getdeleteBtn())) {
                    if(con.deleteBuku(managebukuFrame.getidField().getText())){
                        JOptionPane.showMessageDialog(managebukuFrame, "Berhasil menghapus buku dengan Id " + managebukuFrame.getidField().getText(), "Hapus Buku", JOptionPane.INFORMATION_MESSAGE);
                        managebukuFrame.getidField().setText("");
                        managebukuFrame.getjudulField().setText("");
                        managebukuFrame.getpenulisField().setText("");
                        managebukuFrame.getpenerbitField().setText("");
                        managebukuFrame.gettahunField().setText("");
                        managebukuFrame.getstokspinner().setValue(0);
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
                }
                
                if(source.equals(editmember.getlogoutBtn())) {
                    editmember.getnomorindukField().setText("");
                    editmember.getnamaField().setText("");
                    editmember.gettempatField().setText("");
                    Date dateNow = new java.util.Date();
                    editmember.gettglDateChooser().setDate(dateNow);
                    editmember.getjumlahpinjam().setValue(0);
                    editmember.getsearchField().setText("");
                    editmember.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(editmember.getbackBtn())) {
                    editmember.getnomorindukField().setText("");
                    editmember.getnamaField().setText("");
                    editmember.gettempatField().setText("");
                    Date dateNow = new java.util.Date();
                    editmember.gettglDateChooser().setDate(dateNow);
                    editmember.getjumlahpinjam().setValue(0);
                    editmember.getsearchField().setText("");
                    editmember.setVisible(false);
                    mainFrame.setVisible(true);
                }
                else if(source.equals(editmember.getsearchBtn())) {
                    String category = (String) managebukuFrame.getsearchCombo().getSelectedItem();
                    con.searchMember(category, editmember.getsearchField().getText());
                    editmember.setTable(con.loadTableMember());
                }
                else if(source.equals(editmember.getdeleteBtn())) {
                    if(con.deleteMember(editmember.getnomorindukField().getText())){
                        JOptionPane.showMessageDialog(editmember, "Berhasil menghapus member dengan NIS " + editmember.getnomorindukField().getText(), "Hapus Member", JOptionPane.INFORMATION_MESSAGE);
                        editmember.getnomorindukField().setText("");
                        editmember.getnamaField().setText("");
                        editmember.gettempatField().setText("");
                        java.util.Date date = new java.util.Date();
                        editmember.gettglDateChooser().setDate(date);
                        editmember.getjumlahpinjam().setValue(0);
                    }
                    else{
                        JOptionPane.showMessageDialog(editmember, "Gagal hapus member", "Hapus Member", JOptionPane.ERROR_MESSAGE);
                    }
                    editmember.setTable(con.loadTableMember());
                }
                else if(source.equals(editmember.getaddBtn())) {
                    addMember();
                }
                else if(source.equals(editmember.getupdateBtn())) {
                    updateMember();
                }
                
                if(source.equals(peminjamanFrame.getlogoutBtn())) {
                    peminjamanFrame.getidpinjamField().setText("");
                    peminjamanFrame.getnamaField().setText("");
                    peminjamanFrame.getnomorindukField().setText("");
                    Date dateNow = new java.util.Date();
                    peminjamanFrame.getpinjamDateChooser().setDate(dateNow);
                    peminjamanFrame.getkembaliDateChooser().setDate(dateNow);
                    peminjamanFrame.getsearchField().setText("");
                    peminjamanFrame.getjudulField().setText("");
                    peminjamanFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(peminjamanFrame.getbackBtn())) {
                    peminjamanFrame.getidpinjamField().setText("");
                    peminjamanFrame.getnamaField().setText("");
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
                    
                }
                else if(source.equals(peminjamanFrame.getsearchBtn())){
                    String category = (String) peminjamanFrame.getsearchComboBox().getSelectedItem();
                    con.searchPeminjaman(category, peminjamanFrame.getsearchField().getText());
                    peminjamanFrame.setTable(con.loadTableBuku());
                }
                else if(source.equals(peminjamanFrame.getsubmitBtn())) {
                    
                }
                else if(source.equals(peminjamanFrame.getdeleteBtn())){
                    
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
                    pengembalianFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(pengembalianFrame.getbackBtn())) {
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
                    //String category = (String) pengembalianFrame.getCategory().getSelectedItem();
                    //con.searchPengembalian(category, pengembalianFrame.getsearchField().getText());
                    //pengembalianFrame.setTable(con.loadTablePengembalian());
                }
                else if(source.equals(pengembalianFrame.getsubmitBtn())) {
                
                }
                
                if(source.equals(laporanFrame.getbackBtn())){
                    laporanFrame.setVisible(false);
                    mainFrame.setVisible(true);
                }
                else if(source.equals(laporanFrame.getlogoutBtn())){
                    laporanFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                
                if (source.equals(settingFrame.getupdateBtn())){
                    settingFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
        }
        public void mousePressed(MouseEvent me) {
                Object source = me.getSource();
        }
        
        public void login(String usr, String pwd) {
            if(con.cekLogin(usr, pwd)) {
                loginFrame.setVisible(false);
                mainFrame.setVisible(true);
                JOptionPane.showMessageDialog(null, "Selamat Datang, " + usr +".");
            }
            else {
                JOptionPane.showMessageDialog(null, "username atau password salah");
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
            if((editmember.getnomorindukField().equals(""))||
                        (editmember.getnamaField().equals(""))||
                        (editmember.gettempatField().equals(""))){
                JOptionPane.showMessageDialog(null, "Field tidak boleh ada yang kosong", "Edit Member", JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    editmember.getjumlahpinjam().commitEdit();
                } catch (java.text.ParseException e){

                }
                int value = (Integer) editmember.getjumlahpinjam().getValue();
                Date temp = editmember.gettglDateChooser().getDate();
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
                    managebukuFrame.getpenulisField().setText("");
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
                    editmember.getnomorindukField().setText("");
                    editmember.getnamaField().setText("");
                    editmember.gettempatField().setText("");
                    java.util.Date date = new java.util.Date();
                    editmember.gettglDateChooser().setDate(date);
                    editmember.getjumlahpinjam().setValue(0);
                    editmember.setTable(con.loadTableMember());
                    JOptionPane.showMessageDialog(null, "Data member berhasil diupdate", "Update Member", JOptionPane.INFORMATION_MESSAGE);
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
                    incrementBuku();
                    managebukuFrame.getjudulField().setText("");
                    managebukuFrame.getpenulisField().setText("");
                    managebukuFrame.getpenulisField().setText("");
                    managebukuFrame.gettahunField().setText("");
                    managebukuFrame.getstokspinner().setValue(0);
                    managebukuFrame.setTable(con.loadTableBuku());
                    JOptionPane.showMessageDialog(null, "Data buku berhasil diupdate", "Update Buku", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                                        
                }
            }
        }
}
