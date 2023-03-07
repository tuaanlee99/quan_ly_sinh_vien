package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/thuctap", "root", "tuan99");

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return connection;
    }
}

