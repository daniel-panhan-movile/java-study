package com.movile.study.concurrency.sync.condition;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class Producer implements Runnable {

    private FileMock mock;

    private Buffer buffer;

    public Producer(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()) {
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }

}
