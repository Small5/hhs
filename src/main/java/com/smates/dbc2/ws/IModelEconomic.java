package com.smates.dbc2.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2018-10-29T02:43:58.679+08:00
 * Generated source version: 3.1.11
 * 
 */
@WebService(targetNamespace = "http://service.hhs.com/", name = "IModelEconomic")
@XmlSeeAlso({ObjectFactory.class})
public interface IModelEconomic {

    @WebMethod
    @RequestWrapper(localName = "getData", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.GetData")
    @ResponseWrapper(localName = "getDataResponse", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.GetDataResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.smates.dbc2.ws.DoubleArrayArray> getData(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username
    );

    @WebMethod
    @RequestWrapper(localName = "queryAvailable", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.QueryAvailable")
    @ResponseWrapper(localName = "queryAvailableResponse", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.QueryAvailableResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<java.lang.String> queryAvailable(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username
    );

    @WebMethod
    @RequestWrapper(localName = "start", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.Start")
    @ResponseWrapper(localName = "startResponse", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.StartResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String start(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "countyName", targetNamespace = "")
        java.lang.String countyName,
        @WebParam(name = "SurSupR", targetNamespace = "")
        java.lang.String surSupR,
        @WebParam(name = "GWSupR", targetNamespace = "")
        java.lang.String gwSupR,
        @WebParam(name = "ArgupR", targetNamespace = "")
        java.lang.String argupR,
        @WebParam(name = "IndiupR", targetNamespace = "")
        java.lang.String indiupR,
        @WebParam(name = "SerupR", targetNamespace = "")
        java.lang.String serupR
    );

    @WebMethod
    @RequestWrapper(localName = "queryState", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.QueryState")
    @ResponseWrapper(localName = "queryStateResponse", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.QueryStateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int queryState(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username
    );

    @WebMethod
    @RequestWrapper(localName = "getDataYearly", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.GetDataYearly")
    @ResponseWrapper(localName = "getDataYearlyResponse", targetNamespace = "http://service.hhs.com/", className = "com.smates.dbc2.ws.GetDataYearlyResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.smates.dbc2.ws.DoubleArrayArray> getDataYearly(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "watershedCode", targetNamespace = "")
        java.lang.String watershedCode
    );
}
