/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */


public class TaskTest {

    @Test
    public void testCheckTaskDescription() {
        Task shortDescriptionTask = new Task("Login Feature", "Short description", "John Doe", 8, "To Do");
        assertTrue(shortDescriptionTask.checkTaskDescription(), "Task description is valid");

        Task longDescriptionTask = new Task("Login Feature", "This description is definitely way too long and should trigger an error message", "John Doe", 8, "To Do");
        assertFalse(longDescriptionTask.checkTaskDescription(), "Task description is invalid");
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", "Description", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:0:SON", task.createTaskID(), "Task ID should be LO:0:SON");
    }

    @Test
    public void testReturnTotalHours() {
        Task.resetTaskCounter();
        Task task1 = new Task("Task 1", "Description 1", "Developer 1", 10, "To Do");
        Task task2 = new Task("Task 2", "Description 2", "Developer 2", 20, "Doing");
        Task[] tasks = {task1, task2};
        assertEquals(30, Task.returnTotalHours(tasks), "Total hours should be 30");
    }
}
