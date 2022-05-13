package com.geekbrains.realbuilder.threads;

import java.util.concurrent.locks.Lock;

public class Counter {
    private long value;
    private Lock lock;

    public Counter(Lock lock) {
        this.lock = lock;
    }

    public long getValue() {
        return value;
    }

    public long incrementAndGet() {
        return incrementAndGet(1L);
    }

    public long incrementAndGet(long increment) {
        try {
            lock.lock();
            this.value += increment;
        } finally {
            lock.unlock();
        }
        return value;
    }
}
