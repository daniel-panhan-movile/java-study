package com.movile.study.concurrency.thread_9.factory;

import java.util.concurrent.TimeUnit;

public class SleepTask implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}