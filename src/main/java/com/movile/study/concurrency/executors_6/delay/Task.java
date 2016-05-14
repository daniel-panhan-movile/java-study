package com.movile.study.concurrency.executors_6.delay;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class Task implements Callable<String> {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
        return "Hello, world";
    }
}
