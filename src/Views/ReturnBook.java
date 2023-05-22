package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBook extends JFrame {
    JTextField bid = new JTextField();
    ListenerDetection listenerDetection = new ListenerDetection();
    JButton returnBTN = new JButton("Return");
    JButton cancel = new JButton("Cancel");

    public ReturnBook() {
        setSize(400, 220);
        setPreferredSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add User Page");
        Container panel = getContentPane();
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        returnBTN.addActionListener(listenerDetection);
        cancel.addActionListener(listenerDetection);
        JLabel label = new JLabel("Book ID(BID)");
        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(label)
                                        .addComponent(returnBTN)
                        )
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(bid)
                                        .addComponent(cancel)
                        ).addGap(50, 50, 50)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(label)
                                        .addComponent(bid, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(returnBTN)
                                        .addComponent(cancel)
                        )
                        .addGap(50, 50, 50)
        );
    }

    void hideReturnDialogue() {
        setVisible(false);
    }

    private class ListenerDetection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Return")) {
                if (!bid.getText().equals("")) {
                    if (LoginPage.controller.returnBook(Integer.parseInt(bid.getText()))) {
                        hideReturnDialogue();
                        UserView userView = new UserView();
                        userView.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot Return", "Book Not found", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                hideReturnDialogue();
                UserView userView = new UserView();
                userView.setVisible(true);
            }
        }
    }
}
