package com.hrbb.loan.pos.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ExecutorUtil {
	
	public static Executor getScheduledThreadExecutor(int size){
		return new ScheduledThreadPoolExecutor(size);
	}
}
