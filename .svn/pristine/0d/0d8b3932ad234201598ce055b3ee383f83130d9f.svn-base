package com.hrbb.loan.pos.biz.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.hrbb.loan.pos.dao.entity.TBlacklist;
import com.hrbb.loan.pos.facade.bean.blacklist.BlacklistInfo;
import com.hrbb.loan.pos.facade.bean.blacklist.QueryBlacklistReq;
import com.hrbb.loan.pos.facade.bean.blacklist.QueryBlacklistRes;
import com.hrbb.loan.pos.facade.constants.SysRetCodeConstants;

/**
 * 黑名单静态转换类
 * 
 * @author XLY
 * @version $Id: BlacklistConvert.java, v 0.1 2015-2-28 下午3:22:11 XLY Exp $
 */
public class BlacklistConvert {

    /**
     * 请求转为map格式查询
     * 
     * @param r
     * @return
     */
    public static Map<String,Object> queryConvert2Req(QueryBlacklistReq r){
        Map<String,Object> m = new HashMap<String,Object>();
        BlacklistInfo b = r.getBlacklistInfo();
        if(null!=b){
            if(!StringUtils.isEmpty(b.getConfirmReason())){
                m.put("confirmReason", b.getConfirmReason());
            }
            if(!StringUtils.isEmpty(b.getConfirmUser())){
                m.put("confirmUser",b.getConfirmUser());
            }
            if(!StringUtils.isEmpty(b.getConfirmUserId())){
                m.put("confirmUserId",b.getConfirmUserId());
            }
            if(!StringUtils.isEmpty(b.getInfoDetail())){
                m.put("infoDetail", b.getInfoDetail());
            }
            if(!StringUtils.isEmpty(b.getInfoType())){
                m.put("infoType",b.getInfoType());
            }
            if(!StringUtils.isEmpty(b.getIntervalType())){
                m.put("invtervalType", b.getIntervalType());
            }
            if(!StringUtils.isEmpty(b.getInfoType())){
                m.put("infoType",b.getInfoType());
            }
            if(!StringUtils.isEmpty(b.getCertType())){
                m.put("certType",b.getCertType());
            }
            if(null!=(b.getConfirmTime())){
                m.put("confirmTime", b.getConfirmTime());
            }
            if(null!=(b.getEffectTime())){
                m.put("effectTime",b.getEffectTime());
            }
            if(null!=(b.getUneffTime())){
                m.put("uneffTime", b.getUneffTime());
            }
            if(!StringUtils.isEmpty(b.getEffectFlag())){
                m.put("effectFlag",b.getEffectFlag());
            }
        }
        if(!StringUtils.isEmpty(r.getPageNum())){
            m.put("pageNum", r.getPageNum());
        }
        if(!StringUtils.isEmpty(r.getPageSize())){
            m.put("pageSize", r.getPageSize());
        }

        return m;
    }

    /**
     * 结果转换
     * 
     * @param tBlackLists
     * @param totalRecords
     * @return
     */
    public static QueryBlacklistRes queryConvert2Res(List<TBlacklist> tBlackLists,String totalRecords){
        QueryBlacklistRes res = new QueryBlacklistRes();
        res.setTotalRecords(totalRecords);
        res.setRespCode(SysRetCodeConstants.SUCCESS.getCode());
        res.setMemo(SysRetCodeConstants.SUCCESS.getMessage());
        for(TBlacklist t :tBlackLists){
            res.getResultlist().add(BlacklistConvert.tBlacklist2BlacklistInfo(t));
        }
        return res;
    }  

    /**
     * service层转入facade层
     * 
     * @param tblacklist
     * @return
     */
    public static BlacklistInfo tBlacklist2BlacklistInfo(TBlacklist tblacklist){
        BlacklistInfo blacklistInfo= new BlacklistInfo();
        blacklistInfo.setCertType(tblacklist.getCertType());
        blacklistInfo.setConfirmReason(tblacklist.getConfirmReason());
        blacklistInfo.setConfirmTime(tblacklist.getConfirmTime());
        blacklistInfo.setConfirmUser(tblacklist.getConfirmUser());
        blacklistInfo.setCreateTime(tblacklist.getCreateTime());
        blacklistInfo.setEffectTime(tblacklist.getEffectTime());
        blacklistInfo.setId(tblacklist.getId());
        blacklistInfo.setInfoDetail(tblacklist.getInfoDetail());
        blacklistInfo.setInfoType(tblacklist.getInfoType());
        blacklistInfo.setIntervalType(tblacklist.getIntervalType());
        blacklistInfo.setModifyTime(tblacklist.getModifyTime());
        blacklistInfo.setUneffTime(tblacklist.getUneffTime());
        blacklistInfo.setConfirmUserId(tblacklist.getConfirmUserId());
        blacklistInfo.setEffectFlag(tblacklist.getEffectFlag());
        return blacklistInfo;
    }

    /**
     * facade层转入service层
     * 
     * @param b
     * @return
     */
    public static TBlacklist tlacklistInfo2BlacklistInfo(BlacklistInfo blackListInfo){
        TBlacklist tBlacklist = new TBlacklist();
        tBlacklist.setCertType(blackListInfo.getCertType());
        tBlacklist.setConfirmReason(blackListInfo.getConfirmReason());
        tBlacklist.setConfirmTime(blackListInfo.getConfirmTime());
        tBlacklist.setConfirmUser(blackListInfo.getConfirmUser());
        tBlacklist.setCreateTime(blackListInfo.getCreateTime());
        tBlacklist.setEffectTime(blackListInfo.getEffectTime());
        tBlacklist.setId(blackListInfo.getId());
        tBlacklist.setInfoDetail(blackListInfo.getInfoDetail());
        tBlacklist.setInfoType(blackListInfo.getInfoType());
        tBlacklist.setIntervalType(blackListInfo.getIntervalType());
        tBlacklist.setModifyTime(blackListInfo.getModifyTime());
        tBlacklist.setUneffTime(blackListInfo.getUneffTime());
        tBlacklist.setConfirmUserId(blackListInfo.getConfirmUserId());
        tBlacklist.setEffectFlag(blackListInfo.getEffectFlag());

        return tBlacklist;
    }
}
