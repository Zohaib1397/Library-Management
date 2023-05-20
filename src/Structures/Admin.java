package Structures;

public class Admin extends User{

    public Admin(int userId, String userName, String password, boolean isAdmin) {
        super(userId, userName, password, isAdmin);
    }

    @Override
    public void viewBooks() {
        //TODO add implementation of view Books for admin
    }

    @Override
    public void returnBook() {
        //TODO add implementation of return Book to the library by the admin
    }
    public void viewUsers(){
        //TODO Add implementation of View Users
    }
    public void addBook(){
        //TODO add implementation of add Book by the admin
    }
    public void issueBook(){
        //TODO add implementation of the issue book by the admin
    }
    public void createDatabase(){
        //TODO implementation for Create/Reset Database as per requirements
    }
}
