
package com.mycompany.emailsystemm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class EmailSystemm extends JFrame {

    // Box to write username
    private JTextField usernameField;

    // Box to write password (hidden)
    private JPasswordField passwordField;

    // Button to login
    private JButton btnLogin;

    // List of users
    private ArrayList<User> userList;

    // Make the login window
    public EmailSystemm(ArrayList<User> userList) {
        JFrame frame = this;
        this.userList = userList;

        // Window title and size
        frame.setTitle("Login Panel");
        frame.setSize(400, 250);
        frame.setLocation(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 

        // Text: Username
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(50, 30, 100, 25);

        // Text: Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(50, 70, 100, 25);

        // User writes username here
        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 180, 25);

        // User writes password here
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 180, 25);

        // Login button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 110, 100, 30);

        // Add parts to window
        frame.add(labelUsername);
        frame.add(labelPassword);
        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(btnLogin);

        // Click button → check login
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkLogin();
            }
        });

        // Show the window
        frame.setVisible(true);
    }

    // Check username and password
    private void checkLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Look in the user list
        for (User u : userList) {
            if (u.checkLogin(username, password)) {
                // if Correct, show message
                JOptionPane.showMessageDialog(this, "Login successful");

                // Open inbox, close this window
               new InboxView(u, userList, new EmailProcessing()).setVisible(true);
                dispose();
                return;
            }
        }

        // Wrong → show error
        JOptionPane.showMessageDialog(this, "Incorrect username or password.");
    }

    // Start program with test user
    public static void main(String[] args) {
        ArrayList<User> testUsers = new ArrayList<>();
        testUsers.add(new User("tarik", "1234", "tarik@email.com"));
         testUsers.add(new User("emir", "1234", "emir@email.com"));
          testUsers.add(new User("ahmet", "12345", "ahmet@email.com"));
        new EmailSystemm(testUsers);
    }
}
