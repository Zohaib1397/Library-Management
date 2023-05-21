package Services;

/*
* To connect to your database use these details;
    Host: sql12.freesqldatabase.com
    Database name: sql12619829
    Database user: sql12619829
    Database password: gPVD5DFyqs
    Port number: 3306
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12619829";
    private static final String user = "sql12619829";
    private static final String password = "gPVD5DFyqs";

    Database() {

    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
