/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz;

import java.io.File;

/**
 * @author yida
 * @date 2015年11月5日 下午7:19:52
 */
public interface IFtpService {
    
    /**
     * 对文件进行打包
     * @param sourceFile 被打包的文件或目录
     * @param fileDir 打包进的目录
     * @param loanId 申请编号
     * @return 打包后的压缩文件
     */
    File zip(File sourceFile,String fileDir,String loanId);
    
    /**
     * 上传文件到ftp
     * @param file 要上传的文件
     * @param loanId 申请编号
     */
    void upload(File file,String loanId);
    

}
