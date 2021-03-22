package br.com.concrete.composekmmmoviesapp.database

import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie

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
