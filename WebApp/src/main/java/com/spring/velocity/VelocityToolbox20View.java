package com.spring.velocity;
/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;

/**
 * 支持 2.0 版本的velocity-tool
 * 
 * @author song.li@witontek.com
 * @version $Id: VelocityToolbox20View.java, v 0.1 2014年7月23日 上午11:03:42 song.li@witontek.com Exp $
 */
public class VelocityToolbox20View extends VelocityToolboxView {

    /**  */
    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    /** 
     * @see org.springframework.web.servlet.view.velocity.VelocityToolboxView#createVelocityContext(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {

        logger.debug("=== createVelocityContext ===");
        // Create a ChainedContext instance.

        ViewToolContext ctx;

        ctx = new ViewToolContext(getVelocityEngine(), request, response, getServletContext());

        ctx.putAll(model);

        if (this.getToolboxConfigLocation() != null) {
            ToolManager toolManager = new ToolManager();
            toolManager.setVelocityEngine(getVelocityEngine());

            logger.debug(String.format("resourceLoader=%s", this.resourceLoader));
            String configurePath = getApplicationContext().getResource(getToolboxConfigLocation())
                .getFile().getPath();
            logger.debug(String.format("configurePath=%s", configurePath));
            //            if (StringUtils.startsWith("/WEB-INF", getToolboxConfigLocation())) {
            //                configurePath = getServletContext().getRealPath(getToolboxConfigLocation());
            //            } else {
            //                configurePath = getApplicationContext().getResource(getToolboxConfigLocation())
            //                    .getURI().getPath();
            //            }
            //            logger.info(configurePath);
            Assert.notNull(configurePath, String.format("toolboxConfigLocation is null [%s=%s]",
                getToolboxConfigLocation(), configurePath));
            toolManager.configure(configurePath);

            if (toolManager.getToolboxFactory().hasTools(Scope.REQUEST)) {
                ctx.addToolbox(toolManager.getToolboxFactory().createToolbox(Scope.REQUEST));
            }
            if (toolManager.getToolboxFactory().hasTools(Scope.APPLICATION)) {
                ctx.addToolbox(toolManager.getToolboxFactory().createToolbox(Scope.APPLICATION));
            }
            if (toolManager.getToolboxFactory().hasTools(Scope.SESSION)) {
                ctx.addToolbox(toolManager.getToolboxFactory().createToolbox(Scope.SESSION));
            }
        }
        return ctx;
    }

    /**
     * Setter method for property <tt>resourceLoader</tt>.
     * 
     * @param resourceLoader value to be assigned to property resourceLoader
     */
    public void setResourceLoader(ResourceLoader resourceLoader) {
        logger.debug(String.format("set=%s", resourceLoader));
        this.resourceLoader = resourceLoader;
    }

}
