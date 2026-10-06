
package com.mycompany.emailsystemm;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SendEmailView extends JFrame{
   

    private JComboBox<String> receiverComboBox;
    private JTextField subjectField;
    private JTextArea messageArea;
    private JButton sendButton;

    // screen to send email
    public SendEmailView(User sender, ArrayList<User> userList, EmailProcessing emailProcessor) {
        JFrame frame = this;

        // label for receiver
        JLabel receiverLabel = new JLabel("To:");
        receiverLabel.setBounds(30, 30, 50, 25);

        // dropdown for user selection
        receiverComboBox = new JComboBox<>();
        for (User user : userList) {
            if (!user.getUsername().equals(sender.getUsername())) {
                receiverComboBox.addItem(user.getUsername());
            }
        }
        receiverComboBox.setBounds(80, 30, 200, 25);

        // label for subject
        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(30, 70, 60, 25);

        // text field for subject
        subjectField = new JTextField();
        subjectField.setBounds(100, 70, 200, 25);

        // label for content
        JLabel messageLabel = new JLabel("Content:");
        messageLabel.setBounds(30, 110, 60, 25);

        // area to write message
        messageArea = new JTextArea();
        messageArea.setBounds(100, 110, 250, 100);

        // send button
        sendButton = new JButton("Send");
        sendButton.setBounds(150, 230, 100, 30);

        // add all components
        frame.add(receiverLabel);
        frame.add(receiverComboBox);
        frame.add(subjectLabel);
        frame.add(subjectField);
        frame.add(messageLabel);
        frame.add(messageArea);
        frame.add(sendButton);

        // click send button
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String receiver = receiverComboBox.getSelectedItem().toString();
                String subject = subjectField.getText();
                String content = messageArea.getText();

                Email newEmail = new Email(sender.getUsername(), receiver, subject, content);
                emailProcessor.sendEmail(newEmail);

                JOptionPane.showMessageDialog(frame, "Email sent");
                frame.dispose();
                
                //go back to inbox
            }
        });

        // window settings
        frame.setTitle("Send Email");
        frame.setSize(420, 330);
        frame.setLocation(500, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}