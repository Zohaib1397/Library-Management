package Structures;

public abstract class User {
    public int userId;
    public String userName;
    private String password;
    public boolean isAdmin;

    public User(int userId, String userName, String password, boolean isAdmin) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    /*-----------------------------------------------
            The following two abstract functions will be implemented by the Customer and Admin classes and Admin
            will have his/her own operations as well so his View will also be different.
             ------------------------------------------------*/
    public abstract void viewBooks();
    public abstract void returnBook();
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
