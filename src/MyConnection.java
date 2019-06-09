import java.sql.*;
public class MyConnection {
    public static final String USERNAME="root";
    //public static final String PASSWORD="demouser=**";
    public static final String PASSWORD="";
    public static final String URL = "jdbc:mysql://localhost/demoproject";
    private static Connection connection = null;
    private static  Statement statement = null;
    private static  ResultSet resultSet = null;
    private static String table = "";
    private static boolean isConnected = false;
    public MyConnection(){
    }


    public static void connect() throws SQLException {
        System.out.println("isConnected: " + isConnected);

        //String table = "";
        //Statement statement = null;
        //ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            isConnected = true;
            System.out.println("SUCCESS : Connection established!!!" + "\nisConnected: " + isConnected);
        }
        catch (SQLException e){
            System.out.println("FAILURE: Error in connection" );
            System.err.print(e);
            //e.printStackTrace();
        }

    }

    public static void connectToTable(String table) throws SQLException {
        MyConnection.table = table;
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
        finally {
            if (connection != null){
                connection.close();
                isConnected=false;
            }
            //System.out.println(isConnected);
        }
    }
    public static void getNumOfRows(String table) throws  SQLException{
        //connect();
        MyConnection.table = table;
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery("SELECT * FROM "+ table);
        resultSet.last(); //get last line in result set
        System.out.println("There are currently " + resultSet.getRow() + " rows in "+ table + " table");
    }
    public static boolean getIsConnected(){
        return isConnected;
    }
}
