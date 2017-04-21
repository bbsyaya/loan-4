package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hrbb.loan.pos.util.StringUtil;

public class TFixLineInfo implements Serializable{
	
	
    
	private static final long serialVersionUID = -5501126825982813871L;

	public static final Map<String, String> codeVal = new ConcurrentHashMap<String, String>();
    
    static {
        codeVal.put("0001", "电话正查(电信企业)");
        codeVal.put("0003", "名称反查(电信企业)");
        codeVal.put("0004", "地址反查(电信企业)");
        codeVal.put("0101", "电话正查(电信白页)");
        codeVal.put("0104", "家庭地址反查(电信白页)");
        codeVal.put("1101", "电话正查(联通固话)");
        codeVal.put("1102", "名称和地址反查(联通固话)");
        codeVal.put("1103", "名称反查(联通固话)");
        codeVal.put("1104", "地址反查(联通固话)");
    }
    private Integer id;

    private String telNum;

    private String name;

    private String address;

    private String version;

    private String telInput;

    private String nameInput;

    private String addressInput;

    private String uniqueNum;

    private String uniqueNumDesc;

    private String areaCode;

    private String queryResult;

    private String queryType;

    private String corpTel;

    private String corpName;

    private String corpAddress;

    private Date created_at;

    private Date updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum == null ? null : telNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getTelInput() {
        return telInput;
    }

    public void setTelInput(String telInput) {
        this.telInput = telInput == null ? null : telInput.trim();
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput == null ? null : nameInput.trim();
    }

    public String getAddressInput() {
        return addressInput;
    }

    public void setAddressInput(String addressInput) {
        this.addressInput = addressInput == null ? null : addressInput.trim();
    }

    public String getUniqueNum() {
        return uniqueNum;
    }

    public void setUniqueNum(String uniqueNum) {
        this.uniqueNum = uniqueNum == null ? null : uniqueNum.trim();
    }

    public String getUniqueNumDesc() {
        return uniqueNumDesc;
    }

    public void setUniqueNumDesc(String uniqueNumDesc) {
        this.uniqueNumDesc = uniqueNumDesc == null ? null : uniqueNumDesc.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(String queryResult) {
        this.queryResult = queryResult == null ? null : queryResult.trim();
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType == null ? null : queryType.trim();
    }

    public String getCorpTel() {
        return corpTel;
    }

    public void setCorpTel(String corpTel) {
        this.corpTel = corpTel == null ? null : corpTel.trim();
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName == null ? null : corpName.trim();
    }

    public String getCorpAddress() {
        return corpAddress;
    }

    public void setCorpAddress(String corpAddress) {
        this.corpAddress = corpAddress == null ? null : corpAddress.trim();
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
    
    /**
     * @return fixLineInfo 是否是有效信息
     */
    public boolean isEmpty(){
        return StringUtil.isEmpty(telNum);
    }
}