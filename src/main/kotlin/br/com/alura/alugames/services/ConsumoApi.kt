package br.com.alura.alugames.services

import br.com.alura.alugames.models.InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun searchGame(id:String):InfoGame?{
        val uriGame = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(uriGame))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()

        var myInfoGame: InfoGame? = null



        val resultInf = runCatching {
            myInfoGame = gson.fromJson(json, InfoGame::class.java)

        }
        resultInf.onFailure{
            println("Id informado inexistente. Tente outro id.")
            System.exit(1)
        }

        return myInfoGame
    }


}