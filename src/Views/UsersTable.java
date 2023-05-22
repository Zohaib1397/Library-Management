package Views;

import Structures.Admin;
import Structures.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class UsersTable extends JFrame {
    DefaultTableModel tableModel;

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
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup()
                        .addComponent(scrollPane)
        );
        pack();
    }
}
