package com.kyljmeeski.plainscheduler;

public class TaskFrequency {

    private final int frequency;

    public static TaskFrequency everySeconds(int seconds) {
        return new TaskFrequency(seconds * 1000);
    }

    public static TaskFrequency everyMinutes(int minutes) {
        return new TaskFrequency(minutes * 60 * 1000);
    }

    public static TaskFrequency everyHours(int hours) {
        return new TaskFrequency(hours * 60 * 60 * 1000);
    }

    public TaskFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int frequency() {
        return frequency;
    }

}
