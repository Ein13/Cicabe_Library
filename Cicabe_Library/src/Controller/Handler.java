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
        }
        public void mousePressed(MouseEvent me) {
                Object source = me.getSource();
        }
}