
package ClienteWS_BusquedaVideosWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarVideosAutor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarVideosAutor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="autorVideo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarVideosAutor", propOrder = {
    "autorVideo"
})
public class BuscarVideosAutor {

    protected String autorVideo;

    /**
     * Gets the value of the autorVideo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutorVideo() {
        return autorVideo;
    }

    /**
     * Sets the value of the autorVideo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutorVideo(String value) {
        this.autorVideo = value;
    }

}
