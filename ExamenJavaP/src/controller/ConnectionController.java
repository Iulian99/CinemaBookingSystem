package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionController {
    private Connection con;

    public ConnectionController() {
        String url = "jdbc:mysql://localhost:3306/myDatabase";
        try {
            con = DriverManager.getConnection(url,"root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final class SingletonHolder{
        private static final ConnectionController instance = new ConnectionController();
    }

    public static ConnectionController getInstance(){
        return SingletonHolder.instance;
    }

    public Connection getConnection(){
        return con;
    }
}
