package com.hrbb.loan.timer;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo;
import com.hrbb.loan.pos.service.CreditApplyAprvInfoService;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.enums.ApprInfoExtEnum;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年10月13日上午11:02:44 
 */
@Service
public class PatchBoltTimer {

    private static final String APPRV_ID = "system";// 审批人
    private static final String APRV_REFUSE = "92";// 审批拒绝，同步数据字典
    private static final int TIMEOUT_DAYS = 14;//过期天数

    @Autowired
    private CreditApplyAprvInfoService creditApplyAprvInfoService;

    /**
     * 定时任务，对于初审补件applyStatus=21,风险复审补件applyStatus=32的申请状态超过2周的，予以系统自动拒绝
     */
    @Scheduled(cron = "0 30 5 * * ?")
    public void refuseBolt() {
        Long now = new Date().getTime();
        Date endDate = new Date(now-TIMEOUT_DAYS*3600*24);
        String timeout = DateUtil.formatDate(endDate,DateUtil.HRRB_FULL_DATETIME_FORMAT);
        List<String> loanIds = creditApplyAprvInfoService.getLoanIdsByDate(timeout);
        if (null == loanIds)
            return;
        TCreditApplyAprvInfo creditApplyAprvInfo = null;
        for (String loanId : loanIds) {
            creditApplyAprvInfo = new TCreditApplyAprvInfo();
            creditApplyAprvInfo.setLoanId(loanId);
            creditApplyAprvInfo.setApprvId(APPRV_ID);
            creditApplyAprvInfo.setApprInfo(ApprInfoExtEnum.APPRINFOEXT_91.getDescription());
            creditApplyAprvInfo.setApprInfoExt(ApprInfoExtEnum.APPRINFOEXT_91.getValue());
            creditApplyAprvInfo.setApprState(APRV_REFUSE);
            creditApplyAprvInfoService.updateCreditApplyRefuse(creditApplyAprvInfo);
        }
    }

}
