package br.com.alura.alugames.main

import br.com.alura.alugames.models.Game
import br.com.alura.alugames.models.Players

fun main() {
    val gamer1 = Players("Ariovaldo", "Ariovaldo.com")
    println(gamer1)
    val gamer2 = Players(
        "Arioldo",
        "Arioldo.com",
        "29/29/2092",
        "aroldao"
    )
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "01/01/1991"
        it.usuario = "Arioldin"
    }.also {
        println(gamer1)
    }

    gamer2.let {
        it.usuario = "MenoAroudo"
    }.also { println(gamer2) }

}