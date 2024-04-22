package com.kyljmeeski.plainscheduler;

/**
 * Interface for scheduling tasks to execute.
 * Provides methods to schedule tasks, pause/resume specific tasks, and shut down the scheduler.
 */
public interface Scheduler {

    /**
     * Schedules a task for execution.
     *
     * @param task the task to schedule
     */
    void schedule(Task task);

    /**
     * Pauses the execution of a scheduled task.
     *
     * @param task the task to pause
     */
    void pause(Task task);

    /**
     * Resumes the execution of a paused task.
     *
     * @param task the task to resume
     */
    void resume(Task task);

    /**
     * Shuts down the scheduler, stopping all scheduled tasks.
     * After shutdown, the scheduler cannot be used to schedule new tasks.
     */
    void shutdown();

}
