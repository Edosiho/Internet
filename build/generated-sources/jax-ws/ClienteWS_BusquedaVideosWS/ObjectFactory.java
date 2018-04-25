
package ClienteWS_BusquedaVideosWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ClienteWS_BusquedaVideosWS package. 
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

    private final static QName _BuscarVideosAnioResponse_QNAME = new QName("http://webServices/", "buscarVideosAnioResponse");
    private final static QName _BuscarVideosAutor_QNAME = new QName("http://webServices/", "buscarVideosAutor");
    private final static QName _BuscarVideosAutorResponse_QNAME = new QName("http://webServices/", "buscarVideosAutorResponse");
    private final static QName _BuscarVideosTitulo_QNAME = new QName("http://webServices/", "buscarVideosTitulo");
    private final static QName _BuscarVideosTituloResponse_QNAME = new QName("http://webServices/", "buscarVideosTituloResponse");
    private final static QName _BuscarVideosAnio_QNAME = new QName("http://webServices/", "buscarVideosAnio");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ClienteWS_BusquedaVideosWS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuscarVideosTituloResponse }
     * 
     */
    public BuscarVideosTituloResponse createBuscarVideosTituloResponse() {
        return new BuscarVideosTituloResponse();
    }

    /**
     * Create an instance of {@link BuscarVideosAnio }
     * 
     */
    public BuscarVideosAnio createBuscarVideosAnio() {
        return new BuscarVideosAnio();
    }

    /**
     * Create an instance of {@link BuscarVideosAutorResponse }
     * 
     */
    public BuscarVideosAutorResponse createBuscarVideosAutorResponse() {
        return new BuscarVideosAutorResponse();
    }

    /**
     * Create an instance of {@link BuscarVideosTitulo }
     * 
     */
    public BuscarVideosTitulo createBuscarVideosTitulo() {
        return new BuscarVideosTitulo();
    }

    /**
     * Create an instance of {@link BuscarVideosAnioResponse }
     * 
     */
    public BuscarVideosAnioResponse createBuscarVideosAnioResponse() {
        return new BuscarVideosAnioResponse();
    }

    /**
     * Create an instance of {@link BuscarVideosAutor }
     * 
     */
    public BuscarVideosAutor createBuscarVideosAutor() {
        return new BuscarVideosAutor();
    }

    /**
     * Create an instance of {@link Video }
     * 
     */
    public Video createVideo() {
        return new Video();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarVideosAnioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "buscarVideosAnioResponse")
    public JAXBElement<BuscarVideosAnioResponse> createBuscarVideosAnioResponse(BuscarVideosAnioResponse value) {
        return new JAXBElement<BuscarVideosAnioResponse>(_BuscarVideosAnioResponse_QNAME, BuscarVideosAnioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarVideosAutor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "buscarVideosAutor")
    public JAXBElement<BuscarVideosAutor> createBuscarVideosAutor(BuscarVideosAutor value) {
        return new JAXBElement<BuscarVideosAutor>(_BuscarVideosAutor_QNAME, BuscarVideosAutor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarVideosAutorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "buscarVideosAutorResponse")
    public JAXBElement<BuscarVideosAutorResponse> createBuscarVideosAutorResponse(BuscarVideosAutorResponse value) {
        return new JAXBElement<BuscarVideosAutorResponse>(_BuscarVideosAutorResponse_QNAME, BuscarVideosAutorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarVideosTitulo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "buscarVideosTitulo")
    public JAXBElement<BuscarVideosTitulo> createBuscarVideosTitulo(BuscarVideosTitulo value) {
        return new JAXBElement<BuscarVideosTitulo>(_BuscarVideosTitulo_QNAME, BuscarVideosTitulo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarVideosTituloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "buscarVideosTituloResponse")
    public JAXBElement<BuscarVideosTituloResponse> createBuscarVideosTituloResponse(BuscarVideosTituloResponse value) {
        return new JAXBElement<BuscarVideosTituloResponse>(_BuscarVideosTituloResponse_QNAME, BuscarVideosTituloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarVideosAnio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "buscarVideosAnio")
    public JAXBElement<BuscarVideosAnio> createBuscarVideosAnio(BuscarVideosAnio value) {
        return new JAXBElement<BuscarVideosAnio>(_BuscarVideosAnio_QNAME, BuscarVideosAnio.class, null, value);
    }

}
