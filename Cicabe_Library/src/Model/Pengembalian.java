package Model;

import java.util.Date;

public class Pengembalian {
    private String id_kembali;
    private String id_pinjam;
    private Date tgl_Kembali;
    private int denda;
    private int total_kembali;
    //Tunggu konfirmasi ERD

    public Pengembalian(String id_kembali, String id_pinjam, Date tgl_Kembali, int denda, int total_kembali) {
        this.id_kembali = id_kembali;
        this.id_pinjam = id_pinjam;
        this.tgl_Kembali = tgl_Kembali;
        this.denda = denda;
        this.total_kembali = total_kembali;
    }

    public String getId_kembali() {
        return id_kembali;
    }

    public void setId_kembali(String id_kembali) {
        this.id_kembali = id_kembali;
    }

    public String getId_pinjam() {
        return id_pinjam;
    }

    public void setId_pinjam(String id_pinjam) {
        this.id_pinjam = id_pinjam;
    }

    public Date getTgl_Kembali() {
        return tgl_Kembali;
    }

    public void setTgl_Kembali(Date tgl_Kembali) {
        this.tgl_Kembali = tgl_Kembali;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public int getTotal_kembali() {
        return total_kembali;
    }

    public void setTotal_kembali(int total_kembali) {
        this.total_kembali = total_kembali;
    }
    
    
}
