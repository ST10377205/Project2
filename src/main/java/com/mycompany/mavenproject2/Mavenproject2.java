/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

/**
 *
 * @author RC_Student_lab
 */


import javax.swing.JOptionPane;

public class Mavenproject2 {
    public static void main(String[] args) {
        // Registration
        String username = JOptionPane.showInputDialog(null, "Enter username:");
        while (!Account.isUsernameValid(username)) {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length", "Invalid Username", JOptionPane.ERROR_MESSAGE);
            username = JOptionPane.showInputDialog(null, "Enter username:");
        }

        String password = JOptionPane.showInputDialog(null, "Enter password:");
        while (!Account.isPasswordValid(password)) {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", "Invalid Password", JOptionPane.ERROR_MESSAGE);
            password = JOptionPane.showInputDialog(null, "Enter password:");
        }

        String firstName = JOptionPane.showInputDialog(null, "Enter first name:");
        String lastName = JOptionPane.showInputDialog(null, "Enter last name:");

        // Create account
        Account account = new Account(username, password, firstName, lastName);

        // Create login instance
        Login login = new Login(account);

        // Login process
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            String enteredUsername = JOptionPane.showInputDialog(null, "Enter your credentials to login:\nEnter username:");
            String enteredPassword = JOptionPane.showInputDialog(null, "Enter password:");
            isLoggedIn = login.loginUser(enteredUsername, enteredPassword);
            JOptionPane.showMessageDialog(null, login.returnLoginStatus(isLoggedIn), "Login Status", isLoggedIn ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        }

        // Display welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban", "Welcome", JOptionPane.INFORMATION_MESSAGE);

        // Main menu
        boolean running = true;
        Task[] tasks = null;
        int numTasks = 0;
        while (running) {
            String menu = "Select an option:\n1) Add tasks\n2) Show report\n3) Quit";
            String choice = JOptionPane.showInputDialog(menu);
            switch (choice) {
                case "1":
                    if (tasks == null) {
                        numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
                        tasks = new Task[numTasks];
                    }

                    for (int i = 0; i < numTasks; i++) {
                        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                        String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
                        while (taskDescription.length() > 50) {
                            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters", "Invalid Task Description", JOptionPane.ERROR_MESSAGE);
                            taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
                        }
                        String developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First and Last Name):");
                        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (hours):"));
                        String[] statusOptions = {"To Do", "Doing", "Done"};
                        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

                        Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
                        tasks[i] = task;

                        JOptionPane.showMessageDialog(null, "Task successfully captured", "Task Captured", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, task.printTaskDetails(), "Task Details", JOptionPane.INFORMATION_MESSAGE);
                    }

                    int totalHours = Task.returnTotalHours(tasks);
                    JOptionPane.showMessageDialog(null, "Total Hours for all tasks: " + totalHours, "Total Hours", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon", "Show Report", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please enter 1, 2, or 3.", "Invalid Option", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
}
