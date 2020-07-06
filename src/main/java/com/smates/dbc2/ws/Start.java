
package com.smates.dbc2.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>start complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="start"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SurSupR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GWSupR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ArgupR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IndiupR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SerupR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "start", propOrder = {
    "username",
    "countyName",
    "surSupR",
    "gwSupR",
    "argupR",
    "indiupR",
    "serupR"
})
public class Start {

    protected String username;
    protected String countyName;
    @XmlElement(name = "SurSupR")
    protected String surSupR;
    @XmlElement(name = "GWSupR")
    protected String gwSupR;
    @XmlElement(name = "ArgupR")
    protected String argupR;
    @XmlElement(name = "IndiupR")
    protected String indiupR;
    @XmlElement(name = "SerupR")
    protected String serupR;

    /**
     * 获取username属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置username属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * 获取countyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * 设置countyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountyName(String value) {
        this.countyName = value;
    }

    /**
     * 获取surSupR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurSupR() {
        return surSupR;
    }

    /**
     * 设置surSupR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurSupR(String value) {
        this.surSupR = value;
    }

    /**
     * 获取gwSupR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGWSupR() {
        return gwSupR;
    }

    /**
     * 设置gwSupR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGWSupR(String value) {
        this.gwSupR = value;
    }

    /**
     * 获取argupR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArgupR() {
        return argupR;
    }

    /**
     * 设置argupR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArgupR(String value) {
        this.argupR = value;
    }

    /**
     * 获取indiupR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndiupR() {
        return indiupR;
    }

    /**
     * 设置indiupR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndiupR(String value) {
        this.indiupR = value;
    }

    /**
     * 获取serupR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerupR() {
        return serupR;
    }

    /**
     * 设置serupR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerupR(String value) {
        this.serupR = value;
    }

}
