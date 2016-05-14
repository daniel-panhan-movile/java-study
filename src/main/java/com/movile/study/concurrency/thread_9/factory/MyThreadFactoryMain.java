package com.movile.study.concurrency.thread_9.factory;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class MyThreadFactoryMain {

    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        SleepTask task = new SleepTask();

        Thread thread;
        System.out.printf("Starting the Threads\n");
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(task);
            thread.start();
        }

        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n", factory.getStats());

    }

}
