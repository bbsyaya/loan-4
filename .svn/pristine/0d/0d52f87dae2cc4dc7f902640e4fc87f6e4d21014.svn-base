package com.hrbb.loan.channel.gboss.obj;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.hrbb.loan.pos.util.XmlUtil;

/**
 * 国政通： 行驶证信息查询应答.
 * 
 * @author xiongshaogang
 * @version $Id: GbossResBean.java, v 0.1 2015年4月27日 下午6:17:44 xiongshaogang Exp $
 */
public class GbossResponseObj {
    
    private String messageStatus;
    private String messageValue;
    private List<VehicleInfo> vehicleInfoList;
    
    
    public String getMessageStatus() {
        return messageStatus;
    }
    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }
    public String getMessageValue() {
        return messageValue;
    }
    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }
    public List<VehicleInfo> getVehicleInfoList() {
        return vehicleInfoList;
    }
    public void setVehicleInfoList(List<VehicleInfo> vehicleInfoList) {
        this.vehicleInfoList = vehicleInfoList;
    }
    
    public void addVehicleInfoList(VehicleInfo vehicleInfo) {
        this.vehicleInfoList.add(vehicleInfo);
    }
    
    public boolean parseXml(String respXml) {
        try {
            Document doc = DocumentHelper.parseText(respXml);
            Element rootElement = doc.getRootElement();
            Element messageElement = (Element) rootElement.selectSingleNode("message");
            this.setMessageStatus(XmlUtil.getSingleNodeText(messageElement, "status"));
            this.setMessageValue(XmlUtil.getSingleNodeText(messageElement, "value"));
            Element vehicleInfoElement = (Element) rootElement.selectSingleNode("vehicleInfos");
            List<Element> vehicleInfoElements = vehicleInfoElement.selectNodes("vehicleInfo");
            if (vehicleInfoElements != null && vehicleInfoElements.size() > 0) {
                VehicleInfo vehicleInfo = null;
                for (int i = 0; i < vehicleInfoElements.size(); i++) {
                    vehicleInfo = new VehicleInfo();
                    vehicleInfo.parseElement(vehicleInfoElements.get(i));
                    this.addVehicleInfoList(vehicleInfo);
                }
            }
            return true;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
