package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Tomasz on 21.06.2017.
 */
public class MySqlConnector {

    private static final String DB = "jdbc:mysql://:3306/?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "";
    private static final String USERPW = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection connection;

    private static MySqlConnector ourInstance = new MySqlConnector();

    public static MySqlConnector getInstance() {
        return ourInstance;
    }

    private MySqlConnector() {
        try {
            Class.forName(DRIVER).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB, USER, USERPW);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getNewStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
