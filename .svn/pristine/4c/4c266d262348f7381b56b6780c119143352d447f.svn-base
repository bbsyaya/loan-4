package com.hrbb.loan.pos.biz.facade;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBlacklistBackStageBiz;
import com.hrbb.loan.pos.biz.convert.BlacklistConvert;
import com.hrbb.loan.pos.biz.hession.LoanPosBlackBizHession;
import com.hrbb.loan.pos.dao.entity.TBlacklist;
import com.hrbb.loan.pos.facade.LoanPosBlacklistBizFacade;
import com.hrbb.loan.pos.facade.bean.blacklist.BlacklistInfo;
import com.hrbb.loan.pos.facade.bean.blacklist.BlacklistInfoInsertRes;
import com.hrbb.loan.pos.facade.bean.blacklist.BlacklistInfoUpdateRes;
import com.hrbb.loan.pos.facade.bean.blacklist.QueryBlacklistReq;
import com.hrbb.loan.pos.facade.bean.blacklist.QueryBlacklistRes;
import com.hrbb.loan.pos.facade.constants.SysRetCodeConstants;
import com.hrbb.loan.pos.service.LoanPosBlacklistService;
import com.hrbb.loan.pos.service.bean.BlackListQueryResVo;

/**
 * 
 * 
 * @author XLY
 * @version $Id: LoanPosBlacklistBizFacadeImpl.java, v 0.1 2015-2-28 下午3:19:54 XLY Exp $
 */
public class LoanPosBlacklistBizFacadeImpl implements LoanPosBlacklistBizFacade,ILoanPosBlacklistBackStageBiz,LoanPosBlackBizHession{
    private Logger LOG = LoggerFactory.getLogger(LoanPosBlacklistBizFacade.class);

    @Autowired
    private LoanPosBlacklistService loanPosBlacklistService;
    
    /**
     * 增加用户记录
     * 
     * @param res
     * @return
     */
    public BlacklistInfoInsertRes addBlacklistInfo(BlacklistInfo req){
        BlacklistInfoInsertRes res = new BlacklistInfoInsertRes();
        TBlacklist tBlacklist = BlacklistConvert.tlacklistInfo2BlacklistInfo(req);
        try {
            loanPosBlacklistService.insertTBlacklist(tBlacklist);
            res.setRespCode(SysRetCodeConstants.SUCCESS.getCode());
            res.setMemo(SysRetCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            LOG.error("update blacklist error");
            res.setRespCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            res.setMemo(SysRetCodeConstants.SYSTEM_ERROR.getMessage());
        }
        return res;
    }
    
    /**
     * 跟新用户信息
     * 
     * @param req
     * @return
     */
    public BlacklistInfoUpdateRes updateBlacklistInfo(BlacklistInfo req){
        BlacklistInfoUpdateRes res = new BlacklistInfoUpdateRes();
        TBlacklist tBlacklist = BlacklistConvert.tlacklistInfo2BlacklistInfo(req);
        try {
            int i = loanPosBlacklistService.updateTBlacklist(tBlacklist);
            if(i==1){
                res.setRespCode(SysRetCodeConstants.SUCCESS.getCode());
                res.setMemo(SysRetCodeConstants.SUCCESS.getMessage());
            }else{
                res.setRespCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
                res.setMemo(SysRetCodeConstants.DATA_NOT_EXIST.getMessage());
            }
        } catch (Exception e) {
            LOG.error("update blacklist error");
            res.setRespCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            res.setMemo(SysRetCodeConstants.SYSTEM_ERROR.getMessage());
        }
        return res;
    }
    
    /**
     * 批量查询黑名单
     * 
     * @param req
     * @return
     */
    public QueryBlacklistRes queryBlackLists(QueryBlacklistReq req){
        QueryBlacklistRes res = new QueryBlacklistRes();
        BlackListQueryResVo result;
        try {
            result = loanPosBlacklistService.queryTBlacklists(BlacklistConvert.queryConvert2Req(req));
            res = BlacklistConvert.queryConvert2Res(result.getList(), result.getTotalRecodeNum());
        } catch (Exception e) {
            LOG.error("update blacklist error");
            res.setRespCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            res.setMemo(SysRetCodeConstants.SYSTEM_ERROR.getMessage());        
         }
        return res;
    }
    
    public List<Map<String, Object>> queryBlacklist(Map<String, Object> reqMap) {
        //查询所有受理状态及之后状态的申请数据，列表展示
        Long total = loanPosBlacklistService.countBlacklist(reqMap);
        Map<String, Object> map = Maps.newHashMap();
        map.put("total", total);
        List<Map<String, Object>> list = loanPosBlacklistService.getBlacklistMap(reqMap);
        list.add(map);
        return list;
    }
    
    public QueryBlacklistRes queryBlackListsHession(QueryBlacklistReq req){
        return this.queryBlackLists(req);
    }

    
    public List<Map<String, Object>> queryBlacklistHession(Map<String, Object> reqMap){
        return queryBlacklist(reqMap);
    }
    
    public void  insertBlacklist(Map<String, Object> reqMap){
        loanPosBlacklistService.insertSelectiveMap(reqMap);
    }
    
    public void  updateBlacklist(Map<String, Object> reqMap){
        loanPosBlacklistService.updateSelectiveMap(reqMap);
    }

	/** 
	 * @see com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBlacklistBackStageBiz#insertBlacklists(com.hrbb.loan.pos.dao.entity.TBlacklist)
	 */
	@Override
	public int insertBlacklists(TBlacklist bl) {
		return 0;
	}


}
