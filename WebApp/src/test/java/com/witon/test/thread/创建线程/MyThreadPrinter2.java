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
 * @version $Id: MyThreadPrinter2.java, v 0.1 2016年3月15日 上午9:49:18 song.li@witontek.com Exp $
 */
public class MyThreadPrinter2 implements Runnable {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(MyThreadPrinter2.class);

    private String              name;
    private Object              prev;
    private Object              self;

    private MyThreadPrinter2(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();

                    if (count == 0) {
                        System.out.println("\n\n");
                        logger.info("E {}", count);
                    }
                } catch (InterruptedException e) {
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        logger.info("");
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);
        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);
        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);

        new Thread(pa).start();
        new Thread(pb).start();
        new Thread(pc).start();
    }
}
