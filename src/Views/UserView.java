package Views;

import Logic.Model;
import Structures.SelectedUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setSize(300, 200);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Model.currentUser + " View");
        JPanel panel = new JPanel(new FlowLayout());
        viewBooks.addActionListener(listenerDetection);
        viewUsers.addActionListener(listenerDetection);
        viewIssuedBooks.addActionListener(listenerDetection);
        issueBook.addActionListener(listenerDetection);
        addUser.addActionListener(listenerDetection);
        addBook.addActionListener(listenerDetection);
        returnBook.addActionListener(listenerDetection);
        createDatabase.addActionListener(listenerDetection);
        panel.add(viewBooks);
        if (Model.currentUser == SelectedUser.ADMIN) {
            panel.add(viewUsers);
            panel.add(viewIssuedBooks);
            panel.add(issueBook);
            panel.add(addUser);
            panel.add(addBook);
            panel.add(createDatabase);
        }
        panel.add(returnBook);
        add(panel);
        pack();
    }

    private class ListenerDetection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
