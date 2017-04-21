/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPdfSignature;

/**
 * @author yida
 * @date 2015年11月12日 下午6:31:37
 */
public interface PdfSignatureService {
    
    int insert(TPdfSignature pdfSignature);
    
    TPdfSignature findByContNo(String contNo);
    
    Map<String, Object> findSignatureByContNo(String contNo);
    
    

}
