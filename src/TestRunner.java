import java.sql.SQLException;

public class TestRunner {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.toString());
        //System.out.println("My name is Adefemi Kolawole. I am a Java developer");
        System.out.println("**Connecting to database**..........");
        try {
           // DBConnection.connect();
            DBConnection.connectToTable("students");
            System.out.println("************************************");
            DBConnection.connectToTable("teacher");
        } catch (SQLException e) {
           // e.printStackTrace();
        }

    }
}
