package main.kotlin

import kotlin.math.sqrt

fun u3EjListas04() {

    val numerosLista: MutableList<Int> = mutableListOf()
    var numero: Int

    println("Introduzca los 6 número de la primitiva.")
    while (numerosLista.size != 6) {
        print("Número ${numerosLista.size + 1}. ")
        numero = pedirEntero(1,49)
        if (numero !in numerosLista) {
            numerosLista.add(numero)
        } else {
            println("Error, ya has seleccionado ese número.")
        }
    }
    numerosLista.sort()

    print("Los números que has seleccionado para tu primitiva son: ")
    for (i in (numerosLista.indices)) {
        print(" ${numerosLista[i]}")
        if (i != numerosLista.size - 1) {
            print(",")
        } else {
            print(".")
        }
    }
}


fun pedirDecimal(min: Double = -Double.MAX_VALUE, max: Double = Double.MAX_VALUE): Double {

    var numero = 1.0
    var todoOk = false

    do {
        try {
            numero = readln().trim().toDouble()

            if (numero < min) {
                throw NumberFormatException("")
            } else if (numero > max) {
                throw NumberFormatException("")
            } else {
                todoOk = true
            }
        } catch (e: NumberFormatException) {
            print("Error, el valor introducido no es válido. Intentalo otra vez: ")
        } catch (e: Exception) {
            println("Error desconocido: ${e.message}")
            print("Intentalo otra vez: ")
        }
    } while (!todoOk)

    return numero
}


fun u3EjListas06() {

    val asignaturasLista: MutableList<String> = mutableListOf("Matemáticas", "Física", "Química", "Historia", "Lengua")
    var nota: Double
    var contador = 0

    println("Introduzca su nota en las asignaturas siguientes.")
    while (contador < asignaturasLista.size) {
        print("${asignaturasLista[contador]}: ")
        nota = pedirDecimal(0.0, 10.0)

        if (nota >= 5.0) {
            asignaturasLista.removeAt(contador)
        } else {
            ++contador
        }
    }
    println("Has de repetir las siguientes asignaturas:")
    for (i in asignaturasLista) {
        println(i)
    }
}

fun u3EjListas08() {

    print("Introduzca una palabra: ")
    val palabra = readln().trim().lowercase()
    val palabraLista = palabra.split("")

    if (palabraLista == palabraLista.reversed()) {
        println("$palabra es palíndromo.")
    } else {
        println("$palabra no es palíndromo.")
    }
}

fun u3EjListas09() {

    print("Introduzca una palabra: ")
    val palabra = readln().trim().lowercase()
    val palabraLista = palabra.split("")
    var vocalA = 0
    var vocalE = 0
    var vocalI = 0
    var vocalO = 0
    var vocalU = 0

    for (i in palabraLista) {
        when (i.lowercase()) {
            "a" -> ++vocalA
            "e" -> ++vocalE
            "i" -> ++vocalI
            "o" -> ++vocalO
            "u" -> ++vocalU
        }
    }

    println("La palabra $palabra contiene:")
    println("- A: $vocalA veces.")
    println("- E: $vocalE veces.")
    println("- I: $vocalI veces.")
    println("- O: $vocalO veces.")
    println("- U: $vocalU veces.")
}

fun u3EjListas10() {

    val preciosLista = listOf(50, 75, 46, 22, 80, 65, 8)
    preciosLista.sorted()

    println("El menor de los precios es ${preciosLista.sorted()[0]} y el mayor es ${preciosLista.sorted()[preciosLista.size -1]}.")
}

fun u3EjListas13() {

    var todoOk: Boolean
    var listaInput: List<String>

    do {
        print("Introduzca una serie de números separados por comas: ")
        listaInput = readln().replace(" ", "").split(",")

        todoOk = true
        for (i in listaInput) {

            if (!esNumerico(i)) {
                todoOk = false
            }
        }

    } while (!todoOk)

    var media = 0.0
    var desviacion = 0.0

    for (i in listaInput) {
        media += i.toDouble()
    }
    media /= listaInput.size

    for (i in listaInput) {
        desviacion += ((i.toDouble() - media) * (i.toDouble() - media))
    }
    desviacion /= listaInput.size

    desviacion = sqrt(desviacion)

    println("La media de los números introducidos es %.2f y su desviación típica es %.2f".format(media, desviacion))
}

