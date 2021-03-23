package br.com.concrete.composekmmmoviesapp.androidApp.data.mapper

import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Genre
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie

class MoviesMapper {
    companion object {
        const val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
    }

//    fun mapMoviesDtoToMovie(
//        moviePage: MoviePageDto,
//        favoriteMovies: List<MovieResponse>,
//        genreDto: GenreDto
//    ): List<MovieResponse> {
//        return moviePage.movieItems.map { apiMovie ->
//            val movieGenres = apiMovie.genreIds.map { genreId ->
//                val genreApiDto = genreDto.genres.find { genreDto ->
//                    genreDto.id == genreId
//                }
//
//                if (genreApiDto != null) {
//                    Genre(genreApiDto.id, genreApiDto.name)
//                } else {
//                    null
//                }
//            }.filterNotNull()
//
//            MovieResponse(
//                id = apiMovie.id,
//                title = apiMovie.title,
//                imageUrl = "${imageBaseUrl}${apiMovie.backdropPath}",
//                genres = movieGenres,
//                overview = apiMovie.overview,
//                releaseYear = apiMovie.releaseDate.parseToDate()?.getYearFromDate() ?: -1,
//                isfavorite = favoriteMovies.any { it.id == apiMovie.id }
//            )
//        }
//    }

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
