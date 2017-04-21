/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.util;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author yida
 * @date 2015年10月28日 下午2:57:28
 */
public class HtmlGenerator {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HtmlGenerator.class);
    private static final String UTF8 = "utf-8";
    private static final String FILE_DIR = "/template";
    
    /**
     * @param fileDir 模板项目路径
     * @param fileName freemarker模板文件名
     * @param model 模板model
     * @return htmlStr
     */
    public static String generate(String fileName,Map<String, Object> model){
        String htmlStr = null;
        try {
            Configuration config = new Configuration();
            config.setClassForTemplateLoading(HtmlGenerator.class, FILE_DIR);
            Template template = config.getTemplate(fileName);
            template.setEncoding(UTF8);
            htmlStr = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        } catch (IOException | TemplateException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
        }
        return htmlStr;
    } 

}
