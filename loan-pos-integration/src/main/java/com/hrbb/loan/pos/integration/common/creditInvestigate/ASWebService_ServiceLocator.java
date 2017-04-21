/**
 * ASWebService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hrbb.loan.pos.integration.common.creditInvestigate;

public class ASWebService_ServiceLocator extends org.apache.axis.client.Service implements ASWebService_Service {

    public ASWebService_ServiceLocator() {
    }


    public ASWebService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ASWebService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ASWebServicePort
    private java.lang.String ASWebServicePort_address = "http://197.17.66.179:8080/AmarCRQ/services/ASWebService";

    public java.lang.String getASWebServicePortAddress() {
        return ASWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ASWebServicePortWSDDServiceName = "ASWebServicePort";

    public java.lang.String getASWebServicePortWSDDServiceName() {
        return ASWebServicePortWSDDServiceName;
    }

    public void setASWebServicePortWSDDServiceName(java.lang.String name) {
        ASWebServicePortWSDDServiceName = name;
    }

    public ASWebService_PortType getASWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ASWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getASWebServicePort(endpoint);
    }

    public ASWebService_PortType getASWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ASWebServicePortBindingStub _stub = new ASWebServicePortBindingStub(portAddress, this);
            _stub.setPortName(getASWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setASWebServicePortEndpointAddress(java.lang.String address) {
        ASWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ASWebService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ASWebServicePortBindingStub _stub = new ASWebServicePortBindingStub(new java.net.URL(ASWebServicePort_address), this);
                _stub.setPortName(getASWebServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ASWebServicePort".equals(inputPortName)) {
            return getASWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://com.amarsoft.app.webservice.server", "ASWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://com.amarsoft.app.webservice.server", "ASWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ASWebServicePort".equals(portName)) {
            setASWebServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
