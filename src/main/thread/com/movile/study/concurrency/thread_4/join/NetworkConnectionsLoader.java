package com.movile.study.concurrency.thread_4.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class NetworkConnectionsLoader implements Runnable {

    @Override
    public void run() {
        System.out.printf("Beginning network connections loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network connections loading has finished: %s\n", new Date());
    }

}
