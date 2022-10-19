package reader

import model.CasosHospProvres
import java.io.File

/**
 * @author Daniel Rodriguez Muñoz - Email: daniel.ro.mu02@gmail.com
 */
object CSVReader {
    fun readCSVs(): Set<CasosHospProvres> {
        val list1 = readCSVCasosHospUciDefSexoEdadProvres()
        val list2 = readCSVHospUciDefSexoEdadProvresTodasEdades()
        val result = mutableSetOf<CasosHospProvres>()
        result.addAll(list1)
        result.addAll(list2)
        return result.toSet()
    }

    fun readCSVCasosHospUciDefSexoEdadProvres(): List<CasosHospProvres> {
        val results = mutableListOf<CasosHospProvres>()
        val csv = File("${System.getProperty("user.dir")}${File.separator}data${File.separator}casos_hosp_uci_def_sexo_edad_provres.csv")
        val lines = csv.readLines().drop(1)

        lines.forEach {
            val arguments = it.split(",")
            val caso = CasosHospProvres(
                provinciaISO = arguments[0],
                sex = arguments[1],
                grupoEdad = arguments[2],
                fecha = arguments[3],
                numCasos = arguments[4].toInt(),
                numHosp = arguments[5].toInt(),
                numUci = arguments[6].toInt(),
                numDef = arguments[7].toInt()
            )
            results.add(caso)
        }
        return results.toList()
    }

    fun readCSVHospUciDefSexoEdadProvresTodasEdades(): List<CasosHospProvres> {
        val results = mutableListOf<CasosHospProvres>()
        val csv = File("${System.getProperty("user.dir")}${File.separator}data${File.separator}hosp_uci_def_sexo_edad_provres_todas_edades.csv")
        val lines = csv.readLines().drop(1)

        lines.forEach {
            val arguments = it.split(",")
            val caso = CasosHospProvres(
                provinciaISO = arguments[0],
                sex = arguments[1],
                grupoEdad = arguments[2],
                fecha = arguments[3],
                numCasos = 0,
                numHosp = arguments[4].toInt(),
                numUci = arguments[5].toInt(),
                numDef = arguments[6].toInt()
            )
            results.add(caso)
        }
        return results.toList()
    }
}