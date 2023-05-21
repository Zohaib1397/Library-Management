package Services;

import Structures.Book;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);

    List<Book> getAllBooks();

    List<Book> getIssuedBooks();
}
