package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TUpsIndexMonthConsumeCondition implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1550248256221587673L;

	private Integer id;

    private String fileUuid;

    private String year;

    private String month;

    private Long indexMonthConsumeAomut;

    private String indexMonthConsumeCount;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid == null ? null : fileUuid.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public Long getIndexMonthConsumeAomut() {
        return indexMonthConsumeAomut;
    }

    public void setIndexMonthConsumeAomut(Long indexMonthConsumeAomut) {
        this.indexMonthConsumeAomut = indexMonthConsumeAomut;
    }

    public String getIndexMonthConsumeCount() {
        return indexMonthConsumeCount;
    }

    public void setIndexMonthConsumeCount(String indexMonthConsumeCount) {
        this.indexMonthConsumeCount = indexMonthConsumeCount == null ? null : indexMonthConsumeCount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}