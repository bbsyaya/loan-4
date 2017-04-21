package com.hrbb.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.common.collect.Maps;
import com.hrbb.loan.channel.user.UserProcesser;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.ump.facade.bean.requests.user.UserInformationQueryRequest;
import com.hrbb.ump.facade.bean.responses.user.UserInfoQueryResponse;
import com.hrbb.ump.facade.general.user.UserFacade;

public class ZzSaleAppApplyTest extends UnitTest{
    @Autowired
    @Qualifier("zzSaleAPPQueryApplyInfo")
    private HService zzSaleAPPQueryApplyInfo;
    @Autowired
    @Qualifier("zzSaleAppLoanApply")
    private HService zzSaleAppLoanApply;
    @Autowired
    private UserFacade umpUserService;
    @Autowired
    @Qualifier("zzAppSaleElectricContractGenerate")
    private HService zzAppSaleElectricContractGenerate;
    
    @Autowired
    @Qualifier("zzSaleAppAddInfo")
    private HService zzSaleAppAddInfo;
    @Autowired
    private UserProcesser userProcesser;
    @Test
    public void testQueryUserinfo() {
        UserInformationQueryRequest request = new UserInformationQueryRequest();
        request.setUserId(62);
        UserInfoQueryResponse response = userProcesser.queryUserInfo(request);
        System.out.println(response);
    }
    @Test
    public void testCheckLoginStatus(){
        boolean b = userProcesser.CheckUserLoginStatus("62","c8de5e86-d2f4-4c94-846e-7fb792173f47");
        System.out.println(b );
    }
    
    @Test
    public void testSaleAPPQueryApplyInfo(){
        HRequest request = new HRequest();
        Map<String, Object> props = request.getProperties();
        Map<String, Object> headerMap = Maps.newHashMap();
        headerMap.put("version", "20150415");
        headerMap.put("userid", "userid");
        headerMap.put("sessionid","sessionid");
        headerMap.put("appsource","appsource");
        Map<String, Object> bodyMap = Maps.newHashMap();
        bodyMap.put("loanid", "LO20150317140345775886896354");
        bodyMap.put("custid", "cu2015031714034565031443");
        props.put("HrbbHeader", headerMap);
        props.put("HrbbBody", bodyMap);
        try{
            HResponse response = zzSaleAPPQueryApplyInfo.serve(request);
            System.out.println(response.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testSaleAppLoanApply(){
        HRequest request = new HRequest();
        Map<String, Object> props = request.getProperties();
        Map<String, Object> headerMap = Maps.newHashMap();
        headerMap.put("version", "20150415");
        headerMap.put("userid", "62");
        headerMap.put("sessionid","c8de5e86-d2f4-4c94-846e-7fb792173f47");
        headerMap.put("appsource","2");
        Map<String, Object> bodyMap = Maps.newHashMap();
        bodyMap.put("tcapi", "1234");
        bodyMap.put("retukind", "90");
        bodyMap.put("tterm", "3");
        bodyMap.put("indesubsacno", "12345678903456789");
        bodyMap.put("desireddate", "20150518");
        bodyMap.put("loanuse", "");
        bodyMap.put("bankname", "哈尔滨银行");
        bodyMap.put("bankbrandname", "账户分行");
        bodyMap.put("banksubname", "账户支行");
        props.put("HrbbHeader", headerMap);
        props.put("HrbbBody", bodyMap);
        try{
            HResponse response = zzSaleAppLoanApply.serve(request);
            System.out.println(response.toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void testzzSaleAppAddInfo(){
        HRequest request = new HRequest();
        Map<String, Object> props = request.getProperties();
        Map<String, Object> headerMap = Maps.newHashMap();
        headerMap.put("version", "20150415");
        headerMap.put("userid", "62");
        headerMap.put("sessionid","c8de5e86-d2f4-4c94-846e-7fb792173f47");
        headerMap.put("appsource","2");
        Map<String, Object> bodyMap = Maps.newHashMap();
        bodyMap.put("loanid", "LO2015051915065955322978199000");
        bodyMap.put("custid", "C201505191133190212F");
        bodyMap.put("additspec", "测试补件说明");
        bodyMap.put("imgadditdetail", "工资明细");
        bodyMap.put("imagefilepackagename", "imagefilepackagename");
        props.put("HrbbHeader", headerMap);
        props.put("HrbbBody", bodyMap);
        try{
            HResponse response = zzSaleAppAddInfo.serve(request);
            System.out.println(response.toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Test
    public void testzzAppSaleElectricContractGenerate(){
        HRequest request = new HRequest();
        Map<String, Object> props = request.getProperties();
        Map<String, Object> headerMap = Maps.newHashMap();
        headerMap.put("version", "20150415");
        headerMap.put("userid", "62");
        headerMap.put("sessionid","c8de5e86-d2f4-4c94-846e-7fb792173f47");
        headerMap.put("appsource","2");
        Map<String, Object> bodyMap = Maps.newHashMap();
        bodyMap.put("loanid", "LO2015051915065955322978199000");
        bodyMap.put("custid", "C201505191133190212F");
        props.put("HrbbHeader", headerMap);
        props.put("HrbbBody", bodyMap);
        try{
            HResponse response = zzAppSaleElectricContractGenerate.serve(request);
            System.out.println(response.toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
