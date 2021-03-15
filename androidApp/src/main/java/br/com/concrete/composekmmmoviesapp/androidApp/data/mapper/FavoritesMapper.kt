package br.com.concrete.composekmmmoviesapp.androidApp.data.mapper

import br.com.concrete.composekmmmoviesapp.androidApp.data.db.FavoriteMovieDbEntity
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Genre
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie

class FavoritesMapper {
    fun mapDbToMovies(favoriteMovies: List<FavoriteMovieDbEntity>): List<Movie> {
        return favoriteMovies.map { mapDbToMovie(it) }
    }

    fun mapDbToMovie(favoriteEntity: FavoriteMovieDbEntity): Movie{
        return Movie(
            id = favoriteEntity.id,
            title = favoriteEntity.title,
            imageUrl = favoriteEntity.imageUrl,
            genres = favoriteEntity.genres.split(",").map { Genre(1, it) },
            overview = favoriteEntity.overview,
            releaseYear = favoriteEntity.releaseYear,
            isfavorite = true
        )
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