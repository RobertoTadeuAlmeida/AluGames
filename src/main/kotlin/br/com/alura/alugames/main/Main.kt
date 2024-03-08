package br.com.alura.alugames.main

import br.com.alura.alugames.models.Game
import br.com.alura.alugames.models.Players
import br.com.alura.alugames.services.ConsumoApi
import java.util.*


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Digite um Game:")
    val search = scanner.nextLine()
    val player = Players.criaPlayer(scanner)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(player)

    do {

        val searchApi = ConsumoApi()
        val infoSearch = searchApi.searchGame(search)


        var myGame: Game? = null

        val result = runCatching {
            myGame = Game(
                infoSearch!!.info.title,
                infoSearch.info.thumb
            )
        }

        result.onFailure {
            println("Game não encontrado! Digite outro pfv.")
        }
        result.onSuccess {
            println("Deseja inserir uma descrição personalizada? \nS/N:")
            val option = scanner.nextLine()
            if (option.equals("s", true)) {
                println("Insira a descrição que gostaria:")
                val descriptionPerson = scanner.nextLine()
                myGame?.descripton = descriptionPerson
            } else {
                myGame?.descripton = myGame?.title
            }

            player.jogosBuscados.add(myGame)
        }
        println("Deseja buscar um novo jogo? S/N")
        val resposta = scanner.nextLine()

    } while (resposta.equals("s", true))
    println("Jogos buscados:")
    println(player.jogosBuscados)
    println("Busca finalizada com sucesso.")


}