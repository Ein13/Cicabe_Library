/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Zara
 */
public class Buku {
    private String idbuku;
    private String judul;
    private String penulis;
    private String penerbit;
    private int tahun;
    
    public Buku (String Idbuku, String Judul, String Penulis, String Penerbit, int Tahun){
        idbuku = Idbuku;
        judul = Judul;
        penulis = Penulis;
        penerbit = Penerbit;
        tahun = Tahun;
    }
    
    public String getidbuku(){
        return idbuku;
    }
    
    public void setidbuku(String idbuku){
        this.idbuku = idbuku;
    }
    
    public String getjudul(){
        return judul;
    }
    
    public void setjudul(String judul){
        this.judul = judul;
    }
    
    public String getpenulis(){
        return penulis;
    }
    
    public void setpenulis(String penulis){
        this.penulis = penulis;
    }
    
    public String getpenerbit(){
        return penerbit;
    }
    
    public void setpenerbit(String penerbit){
        this.penerbit = penerbit;
    }
    
    public int gettahun(){
        return tahun;
    }
    
    public void settahun(int tahun){
        this.tahun = tahun;
    }
}

