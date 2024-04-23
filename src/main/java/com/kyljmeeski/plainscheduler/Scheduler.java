/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2024 Amir Syrgabaev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
