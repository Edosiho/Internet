
package ClienteWS_BusquedaVideosWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarVideosAutorResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarVideosAutorResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RespuestaBusquedaVideosAutor" type="{http://webServices/}video" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarVideosAutorResponse", propOrder = {
    "respuestaBusquedaVideosAutor"
})
public class BuscarVideosAutorResponse {

    @XmlElement(name = "RespuestaBusquedaVideosAutor")
    protected List<Video> respuestaBusquedaVideosAutor;

    /**
     * Gets the value of the respuestaBusquedaVideosAutor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the respuestaBusquedaVideosAutor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRespuestaBusquedaVideosAutor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Video }
     * 
     * 
     */
    public List<Video> getRespuestaBusquedaVideosAutor() {
        if (respuestaBusquedaVideosAutor == null) {
            respuestaBusquedaVideosAutor = new ArrayList<Video>();
        }
        return this.respuestaBusquedaVideosAutor;
    }

}
