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
    
  @BeforeEach
       // Reset taskCounter anf totalHours before each test
    public void setUp() {
        Task.taskCounter = 0; 
        Task.totalHours = 0;
    }
    
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
        @Test
    public void testCreateTaskID() {
       // Task 1: "Login Feature" by "Robyn Harrison"
        Task task1 = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
        String expectedTaskID1 = "LO:0:SON";  // "LO" from Login Feature, task 0, "SON" from Harrison
        assertEquals(expectedTaskID1, task1.createTaskID(), "Task ID should match the expected format.");

        // Task 2: "Add Task Feature" by "Mike Smith"
        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add users", "Mike Smith", 10, "Doing");
        String expectedTaskID2 = "AD:1:ITH";  // "AD" from Add Task Feature, task 1, "ITH" from Smith
        assertEquals(expectedTaskID2, task2.createTaskID(), "Task ID should match the expected format.");


    }
   @Test
    public void testReturnTotalHours() {
           // Reset static variables for testing
        Task.totalHours = 0;
        Task.taskCounter = 0;

        // Task 1: "Login Feature" - 8 hours
        Task task1 = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");

        // Task 2: "Add Task Feature" - 10 hours
        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add users", "Mike Smith", 10, "Doing");

        // Verify the total hours
        int expectedTotalHours = 18;  // 8 + 10
        assertEquals(expectedTotalHours, Task.returnTotalHours(), "Total task hours should be the sum of all task durations.");
    }
    // Test for total hours calculation

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        Task instance = null;
        boolean expResult = false;
        boolean result = instance.checkTaskDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTaskID method, of class Task.
     */
 
    
    /**
     * Test of printTaskDetails method, of class Task.
     */
      @Test
    public void testPrintTaskDetails() {
        // Create an instance of Task
        Task task1 = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
        // Generate the expected output based on current logic
        String expectedDetails = "Task Status: To Do\n" +
                                 "Developer: Robyn Harrison\n" +
                                 "Task Number: 0\n" +
                                 "Task Name: Login Feature\n" +
                                 "Task Description: Create login to authenticate users\n" +
                                 "Task ID: LO:0:SON\n" +  // Verify if this matches the actual ID format
                                 "Task Duration: 8 hours";
              // Capture actual output from printTaskDetails
        String actualDetails = task1.printTaskDetails();
        // Debug output
        System.out.println("Expected Output:\n" + expectedDetails);
        System.out.println("Actual Output:\n" + actualDetails);
        // Use assertEquals to check if actual output matches expected output
        assertEquals(expectedDetails, actualDetails, "Task details for task1 should match the expected output.");
   
    }
    /**
     * Test of addTasks method, of class Task.
     */
    @Test
    public void testAddTasks() {
        System.out.println("addTasks");
        Task.addTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayDoneTasks method, of class Task.
     */
    @Test
    public void testDisplayDoneTasks() {
        System.out.println("displayDoneTasks");
        Task.displayDoneTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestTask method, of class Task.
     */
    @Test
    public void testDisplayLongestTask() {
        System.out.println("displayLongestTask");
        Task.displayLongestTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTaskByName method, of class Task.
     */
    @Test
    public void testSearchTaskByName() {
        System.out.println("searchTaskByName");
        String taskName = "";
        Task.searchTaskByName(taskName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTasksByDeveloper method, of class Task.
     */
    @Test
    public void testSearchTasksByDeveloper() {
        System.out.println("searchTasksByDeveloper");
        String developer = "";
        Task.searchTasksByDeveloper(developer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTaskReport method, of class Task.
     */
    @Test
    public void testDisplayTaskReport() {
        System.out.println("displayTaskReport");
        Task.displayTaskReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTask method, of class Task.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("deleteTask");
        String taskName = "";
        Task.deleteTask(taskName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}