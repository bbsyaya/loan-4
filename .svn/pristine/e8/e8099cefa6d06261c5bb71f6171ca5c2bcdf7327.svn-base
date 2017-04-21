/**
 * 哈尔滨银行互联网金融事业部
 * Copyright (c) 2015 Hrbbank Ltd. All Rights Reserved.
 */
package com.hrbb.loan.work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 工作管理器.
 * 
 * @author xiongshaogang
 * @version $Id: WorkManager.java, v 0.1 2015年3月21日 下午4:24:39 xiongshaogang Exp $
 */
@Scope("prototype")
@Service("WorkManager")
public class WorkManager {
	
	private static WorkManager workManager;
	ExecutorService pool = null;
	private int workSize = 0;
	private List<Runnable> workList = null;
	private List<Future<?>> futures = null;
	
	public WorkManager() {
		this.workSize = 100;
		this.workList = new ArrayList<Runnable>();
		this.futures = new ArrayList<Future<?>>();
		pool = Executors.newFixedThreadPool(this.workSize);
	}
	public WorkManager(int workSize, List<Runnable> workList) {
		this.workSize = workSize;
		this.workList = workList;
		this.futures = new ArrayList<Future<?>>();
		pool = Executors.newFixedThreadPool(this.workSize);
	}

	public void start() {
		if (this.workList.size() < 1) {
			return;
		}
		for (int i = 0; i < this.workList.size(); i++) {
			this.futures.add(pool.submit(workList.get(i)));
		}
	}
	
	public void block() {
		if (this.futures.size() < 1) {
			return;
		}
		for (int i = 0; i < this.futures.size(); i++) {
			try {
				this.futures.get(i).get();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
	public void stop() {
		if (this.futures.size() < 1) {
			return;
		}
		for (int i = 0; i < this.futures.size(); i++) {
			Future<?> future = this.futures.get(i);
			future.cancel(true);
		}
	}

	/**
	 * @return the workSize
	 */
	public int getWorkSize() {
		return workSize;
	}

	/**
	 * @param workSize the workSize to set
	 */
	public void setWorkSize(int workSize) {
		this.workSize = workSize;
	}
	
	public void addWork(Runnable t) {
		this.workList.add(t);
		this.futures.add(pool.submit(t));
	}
	
    public void addWorkWithBlock(Runnable t) {
        this.workList.add(t);
        Future<?> tmpFuture = pool.submit(t);
        this.futures.add(tmpFuture);
        try {
            tmpFuture.get();
        } catch (Exception e) {
            return;
        }
    }
	
	/**
	 * 多例生成.
	 * @return
	 */
	public static synchronized WorkManager getWorkManager() {
	    workManager = new WorkManager();
		return workManager;
	}
	
	/**
	 * 多例生成，指定大小.
	 * 
	 * @param size
	 * @return
	 */
	public static synchronized WorkManager getWorkManager(int size) {
	    workManager = new WorkManager(size, new ArrayList<Runnable>());
        return workManager;
    }
}
