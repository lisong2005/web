/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.test.thread.创建线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: 线程不安全.java, v 0.1 2016年3月15日 上午9:12:20 song.li@witontek.com Exp $
 */
public class 线程不安全 {

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(线程不安全.class);

    public static void main(String[] args) {
        int parties = 2;
        ExecutorService exe = Executors.newFixedThreadPool(parties);

        final Account t = new Account();

        for (int i = 0; i < parties; i++) {
            exe.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <= 10000; i++) {
                        t.balance++;
                    }
                    logger.info("end {}", Thread.currentThread().getName());
                }
            });
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(String.format("%s", t.balance));
        exe.shutdown();
    }

    static class Account {
        public int balance = 0;
    }
}
