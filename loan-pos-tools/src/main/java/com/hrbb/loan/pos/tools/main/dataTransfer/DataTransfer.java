/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.tools.main.dataTransfer;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TPosCustInfo;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;
import com.hrbb.pos.loan.tools.database.LoanDatabase;
import com.hrbb.pos.loan.tools.database.LoanDatabaseSqlServer;

/**
 * 小贷系统数据迁移
 * 
 * @author marco
 * @version $Id: DataTransfer.java, v 0.1 2015-4-24 下午4:20:22 marco Exp $
 */
public class DataTransfer {

	private static Logger logger = LoggerFactory.getLogger(DataTransfer.class);

	// 持久层会话工厂
	private static SqlSessionFactory sqlSessionFactory = null;
	private static SqlSessionFactory sqlSessionFactorySqlServer = null;
	static {
		sqlSessionFactory = LoanDatabase.getSqlSessionFactory();
		sqlSessionFactorySqlServer = LoanDatabaseSqlServer
				.getSqlSessionFactory();
	}

	private final static String BLANK = "";
	private final static String COMMA = ",";
	private final static String YEAR_NAME = "年";
	private final static String YEAR_CODE = "Y";
	private final static String MONTH_NAME = "月";
	private final static String MONTH_CODE = "M";
	private final static String DAY_NAME = "日";
	private final static String DAY_CODE = "D";
	private final static String INCHANNELKIND_04 = "04";
	private final static String CURRSIGN_CNY = "CNY";
	private final static String REPAYMETHOD_01 = "01";
	private final static String RETURNKIND_90 = "90";
	private final static String PAPERKIND_10 = "10";
	private final static String OCCURTYPE_01 = "01";
	private final static String LASTOPERID_SYSTEM = "system";
	private final static String LASTOPERID_SYSTEM_NAME = "系统自动处理";

	private final static String LOAN_PREFIX = "LO";
	private final static String POSCUSTID_PREFIX = "MH";

	private final static String NO = "NO";
	private final static String CHANNEL = "channel";
	private final static String APPLYAMT = "applyAmt";
	private final static String BANKID = "bankId";
	private final static String PRODID = "prodId";
	private final static String PRODID_POS = "1001020306";
	private final static String PRODID_POS_NAME = "POS贷";
	private final static String PRODID_CASHFLOW = "1001020305";
	private final static String PRODID_CASHFLOW_NAME = "流量贷";
	private final static String PROD_CASHFLOW = "cashflow";
	private final static String APPLYTERM = "applyTerm";
	private final static String APPLYSTATUS = "applystatus";

	private final static String BEGINDATE = "beginDate";
	private final static String PAPERID = "paperId";
	private final static String CUSTNAME = "custName";
	private final static String SEXSIGN = "sexSign";
	private final static String MARRSIGN = "marrSign";
	private final static String EDUCSIGN = "educSign";
	private final static String CHILDNUM = "childNum";
	private final static String BUSIYEAR = "busiYear";
	private final static String WEIXINNO = "weixinNo";
	private final static String QQNO = "qqNo";
	private final static String EMAIL = "email";
	private final static String MOBILEPHONE = "mobilePhone";
	private final static String TEL = "tel";
	private final static String RESIDENTDETAIL = "residentDetail";
	private final static String CONTACTADDRFLAG = "contactAddrFlag";
	private final static String FAMILYCUSTNAME = "familyCustName";
	private final static String MATEPAPERID = "matePaperId";
	private final static String MATEMOBILEPHONE = "mateMobilephone";

	private final static String POSCUSTID = "posCustId";
	private final static String POSCUSTNAME = "posCustName";
	private final static String POSCUSTBUSISCOPE = "posCustBusiScope";
	private final static String POSCUSTADDRESS = "posCustAddress";
	private final static String REGICODE = "regiCode";
	private final static String REGISTDATE = "registDate";
	private final static String REGCAPITAL = "regCapital";
	private final static String STATE = "state";
	private final static String CITY = "city";

	private final static String BANKACCNO = "bankAccno";
	private final static String BANKNAME = "bankName";

	private final static String CODENO = "codeNo";
	private final static String ITEMNO = "itemNo";
	private final static String ITEMNOLIKE = "itemNoLike";
	private final static String ITEMNOLIKE_PREFIX = "____";
	private final static String ITEMNAME = "itemName";
	private final static String STATUS = "status";
	private final static String STATUS_ACTIVE = "0";

