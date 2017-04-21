package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TUpsIndexConsumeGategories implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5761536395256671269L;

	private Integer id;

    private String fileUuid;
    
    private String indexConsumeName;

    private Long indexConsumeAmount;

    private String indexConsumeCount;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndexConsumeName() {
        return indexConsumeName;
    }

    public void setIndexConsumeName(String indexConsumeName) {
        this.indexConsumeName = indexConsumeName == null ? null : indexConsumeName.trim();
    }

    public Long getIndexConsumeAmount() {
        return indexConsumeAmount;
    }

    public void setIndexConsumeAmount(Long indexConsumeAmount) {
        this.indexConsumeAmount = indexConsumeAmount;
    }

    public String getIndexConsumeCount() {
        return indexConsumeCount;
    }

    public void setIndexConsumeCount(String indexConsumeCount) {
        this.indexConsumeCount = indexConsumeCount == null ? null : indexConsumeCount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid;
    }
}