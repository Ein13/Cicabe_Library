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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JRootPane;
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
    
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
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
        laporanFrame.setVisible(false);
        settingFrame.setVisible(false);
          
        loginFrame.addActionListener(this);
        mainFrame.addActionListener(this);
        peminjamanFrame.addActionListener(this);
        pengembalianFrame.addActionListener(this);
        editmember.addActionListener(this);
        managebukuFrame.addActionListener(this);
        settingFrame.addActionListener(this);
        laporanFrame.addActionListener(this);
         
        loginFrame.getRootPane().setDefaultButton(loginFrame.getloginBtn());
        settingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //centreWindow(loginFrame);
        loginFrame.setLocationRelativeTo(null);
        mainFrame.setLocationRelativeTo(null);
        peminjamanFrame.setLocationRelativeTo(null);
        pengembalianFrame.setLocationRelativeTo(null);
        editmember.setLocationRelativeTo(null);
        managebukuFrame.setLocationRelativeTo(null);
        settingFrame.setLocationRelativeTo(null);
        laporanFrame.setLocationRelativeTo(null);
        
           
        JSpinner spinner = peminjamanFrame.getjumlahSpinner();
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        tf.setEditable(false);
        }
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(loginFrame.getloginBtn())) {
            login(loginFrame.getusernameField().getText(), loginFrame.getpasswordField().getText());
            loginFrame.getpasswordField().setText("");
        }
        
        if(source.equals(mainFrame.getlogoutBtn())) {
            mainFrame.setVisible(false);
            loginFrame.setVisible(true);
            loginFrame.getusernameField().requestFocusInWindow();
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
        }
        else if(source.equals(mainFrame.getkembaliBtn())) {
            //pengembalianFrame.setTable(con.loadTablePeminjaman());
            //pengembalianFrame.setTable(con.loadTableBuku());
            incrementPeminjaman();
            Date dateNow = new java.util.Date();
            pengembalianFrame.getpinjamDateChooserField().setDate(dateNow);
            pengembalianFrame.getkembaliDateChooserField().setDate(dateNow);
            pengembalianFrame.setVisible(true);
            mainFrame.setVisible(false);
            pengembalianFrame.setTable(con.loadTableMember());
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
            loginFrame.setVisible(true);
            managebukuFrame.setVisible(false);
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
            editmember.setVisible(false);
            loginFrame.setVisible(true);
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
            DefaultTableModel model = (DefaultTableModel)peminjamanFrame.getkeranjangTable().getModel();
            model.addRow(new Object[]{peminjamanFrame.getidField().getText(), peminjamanFrame.getjudulField().getText(), peminjamanFrame.getjumlahSpinner().getValue()});
            peminjamanFrame.getjudulField().setText("");
            peminjamanFrame.getidField().setText("");
            peminjamanFrame.getjumlahSpinner().setValue(1);
        }
            else if(source.equals(peminjamanFrame.getsearchBtn())){
                String category = (String) peminjamanFrame.getsearchComboBox().getSelectedItem();
                peminjamanFrame.setTableBuku(con.searchBuku(category, peminjamanFrame.getsearchField().getText()));
            } 
            else if(source.equals(peminjamanFrame.getsubmitBtn())) {
                
            }
            else if(source.equals(peminjamanFrame.getdeleteBtn())){
                DefaultTableModel model = (DefaultTableModel) peminjamanFrame.getkeranjangTable().getModel();
                int[] rows = peminjamanFrame.getkeranjangTable().getSelectedRows();
                for(int i=0;i<rows.length;i++){
                    model.removeRow(rows[i]-i);
                }
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
                mainFrame.setVisible(false);
                loginFrame.setVisible(true);
            }
            else if (source.equals(settingFrame.getcloseBtn())){
                settingFrame.setVisible(false);
            }
        }
        public void mousePressed(MouseEvent me) {
                Object source = me.getSource();
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
           


}
