package com.brbb.loan.sale.validate;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.ValidateUtil;
import com.hrbb.loan.spiconstants.LoanRequestHeaderConstants;
import com.hrbb.loan.spiconstants.SaleLoanReturnCode;
import com.hrbb.sh.framework.HResponse;

public class LoanSaleValidate {
    public static Logger  logger = LoggerFactory.getLogger(LoanSaleValidate.class);
    public static boolean validateHeader(Map<String, String> headerMap, Map<String, String> bodyMap,HResponse resp){
        logger.info("validate header begin !");
        // 版本
        if (!"20150415".equals(headerMap.get("version"))) {
            logger.error("接口版本号为空或不合法:[]", headerMap.get(LoanRequestHeaderConstants.version));
            bodyMap.put("respcode", SaleLoanReturnCode.VERSION_ERRO_ERROR.getReturnCode());
            bodyMap.put("respmsg", SaleLoanReturnCode.VERSION_ERRO_ERROR.getReturnMessage());
            resp.setRespCode(SaleLoanReturnCode.VERSION_ERRO_ERROR.getReturnCode());
            resp.setRespMessage(SaleLoanReturnCode.VERSION_ERRO_ERROR.getReturnMessage());
            return false;
        }
        logger.info("version validate success !");
        // 客户编号
        String userId = (String) headerMap.get(LoanRequestHeaderConstants.userid);
        if(StringUtil.isEmpty(userId)){
            logger.error("消息头客户编号为空或者不合法:[]",userId);
            bodyMap.put("respcode", SaleLoanReturnCode.UESRID_ERROR.getReturnCode());
            bodyMap.put("respmsg", SaleLoanReturnCode.UESRID_ERROR.getReturnMessage());
            resp.setRespCode(SaleLoanReturnCode.UESRID_ERROR.getReturnCode());
            resp.setRespMessage(SaleLoanReturnCode.UESRID_ERROR.getReturnMessage());
            return false;
        }
        logger.info("userid validate success !");
        // 会话编号
        String sessionId = (String) headerMap.get(LoanRequestHeaderConstants.sessionid);
        if(StringUtil.isEmpty(sessionId)){
            logger.error("回话ID为空或者不合法:[]",sessionId);
            bodyMap.put("respcode", SaleLoanReturnCode.SESSIONID_ERROR.getReturnCode());
            bodyMap.put("respmsg", SaleLoanReturnCode.SESSIONID_ERROR.getReturnMessage());
            resp.setRespCode(SaleLoanReturnCode.SESSIONID_ERROR.getReturnCode());
            resp.setRespMessage(SaleLoanReturnCode.SESSIONID_ERROR.getReturnMessage());
            return false;
        }
        logger.info("sessionid validate success !");
        // 申请来源
        String appsource = headerMap.get(LoanRequestHeaderConstants.appsource);
        if (StringUtil.isEmpty(appsource) || !ValidateUtil.checkInteger(appsource) || !(appsource.length()<=2)) {
            logger.error("用户来源为空或者不合法:[]",appsource);
            bodyMap.put("respcode", SaleLoanReturnCode.OTHER_ERROR.getReturnCode());
            bodyMap.put("respmsg", SaleLoanReturnCode.OTHER_ERROR.getReturnMessage());
            resp.setRespCode(SaleLoanReturnCode.OTHER_ERROR.getReturnCode());
            resp.setRespCode(SaleLoanReturnCode.OTHER_ERROR.getReturnMessage());
            return false;
        }
        logger.info("appsource validate success !");
        // 验证数字签名,暂不实现
        logger.info("validate header success !");
        return true;
    }
}
