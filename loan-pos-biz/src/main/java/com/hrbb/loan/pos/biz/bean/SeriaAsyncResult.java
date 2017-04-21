package com.hrbb.loan.pos.biz.bean;

import java.io.Serializable;

import org.springframework.scheduling.annotation.AsyncResult;

/**
 * @author zhangwei5@hrbb.com.cn
 * @param <V>
 * @date 2015年10月16日下午5:30:51 
 */
public class SeriaAsyncResult<V> extends AsyncResult<V> implements Serializable {

    public SeriaAsyncResult(V value) {
        super(value);
    }

    private static final long serialVersionUID = 2783991303921263500L;

}
