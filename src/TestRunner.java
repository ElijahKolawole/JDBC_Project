import java.sql.SQLException;

public class TestRunner {
    public static void main(String[] args) {
        //System.out.println("My name is Adefemi Kolawole. I am a Java developer");
        System.out.println("**Connecting to database**..........");
        try {
           // DBConnection.connect();
            DBConnection2.connectToTable("students");
            System.out.println("************************************");
            DBConnection2.connectToTable("teacher");
        } catch (SQLException e) {
           // e.printStackTrace();
        }

    }
}
