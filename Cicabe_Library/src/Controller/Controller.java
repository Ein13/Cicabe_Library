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
    
    //LOAD STUFF
    
    public ArrayList loadAdmin(){
        ArrayList<Petugas> admin = new ArrayList();
        admin = db.getPetugas();
        return admin;
    }
    
    public ArrayList loadMember(){
        ArrayList<Member> member = new ArrayList();
        member = db.getMember();
        return member;
    }
    
    public ArrayList loadBuku(){
        ArrayList<Buku> buku = new ArrayList();
        buku = db.getBuku();
        return buku;
    }
    
    public ArrayList loadPeminjaman(){
        ArrayList<Peminjaman> pinjam = new ArrayList();
        pinjam = db.getPinjam();
        return pinjam;
    }
    
    public ArrayList loadPengembalian(){
        ArrayList<Pengembalian> kembali = new ArrayList();
        kembali = db.getKembali();
        return kembali;
    }
    
    public DefaultTableModel loadTableMember(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"NIS", "Nama", "Tempat Lahir", "Tgl Lahir", "Jumlah Pinjam"}, 0);
        ArrayList<Member> member = loadMember();
        
        for(Member m : member){
            model.addRow(new Object[]{m.getNIS(), m.getNama(), m.getTempat_lahir(), m.getTgl_lahir(), m.getJml_pinjam()});
            
        }
        return model;
    }
    
    //INSERT STUFF
    
    public boolean addMember(Member m){
        ArrayList<Member> member = loadMember();
        
        for (Member mem : member){
            if (m.getNIS().equals(mem.getNIS())){
                return false;
            }
        }
        
        if (db.insertMember(m)){
            return true;
        }
        return false;
    }
    
    public boolean addBuku(Buku b){
        ArrayList<Buku> buku = loadBuku();
        
        for (Buku buk : buku){
            if (buk.getIdbuku().equals(b.getIdbuku())){
                return false;
            }
        }
        
        if (db.insertBuku(b)){
            return true;
        }
        return false;
    }
    
    //CEK CEK RICEK
    
    public boolean cekLogin(String user, String pass){
        ArrayList<Petugas> admin = loadAdmin();
        for (Petugas a : admin){
            if (a.getUsername().equals(user) && a.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    
    public boolean cekMember(String nis){
        ArrayList<Member> member = loadMember();
        for (Member m : member){
            if (m.getNIS().equals(nis)){
                return true;
            }
        }
        return false;
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
