package com.madhu.concepts.concurrency.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockImpl1Test {

    static final int MAX_T = 4;

    public static void main(String[] args) {
        ReentrantLock relObject = new ReentrantLock();
        ExecutorService pool
                = Executors.newFixedThreadPool(MAX_T);
        Runnable runnable1 = new ReentrantLockImpl1(relObject, "Job1");
        Runnable runnable2 = new ReentrantLockImpl1(relObject, "Job2");
        Runnable runnable3 = new ReentrantLockImpl1(relObject, "Job3");
        Runnable runnable4 = new ReentrantLockImpl1(relObject, "Job4");

        Runnable runnable5 = new ReentrantLockImpl1(relObject, "Job5");
        Runnable runnable6 = new ReentrantLockImpl1(relObject, "Job6");
        Runnable runnable7 = new ReentrantLockImpl1(relObject, "Job7");
        Runnable runnable8 = new ReentrantLockImpl1(relObject, "Job8");
        pool.execute(runnable1);
        pool.execute(runnable2);
        pool.execute(runnable3);
        pool.execute(runnable4);

        pool.execute(runnable5);
        pool.execute(runnable6);
        pool.execute(runnable7);
        pool.execute(runnable8);
        pool.shutdown();
    }
}
