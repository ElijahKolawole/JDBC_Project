import java.sql.*;
public class DBConnection2 {
    public static final String USERNAME="root";
    //public static final String PASSWORD="demouser=**";
    public static final String PASSWORD="";
    public static final String URL = "jdbc:mysql://localhost/demoproject";
    private static Connection connection = null;
    private static  Statement statement = null;
    private static  ResultSet resultSet = null;
    private static String table = "";
    private static boolean isConnected = false;

    public static void connect() throws SQLException {

        System.out.println("isConnected: " + isConnected);

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)
        ){
            DBConnection2.isConnected = true;
            System.out.println("SUCCESS : Connection established!!!" + "\nisConnected: " + isConnected + ", Current table: "+  table.toUpperCase());
        }
        catch (SQLException e){
            System.out.println("FAILURE: Error in connection" );
            System.err.print(e);
            //e.printStackTrace();
        }
    }
    public static void connectToTable(String table) throws SQLException {
        DBConnection2.table = table;
        //Statement statement = null;
        //ResultSet resultSet = null;
        try{
            connect(); //to the database
            getNumOfRows(table); // to a specific table in the database
            //getNumOfRows("teacher");
        }
        catch (SQLException e){
            System.out.println("FAILURE: Error in connection" );
            System.err.print(e);
            //e.printStackTrace();
        }

            System.out.println("isConnected: " + isConnected);
        }

    public static void getNumOfRows(String table) throws  SQLException{
        //connect();
        try(Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+ table);){
            DBConnection2.table = table;

            resultSet.last(); //get last line in result set
            System.out.println("There are currently " + resultSet.getRow() + " rows in "+ table + " table");
        }
        catch (SQLException e){
            System.out.println("Error_getNumOfRows" + e);
        }

    }

}
