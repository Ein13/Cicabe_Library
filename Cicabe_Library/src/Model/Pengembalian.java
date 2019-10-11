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
public class Pengembalian {
    private String idkembali;
    private Date tgl_kembali;
    private int denda;
    private Peminjaman Peminjaman;

    public Pengembalian (String idkembali, Date tgl_kembali, int denda){
        this.idkembali = idkembali;
        this.tgl_kembali = tgl_kembali;
        this.denda = denda;
    }
    /**
     * @return the idkembali
     */
    public String getIdkembali() {
        return idkembali;
    }

    /**
     * @param idkembali the idkembali to set
     */
    public void setIdkembali(String idkembali) {
        this.idkembali = idkembali;
    }

    /**
     * @return the tgl_kembali
     */
    public Date getTgl_kembali() {
        return tgl_kembali;
    }

    /**
     * @param tgl_kembali the tgl_kembali to set
     */
    public void setTgl_kembali(Date tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    /**
     * @return the denda
     */
    public int getDenda() {
        return denda;
    }

    /**
     * @param denda the denda to set
     */
    public void setDenda(int denda) {
        this.denda = denda;
    }

    /**
     * @return the Peminjaman
     */
    public Peminjaman getPeminjaman() {
        return Peminjaman;
    }

    /**
     * @param Peminjaman the Peminjaman to set
     */
    public void setPeminjaman(Peminjaman Peminjaman) {
        this.Peminjaman = Peminjaman;
    }
    
    
}
