package com.movile.study.concurrency.thread_5.exception;

public class ExceptionHandlerTask implements Runnable {
    @Override
    public void run() {
        int number = Integer.parseInt("TTT");
        System.out.println(number);
    }
}