/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Naufal
 */
public class Peminjam {
    private String NIS;
    private String nama;
    // tgl lahir ???
    private boolean pinjam;
    
    public Peminjam (String NIS, String nama, boolean pinjam){
        this.NIS = NIS;
        this.nama = nama;
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
    
    public void setnama(String nama){}
        
}
