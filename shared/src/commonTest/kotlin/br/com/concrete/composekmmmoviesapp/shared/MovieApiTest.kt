package br.com.concrete.composekmmmoviesapp.shared

import br.com.concrete.composekmmmoviesapp.network.MovieApi
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlin.test.Test

class MovieApiTest {

    @Test
    fun when_movies_succeeds_returns_expected_members() = runTest {

        val testResponseString = """
        {"page":1,"results":[{"adult":false,"backdrop_path":"/hJuDvwzS0SPlsE6MNFOpznQltDZ.jpg","genre_ids":[16,12,14,10751,28],"id":527774,"original_language":"en","original_title":"Raya and the Last Dragon","overview":"Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.","popularity":4785.107,"poster_path":"/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg","release_date":"2021-03-03","title":"Raya and the Last Dragon","video":false,"vote_average":8.5,"vote_count":1216}],"total_pages":500,"total_results":10000}
        """.trimIndent()

        val mockEngine = MockEngine {
            respond(testResponseString,
                HttpStatusCode.OK,
                headersOf("Content-Type", ContentType.Application.Json.toString()))
        }

        val httpClient = HttpClient {
            install(JsonFeature) {
                val json: Json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
        }

        val movieApi = MovieApi(httpClient)
    }
}