/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
       private String taskDescription;
    private int[] taskDuration;
    private int counter;
    // Method to check task description length
    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }
    // Tests for task description validation
    @Test
    public void testCheckTaskDescription_success_Robyn() {
        String description = "Create login to authenticate users.";
        boolean result = checkTaskDescription(description);
        assertTrue(result, "Description should be valid");
    }
    @Test
    public void testCheckTaskDescription_success_Mike() {
        String description = "Create login to authenticate users.";
        boolean result = checkTaskDescription(description);
        assertTrue(result, "Description should be valid");
    }
    @Test
    public void testCheckTaskDescription_failure() {
        String description = "Please enter task description of less than 50 characters because this is too long.";
        boolean result = checkTaskDescription(description);
        assertFalse(result, "Description should be invalid");
    }
    // Method to create a Task ID
    public String createTaskID(String taskName, int taskNumber, String developerDetails) {
        String taskNamePart = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String developerPart = developerDetails.length() >= 3
                ? developerDetails.substring(developerDetails.length() - 3).toUpperCase()
                : developerDetails.toUpperCase();
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }
    // Tests for Task ID generation
    @Test
    public void testCreateTaskID_Robyn() {
        String name = "Login Feature";
        int number = 0;
        String developer = "Robyn Harrison";
        String expectedTaskID = "LO:0:SON";
        String actualTaskID = createTaskID(name, number, developer);
        assertEquals(expectedTaskID, actualTaskID, "Task ID should match expected format");
    }
    @Test
    public void testCreateTaskID_Mike() {
        String name = "Add Task Feature";
        int number = 1;
        String developer = "Mike Smith";
        String expectedTaskID = "AD:1:ITH";
        String actualTaskID = createTaskID(name, number, developer);
        assertEquals(expectedTaskID, actualTaskID, "Task ID should match expected format");
    }
    // Method to return total hours
    public int returnTotalHours() {
        int totalHours = 0;
        for (int i = 0; i < counter; i++) {
            totalHours += taskDuration[i];
        }
        return totalHours;
    }
    // Test for total hours calculation
    @Test
    public void testReturnTotalHours() {
        // Initialize taskDuration with sample values
        taskDuration = new int[]{10, 12, 55, 11, 1};
        counter = 5;
        
        int expectedTotalHours = 10 + 12 + 55 + 11 + 1;
        int actualTotalHours = returnTotalHours();
        assertEquals(expectedTotalHours, actualTotalHours, "Total hours should match expected sum");
    }
}