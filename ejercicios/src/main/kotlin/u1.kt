package main.kotlin


fun u1Ej4() {
    print("Introduzca una temperatura en grados Celsius: ")
    val entrada = readln().trim()
    try {
        val temp = entrada.toDouble()
        println("La temperatura en grados Fahrenheit es ${convertirGrados(temp)} grados Fahrenheit")
    } catch (e: NumberFormatException) {
        println("Error, número no válido")
    }
}


fun convertirGrados(celsius: Double) = (celsius * 9 / 5) +32


fun u1Ej6() {
    var todoOk = false

    do {
        try {
            print("Introduzca el importe final de un artículo: ")
            val importe = readln().trim().toFloat()

            val iva = importe * 0.1
            val precioSinIVA = importe * 0.9

            println("Ha pagado %.2f€ de IVA, el precio del artículo sin IVA es %.2f€".format(iva, precioSinIVA))
            todoOk = true
        } catch (e: NumberFormatException) {
            println("Error, no ha introducido un número.")
        }
    } while (!todoOk)
}


fun u1Ej12() {
    var todoOk = false

    do {
        try {
            print("Introduzca su peso en kg: ")
            val peso = readln().trim().toFloat()

            print("Introduzca su estatura en metros: ")
            val estatura = readln().trim().toFloat()

            val iMC = peso / (estatura * estatura)

            val formattedIMC = String.format("%.2f", iMC)

            println("Tu índice de masa corporal es $formattedIMC")

            todoOk = true
        } catch (e: NumberFormatException) {
            println("Error, por favor introduce solo números.")
        }
    } while (!todoOk)
}


fun u1Ej15() {
    var todoOk = false

    do {
        try {
            print("Introduzca el importe final de un artículo: ")
            val importe = readln().trim().toFloat()

            val iva = importe * 0.1
            val precioSinIVA = importe * 0.9

            println("Ha pagado %.2f€ de IVA, el precio del artículo sin IVA es %.2f€".format(iva, precioSinIVA))
            todoOk = true
        } catch (e: NumberFormatException) {
            println("Error, no ha introducido un número.")
        }
    } while (!todoOk)
}


fun capitalizarFrase(frase: String): String {

    val fraseList = frase.split(" ").toMutableList()
    for (index in fraseList.indices) {
        fraseList[index] = fraseList[index].replaceFirstChar { it.uppercase() }
    }
    val fraseCapitalizada = fraseList.joinToString(" ")

    return fraseCapitalizada
}


fun u1Ej18() {
    print("Introduzca su nombre completo: ")
    val nombre: String = readln().trim().lowercase()
    println(nombre)
    println(nombre.uppercase())
    println(capitalizarFrase(nombre))
}


fun esNumerico(string: String): Boolean {
    return try {
        string.toDouble()
        true
    } catch (e: NumberFormatException) {
        false
    }
}


fun u1Ej20() {

    print("Ingrese un número de teléfono con el formato +34-XXXXXXXXX-XX: ")
    val telefono: String = readln()

    if (telefono.length == 16 && telefono.substring(0,4) == "+34-" && esNumerico(telefono.substring(4,13)) && telefono[13] == '-' && esNumerico(telefono.substring(14))) {
        println("Número sin prefijo y extensión: ${telefono.substring(4, 13)}")

    } else {
        println("El formato del número no es válido.")
    }
}


fun u1Ej21() {

    print("Ingrese una frase que quiera ver invertida: ")
    val frase: String = readln().reversed()

    println("La frase invertida es: ")
    print(frase)
}


fun u1Ej22() {

    print("Introduzca una frase: ")
    val frase = readln()
    var todoOk = false

    var vocal: String
    do {
        print("Introduzca una vocal: ")
        vocal = readln().lowercase()
        if (vocal in setOf("a", "e", "i", "o", "u")) {
            todoOk = true
        } else {
            println("Error, no has introducido una vocal.")
        }
    } while (!todoOk)

    val fraseModificada = frase.replace(vocal, vocal.uppercase())
    println("La frase introducida con la vocal '$vocal' en mayúsculas es: $fraseModificada")
}


fun u1Ej24() {

    print("Introduzca el precio de un producto en euros con dos decimales: ")
    val precio = readln().trim()

    try {
        val precioDecimal = precio.toDouble()
        val precioTruncado = String.format("%.2f", precioDecimal)
        val precioList = precioTruncado.split(".", ",")

        println("El precio introducido tiene ${precioList[0]} euros y ${precioList[1]} céntimos.")
    } catch (e: NumberFormatException) {
        println("Error, no ha introducido un número decimal.")
    }
}


fun esEntero(string: String): Boolean {
    return try {
        string.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}


fun u1Ej25() {

    var todoOk = false
    var fechaLista: List<String>

    do {
        print("Introduzca la fecha de su nacimiento en formato dd/mm/aaaa: ")
        fechaLista = readln().trim().split("/")
        if (fechaLista.size != 3) {
            println("Error, por favor introduce la fecha en formato dd/mm/aaaa.")
        } else {
            if (!esEntero(fechaLista[0]) || fechaLista[0].toInt()!in 1..31) {
                println("Error, el dia introducido no es un número entero entre 1 y 31")
            } else if (!esEntero(fechaLista[1]) || fechaLista[1].toInt()!in 1..12) {
                println("Error, el mes introducido no es un número entero entre 1 y 12")
            } else if (!esEntero(fechaLista[2]) || fechaLista[2].toInt()!in 1..9999) {
                println("Error, el año introducido no es un número entero entre 1 y 9999")
            } else {
                todoOk = true
            }
        }
    } while (!todoOk)

    println("Usted nació el día %02d del mes %02d del año %04d.".format(fechaLista[0].toInt(), fechaLista[1].toInt(), fechaLista[2].toInt()))
}


fun u1Ej26() {

    print("Introduzca los productos de su cesta de la compra, separados por comas: ")
    val compraLista = readln().trim().split(",")

    println("Los elementos de tu lista de la compra son:")
    for (elemento in compraLista) {
        println("- ${ elemento.trim().replaceFirstChar { it.uppercase() } }")
    }
}



fun u1Ej27() {
    var productoPrecio: String
    var productoUnidades: String

    print("Introduzca el nombre de un producto: ")
    val productoNombre = readln().trim()

    do {
        print("Introduzca el precio del producto: ")
        productoPrecio = readln().trim()
    } while (!esNumerico(productoPrecio))

    do {
        print("Introduzca el número de unidades del producto: ")
        productoUnidades = readln().trim()
    } while (!esEntero(productoUnidades))

    println("El pedido del producto $productoNombre con un precio por unidad de %09.2f€ y un total de %03d unidades costará %011.2f€.".format(productoPrecio.toDouble(), productoUnidades.toInt(), (productoPrecio.toDouble() * productoUnidades.toInt())))
}
