package Structures;

import Structures.Book;
import Structures.DAO;

import java.sql.SQLException;

public interface ExtendedBookDAO extends DAO<Book> {
    public boolean insertIssueBook(int bid, int uid, int period, String issueDate) throws SQLException;
}
