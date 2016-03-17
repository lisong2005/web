/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.test.thread.创建线程.util;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CyclicBarrierTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(CyclicBarrierTest.class);

    public static void main(String[] args) {

        int parties = 2;
        ExecutorService exe = Executors.newFixedThreadPool(4);
        final List<Integer> list = Arrays
            .asList(new Integer[] { new Integer(0), new Integer(10000) });

        final CyclicBarrier cb = new CyclicBarrier(parties, null);
//        final CyclicBarrier cb = new CyclicBarrier(parties, new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    logger.info("all over {}", list);
//                    Thread.sleep(500);
//                } catch (Exception e) {
//                    logger.error("", e);
//                }
//            }
//        });

        for (int i = 0; i < parties; i++) {
            exe.execute(new TestTask(cb, i, list));
        }
        logger.info("main over");
        try {
            Thread.sleep(2000);
            exe.shutdown();
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    static class TestTask implements Runnable {

        private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

        private CyclicBarrier       cb;
        private int                 index;
        private List<Integer>       result;

        public TestTask(CyclicBarrier cb, int index, List<Integer> result) {
            this.cb = cb;
            this.index = index;
            this.result = result;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    // cb.await();

                    result.set(index, result.get(index) + 1);
                    logger.info("[{}] index={} - {}:{}", Thread.currentThread().getName(), index,
                        i, result.get(index));

                    cb.await();
                } catch (Exception e) {
                    logger.error("", e);
                    break;
                }
            }
            logger.info("[END] {}", Thread.currentThread().getName());
        }
    }
}
