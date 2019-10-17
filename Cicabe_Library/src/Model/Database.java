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
    
    ArrayList<Petugas> petugas;
    ArrayList<Member> member;
    ArrayList<Buku> buku;
    ArrayList<Peminjaman> pinjam;
    ArrayList<Pengembalian> kembali;
    
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
                member.add(new Member(rs.getString("id_Pinjam"), rs.getString("nis"), rs.getString("tempat_Lahir"), 
                        rs.getDate("tgl_Lahir"), rs.getInt("jml_Pinjam")));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
