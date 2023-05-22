package Views;

import Services.BookDAO;
import Services.Database;
import Structures.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;

public class IssueBook extends JFrame {
    JLabel bid = new JLabel("Book ID(BID)");
    JTextField bidField = new JTextField();
    JLabel uid = new JLabel("User ID(UID)");
    JLabel period = new JLabel("Period(Days)");
    JLabel issueDate = new JLabel("Issued Date(DD-MM-YYYY)");
    JTextField uidField = new JTextField();
    JTextField periodField = new JTextField();
    JTextField issueDateField = new JTextField();
    JButton submit = new JButton("Submit");
    JButton cancelBTN = new JButton("Cancel");

    public IssueBook() {
        setSize(400, 300);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ListenerDetection listenerDetection = new ListenerDetection();
        setVisible(true);
        setTitle("Login Page");
        submit.addActionListener(listenerDetection);
        cancelBTN.addActionListener(listenerDetection);
        //Creating a container that fill up whole space
        Container panel = getContentPane();
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        /*--------------------------------------------
         * Using Group Layout to create UI
         * --------------------------------------------*/
        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(groupLayout.createParallelGroup(LEADING)
                                .addComponent(bid)
                                .addComponent(uid)
                                .addComponent(period)
                                .addComponent(issueDate)
                                .addComponent(submit)
                        )
                        .addGroup(groupLayout.createParallelGroup(TRAILING)
                                .addComponent(bidField)
                                .addComponent(uidField)
                                .addComponent(periodField)
                                .addComponent(issueDateField)
                                .addComponent(cancelBTN)
                        )
                        .addGap(50, 50, 50)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(bid)
                                .addComponent(bidField, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(uid)
                                .addComponent(uidField, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(period)
                                .addComponent(periodField, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(issueDate)
                                .addComponent(issueDateField, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(submit)
                                .addComponent(cancelBTN)
                        )
                        .addGap(50, 50, 50)
        );
        pack();
    }

    void hideIssueBookPage() {
        setVisible(false);
    }

    private class ListenerDetection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                if (!bidField.getText().equals("") && !uidField.getText().equals("") && !periodField.getText().equals("") && !issueDateField.getText().equals("")) {
                    if (LoginPage.controller.issueBook(Integer.parseInt(bidField.getText()), Integer.parseInt(uidField.getText()), Integer.parseInt(periodField.getText()), issueDateField.getText())) {
                        hideIssueBookPage();
                        UserView userView = new UserView();
                        userView.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Something Went wrong", "Database Issue", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fill the fields first", "Fields Empty Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                hideIssueBookPage();
                UserView userView = new UserView();
                userView.setVisible(true);
            }
        }
    }
}


//    @Override
//    public void addBook(Book book) {
//        try (Connection connection = Database.getConnection();
//             PreparedStatement statement = connection.prepareStatement("INSERT INTO books (title, author, quantity) VALUES (?, ?, ?)")) {
//            statement.setString(1, book.getBookName());
////            statement.setString(2, book.getAuthor());
////            statement.setInt(3, book.getQuantity());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<Book> getAllBooks() {
//        List<Book> books = new ArrayList<>();
//        try (Connection connection = Database.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery("SELECT * FROM books")) {
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String title = resultSet.getString("title");
////                String author = resultSet.getString("author");
//                int quantity = resultSet.getInt("quantity");
//                Book book = new Book();
//                book.setBookId(id);
//                book.setBookName(title);
////                book.setAuthor(author);
////                book.setQuantity(quantity);
//                books.add(book);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return books;
//    }
//
//    @Override
//    public List<Book> getIssuedBooks() {
//        List<Book> issuedBooks = new ArrayList<>();
//        return issuedBooks;
//    }