package Services;

import Structures.Admin;
import Structures.Book;
import Structures.Customer;
import Structures.ExtendedBookDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO implements ExtendedBookDAO {
    @Override
    public Book get(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public Book search(String data) throws SQLException {
        Connection connection = Database.getConnection();
        System.out.println(connection != null ? "Connected to network" : "Connection Failed");
        String query = "SELECT * FROM Books WHERE BID = ?";
        assert connection != null;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, Integer.parseInt(data));
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            int bid = rs.getInt("BID");
            String bookName = rs.getString("BNAME");
            String genre = rs.getString("GENRE");
            int price = rs.getInt("PRICE");
            return new Book(bid, bookName, genre, price);
        }
        return null;
    }

    @Override
    public ArrayList<Book> getAll() throws SQLException {

        return null;
    }

    @Override
    public boolean insert(Book book) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Book book) throws SQLException {
        Connection connection = Database.getConnection();
        String query = "DELETE FROM Books WHERE BID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, book.bookId);
        int row = ps.executeUpdate();
        return true;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        return false;
    }

    @Override
    public boolean insertIssueBook(int bid, int uid, int period, String issueDate) throws SQLException {
        //The if statement search for the presence of the book in the Book Table and return null if it is not found
        Book book = search(String.valueOf(bid));
        if (book != null) {
            Connection connection = Database.getConnection();
            String query = "INSERT INTO IssuedBooks(BID,UID,PERIOD,DATE)VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bid);
            ps.setInt(2, uid);
            ps.setInt(3, period);
            ps.setString(4, issueDate);
            int row = ps.executeUpdate();
            //Delete the previous book from the book record
            delete(new Book(bid, "sample", "sample", 0));
            insert(book); //insert book into the Database of Issued Books
            return true;
        } else return false;
    }
}
