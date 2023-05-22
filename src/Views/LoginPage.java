package Views;

import Services.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;

public class LoginPage extends JFrame {
    public static Controller controller = new Controller();
    /*--------------------------------------------------
     * Buttons and labels initialization for login page
     * --------------------------------------------------*/
    JLabel userLabel = new JLabel("Username");
    JTextField userField = new JTextField();
    JLabel passLabel = new JLabel("Password");
    JTextField passField = new JTextField();
    JButton loginBTN = new JButton("Login");
    JButton cancelBTN = new JButton("Cancel");

    LoginPage() {
        setSize(400, 220);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ListenerDetection listenerDetection = new ListenerDetection();
        setVisible(true);
        setTitle("Login Page");
        loginBTN.addActionListener(listenerDetection);
        cancelBTN.addActionListener(listenerDetection);
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

    void hideLoginPage() {
        setVisible(false);
    }

    private class ListenerDetection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Login")) {
                //Check if the fields are empty
                //throw exception based on the condition
                try {
                    if (!userField.getText().equals("") && !passField.getText().equals("")) {
                        /*
                         * if login record found in the database
                         * then go to the userView page
                         * before proceeding any further the user must be identified if he/she is an admin or just a customer
                         * The implementation of detection is performed in controller -> model -> authenticateUser()
                         * */
                        if (controller.authenticateUser(userField.getText(), passField.getText())) {
                            hideLoginPage();
                            UserView userView = new UserView();
                            userView.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "User record not found", "Code 404", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        throw new IOException("Login Fields must not be empty");
                    }
                } catch (IOException E) {
                    JOptionPane.showMessageDialog(null, E.toString(), "Fields Empty Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
