package com.hrbb.loan.work;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service("DataSynGetWork")
public class DataSynGetWork implements Runnable {
    
    

    @Override
    public void run() {
        // 1. 征信
        
        // 2. 银联智慧
        
        // 3. 国政通(行驶证、乘机人价值分析、学位）
        
        // 4. 人人催
        
    }
}
