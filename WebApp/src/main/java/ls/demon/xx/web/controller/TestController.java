/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.xx.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author lisong
 * @version $Id: TestController.java, v 0.1 2016年9月9日 下午7:51:41 lisong Exp $
 */
@Controller
public class TestController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test/show.htm", method = RequestMethod.GET)
    public String doGet(ModelMap modelMap, String appId, String appSecret) {
        logger.info("appId={},appSecret={}", appId, appSecret);

        return "test.vm";
    }
}
