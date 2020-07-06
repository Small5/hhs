
package com.smates.dbc2.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.smates.dbc2.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetData_QNAME = new QName("http://service.hhs.com/", "getData");
    private final static QName _GetDataResponse_QNAME = new QName("http://service.hhs.com/", "getDataResponse");
    private final static QName _GetDataYearly_QNAME = new QName("http://service.hhs.com/", "getDataYearly");
    private final static QName _GetDataYearlyResponse_QNAME = new QName("http://service.hhs.com/", "getDataYearlyResponse");
    private final static QName _QueryAvailable_QNAME = new QName("http://service.hhs.com/", "queryAvailable");
    private final static QName _QueryAvailableResponse_QNAME = new QName("http://service.hhs.com/", "queryAvailableResponse");
    private final static QName _QueryState_QNAME = new QName("http://service.hhs.com/", "queryState");
    private final static QName _QueryStateResponse_QNAME = new QName("http://service.hhs.com/", "queryStateResponse");
    private final static QName _Start_QNAME = new QName("http://service.hhs.com/", "start");
    private final static QName _StartResponse_QNAME = new QName("http://service.hhs.com/", "startResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.smates.dbc2.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetData }
     * 
     */
    public GetData createGetData() {
        return new GetData();
    }

    /**
     * Create an instance of {@link GetDataResponse }
     * 
     */
    public GetDataResponse createGetDataResponse() {
        return new GetDataResponse();
    }

    /**
     * Create an instance of {@link GetDataYearly }
     * 
     */
    public GetDataYearly createGetDataYearly() {
        return new GetDataYearly();
    }

    /**
     * Create an instance of {@link GetDataYearlyResponse }
     * 
     */
    public GetDataYearlyResponse createGetDataYearlyResponse() {
        return new GetDataYearlyResponse();
    }

    /**
     * Create an instance of {@link QueryAvailable }
     * 
     */
    public QueryAvailable createQueryAvailable() {
        return new QueryAvailable();
    }

    /**
     * Create an instance of {@link QueryAvailableResponse }
     * 
     */
    public QueryAvailableResponse createQueryAvailableResponse() {
        return new QueryAvailableResponse();
    }

    /**
     * Create an instance of {@link QueryState }
     * 
     */
    public QueryState createQueryState() {
        return new QueryState();
    }

    /**
     * Create an instance of {@link QueryStateResponse }
     * 
     */
    public QueryStateResponse createQueryStateResponse() {
        return new QueryStateResponse();
    }

    /**
     * Create an instance of {@link Start }
     * 
     */
    public Start createStart() {
        return new Start();
    }

    /**
     * Create an instance of {@link StartResponse }
     * 
     */
    public StartResponse createStartResponse() {
        return new StartResponse();
    }

    /**
     * Create an instance of {@link DoubleArray }
     * 
     */
    public DoubleArray createDoubleArray() {
        return new DoubleArray();
    }

    /**
     * Create an instance of {@link DoubleArrayArray }
     * 
     */
    public DoubleArrayArray createDoubleArrayArray() {
        return new DoubleArrayArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "getData")
    public JAXBElement<GetData> createGetData(GetData value) {
        return new JAXBElement<GetData>(_GetData_QNAME, GetData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "getDataResponse")
    public JAXBElement<GetDataResponse> createGetDataResponse(GetDataResponse value) {
        return new JAXBElement<GetDataResponse>(_GetDataResponse_QNAME, GetDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataYearly }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "getDataYearly")
    public JAXBElement<GetDataYearly> createGetDataYearly(GetDataYearly value) {
        return new JAXBElement<GetDataYearly>(_GetDataYearly_QNAME, GetDataYearly.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataYearlyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "getDataYearlyResponse")
    public JAXBElement<GetDataYearlyResponse> createGetDataYearlyResponse(GetDataYearlyResponse value) {
        return new JAXBElement<GetDataYearlyResponse>(_GetDataYearlyResponse_QNAME, GetDataYearlyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAvailable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "queryAvailable")
    public JAXBElement<QueryAvailable> createQueryAvailable(QueryAvailable value) {
        return new JAXBElement<QueryAvailable>(_QueryAvailable_QNAME, QueryAvailable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryAvailableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "queryAvailableResponse")
    public JAXBElement<QueryAvailableResponse> createQueryAvailableResponse(QueryAvailableResponse value) {
        return new JAXBElement<QueryAvailableResponse>(_QueryAvailableResponse_QNAME, QueryAvailableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "queryState")
    public JAXBElement<QueryState> createQueryState(QueryState value) {
        return new JAXBElement<QueryState>(_QueryState_QNAME, QueryState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryStateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "queryStateResponse")
    public JAXBElement<QueryStateResponse> createQueryStateResponse(QueryStateResponse value) {
        return new JAXBElement<QueryStateResponse>(_QueryStateResponse_QNAME, QueryStateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Start }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "start")
    public JAXBElement<Start> createStart(Start value) {
        return new JAXBElement<Start>(_Start_QNAME, Start.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.hhs.com/", name = "startResponse")
    public JAXBElement<StartResponse> createStartResponse(StartResponse value) {
        return new JAXBElement<StartResponse>(_StartResponse_QNAME, StartResponse.class, null, value);
    }

}
