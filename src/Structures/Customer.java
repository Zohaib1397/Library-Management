package Structures;

public class Customer extends User{
    public Customer(int userId, String userName, String password, boolean isAdmin) {
        super(userId, userName, password, isAdmin);
    }

    @Override
    public void viewBooks() {
        //TODO add implementation of view Books for Customer
    }

    @Override
    public void returnBook() {
        //TODO add implementation of return book initiated by the Customer
    }
}
