package com.hrbb.loan.pos.service.bean;

import java.io.Serializable;
import java.util.List;

import com.hrbb.loan.pos.dao.entity.TBlacklist;

/**
 * 
 * 
 * @author XLY
 * @version $Id: BlackListQueryVo.java, v 0.1 2015-2-28 下午4:05:32 XLY Exp $
 */
public class BlackListQueryResVo implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -578017211910946364L;

	private String totalRecodeNum;
    
    private List<TBlacklist> list;

    public String getTotalRecodeNum() {
        return totalRecodeNum;
    }

    public void setTotalRecodeNum(String totalRecodeNum) {
        this.totalRecodeNum = totalRecodeNum;
    }

    public List<TBlacklist> getList() {
        return list;
    }

    public void setList(List<TBlacklist> list) {
        this.list = list;
    }
    
    
}
