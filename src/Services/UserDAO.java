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
        String query = "SELECT * FROM Users WHERE USERNAME=" + username + " AND PASSWORD=" + password;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(2, username);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("UID");
            String UserName = rs.getString("USERNAME");
            String Password = rs.getString("PASSWORD");
            boolean isAdmin = rs.getBoolean("ADMIN");
            if (isAdmin) return new Admin(id, UserName, Password, true);
            else return new Customer(id, UserName, Password, false);
        }
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
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
