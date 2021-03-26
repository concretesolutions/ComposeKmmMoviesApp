package br.com.concrete.composekmmmoviesapp.database

import br.com.concrete.composekmmmoviesapp.cache.AppDatabase
import br.com.concrete.composekmmmoviesapp.di.DataDriverManager
import br.com.concrete.composekmmmoviesapp.domain.FavoriteMovie

class MovieDao(dataDriverManager: DataDriverManager) {
    private val database = AppDatabase(dataDriverManager.databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
        }
    }

    fun getAllFavoriteMovies(): List<FavoriteMovie> {
        return dbQuery.selectAllMovies(::mapMovieSelecting).executeAsList()
    }

    fun insertFavoriteMovie(favoriteMovie: FavoriteMovie) {
        if (dbQuery.selectMovieById(favoriteMovie.id).executeAsOneOrNull() == null) {
            dbQuery.insertMovie(
                id = favoriteMovie.id,
                posterPath = favoriteMovie.posterPath,
                originalTitle = favoriteMovie.originalTitle,
                releaseYear = favoriteMovie.releaseYear,
                genres = favoriteMovie.genres,
                overview = favoriteMovie.overview
            )
        }
    }

    fun removeFavoriteMovie(idMovie: Long) {
        dbQuery.removeMovie(idMovie)
    }
}
