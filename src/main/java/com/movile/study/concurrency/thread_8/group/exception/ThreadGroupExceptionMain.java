package com.movile.study.concurrency.thread_8.group.exception;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class ThreadGroupExceptionMain {

    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();

        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }
    }
}
