package com.movile.study.concurrency.thread.exception;

public class ExceptionHandlerTask implements Runnable {
    @Override
    public void run() {
        int number = Integer.parseInt("TTT");
        System.out.println(number);
    }
}