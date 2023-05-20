package Structures;

public class Book {
    public int bookId;
    public String bookName;
    public String bookGenre;
    public int bookPrice;

    public Book(int bookId, String bookName, String bookGenre, int bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.bookPrice = bookPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }
}
