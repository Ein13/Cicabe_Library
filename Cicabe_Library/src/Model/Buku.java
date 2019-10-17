package Model;

public class Buku {
    private String idbuku;
    private String judul;
    private String penulis;
    private String penerbit;
    private String tahun;
    private int stok;
    
    public Buku (String Idbuku, String Judul, String Penulis, String Penerbit, String Tahun, int Stok){
        idbuku = Idbuku;
        judul = Judul;
        penulis = Penulis;
        penerbit = Penerbit;
        tahun = Tahun;
        stok = Stok;
    }

    /**
     * @return the idbuku
     */
    public String getIdbuku() {
        return idbuku;
    }

    /**
     * @param idbuku the idbuku to set
     */
    public void setIdbuku(String idbuku) {
        this.idbuku = idbuku;
    }

    /**
     * @return the judul
     */
    public String getJudul() {
        return judul;
    }

    /**
     * @param judul the judul to set
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }

    /**
     * @return the penulis
     */
    public String getPenulis() {
        return penulis;
    }

    /**
     * @param penulis the penulis to set
     */
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    /**
     * @return the penerbit
     */
    public String getPenerbit() {
        return penerbit;
    }

    /**
     * @param penerbit the penerbit to set
     */
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    /**
     * @return the tahun
     */
    public String getTahun() {
        return tahun;
    }

    /**
     * @param tahun the tahun to set
     */
    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }   
}
