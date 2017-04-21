/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.tools.main.util;

import com.hrbb.loan.pos.tools.main.synFile.SynFileConstants;
import com.hrbb.loan.pos.util.FileUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;

/**
 * 
 * @author marco
 * @version $Id: SynFileUtil.java, v 0.1 2015-4-28 下午2:52:13 marco Exp $
 */
public class SynFileUtil {

	/**
	 * 统一取得文件名称
	 * 
	 * @param channel
	 * @param no
	 * @return
	 */
	public static String getSynFileName(String channel, int no, String today,
			String loanType) {

		String synFileNo = null;
		String fileName = null;

		switch (channel) {
		case SynFileConstants.CHANNEL_CODE_UM:
			switch (no) {
			case 1:
				synFileNo = "16";
				break;
			case 2:
				synFileNo = "17";
				break;
			case 3:
				synFileNo = "18";
				break;
			case 4:
				synFileNo = "19";
				break;
			default:
				return "";
			}
			fileName = "HB".concat(synFileNo);
			break;
		case SynFileConstants.CHANNEL_CODE_SM:
		case SynFileConstants.CHANNEL_CODE_58:
		case SynFileConstants.CHANNEL_CODE_RN:
			// 资金池模式
			if (ReviewNoteConstants.LOANTYPE_02.equals(loanType)) {
				switch (no) {
				case 1:
					synFileNo = "51";
					break;
				case 2:
					synFileNo = "52";
					break;
				case 3:
					synFileNo = "53";
					break;
				default:
					return "";
				}
			} else {
				switch (no) {
				case 1:
					synFileNo = "01";
					break;
				case 2:
					synFileNo = "02";
					break;
				case 3:
					synFileNo = "03";
					break;
				default:
					return "";
				}
			}
			fileName = channel.concat("B").concat(synFileNo);
			break;
		
		default:
			switch (no) {
			case 1:
				synFileNo = "01";
				break;
			case 2:
				synFileNo = "02";
				break;
			case 3:
				synFileNo = "03";
				break;
			default:
				return "";
			}
			fileName = channel.concat("B").concat(synFileNo);
			break;
		}
		return fileName.concat(SynFileConstants.STRING_UNDERLINE).concat(today)
				.concat(FileUtil.FILETYPE_DAT);
	}
}
