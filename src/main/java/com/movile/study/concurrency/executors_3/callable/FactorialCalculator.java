package com.movile.study.concurrency.executors_3.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class FactorialCalculator implements Callable<Integer> {

    private Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.printf("%s: %d\n",Thread.currentThread().getName(),result);
        return result;
    }
}
