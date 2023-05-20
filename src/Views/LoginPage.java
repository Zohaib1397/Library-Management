package Views;

import javax.swing.*;

public class LoginPage extends JFrame {
    LoginPage(){
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Login Page");

    }
    public static void main(String[] args){
        new LoginPage();
    }
}
