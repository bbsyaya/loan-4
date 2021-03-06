/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter.async;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.biz.IFtpService;
import com.hrbb.loan.pos.biz.backstage.inter.IPDFService;
import com.hrbb.loan.pos.util.ImageUtil;
import com.hrbb.loan.pos.util.PDFGenerator;

/**
 * @author yida
 * @date 2015年10月28日 下午2:23:14
 */

@Service
public class AgreementPDFService implements IPDFService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgreementPDFService.class);
    
    @Autowired
    private IFtpService ftpService;

    @Async
    public void generate(String loanId,String agreementTemplate,String resourcePath, String pdfFileName,String signature,String signImageName) {

        String imgFilePath = null;
        String system = System.getProperty("os.name").toLowerCase();
        if (system.startsWith("win")) {
            imgFilePath = resourcePath.replace("file:/", "")+signImageName;
        } else {
            imgFilePath = resourcePath.replace("file:", "")+signImageName;
        }
        LOGGER.debug("imgFilePath = "+imgFilePath);
        File signImageFile = ImageUtil.generateImage(signature, imgFilePath);
        File pdf = PDFGenerator.generate(agreementTemplate, resourcePath, pdfFileName);
        //归档上传ftp
        File zipFile = ftpService.zip(pdf, null, loanId);
        if(null == zipFile){
            LOGGER.warn("pdf压缩失败，需要重新生成pdf");
            return;
        }
        ftpService.upload(zipFile, loanId);
        //删除本地pdf
        if (null != pdf) {
            boolean deleteFlag = pdf.delete();
            if (!deleteFlag) {
                LOGGER.warn("pdf文件删除失败，请手动删除，pdf电子协议文件路径为：" + pdf.getAbsolutePath());
            }
        }
        //删除本地签名图片
        if(null != signImageFile){
            boolean delFlag = signImageFile.delete();
            if (!delFlag) {
                LOGGER.warn("签名图片文件删除失败，请手动删除，签名图片文件路径为：" + signImageFile.getAbsolutePath());
            }
        }
        //删除zip文件
        boolean zipDelFlag = zipFile.delete();
        if (!zipDelFlag) {
            LOGGER.warn("签名压缩文件删除失败，请手动删除，压缩文件路径为：" + zipFile.getAbsolutePath());
        }
    }

}
