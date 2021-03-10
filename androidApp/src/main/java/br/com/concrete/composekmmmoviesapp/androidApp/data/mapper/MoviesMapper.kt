package br.com.concrete.composekmmmoviesapp.androidApp.data.mapper

import br.com.concrete.composekmmmoviesapp.androidApp.data.dto.MoviePage
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie

class MoviesMapper {
    companion object {
        const val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
    }

    fun mapMoviesDtoToMovie(moviePage: MoviePage): List<Movie> {
        return moviePage.movieItems.map { apiMovie ->
            Movie(
                title = apiMovie.title,
                imageUrl = "${imageBaseUrl}${apiMovie.backdropPath}"
            )
        }
    }
}
