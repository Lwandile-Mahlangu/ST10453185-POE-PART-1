/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part1;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class POE_Part1 {
     public static void main(String[] args){
        //Declaration
        
       Scanner scanner = new Scanner(System.in);
        registerUser user = new registerUser();
        
        System.out.println("=== User Registration ===");
        
        // Input for registration details
        System.out.print("Enter username (must contain an underscore and be no more than 5 characters): ");
        String username = scanner.nextLine();

        System.out.print("Enter password (must be at least 8 characters, contain a capital letter, a number, and a special character): ");
        String password = scanner.nextLine();

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        // Register the user
        String registrationMessage = user.registerUser(username, password, firstName, lastName);
        System.out.println(registrationMessage);

        // Only proceed to login if registration was successful
        if (registrationMessage.equals("User registration successful!")) {
            System.out.println("\n=== User Login ===");
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            // Display the login status message
            String loginMessage = user.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(loginMessage);
        }
    }
}
