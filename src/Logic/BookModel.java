package Logic;

import Services.BookDAO;
import Structures.Book;

import javax.swing.*;
import java.sql.SQLException;

public class BookModel {
    BookDAO dao;

    public boolean issueBook(int bid, int uid, int period, String issueDate) {
        dao = new BookDAO();
        try {
            return dao.insertIssueBook(bid, uid, period, issueDate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Something went wrong", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
