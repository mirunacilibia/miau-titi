package tasks.model;

import javafx.collections.FXCollections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TasksOperationsTest {
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