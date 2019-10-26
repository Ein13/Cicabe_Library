package Controller;
import Model.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Controller {
    private Database db = new Database();
    private Petugas admin_log;
    private Member member_log;
    private Buku buku_log;
    private Peminjaman peminjaman_log;
    private Peminjaman_det peminjaman_det_log;
    private Pengembalian pengembalian_log;
    private Pengembalian_det pengembalian_det_log;
    
    //BASIC LOAD STUFF///////////////////////////////////////////////////////////////////////////////
    
    public ArrayList loadAdmin(){
        ArrayList<Petugas> admin = db.getPetugas();
        return admin;
    }
    
    public ArrayList loadMember(){
        ArrayList<Member> member = db.getMember();
        return member;
    }
    
    public ArrayList loadBuku(){
        ArrayList<Buku> buku = db.getBuku();
        return buku;
    }
    
    public ArrayList loadPeminjaman(){
        ArrayList<Peminjaman> pinjam = db.getPinjam();
        return pinjam;
    }
    
    public ArrayList loadPengembalian(){
        ArrayList<Pengembalian> kembali = db.getKembali();
        return kembali;
    }
    
    //LOAD TABLE STUFF///////////////////////////////////////////////////////////////////////////////
    
    public DefaultTableModel loadTableMember(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"NIS", "Nama", "Tempat Lahir", "Tgl Lahir", "Jumlah Pinjam"}, 0);
        ArrayList<Member> member = loadMember();
        
        member.forEach((m) -> {
            model.addRow(new Object[]{m.getNIS(), m.getNama(), m.getTempat_lahir(), m.getTgl_lahir(), m.getJml_pinjam()});
        });
        return model;
    }
    
    public DefaultTableModel loadTableBuku(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Judul", "Penulis", "Penerbit", "Tahun", "Stok"}, 0);
        ArrayList<Buku> buku = loadBuku();
        
        buku.forEach((b) -> {
            model.addRow(new Object[]{b.getIdbuku(), b.getJudul(), b.getPenulis(), b.getPenerbit(), b.getTahun(), b.getStok()});
        });
        return model;
    }
    
    public DefaultTableModel loadTablePeminjaman(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Pinjam", "NIS", "Tgl Pinjam", "Tgl Kembali", "Total Pinjam"}, 0);
        ArrayList<Peminjaman> pinjam = loadPeminjaman();
        
        pinjam.forEach((pin) -> {
            model.addRow(new Object[]{pin.getId_pinjam(), pin.getNis(), pin.getTgl_pinjam(), pin.getTgl_kembali(), pin.getTotal_pinjam()});
        });
        return model;
    }
    
    //INSERT STUFF///////////////////////////////////////////////////////////////////////////////
    
    public boolean addMember(Member m){
        ArrayList<Member> member = loadMember();
        
        if (!member.stream().noneMatch((mem) -> (m.getNIS().equals(mem.getNIS())))) {
            return false;
        }
        
        return db.insertMember(m);
    }
    
    public boolean addBuku(Buku b){
        ArrayList<Buku> buku = loadBuku();
        
        if (!buku.stream().noneMatch((buk) -> (buk.getIdbuku().equals(b.getIdbuku())))) {
            return false;
        }
        
        return db.insertBuku(b);
    }
    
    //DELETE STUFF///////////////////////////////////////////////////////////////////////////////
    
    public boolean deleteBuku(String id){
        return db.deleteBuku(id);
    }
    
    public boolean deleteMember(String nis){
        return db.deleteMember(nis);
    }
    
    //EDIT STUFF/////////////////////////////////////////////////////////////////////////////////
    
    public boolean updateBuku(Buku b){
        boolean cek = false;
        ArrayList<Buku> buku = loadBuku();
        
        for (Buku buk : buku){
            if (buk.getIdbuku().equals(b.getIdbuku())){
                db.updateBuku(b);
                cek = true;
            }
        }
        
        buku = loadBuku();
        return cek;
    }    
  
    public boolean updateMember(Member m){
        boolean cek = false;
        ArrayList<Member> member = loadMember();
        
        for (Member mem : member){
            if (mem.getNIS().equals(m.getNIS())){
                db.updateMember(m);
                cek = true;
            }
        }
        
        member = loadMember();
        return cek;
    } 
    
    //CEK CEK RICEK//////////////////////////////////////////////////////////////////////////////
    
    public boolean cekLogin(String user, String pass){
        ArrayList<Petugas> admin = loadAdmin();
        for (Petugas a : admin){
            System.out.println(a.getUsername());
            System.out.println(a.getPassword());
            if (a.getUsername().equals(user) && a.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    
    public boolean cekMember(String nis){
        ArrayList<Member> member = loadMember();
        return member.stream().anyMatch((m) -> (m.getNIS().equals(nis)));
    }
    
    //SEARCH STUFF///////////////////////////////////////////////////////////////////////////////
    
    public DefaultTableModel searchBuku(String kategori, String keyword){
        ArrayList<Buku> buku = db.getCariBuku(kategori, keyword);
        
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Judul", "Penulis", "Penerbit", "Tahun", "Stok"}, 0);      
        
        buku.forEach((b) -> {
            model.addRow(new Object[]{b.getIdbuku(), b.getJudul(), b.getPenulis(), b.getPenerbit(), b.getTahun(), b.getStok()});
        });
        return model;
    }
    
    public DefaultTableModel searchMember(String kategori, String keyword){
        ArrayList<Member> member = db.getCariMember(kategori, keyword);
        
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"NIS", "Nama", "Tempat Lahir", "Tgl Lahir", "Jumlah Pinjam"}, 0);
        
        member.forEach((m) -> {
            model.addRow(new Object[]{m.getNIS(), m.getNama(), m.getTempat_lahir(), m.getTgl_lahir(), m.getJml_pinjam()});
        });
        return model;
    }   
  
    
    
    
                    //nyimpen code disini biar ga lupa, JANGAN DIHAPUS
    
                        /*StringBuilder sb = new StringBuilder(e.toString());
                    for (StackTraceElement ste : e.getStackTrace()) {
                        sb.append("\n\tat ");
                        sb.append(ste);
                    }
                    String trace = sb.toString();   
                    JOptionPane.showMessageDialog(editmember, trace, "Edit Member",  JOptionPane.ERROR_MESSAGE);                
                    */ 
}
