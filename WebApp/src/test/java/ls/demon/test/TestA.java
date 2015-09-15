/**
 * LS_Demon Org.
 * Copyright (c) 2005-2015 All Rights Reserved.
 */
package ls.demon.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        try {
            logger.error("xxxx");
            String s1 = "eJwBIADf%2F8gO31arHpnEbSuctM0JbhhXlsT3fxIhqjaAsRf2INp1%2FycPXQ%3D%3D";
            logger.error("{}", URLDecoder.decode(s1, "utf-8"));
            logger.error("{}", URLDecoder.decode(s1, "gbk"));

            String s2 = "eJwBIADf/8gO31arHpnEbSuctM0JbhhXlsT3fxIhqjaAsRf2INp1/ycPXQ==";
            logger.error("{}", Base64.decodeBase64(s2));
            logger.error("{}", Hex.encodeHexString(Base64.decodeBase64(s2)));
            logger.error("{}", new String(Base64.decodeBase64(s2), "utf-8"));
            logger.error("{}", new String(Base64.decodeBase64(s2), "gbk"));
        } catch (UnsupportedEncodingException e) {
            logger.error("", e);
        }
    }
}
