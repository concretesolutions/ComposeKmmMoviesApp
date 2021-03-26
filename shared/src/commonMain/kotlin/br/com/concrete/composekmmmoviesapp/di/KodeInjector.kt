package br.com.concrete.composekmmmoviesapp.di

import br.com.concrete.composekmmmoviesapp.database.GenreDao
import br.com.concrete.composekmmmoviesapp.database.MovieDao
import br.com.concrete.composekmmmoviesapp.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.network.GenreApi
import br.com.concrete.composekmmmoviesapp.network.MovieApi
import br.com.concrete.composekmmmoviesapp.network.SearchMovieApi
import br.com.concrete.composekmmmoviesapp.repository.GenreRepository
import br.com.concrete.composekmmmoviesapp.repository.MovieRepository
import br.com.concrete.composekmmmoviesapp.repository.SearchMovieRepository
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import org.kodein.di.*
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val di = DI {

//    bind<DataDriverManager>() with provider { DataDriverManager() }

    bind<MovieApi>() with provider { MovieApi(instance()) }

    bind<GenreApi>() with provider { GenreApi(instance()) }

    bind<SearchMovieApi>() with provider { SearchMovieApi(instance()) }

    bind<MovieRepository>() with factory { movieDao: MovieDao ->
        MovieRepository(
            instance(),
            movieDao,
            instance(),
            instance()
        )
    }

    bind<MovieDao>() with singleton { MovieDao(instance()) }

    bind<GenreDao>() with factory { dataDriverManager: DataDriverManager ->
        GenreDao(
            dataDriverManager
        )
    }

    bind<GenreRepository>() with factory { genreDao: GenreDao ->
        GenreRepository(
            instance(),
            genreDao
        )
    }

    bind<SearchMovieRepository>() with singleton { SearchMovieRepository(instance()) }

    bind<MoviesMapper>() with provider { MoviesMapper() }

    bind<HttpClient>() with provider {
        HttpClient {
            install(JsonFeature) {
                val json: Json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
        }
    }
}


