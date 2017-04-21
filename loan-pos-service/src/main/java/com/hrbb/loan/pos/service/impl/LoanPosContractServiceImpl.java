package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TContractDao;
import com.hrbb.loan.pos.dao.entity.TContract;
import com.hrbb.loan.pos.service.LoanPosContractService;

/**
 *<h1>合同Service实现</h1>
 *@author Johnson Song
 *@version Id: LoanPosContractServiceImpl.java, v 1.0 2015-2-25 上午9:37:13 Johnson Song Exp
 */
@Service("loanPosContractServiceImpl")
public class LoanPosContractServiceImpl implements LoanPosContractService {
	
	@Autowired
	private TContractDao tContractDao;
	
	/**
	 * <h2>根据id获取记录</h2>
	 * @param String
	 * @return TContract
	 */
	@Override
	public TContract getContractById(String contNo) {
		return tContractDao.selectByPrimaryKey(contNo);
	}
	
	/**
	 * <h2>根据条件获取记录</h2>
	 * @param Map
	 * @return List
	 */
	@Override
	public List<TContract> getSelective(Map<String, Object> map) {
		return tContractDao.selectSelective(map);
	}
	
	/**
	 * <h2>插入记录</h2>
	 * @param TContract
	 * @return int
	 */
	@Override
	public int insertContract(TContract req) {
		return tContractDao.insertSelective(req);
	}
	
	/**
	 * <h2>更新记录</h2>
	 * @param TContract
	 * @return int
	 */
	@Override
	public int updateContract(TContract req) {
		return tContractDao.updateByPrimaryKeySelective(req);
	}
	
	/**
	 * <h2>删除记录</h2>
	 * @param String
	 * @return int
	 */
	@Override
	public int deleteContract(String contNo) {
		return tContractDao.deleteByPrimaryKey(contNo);
	}

}
