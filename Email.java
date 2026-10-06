package com.mycompany.emailsystemm;

import java.time.LocalDateTime;

/**
 *
 * @author mery
 */
public class Email {
    
    
    // keeps sender,recipient,subject and content
    private String sender;        // the sender of the email
    private String recipient;     // the recipient of the email
    private String subject;        
    private String content;         
    private LocalDateTime sendingTime; // The date and time information automatically recorded when the email is created.
   

    // (constructor). when new Email entered, the corresponding datas are taken.
    public Email(String sender, String recipient, String subject, String content){
        this.setSender(sender);
        this.setRecipient(recipient);
        this.setSubject(subject);
        this.setContent(content);
        this.sendingTime = LocalDateTime.now(); // It takes the current date and time when the email is created.
    }

    // Getter and setter methods
    public String getSender(){
        return sender;
     }
    
     // A method that prevents null or empty values from being entered when creating an email.
    public void setSender(String sender){
        if (sender == null){
            this.sender = "(no sender)";
        } else if (sender.equals("")){
            this.sender = "(empty sender)";
        } else{
            this.sender = sender;
        }
    }

    public String getRecipient(){
        return recipient;
    }
     
     // A method that prevents null or empty values from being entered when creating an email.
    public void setRecipient(String recipient){
        if (recipient == null){
            this.recipient = "(no recipient)";
        } else if (recipient.equals("")) {
            this.recipient = "(empty recipient)";
        } else{
            this.recipient = recipient;
        }
    }

    public String getSubject(){
        return subject;
    }
    
     // A method that prevents null or empty values from being entered when creating an email.
    public void setSubject(String subject){
        if (subject == null){
            this.subject = "(no subject)";
        } else if (subject.equals("")){
            this.subject = "(empty subject)";
        } else{
            this.subject = subject;
        }
    }

    public String getContent(){
        return content;
    }
    
     // A method that prevents null or empty values from being entered when creating an email.
    public void setContent(String content){
        if (content == null){
            this.content = "(no content)";
        } else if(content.equals("")){
            this.content = "(empty content)";
        } else{
            this.content = content;
        }
    }

    public LocalDateTime getSendingTime(){
        return sendingTime;
    }


    // The email format to be displayed on screen or in lists
    @Override
    public String toString(){
        return "Subject: " + subject +
               "  Sender: " + sender +
               "  Recipient: " + recipient +
               "  Date: " + sendingTime.toString();
    }
}