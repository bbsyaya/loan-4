/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.factory.ConfigService;
import com.hrbb.loan.pos.factory.SysConfigFactory;

/**
 * @author yida
 * @date 2015年11月4日 下午3:38:25
 */
public class PdfResourceUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PdfResourceUtil.class);
    private static String winResourcePath;
    private static String linuxResourcePath;
    static {
        ConfigService configService = SysConfigFactory.getInstance().getService("pdfResource");
        winResourcePath = configService.getPropertyValue("winResourcePath");
        linuxResourcePath = configService.getPropertyValue("linuxResourcePath");
    }

    public static String getPdfResourcePath() {
        String resourcePath = null;
        if (StringUtils.isNotBlank(winResourcePath) && StringUtils.isNotBlank(linuxResourcePath)) {
            String system = System.getProperty("os.name").toLowerCase();
            if (system.startsWith("win")) {
                resourcePath = winResourcePath;
            } else {
                resourcePath = linuxResourcePath;
            }
        } else {
            LOGGER.warn("winResourcePath = "+winResourcePath+" linuxResourcePath ="+linuxResourcePath+"不能为空");
        }
        return resourcePath;
    }
}
