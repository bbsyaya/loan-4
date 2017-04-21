package com.hrbb.loan.pos.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TBdExecutorDao;
import com.hrbb.loan.pos.dao.TBdInstitutionDao;
import com.hrbb.loan.pos.dao.TBdRegionDao;
import com.hrbb.loan.pos.dao.entity.TBdExecutor;
import com.hrbb.loan.pos.dao.entity.TBdInstitution;
import com.hrbb.loan.pos.dao.entity.TBdRegion;
import com.hrbb.loan.pos.service.BDManagementService;
import com.hrbb.loan.pos.util.StringUtil;

@Service("BDManagementService")
public class BDManagementServiceImpl implements BDManagementService {
    
    private static final Logger LOG = LoggerFactory.getLogger(BDManagementServiceImpl.class);

    @Autowired
    private TBdInstitutionDao bdInstitutionDao;

    @Autowired
    private TBdExecutorDao    bdExecutorDao;
    
    @Autowired
    private TBdRegionDao bdRegionDao;

    @Override
    public List<TBdInstitution> queryTbdInstitutions() {
        return bdInstitutionDao.selectList();
    }

    @Override
    public List<TBdInstitution> queryTbdInstitutions(Map<String, Object> reqMap) {
        return bdInstitutionDao.selectListBySelective(reqMap);
    }

    @Override
    public Long countTbdInstitutions(Map<String, Object> reqMap) {
        return bdInstitutionDao.countListBySelective(reqMap);
    }

    @Override
    public List<TBdExecutor> queryBDExecutors(Map<String, Object> reqMap) {
        return bdExecutorDao.selectListBySelective(reqMap);
    }

    @Override
    public Long countTbdExecutors(Map<String, Object> reqMap) {
        return bdExecutorDao.countListBySelective(reqMap);
    }

    @Override
    public TBdInstitution selectByBelongOrg(Integer BelongOrg) {
        return bdInstitutionDao.selectByPrimaryKey(BelongOrg);
    }

    @Override
    public TBdInstitution selectByBelongOrgName(String belongOrgName) {
        return bdInstitutionDao.selectByBelongOrgName(belongOrgName);
    }
    
    @Override
    public TBdInstitution selectByAlias(String alias){
        return bdInstitutionDao.selectByAlias(alias);
    }
    
    @Override
    public int saveInstitution(Map<String, Object> reqMap) {
        return bdInstitutionDao.insertSelectiveMap(reqMap);
    }

    @Override
    public int modifyInstitution(Map<String, Object> reqMap) {
        return bdInstitutionDao.updateByUpdateMap(reqMap);
    }

    @Override
    public int saveExecutor(Map<String, Object> reqMap) {
        String belongOrg = (String)reqMap.get("belongOrg");
        if(belongOrg != null){
            try {
                TBdInstitution bdInstitution = bdInstitutionDao.selectByPrimaryKey(Integer.parseInt(belongOrg));
                reqMap.put("belongOrgName", bdInstitution.getOrgName());
            } catch (NumberFormatException e) {
                LOG.error("类型转换错误", e);
            }    
        }
        return bdExecutorDao.insertSelectiveMap(reqMap);
    }
    
    @Override
    public int importExcelExecutor(TBdExecutor bdExecutor) {
        //如果展业机构存在,更新所属机构号;否则,不更新
        TBdInstitution bdInstitution = bdInstitutionDao.selectByBelongOrgName(bdExecutor
            .getBelongOrgName());
        if (bdInstitution != null) {
            bdExecutor.setBelongOrg(bdInstitution.getOrgId());
        }else{
            bdExecutor.setBelongOrg(0);
        }
        //如果该展业人员已存在其他机构,而且有active='Y',则更新为'N'
        List<TBdExecutor> bdExecutor2 = bdExecutorDao.selectByCertNo(bdExecutor.getCertNo());
        if (!bdExecutor2.isEmpty()) {
            for (TBdExecutor tBdExecutor : bdExecutor2) {
                if (StringUtil.isNotEmpty(tBdExecutor.getActive())  && "Y".equals(tBdExecutor.getActive())) {
                    bdExecutor.setActive("N");
                    break;
                }
            }
        }
        return bdExecutorDao.insertSelective(bdExecutor);
    }

