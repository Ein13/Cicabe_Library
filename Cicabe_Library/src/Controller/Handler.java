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
    private loginFrame loginFrame;
    private mainFrame mainFrame;
    private peminjamanFrame peminjamanFrame;
    private pengembalianFrame pengembalianFrame;
    private editmemberFrame editmemberFrame;
    private managebukuFrame managebukuFrame;
    
    private Controller con = new Controller();
        public Handler() {
            loginFrame = new loginFrame();
            mainFrame = new mainFrame();
            peminjamanFrame = new peminjamanFrame();
            pengembalianFrame = new PengembalianFrame();
            editmemberFrame = new editmemberFrame();
            managebukuFrame = new managebukuFrame();
            
            loginFrame.setVisible(true);
            mainFrame.setVisible(false);
            peminjamanFrame.setVisible(false);
            pengembalianFrame.setVisible(false);
            editmemberFrame.setVisible(false);
            managebukuFrame.setVisible(false);
            
            loginFrame.addActionListener(this);
            mainFrame.addActionListener(this);
            peminjamanFrame.addActionListener(this);
            pengembalianFrame.addActionListener(this);
            editmemberFrame.addActionListener(this);
            managebukuFrame.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae) {
                Object source = ae.getSource();
        }
        public void mousePressed(MouseEvent me) {
                Object source = me.getSource();
        }
}