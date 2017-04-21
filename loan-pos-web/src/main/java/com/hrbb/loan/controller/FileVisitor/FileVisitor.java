/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller.FileVisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件遍历类
 * 
 * @author marco
 * @version $Id: FileVisitor.java, v 0.1 2015-7-24 上午11:31:53 marco Exp $
 */
public class FileVisitor extends SimpleFileVisitor<Path> {

	private List<String> fileNameList = new ArrayList<String>();

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exec)
			throws IOException {
		// 访问文件夹之前调用
		// System.out.println("Just visited " + dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		// 访问文件夹之后调用
		// System.out.println("About to visit " + dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		// 访问文件后调用
		if (attrs.isRegularFile())
			fileNameList.add(file.getFileName().toString());
		// 插入一个List<String>有别的用。
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		// 文件不可访问时调用
		// System.out.println(exc.getMessage());
		return FileVisitResult.CONTINUE;
	}

	public List<String> getFileNameList() {
		return fileNameList;
	}
}
