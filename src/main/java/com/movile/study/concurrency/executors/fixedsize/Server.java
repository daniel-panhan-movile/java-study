package com.movile.study.concurrency.executors.fixedsize;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class Server {

    private ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");

        executor.execute(task);

        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Largest Pool Size: %d\n", executor.getLargestPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
        System.out.printf("Server: Task Count: %d\n",executor.getTaskCount());

    }

    public void endServer() {
        executor.shutdown();
    }
}
