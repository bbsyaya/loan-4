package com.hrbb.loan.spi.ZJ;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.HServiceException;
import com.hrbb.sh.framework.ftp.HttpClient;
import com.hrbb.sh.framework.ftp.ParamReqBean;
import com.hrbb.sh.framework.ftp.ParamResBean;

/**
 * 
 * @author jianQing
 * @version $Id: ZJAddImageDataServiceImpl.java, v 0.1 2015年4月15日 上午11:15:24 jianQing Exp $
 */
@Service("zjAddImageDataService")
public class ZJAddImageDataServiceImpl implements HService {

	private final Logger logger = LoggerFactory
			.getLogger(ZJAddImageDataServiceImpl.class);

//	@Autowired
//	@Qualifier("tCreditApplyForReviewDao")
//	private TCreditApplyForReviewDao daoCA;

//	@Value("#{systemInfo[url]}")
	private String URL;

	/**
	 * @see com.hrbb.sh.framework.HService#serve(com.hrbb.sh.framework.HRequest)
	 */
	@Override
	public HResponse serve(HRequest request) throws HServiceException {
	    logger.debug("通知ftp做文件上传处理...");
	    
	    /*加载系统参数配置*/
		URL = SysConfigFactory.getInstance().getService("basicService").getPropertyValue("webUrl");

        Map<String, Object> props = request.getProperties();
		// 申请流水号
		String loanid = (String) props.get(CreditApplyHServiceConstants.loanid);
		// 影像资料文件包名
        String imagefilepackagename = (String) props
                .get(CreditApplyHServiceConstants.imagefilepackagename);
		logger.debug("loanid=" + loanid);
		logger.debug("imagefilepackagename=" + imagefilepackagename);
		// ftp请求参数
		ParamReqBean paramReqBean = new ParamReqBean();
		paramReqBean.setApplyNo(loanid);
		//机构代码
		paramReqBean.setKeyValue(
				CreditApplyHServiceConstants.ftp_map_key_instno,
				CreditApplyHServiceConstants.ftp_instno_lc);
		//消息版本
		paramReqBean.setVersion(CreditApplyHServiceConstants.ftp_version);
		//业务类型
		paramReqBean.setBizType(CreditApplyHServiceConstants.ftp_biztype);
		//交易类型
		paramReqBean.setTransType(CreditApplyHServiceConstants.ftp_transtype);
		//阶段前缀
		paramReqBean.setKeyValue(
				CreditApplyHServiceConstants.ftp_map_key_prefix,
				CreditApplyHServiceConstants.ftp_prefix_app);
		//远程文件名
		paramReqBean.setKeyValue(
				CreditApplyHServiceConstants.ftp_map_key_remotefilename,
				imagefilepackagename);
		//流水号
		paramReqBean.setKeyValue(
				CreditApplyHServiceConstants.ftp_map_key_LocalSubFolderNameDef,
				loanid);
		paramReqBean.setKeyValue(CreditApplyHServiceConstants.ftp_map_key_url,
				URL + CreditApplyHServiceConstants.ftp_map_key_returnUrl_imageData);
		logger.debug("--URL--:" + URL);
		logger.debug("url="
				+ paramReqBean
						.getValueByKey(CreditApplyHServiceConstants.ftp_map_key_url));
		ParamResBean paramResBean = HttpClient.send(paramReqBean);
		String respCode = null;
		String respMsg = null;
		if (paramResBean == null) {
			respCode = "999";
			respMsg = "HttpClient error!";
		} else {
			respCode = paramResBean.getRespCode();
			respMsg = paramResBean.getRespMsg();
		}
		logger.debug("ftp respCode=" + respCode);
		logger.debug("ftp respMsg=" + respMsg);
		// 异常的时候
		// if (paramResBean == null
		// || !CreditApplyHServiceConstants.ftp_resp_code_000
		// .equals(respCode)) {
		// return null;
		// }
		HResponse response = new HResponse();
		response.setRespCode(respCode);
		response.setRespMessage(respMsg);
		response.setRespTime(new Date());
		logger.debug("ftp文件上传处理 end");
		return response;
	}
}
