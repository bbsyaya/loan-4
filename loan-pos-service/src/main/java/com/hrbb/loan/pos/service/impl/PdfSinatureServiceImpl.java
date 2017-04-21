/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPdfSignatureDao;
import com.hrbb.loan.pos.dao.entity.TPdfSignature;
import com.hrbb.loan.pos.service.PdfSignatureService;

/**
 * @author yida
 * @date 2015年11月12日 下午7:18:30
 */
@Service("pdfSignatureService")
public class PdfSinatureServiceImpl implements PdfSignatureService {
    
    @Autowired
    private TPdfSignatureDao pdfSignatureDao;

    public int insert(TPdfSignature pdfSignature) {
        return pdfSignatureDao.insert(pdfSignature);
    }

    public TPdfSignature findByContNo(String contNo) {
        return pdfSignatureDao.selectByPrimaryKey(contNo);
    }

    public Map<String, Object> findSignatureByContNo(String contNo) {
        return pdfSignatureDao.selectSinatureByContNo(contNo);
    }

}
