import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Digite um Game:")
    val search = scanner.nextLine()

    val uriGame = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(uriGame))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()
    val myInfoGame = gson.fromJson(json, InfoGame::class.java)


    val result = runCatching {
        val myGame = Game(
            myInfoGame.info.title,
            myInfoGame.info.thumb)

        println(myGame)
    }

    result.onFailure{
        println("Game não encontrado! Digite outro pfv.")
    }
}