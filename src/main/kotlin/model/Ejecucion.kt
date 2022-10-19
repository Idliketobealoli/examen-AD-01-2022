package model

import java.util.*
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

/**
 * @author Daniel Rodriguez Muñoz - Email: daniel.ro.mu02@gmail.com
 */
@XmlRootElement(name="ejecucion_datos")
@XmlAccessorType(XmlAccessType.FIELD)
class Ejecucion() {
    constructor(executionTime: Long, fechaInicio: String, fechaFin: String): this() {
        this.executionTime = executionTime
        this.fechaInicio = fechaInicio
        this.fechaFin = fechaFin
    }

    @XmlAttribute(name = "uuid")
    val id = UUID.randomUUID()
    @XmlAttribute(name = "execution_time_millis")
    var executionTime: Long = 0
    var fechaInicio: String = ""
    var fechaFin: String = ""
}