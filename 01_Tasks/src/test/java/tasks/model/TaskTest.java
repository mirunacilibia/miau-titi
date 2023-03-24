package tasks.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task task;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Test for checking different correct values for the title - TC1_ECP & TC3_BVA")
    @ParameterizedTest
    @ValueSource(strings = { "Fa curatenie", "M" })
    void testCorrectTitle(String title) {
        try {
            task = new Task("title", new Date(), new Date(), 50, true);
            task.setTitle(title);
            assert task != null;
        } catch (IllegalArgumentException e){
            assert false;
        }
    }

    @DisplayName("Test for checking empty title - TC2_ECP - TC1_BVA\"")
    @Test
    void testEmptyTitle() {
        try {
            task = new Task("", new Date(), new Date(), 50, true);

            assert false;
        } catch (IllegalArgumentException e){
            assert true;
        }
    }

    @DisplayName("Test for checking long title - TC6_BVA")
    @Test
    void testLongTitle() {
        try {
            String title = new String(new char[256]).replace("\0", "M");
            task = new Task(title, new Date(), new Date(), 50, true);

            assert false;
        } catch (IllegalArgumentException e){
            assert true;
        }
    }

    @DisplayName("Test for checking correct value for the interval - TC7_BVA")
    @Test
    void testCorrectInterval() {
        try {
            task = new Task("Fa curatenie", new Date(), new Date(), 0, true);

            assert task != null;
        } catch (IllegalArgumentException e){
            assert false;
        }
    }

    @DisplayName("Test for checking different incorrect values for the interval - TC3_ECP & TC8_BVA")
    @ParameterizedTest
    @ValueSource(ints = { -20, -1 })
    void testIncorrectInterval(int interval) {
        try {
            task = new Task("Fa curatenie", new Date(), new Date(), interval, true);

            assert false;
        } catch (IllegalArgumentException e){
            assert true;
        }
    }

    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("RepeatingTest")
    void testIncorrectTitleInterval() {
        try {
            task = new Task("", new Date(), new Date(), -777, true);

            assert false;
        } catch (IllegalArgumentException e){
            assert true;
        }
    }

    @Disabled
    @Test
    void testCorrectDates() {
        // skip this test
    }

    @AfterEach
    void tearDown() {
    }
}