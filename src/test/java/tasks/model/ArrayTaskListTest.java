package tasks.model;

import javafx.collections.FXCollections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ArrayTaskListTest {


    @DisplayName("Test GetTask fara integrare E si S")
    @Test
    public void testGetTask() {
        Task mockTask = Mockito.mock(Task.class);
        when(mockTask.getTitle()).thenReturn("Mock Task");

        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(mockTask);

        assertEquals(mockTask, arrayTaskList.getTask(0));
    }

    @DisplayName("Test GetAll fara integrare E si S")
    @Test
    public void testGetAll() {
        List<Task> mockTasks = new ArrayList<>();
        mockTasks.add(Mockito.mock(Task.class));
        mockTasks.add(Mockito.mock(Task.class));
        mockTasks.add(Mockito.mock(Task.class));

        // set the titles of the mock tasks
        when(mockTasks.get(0).getTitle()).thenReturn("Mock Task 1");
        when(mockTasks.get(1).getTitle()).thenReturn("Mock Task 2");
        when(mockTasks.get(2).getTitle()).thenReturn("Mock Task 3");

        // create an array task list and add the mock tasks
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(mockTasks.get(0));
        arrayTaskList.add(mockTasks.get(1));
        arrayTaskList.add(mockTasks.get(2));

        // get all the tasks using the getAll method and verify that they are the mock tasks
        assertEquals(mockTasks, arrayTaskList.getAll());
    }
}