/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.xx.web.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ls.demon.xx.web.SignUtil;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SignToolController.java, v 0.1 2016年1月22日 下午2:26:24 song.li@witontek.com Exp $
 */
@Controller
@RequestMapping("/tool/sign.htm")
public class SignToolController {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(SignToolController.class);

    /**  */
    private static final String VM     = "tool/sign";

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap modelMap, String jsonStr, String appSecret) {
        logger.info("appId={},appSecret={}", jsonStr, appSecret);

        modelMap.addAttribute("appSecret", appSecret);
        modelMap.addAttribute("jsonStr", jsonStr);

        if (StringUtils.isNotBlank(appSecret) && StringUtils.isNotBlank(jsonStr)) {
            try {
                JSONObject jo = new JSONObject(jsonStr);
                logger.info("{}", jo);

                Map<String, String> params = new HashMap<String, String>();
                Iterator<String> it = jo.keys();
                while (it.hasNext()) {
                    String key = it.next();
                    if (StringUtils.equalsIgnoreCase("sign", key)) {
                        continue;
                    }
                    String value = jo.optString(key);
                    params.put(key, value);
                }
                logger.info("params = {}", params);
                String sign = SignUtil.sign(params, appSecret);
                modelMap.addAttribute("sign", sign);
            } catch (Exception e) {
                logger.error("", e);
                modelMap.addAttribute("error", "json格式错误");
            }
        }

        if (StringUtils.isBlank(jsonStr)) {
            JSONObject jo = new JSONObject();
            try {
                jo.put("key1", "Value1");
                jo.put("key2", "Value2");
            } catch (JSONException e) {
            }
            modelMap.addAttribute("jsonStr", jo.toString());
        }

        return VM;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.POST)
    public String doPost(ModelMap modelMap, String jsonStr, String appSecret) {
        logger.info("appId={},appSecret={}", jsonStr, appSecret);

        modelMap.addAttribute("appSecret", appSecret);
        modelMap.addAttribute("jsonStr", jsonStr);

        if (StringUtils.isNotBlank(appSecret) && StringUtils.isNotBlank(jsonStr)) {
            try {
                JSONObject jo = new JSONObject(jsonStr);
                logger.info("{}", jo);

                Map<String, String> params = new HashMap<String, String>();
                Iterator<String> it = jo.keys();
                while (it.hasNext()) {
                    String key = it.next();
                    if (StringUtils.equalsIgnoreCase("sign", key)) {
                        continue;
                    }
                    String value = jo.optString(key);
                    params.put(key, value);
                }
                logger.info("params = {}", params);
                String sign = SignUtil.sign(params, appSecret);
                modelMap.addAttribute("sign", sign);
            } catch (Exception e) {
                logger.error("", e);
                modelMap.addAttribute("error", "json格式错误");
            }
        }
        return VM;
    }
}
