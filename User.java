
package com.mycompany.emailsystemm;

public class User {
    
       // keeps username, password and emailAddress
    private String username;
    private String password;
    private String emailAddress;
    
   //constructor, when new user entered, the corresponding datas are taken.
    public User(String username, String password, String emailAddress){
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    } 
    
     // Returns the user's username
    public String getUsername(){
        return username;
    }

    // returns the user's password 
    public String getPassword(){
        return password;
    }

    // returns the user's email address
    public String getEmailAddress(){
        return emailAddress;
    }   
    
    // Sets the username of the user
     public void setUsername(String username){
     this.username = username;
    }
    // Sets the password of the user
     public void setPassword(String password){
     this.password = password;
      }
     // Sets the email address of the user
     public void setEmailAddress(String emailAddress){
     this.emailAddress = emailAddress;
      } 
 
       // checks username and password. true or false ?
    public boolean checkLogin(String inputUsername, String inputPassword){
        if (username.equals(inputUsername) && password.equals(inputPassword)){
            return true;
        } else{
            return false;
        }
    }
    
   @Override
   
   public String toString(){
       return "username: " + username + " , Email: " + emailAddress;
 }
}

