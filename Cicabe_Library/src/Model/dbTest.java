package Model;

public class dbTest {
    public static void main(String[] args) {
        Database db = new Database();
        db.loadMember();
        System.out.println(db.member);
    }
}








