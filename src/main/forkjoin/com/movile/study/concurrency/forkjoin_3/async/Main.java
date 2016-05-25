package com.movile.study.concurrency.forkjoin_3.async;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor concurrency = new FolderProcessor("src/main/java/com/movile/study/concurrency", "java");
        FolderProcessor java8 = new FolderProcessor("src/main/java/com/movile/study/java8", "java");
        FolderProcessor study = new FolderProcessor("src/main/java/com/movile/study", "java");

        pool.execute(concurrency);
        pool.execute(java8);
        pool.execute(study);

        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((!concurrency.isDone()) || (!java8.isDone()) || (!study.isDone()));

        pool.shutdown();

        List<String> results;

        results = concurrency.join();
        System.out.printf("Concurrency: %d files found.\n", results.size());

        results = java8.join();
        System.out.printf("Java8: %d files found.\n", results.size());

        results = study.join();
        System.out.printf("Study: %d files found.\n", results.size());

    }

}
