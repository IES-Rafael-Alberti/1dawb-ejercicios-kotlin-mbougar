package main.kotlin


fun u2EjCon2() {

    val contrasenia = "contraseña"

    print("Introduce la contraseña: ")
    val contraseniaIntento = readln().trim()

    if (contraseniaIntento.lowercase() == contrasenia) {
        println("La contraseña introducida coincide con la guardada en la base de datos.")
    } else{
        println("La contraseña introducida NO coincide con la guardada en la base de datos.")
    }
}

fun u2EjCon3() {

    var todoOk = false
    var salida= 1
    var dividendo = 1.0
    var divisor = 1.0

    do {
        try {
            print("Introduce un dividendo: ")
            dividendo = readln().trim().toDouble()

            print("Introduce un divisor: ")
            divisor = readln().trim().toDouble()

            if (divisor == 0.0){
                salida = 2
                todoOk = true
            } else {
                salida = 1
                todoOk = true
            }

        } catch (e: NumberFormatException) {
            println("Error, por favor introduce un número válido.")
        } catch (e: Exception) {
            println("Error desconocido: ${e.message}")
        }

    } while (!todoOk)

    if (salida == 1) {
        println("La división de los números $dividendo y $divisor es ${dividendo / divisor}.")
    } else {
        println("Error, este programa no es capaz de dividir entre 0.")
    }
}

fun u2EjCon6() {

    var nombre: String
    var todoOk = false
    var sexo: String
    var anteriorM = false
    do {
        print("Introduzca su nombre: ")
        nombre = readln().trim().lowercase()

        if (nombre.substring(0, 1) in ("a".."m")) {
            todoOk = true
            anteriorM = true
        } else if (nombre.substring(0, 1) in ("n".."z")) {
            todoOk = true
        } else {
            println("Error, por favor introduce un nombre que comience por una letra a-z.")
        }
    } while (!todoOk)

    todoOk = false
    do {
        print("Introduzca su sexo: ")
        sexo = readln().trim().lowercase()

        if (sexo.substring(0, 1) != "m" && sexo.substring(0, 1) != "h") {
            println("Error, por favor introduce un sexo válido Hombre(H) o Mujer(M).")
        } else {
            todoOk = true
        }
    } while (!todoOk)

    if (sexo.substring(0, 1) == "m") {
        if (anteriorM){
            println("Usted corresponde al grupo A.")
        } else {
            println("Usted corresponde al grupo B.")
        }
    } else {
        if (anteriorM){
            println("Usted corresponde al grupo B.")
        } else {
            println("Usted corresponde al grupo A.")
        }
    }
}

fun u2EjCon8() {

    var todoOk = false
    var puntuacion = 0.0
    do {
        try {
            print("Introduca la puntuación del usuario (0.0, 0.4 o 0.6+): ")
            puntuacion = readln().trim().toDouble()

            if (puntuacion != 0.0 && puntuacion != 0.4 && (puntuacion !in (0.6..1.0))) {
                throw NumberFormatException("")
            } else {
                todoOk = true
            }

        } catch (e: NumberFormatException) {
            println("Error, por favor introduzca un número válido (No se aceptan números mayores de 1.0).")

        } catch (e: Exception) {
            println("Error desconocido: ${e.message}")
        }

    } while (!todoOk)

    println("Su nivel de rendimiento es (%.2f), por tanto recibirá un bonus de (%.2f€).".format(puntuacion, puntuacion * 2400))
}

fun pedirOpcionSinTexto(min: Int, max: Int): Int {

    var opcion: Int
    var error = false

    do {
        opcion = try {
            readln().toInt()
        } catch (ex: NumberFormatException) {
            error = true
            -1
        }

        if (error || opcion !in min..max) {
            print("Error, introduce un número entero entre $min y $max: ")
            error = false
        }
    } while (opcion !in min..max)

    return opcion
}


