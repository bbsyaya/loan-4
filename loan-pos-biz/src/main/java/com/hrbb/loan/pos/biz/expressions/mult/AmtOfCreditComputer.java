/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.mult;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.biz.expressions.bean.MultResultBean;
import com.hrbb.loan.pos.dao.entity.TCreditReportIndicator;
import com.hrbb.loan.pos.dao.entity.TPosCustInfo;
import com.hrbb.loan.pos.dao.entity.TRiskCheckModelIndex;
import com.hrbb.loan.pos.factory.CityFactory;
import com.hrbb.loan.pos.biz.constants.ChannelConstants;
import com.hrbb.loan.pos.biz.constants.RiskCheckConstants;
import com.hrbb.loan.pos.util.MathUtils;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;

/**
 * 1.3.2.5 授信额度建议
 * 
 * @author XLY
 * @version $Id: AmtOfCreditComputer.java, v 0.1 2015-3-10 下午3:41:12 XLY Exp $
 */
public class AmtOfCreditComputer {

	private final static Logger logger = LoggerFactory
			.getLogger(AmtOfCreditComputer.class);

	public static BigDecimal computer(MultResultBean multResultBean,
			TRiskCheckModelIndex modelIndexBean, String posChannel,
			TPosCustInfo tPosCustInfo, BigDecimal creditApplyAmt,
			BigDecimal finalModelp, String prodID, TCreditReportIndicator cri,
			String localHouseNum) {
		// 原始模型得分
		// BigDecimal RawModelScore = multResultBean.getRawModelScore();
		// 最终模型得分
		BigDecimal finalModelScore = multResultBean.getFinalModelScore();
		logger.debug("finalModelScore=" + finalModelScore);
		BigDecimal coefficient1 = null;
		BigDecimal coefficient2 = null;
		BigDecimal coefficient3 = null;

		// >75
		if (finalModelScore.compareTo(new BigDecimal(75)) > 0) {
			coefficient1 = new BigDecimal(1.3);
			coefficient2 = new BigDecimal(1.1);
			coefficient3 = new BigDecimal(0.9);
			// <=75
		} else {
			// >70
			if (finalModelScore.compareTo(new BigDecimal(70)) > 0) {
				coefficient1 = new BigDecimal(1.2);
				coefficient2 = BigDecimal.ONE;
				coefficient3 = new BigDecimal(0.8);
				// <=70
			} else {
				coefficient1 = BigDecimal.ONE;
				coefficient2 = new BigDecimal(0.9);
				coefficient3 = new BigDecimal(0.7);
			}
		}
		logger.debug("倍数coefficient1=" + coefficient1);
		logger.debug("倍数coefficient2=" + coefficient2);
		logger.debug("倍数coefficient3=" + coefficient3);
		// 他行限额peers_cl
		BigDecimal peers_cl1 = MathUtils.getMax(cri.getCR120(), cri.getCR121())
				.multiply(coefficient1);
		BigDecimal peers_cl2 = MathUtils.getMax(cri.getCR122(), cri.getCR123())
				.multiply(coefficient2);
		BigDecimal peers_cl3 = MathUtils.getMax(cri.getCR124(), cri.getCR125())
				.multiply(coefficient3);
		BigDecimal peerscl = MathUtils.getMax(
				MathUtils.getMax(
						MathUtils.getMax(new BigDecimal(100000), peers_cl1),
						peers_cl2), peers_cl3);
		logger.debug("他行额度peerscl=" + peerscl);
		return computer(multResultBean, tPosCustInfo, posChannel,
				modelIndexBean.getModelIndex26(),
				modelIndexBean.getModelIndex18(), creditApplyAmt, finalModelp,
				prodID, peerscl, localHouseNum);
	}

