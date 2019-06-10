import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private String dob;
    private String  classes;
    private String  email;

    public Student(){

    }

    public int getId() {
        return this.id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getDob() {
        return this.dob;
    }

    public String getClasses() {
        return this.classes;
    }

    public String getEmail() {
        return this.email;
    }

    public static void getStudents(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Student{" +
                    "id=" + resultSet.getInt("id") +
                    ", first_name='" + resultSet.getString("first_name")+ '\'' +
                    ", last_name='" + resultSet.getString("last_name") + '\'' +
                    ", dob='" + resultSet.getString("dob") + '\'' +
                    ", classes='" + resultSet.getInt("class") + '\'' +
                    ", email='" + resultSet.getString("email") + '\'' +
                    '}');
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob='" + dob + '\'' +
                ", classes='" + classes + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
