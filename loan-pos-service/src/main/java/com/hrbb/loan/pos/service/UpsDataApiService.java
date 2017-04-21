package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TUpsBillcardstatQueryInfo;
import com.hrbb.loan.pos.dao.entity.TUpsBillcardstatSerial;

/**
 * 银联智慧个人卡流水接口
 * 
 * @author cjq
 * @version $Id: UpsDataApiService.java, v 0.1 2015年7月16日 上午10:57:49 cjq Exp $
 */
public interface UpsDataApiService {
    
    /**
     * 保存流水
     * 
     * @param upsBillcardstatSerial
     * @return
     */
    int saveTUpsBillcardstatSerial(TUpsBillcardstatSerial upsBillcardstatSerial);
    
    /**
     * 批量保存消费流水
     * 
     * @param upsBillcardstatSerials
     * @return
     */
    int saveTUpsBillcardstatSerialBatch(List<TUpsBillcardstatSerial> upsBillcardstatSerials);

    /**
     * 保存查询记录
     * 
     * @param upsBillcardstatQueryInfo
     * @return
     */
    int saveUpsBillcardstatQueryInfo(TUpsBillcardstatQueryInfo upsBillcardstatQueryInfo);
    
    /**
     * 查询消费明细
     * 
     * @param fileUuid
     * @return
     */
    List<TUpsBillcardstatSerial> selectListByFileUuid(String fileUuid);

    /**
     * 查询消费汇总情况
     * 
     * @param fileUuid 文件标识符
     * @return
     */
    Map<String, Object> queryConsumeSummary(String fileUuid);
    
    /**
     * 保存消费汇总
     * 
     * @param reqMap
     * @return
     */
    int saveUpsBillcardConsumeSummary(Map<String,Object> reqMap);
    
    /**
     * 获取最近的fileUuid
     * 
     * @param bankAccno
     * @return
     */
    String getFileUuid(String bankAccno);
    
    /**
     * 查询消费汇总情况，数据来源于各个汇总表
     * 
     * @param fileUuid
     * @return
     */
    Map<String,Object> queryConsumeSummaryNew(String fileUuid);
}
