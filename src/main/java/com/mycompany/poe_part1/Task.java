/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part1;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author RC_Student_lab
 */

public class Task {
     private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
    
    // Static arrays to store data
    private static ArrayList<String> developers = new ArrayList<>();
    private static ArrayList<String> taskNames = new ArrayList<>();
    private static ArrayList<String> taskIDs = new ArrayList<>();
    private static ArrayList<Integer> taskDurations = new ArrayList<>();
    private static ArrayList<String> taskStatuses = new ArrayList<>();
    
    static ArrayList<Task> tasks = new ArrayList<>();
    static int totalHours = 0;
     static int taskCounter = 0;

    // Constructor
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskCounter++;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
        totalHours += taskDuration;
        
         // Populate static arrays
        developers.add(developerDetails);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);
    }

    // Method to ensure task description is less than 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to create task ID
    public String createTaskID() {
        String devLastName = developerDetails.split(" ")[1];  // Assume developer name is "First Last"
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + devLastName.substring(devLastName.length() - 3).toUpperCase();
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
                "Developer: " + developerDetails + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Task ID: " + taskID + "\n" +
                "Task Duration: " + taskDuration + " hours";
    }

    // Method to return total hours of all tasks
    public static int returnTotalHours() {
        return totalHours;
    }

    // Add task method
    public static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?"));

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");

            // Check if description is valid
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Task description too long! Please enter less than 50 characters.");
                i--;  // Retry task input
                continue;
            }

            String developerDetails = JOptionPane.showInputDialog("Enter Developer First and Last Name:");
              String[] nameParts = developerDetails.split(" ");
        if (nameParts.length < 2) {
            JOptionPane.showMessageDialog(null, "Please provide both first and last name.");
            i--;  // Retry task input
            continue;
        }
        
        String devLastName = nameParts[1];  // Use the last name for Task ID generation
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
            String taskStatus = JOptionPane.showInputDialog("Select Task Status:\n1) To Do\n2) Doing\n3) Done");

            // Convert numeric input to meaningful status
            switch (taskStatus) {
                case "1":
                    taskStatus = "To Do";
                    break;
                case "2":
                    taskStatus = "Doing";
                    break;
                case "3":
                    taskStatus = "Done";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid status! Defaulting to 'To Do'.");
                    taskStatus = "To Do";
            }

            // Create and store the task
            Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
            tasks.add(newTask);  // Add new task to the static tasks list

            // Display task details
            JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
        }

        JOptionPane.showMessageDialog(null, "All tasks added successfully! Total hours: " + returnTotalHours());
    }
    // Display tasks with 'Done' status
    public static void displayDoneTasks() {
        StringBuilder result = new StringBuilder("Tasks with status 'Done':\n");
        for (Task task : tasks) {
            if ("Done".equalsIgnoreCase(task.taskStatus)) {
                result.append(task.printTaskDetails()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 0 ? result.toString() : "No tasks with 'Done' status.");
    }

    // Display the longest task
    public static void displayLongestTask() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        Task longestTask = tasks.get(0);
        for (Task task : tasks) {
            if (task.taskDuration > longestTask.taskDuration) {
                longestTask = task;
            }
        }
        JOptionPane.showMessageDialog(null, "Longest Task:\n" + longestTask.printTaskDetails());
    }

    // Search task by name
    public static void searchTaskByName(String taskName) {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        for (Task task : tasks) {
            if (task.taskName.equalsIgnoreCase(taskName)) {
                JOptionPane.showMessageDialog(null, "Task Found:\n" + task.printTaskDetails());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    // Search tasks by developer
    public static void searchTasksByDeveloper(String developer) {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        StringBuilder result = new StringBuilder("Tasks for Developer: " + developer );
        for (Task task : tasks) {
            if (task.developerDetails.equalsIgnoreCase(developer)) {
                result.append(task.printTaskDetails()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 0 ? result.toString() : "No tasks found for developer: " + developer );
    }

    // Display a detailed report of all tasks
    public static void displayTaskReport() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        StringBuilder report = new StringBuilder("Task Report:\n");
        for (Task task : tasks) {
            report.append(task.printTaskDetails()).append("\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
  // Delete task by name
    public static void deleteTask(String taskName) {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        for (Task task : tasks) {
            if (task.taskName.equalsIgnoreCase(taskName)) {
                tasks.remove(task);
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task '" + taskName + "' not found.");
    }
}