fun u3EjDiccionarios03() {

    val frutasMap = mapOf("platano" to	1.35, "manzana" to 0.80, "pera" to 0.85, "naranja" to 0.70)
    var fruta: String
    var kilos = 0.0
    var todoOk = false

    do {
        print("Introduzca el nombre de una fruta: ")
        fruta = readln().trim().lowercase()
        if (fruta in frutasMap) {

            print("Introduzca una cantidad de kg de fruta: ")
            kilos = pedirDecimal(0.0)
            todoOk = true
        } else {
            println("Error, esa fruta no esta en nuestro repertorio de frutas.")
        }
    } while (!todoOk)

    println("%.2f kg de $fruta cuestan %.2f€.".format(kilos, frutasMap[fruta]?.times(kilos)))
}

fun u3EjDiccionarios05() {

    val creditosMap = mapOf("Matemáticas" to 6, "Física" to 4, "Química" to 5)
    var creditosTotal = 0

    for ((key,value) in creditosMap) {
        println("$key tiene $value créditos.")
        creditosTotal += value
    }
    println("El curso tiene $creditosTotal créditos en total.")
}

fun pedirCadenaNoVacia(): String {

    var cadena = ""

    while (cadena == ""){
        cadena = readln().trim()
        if (cadena == "") {
            print("Error, no se permiten valores vacíos, intentelo otra vez: ")
        }
    }

    return cadena
}

