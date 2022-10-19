- Autor: Daniel Rodriguez Muñoz - dam2
- Correo electronico: daniel.ro.mu02@gmail.com
- GitHub: https://github.com/Idliketobealoli
---
Explicacion del codigo:
- Clase Exporter:

Se encarga de exportar el objeto Ejecucion que le pasemos al unico metodo publico que 
tiene ( save(ejecucion) ) al archivo informe.xml ubicado en la carpeta /informe del proyecto. 
Si dicho objeto ejecucion ya existe en ese XML, entonces no lo añade; de lo contrario, lo añade.
Si la carpeta o el archivo no estan creados, los crea automaticamente.

- Clase Ejecuciones y Clase Ejecucion:

Son las clases sobre las que trabaja jaxb a la hora de crear el informe. Ejecuciones simplemente tiene una lista
 de Ejecucion, y Ejecucion tiene su id, tiempo que ha transcurrido desde que se inicio el programa, 
fecha de inicio del programa y fecha de fin del programa.

---
- Clase CSVReader:

Lee los dos csv y los convierte en una lista de objetos model.CasosHospProvres. 
Como uno de los dos csv no tiene el numero de casos como columna, al leer ese csv, setea a 0
 ese valor en el constructor de CasosHospProvres.

---
- Clase CSVProcessor:

Coge la lista de objetos pasada por el CSVReader y en el metodo ejercicio2() coge dicha lista, y la divivde en multiples listas, una por cada provincia.
Esas listas las agrupa en un set de listas, y luego por cada lista de ese set, hace la media, maximo y minimo de casos, 
hospitalizaciones, casos en uci y defunciones, y lo imprime por pantalla.
---

- Main: 

Primero anota la fecha actual (tanto en LocalDate como en milisegundos).

Luego llama a la clase CSVReader y por cada elemento de la lista que devuelve esa clase lo imprime por pantalla.

Tras esto, crea la clase CSVProcessor pasandole por constructor la lista que devolvio CSVReader y llama al metodo ejercicio2().

Una vez hecho esto, crea un objto Ejecucion pasandole como parametros el tiempo que ha pasado desde que inicio la ejecucion 
(restando los milisegundos actuales menos los que apunto al inicio del programa), la fecha de inicio 
en formato ISO-8601 y la fecha actual en el mismo formato. 

Tras esto, llama a la clase Exporter y guarda la ejecucion.