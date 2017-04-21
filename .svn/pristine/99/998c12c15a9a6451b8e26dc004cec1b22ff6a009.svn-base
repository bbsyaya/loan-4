package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TUpsBillcardstatQueryInfoDao;
import com.hrbb.loan.pos.dao.TUpsBillcardstatSerialDao;
import com.hrbb.loan.pos.dao.TUpsIndexConsumeCityDao;
import com.hrbb.loan.pos.dao.TUpsIndexConsumeGategoriesDao;
import com.hrbb.loan.pos.dao.TUpsIndexMonthConsumeConditionDao;
import com.hrbb.loan.pos.dao.entity.TUpsBillcardstatQueryInfo;
import com.hrbb.loan.pos.dao.entity.TUpsBillcardstatSerial;
import com.hrbb.loan.pos.dao.entity.TUpsIndexConsumeCity;
import com.hrbb.loan.pos.dao.entity.TUpsIndexConsumeGategories;
import com.hrbb.loan.pos.dao.entity.TUpsIndexMonthConsumeCondition;
import com.hrbb.loan.pos.service.UpsDataApiService;
import com.hrbb.loan.pos.util.StringUtil;

/**
 * 银联智慧个人卡流水接口实现类
 * 
 * @author cjq
 * @version $Id: UpsDataApiServiceImpl.java, v 0.1 2015年7月27日 下午3:40:39 cjq Exp $
 */
@Component("upsDataApiServiceImpl")
public class UpsDataApiServiceImpl implements UpsDataApiService {

    private Logger                            logger = LoggerFactory.getLogger(UpsDataApiServiceImpl.class);

    @Autowired
    private TUpsBillcardstatSerialDao         upsBillcardstatSerialDao;

    @Autowired
    private TUpsBillcardstatQueryInfoDao      upsBillcardstatQueryInfoDao;

    @Autowired
    private TUpsIndexConsumeCityDao           upsIndexConsumeCityDao;

    @Autowired
    private TUpsIndexConsumeGategoriesDao     upsIndexConsumeGategoriesDao;

    @Autowired
    private TUpsIndexMonthConsumeConditionDao upsIndexMonthConsumeConditionDao;

    /** 
     * @see com.hrbb.loan.pos.service.UpsDataApiService#saveTUpsBillcardstatSerial(com.hrbb.loan.pos.dao.entity.TUpsBillcardstatSerial)
     */
    @Override
    public int saveTUpsBillcardstatSerial(TUpsBillcardstatSerial upsBillcardstatSerial) {
        return upsBillcardstatSerialDao.insert(upsBillcardstatSerial);
    }

    /** 
     * @see com.hrbb.loan.pos.service.UpsDataApiService#saveTUpsBillcardstatSerialBatch(java.util.List)
     */
    @Override
    public int saveTUpsBillcardstatSerialBatch(List<TUpsBillcardstatSerial> upsBillcardstatSerials) {
        return upsBillcardstatSerialDao.insertBatch(upsBillcardstatSerials);
    }

    /** 
     * @see com.hrbb.loan.pos.service.UpsDataApiService#saveUpsBillcardstatQueryInfo(com.hrbb.loan.pos.dao.entity.TUpsBillcardstatQueryInfo)
     */
    @Override
    public int saveUpsBillcardstatQueryInfo(TUpsBillcardstatQueryInfo upsBillcardstatQueryInfo) {
        return upsBillcardstatQueryInfoDao.insert(upsBillcardstatQueryInfo);
    }

    /** 
     * @see com.hrbb.loan.pos.service.UpsDataApiService#selectListByFileUuid(java.lang.String)
     */
    @Override
    public List<TUpsBillcardstatSerial> selectListByFileUuid(String fileUuid) {
        return upsBillcardstatSerialDao.selectTUpsBillcardstatSerials(fileUuid);
    }
    
    /** 
     * @see com.hrbb.loan.pos.service.UpsDataApiService#queryConsumeSummary(java.lang.String)
     */
    @Override
    public Map<String, Object> queryConsumeSummary(String fileUuid) {
        List<TUpsIndexMonthConsumeCondition> condition = upsBillcardstatSerialDao
            .selectCondition(fileUuid);
        List<TUpsIndexConsumeCity> city = upsBillcardstatSerialDao.selectCity(fileUuid);
        List<TUpsIndexConsumeGategories> mcc = upsBillcardstatSerialDao.selectMcc(fileUuid);
        Map<String, Object> respMap = Maps.newHashMap();
        respMap.put("consumeCity", city);
        respMap.put("consumeGategories", mcc);
        respMap.put("consumeCondition", condition);
        return respMap;
    }

    /** 
     * @see com.hrbb.loan.pos.service.UpsDataApiService#saveUpsBillcardConsumeSummary(java.util.Map)
     */
    @Override
    public int saveUpsBillcardConsumeSummary(Map<String, Object> reqMap) {
        try {
            @SuppressWarnings("unchecked")
            List<TUpsIndexConsumeCity> city = (List<TUpsIndexConsumeCity>) reqMap
                .get("consumeCity");
            @SuppressWarnings("unchecked")
            List<TUpsIndexConsumeGategories> gategories = (List<TUpsIndexConsumeGategories>) reqMap
                .get("consumeGategories");
            @SuppressWarnings("unchecked")
            List<TUpsIndexMonthConsumeCondition> condition = (List<TUpsIndexMonthConsumeCondition>) reqMap
                .get("consumeCondition");
            
            //消费汇总信息入库
            upsIndexConsumeCityDao.insertBatch(city);
            upsIndexConsumeGategoriesDao.insertBatch(gategories);
            upsIndexMonthConsumeConditionDao.insertBatch(condition);
        } catch (Exception e) {
            logger.error("系统异常", e);
        }
        return 0;
    }

    /** 
     * @see com.hrbb.loan.pos.service.UpsDataApiService#getFileUuid(java.lang.String)
     */
    @Override
    public String getFileUuid(String bankAccno) {
        if(StringUtil.isEmpty(bankAccno)){
            return null;
        }
        TUpsBillcardstatQueryInfo upsBillcardstatQueryInfo = upsBillcardstatQueryInfoDao.getRecentlyQueryInfo(bankAccno);
        if(upsBillcardstatQueryInfo !=null){
            return upsBillcardstatQueryInfo.getFileUuid();
        }
        return null;
    }

    /** 
     * @see com.hrbb.loan.pos.service.UpsDataApiService#queryConsumeSummaryNew(java.lang.String)
     */
    @Override
    public Map<String, Object> queryConsumeSummaryNew(String fileUuid) {
        List<TUpsIndexMonthConsumeCondition> condition = upsIndexMonthConsumeConditionDao.selectListByFileUuid(fileUuid);
        List<TUpsIndexConsumeCity> city = upsIndexConsumeCityDao.selectListByFileUuid(fileUuid);
        List<TUpsIndexConsumeGategories> mcc = upsIndexConsumeGategoriesDao.selectListByFileUuid(fileUuid);
        Map<String, Object> respMap = Maps.newHashMap();
        respMap.put("consumeCity", city);
        respMap.put("consumeGategories", mcc);
        respMap.put("consumeCondition", condition);
        return respMap;
    }

}
