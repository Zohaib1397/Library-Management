package Services;

import Logic.Model;
import Structures.DAO;
import Structures.User;

public class Controller {
    User user;
    Model model;

    Controller() {
        model = new Model();
    }

    public boolean authenticateUser(String username, String password) {
        return true;
    }
}
