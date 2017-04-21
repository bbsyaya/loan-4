package com.hrbb.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.common.collect.Maps;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;

public class ZzAppCreditApplyTest extends UnitTest {
	
	
	@Autowired
	@Qualifier("zzAppQueryApplyInfo")
	private HService zzAppQueryApplyInfo;
	
	@Autowired
    @Qualifier("zzAppElectronicProtocolQuery")
    private HService zzAppElectronicProtocolQuery;
	
	@Autowired
    @Qualifier("zzAppSmsSender")
    private HService zzAppSmsSender;
	
	@Autowired
    @Qualifier("zzAppBankProperties")
    private HService zzAppBankProperties;
	
	@Test
    public void bankProperties(){
        HRequest request = new HRequest();
        Map<String, Object> props = request.getProperties();
        Map<String, Object> headerMap = Maps.newHashMap();
        headerMap.put("Version", "20150415");
        Map<String, Object> bodyMap = Maps.newHashMap();
        bodyMap.put("flag", "18516053329");
        props.put("HrbbHeader", headerMap);
        props.put("HrbbBody", bodyMap);
        try{
            HResponse response = zzAppBankProperties.serve(request);
            System.out.println(response.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
	
	@Test
    public void smsSender(){
        HRequest request = new HRequest();
        Map<String, Object> props = request.getProperties();
        Map<String, Object> headerMap = Maps.newHashMap();
        headerMap.put("Version", "20150415");
        Map<String, Object> bodyMap = Maps.newHashMap();
        bodyMap.put("mobile", "18516053329");
        bodyMap.put("smstype", "POS0001");
        bodyMap.put("code", "3223");
        bodyMap.put("number", "1");
        props.put("HrbbHeader", headerMap);
        props.put("HrbbBody", bodyMap);
        try{
            HResponse response = zzAppSmsSender.serve(request);
            System.out.println(response.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
	
	@Test
	public void queryCreditApply(){
		HRequest request = new HRequest();
		Map<String, Object> props = request.getProperties();
		Map<String, Object> headerMap = Maps.newHashMap();
		headerMap.put("Version", "20150415");
		Map<String, Object> bodyMap = Maps.newHashMap();
		bodyMap.put(CreditApplyHServiceConstants.loanid, "LO20150317140345775886896354");
		props.put("HrbbHeader", headerMap);
		props.put("HrbbBody", bodyMap);
		try{
			HResponse response = zzAppQueryApplyInfo.serve(request);
			System.out.println(response.toString());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
    public void queryElectronicProtocolQuery(){
        HRequest request = new HRequest();
        Map<String, Object> props = request.getProperties();
        Map<String, Object> headerMap = Maps.newHashMap();
        headerMap.put("Version", "20150415");
        Map<String, Object> bodyMap = Maps.newHashMap();
        bodyMap.put(PaymentApplyHServiceConstants.contno, "cn2015040812590947674952247888");
        props.put("HrbbHeader", headerMap);
        props.put("HrbbBody", bodyMap);
        try{
            HResponse response = zzAppElectronicProtocolQuery.serve(request);
            System.out.println(response.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
	
}
