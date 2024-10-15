//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.10.16 at 12:46:28 AM WIB 
//


package com.polstat.perpustakaan.gen;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.polstat.perpustakaan.gen package. 
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

    private final static QName _GetBooksRequest_QNAME = new QName("http://www.polstat.com/perpustakaan/gen", "getBooksRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.polstat.perpustakaan.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateBookRequest }
     * 
     */
    public CreateBookRequest createCreateBookRequest() {
        return new CreateBookRequest();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link CreateBookResponse }
     * 
     */
    public CreateBookResponse createCreateBookResponse() {
        return new CreateBookResponse();
    }

    /**
     * Create an instance of {@link GetBooksResponse }
     * 
     */
    public GetBooksResponse createGetBooksResponse() {
        return new GetBooksResponse();
    }

    /**
     * Create an instance of {@link SearchBooksRequest }
     * 
     */
    public SearchBooksRequest createSearchBooksRequest() {
        return new SearchBooksRequest();
    }

    /**
     * Create an instance of {@link SearchBooksResponse }
     * 
     */
    public SearchBooksResponse createSearchBooksResponse() {
        return new SearchBooksResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.polstat.com/perpustakaan/gen", name = "getBooksRequest")
    public JAXBElement<Object> createGetBooksRequest(Object value) {
        return new JAXBElement<Object>(_GetBooksRequest_QNAME, Object.class, null, value);
    }

}
