package com.hrbb.test;

import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.loan.pos.biz.backstage.inter.SynFileBiz;
import com.hrbb.loan.pos.biz.backstage.inter.SynFileUploadBiz;
import com.hrbb.loan.pos.biz.constants.SynFileConstants;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.FileUtil;
import com.hrbb.test.UnitTest;

public class SynFileBizImplTest extends UnitTest {

	@Autowired
	@Qualifier("synFileBiz")
	private SynFileBiz biz;

	@Autowired
	@Qualifier("synFileUploadBiz")
	private SynFileUploadBiz bizUpload;

	@Test
	public void testServe() throws URISyntaxException {
		// 项目路径
		// String synFilePath = getClass().getResource("../")
		// + SynFileConstants.SYNFILEUM;
		String synFilePath = this.getClass().getClassLoader()
				.getResource("../../").toURI().getPath()
				+ SynFileConstants.SYNFILEUM;
		// 文件名
		String fileName = SynFileConstants.NO_STATISTICS
				.concat(SynFileConstants.STRING_UNDERLINE)
				.concat(DateUtil.getTodayDatePattern1())
				.concat(FileUtil.FILETYPE_XLSX);
		// 创建文件
		// biz.makeSynFile(synFilePath, fileName);
		// 上传文件
		// bizUpload.upload(synFilePath + fileName);
	}
}
