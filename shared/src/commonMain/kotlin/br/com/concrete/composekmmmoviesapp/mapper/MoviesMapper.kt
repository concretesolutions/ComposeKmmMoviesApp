package br.com.concrete.composekmmmoviesapp.mapper

import br.com.concrete.composekmmmoviesapp.domain.*

class MoviesMapper {
    companion object {
        const val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
    }

    fun mapMoviesDtoToMovie(
        moviePage: MoviesResponse = MoviesResponse(0, listOf()),
        favoriteMovies: List<FavoriteMovie>,
        genresResponse: GenresResponse
    ): List<Movie> {
        return moviePage.results.map { apiMovie ->
            val movieGenres = apiMovie.genres.map { genreId ->
                val genreApiDto = genresResponse.genres.find { genreDto ->
                    genreDto.id == genreId.toLong()
                }

                if (genreApiDto != null) {
                    Genre(genreApiDto.id.toInt(), genreApiDto.name)
                } else {
                    null
                }
            }.filterNotNull()

            Movie(
                id = apiMovie.id,
                title = apiMovie.originalTitle,
                imageUrl = "${imageBaseUrl}${apiMovie.posterPath}",
                genres = movieGenres,
                overview = apiMovie.overview,
//                releaseYear = apiMovie.releaseDate.parseToDate()?.getYearFromDate() ?: -1,
                releaseYear = 2021,
                isfavorite = favoriteMovies.any { it.id == apiMovie.id.toLong() }
            )
        }
    }

    fun mapFavoriteDtoToMovie(
        favoriteMovies: List<FavoriteMovie>,
        genresResponse: GenresResponse
    ): List<Movie> {
        return favoriteMovies.map { favoriteMovie ->
            val movieGenres = favoriteMovie.genres.map { genreId ->
                val genreApiDto = genresResponse.genres.find { genreDto ->
                    genreDto.id == genreId.toLong()
                }

                if (genreApiDto != null) {
                    Genre(genreApiDto.id.toInt(), genreApiDto.name)
                } else {
                    null
                }
            }.filterNotNull()

            Movie(
                id = favoriteMovie.id.toInt(),
                title = favoriteMovie.originalTitle,
                imageUrl = favoriteMovie.posterPath,
                genres = movieGenres,
                overview = favoriteMovie.overview ?: "",
//                releaseYear = apiMovie.releaseDate.parseToDate()?.getYearFromDate() ?: -1,
                releaseYear = 2021,
                isfavorite = true
            )
        }
    }
}