import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {
    static Connection connection=null;
    public Connection getConnection(){
        if(connection!=null){
            return connection;
        }
        String user="root";
        String pwd="chauhans";
        String db="searchengineapp";
        return getConnection(user,pwd,db);
    }
    private Connection getConnection(String user,String pwd,String db){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =DriverManager.getConnection("jdbc:mysql://localhost/"+db+"?user="+user+"&password="+pwd);
            return connection;

        }
        catch(SQLException | ClassNotFoundException sqlException){
            sqlException.printStackTrace();
        }
        return connection;
    }
}
