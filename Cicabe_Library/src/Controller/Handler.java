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
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;



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
        }
        public void actionPerformed(ActionEvent ae) {
                Object source = ae.getSource();
                if(source.equals(loginFrame.getloginBtn())) {
                    login(loginFrame.getusernameField().getText(), loginFrame.getpasswordField().getText());
                    loginFrame.setVisible(false);
                    mainFrame.setVisible(true);
                }
                
                if(source.equals(mainFrame.getlogoutBtn())) {
                    mainFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getmanageBtn())) {
                    mainFrame.setVisible(false);
                    managebukuFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getmemberBtn())) {
                    mainFrame.setVisible(false);
                    editmember.setVisible(true);
                }
                else if(source.equals(mainFrame.getpinjamBtn())) {
                    mainFrame.setVisible(false);
                    peminjamanFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getkembaliBtn())) {
                    mainFrame.setVisible(false);
                    pengembalianFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getlaporanBtn())){
                    mainFrame.setVisible(false);
                    laporanFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.getsettingBtn())){
                    mainFrame.setVisible(false);
                    settingFrame.setVisible(true);
                }
                
                if(source.equals(managebukuFrame.getlogoutBtn())) {
                    managebukuFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(managebukuFrame.getbackBtn())) {
                    managebukuFrame.setVisible(false);
                    mainFrame.setVisible(true);
                }
                else if(source.equals(managebukuFrame.getsearchBtn())) {
                
                }
                else if(source.equals(managebukuFrame.getdeleteBtn())) {
                
                }
                else if(source.equals(managebukuFrame.getaddBtn())) {
                
                }
                else if(source.equals(managebukuFrame.getupdateBtn())) {
                
                }
                
                if(source.equals(editmember.getlogoutBtn())) {
                    editmember.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(editmember.getbackBtn())) {
                    editmember.setVisible(false);
                    mainFrame.setVisible(true);
                }
                else if(source.equals(editmember.getsearchBtn())) {
                
                }
                else if(source.equals(editmember.getdeleteBtn())) {
                
                }
                else if(source.equals(editmember.getaddBtn())) {
                
                }
                else if(source.equals(editmember.getupdateBtn())) {
                
                }
                
                if(source.equals(peminjamanFrame.getlogoutBtn())) {
                    peminjamanFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(peminjamanFrame.getbackBtn())) {
                    peminjamanFrame.setVisible(false);
                    mainFrame.setVisible(true);
                }
                else if(source.equals(peminjamanFrame.getokBtn())) {
                
                }
                else if(source.equals(peminjamanFrame.getsubmitBtn())) {
                
                }
                else if(source.equals(peminjamanFrame.getdeleteBtn()))
                
                if(source.equals(pengembalianFrame.getlogoutBtn())) {
                    pengembalianFrame.setVisible(false);
                    loginFrame.setVisible(true);
                }
                else if(source.equals(pengembalianFrame.getbackBtn())) {
                    pengembalianFrame.setVisible(false);
                    mainFrame.setVisible(true);
                }
                else if(source.equals(pengembalianFrame.getsearchBtn())) {
                
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
            }
            else {
                JOptionPane.showMessageDialog(null, "username atau password salah");
            }
        }
        
        public void addMember(String nis){
            if(con.cekMember(nis)) {
                JOptionPane.showMessageDialog(null, "nis sudah terdaftar di database");
                editmember.getnomorindukField().setText("");
                editmember.getnamaField().setText("");
                editmember.gettempatField().setText("");
                java.util.Date date = new java.util.Date();
                editmember.gettglDateChooser().setDate(date);
                editmember.getjumlahpinjam().setValue(0);
            }
            else {
                if((editmember.getnomorindukField().equals(""))||
                        (editmember.getnamaField().equals(""))||
                        (editmember.gettempatField().equals(""))){
                    JOptionPane.showMessageDialog(null, "Field tidak boleh ada yg kosong");
                }
                else{
                    try{
                        editmember.getjumlahpinjam().commitEdit();
                    } catch (java.text.ParseException e){}
                    int value = (Integer) editmember.getjumlahpinjam().getValue();
                    Member m = new Member(editmember.getnomorindukField().getText(),
                            editmember.getnamaField().getText(),
                            editmember.gettempatField().getText(),
                            editmember.gettglDateChooser().getDate(),value);
                    con.insertMember(m);
                    editmember.getnomorindukField().setText("");
                    editmember.getnamaField().setText("");
                    editmember.gettempatField().setText("");
                    java.util.Date date = new java.util.Date();
                    editmember.gettglDateChooser().setDate(date);
                    editmember.getjumlahpinjam().setValue(0);
                    editmember.setTable(con.loadTableModel());
                    JOptionPane.showMessageDialog(null, "Member berhasil ditambahkan");
                }
            }
        }
        
        public void addBuku(String idBuku){
            if(con.cekBuku(idBuku)) {
                JOptionPane.showMessageDialog(null, "nis sudah terdaftar di database");
                managebukuFrame.getidField().setText("");
                managebukuFrame.getjudulField().setText("");
                managebukuFrame.getpenulisField().setText("");
                managebukuFrame.getpenerbitField().setText("");
                managebukuFrame.gettahunField().setText("");
                managebukuFrame.getstokspinner().setValue(0);
            }
            else{
                if((managebukuFrame.getidField().equals(""))||
                        (managebukuFrame.getjudulField().equals(""))||
                        (managebukuFrame.getpenulisField().equals(""))||
                        (managebukuFrame.getpenerbitField().equals(""))||
                        (managebukuFrame.gettahunField().equals(""))||
                        (managebukuFrame.getstokspinner().getValue().equals(""))){
                    JOptionPane.showMessageDialog(null, "Field tidak boleh ada yang kosong");
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
                    con.insertBuku(b);
                    managebukuFrame.getidField().setText("");
                    managebukuFrame.getjudulField().setText("");
                    managebukuFrame.getpenulisField().setText("");
                    managebukuFrame.getpenulisField().setText("");
                    managebukuFrame.gettahunField().setText("");
                    managebukuFrame.getstokspinner().setValue(0);
                }
            }
        }
}
