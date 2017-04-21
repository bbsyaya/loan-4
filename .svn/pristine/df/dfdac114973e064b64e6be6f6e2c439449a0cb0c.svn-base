package com.hrbb.loan.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TDrivinglicenseInfoDao;
import com.hrbb.loan.pos.dao.entity.TDrivinglicenseInfo;
import com.hrbb.loan.pos.service.LoanPosChannelService;

/**
 * 渠道服务事务实现.
 * 
 * @author xiongshaogang
 * @version $Id: LoanPosChannelServiceImpl.java, v 0.1 2015年4月28日 上午10:27:17 xiongshaogang Exp $
 */
@Service("loanPosChannelService")
public class LoanPosChannelServiceImpl implements LoanPosChannelService {

    @Autowired
    private TDrivinglicenseInfoDao tDrivinglicenseInfoDao;
    
    @Override
    public boolean insertTDrivinglicenseInfo(List<TDrivinglicenseInfo> inserTDrivinglicenseInfos) {
        
        int insertRet = 0, updateRet = 0;
        
        for (int i = 0; i < inserTDrivinglicenseInfos.size(); i++) {
            TDrivinglicenseInfo tDrivinglicenseInfo = inserTDrivinglicenseInfos.get(i);
            
            TDrivinglicenseInfo tmptDrivinglicenseInfo = tDrivinglicenseInfoDao.selectByPrimaryKey(tDrivinglicenseInfo.getCphm());
            if (tmptDrivinglicenseInfo == null) {
                insertRet += tDrivinglicenseInfoDao.insert(tDrivinglicenseInfo);
            } else {
                tDrivinglicenseInfo.setCreatetime(tmptDrivinglicenseInfo.getCreatetime());
                updateRet += tDrivinglicenseInfoDao.updateByPrimaryKey(tDrivinglicenseInfo);
            }
        }
        
        if (insertRet + updateRet == inserTDrivinglicenseInfos.size()) {
            return true;
        }
        
        return false;
    }

}
