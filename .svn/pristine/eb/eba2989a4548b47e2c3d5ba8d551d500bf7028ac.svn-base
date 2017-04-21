/**
 * 哈尔滨银行互联网金融事业部
 * Copyright (c) 2015 Hrbbank Ltd. All Rights Reserved.
 */
package com.hrbb.loan.work;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.util.StringUtil;

/**
 * 工作管理器组.
 * 
 * @author xiongshaogang
 * @version $Id: WorkManagerGroup.java, v 0.1 2015年5月15日 下午1:26:54 xiongshaogang Exp $
 */
@Service("WorkManagerGroup")
public class WorkManagerGroup {
    
    public static String PRE_DATASYN_WORK = "preDataSyn";
    
    public static String PRE_POSLOAN_DATASYN_WORK = "prePosLoanDataSyn";
    
    public static String PRE_RERUN_DATASYN_WORK = "preRerunDataSyn";
    
    @Autowired
    private WorkManager WorkManager;
    
    /**
     * 线程池组. 
     */
    public static Map<String, WorkManager> workManagerMap = Maps.newHashMap();
    
    public static void putWork(String pre, WorkManager workManager) {
        if (StringUtil.isEmpty(pre) || workManager == null) {
            return;
        }
        workManagerMap.put(pre, workManager);
    }
    
    public static WorkManager removeWork(String pre) {
        if (!workManagerMap.containsKey(pre)) {
            return null;
        }
        
        return workManagerMap.remove(pre);
    }
    
    public static WorkManager getWorkManager(String pre) {
        if (!workManagerMap.containsKey(pre)) {
            return null;
        }
        
        return workManagerMap.get(pre);
    }
    
    public static void start() {
        if (workManagerMap.size() <= 0) {
            return;
        }
        
        for (Map.Entry<String, WorkManager> en : workManagerMap.entrySet()) {
            String pre = en.getKey();
            WorkManager workManager = workManagerMap.get(pre);
            
            if (workManager != null) {
                workManager.start();
            }
        }
    }
    
    public static void stop() {
        if (workManagerMap.size() <= 0) {
            return;
        }
        
        for (Map.Entry<String,  WorkManager> en : workManagerMap.entrySet()) {

            WorkManager workManager = en.getValue();
            
            if (workManager != null) {
                workManager.stop();
            }
        }
    }
    
    public synchronized void addThread(String pre, Runnable runnable) {
        if (!workManagerMap.containsKey(pre)) {
            putWork(pre, WorkManager);
        }
        
        getWorkManager(pre).addWork(runnable);
    }
    
    public synchronized void addThreadWithBlock(String pre, Runnable runnable) {
        if (!workManagerMap.containsKey(pre)) {
            putWork(pre, WorkManager);
        }
        
        getWorkManager(pre).addWorkWithBlock(runnable);
    }
}
