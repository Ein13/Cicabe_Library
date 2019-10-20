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
    
    
}
