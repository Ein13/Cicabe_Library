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
    
    public void addBuku(Buku x){
        Buku = x;
    }
        
    public void addPeminjam (Peminjam x){
        Peminjam = x;
    }
    
    public String getidpinjam(){
        return idpinjam;
    }
    
    public void setidpinjam(String idpinjam){
        this.idpinjam = idpinjam;
    }
    
    public Date gettgl_pinjam(){
        return tgl_pinjam;
    }
    
    public void settgl_pinjam(Date tgl_pinjam){
        this.tgl_pinjam = tgl_pinjam;
    }
    
    public int getlama_pinjam(){
        return lama_pinjam;
    }
    
    public void setlama_pinjam(int lama_pinjam){
        this.lama_pinjam = lama_pinjam;
    }
    
    public boolean getsudah_kembali(){
        return sudah_kembali;
    }
    
    public void setsudah_kembali(boolean sudah_kembali){
        this.sudah_kembali = sudah_kembali;
    }

}
