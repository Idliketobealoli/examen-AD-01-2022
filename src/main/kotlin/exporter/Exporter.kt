package exporter

import model.Ejecucion
import model.Ejecuciones
import java.io.File
import java.lang.Boolean
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Marshaller

/**
 * @author Daniel Rodriguez Muñoz - Email: daniel.ro.mu02@gmail.com
 */
object Exporter {
    private val PATH_TO_INFORME_XML = "${System.getProperty("user.dir")}${File.separator}informe${File.separator}informe.xml"

    @Throws(JAXBException::class)
    fun save(ejecucion: Ejecucion) {
        val directoryURI = "${System.getProperty("user.dir")}${File.separator}informe"
        val directory = File(directoryURI)
        if (!directory.exists()) {
            directory.mkdirs()
        }
        val file = File(PATH_TO_INFORME_XML)
        if (!file.exists()) {
            create(ejecucion)
        } else {
            val jaxbContext: JAXBContext = JAXBContext.newInstance(Ejecuciones::class.java)
            val unmarshaller = jaxbContext.createUnmarshaller()
            val ejecuciones: Ejecuciones = unmarshaller.unmarshal(File(PATH_TO_INFORME_XML)) as Ejecuciones
            var duplicate = false
            for (ejec in ejecuciones.ejecuciones) {
                if (ejec.id == ejecucion.id) {
                    duplicate = true
                }
            }
            if (!duplicate) {
                ejecuciones.ejecuciones.add(ejecucion)
            }
            export(ejecuciones)
        }
    }

    @Throws(JAXBException::class)
    private fun export(ejecuciones: Ejecuciones) {
        val jaxbContext: JAXBContext = JAXBContext.newInstance(Ejecuciones::class.java)
        val marshaller = jaxbContext.createMarshaller()
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE)
        marshaller.marshal(ejecuciones, File(PATH_TO_INFORME_XML))
    }

    @Throws(JAXBException::class)
    private fun create(ejecucion: Ejecucion) {
        val ejecuciones = Ejecuciones()
        ejecuciones.ejecuciones.add(ejecucion)
        export(ejecuciones)
    }
}
