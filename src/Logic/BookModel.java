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

    public boolean returnBook(int bid) {
        dao = new BookDAO();
        try {
            return dao.deleteFromReturnable(bid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertBook(Book book){
        try{
            return dao.insert(book);
        }catch(Exception e){
            return false;
        }
    }

}
