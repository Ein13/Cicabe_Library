package Model;

public class Peminjaman_det {
    private String id_pinjam;
    private String id_buku;
    private int jml;

    public Peminjaman_det(String id_pinjam, String id_buku, int jml) {
        this.id_pinjam = id_pinjam;
        this.id_buku = id_buku;
        this.jml = jml;
    }

    public String getId_pinjam() {
        return id_pinjam;
    }

    public void setId_pinjam(String id_pinjam) {
        this.id_pinjam = id_pinjam;
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
