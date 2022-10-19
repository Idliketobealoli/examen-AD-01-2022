import exporter.Exporter
import model.Ejecucion
import processor.CSVProcessor
import reader.CSVReader
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * @author Daniel Rodriguez Muñoz - Email: daniel.ro.mu02@gmail.com
 */
fun main(args: Array<String>) {
    val inicioPrograma: Long = System.currentTimeMillis()
    val dateInicio = LocalDate.now()
    /*
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

     */

    val casos = CSVReader.readCSVs()
    casos.forEach { println(it.toString()) }

    val processor = CSVProcessor(casos)
    processor.ejercicio2()

    val dtf = DateTimeFormatter.ISO_DATE
    val ejecucionActual = Ejecucion(
        (System.currentTimeMillis() - inicioPrograma),
        dtf.format(dateInicio).toString(),
        dtf.format(LocalDate.now()).toString()
    )

    Exporter.save(ejecucionActual)
}