fun u2EjCon10() {

    var todoOk = false
    var pizzaTipo: String

    do {
        print("Quiere una pizza vegetariana?: ")
        pizzaTipo = readln().trim().lowercase()

        if (pizzaTipo.substring(0, 1) != "s" && pizzaTipo.substring(0, 1) != "n") {
            println("Error, por favor responda Si o No (S/N).")
        } else {
            todoOk = true
        }
    } while (!todoOk)

    val op: Int
    var ingrediente = ""
    if (pizzaTipo.substring(0, 1) == "s") {
        println("Seleccione un ingrediente además de la mozzarella y el tomate que están en todas nuestras pizzas.")
        println("Ingredientes vegetarianos:")
        println("1 - > Pimiento.")
        println("2 - > Tofu.")
        print("Introduzca el número correspondiente al ingrediente deseado: ")

        op = pedirOpcionSinTexto(1, 2)
        when (op) {
            1 -> ingrediente = "pimiento"
            2 -> ingrediente = "tofu"
        }

        println("Su pizza vegetariana contiene mozzarella, tomate y $ingrediente.")

    } else {
        println("Seleccione un ingrediente además de la mozzarella y el tomate que están en todas nuestras pizzas.")
        println("Ingredientes no vegetarianos:")
        println("1 - > Peperoni.")
        println("2 - > Jamón.")
        println("3 - > Salmón.")
        print("Introduzca el número correspondiente al ingrediente deseado: ")

        op = pedirOpcionSinTexto(1, 2)
        when (op) {
            1 -> ingrediente = "peperoni"
            2 -> ingrediente = "jamón"
            3 -> ingrediente = "salmón"
        }

        println("Su pizza no vegetariana contiene mozzarella, tomate y $ingrediente.")

    }
}


