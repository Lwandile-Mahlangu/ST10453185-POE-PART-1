/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
public class registerUser {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
   
// Method to validate the username
    public boolean checkUserName(String username) {
        if (username.length() <= 5 && username.contains("_")) {
            System.out.println("Username successfully captured");
            return true;
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }
    }
    
// Method to validate the password complexity
    public boolean checkPasswordComplexity(String password) {
        String pattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(password);

        if (matcher.find()) {
            System.out.println("Password successfully captured");
            return true;
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return false;
        }
    }
    
        // Method to register the user
 public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }

        // Store user details if both username and password are valid
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

        return "User registration successful!";
    }
     // Method to verify login credentials
    public boolean loginUser(String username, String password) {
        return this.username != null && this.password != null && this.username.equals(username) && this.password.equals(password);
    }

    // Method to return the login status message
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + this.firstName + " " + this.lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
    

