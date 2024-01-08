package main.kotlin

fun main() {

    var op: Int

    do {

        limpiaConsola()
        mostrarMenuPpal()
        op = pedirOpcion(0, 3)

        if (op != 0) {
            mostrarMenu(op)
        }

    } while (op != 0)

}


fun mostrarMenuPpal() {
    println("1. Ejercicios U1")
    println("2. Ejercicios U2")
    println("3. Ejercicios U3")
}

fun mostrarMenu(tipo: Int) {
    var op = -1

    do {
        limpiaConsola()
        when (tipo) {
            1 -> {
                println("01. Ejercicio 04")
                println("02. Ejercicio 06")
                println("03. Ejercicio 12")
                println("04. Ejercicio 15")
                println("05. Ejercicio 18")
                println("06. Ejercicio 20")
                println("07. Ejercicio 21")
                println("08. Ejercicio 22")
                println("09. Ejercicio 24")
                println("10. Ejercicio 25")
                println("11. Ejercicio 26")
                println("12. Ejercicio 27")

                op = pedirOpcion(0, 12)
                when (op) {
                    1 -> u1Ej4()
                    2 -> u1Ej6()
                    3 -> u1Ej12()
                    4 -> u1Ej15()
                    5 -> u1Ej18()
                    6 -> u1Ej20()
                    7 -> u1Ej21()
                    8 -> u1Ej22()
                    9 -> u1Ej24()
                    10 -> u1Ej25()
                    11 -> u1Ej26()
                    12 -> u1Ej27()
                }

                if (op in 1..12) {
                    pulsaTeclaParaContinuar()
                }
            }

            2 -> {
                println("01. EjCondicion 02")
                println("02. EjCondicion 03")
                println("03. EjCondicion 06")
                println("04. EjCondicion 08")
                println("05. EjCondicion 10")
                println("06. EjIterativa 02")
                println("07. EjIterativa 04")
                println("08. EjIterativa 06")
                println("09. EjIterativa 07")
                println("10. EjIterativa 08")
                println("11. EjIterativa 13")
                println("12. EjIterativa 15")
                println("13. EjIterativa 18")
                println("14. EjIterativa 19")
                println("15. EjIterativa 25")
                println("16. EjExcepcion 02")
                println("17. EjExcepcion 03")
                println("18. EjExcepcion 04")

                op = pedirOpcion(0, 18)
                when (op) {
                    1 -> u2EjCon2()
                    2 -> u2EjCon3()
                    3 -> u2EjCon6()
                    4 -> u2EjCon8()
                    5 -> u2EjCon10()
                    6 -> u2EjIte2()
                    7 -> u2EjIte4()
                    8 -> u2EjIte6()
                    9 -> u2EjIte7()
                    10 -> u2EjIte8()
                    11 -> u2EjIte13()
                    12 -> u2EjIte15()
                    13 -> u2EjIte18()
                    14 -> u2EjIte19()
                    15 -> u2EjIte25()
                    16 -> u2EjExc2()
                    17 -> u2EjExc3()
                    18 -> u2EjExc4()
                }

                if (op in 1..18) {
                    pulsaTeclaParaContinuar()
                }
            }

            3 -> {
                println("01. EjListas 04")
                println("02. EjListas 06")
                println("03. EjListas 08")
                println("04. EjListas 09")
                println("05. EjListas 10")
                println("06. EjListas 13")
                println("07. EjDiccionarios 03")
                println("08. EjDiccionarios 05")
                println("09. EjDiccionarios 06")
                println("10. EjDiccionarios 07")
                println("11. EjDiccionarios 08")
                println("12. EjDiccionarios 10")
                println("13. EjDiccionarios 11")
                println("14. EjConjuntos 01")
                println("15. EjConjuntos 02")
                println("16. EjConjuntos 03")
                println("17. EjConjuntos 04")
                println("18. EjConjuntos 05")
                println("19. EjConjuntos 06")

                op = pedirOpcion(0, 19)
                when (op) {
                    1 -> u3EjListas04()
                    2 -> u3EjListas06()
                    3 -> u3EjListas08()
                    4 -> u3EjListas09()
                    5 -> u3EjListas10()
                    6 -> u3EjListas13()
                    7 -> u3EjDiccionarios03()
                    8 -> u3EjDiccionarios05()
                    9 -> u3EjDiccionarios06()
                    10 -> u3EjDiccionarios07()
                    11 -> u3EjDiccionarios08()
                    12 -> u3EjDiccionarios10()
                    13 -> u3EjDiccionarios11()
                    14 -> u3EjConjuntos01()
                    15 -> u3EjConjuntos02()
                    16 -> u3EjConjuntos03()
                    17 -> u3EjConjuntos04()
                    18 -> u3EjConjuntos05()
                    19 -> u3EjConjuntos06()
                }
                if (op in 1..19) {
                    pulsaTeclaParaContinuar()
                }
            }
        }
    } while (op != 0)

}

/**
 * Pedir una opción del menú
 * @param min Opción mínima
 * @param max Opción máxima
 */
fun pedirOpcion(min: Int, max: Int): Int {

    var opcion: Int
    var error = false

    do {
        print("Seleccione opción (0 = SALIR) >> ")
        opcion = try {
            readln().toInt()
        } catch (ex: NumberFormatException) {
            error = true
            -1
        }

        if (error || opcion !in min..max) {
            mensajeError(1)
            error = false
        }
    } while (opcion !in min..max)

    return opcion
}

fun mensajeError(id: Int) {
    when (id) {
        1 -> println("**Opción no válida**")
        else -> {
            println("**Error desconocido**")
        }
    }
}

fun limpiaConsola() {
    for (i in 1..20) {
        println()
    }
}

fun pulsaTeclaParaContinuar() {
    println()
    print("Pulsa la tecla enter para continuar...")
    readlnOrNull()
}

