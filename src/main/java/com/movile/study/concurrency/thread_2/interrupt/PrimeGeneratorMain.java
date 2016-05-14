/**
 * 
 */
package com.movile.study.concurrency.thread_2.interrupt;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 *
 */
public class PrimeGeneratorMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }

}
