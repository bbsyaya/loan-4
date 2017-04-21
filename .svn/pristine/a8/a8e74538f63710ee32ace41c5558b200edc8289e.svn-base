/**
 * 
 *哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hrbb.loan.controller.FileVisitor.FileVisitor;
import com.hrbb.loan.pos.biz.backstage.inter.SynFileSummaryBiz;
import com.hrbb.loan.pos.biz.backstage.inter.SynFileUploadBiz;
import com.hrbb.loan.pos.biz.constants.SynFileConstants;

/**
 * 
 * @author marco
 * @version $Id: SynFileSummaryController.java, v 0.1 2015-3-11 上午11:35:10 marco
 *          Exp $
 */
@Controller
@RequestMapping("/synFileSummary")
public class SynFileSummaryController {

	private Logger logger = LoggerFactory
			.getLogger(SynFileSummaryController.class);

	@Autowired
	@Qualifier("synFileSummaryBiz")
	private SynFileSummaryBiz biz;

	@Autowired
	@Qualifier("synFileUploadBiz")
	private SynFileUploadBiz bizUpload;

	/**
	 * <h2>初始化文件列表</h2>
	 * 
	 * @return modelAndView
	 */
	@RequestMapping("/initSynFileList")
	public ModelAndView initSynFileList(HttpServletRequest request,
			PrintWriter out) {
		// 文件真实路径
		String synFileRealPath = request.getSession().getServletContext()
				.getRealPath("")
				+ "/" + SynFileConstants.SYNFILESUMMARY;
		logger.debug("synFileRealPath=" + synFileRealPath);

		Path fileDir = Paths.get(synFileRealPath);

		FileVisitor visitor = new FileVisitor();

		List<Map<String, Object>> fileNameList = Lists.newArrayList();
		try {
			Files.walkFileTree(fileDir, visitor);
			List<String> fileNames = visitor.getFileNameList();
			// 排倒叙
			Collections.sort(fileNames, new Comparator<String>() {
				public int compare(String name0, String name1) {
					return name1.compareTo(name0);
				}
			});

			Map<String, Object> m = null;
			for (String fileName : fileNames) {
				m = Maps.newHashMap();
				m.put("fileName", fileName);
				m.put("fileURL", fileName + "|"
						+ SynFileConstants.SYNFILESUMMARY + fileName);
				fileNameList.add(m);
			}
		} catch (IOException e) {
			logger.error("遍历文件路径失败！", e);
		}
		logger.debug("fileNameList.size=" + fileNameList.size());
		JSONObject aaJson = new JSONObject();
		aaJson.put("rows", fileNameList);
		out.write(aaJson.toJSONString());
		return null;
	}

	/**
	 * <h2>生成文件</h2>
	 * 
	 * @param fileName
	 * @param excuteDay
	 * @return modelAndView
	 */
	@RequestMapping("/makeSynFile")
	public ModelAndView makeSynFile(
			@RequestParam(value = "channel", required = false) String channel,
			@RequestParam(value = "fromDay", required = false) String fromDay,
			@RequestParam(value = "toDay", required = false) String toDay,
			HttpServletRequest request, PrintWriter out) {
		// 创建文件
		String msg = null;
		try {
			Map<String, String> resp = biz.makeSynFile(channel, fromDay, toDay);
			msg = resp.get("msg");
		} catch (Exception e) {
			logger.error("生成失败，请联系系统管理员。", e);
			msg = "生成失败，请联系系统管理员。";
		}
		out.print(msg);
		return null;
	}

	/**
	 * <h2>上传文件给银商</h2>
	 * 
	 * @param fileName
	 * @return modelAndView
	 */
	@RequestMapping("/uploadSynFile")
	public ModelAndView uploadSynFile(
			@RequestParam(value = "fileName", required = false) String fileName,
			HttpServletRequest request, PrintWriter out) {
		String msg = null;
		try {
			Map<String, String> resp = biz.upload(fileName);
			msg = resp.get("msg");
		} catch (Exception e) {
			msg = "上传失败，请联系系统管理员。";
		}
		out.print(msg);
		return null;
	}
}
