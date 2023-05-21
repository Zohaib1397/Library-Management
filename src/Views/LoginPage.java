package Views;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;

public class LoginPage extends JFrame {
    LoginPage() {
        setSize(400, 220);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Login Page");
        /*--------------------------------------------------
         * Buttons and labels initialization for login page
         * --------------------------------------------------*/
        JLabel userLabel = new JLabel("Username");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password");
        JTextField passField = new JTextField();
        JButton loginBTN = new JButton("Login");
        JButton cancelBTN = new JButton("Cancel");
        //Creating a container that fill up whole space
        Container panel = getContentPane();
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        /*--------------------------------------------
         * Using Group Layout to create UI
         * The structure pseudocode is as follows
         * horizontal axis = sequential group { parallel group {userLabel, passLabel, loginBTN} , parallel group {userField, passField, cancelBTN}}
         * vertical axis = sequential group { parallel group {userLabel, userField} , parallel group {passLabel, passField}, parallel group {loginBTN, cancelBTN}}
         * --------------------------------------------*/
        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(groupLayout.createParallelGroup(LEADING)
                                .addComponent(userLabel)
                                .addComponent(passLabel)
                                .addComponent(loginBTN)
                        )
                        .addGroup(groupLayout.createParallelGroup(TRAILING)
                                .addComponent(userField)
                                .addComponent(passField)
                                .addComponent(cancelBTN)
                        )
                        .addGap(50, 50, 50)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(userLabel)
                                .addComponent(userField, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(passLabel)
                                .addComponent(passField, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(loginBTN)
                                .addComponent(cancelBTN)
                        )
                        .addGap(50, 50, 50)
        );
        pack();

    }
    public static void main(String[] args){
        new LoginPage();
    }
}
