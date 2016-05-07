package com.movile.study.concurrency.sync.wait;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }

}
