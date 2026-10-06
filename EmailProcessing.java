
package com.mycompany.emailsystemm;

 import java.util.ArrayList;



// This class is used to manage emails, such as adding or displaying them.
public class EmailProcessing{

    private ArrayList<Email> allEmails; // This is where all emails are stored.

    // Constructor: Initializes the email list as empty
    public EmailProcessing(){
        allEmails = new ArrayList<Email>();
    }

    // When a new email is sent, it is received by this method and added to the list.
    public void sendEmail(Email newEmail){
        allEmails.add(newEmail);
    }

    // Returns the inbox of a specific user
    public ArrayList<Email> getInbox(String username){
        ArrayList<Email> inbox = new ArrayList<Email>();
        for (int i = 0; i < allEmails.size(); i++){
            Email selectedEmail = allEmails.get(i);
            if (selectedEmail.getRecipient().equals(username)){
                inbox.add(selectedEmail);
            }
        }
        return inbox;
    }

    // Displays all emails sent by a specific user
    public ArrayList<Email> getSended(String username){
        ArrayList<Email> sentEmails = new ArrayList<Email>();
        for (int i = 0; i < allEmails.size(); i++){
            Email selectedEmail = allEmails.get(i);
            if (selectedEmail.getSender().equals(username)){
                sentEmails.add(selectedEmail);
            }
        }
        return sentEmails;
    }   

    // Returns all emails in the system
    public ArrayList<Email> getAllEmails(){
        return allEmails;
    }  
}