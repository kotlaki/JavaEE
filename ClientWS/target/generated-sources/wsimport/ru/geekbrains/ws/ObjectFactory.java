
package ru.geekbrains.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.geekbrains.ws package. 
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

    private final static QName _GetProduct_QNAME = new QName("http://ws.geekbrains.ru/", "getProduct");
    private final static QName _GetProductResponse_QNAME = new QName("http://ws.geekbrains.ru/", "getProductResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.geekbrains.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProduct }
     * 
     */
    public GetProduct createGetProduct() {
        return new GetProduct();
    }

    /**
     * Create an instance of {@link GetProductResponse }
     * 
     */
    public GetProductResponse createGetProductResponse() {
        return new GetProductResponse();
    }

    /**
     * Create an instance of {@link ProductServiceWs }
     * 
     */
    public ProductServiceWs createProductServiceWs() {
        return new ProductServiceWs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduct }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetProduct }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.geekbrains.ru/", name = "getProduct")
    public JAXBElement<GetProduct> createGetProduct(GetProduct value) {
        return new JAXBElement<GetProduct>(_GetProduct_QNAME, GetProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetProductResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.geekbrains.ru/", name = "getProductResponse")
    public JAXBElement<GetProductResponse> createGetProductResponse(GetProductResponse value) {
        return new JAXBElement<GetProductResponse>(_GetProductResponse_QNAME, GetProductResponse.class, null, value);
    }

}
