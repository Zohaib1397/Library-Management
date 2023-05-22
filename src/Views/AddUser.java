package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class AddUser extends JFrame {
    JTextField usernameField = new JTextField();
    JTextField passwordField = new JTextField();
    JRadioButton isAdmin = new JRadioButton("Is Admin");
    JRadioButton isNotAdmin = new JRadioButton("Not Admin");
    ButtonGroup btnGroup = new ButtonGroup();
    JButton save = new JButton("Save");
    JButton cancel = new JButton("Cancel");
    ListenerDetection listenerDetection = new ListenerDetection();

    public AddUser() {
        setSize(400, 220);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add User Page");
        Container panel = getContentPane();
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        save.addActionListener(listenerDetection);
        cancel.addActionListener(listenerDetection);
        btnGroup.add(isAdmin);
        btnGroup.add(isNotAdmin);
        isNotAdmin.setSelected(true);
        JLabel user = new JLabel("Username");
        JLabel pass = new JLabel("Password");
        JLabel role = new JLabel("Role");
        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(user)
                                        .addComponent(pass)
                                        .addComponent(role)
                                        .addComponent(save)
                        )
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(usernameField)
                                        .addComponent(passwordField)
                                        .addGroup(
                                                groupLayout.createSequentialGroup()
                                                        .addComponent(isAdmin)
                                                        .addComponent(isNotAdmin)
                                        )
                                        .addComponent(cancel)
                        ).addGap(50, 50, 50)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(user)
                                        .addComponent(usernameField, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(pass)
                                        .addComponent(passwordField, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(role)
                                        .addComponent(isAdmin)
                                        .addComponent(isNotAdmin)
                        )
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(save)
                                        .addComponent(cancel)
                        )
                        .addGap(50, 50, 50)
        );
    }

    void hideAddUserPage() {
        setVisible(false);
    }

    private class ListenerDetection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Save")) {
                try {
                    if (!usernameField.getText().equals("") && !passwordField.getText().equals("")) {
                        if (LoginPage.controller.addUser(usernameField.getText(), passwordField.getText(), isAdmin.isSelected())) {
                            hideAddUserPage();
                            UserView userView = new UserView();
                            userView.setVisible(true);
                        } else {
                            throw new IOException("Username already exists");
                        }
                    } else {
                        throw new IOException("Add User Fields must not be empty");
                    }
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, E.toString(), "Something went wrong", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                hideAddUserPage();
                UserView userView = new UserView();
                userView.setVisible(true);
            }
        }
    }
}
