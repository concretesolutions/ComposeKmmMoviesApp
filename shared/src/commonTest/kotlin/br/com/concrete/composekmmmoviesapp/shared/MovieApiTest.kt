package br.com.concrete.composekmmmoviesapp.shared

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.domain.Movie
import br.com.concrete.composekmmmoviesapp.domain.MoviesResponse
import br.com.concrete.composekmmmoviesapp.network.MovieApi
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class MovieApiTest {

    @Test
    fun when_movies_succeeds_returns_expected_members() = runTest {

        val testResponseString = """
        {"page":1,"results":[{"id":"527774","poster_path": "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg","genre_ids":[16,12,14,10751,28],"original_title":"Raya and the Last Dragon","overview":"Long ago","release_date":"2021-03-03"}]}
        """.trimIndent()

        val mockEngine = MockEngine {
            respond(
                testResponseString,
                HttpStatusCode.OK,
                headersOf("Content-Type", ContentType.Application.Json.toString())
            )
        }

        val httpClient = HttpClient(mockEngine) {
            install(JsonFeature) {
                val json: Json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
        }

        val expectedMembers = MoviesResponse(
            1,
            listOf(
                Movie(
                    527774,
                    "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                    "Raya and the Last Dragon",
                    listOf(16, 12, 14, 10751, 28),
                    "2021-03-03",
                    "Long ago"
                )
            )
        )

        val movieApi = MovieApi(httpClient)

        // WHEN
        val actualMembers = movieApi.getMovies(1)

        // THEN
        assertEquals(expectedMembers, (actualMembers as Response.Success).data)
    }
}
