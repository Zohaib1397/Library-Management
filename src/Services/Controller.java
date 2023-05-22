package Services;

import Logic.Model;
import Structures.DAO;
import Structures.User;

import java.sql.SQLException;

public class Controller {
    User user;
    Model model;

    public Controller() {
        model = new Model();
    }

    public boolean authenticateUser(String username, String password) throws SQLException {
        return model.authenticateUser(username, password);
    }

    public boolean addUser(String username, String password, boolean isAdmin) throws SQLException {
        return model.addUser(username, password, isAdmin);
    }
}
