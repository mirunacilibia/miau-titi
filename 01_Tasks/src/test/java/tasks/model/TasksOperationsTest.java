package tasks.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TasksOperationsTest {

    @DisplayName("Test incoming valid fara integrare E")
    @Test
    public void testIncomingValid() {
        Task task1 = Mockito.mock(Task.class);
        Task task2 = Mockito.mock(Task.class);
        Task task3 = Mockito.mock(Task.class);

        when(task1.nextTimeAfter(any())).thenReturn(new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime());
        when(task2.nextTimeAfter(any())).thenReturn(new GregorianCalendar(2022, Calendar.JANUARY, 5).getTime());
        when(task3.nextTimeAfter(any())).thenReturn(new GregorianCalendar(2022, Calendar.FEBRUARY, 1).getTime());

        List<Task> tasksList = Arrays.asList(task1, task2, task3);

        TasksOperations tasksOperations = new TasksOperations(FXCollections.observableList(tasksList));

        Date start = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        Date end = new GregorianCalendar(2022, Calendar.JANUARY, 31).getTime();

        Iterable<Task> incomingTasks = tasksOperations.incoming(start, end);
        List<Task> incomingTasksList = new ArrayList<>();
        incomingTasks.forEach(incomingTasksList::add);
        assertEquals(2, incomingTasksList.size());
    }

    @DisplayName("Test incoming invalid fara integrare E")
    @Test
    public void testIncomingInvalid() {
        Task task1 = Mockito.mock(Task.class);
        Task task2 = Mockito.mock(Task.class);
        Task task3 = Mockito.mock(Task.class);

        when(task1.nextTimeAfter(any())).thenReturn(new GregorianCalendar(2023, Calendar.JANUARY, 1).getTime());
        when(task2.nextTimeAfter(any())).thenReturn(new GregorianCalendar(2023, Calendar.JANUARY, 5).getTime());
        when(task3.nextTimeAfter(any())).thenReturn(new GregorianCalendar(2023, Calendar.FEBRUARY, 1).getTime());

        List<Task> tasksList = Arrays.asList(task1, task2, task3);

        TasksOperations tasksOperations = new TasksOperations(FXCollections.observableList(tasksList));

        Date start = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        Date end = new GregorianCalendar(2022, Calendar.JANUARY, 31).getTime();

        Iterable<Task> incomingTasks = tasksOperations.incoming(start, end);
        List<Task> incomingTasksList = new ArrayList<>();
        incomingTasks.forEach(incomingTasksList::add);
        assertEquals(0, incomingTasksList.size());
    }

    @DisplayName("FO1_TC01")
    @Test
    void testIncoming01() {
        try {

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,0);
            cal.set(Calendar.MINUTE,0);
            cal.set(Calendar.SECOND,0);
            cal.set(Calendar.MILLISECOND,0);

            ArrayTaskList tasks = new ArrayTaskList();
            cal.set(2022,5,10);
            Date dateStartTask = cal.getTime();
            cal.set(2022,6,10);
            Date dateEndTask = cal.getTime();

            tasks.add(new Task("title", dateStartTask, dateEndTask, 50, true));

            cal.set(2023,1,1);
            Date dateStart = cal.getTime();
            cal.set(2023,1,2);
            Date dateEnd = cal.getTime();
            TasksOperations tasksOps = new TasksOperations(FXCollections.observableArrayList(tasks.getAll()));
            Iterable<Task> rez = tasksOps.incoming(dateStart,dateEnd);
            List<Task> myList = new ArrayList<>();
            rez.forEach(myList::add);
            assert myList.isEmpty();
        } catch (IllegalArgumentException e){
            assert false;
        }
    }

    @DisplayName("FO1_TC02")
    @Test
    void testIncoming02() {
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,0);
            cal.set(Calendar.MINUTE,0);
            cal.set(Calendar.SECOND,0);
            cal.set(Calendar.MILLISECOND,0);


            ArrayTaskList tasks = new ArrayTaskList();
            cal.set(2022,5,10);
            Date dateStartTask = cal.getTime();
            cal.set(2022,6,10);
            Date dateEndTask = cal.getTime();

            tasks.add(new Task("title", dateStartTask, dateEndTask, 50, true));
            cal.set(2023,4,10);
            Date dateStart = cal.getTime();
            cal.set(2023,4,15);
            Date dateEnd = cal.getTime();
            TasksOperations tasksOps = new TasksOperations(FXCollections.observableArrayList(tasks.getAll()));
            Iterable<Task> rez = tasksOps.incoming(dateStart,dateEnd);
            List<Task> myList = new ArrayList<>();
            rez.forEach(myList::add);
            assert myList.isEmpty();
        } catch (IllegalArgumentException e){
            assert false;
        }
    }

    @DisplayName("FO1_TC03")
    @Test
    void testIncoming03() {
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,0);
            cal.set(Calendar.MINUTE,0);
            cal.set(Calendar.SECOND,0);
            cal.set(Calendar.MILLISECOND,0);


            ArrayTaskList tasks = new ArrayTaskList();
            cal.set(2022,5,10);
            Date dateStartTask = cal.getTime();
            cal.set(2022,6,10);
            Date dateEndTask = cal.getTime();

            Task task = new Task("title", dateStartTask, dateEndTask, 50, true);
            tasks.add(task);

            cal.set(2022,4,10);
            Date dateStart = cal.getTime();
            cal.set(2022,5,20);
            Date dateEnd = cal.getTime();
            TasksOperations tasksOps = new TasksOperations(FXCollections.observableArrayList(tasks.getAll()));
            Iterable<Task> rez = tasksOps.incoming(dateStart,dateEnd);
            List<Task> myList = new ArrayList<>();
            rez.forEach(myList::add);
            assert myList.get(0).equals(task);
        } catch (IllegalArgumentException e){
            assert false;
        }
    }


    @DisplayName("FO1_TC04")
    @Test
    void testIncoming04() {
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,0);
            cal.set(Calendar.MINUTE,0);
            cal.set(Calendar.SECOND,0);
            cal.set(Calendar.MILLISECOND,0);
            cal.set(2023,1,1);


            ArrayTaskList tasks = new ArrayTaskList();
            cal.set(2022,5,10);
            Date dateStartTask = cal.getTime();
            cal.set(2022,6,10);
            Date dateEndTask = cal.getTime();

            Task task = new Task("title", dateStartTask, dateEndTask, 50, true);
            tasks.add(task);

            cal.set(2022,4,10);
            Date dateStart = cal.getTime();
            cal.set(2022,5,10);
            Date dateEnd = cal.getTime();
            TasksOperations tasksOps = new TasksOperations(FXCollections.observableArrayList(tasks.getAll()));
            Iterable<Task> rez = tasksOps.incoming(dateStart,dateEnd);
            List<Task> myList = new ArrayList<>();
            rez.forEach(myList::add);
            assert myList.get(0).equals(task);
        } catch (IllegalArgumentException e){
            assert false;
        }
    }
}