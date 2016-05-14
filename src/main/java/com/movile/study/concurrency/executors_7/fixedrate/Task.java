package com.movile.study.concurrency.executors_7.fixedrate;

import java.util.Date;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
    }
}
