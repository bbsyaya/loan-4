package com.hrbb.loan.pos.biz.backstage.inter.async;

import java.util.Date;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.biz.backstage.inter.IId5Service;
import com.hrbb.loan.pos.biz.bean.SeriaAsyncResult;
import com.hrbb.loan.pos.dao.TCustomerDao;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TFixLineInfo;
import com.hrbb.loan.pos.factory.ConfigService;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.FixLineInfoService;
import com.hrbb.loan.pos.util.JsonUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.sh.frontier.biz.id5.bean.ChinaTelecomUnicomInfo;
import com.hrbb.sh.frontier.biz.id5.bean.FixedLineQueryResponse;
import com.hrbb.sh.frontier.biz.id5.bean.Request;
import com.hrbb.sh.frontier.biz.id5.facade.Id5Facade;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年10月8日下午3:31:54 
 */
@Service
public class LoadId5InfoService implements IId5Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadId5InfoService.class);
    @Autowired
    private Id5Facade id5Facade;
    @Autowired
    private FixLineInfoService fixLineInfoService;
    @Autowired
    private TCustomerDao customerDao;
    private static String endpoint;
    private static String username;
    private static String password;
    private static String datasourceQueryFixedLineData;

    static {
        ConfigService configService = SysConfigFactory.getInstance().getService("guozhengtongService");
        endpoint = configService.getPropertyValue("endpoint");
        username = configService.getPropertyValue("username");
        password = configService.getPropertyValue("password");
        datasourceQueryFixedLineData = SysConfigFactory.getInstance().getService("guozhengtongService")
                .getPropertyValue("datasource_queryFixedLineData");
    }

    @Async
    public void asyncQueryFixedLineData(String loanId) {
        LOGGER.debug("current thread name:" + Thread.currentThread().getName());
        String telNum = getTelNum(loanId);
        if (null == telNum) {
            LOGGER.warn("查询不到loanId:" + loanId + "的座机号码信息");
            return;
        }

        FixedLineQueryResponse response = queryFixedLineInfo(telNum);
        if (null == response || null == response.getList() || 1 > response.getList().size()) {
            LOGGER.warn("查询不到固话信息");
            return ;
        }
        saveOrUpdateFixLineInfo(response);
    }

    /**
     * @param telNum 座机号码
     * @return 固话综合信息
     */
    private FixedLineQueryResponse queryFixedLineInfo(String telNum) {
        Request request = new Request();
        request.setEndpoint(endpoint);
        request.setDatasource(datasourceQueryFixedLineData);
        request.setUsername(username);
        request.setPassword(password);
        request.setParam(telNum);
        FixedLineQueryResponse response = null;
        try {
            response = id5Facade.queryFixedLineData(request);
        } catch (Exception e) {
            LOGGER.error("固话查询失败，" + "传入的参数param:" + telNum + ",response:" + JsonUtil.toJson(response) + "\n"
                    + ExceptionUtils.getStackTrace(e));
        }
        return response;
    }

    /**
     * @param loanId 贷款申请编号
     * @return 申请人座机号码
     */
    private String getTelNum(String loanId) {
        TCustomer customer = customerDao.selectByLoanId(loanId);
        String telNum = null;
        if (null != customer) {
            telNum = customer.getTel();
            telNum = telNum.replaceAll("-", "");
        }
        return telNum;
    }

    /**
     * save 固话综合信息
     * @param response 调用外部接口查询到的固话综合信息
     * @param isUpdated 是否更新TFixlineInfo
     * @return save 状态值
     */
    private TFixLineInfo saveOrUpdateFixLineInfo(FixedLineQueryResponse response) {
        ChinaTelecomUnicomInfo telInfo = response.getList().get(0);
        TFixLineInfo record = getFixLineInfo(telInfo);
        String telNum = record.getTelNum();
        if (null == telNum)
            return null;
        TFixLineInfo existRecord = fixLineInfoService.findByTelNum(telNum);
        Date nowDate = new Date();
        if (null != existRecord) {
            record.setUpdated_at(nowDate);
            fixLineInfoService.update(record);
        } else {
            record.setCreated_at(nowDate);
            record.setUpdated_at(nowDate);
            fixLineInfoService.save(record);
        }
        return record;
    }

    /**
     * @param telInfo 外部接口封装承德entity
     * @param isUpdated 是否是更新TFixLineInfo
     * @return self 组装的entity
     */
    private TFixLineInfo getFixLineInfo(ChinaTelecomUnicomInfo telInfo) {
        TFixLineInfo record = new TFixLineInfo();
        record.setTelNum(telInfo.getTelNum());
        record.setName(telInfo.getName());
        record.setAddress(telInfo.getAddress());
        record.setVersion(telInfo.getVersion());
        record.setTelInput(telInfo.getTelInput());
        record.setNameInput(telInfo.getNameInput());
        record.setAddressInput(telInfo.getAddressInput());
        record.setUniqueNum(telInfo.getUniqueNum());
        record.setUniqueNumDesc(telInfo.getUniqueNumDesc());
        record.setAreaCode(telInfo.getAreaCode());
        record.setQueryResult(telInfo.getQueryResult());
        String queryType = telInfo.getQueryType();
        if (StringUtil.isNotEmpty(queryType))
            record.setQueryType(TFixLineInfo.codeVal.get(queryType));
        record.setCorpTel(telInfo.getCorpTel());
        record.setCorpName(telInfo.getCorpName());
        record.setCorpAddress(telInfo.getCorpAddress());
        return record;
    }

    /**
     * 直接查询第三方接口
     * @param loanId 申请编号
     * @return 固话综合信息
     */
    public TFixLineInfo queryFixLineInfoForUpdate(String loanId) {
        return queryFixLineInfo(loanId, true);
    }

    /**先查db,db没有，则查第三方接口
     * @param loanId 申请编号
     * @return 固话综合信息
     */
    public TFixLineInfo queryFixLineInfoDBfirst(String loanId) {
        return queryFixLineInfo(loanId, false);
    }

    /**
     * @param loanId 贷款申请编号
     * @param isDrect 是,直接查询第三方接口，不查数据库;否，先查数据库
     * @return
     */
    private TFixLineInfo queryFixLineInfo(String loanId, boolean isDrect) {
        String telNum = getTelNum(loanId);
        if (null == telNum) {
            LOGGER.warn("查询不到loanId:" + loanId + "的座机号码信息");
            return null;
        }
        TFixLineInfo existRecord = null;
        if (!isDrect)
            existRecord = fixLineInfoService.findByTelNum(telNum);
        if (null == existRecord) {
            // 查询固话综合信息，并更新保存入库
            FixedLineQueryResponse response = queryFixedLineInfo(telNum);
            if (null == response || null == response.getList() || 1 > response.getList().size()) {
                LOGGER.warn("查询不到固话信息");
                return null;
            }
            existRecord = saveOrUpdateFixLineInfo(response);
        }
        return existRecord;
    }

}
