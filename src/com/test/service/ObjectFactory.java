
package com.test.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.test.service package. 
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

    private final static QName _GetData_QNAME = new QName("http://service.test.com/", "getData");
    private final static QName _GetDataResponse_QNAME = new QName("http://service.test.com/", "getDataResponse");
    private final static QName _ParseXML_QNAME = new QName("http://service.test.com/", "parseXML");
    private final static QName _ParseXMLResponse_QNAME = new QName("http://service.test.com/", "parseXMLResponse");
    private final static QName _TransferXML_QNAME = new QName("http://service.test.com/", "transferXML");
    private final static QName _TransferXMLResponse_QNAME = new QName("http://service.test.com/", "transferXMLResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.test.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetData_Type }
     * 
     */
    public GetData_Type createGetData_Type() {
        return new GetData_Type();
    }

    /**
     * Create an instance of {@link GetDataResponse }
     * 
     */
    public GetDataResponse createGetDataResponse() {
        return new GetDataResponse();
    }

    /**
     * Create an instance of {@link ParseXML }
     * 
     */
    public ParseXML createParseXML() {
        return new ParseXML();
    }

    /**
     * Create an instance of {@link ParseXMLResponse }
     * 
     */
    public ParseXMLResponse createParseXMLResponse() {
        return new ParseXMLResponse();
    }

    /**
     * Create an instance of {@link TransferXML }
     * 
     */
    public TransferXML createTransferXML() {
        return new TransferXML();
    }

    /**
     * Create an instance of {@link TransferXMLResponse }
     * 
     */
    public TransferXMLResponse createTransferXMLResponse() {
        return new TransferXMLResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetData_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.test.com/", name = "getData")
    public JAXBElement<GetData_Type> createGetData(GetData_Type value) {
        return new JAXBElement<GetData_Type>(_GetData_QNAME, GetData_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.test.com/", name = "getDataResponse")
    public JAXBElement<GetDataResponse> createGetDataResponse(GetDataResponse value) {
        return new JAXBElement<GetDataResponse>(_GetDataResponse_QNAME, GetDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseXML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.test.com/", name = "parseXML")
    public JAXBElement<ParseXML> createParseXML(ParseXML value) {
        return new JAXBElement<ParseXML>(_ParseXML_QNAME, ParseXML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.test.com/", name = "parseXMLResponse")
    public JAXBElement<ParseXMLResponse> createParseXMLResponse(ParseXMLResponse value) {
        return new JAXBElement<ParseXMLResponse>(_ParseXMLResponse_QNAME, ParseXMLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferXML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.test.com/", name = "transferXML")
    public JAXBElement<TransferXML> createTransferXML(TransferXML value) {
        return new JAXBElement<TransferXML>(_TransferXML_QNAME, TransferXML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.test.com/", name = "transferXMLResponse")
    public JAXBElement<TransferXMLResponse> createTransferXMLResponse(TransferXMLResponse value) {
        return new JAXBElement<TransferXMLResponse>(_TransferXMLResponse_QNAME, TransferXMLResponse.class, null, value);
    }

}
