package com.hrbb.loan.channel.gboss;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.hrbb.loan.channel.Processer;
import com.hrbb.loan.channel.gboss.client.QueryValidatorServicesSoapBindingStub;
import com.hrbb.loan.channel.gboss.obj.GbossResponseObj;
import com.hrbb.loan.channel.gboss.obj.VehicleInfo;
import com.hrbb.loan.pos.dao.entity.TDrivinglicenseInfo;
import com.hrbb.loan.pos.service.LoanPosChannelService;
import com.hrbb.loan.pos.util.StringUtil;

/**
 * 国政通： 车辆信息查询（批量）.
 * 
 * @author xiongshaogang
 * @version $Id: GbossProcesser.java, v 0.1 2015年4月27日 下午5:47:06 xiongshaogang Exp $
 */
@Component("gbossProcesser")
public class GbossProcesser extends Processer {

    private static Logger logger = LoggerFactory.getLogger(GbossProcesser.class);
    
    @Autowired
    private LoanPosChannelService loanPosChannelService;
    
    /**
     * params 规则：（车牌号码1,车辆类型1;车牌号码2,车辆类型2).
     * 
     * @param carKeyList
     * @return
     * @throws Exception 
     */
    public boolean queryCarBatch(String params) throws Exception {
        
        if (StringUtil.isEmpty(params)) {
            logger.error("入参为空");
            setRespCode("0001");
            setRespMsg("入参为空");
            return false;
        }
        
        String[] tmpAarry = params.split(",", -1);
        if (tmpAarry == null || tmpAarry.length < 1) {
            logger.error("入参格式错");
            setRespCode("0002");
            setRespMsg("入参格式错");
            return false;
        }
        
        QueryValidatorServicesSoapBindingStub client = new QueryValidatorServicesSoapBindingStub();
        logger.info("国政通行驶证查询请求参数 : [" + params + "]");
        String respXml = client.queryBatch("username", "userpassword", "1V010101", params);
        logger.info("国政通行驶证查询应答报文 : [" + respXml + "]");
        
        if (StringUtil.isEmpty(respXml)) {
            logger.error("通讯失败");
            setRespCode("0003");
            setRespMsg("通讯失败");
            return false;
        }
        
        // 应答报文解析
        GbossResponseObj gbossResponseObj = new GbossResponseObj();
        if (!gbossResponseObj.parseXml(respXml)) {
            logger.error("应答报文解析失败");
            setRespCode("0004");
            setRespMsg("应答报文解析失败");
            return false;
        }
        
        // 持久化处理
        List<TDrivinglicenseInfo> tDrivinglicenseInfos = transferObj(gbossResponseObj);
        if (tDrivinglicenseInfos == null || tDrivinglicenseInfos.size() < 1) {
            logger.error("应答数据异常");
            setRespCode("0005");
            setRespMsg("应答数据异常");
            return false;
        }
        
        if (!loanPosChannelService.insertTDrivinglicenseInfo(tDrivinglicenseInfos)) {
            logger.error("国政通数据入库异常");
            setRespCode("0006");
            setRespMsg("国政通数据入库异常");
            return false;
        }
        
        return true;
    }
    
    /**
     * 对象转换.
     * 
     * @param gbossResponseObj
     * @return
     */
    private List<TDrivinglicenseInfo> transferObj(GbossResponseObj gbossResponseObj) {
        List<TDrivinglicenseInfo> tDrivinglicenseInfos = Lists.newArrayList();
        if ("1".equals(gbossResponseObj.getMessageStatus())) {
            return null;
        }
        
        List<VehicleInfo> vehicleInfos = gbossResponseObj.getVehicleInfoList();
        for (int i = 0; i < vehicleInfos.size(); i++) {
            VehicleInfo vehicleInfo = vehicleInfos.get(i);
            if ("1".equals(vehicleInfo.getMessageStatus())) {
                continue;
            }
            
            TDrivinglicenseInfo tDrivinglicenseInfo = new TDrivinglicenseInfo();
            tDrivinglicenseInfo.setCphm(vehicleInfo.getCphm());
            tDrivinglicenseInfo.setCllx(vehicleInfo.getCllx());
            tDrivinglicenseInfo.setSyr(vehicleInfo.getSyr());
            tDrivinglicenseInfo.setCpxh(vehicleInfo.getCpxh());
            tDrivinglicenseInfo.setZt(vehicleInfo.getZt());
            tDrivinglicenseInfo.setSyxz(vehicleInfo.getSyxz());
            tDrivinglicenseInfo.setCcdjrq(vehicleInfo.getCcdjrq());
            tDrivinglicenseInfo.setFzrq(vehicleInfo.getFzrq());
            tDrivinglicenseInfo.setJyyxqz(vehicleInfo.getJyyxqz());
            tDrivinglicenseInfo.setDyqk(vehicleInfo.getDyqk());
            tDrivinglicenseInfo.setCreatetime(new Date());
            tDrivinglicenseInfo.setLstupdtime(new Date());
            
            tDrivinglicenseInfos.add(tDrivinglicenseInfo);
        }
        
        return tDrivinglicenseInfos;
    }

}
