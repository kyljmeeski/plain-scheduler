package com.kyljmeeski.plainscheduler;

public interface Task extends Runnable {

    Runnable job();

    long interval();

    boolean paused();

    void pause();

    void resume();

}
