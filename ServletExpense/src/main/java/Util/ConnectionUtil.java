package Util;

import Constants.MySqlConstants;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Constants.MySqlConstants.*;

public class ConnectionUtil {

    @Getter
private static Connection connection;
    static {
        try {
            Class.forName(MySqlConstants.MYSQL_DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Class Not Found");
        } catch (SQLException e) {
            System.out.println("Invalid Credentials");
        }
    }

}
