package Views;

import Logic.Model;

import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame {
    JButton viewBooks = new JButton("View Books");
    JButton viewUsers = new JButton("View Users");
    JButton viewIssuedBooks = new JButton("View Issued Books");
    JButton issueBook = new JButton("Issue Book");
    JButton addUser = new JButton("Add User");
    JButton addBook = new JButton("Add Book");
    JButton returnBook = new JButton("Return Book");
    JButton createDatabase = new JButton("Create/Reset");

    public UserView() {
        setSize(300, 200);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Model.currentUser + "View");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(viewBooks);
        panel.add(viewUsers);
        panel.add(viewIssuedBooks);
        panel.add(issueBook);
        panel.add(addUser);
        panel.add(addBook);
        panel.add(returnBook);
        panel.add(createDatabase);
        add(panel);
        pack();
    }
}
