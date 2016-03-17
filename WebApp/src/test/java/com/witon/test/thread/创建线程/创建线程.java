/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.test.thread.创建线程;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: 创建线程.java, v 0.1 2016年3月14日 下午3:05:07 song.li@witontek.com Exp $
 */
public class 创建线程 {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(创建线程.class);

    public static void main(String[] args) {
        Thread t1 = new NewTestThread();
        t1.start();

        Thread t2 = new Thread(new NewsTestRunnable());
        t2.start();

        logger.info("main over");
    }

    static class NewTestThread extends Thread {
        @Override
        public void run() {
            // TODO 线程执行任务
            for (int i = 0; i < 1024; i++) {
                logger.info("1111");
            }
        }
    }

    static class NewsTestRunnable implements Runnable {
        @Override
        public void run() {
            // TODO 线程执行任务
            for (int i = 0; i < 1024; i++) {
                logger.info("2222");
            }
        }
    }

}
