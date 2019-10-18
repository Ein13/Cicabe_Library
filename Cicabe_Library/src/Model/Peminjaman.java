package Model;

import java.util.Date;

public class Peminjaman {
    private String id_pinjam;
    private String nis;
    private Date tgl_pinjam;
    private Date tgl_kembali;
    private int total_pinjam;

    public Peminjaman(String id_pinjam, String nis, Date tgl_pinjam, Date tgl_kembali, int total_pinjam) {
        this.id_pinjam = id_pinjam;
        this.nis = nis;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
        this.total_pinjam = total_pinjam;
    }

    public String getId_pinjam() {
        return id_pinjam;
    }

    public void setId_pinjam(String id_pinjam) {
        this.id_pinjam = id_pinjam;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public Date getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(Date tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public Date getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(Date tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    public int getTotal_pinjam() {
        return total_pinjam;
    }

    public void setTotal_pinjam(int total_pinjam) {
        this.total_pinjam = total_pinjam;
    }
    
    
}
