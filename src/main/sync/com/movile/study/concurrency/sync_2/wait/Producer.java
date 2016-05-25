package com.movile.study.concurrency.sync_2.wait;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }

}
