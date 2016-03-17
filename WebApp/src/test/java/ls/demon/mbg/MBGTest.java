/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.mbg;

import ls.demon.xx.BaseModel;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: MBGTest.java, v 0.1 2016年3月17日 上午11:13:13 song.li@witontek.com Exp $
 */
public class MBGTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(MBGTest.class);

    @Test
    public void test_mbg_create() {
        try {
            logger.info("{}", BaseModel.class.getClassLoader());
            logger.info("{}", BaseModel.class.getClassLoader().getParent());
            logger.info("{}", BaseModel.class.getClassLoader().getParent().getParent());
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            logger.info("{}", Thread.currentThread().getContextClassLoader());
            logger.info("{}", Thread.currentThread().getClass().getClassLoader());
            logger.info("{}", Thread.class.getClassLoader());
            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            logger.info("{}", MBGTest.class.getClassLoader());
            logger.info("{}", new BaseModel().getClass().getClassLoader());

            logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            //            logger.info("{}", new BaseModel().getClass().getClassLoader().getResource("/").getPath());

            logger.info("{}", Thread.class.getResource("/").getPath());
            logger.info("{}", BaseModel.class.getResource("/").getPath());
            logger.info("{}", new BaseModel().getClass().getResource("/").getPath());

            logger.info("{}", Thread.currentThread().getContextClassLoader().getResource(""));
            logger.info("{}", BaseModel.class.getResource("app.properties"));

            ClassPathResource r = new ClassPathResource("/app.properties");
            logger.info("{}", r);
            logger.info("{}", r.getURL().getPath());

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test2() {
        try {
            logger.info("{}", BaseModel.class.getClassLoader().getResource("app.properties"));

            logger.info(
                "{}",
                BaseModel.class.getClassLoader().getResource(
                    "org/springframework/web/servlet/config/spring-mvc-3.0.xsd"));
            logger.info("{}",
                Thread.currentThread().getContextClassLoader().getResource("app.properties"));

            ClassPathResource r = new ClassPathResource("/app.properties");
            logger.info("{}", r);
            logger.info("{}", r.getURL().getPath());
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
