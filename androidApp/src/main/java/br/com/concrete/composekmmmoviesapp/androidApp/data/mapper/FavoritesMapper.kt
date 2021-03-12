package br.com.concrete.composekmmmoviesapp.androidApp.data.mapper

import br.com.concrete.composekmmmoviesapp.androidApp.data.db.FavoriteMovieDbEntity
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Genre
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie

class FavoritesMapper {
    fun mapDbToMovies(favoriteMovies: List<FavoriteMovieDbEntity>): List<Movie> {
        return favoriteMovies.map {
            Movie(
                id = it.id,
                title = it.title,
                imageUrl = it.imageUrl,
                genres = it.genres.split(",").map { Genre(1, it) },
                overview = it.overview,
                releaseYear = it.releaseYear
            )
        }
    }

    fun mapMovieToDbEntity(movie: Movie): FavoriteMovieDbEntity {
        return FavoriteMovieDbEntity(
            id = movie.id,
            overview = movie.overview,
            title = movie.title,
            imageUrl = movie.imageUrl,
            releaseYear = movie.releaseYear,
            genres = movie.genres.joinToString { it.name }

        )
    }

}