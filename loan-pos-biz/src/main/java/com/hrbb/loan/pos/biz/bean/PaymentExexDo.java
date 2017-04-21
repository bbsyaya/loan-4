package com.hrbb.loan.pos.biz.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.biz.bean.pay.IPayService;
import com.hrbb.loan.pos.biz.bean.pay.PayServiceFactory;
import com.hrbb.loan.pos.biz.bean.pay.constant.PayTypeEnum;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.sh.framework.HServiceException;

/**
 * 放款交易执行
 * 
 * @author cjq
 * @version $Id: PaymentExexDo.java, v 0.1 2015年8月7日 下午2:30:05 cjq Exp $
 * @date 2015-08-07
 */
public class PaymentExexDo extends AbsInternalService {

    private static final long serialVersionUID = 473747531825671709L;

    private Logger            logger           = LoggerFactory.getLogger(PaymentExexDo.class);

    private TReceiptInfo      receipt;

    public TReceiptInfo getReceipt() {
        return receipt;
    }

    /**
     * 构造器
     * @param receiptInfo 借据
     */
    public PaymentExexDo(TReceiptInfo receipt) {
        this.receipt = receipt;
    }

    /** 
     * 初始化service
     * @see com.hrbb.loan.pos.biz.bean.AbsInternalService#initService()
     */
    @Override
    public boolean initService() throws HServiceException {
        return true;
    }

    @Override
    public boolean processService() throws HServiceException {
        try {
            IPayService service = PayServiceFactory.getThirdPayService(PayTypeEnum.PAY.getPayTypeCode(), receipt);
            return service.pay();
        } catch (Exception e) {
            logger.error("放款失败", e);
            return false;
        }
    }

    @Override
    public boolean processService(String fileName, byte[] bytes) throws HServiceException {
        // TODO Auto-generated method stub
        return false;
    }
}
