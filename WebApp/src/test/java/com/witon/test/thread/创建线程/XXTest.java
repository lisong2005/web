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
 * @version $Id: XXTest.java, v 0.1 2016年3月23日 下午12:45:18 song.li@witontek.com Exp $
 */
public class XXTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(XXTest.class);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        logger.info(String.format("%s", j));
                        Thread.yield();
                    }
                }
            }).start();
        }
        
        logger.info("end");
    }
}
