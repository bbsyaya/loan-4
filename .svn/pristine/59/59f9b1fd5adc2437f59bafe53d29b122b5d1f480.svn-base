
package com.hrbb.loan.pos.biz.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.facade.LoanPosCreditApplyBizFacade;
import com.hrbb.loan.pos.facade.bean.QueryCreditApplyReq;
import com.hrbb.loan.pos.facade.bean.QueryCreditApplyRes;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;

/**
 *<h1>授信申请</h1>
 *@author Johnson Song
 *@version Id: LoanPosCreditApplyBizFacadeImpl.java, v 1.0 2015-2-26 上午11:44:35 Johnson Song Exp
 */
@Component("loanPosCreditApplyBizFacade")
public class LoanPosCreditApplyBizFacadeImpl implements LoanPosCreditApplyBizFacade{
	
	@Autowired
	private LoanPosCreditApplyService loanPosCreditApplyService;

	@Override
	public void creditApplyReg(Map<String, Object> reqMap) {
		//pos贷产品代码1001020306
		
		//查询是否存在该用户，有则更新，无则新增
		
		//如果是已有客户，判断客户是否黑名单客户，如果是业务状态直接拒绝，否则受理
		
		//账户验真
		
		//POS流水获取
		
		//公安系统查询
		
		//工商系统查询
		
		//邮件接口
		
		//短信接口
		//插入记录
		loanPosCreditApplyService.insertCreditApplyMap(reqMap);
	}

	@Override
	public List<Map<String, Object>> queryCreditApply(Map<String, Object> reqMap) {
		//查询所有受理状态及之后状态的申请数据，列表展示
		Long total = loanPosCreditApplyService.countCreditApply(reqMap);
		Map<String, Object> map = Maps.newHashMap();
		map.put("total", total);
		List<Map<String, Object>> list = loanPosCreditApplyService.getCreditApplyMap(reqMap);
		list.add(map);
		return list;
	}

	@Override
	public Map<String, Object> queryCreditApplyDetail(Map<String, Object> reqMap) {
		//查看该笔申请的详细信息
		return null;
	}

	@Override
	public void modifyCreditApplyInfo(Map<String, Object> reqMap) {
		//申请信息修改
		loanPosCreditApplyService.updateCreditApplyMap(reqMap);
	}

	@Override
	public void deleteCreditApplyInfo(Map<String, Object> reqMap) {
		//申请信息删除，逻辑删除
		loanPosCreditApplyService.updateCreditApplyMap(reqMap);
	}

	@Override
	public void cancelCreditApply(Map<String, Object> reqMap) {
		//申请撤销，客户主动提出撤销受理
	}

	




    /**
     * 
     * @see com.hrbb.loan.pos.facade.LoanPosCreditApplyBizFacade#queryCreditInfoById(com.hrbb.loan.pos.facade.bean.QueryCreditApplyReq)
     */
    public QueryCreditApplyRes queryCreditInfoById(QueryCreditApplyReq req){
//        List<Map<String, Object>> resList = creditApplyService.getCreditApply(CreditApplyConvert.CreditApplyReq2Map(req));
//        QueryCreditApplyRes res = CreditApplyConvert.Map2CreditApplyRe2(resList);
        QueryCreditApplyRes res = new QueryCreditApplyRes();
        return res;
    }


    
}

