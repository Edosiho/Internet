
package ClienteWS_BusquedaVideosWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarVideosTitulo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarVideosTitulo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tituloVideo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarVideosTitulo", propOrder = {
    "tituloVideo"
})
public class BuscarVideosTitulo {

    protected String tituloVideo;

    /**
     * Gets the value of the tituloVideo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTituloVideo() {
        return tituloVideo;
    }

    /**
     * Sets the value of the tituloVideo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTituloVideo(String value) {
        this.tituloVideo = value;
    }

}
