/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package ls.demon.xx.web.controller.form;

import ls.demon.xx.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: XXForm.java, v 0.1 2015年8月13日 下午5:01:59 song.li@witontek.com Exp $
 */
public class XXForm extends BaseModel {

    /**  */
    private static final long serialVersionUID = 61686648380758078L;

    private String            appId;

    private String            appSecret;

    /**
     * Getter method for property <tt>appId</tt>.
     * 
     * @return property value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Setter method for property <tt>appId</tt>.
     * 
     * @param appId value to be assigned to property appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * Getter method for property <tt>appSecret</tt>.
     * 
     * @return property value of appSecret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * Setter method for property <tt>appSecret</tt>.
     * 
     * @param appSecret value to be assigned to property appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

}
