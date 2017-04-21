package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.UploadBizInter;
import com.hrbb.loan.pos.biz.bean.Upload2FileSystem;


@Component("uploadBiz")
public class UploadBizImpl implements UploadBizInter {
	
	Logger logger = LoggerFactory.getLogger(UploadBizImpl.class);

	@Autowired
	private Upload2FileSystem u2fs;
	
	@Override
	public boolean uploadFile(String fileName, byte[] bytes) {
		try{
			return u2fs.executeForPeanut(fileName, bytes);
		}catch(Exception e){
			logger.error("阉割版上传影像异常", e);
			return false;
		}
	}

}
