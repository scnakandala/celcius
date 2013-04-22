package dataaccess;

import celcius.Config;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDataAccess {

    private static Connection connect;
    private static Statement statement;
    private static UsersDataAccess instance;
    private ResultSet resultSet;

    private UsersDataAccess() throws SQLException {
        connect = (Connection) DriverManager.getConnection(Config.connectionString);

    }

    public static UsersDataAccess getInstance() throws SQLException {
        if (UsersDataAccess.instance == null) {
            UsersDataAccess.instance = new UsersDataAccess();
        }
        return UsersDataAccess.instance;
    }

    public String getPassword(String username) throws SQLException{
        statement = (Statement) connect.createStatement();
        String sql = "select password from celcius.users where username ='" + username + "'";
        resultSet = statement.executeQuery(sql);
        resultSet.next();
        return resultSet.getString("password");
    }
}
