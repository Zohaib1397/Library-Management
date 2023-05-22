package Services;

import Logic.BookModel;
import Logic.UserModel;
import Structures.Book;
import Structures.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    User user;
    UserModel userModel;
    BookModel bookModel;

    /*---------------------------------
     * The following section is for the user functions
     * --------------Start-------------------*/
    public Controller() {
        userModel = new UserModel();
        bookModel = new BookModel();
    }

    public boolean authenticateUser(String username, String password) throws SQLException {
        return userModel.authenticateUser(username, password);
    }

    public boolean addUser(String username, String password, boolean isAdmin) throws SQLException {
        return userModel.addUser(username, password, isAdmin);
    }

    public ArrayList<User> getAllUsers() {
        return userModel.getAllUsers();
    }

    /*---------------END--------------------
     * The following section is for the Book functions
     * --------------Start-------------------*/
    public boolean issueBook(int bid, int uid, int period, String issueDate) {
        return bookModel.issueBook(bid, uid, period, issueDate);
    }

    public boolean returnBook(int bid) {
        return bookModel.returnBook(bid);
    }

}