	/**
	 * 
	 * 1.2.2.5 授信额度建议
	 * 
	 * @param multResultBean
	 * @param productType
	 * @param channel
	 * @param modelIndex26
	 * @param modelIndex18
	 * @param creditApplyAmt
	 * @param finalModelp
	 * @return
	 */
	private static BigDecimal computer(MultResultBean multResultBean,
			TPosCustInfo tPosCustInfo, String channel, BigDecimal modelIndex26,
			BigDecimal modelIndex18, BigDecimal creditApplyAmt,
			BigDecimal finalModelp, String prodID, BigDecimal peerscl,
			String localHouseNum) {

		BigDecimal capcl = BigDecimal.ZERO;
		// 额度下限
		BigDecimal lower_limit = BigDecimal.ZERO;
		logger.debug("channel=" + channel);
		// 渠道=“四川烟草”
		if (ChannelConstants.CH_CY.equals(channel)) {
			BigDecimal poscl = (MathUtils.getMin(
					MathUtils.getMax(new BigDecimal(25),
							multResultBean.getFinalModelScore()),
					new BigDecimal(75)).multiply(new BigDecimal(0.08)))
					.multiply(modelIndex26);
			logger.debug("POS额度poscl=" + poscl);
			// BigDecimal peerscl = MathUtils.getMax(new BigDecimal(100000),
			// modelIndex18.multiply(new BigDecimal(2)));
			capcl = MathUtils.getMin(MathUtils.getMin(
					MathUtils.getMin(new BigDecimal(500000), poscl), peerscl),
					creditApplyAmt);
			lower_limit = new BigDecimal(50000);

			// 渠道<>“四川烟草”
		} else {
			// pos贷,非商圈模式
			if (prodID.equals(ReviewNoteConstants.POS_LOAN_ID)) {
				// BigDecimal poscl = (MathUtils.getMin(
				// MathUtils.getMax(new BigDecimal(25),
				// multResultBean.getFinalModelScore()),
				// new BigDecimal(75)).multiply(new BigDecimal(0.03))
				// .subtract(new BigDecimal(0.25))).multiply(modelIndex26);
				// 最终模型得分
				BigDecimal finalModelScore = multResultBean
						.getFinalModelScore();
				BigDecimal poscl = null;
				// >75
				if (finalModelScore.compareTo(new BigDecimal(75)) > 0) {
					poscl = modelIndex26.multiply(new BigDecimal(2));
					// <=75
				} else {
					// >70
					if (finalModelScore.compareTo(new BigDecimal(70)) > 0) {
						poscl = modelIndex26.multiply(new BigDecimal(1.5));
						// <=70
					} else {
						// >63
						if (finalModelScore.compareTo(new BigDecimal(63)) > 0) {
							poscl = modelIndex26;
							// <=63
						} else {
							poscl = modelIndex26.multiply(new BigDecimal(0.7));
						}
					}
				}
				logger.debug("POS额度poscl=" + poscl);
				// BigDecimal peerscl = MathUtils.getMax(new BigDecimal(100000),
				// modelIndex18.multiply(new BigDecimal(2)));
				// a) 快钱
				if (ChannelConstants.CH_KQ.equals(channel)) {
					capcl = MathUtils.getMin(poscl, peerscl);
				} else {
					capcl = MathUtils.getMin(MathUtils.getMin(poscl, peerscl),
							creditApplyAmt);
				}

				lower_limit = new BigDecimal(50000);

				// 流量贷,商圈模式
			} else {
				// 流量贷不再考虑pos_cl
				// BigDecimal poscl = (MathUtils.getMin(
				// MathUtils.getMax(new BigDecimal(25),
				// multResultBean.getFinalModelScore()),
				// new BigDecimal(75)).multiply(new BigDecimal(0.03))
				// .subtract(new BigDecimal(0.25))).multiply(modelIndex18);
				// BigDecimal peerscl = MathUtils.getMax(new BigDecimal(100000),
				// modelIndex18.multiply(new BigDecimal(2)));

				// 快钱
				// if (ChannelConstants.CH_KQ.equals(channel)) {
				// capcl = MathUtils.getMin(peerscl, creditApplyAmt);
				// } else {
				logger.debug("流量贷,商圈模式没有POS额度poscl");
				capcl = MathUtils.getMin(peerscl, creditApplyAmt);
				// }

				lower_limit = new BigDecimal(100000);
			}
		}
		logger.debug("capcl=" + capcl);
		logger.debug("lower_limit=" + lower_limit);
		BigDecimal finalModelCl = MathUtils.round(
				MathUtils.getMax(capcl, lower_limit), new BigDecimal(50000));
		logger.debug("模型授信额度finalModelCl=" + finalModelCl);
		// 1.3.2.6模型建议额度调整
		// finalModelCl = finalModelp.compareTo(new BigDecimal(0.20)) > 0 ?
		// MathUtils
		// .getMin(new BigDecimal(200000), finalModelCl) : finalModelCl;
		// 如果申请人经营地有房产，授信额度+5万
		logger.debug("localHouseNum=" + localHouseNum);
		if (StringUtil.isNotEmpty(localHouseNum)) {
			if (new BigDecimal(localHouseNum).compareTo(BigDecimal.ONE) >= 0) {
				finalModelCl = finalModelCl.add(new BigDecimal(50000));
			}
		}
		logger.debug("模型授信额度finalModelCl=" + finalModelCl);
		logger.debug("OperAddrCode=" + tPosCustInfo.getOperAddrCode());
		// 申请人经营地址在一线城市
		if (CityFactory.isFirsttierCity(tPosCustInfo.getOperAddrCode())) {
			finalModelCl = MathUtils.getMax(finalModelCl,
					new BigDecimal(100000));
		}
		logger.debug("模型授信额度finalModelCl=" + finalModelCl);
		// 最高限额
		logger.debug("channel=" + channel);
		// 快钱
		if (ChannelConstants.CH_KQ.equals(channel)) {
			finalModelCl = MathUtils.getMin(new BigDecimal(500000),
					finalModelCl);
		} else {
			finalModelCl = MathUtils.getMin(new BigDecimal(1000000),
					finalModelCl);
		}
		logger.debug("模型授信额度finalModelCl=" + finalModelCl);
		return finalModelCl;
	}