fun pedirEnteroSinTexto(min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Int {

    var numero = 1
    var todoOk = false

    do {
        try {
            numero = readln().trim().toInt()

            if (numero < min) {
                throw NumberFormatException("")
            } else if (numero > max) {
                throw NumberFormatException("")
            } else {
                todoOk = true
            }
        } catch (e: NumberFormatException) {
            print("Error, el valor introducido no es válido. Intentelo otra vez: ")
        } catch (e: Exception) {
            println("Error desconocido: ${e.message}")
            print("Intentelo otra vez: ")
        }
    } while (!todoOk)

    return numero
}

fun u3EjDiccionarios06() {

    val datosMap = mutableMapOf<String, Any>()

    print("Introduzca su nombre: ")
    datosMap["Nombre"] = pedirCadenaNoVacia()
    for ((key, value) in datosMap){
        println("$key: $value")
    }
    print("Introduzca su edad: ")
    datosMap["Edad"] = pedirEnteroSinTexto(1, 130)
    for ((key, value) in datosMap){
        println("$key: $value")
    }
    print("Introduzca su sexo: ")
    datosMap["Sexo"] = pedirCadenaNoVacia()
    for ((key, value) in datosMap){
        println("$key: $value")
    }
    print("Introduzca su teléfono sin el prefijo: ")
    datosMap["Telefono"] = pedirEnteroSinTexto(100000000, 999999999)
    for ((key, value) in datosMap){
        println("$key: $value")
    }
    print("Introduzca su correo electrónico: ")
    datosMap["Correo"] = pedirCadenaNoVacia()
    for ((key, value) in datosMap){
        println("$key: $value")
    }
}

fun u3EjDiccionarios07() {

    var todoOk = false
    var articulo: String
    var compraTotal = 0.0
    val compraMap = mutableMapOf<String, Double>()
    println("Introduzca los elementos de su lista de la compra con su precio. Cuando haya terminado, introduzca 'salir'.")

    do {
        print("Introduzca un artículo: ")
        articulo = pedirCadenaNoVacia().lowercase().replaceFirstChar { it.uppercase() }

        if (articulo == "Salir") {
            todoOk = true
        } else {
            if (articulo !in  compraMap) {
                print("Introduzca el coste del artículo: ")
                compraMap[articulo] = pedirDecimal(0.0, 5000.0)
                compraTotal += compraMap[articulo]!!
            } else {
                println("Error, $articulo ya esta en su carrito de la compra.")
            }
        }
    } while (!todoOk)

    println("Lista de la compra")
    for ((key, value) in compraMap){
        println("$key $value€")
    }
    println("\nTotal $compraTotal€")
}

fun u3EjDiccionarios08() {
    val patron = """^\w+:\w+(,\w+:\w+)*$""".toRegex()
    var todoOk = false
    var traduccionString: String
    var traduccionLista: List<String> = emptyList()

    do {
        print("Introduzca palabras en español e inglés separadas por dos puntos, y cada par <palabra>:<traducción> separados por comas: ")
        traduccionString = readln().replace(" ", "")

        if (patron.matches(traduccionString)) {
            todoOk = true
            traduccionLista = traduccionString.split(",")
        } else {
            println("El formato introducido no coincide con lo que se te ha pedido.")
        }

    } while (!todoOk)

    val traduccionMap = mutableMapOf<String, String>()
    for (i in traduccionLista) {
        traduccionMap[i.split(":")[0]] = i.split(":")[1]
    }
    print("Introduzca una frase que quiere traducir: ")
    val fraseLista = readln().trim().split(" ")
    var fraseString = ""
    for (elemento in fraseLista){
        if (elemento in traduccionMap.keys) {
           fraseString += " ${traduccionMap[elemento]}"
        } else {
            fraseString += " $elemento"
        }
    }

    println(fraseString)
}

fun menuU3EjDiccionarios10(): Int {
    println("\n\n1. Añadir cliente.")
    println("2. Eliminar cliente.")
    println("3. Mostrar cliente.")
    println("4. Listar todos los clientes.")
    println("5. Listar clientes preferentes.")
    println("6. Terminar.")
    print("\nSeleccione una opción: ")

    return pedirOpcionSinTexto(1, 6)

}

fun pedirDNI(): String {
    val patron = """^\d{8}[A-Za-z]$""".toRegex()
    var dni: String
    var todoOk = false

    do {
        print("Introduzca el DNI (Ej: 12345678 A): ")
        dni= readln().replace(" ", "")

        if (patron.matches(dni)) {
            todoOk = true
        } else {
            println("Error, el dato que ha introducido no sigue el formato estandarizado del DNI español.")
        }
    } while (!todoOk)

    dni = dni.substring(0, dni.length - 1) + dni[dni.length - 1].uppercase()

    return dni
}

fun pedirPreferenteU3EjDiccionarios10(): Boolean {
    var todoOk = false
    var preferente: String
    var retorno = false

    do {
        print("Introduzca si el cliente es preferente (S/N): ")
        preferente = readln().trim().lowercase()

        if (preferente.substring(0, 1) != "s" && preferente.substring(0, 1) != "n") {
            println("Error, por favor Introduzca Si o No (S/N).")
        } else {
            todoOk = true
            if (preferente.substring(0, 1) == "s") {
                retorno = true
            }
        }
    } while (!todoOk)

    return retorno
}

fun u3EjDiccionarios10() {

    var opcion: Int
    val clientesMap = mutableMapOf<String, MutableMap<String, Any>>()
    var datosMap: MutableMap<String, Any>

    do {
        opcion = menuU3EjDiccionarios10()
        datosMap = mutableMapOf()

        when (opcion) {
            1 -> {
                print("Introduzca su nombre: ")
                datosMap["Nombre"] = pedirCadenaNoVacia()

                print("Introduzca su edad: ")
                datosMap["Edad"] = pedirEnteroSinTexto(1, 130)

                print("Introduzca su sexo: ")
                datosMap["Sexo"] = pedirCadenaNoVacia()

                print("Introduzca su teléfono sin el prefijo: ")
                datosMap["Telefono"] = pedirEnteroSinTexto(100000000, 999999999)

                print("Introduzca su correo electrónico: ")
                datosMap["Correo"] = pedirCadenaNoVacia()

                datosMap["Preferente"] = pedirPreferenteU3EjDiccionarios10()

                clientesMap[pedirDNI()] = datosMap


            }
            2 -> {
                print("Introduzca el siguiente dato sobre el cliente que desea eliminar.")
                val dni = pedirDNI()
                if (dni in clientesMap.keys) {
                    clientesMap.remove(dni)
                } else {
                    println("Lo sentimos pero el DNI que ha introducido no coincide con ninguno de los clientes de nuestra base de datos.")
                }
            }
            3 -> {
                print("Introduzca el siguiente dato sobre el cliente que desea mostrar.")
                val dni = pedirDNI()
                if (dni in clientesMap.keys) {
                    datosMap = clientesMap[dni]!!
                    for ((key, value) in datosMap) {
                        println("- $key: $value")
                    }
                } else {
                    println("Lo sentimos pero el DNI que ha introducido no coincide con ninguno de los clientes de nuestra base de datos.")
                }
            }
            4 -> {
                for (dni in clientesMap.keys) {
                    datosMap = clientesMap[dni]!!
                    println("- ${datosMap["Nombre"]} asociado al DNI $dni.")
                }
            }
            5 -> {
                for (dni in clientesMap.keys) {
                    datosMap = clientesMap[dni]!!
                    if (datosMap["Preferente"] == true) {
                        println("- ${datosMap["Nombre"]} asociado al DNI $dni.")
                    }
                }
            }
        }
    } while (opcion != 6)
}

fun u3EjDiccionarios11() {

    val datosLista = "nif;nombre;email;teléfono;descuento\n01234567L;Luis González;luisgonzalez@mail.com;656343576;12.5\n71476342J;Macarena Ramírez;macarena@mail.com;692839321;8\n63823376M;Juan José Martínez;juanjo@mail.com;664888233;5.2\n98376547F;Carmen Sánchez;carmen@mail.com;667677855;15.7".split("\n")
    val nombresDatosLista = datosLista[0].split(";")
    var datosClienteLista: List<String>
    val clientesMap = mutableMapOf<String, MutableMap<String, Any>>()
    var datosMap: MutableMap<String, Any>

    for (i in (1..< datosLista.size)) {
        datosMap = mutableMapOf()
        datosClienteLista = datosLista[i].split(";")
        for (j in (1..< nombresDatosLista.size)) {
            datosMap[nombresDatosLista[j]] = datosClienteLista[j]
        }
        clientesMap[datosClienteLista[0]] = datosMap
    }
    println(clientesMap)
    for (dni in clientesMap.keys) {
        datosMap = clientesMap[dni]!!
        println("\n- Cliente asociado al DNI $dni:")
        for ((key, value) in datosMap)
            println("  $key: $value.")
    }
}

fun u3EjConjuntos01() {

    val datosLista = listOf(
        listOf("Nuria Costa", 5, 12780.78, "Calle Las Flores 355"),
        listOf("Jorge Russo", 7, 699, "Mirasol 218"),
        listOf("Nuria Costa", 7, 532.90, "Calle Las Flores 355"),
        listOf("Julián Rodriguez", 12, 5715.99, "La Mancha 761"),
        listOf("Jorge Russo", 15, 958, "Mirasol 218")
    )
    val domicilios = mutableSetOf<String>()

    for (lista in datosLista) {
        domicilios.add(lista[3].toString())
    }

    println("$domicilios")
}

fun u3EjConjuntos02() {

    var todoOk = false
    val nombresPrimariaSet: MutableSet<String> = mutableSetOf()
    val nombresSecundariaSet: MutableSet<String> = mutableSetOf()
    var input: String

    println("Introduzca nombres de pila de los alumnos de primaria, cuando no quiera introducir más nombres introduzca 'x'.")
    do {
        print("Introduzca un nombre: ")
        input = pedirCadenaNoVacia().lowercase()

        if (input == "x") {
            todoOk = true
        } else {
            nombresPrimariaSet.add(input)
        }
    } while (!todoOk)

    todoOk = false

    println("Introduzca nombres de pila de los alumnos de secundaria, cuando no quiera introducir más nombres introduzca 'x'.")
    do {
        print("Introduzca un nombre: ")
        input = pedirCadenaNoVacia().lowercase()

        if (input == "x") {
            todoOk = true
        } else {
            nombresSecundariaSet.add(input)
        }
    } while (!todoOk)

    println("Estos son todos los nombres que hay entre los alumnos de primaria y secundaria: ${nombresPrimariaSet.union(nombresSecundariaSet)}")

    println("Estos son todos los nombres que se repiten entre primaria y secundaria: ${nombresPrimariaSet.intersect(nombresSecundariaSet)}")

    println("Estos son todos los nombres de primaria que no se repiten en secundaria: ${nombresPrimariaSet.subtract(nombresSecundariaSet)}")

    if (nombresPrimariaSet.all { it in nombresSecundariaSet }) {
        println("Todos los nombres de primaria están incluidos en secundaria.")
    } else {
        println("Todos los nombres de primaria NO están incluidos en secundaria.")
    }
}

/**
 * Genera la lista de todos los subconjuntos posibles de un conjunto
 * @param conjuntoOriginal: conjunto del que debemos realizar la lista del conjunto potencia
 *
 */
fun conjuntoPotencia(conjuntoOriginal: Set<Int>): MutableList<MutableSet<Int>> {

    val listaPotencia: MutableList<MutableSet<Int>> = mutableListOf(mutableSetOf())

    for (elemento in conjuntoOriginal) {
        val nuevosSubconjuntos: MutableList<MutableSet<Int>> = mutableListOf()

        for (subconjunto in listaPotencia) {

            //No puedo hacer val nuevoSubconjunto = subconjunto.toMutableSet().add(elemento) porque add devuelve un Booleano
            val nuevoSubconjunto = subconjunto.toMutableSet()
            nuevoSubconjunto.add(elemento)
            nuevosSubconjuntos.add(nuevoSubconjunto)

        }

        listaPotencia.addAll(nuevosSubconjuntos)
    }

    return listaPotencia
}

fun u3EjConjuntos03() {

    val conjuntoOriginal = setOf(6, 1, 4)
    val listaPotencia = conjuntoPotencia(conjuntoOriginal)
    println(listaPotencia)
}

fun u3EjConjuntos04() {

    val frutas1 = listOf("manzana", "pera", "naranja", "plátano", "uva")
    val frutas2 = listOf("manzana", "pera", "durazno", "sandía", "uva")

    val setFrutas1: MutableSet<String> = mutableSetOf()
    setFrutas1.addAll(frutas1)
    println("Frutas 1: $frutas1")

    val setFrutas2: MutableSet<String> = mutableSetOf()
    setFrutas2.addAll(frutas2)
    println("Frutas 2: $frutas2")

    val frutasComunes = setFrutas1.intersect(setFrutas2)
    println("Frutas comunes: $frutasComunes")

    val frutasSoloEnFrutas1 = setFrutas1.subtract(setFrutas2)
    println("Frutas en 1 que no están en 2: $frutasSoloEnFrutas1")

    val frutasSoloEnFrutas2 = setFrutas2.subtract(setFrutas1)
    println("Frutas en 2 que no están en 1: $frutasSoloEnFrutas2")

}

fun u3EjConjuntos05() {

    val numeros = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Números del conjunto: $numeros")

    val pares: MutableSet<Int> = mutableSetOf()
    for (numero in numeros) {
        if (numero % 2 == 0) {
            pares.add(numero)
        }
    }
    println("Números pares: $pares")

    val multiplosDeTres: MutableSet<Int> = mutableSetOf()
    for (numero in numeros) {
        if (numero % 3 == 0) {
            multiplosDeTres.add(numero)
        }
    }
    println("Números multiplo de tres: $multiplosDeTres")

    val paresYMultiplosDeTres = pares.intersect(multiplosDeTres)
    println("Números pares y multiplo de tres: $paresYMultiplosDeTres")
}

fun u3EjConjuntos06() {

    val vocales = setOf('a', 'e', 'i', 'o', 'u')
    println("Letras vocales: $vocales")

    val consonantes = ('a'..'z').toSet().subtract(vocales)
    println("Letras consonantes: $consonantes")

    val letrasComunes = vocales.intersect(consonantes)
    println("Estas son las letras comunes entre las vocales y las consonantes: $letrasComunes")
}
