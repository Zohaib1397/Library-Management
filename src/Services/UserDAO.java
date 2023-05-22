package Services;

import Structures.Admin;
import Structures.Customer;
import Structures.DAO;
import Structures.User;

import java.sql.*;
import java.util.List;

public class UserDAO implements DAO<User> {

    @Override
    public User get(String username, String password) throws SQLException {
        Connection connection = Database.getConnection();
        System.out.println(connection != null ? "Connected to network" : "Connection Failed");
        String query = "SELECT * FROM Users WHERE USERNAME = ? AND PASSWORD = ? ";
        assert connection != null;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        System.out.println(rs);
        if (rs.next()) {
            int id = rs.getInt("UID");
            String UserName = rs.getString("USERNAME");
            System.out.println(UserName);
            String Password = rs.getString("PASSWORD");
            boolean isAdmin = rs.getBoolean("ADMIN");
            /*---------------------------------
             * Based on the isAdmin value the object of user will return either the Admin or Customer
             * --------------------------------*/
            if (isAdmin) return new Admin(id, UserName, Password, true);
            else return new Customer(id, UserName, Password, false);
        }
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
//        Connection connection = Database.getConnection();
//        System.out.println(connection != null ? "Connected to network" : "Connection Failed");
//        String query = "SELECT * FROM Users";
//        assert connection != null;
//        PreparedStatement statement = connection.prepareStatement(query);
//        ResultSet rs = statement.executeQuery();
//        System.out.println(rs);
//        if (rs.next()) {
//            int id = rs.getInt("UID");
//            String UserName = rs.getString("USERNAME");
//            System.out.println(UserName);
//            String Password = rs.getString("PASSWORD");
//            boolean isAdmin = rs.getBoolean("ADMIN");
//            /*---------------------------------
//             * Based on the isAdmin value the object of user will return either the Admin or Customer
//             * --------------------------------*/
//            if (isAdmin) return new Admin(id, UserName, Password, true);
//            else return new Customer(id, UserName, Password, false);
//        }
        return null;
    }

    @Override
    public boolean insert(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }
}
