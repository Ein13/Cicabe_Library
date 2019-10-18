package Model;

public class Pengembalian_det {
    private String id_kembali;
    private String id_buku;
    private int jml;

    public Pengembalian_det(String id_kembali, String id_buku, int jml) {
        this.id_kembali = id_kembali;
        this.id_buku = id_buku;
        this.jml = jml;
    }

    public String getId_kembali() {
        return id_kembali;
    }

    public void setId_kembali(String id_kembali) {
        this.id_kembali = id_kembali;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public int getJml() {
        return jml;
    }

    public void setJml(int jml) {
        this.jml = jml;
    }
    
    
}
