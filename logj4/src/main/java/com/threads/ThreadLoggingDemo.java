package com.threads;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class MyThread extends Thread {
    private static final Logger logger = LogManager.getLogger(MyThread.class);
    private int threadId;

    public MyThread(int id) {
        this.threadId = id;
    }

    @Override
    public void run() {
        logger.info("Thread " + threadId + " started.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error("Thread " + threadId + " interrupted.", e);
        }
        logger.info("Thread " + threadId + " finished execution.");
    }
}

public class ThreadLoggingDemo {
    private static final Logger logger = LogManager.getLogger(ThreadLoggingDemo.class);

    public static void main(String[] args) {
        logger.info("Starting multi-threaded application...");

        for (int i = 1; i <= 3; i++) {
            new MyThread(i).start();
        }

        logger.info("All threads have been started.");
    }
}

