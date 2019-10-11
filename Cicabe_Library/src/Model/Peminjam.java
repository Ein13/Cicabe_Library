/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Naufal
 */
public class Peminjam {
    private String NIS;
    private String nama;
    private Date tgl_lahir;
    private boolean pinjam;
    
    public Peminjam (String NIS, String nama, Date tgl_lahir , boolean pinjam){
        this.NIS = NIS;
        this.nama = nama;
        this.tgl_lahir = tgl_lahir;
        this.pinjam = pinjam;
    }

    /**
     * @return the NIS
     */
    public String getNIS() {
        return NIS;
    }

    /**
     * @param NIS the NIS to set
     */
    public void setNIS(String NIS) {
        this.NIS = NIS;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the tgl_lahir
     */
    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    /**
     * @param tgl_lahir the tgl_lahir to set
     */
    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    /**
     * @return the pinjam
     */
    public boolean isPinjam() {
        return pinjam;
    }

    /**
     * @param pinjam the pinjam to set
     */
    public void setPinjam(boolean pinjam) {
        this.pinjam = pinjam;
    }
    
    
}
