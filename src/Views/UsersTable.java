package Views;

import Structures.Admin;
import Structures.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UsersTable extends JFrame {
    DefaultTableModel tableModel;
    JButton goBack = new JButton("Go Back");

    public UsersTable(ArrayList<User> usersList) {
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(getSize());
        setTitle("Add User Page");
        Container panel = getContentPane();
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        tableModel = new DefaultTableModel(new Object[]{"ID", "USERNAME", "ADMIN"}, 0);
        for (User user : usersList) {
            tableModel.addRow(new Object[]{user.userId, user.userName, user.isAdmin});
        }
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup()
                        .addComponent(scrollPane)
                        .addComponent(goBack)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup()
                        .addComponent(scrollPane)
                        .addComponent(goBack)
        );
        pack();
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                UserView userView = new UserView();
                userView.setVisible(true);
            }
        });
    }
}
