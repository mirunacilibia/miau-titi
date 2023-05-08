package tasks.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.model.TasksOperations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TasksServiceTest {

    @DisplayName("Test FilterTasks valid fara integrare E si R")
    @Test
    public void testFilterTasks() {
        Task task = Mockito.mock(Task.class);
        when(task.nextTimeAfter(any())).thenReturn(new GregorianCalendar(2022, Calendar.JANUARY, 5).getTime());

        ArrayTaskList tasksList = Mockito.mock(ArrayTaskList.class);
        Mockito.when(tasksList.getAll()).thenReturn(List.of(task));

        TasksService tasksService = new TasksService(tasksList);

        Date start = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        Date end = new GregorianCalendar(2022, Calendar.JANUARY, 31).getTime();

        Iterable<Task> incomingTasks = tasksService.filterTasks(start, end);
        List<Task> incomingTasksList = new ArrayList<>();
        incomingTasks.forEach(incomingTasksList::add);
        assertEquals(1, incomingTasksList.size());
    }

    @DisplayName("Test GetObservableList fara integrare E si R")
    @Test
    public void testGetObservableList() {
        Task task = Mockito.mock(Task.class);
        when(task.getTitle()).thenReturn("Mock title");

        ArrayTaskList tasksList = Mockito.mock(ArrayTaskList.class);
        Mockito.when(tasksList.getAll()).thenReturn(List.of(task));

        TasksService tasksService = new TasksService(tasksList);

        assertEquals(FXCollections.observableArrayList(List.of(task)), tasksService.getObservableList());
        assertEquals("Mock title", tasksService.getObservableList().get(0).getTitle());
    }

    @DisplayName("Test FilterTasks fara integrare E, cu integrare R")
    @Test
    public void testFilterTasksRIntegration() {
        Task task = Mockito.mock(Task.class);
        when(task.nextTimeAfter(any())).thenReturn(new GregorianCalendar(2022, Calendar.JANUARY, 5).getTime());

        ArrayTaskList tasksList = new ArrayTaskList();
        tasksList.add(task);

        TasksService tasksService = new TasksService(tasksList);

        Date start = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        Date end = new GregorianCalendar(2022, Calendar.JANUARY, 31).getTime();

        Iterable<Task> incomingTasks = tasksService.filterTasks(start, end);
        List<Task> incomingTasksList = new ArrayList<>();
        incomingTasks.forEach(incomingTasksList::add);
        assertEquals(1, incomingTasksList.size());
    }

    @DisplayName("Test GetObservableList invalid fara integrare E, cu integrare R")
    @Test
    public void testGetObservableListRIntegration() {
        Task task = Mockito.mock(Task.class);
        when(task.getTitle()).thenReturn("Mock title");

        ArrayTaskList tasksList = new ArrayTaskList();
        tasksList.add(task);

        TasksService tasksService = new TasksService(tasksList);

        assertEquals(FXCollections.observableArrayList(List.of(task)), tasksService.getObservableList());
        assertEquals("Mock title", tasksService.getObservableList().get(0).getTitle());
    }

    @DisplayName("Test FilterTasks valid cu integrare E si R")
    @Test
    public void testFilterTasksERIntegration() {
        Task task = new Task("title", new GregorianCalendar(2022, Calendar.JANUARY, 5).getTime(), new GregorianCalendar(2022, Calendar.JANUARY, 15).getTime(), 100, true);

        ArrayTaskList tasksList = new ArrayTaskList();
        tasksList.add(task);

        TasksService tasksService = new TasksService(tasksList);

        Date start = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        Date end = new GregorianCalendar(2022, Calendar.JANUARY, 31).getTime();

        Iterable<Task> incomingTasks = tasksService.filterTasks(start, end);
        List<Task> incomingTasksList = new ArrayList<>();
        incomingTasks.forEach(incomingTasksList::add);
        assertEquals(1, incomingTasksList.size());
    }

    @DisplayName("Test GetObservableList cu integrare E si R")
    @Test
    public void testGetObservableListERIntegration() {
        Task task = new Task("Mock title", new Date(), new Date(), 100, true);

        ArrayTaskList tasksList = new ArrayTaskList();
        tasksList.add(task);

        TasksService tasksService = new TasksService(tasksList);

        assertEquals(FXCollections.observableArrayList(List.of(task)), tasksService.getObservableList());
        assertEquals("Mock title", tasksService.getObservableList().get(0).getTitle());
    }
}