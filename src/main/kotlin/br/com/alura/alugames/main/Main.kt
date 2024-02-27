package br.com.alura.alugames.main

import br.com.alura.alugames.models.Game
import br.com.alura.alugames.services.ConsumoApi
import java.util.*


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Digite um Game:")
    val search = scanner.nextLine()

    val searchApi = ConsumoApi()
    val infoSearch = searchApi.searchGame(search)


    var myGame: Game? = null

    val result = runCatching {
        myGame = Game(
            infoSearch!!.info.title,
            infoSearch.info.thumb
        )
    }

    result.onFailure{
        println("Game não encontrado! Digite outro pfv.")
    }
    result.onSuccess {
        println("Deseja inserir uma descrição personalizada? \nS/N:")
        val option = scanner.nextLine()
        if (option.equals("s",true)){
            println("Insira a descrição que gostaria:")
            val descriptionPerson = scanner.nextLine()
            myGame?.descripton = descriptionPerson
        }else{
            myGame?.descripton = myGame?.title
        }

        println(myGame)
    }


}