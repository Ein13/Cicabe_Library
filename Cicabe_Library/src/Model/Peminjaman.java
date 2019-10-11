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
public class Peminjaman {
    private String idpinjam;
    private Date tgl_pinjam;
    private int lama_pinjam;
    private boolean sudah_kembali;
    private Buku Buku;
    private Peminjam Peminjam;

    public Peminjaman (String idpinjam, Date tgl_pinjam, int lama_pinjam, boolean sudah_kembali){
        this.idpinjam = idpinjam;
        this.tgl_pinjam = tgl_pinjam;
        this.lama_pinjam = lama_pinjam;
        this.sudah_kembali = sudah_kembali;
    }
    

    /**
     * @return the idpinjam
     */
    public String getIdpinjam() {
        return idpinjam;
    }

    /**
     * @param idpinjam the idpinjam to set
     */
    public void setIdpinjam(String idpinjam) {
        this.idpinjam = idpinjam;
    }

    /**
     * @return the tgl_pinjam
     */
    public Date getTgl_pinjam() {
        return tgl_pinjam;
    }

    /**
     * @param tgl_pinjam the tgl_pinjam to set
     */
    public void setTgl_pinjam(Date tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    /**
     * @return the lama_pinjam
     */
    public int getLama_pinjam() {
        return lama_pinjam;
    }

    /**
     * @param lama_pinjam the lama_pinjam to set
     */
    public void setLama_pinjam(int lama_pinjam) {
        this.lama_pinjam = lama_pinjam;
    }

    /**
     * @return the sudah_kembali
     */
    public boolean isSudah_kembali() {
        return sudah_kembali;
    }

    /**
     * @param sudah_kembali the sudah_kembali to set
     */
    public void setSudah_kembali(boolean sudah_kembali) {
        this.sudah_kembali = sudah_kembali;
    }

    /**
     * @return the Buku
     */
    public Buku getBuku() {
        return Buku;
    }

    /**
     * @param Buku the Buku to set
     */
    public void setBuku(Buku Buku) {
        this.Buku = Buku;
    }

    /**
     * @return the Peminjam
     */
    public Peminjam getPeminjam() {
        return Peminjam;
    }

    /**
     * @param Peminjam the Peminjam to set
     */
    public void setPeminjam(Peminjam Peminjam) {
        this.Peminjam = Peminjam;
    }
    
    
    
    

}
