
package com.mycompany.emailsystemm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InboxView extends JFrame{


    // show welcome message
    private JLabel label;

    // go back button
    private JButton backButton;

    // button to send new email
    private JButton newEmailButton;

    // email list
    private JList<String> emailList;
    private DefaultListModel<String> listModel;

    private User currentUser;
    private ArrayList<User> userList;
    private EmailProcessing emailProcessing;

    // build the screen
    public InboxView(User currentUser, ArrayList<User> userList, EmailProcessing emailProcessing) {
        JFrame frame = this;

        this.currentUser = currentUser;
        this.userList = userList;
        this.emailProcessing = emailProcessing;

        // write welcome text
        label = new JLabel("Welcome, " + currentUser.getUsername());
        label.setBounds(100, 20, 200, 25);

        // create back button
        backButton = new JButton("Back");
        backButton.setBounds(50, 220, 100, 30);

        // create new email button
        newEmailButton = new JButton("New Email");
        newEmailButton.setBounds(200, 220, 120, 30);

        // create list model and fill with emails
        listModel = new DefaultListModel<>();
        ArrayList<Email> inboxEmails = emailProcessing.getInbox(currentUser.getUsername());
        for (Email e : inboxEmails) {
            listModel.addElement(e.toString());
        }

        // create JList with email data
        emailList = new JList<>(listModel);
        emailList.setBounds(50, 60, 300, 140);

        // add things to screen
        frame.add(label);
        frame.add(backButton);
        frame.add(newEmailButton);
        frame.add(emailList);

        // when back is clicked
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new EmailSystemm(userList);
               
               dispose();
            }
        });

        // when new email is clicked
        newEmailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SendEmailView(currentUser, userList, emailProcessing);
            }
        });

        // screen settings
        frame.setTitle("Inbox");
        frame.setSize(420, 320);
        frame.setLocation(500, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}