fun pedirEntero(min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Int {

    var numero = 1
    var todoOk = false

    do {
        try {
            if (min == Int.MIN_VALUE && max == Int.MAX_VALUE){
                print("Introduzca un número entero: ")
            } else if (min == Int.MIN_VALUE){
                print("Introduzca un número entero menor o igual a $max: ")
            } else if (max == Int.MAX_VALUE){
                print("Introduzca un número entero mayor o igual a $min: ")
            } else {
                print("Introduzca un número entero entre $min y $max: ")
            }
            numero = readln().trim().toInt()

            if (numero < min) {
                throw NumberFormatException("")
            } else if (numero > max) {
                throw NumberFormatException("")
            } else {
                todoOk = true
            }
        } catch (e: NumberFormatException) {
            println("Error, el valor introducido no es un número entero o está fuera de rango.")
        } catch (e: Exception) {
            println("Error desconocido: ${e.message}")
        }
    } while (!todoOk)

    return numero
}


fun u2EjIte2() {

    val edad = pedirEntero(1)

    for (i in (0..edad)) {
        println("En el año ${2024 - edad - 1 + i} usted cumplió $i años.")
    }
}

fun u2EjIte4() {

    val numero = pedirEntero(0)

    print("Iniciando cuenta atras...")

    // No tengo claro si usar (numero downTo 0) sería mas eficiente
    for (i in (0..numero).reversed()) {
        print(" $i")
        if (i != 0){
            print(",")
        } else {
            print("... vaya, no ha sucedido nada.")
        }
    }
}

fun u2EjIte6() {

    val filas = pedirEntero(1)

    for (i in (1 .. filas)) {
        for (j in (1..i)) {
            print("*")
        }
        print("\n")
    }
}

fun u2EjIte7() {

    for (i in (1..10)) {

        println("\n* $i:")
        for (j in (1..10)){
            println("$i x $j = ${i*j}")
        }
    }
}

fun u2EjIte8() {

    val filas = pedirEntero(1)

    for (i in (1 .. filas step 2)) {
        for (j in (1..i step 2).reversed()) {
            print("$j ")
        }
        print("\n")
    }
}

fun u2EjIte13() {

    var todoOk = false
    var palabra: String

    println("El programa repetira todo lo que introduzca hasta que introduzca 'salir'.")
    do {
        print("> ")
        palabra = readln().trim()

        if (palabra.lowercase() == "salir") {
            todoOk = true
        } else {
            println(palabra)
        }
    } while (!todoOk)
}

fun u2EjIte15() {

    var todoOk = false
    var numero: Int
    var sumatorio = 0

    println("Introduce números enteros que quieras sumar, cuando no quieras sumar más números introduce 0.")
    do {
        numero = pedirEntero()

        if (numero == 0) {
            todoOk = true
        } else {
            sumatorio += numero
        }
    } while (!todoOk)

    println("La suma de todos los números introducidos es: $sumatorio.")
}


fun sumarNumero(numero: Int): Int {
    var suma = 0
    var numeroOperar = numero

    // Ponemos != 0 para que acepte numeros negativos
    while (numeroOperar != 0) {
        // El resto de la division de un número entre 10 es el último digito del número
        suma += numeroOperar % 10
        // Dividimos el numero entre 10, truncando los decimales y asi eliminando el último digito del número
        numeroOperar /= 10
    }

    // Si el número dado es negativo la suma de restos negativos será negativa, por tanto la hacemos positiva
    if (suma < 0) {
        suma *= -1
    }

    return suma
}


fun u2EjIte18() {

    var todoOk = false
    var numero: Int
    var numerosPares = 0
    var sumaDigitos: Int

    println("Introduce números enteros cuyos digitos quieras sumar, cuando no quieras sumar más números introduce -1.")
    do {
        numero = pedirEntero()

        if (numero == -1) {
            todoOk = true
        } else {
            sumaDigitos = sumarNumero(numero)
            println("La suma de sus dígitos es $sumaDigitos")
            if (numero % 2 == 0)
                numerosPares += 1
        }
    } while (!todoOk)

    println("En total has introducido $numerosPares números pares.")
}

fun u2EjIte19() {

    var todoOk = false
    var op: Int

    do {
        println("1- Comenzar programa.")
        println("2- Imprimir listado.")
        println("3- Finalizar programa.")
        print("\nSeleccione una opción: ")

        op = pedirOpcionSinTexto(1, 3)
        when (op) {
            1 -> println("Comenzando programa...")
            2 -> {
                println("Juan Pérez - Analista")
                println("Pedro Narigudo - Diseñador")
                println("Carlos Gómez - Programador")
                println("Alberto Robles - Programador")
                println("Miguel Sánchez - Gerente de Proyecto")
            }
            3 -> {
                todoOk = true
                println("Finalizando programa...")
            }
        }
    } while (!todoOk)
}

fun u2EjIte25() {

    print("Introduce una frase (serie de palabras separadas por espacios):\n> ")
    val frase = readln().trim().split(" ")
    var longitudPalabra = 0
    var palabraLarga = 0

    for (i in frase.indices) {
        if (frase[i].length > longitudPalabra) {
            longitudPalabra = frase[i].length
            palabraLarga = i
        }
    }

    println("La palabra más larga está en la posición número ${palabraLarga + 1}, con una longitud de $longitudPalabra caracteres. En total la frase tenía ${frase.size} palabras.")
}

fun u2EjExc2() {

    val numero = pedirEntero(1)

    print("Todos los números impares desde 1 hasta $numero son: ")
    for (i in (1..numero step 2)) {
        print(" $i")
        if (i != numero && i != (numero - 1)){
            print(",")
        } else {
            print(".")
        }
    }
}

fun u2EjExc3() {


    val numero = pedirEntero(1)

    print("Iniciando la cuenta atrás...  ")
    for (i in (0..numero).reversed()) {
        print(" $i")
        if (i != numero){
            print(",")
        } else {
            print(".")
        }
    }
}

fun u2EjExc4() {

    try {
        print("Introduzca un número entero: ")
        val numero = readln().trim().toInt()
        println("La entrada es correcta, $numero es un número entero.")
    } catch (e: NumberFormatException) {
        println("La entrada no es correcta: ${e.message}")
    } catch (e: Exception) {
        println("Error desconocido: ${e.message}")
    }
}