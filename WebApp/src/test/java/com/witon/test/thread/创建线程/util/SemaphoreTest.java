/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.test.thread.创建线程.util;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SemaphoreTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(SemaphoreTest.class);

    public static void main(String[] args) {

        int parties = 2;
        //  ExecutorService exe = Executors.newFixedThreadPool(4);

        Semaphore sem = new Semaphore(parties);

        try {
            logger.info("[start]avail = {}", sem.availablePermits());
            sem.acquire();
            logger.info("avail = {}", sem.availablePermits());
            sem.acquire();
            logger.info("avail = {}", sem.availablePermits());
            sem.acquire();
            logger.info("no print...");
            logger.info("avail = {}", sem.availablePermits());
        } catch (InterruptedException e) {
            logger.error("", e);
        }

    }
}
