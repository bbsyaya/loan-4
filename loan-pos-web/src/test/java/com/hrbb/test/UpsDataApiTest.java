package com.hrbb.test;

import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.hrbb.loan.hessian.inter.IUpsDataApiHessionService;

public class UpsDataApiTest extends UnitTest{
    
    private Logger logger = Logger.getLogger(UpsDataApiTest.class);
    
    @Autowired
    private IUpsDataApiHessionService upsDataApiService;
    
    @Test
    public void Test1(){
     Map<String,Object> reqMap = Maps.newHashMap();
     reqMap.put("card", "6222520358610056");
     reqMap.put("name", "王莉");
     reqMap.put("beginDateStr", "2014-01-01");
     reqMap.put("endDateStr", "2015-06-06");
     upsDataApiService.getPosSerialByBankCardIds(reqMap);
    }
    
}
