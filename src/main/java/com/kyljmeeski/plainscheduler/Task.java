package com.kyljmeeski.plainscheduler;

/**
 * Represents a task that can be scheduled by a Scheduler.
 * Implementations of Task should provide a job to execute, an interval for execution,
 * and methods to control its execution state.
 */
public interface Task extends Runnable {

    /**
     * Returns the job to be executed by this task.
     *
     * @return the job to be executed
     */
    Runnable job();

    /**
     * Returns the interval in milliseconds between executions of this task.
     *
     * @return the interval in milliseconds
     */
    long interval();

    /**
     * Checks if the task is currently paused.
     *
     * @return true if the task is paused, false otherwise
     */
    boolean paused();

    /**
     * Pauses the execution of this task.
     */
    void pause();

    /**
     * Resumes the execution of this task if it was paused.
     */
    void resume();

}
