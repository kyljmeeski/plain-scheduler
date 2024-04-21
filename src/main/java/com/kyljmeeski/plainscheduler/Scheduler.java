package com.kyljmeeski.plainscheduler;

public interface Scheduler {

    void schedule(Task task);

    void pause(Task task);

    void resume(Task task);

    void shutdown();

}