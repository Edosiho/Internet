
package ClienteWS_BusquedaVideosWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarVideosTituloResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarVideosTituloResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RespuestaBusquedaVideosTitulo" type="{http://webServices/}video" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarVideosTituloResponse", propOrder = {
    "respuestaBusquedaVideosTitulo"
})
public class BuscarVideosTituloResponse {

    @XmlElement(name = "RespuestaBusquedaVideosTitulo")
    protected List<Video> respuestaBusquedaVideosTitulo;

    /**
     * Gets the value of the respuestaBusquedaVideosTitulo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the respuestaBusquedaVideosTitulo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRespuestaBusquedaVideosTitulo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Video }
     * 
     * 
     */
    public List<Video> getRespuestaBusquedaVideosTitulo() {
        if (respuestaBusquedaVideosTitulo == null) {
            respuestaBusquedaVideosTitulo = new ArrayList<Video>();
        }
        return this.respuestaBusquedaVideosTitulo;
    }

}
