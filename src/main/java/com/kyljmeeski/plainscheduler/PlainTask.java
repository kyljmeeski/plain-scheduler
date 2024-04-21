package com.kyljmeeski.plainscheduler;

import java.util.concurrent.atomic.AtomicBoolean;

public class PlainTask implements Task {

    private final Runnable job;
    private final int interval;
    private final AtomicBoolean paused = new AtomicBoolean(false);

    public PlainTask(Runnable job, TaskFrequency frequency) {
        this(job, frequency.frequency());
    }

    public PlainTask(Runnable job, int interval) {
        this.job = job;
        this.interval = interval;
    }

    @Override
    public Runnable job() {
        return job;
    }

    @Override
    public long interval() {
        return interval;
    }

    @Override
    public boolean paused() {
        return paused.get();
    }

    @Override
    public void pause() {
        paused.set(true);
    }

    @Override
    public void resume() {
        paused.set(false);
        synchronized (this) {
            notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    while (paused.get()) {
                        wait();
                    }
                }
                job.run();
                Thread.sleep(interval);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}
