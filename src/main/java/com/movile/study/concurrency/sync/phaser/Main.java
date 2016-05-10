package com.movile.study.concurrency.sync.phaser;

import java.util.concurrent.Phaser;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class Main {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        FileSearch phaserFiles = new FileSearch("src/main/java/com/movile/study/concurrency/sync/phaser", "java", phaser);
        FileSearch syncFiles = new FileSearch("src/main/java/com/movile/study/concurrency/sync", "java", phaser);
        FileSearch interruptFiles = new FileSearch("src/main/java/com/movile/study/concurrency/thread/interrupt", "java", phaser);

        Thread systemThread = new Thread(phaserFiles, "phaserFiles");
        systemThread.start();

        Thread appsThread = new Thread(syncFiles, "syncFiles");
        appsThread.start();

        Thread documentsThread = new Thread(interruptFiles, "interruptFiles");
        documentsThread.start();

        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Terminated: " + phaser.isTerminated());

    }

}