	private static final BigDecimal TEN_THOUSAND = new BigDecimal(10000);

	/**
	 * 小贷系统数据迁移
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		logger.debug("小贷系统数据迁移开始。。。");
		String day = null;
		if (args == null || args.length == 0) {
			// day = DateUtil.getCurrentTimePattern12();
			logger.debug("没有输入日期，全量数据");
		} else {
			day = args[0];
			logger.debug("日期参数day=" + day);
			try {
				DateUtil.getStrToDate12(day);
			} catch (ParseException e) {
				logger.error("日期参数[" + day + "]输入不正确,期望格式:[yyyyMMdd]", e);
				return;
			}
		}
		// 检索数据
		List<Map<String, String>> data = select(day);

		if (data == null || data.size() == 0) {
			logger.debug("没有可供处理的数据！");
		} else {
			// 格式化数据，并插入数据库
			insert(data);
		}
		logger.debug("小贷系统数据迁移结束。");
	}

	/**
	 * 获取数据
	 * 
	 * @param day
	 * @return
	 */
	private static List<Map<String, String>> select(String day) {
		logger.debug("检索sqlserver数据库开始...");
		// 读取配置
		SqlSession sqlSession = sqlSessionFactorySqlServer.openSession();

		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("day", day);

		List<Map<String, String>> data = null;
		try {
			data = sqlSession.selectList("sqlServerMapper.select", reqMap);
			logger.debug("数据件数=" + data.size());
		} catch (Exception e) {
			logger.error("检索异常，查看日志:", e);
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		logger.debug("检索sqlserver数据库结束...");
		return data;
	}

	/**
	 * 获取数据文件内容
	 * 
	 * @param filePath
	 * @return
	 */
	private static void insert(List<Map<String, String>> data) {

		logger.debug("插入mysql数据库开始...");
		// 读取配置
		SqlSession sqlSession = sqlSessionFactory.openSession(false);

		int cnt = data.size();
		logger.debug("数据条数cnt=" + cnt);

		TCreditApply ca = null;
		TBankAccnoInfo bai = null;

		Map<String, Object> reqMap = Maps.newHashMap();

		Date now = new Date();
		logger.debug("now=" + DateUtil.getNowTime());
		// 插入成功条数
		int commitCnt = 0;

		StringBuilder errorMsg = new StringBuilder();

		try {

			for (int i = 0; i < cnt; ++i) {

				Map<String, String> m = data.get(i);
				logger.debug("正在处理第" + i + "条数据。。。。。");
				try {

					ca = new TCreditApply();
					ca.setLastOperTime(now);
					// 设置申请信息
					setCreditApply(sqlSession, m, ca);

					// 申请人信息
					// 身份证号码
					String paperId = m.get(PAPERID);
					logger.debug("PAPERID=" + paperId);
					if (StringUtil.isNotEmpty(paperId)) {
						// 申请人姓名
						reqMap.put(PAPERID, paperId);
						List<TCustomer> cusList = sqlSession.selectList(
								"TCustomerMapper.selectSelective", reqMap);
						reqMap.clear();

						if (cusList == null || cusList.size() == 0) {
							logger.debug("非存量客户。");
							String custId = IdUtil.getCustId(paperId);
							// 插入客户表
							insertCust(sqlSession, m, paperId, custId);

							ca.setCustId(custId);
							ca.setCustName(m.get(CUSTNAME));

						} else {
							logger.debug("存量客户。");
							ca.setCustId(cusList.get(0).getCustId());
							ca.setCustName(cusList.get(0).getCustName());
						}
					}

					// 商户信息
					String posCustName = m.get(POSCUSTNAME);
					logger.debug("POSCUSTNAME=" + posCustName);

					if (StringUtil.isNotEmpty(posCustName)) {

						reqMap.put(POSCUSTNAME, posCustName);

						List<Map<String, Object>> resList = sqlSession
								.selectList("TPosCustInfoMapper.selectMap",
										reqMap);
						reqMap.clear();

						// 非存量商户
						if (resList == null || resList.size() == 0) {
							logger.debug("非存量商户。");

							String posCustId = IdUtil.getId(POSCUSTID_PREFIX);
							logger.debug("posCustId=" + posCustId);
							// 插入商户表
							insertPosCust(sqlSession, m, posCustId,
									ca.getProdId(), ca.getCustId(),
									posCustName, ca.getRegion());

							ca.setPosCustId(posCustId);
						} else {
							logger.debug("存量商户。");

							ca.setPosCustId(resList.get(0).get(POSCUSTID)
									.toString());
							logger.debug("posCustId=" + ca.getPosCustId());
						}
						ca.setPosCustName(posCustName);
					}

					// 银行信息
					String bankAccno = m.get(BANKACCNO);
					logger.debug("BANKACCNO=" + bankAccno);
					ca.setBankAccno(bankAccno);
					if (StringUtil.isNotEmpty(bankAccno)) {
						bai = sqlSession.selectOne(
								"TBankAccnoInfoMapper.selectByPrimaryKey",
								bankAccno);
						// 非存量银行
						if (bai == null) {
							logger.debug("非存量银行。");
							// 插入银行卡表
							insertBankAccno(sqlSession, m, bankAccno,
									ca.getCustId(), now);
						} else {
							logger.debug("存量银行。");
						}
					}

					int result = sqlSession.insert(
							"TCreditApplyMapper.insertSelective", ca);
					if (result == 1) {
						logger.debug("插入申请表成功。");
					} else {
						logger.debug("插入申请表失败！");
					}
					sqlSession.commit();
					commitCnt++;
				} catch (Exception e) {
					sqlSession.rollback();
					logger.error("出现异常：", e);
					errorMsg.append("序号:[" + m.get(NO) + "],")
							.append("商户名:[" + m.get(POSCUSTNAME) + "],")
							.append("申请人姓名:[" + m.get(CUSTNAME) + "],")
							.append("身份证号:[" + m.get(PAPERID)
									+ "]的申请导入失败，请确认错误日志。\n");
				}
			}
		} catch (Exception e) {
			logger.error("出现异常：", e);
			errorMsg.append("出现异常");
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		String msg = "总记录数cnt=" + cnt + "；成功插入数据条数commitCnt=" + commitCnt
				+ "\n";
		String result = null;
		if (StringUtil.isNotEmpty(errorMsg.toString())) {
			logger.error(errorMsg.toString());
			result = msg.concat(errorMsg.toString());
		} else {
			result = msg.concat("更新数据成功！");
		}
		logger.debug(result);
		logger.debug("插入mysql数据库结束...");
	}

	/**
	 * 设置申请信息
	 * 
	 * @param sqlSession
	 * @param m
	 * @param ca
	 */
	private static void setCreditApply(SqlSession sqlSession,
			Map<String, String> m, TCreditApply ca) {

		Map<String, Object> reqMap = Maps.newHashMap();

		ca.setLoanId(IdUtil.getId(LOAN_PREFIX));

		// 产品代码
		logger.debug("PRODID=" + m.get(PRODID));
		// 流量贷
		if (PROD_CASHFLOW.equals(m.get(PRODID))) {
			ca.setProdId(PRODID_CASHFLOW);
			ca.setProdName(PRODID_CASHFLOW_NAME);
			// POS贷
		} else {
			ca.setProdId(PRODID_POS);
			ca.setProdName(PRODID_POS_NAME);
		}

		ca.setCurrSign(CURRSIGN_CNY);

		// 申请金额
		String applyAmt = m.get(APPLYAMT);
		logger.debug("APPLYAMT=" + m.get(APPLYAMT));
		if (StringUtil.isEmpty(applyAmt)) {
			ca.setApplyAmt(BigDecimal.ZERO);
		} else {
			ca.setApplyAmt(new BigDecimal(applyAmt.replaceAll(COMMA, BLANK)));
		}

		// 申请期限
		String applyTerm = m.get(APPLYTERM);
		logger.debug("APPLYTERM=" + applyTerm);
		if (StringUtil.isNotEmpty(applyTerm)) {
			if (applyTerm.indexOf(YEAR_NAME) >= 0) {
				ca.setTermUnit(YEAR_CODE);
				ca.setApplyTerm(applyTerm.replaceAll(YEAR_NAME, BLANK));
			} else if (applyTerm.indexOf(MONTH_NAME) >= 0) {
				ca.setTermUnit(MONTH_CODE);
				ca.setApplyTerm(applyTerm.replaceAll(MONTH_NAME, BLANK));
			} else if (applyTerm.indexOf(DAY_NAME) >= 0) {
				ca.setTermUnit(DAY_CODE);
				ca.setApplyTerm(applyTerm.replaceAll(DAY_NAME, BLANK));
			} else {
				ca.setTermUnit(MONTH_CODE);
				ca.setApplyTerm(applyTerm);
			}
		}

		// 申请日期
		String beginDate = m.get(BEGINDATE);
		logger.debug("beginDate=" + beginDate);
		if (StringUtil.isNotEmpty(beginDate)) {
			try {
				ca.setBeginDate(DateUtil.getStrToDate12(beginDate));
			} catch (Exception e) {
				logger.error("申请日期格式不对！", e);
			}
		}

		ca.setReturnKind(RETURNKIND_90);
		ca.setBankId(m.get(BANKID));
		logger.debug("BANKID=" + ca.getBankId());
		ca.setOperId(LASTOPERID_SYSTEM);
		ca.setApplyStatus(m.get(APPLYSTATUS));
		logger.debug("APPLYSTATUS=" + ca.getApplyStatus());
		ca.setLastOperId(LASTOPERID_SYSTEM);
		ca.setDeleteFlag("0");

		// 区划国标码
		ca.setRegion(getRegion(sqlSession, m));

		ca.setOperName(LASTOPERID_SYSTEM_NAME);

		// 业务来源
		String channel = m.get(CHANNEL);
		logger.debug("channelName=" + channel);
		reqMap.put(CODENO, BusinessDictionaryConstants.BizChannel);
		reqMap.put(ITEMNAME, channel);
		reqMap.put(STATUS, STATUS_ACTIVE);
		List<Map<String, Object>> resListChannel = sqlSession.selectList(
				"TBusinessDictionaryMapper.selectMap", reqMap);
		reqMap.clear();
		if (resListChannel != null && resListChannel.size() > 0) {
			channel = resListChannel.get(0).get(ITEMNO).toString();
			logger.debug("channelCode=" + channel);
			ca.setChannel(channel);
		}

		ca.setInChannelKind(INCHANNELKIND_04);
		ca.setOccurType(OCCURTYPE_01);
		ca.setRegDate(ca.getLastOperTime());
		ca.setRepayMethod(REPAYMETHOD_01);
	}

	/**
	 * 插入客户表
	 * 
	 * @param sqlSession
	 * @param m
	 * @param paperId
	 * @param custId
	 * @return
	 */
	private static int insertCust(SqlSession sqlSession, Map<String, String> m,
			String paperId, String custId) {
		TCustomer c = new TCustomer();

		c.setCustId(custId);
		c.setCustName(m.get(CUSTNAME));
		c.setPaperKind(PAPERKIND_10);
		c.setPaperId(paperId);

		// 出生日期
		if (paperId.length() < 18) {
			logger.debug("申请人的身份证号码小于18位！");
		} else {
			try {
				String birtDateStr = paperId.substring(6, 14);
				logger.debug("birtDateStr=" + birtDateStr);
				c.setBirtDate(DateUtil.getStrToDate1(birtDateStr));
			} catch (ParseException e) {
				logger.debug("申请人的身份证中的出生日期不是日期！");
			}
		}

		// 性别
		String sexSign = m.get(SEXSIGN);
		logger.debug("SEXSIGN=" + sexSign);
		c.setSexSign(DataTransferUtil.getSexSign(sexSign));

		// 婚姻状况:0;未婚；1，已婚
		String marrSign = m.get(MARRSIGN);
		logger.debug("MARRSIGN=" + marrSign);
		c.setMarrSign(DataTransferUtil.getMarrSign(marrSign));

		// 最高学历
		String educSign = m.get(EDUCSIGN);
		logger.debug("EDUCSIGN=" + educSign);
		c.setEducSign(DataTransferUtil.getEducSign(educSign));

		// 子女人数
		String childNum = m.get(CHILDNUM);
		logger.debug("CHILDNUM=" + childNum);
		c.setChildNum(childNum);

		// 居住地址-具体
		String residentDetail = m.get(RESIDENTDETAIL);
		logger.debug("RESIDENTDETAIL=" + residentDetail);
		if (StringUtil.isNotEmpty(residentDetail)) {
			// 截取省市，转化编码
			c.setResidentDetail(residentDetail);
		}

		// 联系地址
		String contactAddrFlag = m.get(CONTACTADDRFLAG);
		logger.debug("CONTACTADDRFLAG=" + contactAddrFlag);
		c.setContactAddrFlag(contactAddrFlag);

		// 手机号码
		String mobilePhone = m.get(MOBILEPHONE);
		logger.debug("MOBILEPHONE=" + mobilePhone);
		if (mobilePhone == null) {
			c.setMobilePhone("");
		} else {
			c.setMobilePhone(mobilePhone);
		}
		// 固定电话
		String tel = m.get(TEL);
		logger.debug("TEL=" + tel);
		c.setTel(tel);
		// 微信号
		String weixinNo = m.get(WEIXINNO);
		logger.debug("WEIXINNO=" + weixinNo);
		c.setWeixinNo(weixinNo);
		// QQ号
		String qqNo = m.get(QQNO);
		logger.debug("QQNO=" + qqNo);
		c.setQqNo(qqNo);
		// 电子邮件
		String email = m.get(EMAIL);
		logger.debug("EMAIL=" + email);
		c.setEmail(email);

		// 从业年限
		String busiYear = m.get(BUSIYEAR);
		logger.debug("BUSIYEAR=" + busiYear);
		c.setBusiYear(busiYear);

		// 配偶姓名
		String familyCustName = m.get(FAMILYCUSTNAME);
		logger.debug("FAMILYCUSTNAME=" + familyCustName);
		c.setFamilyCustName(familyCustName);

		// 配偶证件类型
		c.setMatePaperKind(PAPERKIND_10);

		// 配偶证件号码
		String matePaperId = m.get(MATEPAPERID);
		logger.debug("MATEPAPERID=" + matePaperId);

		if (StringUtil.isNotEmpty(matePaperId)) {
			c.setMatePaperId(matePaperId);

			// 出生日期
			if (matePaperId.length() < 18) {
				logger.debug("配偶的身份证号码小于18位！");
			} else {
				try {
					String mateBirtDateStr = matePaperId.substring(6, 14);
					logger.debug("mateBirtDateStr=" + mateBirtDateStr);
					c.setMateBirtDate(DateUtil.getStrToDate1(mateBirtDateStr));
				} catch (ParseException e) {
					logger.debug("配偶的身份证中的出生日期不是日期！");
				}

				// 性别
				String mateSexSign = matePaperId.substring(16, 17);
				logger.debug("mateSexSign(判断奇偶)=" + mateSexSign);
				c.setMateSexSign(DataTransferUtil.getSexSignByID(mateSexSign));
			}
		}

		// 配偶手机
		String mateMobilephone = m.get(MATEMOBILEPHONE);
		logger.debug("MATEMOBILEPHONE=" + mateMobilephone);
		c.setMateMobilephone(mateMobilephone);
		int result = sqlSession.insert("TCustomerMapper.insertSelective", c);
		if (result == 1) {
			logger.debug("插入客户表成功。");
		} else {
			logger.debug("插入客户表失败！");
		}

		return result;
	}

	/**
	 * 插入商户表
	 * 
	 * @param sqlSession
	 * @param m
	 * @param posCustId
	 * @param prodId
	 * @param custId
	 * @return
	 */
	private static int insertPosCust(SqlSession sqlSession,
			Map<String, String> m, String posCustId, String prodId,
			String custId, String posCustName, String region) {

		TPosCustInfo pci = new TPosCustInfo();
		pci.setPosCustId(posCustId);
		pci.setCustId(custId);
		pci.setPosCustName(posCustName);

		// 主营业务
		pci.setPosCustBusiScope(m.get(POSCUSTBUSISCOPE));
		logger.debug("POSCUSTBUSISCOPE=" + m.get(POSCUSTBUSISCOPE));

		// 互金行业分类(内部)
		pci.setIndustryTypeId2(DataTransferUtil.getIndustryType(posCustName));
		logger.debug("IndustryTypeId2=" + pci.getIndustryTypeId2());

		// 实际经营地址详细
		pci.setPosCustAddress(m.get(POSCUSTADDRESS));
		logger.debug("POSCUSTADDRESS=" + m.get(POSCUSTADDRESS));

		// 区划国标码
		pci.setOperAddrCode(region);

		// 营业执照编号
		pci.setRegiCode(m.get(REGICODE));
		logger.debug("REGICODE=" + m.get(REGICODE));

		// 注册资本
		String regCapitalStr = m.get(REGCAPITAL);
		logger.debug("regCapitalStr=" + regCapitalStr);
		if (StringUtil.isNotEmpty(regCapitalStr)) {
			try {
				BigDecimal regCapital = new BigDecimal(regCapitalStr);
				pci.setRegCapital(regCapital.multiply(TEN_THOUSAND));
			} catch (NumberFormatException e) {
				logger.debug("注册资本转化失败！");
			}
		}

		// 注册日期
		pci.setRegistDate(m.get(REGISTDATE));
		logger.debug("RegistDate=" + pci.getRegistDate());

		// 是否安装POS机 0未安装 1安装
		// 流量贷
		if (PRODID_CASHFLOW.equals(prodId)) {
			pci.setIsPosInstall("0");
			// POS贷
		} else {
			pci.setIsPosInstall("1");
		}
		int result = sqlSession.insert("TPosCustInfoMapper.insertSelective",
				pci);
		if (result == 1) {
			logger.debug("插入商户表成功。");
		} else {
			logger.debug("插入商户表失败！");
		}
		return result;
	}

	/**
	 * 插入银行卡表
	 * 
	 * @param sqlSession
	 * @param m
	 * @param bankAccno
	 * @param custId
	 * @param now
	 * @return
	 */
	private static int insertBankAccno(SqlSession sqlSession,
			Map<String, String> m, String bankAccno, String custId, Date now) {
		TBankAccnoInfo bai = new TBankAccnoInfo();
		bai.setBankAccno(bankAccno);
		bai.setCustId(custId);
		String bankName = m.get(BANKNAME);
		logger.debug("BANKNAME=" + bankName);
		bai.setBankBranName(bankName);
		bai.setCreateTime(now);
		int result = sqlSession.insert("TBankAccnoInfoMapper.insertSelective",
				bai);
		if (result == 1) {
			logger.debug("插入银行卡表成功。");
		} else {
			logger.debug("插入银行卡表失败！");
		}
		return result;
	}

	/**
	 * 取得省市编码
	 * 
	 * @param sqlSession
	 * @param m
	 * @return
	 */
	private static String getRegion(SqlSession sqlSession, Map<String, String> m) {

		// 区划国标码-省
		String state = m.get(STATE);
		logger.debug("state=" + state);

		Map<String, Object> reqMap = Maps.newHashMap();

		String region = "";

		if (StringUtil.isNotEmpty(state)) {
			reqMap.put(CODENO, BusinessDictionaryConstants.AdminDivision);
			reqMap.put(ITEMNAME, state);
			reqMap.put(STATUS, STATUS_ACTIVE);
			List<Map<String, Object>> resListDB = sqlSession.selectList(
					"TBusinessDictionaryMapper.selectMap", reqMap);
			reqMap.clear();
			// 省
			if (resListDB != null && resListDB.size() > 0) {
				region = resListDB.get(0).get(ITEMNO).toString();
				logger.debug("省region=" + region);
				// 市
				String city = m.get(CITY);
				logger.debug("city=" + city);

				if (StringUtil.isNotEmpty(city)) {
					reqMap.put(CODENO,
							BusinessDictionaryConstants.AdminDivision);
					reqMap.put(ITEMNOLIKE, region.substring(0, 2)
							+ ITEMNOLIKE_PREFIX);
					reqMap.put(ITEMNAME, city);
					List<Map<String, Object>> resListDB2 = sqlSession
							.selectList("TBusinessDictionaryMapper.selectMap",
									reqMap);
					reqMap.clear();
					if (resListDB2 != null && resListDB2.size() > 0) {
						region = resListDB2.get(0).get(ITEMNO).toString();
						logger.debug("市region=" + region);
					} else {
						logger.debug("没有市region");
					}
				}
			} else {
				logger.debug("没有省region");
			}
		}
		return region;
	}
}
