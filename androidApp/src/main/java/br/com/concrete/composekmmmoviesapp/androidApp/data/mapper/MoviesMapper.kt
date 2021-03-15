package br.com.concrete.composekmmmoviesapp.androidApp.data.mapper

import br.com.concrete.composekmmmoviesapp.androidApp.data.apidto.GenreDto
import br.com.concrete.composekmmmoviesapp.androidApp.data.apidto.MoviePageDto
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Genre
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie
import br.com.concrete.composekmmmoviesapp.androidApp.util.getYearFromDate
import br.com.concrete.composekmmmoviesapp.androidApp.util.parseToDate

class MoviesMapper {
    companion object {
        const val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
    }

    fun mapMoviesDtoToMovie(
        moviePage: MoviePageDto,
        favoriteMovies: List<Movie>,
        genreDto: GenreDto
    ): List<Movie> {
        return moviePage.movieItems.map { apiMovie ->
            val movieGenres = apiMovie.genreIds.map { genreId ->
                val genreApiDto = genreDto.genres.find { genreDto ->
                    genreDto.id == genreId
                }

                if (genreApiDto != null) {
                    Genre(genreApiDto.id, genreApiDto.name)
                } else {
                    null
                }
            }.filterNotNull()

            Movie(
                id = apiMovie.id,
                title = apiMovie.title,
                imageUrl = "${imageBaseUrl}${apiMovie.backdropPath}",
                genres = movieGenres,
                overview = apiMovie.overview,
                releaseYear = apiMovie.releaseDate.parseToDate()?.getYearFromDate() ?: -1,
                isfavorite = favoriteMovies.any { it.id == apiMovie.id }
            )
        }
    }
}
