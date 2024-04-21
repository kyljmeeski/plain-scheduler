package com.kyljmeeski.plainscheduler;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PlainScheduler implements Scheduler {

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final ConcurrentHashMap<Task, Future<?>> tasks = new ConcurrentHashMap<>();

    @Override
    public void schedule(Task task) {
        Future<?> future = executorService.submit(task);
        tasks.put(task, future);
    }

    @Override
    public void pause(Task task) {
        task.pause();
    }

    @Override
    public void resume(Task task) {
        task.resume();
    }

    @Override
    public void shutdown() {
        for (Future<?> future : tasks.values()) {
            future.cancel(true);
        }
        executorService.shutdown();
    }

}
