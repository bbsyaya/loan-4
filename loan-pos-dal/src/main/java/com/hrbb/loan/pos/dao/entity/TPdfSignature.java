package com.hrbb.loan.pos.dao.entity;

public class TPdfSignature {
    
    public TPdfSignature() {
        super();
    }

    public TPdfSignature(String contNo, String signature) {
        super();
        this.contNo = contNo;
        this.signature = signature;
    }

    private String contNo;

    private String signature;

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo == null ? null : contNo.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }
}