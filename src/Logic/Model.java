package Logic;

import Services.UserDAO;
import Structures.DAO;
import Structures.SelectedUser;
import Structures.User;

import java.sql.SQLException;

public class Model {
    private DAO dao;
    public static SelectedUser currentUser = SelectedUser.ADMIN;
//    public boolean authenticateUser(String username, String password) throws SQLException {
//        dao = new UserDAO();
////        User user = dao.get(username,password);
//
//    }
}
