package br.com.concrete.composekmmmoviesapp.database

import br.com.concrete.composekmmmoviesapp.cache.AppDatabase
import br.com.concrete.composekmmmoviesapp.di.DataDriverManager
import br.com.concrete.composekmmmoviesapp.domain.Genre

class GenreDao(dataDriverManager: DataDriverManager) {
    private val database = AppDatabase(dataDriverManager.databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    fun getAllGenres(): List<Genre> {
        return dbQuery.selectAllGenres(::mapGenreSelecting).executeAsList()
    }

    fun getGenreById(id: Long): Genre? {
        return dbQuery.selectGenreById(id, ::mapGenreSelecting).executeAsOneOrNull()
    }

    fun insertGenres(genres: List<Genre>) {
        for (genre in genres) {
            insertGenre(genre)
        }
    }

    fun insertGenre(genre: Genre) {
        if (dbQuery.selectGenreById(genre.id).executeAsOneOrNull() == null) {
            dbQuery.insertGenre(
                id = genre.id,
                name = genre.name
            )
        }
    }

    fun removeAllGenres() {
        dbQuery.removeAllGenres()
    }
}