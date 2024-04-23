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