	/**
	 * 特殊情况
	 * 
	 * @param finalModelCl
	 * @param tPosCustInfo
	 * @param channel
	 * @param modelIndex18
	 * @param finalModelp
	 * @return
	 */
	public static BigDecimal computerForSpecialCase(BigDecimal finalModelCl,
			TPosCustInfo tPosCustInfo, String channel, BigDecimal modelIndex18,
			BigDecimal finalModelp) {
		logger.debug("特殊情况");
		// 特殊情况
		// 将经营地在洛阳(4103**)的进件，授信额度上限定为20万元
		if (tPosCustInfo.getOperAddrCode().indexOf(
				RiskCheckConstants.operAddrCode_4103) == 0) {
			if (finalModelCl.compareTo(new BigDecimal(200000)) > 0) {
				finalModelCl = new BigDecimal(200000);
			}
			// 将银联渠道推送的福建省龙岩市的进件，授信额度上限定为20万元
		} else if (tPosCustInfo.getOperAddrCode().indexOf(
				RiskCheckConstants.operAddrCode_3508) == 0
				&& ChannelConstants.CH_UP.equals(channel)) {
			if (finalModelCl.compareTo(new BigDecimal(200000)) > 0) {
				finalModelCl = new BigDecimal(200000);
			}
		}
		logger.debug("模型授信额度finalModelCl=" + finalModelCl);
		logger.debug("modelIndex18=" + modelIndex18);
		logger.debug("finalModelp=" + finalModelp);
		// 人行最高兴勇额度大于5万，且模型利率小于等于15%，额度下限为10万
		if (modelIndex18.compareTo(new BigDecimal(50000)) > 0
				&& finalModelp.compareTo(new BigDecimal(0.15)) <= 0) {
			finalModelCl = MathUtils.getMax(finalModelCl,
					new BigDecimal(100000));
		}
		logger.debug("模型授信额度finalModelCl=" + finalModelCl);
		// 根据模型利率调整额度上限
		// >=0.18
		if (finalModelp.compareTo(new BigDecimal(0.18)) >= 0) {
			finalModelCl = MathUtils.getMin(finalModelCl,
					new BigDecimal(100000));
			// 模型利率<0.18
		} else {
			// 0.165~0.18之间
			if (finalModelp.compareTo(new BigDecimal(0.165)) >= 0) {
				finalModelCl = MathUtils.getMin(finalModelCl, new BigDecimal(
						300000));
			} else {
				// 不做上限设置
			}
		}
		logger.debug("模型授信额度finalModelCl=" + finalModelCl);
		return finalModelCl;
	}
}
