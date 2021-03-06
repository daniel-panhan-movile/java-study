package com.movile.study.concurrency.sync_7.countdownlatch;

import java.util.concurrent.TimeUnit;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class Participant implements Runnable {

    private Videoconference conference;
    private String name;

    public Participant(Videoconference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        conference.arrive(name);
    }

}
