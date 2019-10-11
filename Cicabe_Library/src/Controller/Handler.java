/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Zara
 */
public class Handler extends MouseAdapter implements ActionListener {
    private Login log;
    private Main main;
    private Peminjaman peminjaman;
    private Pengembalian pengembalian;
    
    private Controller con = new Controller();
        public Handler() {
            log = new Login();
            main = new Main();
            peminjaman = new Peminjaman();
            pengembalian = new Pengembalian();
            
            log.setVisible(true);
            main.setVisible(false);
            peminjaman.setVisible(false);
            pengembalian.setVisible(false);
            
            log.addActionListener(this);
            main.addActionListener(this);
            peminjaman.addActionListener(this);
            pengembalian.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae) {
                Object source = ae.getSource();
        }
        public void mousePressed(MouseEvent me) {
                Object source = me.getSource();
        }
}