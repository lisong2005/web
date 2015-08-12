/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package ls.demon.xx.web.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AccessTotenToolController.java, v 0.1 2015年8月12日 上午10:57:13 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/tool/at.htm")
public class AccessTotenToolController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(AccessTotenToolController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap modelMap, String appId, String appSecret) {
        logger.info("");

        if (StringUtils.isNotBlank(appId) && StringUtils.isNotBlank(appSecret)) {

            String timestamp = String.valueOf(System.currentTimeMillis());

            String checkToken = DigestUtils.md5Hex(String.format("%s%s%s", appId, appSecret,
                timestamp));

            modelMap.addAttribute("appId", appId);
            modelMap.addAttribute("appSecret", appSecret);
            modelMap.addAttribute("timestamp", timestamp);
            modelMap.addAttribute("checkToken", checkToken);
        }

        return "tool/at";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(ModelMap modelMap, String appId, String appSecret) {
        logger.info("post");

        if (StringUtils.isNotBlank(appId) && StringUtils.isNotBlank(appSecret)) {

            String timestamp = String.valueOf(System.currentTimeMillis());

            String checkToken = DigestUtils.md5Hex(String.format("%s%s%s", appId, appSecret,
                timestamp));

            modelMap.addAttribute("appId", appId);
            modelMap.addAttribute("appSecret", appSecret);
            modelMap.addAttribute("timestamp", timestamp);
            modelMap.addAttribute("checkToken", checkToken);
        }

        return "tool/at";
    }

}
