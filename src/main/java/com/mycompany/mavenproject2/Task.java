/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author RC_Student_lab
 */


public final class Task {
    private static int taskCounter = 0;

    private final String taskName;
    private final int taskNumber;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskID;
    private final String taskStatus;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskCounter++;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

    public String createTaskID() {
        String firstTwoLetters = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String lastThreeLetters = developerDetails.length() >= 3 ? developerDetails.substring(developerDetails.length() - 3).toUpperCase() : developerDetails.toUpperCase();
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    }

    public String printTaskDetails() {
        return String.format("Task Status: %s\nDeveloper Details: %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nTask Duration: %d hours",
                taskStatus, developerDetails, taskNumber, taskName, taskDescription, taskID, taskDuration);
    }

    public static int returnTotalHours(Task[] tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }

    public static int getTaskCounter() {
        return taskCounter;
    }

    public static void resetTaskCounter() {
        taskCounter = 0;
    }
}

