package Views;

import Logic.UserModel;
import Structures.SelectedUser;
import Structures.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserView extends JFrame {
    JButton viewBooks = new JButton("View Books");
    JButton viewUsers = new JButton("View Users");
    JButton viewIssuedBooks = new JButton("View Issued Books");
    JButton issueBook = new JButton("Issue Book");
    JButton addUser = new JButton("Add User");
    JButton addBook = new JButton("Add Book");
    JButton returnBook = new JButton("Return Book");
    JButton createDatabase = new JButton("Create/Reset");
    ListenerDetection listenerDetection = new ListenerDetection();
    public UserView() {
        setSize(550, 150);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(UserModel.currentUser + " View");
        Container panel = getContentPane();
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        viewBooks.addActionListener(listenerDetection);
        viewUsers.addActionListener(listenerDetection);
        viewIssuedBooks.addActionListener(listenerDetection);
        issueBook.addActionListener(listenerDetection);
        addUser.addActionListener(listenerDetection);
        addBook.addActionListener(listenerDetection);
        returnBook.addActionListener(listenerDetection);
        createDatabase.addActionListener(listenerDetection);
        if (UserModel.currentUser == SelectedUser.ADMIN) {
            groupLayout.setHorizontalGroup(
                    groupLayout.createSequentialGroup()
                            .addGroup(
                                    groupLayout.createParallelGroup()
                                            .addComponent(viewBooks)
                                            .addComponent(addUser)
                            )
                            .addGroup(
                                    groupLayout.createParallelGroup()
                                            .addComponent(viewUsers)
                                            .addComponent(addBook)
                            )
                            .addGroup(
                                    groupLayout.createParallelGroup()
                                            .addComponent(viewIssuedBooks)
                                            .addComponent(returnBook)
                            )
                            .addGroup(
                                    groupLayout.createParallelGroup()
                                            .addComponent(issueBook)
                                            .addComponent(createDatabase)
                            )

            );
            groupLayout.setVerticalGroup(
                    groupLayout.createSequentialGroup()
                            .addGroup(
                                    groupLayout.createParallelGroup()
                                            .addComponent(viewBooks)
                                            .addComponent(viewUsers)
                                            .addComponent(viewIssuedBooks)
                                            .addComponent(issueBook)
                            )
                            .addGroup(
                                    groupLayout.createParallelGroup()
                                            .addComponent(addUser)
                                            .addComponent(addBook)
                                            .addComponent(returnBook)
                                            .addComponent(createDatabase)
                            )
            );
        } else {
            groupLayout.setHorizontalGroup(
                    groupLayout.createSequentialGroup()
                            .addGroup(
                                    groupLayout.createParallelGroup()
                                            .addComponent(viewBooks)
                                            .addComponent(returnBook)
                            )

            );
            groupLayout.setVerticalGroup(
                    groupLayout.createSequentialGroup()
                            .addGroup(
                                    groupLayout.createParallelGroup()
                                            .addComponent(viewBooks)
                            )
                            .addGroup(
                                    groupLayout.createParallelGroup()
                                            .addComponent(returnBook)
                            )
            );
        }
        pack();
    }

    void hideUserView() {
        setVisible(false);
    }

    private class ListenerDetection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add User")) {
                hideUserView();
                AddUser addUser = new AddUser();
                addUser.setVisible(true);
            } else if (e.getActionCommand().equals("View Users")) {
                ArrayList<User> usersList = LoginPage.controller.getAllUsers();
                UsersTable usersTable = new UsersTable(usersList);
                hideUserView();
                usersTable.setVisible(true);
            } else if (e.getActionCommand().equals("Issue Book")) {
                hideUserView();
                IssueBook issueBook = new IssueBook();
                issueBook.setVisible(true);
            } else if (e.getActionCommand().equals("Return Book")) {
                hideUserView();
                ReturnBook returnBook = new ReturnBook();
                returnBook.setVisible(true);
            } else if (e.getActionCommand().equals("Add Book")) {
                AddBook addBook = new AddBook();
                hideUserView();
                ;
                addBook.setVisible(true);
            }
        }
    }
}
