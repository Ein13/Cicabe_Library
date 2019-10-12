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
    
    private Controller con = new Controller();
        public Handler() {
            loginFrame = new login();
            mainFrame = new main();
            peminjamanFrame = new peminjaman();
            pengembalianFrame = new pengembalian();
            editmember = new editmember();
            managebukuFrame = new managebuku();
            
            loginFrame.setVisible(true);
            mainFrame.setVisible(false);
            peminjamanFrame.setVisible(false);
            pengembalianFrame.setVisible(false);
            editmember.setVisible(false);
            managebukuFrame.setVisible(false);
            
            loginFrame.addActionListener(this);
            mainFrame.addActionListener(this);
            peminjamanFrame.addActionListener(this);
            pengembalianFrame.addActionListener(this);
            editmember.addActionListener(this);
            managebukuFrame.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae) {
                Object source = ae.getSource();
                if(source.equals(loginFrame.getloginBtn())) {
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
                else if(source.equals(mainFrame.pinjamBtn())) {
                    mainFrame.setVisible(false);
                    peminjamanFrame.setVisible(true);
                }
                else if(source.equals(mainFrame.kembaliBtn())) {
                    mainFrame.setVisible(false);
                    pengembalianFrame.setVisible(true);
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
                else if(source.equals(peminjamanFrame.getsearchBtn())) {
                
                }
                else if(source.equals(peminjamanFrame.submitBtn())) {
                
                }
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
        }
        public void mousePressed(MouseEvent me) {
                Object source = me.getSource();
        }
}
