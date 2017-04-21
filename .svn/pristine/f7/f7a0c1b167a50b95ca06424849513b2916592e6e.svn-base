package com.hrbb.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.hrbb.loan.channel.user.UserProcesser;
import com.hrbb.loan.work.PosLoanDataSynGetWork;
import com.hrbb.loan.work.WorkManagerGroup;
import com.hrbb.loan.work.bean.AicReqBean;
import com.hrbb.loan.work.bean.NciicReqBean;
import com.hrbb.loan.work.bean.PosLoanHeaderBean;
import com.hrbb.loan.work.bean.YijifuVerifiedReqBean;

public class UmpProcesserTest extends UnitTest {
	
	@Resource(name="userProcesser")
    private UserProcesser userProcesser;
	
	@Resource(name="PosLoanDataSynGetWork")
	private PosLoanDataSynGetWork PosLoanDataSynGetWork;
	
	@Resource(name="WorkManagerGroup")
	private WorkManagerGroup WorkManagerGroup;
	
//	@Test
//    public void createMessage(){
//        System.out.println(userProcesser.createMessage(1, 1, "test", "这是一封测试消息!", 1, 2, 123, "t"));
//    }
	
	@Test
    public void updateValid(){
	    PosLoanHeaderBean posLoanHeaderBean = new PosLoanHeaderBean();
	    posLoanHeaderBean.setAppSource("");
	    posLoanHeaderBean.setSessionId("233");
	    posLoanHeaderBean.setUserId("123");
	    posLoanHeaderBean.setVersion("20150415");
	    
	    NciicReqBean nciicReqBean = new NciicReqBean();
        nciicReqBean.setCertType("");
        nciicReqBean.setCertId("620101198808080212");
        nciicReqBean.setCertName("测试");
        nciicReqBean.setUserId("123");
        nciicReqBean.setCustId("");
        
        YijifuVerifiedReqBean yijifuVerifiedReqBean = new YijifuVerifiedReqBean();
        yijifuVerifiedReqBean.setBankBranchName("测试分行");
        yijifuVerifiedReqBean.setBankCardNo("6226622201464076");
        yijifuVerifiedReqBean.setBankCode("0102");
        yijifuVerifiedReqBean.setBankSubbranchName("测试支行");
        
        AicReqBean aicReqBean = new AicReqBean();
        aicReqBean.setPosCustName("测试");
        
        PosLoanDataSynGetWork.setPosLoanHeaderBean(posLoanHeaderBean);
        PosLoanDataSynGetWork.setAicReqBean(aicReqBean);
        PosLoanDataSynGetWork.setPosLoanHeaderBean(new PosLoanHeaderBean());
        PosLoanDataSynGetWork.setNciicReqBean(nciicReqBean);
        PosLoanDataSynGetWork.setYijifuVerifiedReqBean(yijifuVerifiedReqBean);
        
        for (int i = 0; i < 10; i++) {
            WorkManagerGroup.addThread("prePosLoanDataSyn", PosLoanDataSynGetWork);
        }
        for (int i = 0; i < 5; i++) {
            WorkManagerGroup.addThread("t", PosLoanDataSynGetWork);
        }
	    
//	    UserSensitiveInformationUpdateRequest userSensitiveInformationUpdateRequest = new UserSensitiveInformationUpdateRequest();
//        userSensitiveInformationUpdateRequest.setUserId(123);
////        userSensitiveInformationUpdateRequest.setCustId(0);
//        userSensitiveInformationUpdateRequest.setOperationType(2);
//        userSensitiveInformationUpdateRequest.setAppSource(1);
//        userSensitiveInformationUpdateRequest.setIdType(1);
//        userSensitiveInformationUpdateRequest.setIdNo("620101198808080212");
//        userSensitiveInformationUpdateRequest.setIdCheckedStatus(2);
//        System.out.println(userProcesser);
//        UserSensitiveInformationUpdateResponse userSensitiveInformationUpdateResponse = userProcesser.updateUserSensitiveInfo(userSensitiveInformationUpdateRequest);
//        if (userSensitiveInformationUpdateResponse == null || !"UMP000000".equals(userSensitiveInformationUpdateResponse.getResponseCode())) {
//            System.out.println("公安部实名数据录入失败");
//        } else {
//            System.out.println("公安部实名数据录入成功");
//        }
	    
	    
//	    NciicReqBean nciicReqBean = new NciicReqBean();
//        nciicReqBean.setCertType("");
//        nciicReqBean.setCertId("620101198808080212");
//        nciicReqBean.setCertName("测试");
//        nciicReqBean.setUserId("123");
//        nciicReqBean.setCustId("");
//        PosLoanDataSynGetWork work = new PosLoanDataSynGetWork();
//        work.setNciicReqBean(nciicReqBean);
//        WorkManager.getWorkManager().addWork(work);
    }
	
}