    @Override
    public int modifyExector(Map<String, Object> reqMap) {
        return bdExecutorDao.updateByPrimaryKeySelectiveMap(reqMap);
    }
    
    @Override
    public int modifyExecutorByBelongOrgName(String belongOrgName, Integer belongOrg) {
        return bdExecutorDao.updateExecutorByBelongOrg(belongOrgName,belongOrg);
    }

    @Override
    public int deleteExector(Integer menberId) {
        return bdExecutorDao.updateExecutorActive(menberId, "N");
    }
    
    @Override
    public int activeExector(Integer menberId) {
        return bdExecutorDao.updateExecutorActive(menberId, "Y");
    }

    @Override
    public TBdExecutor selectByMenberId(Integer menberId) {
        return bdExecutorDao.selectByPrimaryKey(menberId);
    }
    
    @Override
    public List<TBdRegion> queryTBdRegion(Map<String, Object> reqMap) {
        return bdRegionDao.queryRegion(reqMap);
    }

    @Override
    public int saveRegion(TBdRegion tBdRegion) {
        // step1:先添加省份
        String provinceRegion = tBdRegion.getRegion().substring(0, 2)+"0000";
        Map<String,Object> param = Maps.newHashMap();
        param.put("region", provinceRegion);
        param.put("status", "1");
        param.put("orgId", tBdRegion.getOrgId());
        List<TBdRegion> list = bdRegionDao.selectTBRegionsByReqMap(param);
        if(list == null || list.isEmpty()){
            TBdRegion province = new TBdRegion();
            province.setOrgId(tBdRegion.getOrgId());
            province.setRegion(provinceRegion);
            province.setStatus("1");
            province.setCreateTime(new Date());
            province.setUpdateTime(new Date());
            bdRegionDao.insert(province);
        }
        // step2:删除status相反的城市配置
        if(tBdRegion.getStatus().equals("1")){
            param.clear();
            param.put("orgId", tBdRegion.getOrgId());
            param.put("cityLike", tBdRegion.getRegion().substring(0, 2)+"__00");
            param.put("provinceLike", tBdRegion.getRegion().substring(0, 2)+"0000");
            param.put("status", "0");
            
            bdRegionDao.deleteByStatusParam(param);
        }else{
            param.clear();
            param.put("orgId", tBdRegion.getOrgId());
            param.put("cityLike", tBdRegion.getRegion().substring(0, 2)+"__00");
            param.put("provinceLike", tBdRegion.getRegion().substring(0, 2)+"0000");
            param.put("status", "1");
            bdRegionDao.deleteByStatusParam(param);
        }
        //TODO 数据检验
        param.clear();
        param.put("region", tBdRegion.getRegion());
        param.put("orgId", tBdRegion.getOrgId());
        bdRegionDao.deleteRegion(param);
        return bdRegionDao.insert(tBdRegion);
    }

    @Override
    public int delRegion(Map<String, Object> reqMap) {
        String region = (String)reqMap.get("region");
        if(StringUtil.isNotEmpty(region) && (region.substring(0, 2)+"0000").equals(region)){//如果是省，那么对应所属的市全部删掉
            Map<String,Object> delMap = Maps.newHashMap();
            delMap.put("orgId", reqMap.get("orgId"));
            delMap.put("cityLike", region.substring(0,2)+"__00");
            delMap.put("provinceLike", region.substring(0, 2)+"0000");
            bdRegionDao.deleteByStatusParam(delMap);
        }
        return bdRegionDao.deleteRegion(reqMap);
    }

    @Override
    public Long countRegion(Map<String, Object> reqMap) {
        return bdRegionDao.count(reqMap);
    }

    @Override
    public List<TBdRegion> selectTBRegionsByReqMap(Map<String, Object> reqMap) {
        return bdRegionDao.selectTBRegionsByReqMap(reqMap);
    }
    
    @Override
    public List<TBdRegion> queryTBbRegionsByCode(Map<String,Object> reqMap){
        return bdRegionDao.selectTBbRegionsByCode(reqMap);
    }
    

}
