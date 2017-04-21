/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.SynFileBiz;
import com.hrbb.loan.pos.biz.constants.SynFileConstants;
import com.hrbb.loan.pos.service.BusinessDictionaryService;
import com.hrbb.loan.pos.service.CreditApplyForReviewService;
import com.hrbb.loan.pos.service.ReceiptInfoService;
import com.hrbb.loan.pos.util.FileUtil;
import com.hrbb.loan.pos.util.StringUtil;

/**
 * 数据同步接口
 * 
 * @author marco
 * @version $Id: LedgerBizImpl.java, v 0.1 2015-4-24 下午4:20:22 marco Exp $
 */
@Component("synFileBiz")
public class SynFileBizImpl implements SynFileBiz {

	private Logger LOG = LoggerFactory.getLogger(SynFileBizImpl.class);

	@Autowired
	@Qualifier("businessDictionaryService")
	private BusinessDictionaryService serviceBD;

	@Autowired
	@Qualifier("receiptInfoService")
	private ReceiptInfoService serviceRI;

	@Autowired
	@Qualifier("creditApplyForReviewService")
	private CreditApplyForReviewService serviceCAFR;

	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.LedgerBiz#makeSynFile()
	 */
	public boolean makeSynFile(String pathStr, String fileName, String channel,
			String excuteDay) {

		LOG.debug("makeSynFile begin");
		// 取得路径
		LOG.debug("取得路径pathStr=" + pathStr);
		// 判断路径存在
		if (!FileUtil.createDirectory(pathStr)) {
			LOG.error("创建路径失败！");
			return false;
		} else {
			LOG.debug("路径存在");
		}

		// 判断文件是否存在，存在测删除
		String allPath = pathStr + fileName;
		LOG.debug("allPath=" + allPath);
		if (FileUtil.checkFileExist(allPath)) {
			LOG.debug("文件存在，删除");
			FileUtil.deleteIfExists(allPath);
		} else {
			LOG.debug("文件不存在。");
		}

		LOG.debug("创建文件fileName=" + fileName);

		// 创建文件
		Workbook workbook = makeFileTemplete();
		if (workbook == null) {
			LOG.error("创建文件失败！");
			return false;
		}

		// 写入数据
		setRowData(workbook, channel, excuteDay);

		// 保存文件
		if (!saveFile(pathStr + fileName, workbook)) {
			LOG.error("保存文件失败！");
			return false;
		}

		LOG.debug("makeSynFile end");
		return true;
	}

	/**
	 * 银商数据统计表取得数据，生成文件
	 * 
	 * @return boolean
	 */
	private Workbook makeFileTemplete() {

		Workbook workbook = null;
		try {
			// 创建文件
			// XSSFWork used for .xslx (>= 2007), HSSWorkbook for 03 .xsl
			// workbook = new HSSFWorkbook();
			workbook = new XSSFWorkbook();
		} catch (Exception e) {
			LOG.error("Error on CREATING excel workbook:", e);
			return null;
		}
		LOG.debug("创建文件成功");

		// 创建标题
		createRow(workbook);

		LOG.debug("创建文件模板成功");
		return workbook;
	}

