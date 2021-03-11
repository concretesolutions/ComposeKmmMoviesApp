package br.com.concrete.composekmmmoviesapp.database

import br.com.concrete.composekmmmoviesapp.cache.AppDatabase
import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie

class MovieDao(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {

        }
    }

    fun getAllFavoriteMovies(): List<FavoriteMovie> {
        return dbQuery.selectAllMovies(::mapMovieSelecting).executeAsList()
    }

    fun insertFavoriteMovie(favoriteMovie: FavoriteMovie) {
        dbQuery.insertMovie(
            id = favoriteMovie.id,
            posterPath = favoriteMovie.posterPath,
            originalTitle = favoriteMovie.originalTitle,
            releaseYear = favoriteMovie.releaseYear,
            genres = favoriteMovie.genres,
            overview = favoriteMovie.overview
        )
    }

    fun removeFavoriteMovie(idMovie: Long) {
        dbQuery.removeMovie(idMovie)
    }
}