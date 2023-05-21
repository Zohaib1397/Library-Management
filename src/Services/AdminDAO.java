package Services;

import Structures.Admin;
import Structures.DAO;

import java.sql.*;
import java.util.List;

public class AdminDAO implements DAO<Admin> {

    @Override
    public Admin get(String username, String password) throws SQLException {
        Connection connection = Database.getConnection();
        Admin admin = null;
        String query = "SELECT * FROM Users WHERE USERNAME=" + username + " AND PASSWORD=" + password;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(2, username);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("UID");
            String UserName = rs.getString("USERNAME");
            String Password = rs.getString("PASSWORD");
            boolean isAdmin = rs.getBoolean("ADMIN");
            admin = new Admin(id, UserName, Password, isAdmin);
        }
        return admin;
    }

    @Override
    public List<Admin> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insert(Admin admin) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        return false;
    }

    @Override
    public boolean update(Admin admin) throws SQLException {
        return false;
    }
}
