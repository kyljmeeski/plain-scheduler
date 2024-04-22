package com.kyljmeeski.plainscheduler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

class PlainSchedulerTest {

    private PlainScheduler scheduler;

    @BeforeEach
    void setUp() {
        scheduler = new PlainScheduler();
    }

    @AfterEach
    void tearDown() {
        scheduler.shutdown();
    }

    @Test
    void testScheduleTask() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        Task task = new PlainTask(counter::incrementAndGet, TaskFrequency.everySeconds(1));

        scheduler.schedule(task);
        Thread.sleep(5000);

        assertTrue(counter.get() >= 4, "Task should run at least 4 times in 5 seconds");
    }

    @Test
    void testPauseAndResumeTask() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        Task task = new PlainTask(counter::incrementAndGet, TaskFrequency.everySeconds(1));

        scheduler.schedule(task);
        Thread.sleep(3000);
        scheduler.pause(task);
        int countAfterPause = counter.get();

        Thread.sleep(3000);
        assertEquals(countAfterPause, counter.get(), "Task should not run when paused");

        scheduler.resume(task);
        Thread.sleep(3000);

        assertTrue(counter.get() > countAfterPause, "Task should resume running after resume");
    }

    @Test
    void testShutdown() throws InterruptedException {
        AtomicInteger counter1 = new AtomicInteger(0);
        AtomicInteger counter2 = new AtomicInteger(0);

        Task task1 = new PlainTask(counter1::incrementAndGet, TaskFrequency.everySeconds(1));
        Task task2 = new PlainTask(counter2::incrementAndGet, TaskFrequency.everySeconds(2));

        scheduler.schedule(task1);
        scheduler.schedule(task2);

        Thread.sleep(5000);
        scheduler.shutdown();

        int finalCount1 = counter1.get();
        int finalCount2 = counter2.get();

        Thread.sleep(3000);
        assertEquals(finalCount1, counter1.get(), "Task1 should not run after shutdown");
        assertEquals(finalCount2, counter2.get(), "Task2 should not run after shutdown");
    }

}
