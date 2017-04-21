package com.hrbb.loan.work.bean;

/**
 * 不等贷 报文头.
 * 
 * @author xiongshaogang
 * @version $Id: PosLoanHeaderBean.java, v 0.1 2015年5月21日 上午9:36:42 xiongshaogang Exp $
 */
public class PosLoanHeaderBean {

    private String version;
    private String userId;
    private String sessionId;
    private String appSource;
    private String mac;
    
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getAppSource() {
        return appSource;
    }
    public void setAppSource(String appSource) {
        this.appSource = appSource;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
}
