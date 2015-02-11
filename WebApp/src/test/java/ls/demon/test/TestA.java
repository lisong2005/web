/**
 * LS_Demon Org.
 * Copyright (c) 2005-2015 All Rights Reserved.
 */
package ls.demon.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * 
 * @author lisong
 * @version $Id: TestA.java, v 0.1 2015年2月11日 下午8:37:50 lisong Exp $
 */
public class TestA {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(TestA.class);

    @Test
    public void test_show() {
        logger.error("xxxx");
    }
}
