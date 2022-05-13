package com.geekbrains.realbuilder.threads;

public class ThreadCounter implements Runnable {
    private final Counter counter1;
    private final Counter counter2;
    private final int iterations;

    public ThreadCounter(Counter counter1, Counter counter2, int iterations) {
        this.counter1 = counter1;
        this.counter2 = counter2;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            counter1.incrementAndGet();
            counter2.incrementAndGet();
        }
    }
}
