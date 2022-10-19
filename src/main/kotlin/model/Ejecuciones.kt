package model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement

/**
 * @author Daniel Rodriguez Muñoz - Email: daniel.ro.mu02@gmail.com
 */

@XmlRootElement(name="ejecuciones")
@XmlAccessorType(XmlAccessType.FIELD)
class Ejecuciones() {
    @XmlElementWrapper(name = "ejecuciones_list")
    val ejecuciones : MutableList<Ejecucion> = mutableListOf()
}