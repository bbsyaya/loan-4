package com.hrbb.loan.spi.UM;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackApplyBiz;
import com.hrbb.loan.pos.service.RepaymentApplyService;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.HServiceException;

@Service("umRepaymentApply")
public class UMRepaymentApplyServiceImpl implements HService {
    
    private static final Logger   logger = Logger.getLogger(UMRepaymentApplyServiceImpl.class);

    @Autowired
    private RepaymentApplyService repaymentApplyService;
    
    @Autowired
    private LoanPosPaybackApplyBiz loanPosPaybackApplyBiz;

    @Override
    public HResponse serve(HRequest request) throws HServiceException {
        
        if (logger.isDebugEnabled()) {
            logger.debug("repayment request received");
        }

        Assert.notNull(repaymentApplyService, "doesn't allow empty repaymentApplyService");

        Map<String, Object> properties = request.getProperties();

        Assert.notNull(properties, "doesn't allow empty properties");

        HResponse hResponse = new HResponse();
        /*listid空判断*/
        if (!properties.containsKey("listid")) {
            hResponse.setRespCode(HServiceReturnCode.LISTID_REPAY_ERROR.getReturnCode());
            hResponse.setRespMessage(HServiceReturnCode.LISTID_REPAY_ERROR.getReturnMessage());
            hResponse.setRespTime(new Date());
            return getBlankResponse(hResponse);
        }
        /*金额转格式*/
        try {
            String amount = (String) properties.get("sumamt");
            Double.parseDouble(amount);
        } catch (Exception ex) {
            logger.warn("invalid amount...", ex);
            hResponse.setRespCode(HServiceReturnCode.AMT_REPAY_ERROR.getReturnCode());
            hResponse.setRespMessage(HServiceReturnCode.AMT_REPAY_ERROR.getReturnMessage());
            hResponse.setRespTime(new Date());
            return getBlankResponse(hResponse);
        }
        /*生成还款申请*/
        try {
            String repaymentNo = repaymentApplyService.applyRepayment(properties);
            logger.info("还款流水号为" + repaymentNo);
            Map<String, Object> reqMap = Maps.newHashMap();
            reqMap.put("listid", repaymentNo);
            hResponse.setProperties(reqMap);
            hResponse.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
            hResponse.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
            return hResponse;
        } catch (Exception ex) {
            logger.error("failed to apply repayment...", ex);
            hResponse.setRespCode(HServiceReturnCode.FAILURE_REPAY_ERROR.getReturnCode());
            hResponse.setRespMessage(HServiceReturnCode.FAILURE_REPAY_ERROR.getReturnMessage());
            hResponse.setRespTime(new Date());
            return getBlankResponse(hResponse);
        }
    }

    /**
     * 返回空结果
     * 
     * @param resp
     * @return
     */
    private HResponse getBlankResponse(HResponse resp) {
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put(PaymentApplyHServiceConstants.listid, "");
        resp.setProperties(reqMap);
        return resp;
    }

}
