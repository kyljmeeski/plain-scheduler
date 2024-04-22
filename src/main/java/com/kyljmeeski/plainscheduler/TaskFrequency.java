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
