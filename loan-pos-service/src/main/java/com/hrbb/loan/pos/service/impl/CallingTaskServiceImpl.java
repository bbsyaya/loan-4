package com.hrbb.loan.pos.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TCallingTaskDao;
import com.hrbb.loan.pos.dao.TCustomerDao;
import com.hrbb.loan.pos.dao.TPosCustInfoDao;
import com.hrbb.loan.pos.dao.entity.TCallingTask;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TPosCustInfo;
import com.hrbb.loan.pos.service.ApproveResultService;
import com.hrbb.loan.pos.service.CallingTaskService;
import com.hrbb.loan.pos.service.LoanPosBusinessCodeService;
import com.hrbb.loan.pos.service.LoanPosContractManagementService;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;

@Service("CallingTaskService")
public class CallingTaskServiceImpl implements CallingTaskService {
    
    Logger                                   logger = LoggerFactory
                                                        .getLogger(CallingTaskServiceImpl.class);

    @Autowired
    @Qualifier("tCallingTaskDao")
    TCallingTaskDao                          dao;

    @Autowired
    private TCustomerDao                     custDao;

    @Autowired
    private TPosCustInfoDao                  posCustDao;

    @Autowired
    private LoanPosCreditApplyService        loanPosCreditApplyService;

    @Autowired
    private ApproveResultService             approveResultService;

    @Autowired
    private LoanPosBusinessCodeService       loanPosBusinessCodeService;

    @Autowired
    private LoanPosContractManagementService loanPosContractManagementService;

	@Override
	public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> l = dao.selectSelective(reqMap);
		
		for (Map<String, Object> map : l) {
			if (map.get("generateTime")!=null) {
				
				try {
					map.put("generateTime", DateUtil.getDateToString3((Date)map.get("generateTime")).toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (map.get("claimTime")!=null) {
				
				try {
					map.put("claimTime", DateUtil.getDateToString3((Date)map.get("claimTime")).toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (map.get("callingType") !=null){
				map.put("callingTypeName", loanPosBusinessCodeService.getItemNameByNo("CallingType",map.get("callingType").toString()));
			}
		}
		return l;
	}
	@Override
	public long selectSelectiveForReviewCount(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.selectSelectiveForReviewCount(reqMap);
	}

	@Override
	public TCallingTask selectOne(String taskNo) {
		// TODO Auto-generated method stub
		TCallingTask callingTask = (TCallingTask)dao.selectByPrimaryKey(taskNo);
		if (callingTask.getGenerateTime()!=null) {
			try {
				String datesString = DateUtil.getDateToString3(callingTask.getGenerateTime());
				callingTask.setGenerateTime(DateUtil.getDatePattern3(datesString.toString()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return callingTask;
	}

	@Override
	public boolean updateTaskClaimer(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		String[] taskNoes = reqMap.get("taskNo").toString().split(
				ReviewNoteConstants.STRING_SEPARATOR_CODE);
		int count = 0;
		for (int i = 0; i < taskNoes.length; i++) {
			reqMap.put("taskNo", taskNoes[i]);
			int num = dao.updateTaskClaimer(reqMap);
			if (num >0) {
				count++;
			}
		}
		if (count<=0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateGenerateTime(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		int count = dao.updateGenerateTime(reqMap);
		if (count>0) {
			return true;
		}
		return false;
	}
	@Override
	public List<TCallingTask> getTCallingTask(Map<String, Object> reqMap) {
		return dao.getTCallingTask(reqMap);
	}
	@Override
	public int updateTcallingTask1(Map<String, Object> map) {
		return dao.updateTcallingTask1(map);
		
	}
	@Override
	public int updateTcallingTask2(Map<String, Object> map) {
		return dao.updateTcallingTask2(map);
	}
	
	@Override
	public int insertSelective(TCallingTask record) {
	    /*add by cjq 2015-09-02 */
        if (record == null) {
            logger.info("外呼任务不存在");
            return 1;
        }
        String relaBizPhase = record.getRelaBizPhase();
        String relaBizNo = record.getRelaBizNo();
        String channel = null;
        if (!StringUtil.isEmpty(relaBizNo) && !StringUtil.isEmpty(relaBizNo)) {

            if (ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APP.equals(relaBizPhase)) {//申请阶段
                String loanId = relaBizNo;
                channel = loanPosCreditApplyService.getChannelByLoanId(loanId);
            } else if (ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APR.equals(relaBizPhase)) {//审批阶段
                String approveId = relaBizNo;
                Map<String, Object> resultMap = approveResultService.getApproveMap(approveId);
                if (resultMap != null) {
                    channel = (String) resultMap.get("channel");
                }
            } else if (ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_ISS.equals(relaBizPhase)) {//用款阶段
                String payApplyId = relaBizNo;
                TContractManagement contract = loanPosContractManagementService
                    .getContractInfoByPayapplyId(payApplyId);
                if (contract != null) {
                    channel = contract.getChannel();
                }
            }
            if (!StringUtil.isEmpty(channel)) {
                if (BusinessDictionaryConstants.BIZ_CHANNEL_58.equals(channel)
                    || BusinessDictionaryConstants.BIZ_CHANNEL_UM.equals(channel)) {
                    logger.info("58/银商不生成外呼任务");
                    return 1;
                }
            }
        }
        /*end add by cjq 2015-09-02*/
        
		//客户名
		TCustomer c = custDao.selectByPrimaryKey(record.getCustId());
		if (c != null){
			record.setCustName(c.getCustName());
		}
		//商户名
		TPosCustInfo pc = posCustDao.selectByPrimaryKey(record.getPosCustId());
		if (pc != null){
			record.setPosCustName(pc.getPosCustName());
		}
		return dao.insertSelective(record);
	}
}
