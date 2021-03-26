package br.com.concrete.composekmmmoviesapp.androidApp.data.mapper

import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Genre
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie

class MoviesMapper {
    companion object {
        const val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
    }

    fun mapMovieToMoviesDTO(moviesSdk: List<br.com.concrete.composekmmmoviesapp.domain.Movie>): List<Movie> {
        return moviesSdk.map {
            Movie(
                id = it.id,
                imageUrl = it.imageUrl,
                title = it.title,
                overview = it.overview,
                releaseYear = it.releaseYear,
                genres = mapGenreToGenreDTO(it.genres),
                isfavorite = it.isfavorite
            )
        }
    }

    private fun mapGenreToGenreDTO(genreSdk: List<br.com.concrete.composekmmmoviesapp.domain.Genre>): List<Genre> {
        return genreSdk.map {
            Genre(
                id = it.id,
                name = it.name
            )
        }
    }
}
