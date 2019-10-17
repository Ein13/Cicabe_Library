package Model;

import java.util.Date;

public class Member {
    private String NIS;
    private String nama;
    private String tempat_lahir;
    private Date tgl_lahir;
    private int jml_pinjam;
    
    public Member (String NIS, String nama, String tempat_lahir, Date tgl_lahir , int jml_pinjam){
        this.NIS = NIS;
        this.nama = nama;
        this.tempat_lahir = tempat_lahir;
        this.tgl_lahir = tgl_lahir;
        this.jml_pinjam = jml_pinjam;
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

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
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

    public int getJml_pinjam() {
        return jml_pinjam;
    }

    public void setJml_pinjam(int jml_pinjam) {
        this.jml_pinjam = jml_pinjam;
    }
    
    
}



