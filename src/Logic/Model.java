package Logic;

import Services.UserDAO;
import Structures.DAO;
import Structures.SelectedUser;
import Structures.User;

import javax.swing.*;
import java.sql.SQLException;

public class Model {
    /*------------------------------------------------------------
     * This following static function maintain the record of current user it will detect based on the database
     * if the database isAdmin is false then the current user will automatically be switched to the customer status
     * in general it is a State Management Object
     * -----------------------------------------------------------*/
    public static SelectedUser currentUser = SelectedUser.ADMIN;

    public boolean authenticateUser(String username, String password) throws SQLException {
        UserDAO dao = new UserDAO();
        try {
            User user = dao.get(username, password);
            if (user == null) return false;
            currentUser = user.isAdmin ? SelectedUser.ADMIN : SelectedUser.CUSTOMER;
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Something went wrong", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
