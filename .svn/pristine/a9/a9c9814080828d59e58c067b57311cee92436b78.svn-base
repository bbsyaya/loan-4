/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.converts;

import com.hrbb.loan.pos.dao.entity.TPosSerialnoInfo;
import com.hrbb.loan.pos.service.bean.PosSerialnoInfoBean;

/**
 * 
 * @author XLY
 * @version $Id: PosSerialnoInfoConvert.java, v 0.1 2015-3-12 上午9:59:31 XLY Exp $
 */
public class PosSerialnoInfoConvert {

    public static PosSerialnoInfoBean dal2ServiceBean(TPosSerialnoInfo t){
        PosSerialnoInfoBean p = new PosSerialnoInfoBean();
        p.setCardLastFourState(t.getCardLastFourState());
        p.setCreditCardTradeAmtRate(t.getCreditCardTradeAmtRate());
        p.setCreditCardTradeNumRate(t.getCreditCardTradeNumRate());
        p.setDifferentCardNoNum(t.getDifferentCardNoNum());
        p.setMaxTradeAmtPerWeek(t.getMaxTradeAmtPerWeek());
        p.setPosKind(t.getPosKind());
        p.setPosSerialNo(t.getPosSerialNo());
        p.setRegTimeTradeAmt(t.getRegTimeTradeAmt());
        p.setRegTimeTradeNum(t.getRegTimeTradeNum());
        p.setTradeAmt(t.getTradeAmt());
        p.setTradeCardKind(t.getTradeCardKind());
        p.setTradeDate(t.getTradeDate());
        p.setTradeNum(t.getTradeNum());
        p.setTradeTime(t.getTradeTime());
        return p;
    }
}
