package Model;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;


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
            System.out.println("Connected");
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
    
    public void loadAdmin(){
        connect();
        try{
            admin = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM peminjaman_det");
            while(rs.next()){
                admin.add(new Petugas(rs.getString("id"), rs.getString("nama"), 
                        rs.getString("username"), rs.getString("password")));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
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
        } catch(Exception e){
            e.printStackTrace();
        }
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
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loadPinjam(){
        connect();
        try{
            pinjam = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM peminjaman");
            while(rs.next()){
                pinjam.add(new Peminjaman(rs.getString("id_Pinjam"), rs.getString("nis"), 
                        rs.getDate("tempat_Lahir"), rs.getDate("tgl_Lahir"), 
                        rs.getInt("jml_Pinjam")));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loadPinjamDet(){
        connect();
        try{
            pinjamDet = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM peminjaman_det");
            while(rs.next()){
                pinjamDet.add(new Peminjaman_det(rs.getString("id_Pinjam"), 
                        rs.getString("id_Buku"), rs.getInt("jml")));
            }
        } catch(Exception e){
            e.printStackTrace();
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
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loadKembaliDet(){
        connect();
        try{
            kembaliDet = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM pengembalian_det");
            while(rs.next()){
                kembaliDet.add(new Pengembalian_det(rs.getString("id_Kembali"), rs.getString("id_Buku"), rs.getInt("jml")));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
