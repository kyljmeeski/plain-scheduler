package com.kyljmeeski.plainscheduler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

class PlainTaskTest {

    @Test
    void testTaskExecution() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        Task task = new PlainTask(counter::incrementAndGet, TaskFrequency.everySeconds(1));

        Thread taskThread = new Thread(task);
        taskThread.start();

        Thread.sleep(5000);
        taskThread.interrupt();

        assertTrue(counter.get() >= 4, "Task should run at least 4 times in 5 seconds");
    }

    @Test
    void testPauseAndResume() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        Task task = new PlainTask(counter::incrementAndGet, TaskFrequency.everySeconds(1));

        Thread taskThread = new Thread(task);
        taskThread.start();

        Thread.sleep(3000);
        task.pause();
        int countAfterPause = counter.get();

        Thread.sleep(3000);
        assertEquals(countAfterPause, counter.get(), "Task should not run when paused");

        task.resume();
        Thread.sleep(3000);
        taskThread.interrupt();

        assertTrue(counter.get() > countAfterPause, "Task should resume running after resume");
    }
}