	/**
	 * 保存文件-模板
	 * 
	 * @param pathStr
	 * @return
	 */
	private boolean saveFile(String pathStr, Workbook workbook) {

		LOG.debug("保存文件全路径pathStr=" + pathStr);

		// 写入文件流，创建文件
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(pathStr);
			workbook.write(outputStream);
			outputStream.flush();
			LOG.debug("保存文件成功。");
		} catch (Exception e) {
			LOG.error("Error on CREATING excel workbook:", e);
			return false;
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// 关闭失败，不影响业务
					LOG.debug("outputStream Error on saving excel workbook:", e);
				}
			}
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					// 关闭失败，不影响业务
					LOG.debug("workbook Error on saving excel workbook:", e);
				}
			}
		}
		return true;
	}

	/**
	 * 创建数据行
	 * 
	 * @param sheet
	 * @param style
	 * @return
	 */
	private void setRowData(Workbook workbook, String channel, String excuteDay) {

		LOG.debug("写入数据开始");
		// 创建标题
		CellStyle style = getStyleCell(workbook);

		// 取得sheet
		Sheet sheet = workbook.getSheet(SynFileConstants.SHEET_NAME);

		Row row = null;
		Cell cell = null;

		BigDecimal TEN_THOUSAND = new BigDecimal(10000);

		// 查询数据
		List<Map<String, String>> data = getData(channel, excuteDay);
		int rowCount = data.size();

		for (int i = 0; i < rowCount; i++) {

			row = sheet.createRow(i + 1);

			Map<String, String> map = data.get(i);

			for (int j = 0; j < 11; j++) {

				cell = row.createCell(j);

				switch (j) {
				case 0:
					cell.setCellValue(i + 1);
					break;
				case 1:
					if (StringUtil.isEmpty(map.get("itemName"))) {
						cell.setCellValue("");
					} else {
						cell.setCellValue(map.get("itemName"));
					}
					break;
				case 2:
					if (StringUtil.isEmpty(map.get("countWeek"))) {
						cell.setCellValue(0);
					} else {
						cell.setCellValue(Long.parseLong(map.get("countWeek")));
					}
					break;
				case 3:
					if (StringUtil.isEmpty(map.get("countMonth"))) {
						cell.setCellValue(0);
					} else {
						cell.setCellValue(Long.parseLong(map.get("countMonth")));
					}
					break;
				case 4:
					if (StringUtil.isEmpty(map.get("countYear"))) {
						cell.setCellValue(0);
					} else {
						cell.setCellValue(Long.parseLong(map.get("countYear")));
					}
					break;
				case 5:
					if (StringUtil.isEmpty(map.get("countHist"))) {
						cell.setCellValue(0);
					} else {
						cell.setCellValue(Long.parseLong(map.get("countHist")));
					}
					break;
				case 6:
					if (StringUtil.isEmpty(map.get("loan"))) {
						cell.setCellValue(0.00);
					} else {
						BigDecimal loan = new BigDecimal(map.get("loan"));
						cell.setCellValue(loan.divide(TEN_THOUSAND)
								.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue());
					}
					break;
				case 7:
					if (StringUtil.isEmpty(map.get("amountWeek"))) {
						cell.setCellValue(0.00);
					} else {
						BigDecimal loan = new BigDecimal(map.get("amountWeek"));
						cell.setCellValue(loan.divide(TEN_THOUSAND)
								.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue());
					}
					break;
				case 8:
					if (StringUtil.isEmpty(map.get("amountMonth"))) {
						cell.setCellValue(0.00);
					} else {
						BigDecimal loan = new BigDecimal(map.get("amountMonth"));
						cell.setCellValue(loan.divide(TEN_THOUSAND)
								.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue());
					}
					break;
				case 9:
					if (StringUtil.isEmpty(map.get("amountYear"))) {
						cell.setCellValue(0.00);
					} else {
						BigDecimal loan = new BigDecimal(map.get("amountYear"));
						cell.setCellValue(loan.divide(TEN_THOUSAND)
								.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue());
					}
					break;
				case 10:
					if (StringUtil.isEmpty(map.get("amountHist"))) {
						cell.setCellValue(0.00);
					} else {
						BigDecimal loan = new BigDecimal(map.get("amountHist"));
						cell.setCellValue(loan.divide(TEN_THOUSAND)
								.setScale(2, BigDecimal.ROUND_HALF_UP)
								.doubleValue());
					}
					break;
				default:
					cell.setCellValue("");
					break;
				}
				cell.setCellStyle(style);
				sheet.autoSizeColumn(j);
			}
		}
		// 合计行
		createSumRow(rowCount + 1, workbook);

		LOG.debug("写入数据结束");
	}

	/**
	 * 查询数据
	 * 
	 * @return
	 */
	private List<Map<String, String>> getData(String channel, String excuteDay) {

		Map<String, String> p = new HashMap<String, String>();
		p.put("channel", channel);
		p.put("excuteDay", excuteDay);

		// 数据
		List<Map<String, String>> data = new ArrayList<>();

		// 查询数据-客户数
		List<Map<String, String>> dataCustCount = serviceCAFR
				.selectNewCustCountForUM(p);
		// 查询数据-交易金额
		List<Map<String, String>> dataAmount = serviceRI.selectSumForUM(p);

		String regionAmount = null;
		String regionCustCount = null;
		boolean mappedFlag = false;
		for (Map<String, String> mapAmount : dataAmount) {
			regionAmount = mapAmount.get("region");
			for (Map<String, String> mapCustCount : dataCustCount) {
				regionCustCount = mapCustCount.get("region");
				// 同一个省
				if (regionCustCount.equals(regionAmount)) {
					// 合并数据
					mapCustCount.putAll(mapAmount);
					mappedFlag = true;
					break;
				}
			}
			if (!mappedFlag) {
				// 没有匹配到
				data.add(mapAmount);
			}
		}
		// 合并数据
		data.addAll(dataCustCount);

		return data;
	}

	/**
	 * 创建模板
	 * 
	 * @param sheet
	 * @param style
	 * @return
	 */
	private void createRow(Workbook workbook) {

		// 创建1个sheet
		Sheet sheet = workbook.createSheet(SynFileConstants.SHEET_NAME);

		// 创建标题
		CellStyle styleTitle = getStyleTitle(workbook);

		Row row0 = sheet.createRow(0);

		for (int i = 0; i < 11; i++) {
			Cell cell = row0.createCell(i);
			switch (i) {
			case 0:
				cell.setCellValue("序号");
				break;
			case 1:
				cell.setCellValue("银商分公司");
				break;
			case 2:
				cell.setCellValue("本周新增客户数");
				break;
			case 3:
				cell.setCellValue("本月新增客户数");
				break;
			case 4:
				cell.setCellValue("本年新增客户数");
				break;
			case 5:
				cell.setCellValue("历史累计客户数");
				break;
			case 6:
				cell.setCellValue("贷款余额(万元)");
				break;
			case 7:
				cell.setCellValue("本周交易金额(万元)");
				break;
			case 8:
				cell.setCellValue("本月交易金额(万元)");
				break;
			case 9:
				cell.setCellValue("本年交易金额(万元)");
				break;
			case 10:
				cell.setCellValue("历史累计交易金额(万元)");
				break;
			default:
				break;
			}
			cell.setCellStyle(styleTitle);
			sheet.autoSizeColumn(i);
		}
	}

	/**
	 * 创建合计行
	 * 
	 * @param sheet
	 * @param style
	 * @return
	 */
	private void createSumRow(int rowCount, Workbook workbook) {
		Cell cell = null;
		// 取得sheet
		Sheet sheet = workbook.getSheet(SynFileConstants.SHEET_NAME);
		Row row = sheet.createRow(rowCount);
		// 标题式样
		CellStyle styleTitle = getStyleTitle(workbook);

		for (int j = 0; j < 11; j++) {

			cell = row.createCell(j, Cell.CELL_TYPE_STRING);

			switch (j) {
			case 0:
				cell.setCellValue("");
				break;
			case 1:
				cell.setCellValue("总计");
				break;
			case 2:
				if (rowCount == 1) {
					cell.setCellValue("0");
				} else {
					cell.setCellFormula("SUM(C2:C" + rowCount + ")");
				}
				break;
			case 3:
				if (rowCount == 1) {
					cell.setCellValue("0");
				} else {
					cell.setCellFormula("SUM(D2:D" + rowCount + ")");
				}
				break;
			case 4:
				if (rowCount == 1) {
					cell.setCellValue("0");
				} else {
					cell.setCellFormula("SUM(E2:E" + rowCount + ")");
				}
				break;
			case 5:
				if (rowCount == 1) {
					cell.setCellValue("0");
				} else {
					cell.setCellFormula("SUM(F2:F" + rowCount + ")");
				}
				break;
			case 6:
				if (rowCount == 1) {
					cell.setCellValue("0.00");
				} else {
					cell.setCellFormula("SUM(G2:G" + rowCount + ")");
				}
				break;
			case 7:
				if (rowCount == 1) {
					cell.setCellValue("0.00");
				} else {
					cell.setCellFormula("SUM(H2:H" + rowCount + ")");
				}
				break;
			case 8:
				if (rowCount == 1) {
					cell.setCellValue("0.00");
				} else {
					cell.setCellFormula("SUM(I2:I" + rowCount + ")");
				}
				break;
			case 9:
				if (rowCount == 1) {
					cell.setCellValue("0.00");
				} else {
					cell.setCellFormula("SUM(J2:J" + rowCount + ")");
				}
				break;
			case 10:
				if (rowCount == 1) {
					cell.setCellValue("0.00");
				} else {
					cell.setCellFormula("SUM(K2:K" + rowCount + ")");
				}
				break;
			default:
				cell.setCellValue("");
				break;
			}
			cell.setCellStyle(styleTitle);
			sheet.autoSizeColumn(j);
		}
	}

	/**
	 * 创建单元格样式-标题
	 * 
	 * @param workbook
	 * @return
	 */
	private CellStyle getStyleTitle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		// 设置单元格字体
		Font headerFont = workbook.createFont(); // 字体
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(HSSFColor.BLACK.index);
		headerFont.setFontName("宋体");
		headerFont.setBold(true);
		style.setFont(headerFont);
		// 设置单元格边框及颜色
		style.setBorderBottom((short) 2);
		style.setBorderLeft((short) 2);
		style.setBorderRight((short) 2);
		style.setBorderTop((short) 2);
		style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		return style;
	}

	/**
	 * 创建单元格样式-普通单元格
	 * 
	 * @param workbook
	 * @return
	 */
	private CellStyle getStyleCell(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		// 设置单元格字体
		Font headerFont = workbook.createFont(); // 字体
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(HSSFColor.BLACK.index);
		headerFont.setFontName("宋体");
		style.setFont(headerFont);
		// 设置单元格边框及颜色
		style.setBorderBottom((short) 2);
		style.setBorderLeft((short) 2);
		style.setBorderRight((short) 2);
		style.setBorderTop((short) 2);
		return style;
	}
}
