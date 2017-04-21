package com.hrbb.loan.pos.integration.common.creditInvestigate;

public class ASWebServiceProxy implements ASWebService_PortType {
  private String _endpoint = null;
  private ASWebService_PortType aSWebService_PortType = null;
  
  public ASWebServiceProxy() {
    _initASWebServiceProxy();
  }
  
  public ASWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initASWebServiceProxy();
  }
  
  private void _initASWebServiceProxy() {
    try {
      aSWebService_PortType = (new ASWebService_ServiceLocator()).getASWebServicePort();
      if (aSWebService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aSWebService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aSWebService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aSWebService_PortType != null)
      ((javax.xml.rpc.Stub)aSWebService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ASWebService_PortType getASWebService_PortType() {
    if (aSWebService_PortType == null)
      _initASWebServiceProxy();
    return aSWebService_PortType;
  }
  
  public java.lang.String execute(java.lang.String tradeNo, java.lang.String reqXml) throws java.rmi.RemoteException{
    if (aSWebService_PortType == null)
      _initASWebServiceProxy();
    return aSWebService_PortType.execute(tradeNo, reqXml);
  }
  
  
}