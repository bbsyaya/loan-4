/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

/**
 * @author yida
 * @date 2015年10月28日 下午4:35:05
 */
public class PDFGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

    /**
     * @param template html模板字符串
     * @param resourcePath  font&image资源 路径
     */
    public static File generate(String template, String resourcePath,String pdfFileName) {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(template);
        ITextFontResolver fontResolver = renderer.getFontResolver();
        File pdfFile = new File(pdfFileName);
        //解决中文字体问题
        try {
            fontResolver.addFont(resourcePath + "simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//宋体常规字体
        } catch (DocumentException | IOException e1) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e1));
        }
        //解决图片问题
        renderer.getSharedContext().setBaseURL(resourcePath);
        renderer.layout();
        OutputStream os = null;
        try {
            os = new FileOutputStream(pdfFile);
            renderer.createPDF(os);
        } catch (FileNotFoundException | DocumentException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            }
        }
        return pdfFile;
    }

}
