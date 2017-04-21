/**
 * 
 */
package com.hrbb.loan.pos.util.excel;

import java.util.List;

/**
 * <p>Title: IRowReader.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年4月24日
 *
 * logs: 1. 
 */
public interface IRowReader {
	public static final int READER_VER_UNKOWN = -1;
	public static final int READER_VER_03 = 3;
	public static final int READER_VER_07 = 7;
	
	/**业务逻辑实现方法
	 * @param sheetIndex
	 * @param curRow
	 * @param rowlist
	 */
	public void getRows(int sheetIndex, int curRow, List<String> rowlist);
	
	public void setVersion(int ver);

}
