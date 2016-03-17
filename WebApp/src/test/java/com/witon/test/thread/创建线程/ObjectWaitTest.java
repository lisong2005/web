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
 * @version $Id: ObjectWaitTest.java, v 0.1 2016年3月15日 下午1:25:23 song.li@witontek.com Exp $
 */
public class ObjectWaitTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ObjectWaitTest.class);

    public static void main(String[] args) {
        ObjectWaitTest lock = new ObjectWaitTest();
        logger.info("start");
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                logger.error("", e);
            }
        }
        logger.info("end");
    }
}
