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
 * Represents the frequency of task execution in milliseconds.
 */
public class TaskFrequency {

    private final int frequency;

    /**
     * Creates a TaskFrequency object that specifies execution every given number of seconds.
     *
     * @param seconds the number of seconds between task executions
     * @return a TaskFrequency object representing the specified frequency
     */
    public static TaskFrequency everySeconds(int seconds) {
        return new TaskFrequency(seconds * 1000);
    }

    /**
     * Creates a TaskFrequency object that specifies execution every given number of minutes.
     *
     * @param minutes the number of minutes between task executions
     * @return a TaskFrequency object representing the specified frequency
     */
    public static TaskFrequency everyMinutes(int minutes) {
        return new TaskFrequency(minutes * 60 * 1000);
    }

    /**
     * Creates a TaskFrequency object that specifies execution every given number of hours.
     *
     * @param hours the number of hours between task executions
     * @return a TaskFrequency object representing the specified frequency
     */
    public static TaskFrequency everyHours(int hours) {
        return new TaskFrequency(hours * 60 * 60 * 1000);
    }

    /**
     * Creates a TaskFrequency object that specifies execution frequency in milliseconds.
     *
     * @param frequency the frequency of task execution in milliseconds
     */
    public TaskFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Returns the frequency of task execution in milliseconds.
     *
     * @return the frequency of task execution in milliseconds
     */
    public int frequency() {
        return frequency;
    }

}
