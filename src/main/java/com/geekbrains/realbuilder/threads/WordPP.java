package com.geekbrains.realbuilder.threads;

import static java.lang.Thread.sleep;

public class WordPP implements Runnable {

    @Override
    public void run() {
        while (true){
            try {
                printWord();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected synchronized void printWord() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        sleep(300);
        notify();
        wait();
    }
}
