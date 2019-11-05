//TO DO LIST
//peminjaman cek jumlah dipinjam dengan stok DONE
//peminjaman kurang stok dengan jumlah dipinjam saat ADD
//peminjaman tambah stok dengan jumlah dipinjam saat DELETE


package Model;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Database {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    ArrayList<Petugas> admin;
    ArrayList<Member> member;
    ArrayList<Buku> buku;
    ArrayList<Peminjaman> pinjam;
    ArrayList<Peminjaman_det> pinjamDet;
    ArrayList<Pengembalian> kembali;
    ArrayList<Pengembalian_det> kembaliDet;
    
    public void connect() {
        try {
            String msAccDB = System.getProperty("user.dir") + "\\src\\cicabrary.accdb";
            String url = "jdbc:ucanaccess://" + msAccDB;
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            //System.out.println("Connected");
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void disconnect() {
        try {
            if(con != null) {
                con.close();
                stmt.close();
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //LOAD STUFF
    
    public void loadAdmin(){
        connect();
        try{
            admin = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM admin");
            while(rs.next()){
                admin.add(new Petugas(rs.getString("id"), rs.getString("nama"), 
                        rs.getString("username"), rs.getString("password")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Petugas> getPetugas(){
        loadAdmin();
        return admin;
    }
    
    public void loadMember(){
        connect();
        try{
            member = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM member");
            while(rs.next()){
                member.add(new Member(rs.getString("nis"), rs.getString("nama"), rs.getString("tempat_Lahir"), 
                        rs.getDate("tgl_Lahir"), rs.getInt("jml_Pinjam")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Member> getMember(){
        loadMember();
        return member;
    }
    
    public void loadBuku(){
        connect();
        try{
            buku = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM buku");
            while(rs.next()){
                buku.add(new Buku(rs.getString("id_buku"), rs.getString("judul"), rs.getString("penulis"), 
                        rs.getString("penerbit"), rs.getString("tahun"), rs.getInt("stok")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Buku> getBuku(){
        loadBuku();
        return buku;
    }
    
    public void loadPinjam(){
        connect();
        try{
            pinjam = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM peminjaman");
            while(rs.next()){
                pinjam.add(new Peminjaman(rs.getString("id_Pinjam"), rs.getString("nis"), 
                        rs.getDate("tgl_pinjam"), rs.getDate("tgl_kembali"), 
                        rs.getInt("total_pinjam")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Peminjaman> getPinjam(){
        loadPinjam();
        return pinjam;
    }
    
    public void loadPinjamDet(String id){
        connect();
        try{
            pinjamDet = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM peminjaman_det WHERE id_Pinjam = "+"'"+id+"'");
            while(rs.next()){
                pinjamDet.add(new Peminjaman_det(rs.getString("id_Pinjam"), 
                        rs.getString("id_Buku"), rs.getInt("jml")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Peminjaman_det> getPinjamDet(String id){
        loadPinjamDet(id);
        return pinjamDet;
    }
    
    public void loadPinjamDetID(){
        connect();
        try{
            
        } catch(Exception e){
            
        }
    }
    
    public void loadKembali(){
        connect();
        try{
            kembali = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM pengembalian");
            while(rs.next()){
                kembali.add(new Pengembalian(rs.getString("id_Kembali"), 
                        rs.getString("id_Pinjam"), rs.getDate("tgl_Kembali"), 
                        rs.getInt("denda"), rs.getInt("total_Kembali")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    public ArrayList<Pengembalian> getKembali(){
        loadKembali();
        return kembali;
    }
    
    public void loadKembaliDet(){
        connect();
        try{
            kembaliDet = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM pengembalian_det");
            while(rs.next()){
                kembaliDet.add(new Pengembalian_det(rs.getString("id_Kembali"), rs.getString("id_Buku"), rs.getInt("jml")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Pengembalian_det> getKembaliDet(){
        loadKembaliDet();
        return kembaliDet;
    }
    
    //INSERT STUFF
    
    public boolean insertMember(Member m){
        connect();
        boolean cek = false;
        int row;
        try{
            java.text.DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
            String tgl = df.format(m.getTgl_lahir());
 
            row = stmt.executeUpdate("INSERT INTO member VALUES ('" + m.getNIS() + "', '" + m.getNama() +"', '" + m.getTempat_lahir() + "', #" + tgl +"#, '" + m.getJml_pinjam() + "')");
            if (row > 0){
                cek = true;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Insert Member", JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }
    
    public boolean insertBuku(Buku b){
        connect();
        boolean cek = false;
        int row;
        try{
           row = stmt.executeUpdate("INSERT INTO buku VALUES ('" + b.getIdbuku() +"', '"+ b.getJudul() +"', '"+ b.getPenulis() +"', "
                   + "'"+ b.getPenerbit() +"', '"+ b.getTahun() +"', '"+ b.getStok() +"')");
           if (row > 0){
               cek = true;
           }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Insert Buku", JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }
    
    public boolean insertPeminjaman(Peminjaman p){
        connect();
        boolean cek = false;
        int row;
        try{
            java.text.DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
            String tglPinjam = df.format(p.getTgl_pinjam());
            String tglKembali = df.format(p.getTgl_kembali());
            
            row = stmt.executeUpdate("INSERT INTO peminjaman VALUES('"+ p.getId_pinjam() +"', "
                   + "'"+ p.getNis() +"', #"+ tglPinjam +"#, #"+ tglKembali +"#, "
                   + "'"+ p.getTotal_pinjam() +"')");
            if (row > 0){
                cek = true;
            }
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage(), "Insert", JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }

    public boolean insertPeminjaman_Det(Peminjaman_det p){
        connect();
        boolean cek = false;
        int row;
        try{
           row = stmt.executeUpdate("INSERT INTO peminjaman_det VALUES('"+ p.getId_pinjam() +"', '"+ p.getId_buku() +"', '"+ p.getJml() +"')");
           if (row > 0){
               cek = true;
           }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Insert", JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }
    
    public boolean insertPengembalian(Pengembalian p){
        connect();
        boolean cek = false;
        int row;
        try{
           row = stmt.executeUpdate("INSERT INTO pengembalian VALUES('"+ p.getId_kembali() +"', '"+ p.getId_pinjam() +"', "
                   + "'"+ p.getTgl_Kembali() +"', '"+ p.getDenda() +"', '"+ p.getTotal_kembali() +"')");
           if (row > 0){
               cek = true;
           }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Insert", JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }
    
    public boolean insertPengembalianDet(Pengembalian_det p){
        connect();
        boolean cek = false;
        int row;
        try{
           row = stmt.executeUpdate("INSERT INTO pengembalian_det VALUES('"+ p.getId_kembali() +"', '"+ p.getId_buku() +"', '"+ p.getJml() +"')");
           if (row > 0){
               cek = true;
           }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Insert", JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }
    
    //UPDATE STUFF
    
    public boolean updateMember(Member m){
        connect();
        boolean cek = false;
        int row;
        try {
            java.text.DateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
            String tgl = df.format(m.getTgl_lahir());

            row = stmt.executeUpdate("UPDATE member SET nama = '"+ m.getNama() +"', tempat_lahir = '"+ m.getTempat_lahir() +"', tgl_lahir = #"+ tgl +"#, jml_pinjam = '"+ m.getJml_pinjam() +"' WHERE nis = '"+ m.getNIS() +"'");
            if (row > 0){
                cek = true;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Update Member", JOptionPane.ERROR_MESSAGE);
        }
        disconnect();
        return cek;
    }
    
    public boolean updateBuku(Buku b){
        connect();
        boolean cek = false;
        int row;
        try {
            row = stmt.executeUpdate("UPDATE buku SET judul = '"+ b.getJudul() +"', penulis = '"+b.getPenulis()+"', penerbit = '"+ b.getPenerbit() +"', tahun = '"+ b.getTahun() +"', stok = '"+ b.getStok() +"' WHERE id_Buku = '"+ b.getIdbuku() +"'");
            if (row > 0){
                cek = true;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Update Buku", JOptionPane.ERROR_MESSAGE);
        }
        disconnect();
        return cek;
    }
    
    //DELETE STUFF
    
    public boolean deleteMember(String id){
        boolean cek = false;
        connect();
        int row;
        try {
            row = stmt.executeUpdate("DELETE FROM member WHERE nis = '" + id + "'");
            if (row > 0){
                cek = true;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Delete Member", JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }
    
    public boolean deleteBuku(String id){
        boolean cek = false;
        connect();
        int row;
        try {
            row = stmt.executeUpdate("DELETE FROM buku WHERE id_Buku = '" + id + "'");
            if (row > 0){
                cek = true;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Delete Buku", JOptionPane.ERROR_MESSAGE);
        }
        return cek;
    }
    
    //SEARCH STUFF
    
    public void cariBuku(String kategori, String keyword){
        connect();
        try {
            buku = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM buku WHERE "+ kategori +" LIKE '%" + keyword +"%'");
            while (rs.next()){
                buku.add(new Buku(rs.getString("id_buku"), rs.getString("judul"), rs.getString("penulis"), 
                        rs.getString("penerbit"), rs.getString("tahun"), rs.getInt("stok")));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Cari Buku", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Buku> getCariBuku(String kategori, String keyword){
        cariBuku(kategori, keyword);
        return buku;
    }
    
    public void cariMember(String kategori, String keyword){
        connect();
        try {
            member = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM member WHERE "+ kategori +" LIKE '%" + keyword +"%'");
            while (rs.next()){
                member.add(new Member(rs.getString("nis"), rs.getString("nama"), rs.getString("tempat_Lahir"), 
                        rs.getDate("tgl_Lahir"), rs.getInt("jml_Pinjam")));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Cari Member", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Member> getCariMember(String kategori, String keyword){
        cariMember(kategori, keyword);
        return member;
    }
    
    public void cariPeminjaman(String kategori, String keyword){
        connect();
        try {
            pinjam = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM peminjaman WHERE "+ kategori +" LIKE '%" + keyword +"%'");
            while (rs.next()){
                pinjam.add(new Peminjaman(rs.getString("id_Pinjam"), rs.getString("nis"), 
                        rs.getDate("tgl_Pinjam"), rs.getDate("tgl_Kembali"), 
                        rs.getInt("total_Pinjam")));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Cari Pinjam", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Peminjaman> getCariPeminjaman(String kategori, String keyword){
        cariPeminjaman(kategori, keyword);
        return pinjam;
    }
}
