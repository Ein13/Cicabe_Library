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
    
    public String getNIS(){
        return NIS;
    }
    
    public void setNIS(String NIS){
        this.NIS = NIS;
    } 
    
    public  String getnama(){
        return nama;
    }
    
    public void setnama(String nama){
        this.nama = nama;
    }
    
    public Date gettgl_lahir(){
        return tgl_lahir;
    }
    
    public void settgl_lahir(Date tgl_lahir){
        this.tgl_lahir = tgl_lahir;
    }
    
    public boolean getpinjam(){
        return pinjam;
    }
    
    public void setpinjam(boolean pinjam){
        this.pinjam = pinjam;
    }
}
