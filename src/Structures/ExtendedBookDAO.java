package Structures;

import java.sql.SQLException;

public interface ExtendedBookDAO extends DAO<Book> {
    public boolean insertIssueBook(int bid, int uid, int period, String issueDate) throws SQLException;

    public void insertToReturnable(Book book) throws SQLException;

    public boolean deleteFromReturnable(int bid) throws SQLException;
}
