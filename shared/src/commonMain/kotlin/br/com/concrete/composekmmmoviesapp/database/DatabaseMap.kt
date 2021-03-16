package br.com.concrete.composekmmmoviesapp.database

import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie
import br.com.concrete.composekmmmoviesapp.domain.Genre

fun mapMovieSelecting(
    id: Long,
    posterPath: String,
    originalTitle: String,
    releaseYear: Int,
    genres: String,
    overview: String?
): FavoriteMovie {
    return FavoriteMovie(
        id = id,
        posterPath = posterPath,
        originalTitle = originalTitle,
        genres = genres,
        releaseYear = releaseYear,
        overview = overview
    )
}

fun mapGenreSelecting(
    id: Long,
    name: String
): Genre {
    return Genre(
        id = id,
        name = name,
    )
}
