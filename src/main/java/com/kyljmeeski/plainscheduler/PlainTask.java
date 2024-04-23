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

import java.util.concurrent.atomic.AtomicBoolean;

public class PlainTask implements Task {

    private final Runnable job;
    private final int interval;
    private final AtomicBoolean paused = new AtomicBoolean(false);

    public PlainTask(Runnable job, TaskFrequency frequency) {
        this(job, frequency.frequency());
    }

    /**
     * Constructs a PlainTask with the provided job and interval.
     *
     * @param job      the job to execute
     * @param interval the interval in milliseconds between job executions
     */
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
