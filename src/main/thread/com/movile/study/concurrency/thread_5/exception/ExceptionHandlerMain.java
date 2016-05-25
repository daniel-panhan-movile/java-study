package com.movile.study.concurrency.thread_5.exception;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class ExceptionHandlerMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExceptionHandlerTask task = new ExceptionHandlerTask();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }

}
