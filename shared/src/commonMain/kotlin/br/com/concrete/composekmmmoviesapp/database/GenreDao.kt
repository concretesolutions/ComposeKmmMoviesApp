package br.com.concrete.composekmmmoviesapp.database

import br.com.concrete.composekmmmoviesapp.cache.AppDatabase
import br.com.concrete.composekmmmoviesapp.di.DataDriverManager
import br.com.concrete.composekmmmoviesapp.domain.GenreResponse
import br.com.concrete.composekmmmoviesapp.domain.GenresResponse

class GenreDao(dataDriverManager: DataDriverManager) {
    private val database = AppDatabase(dataDriverManager.databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    fun getAllGenres(): List<GenreResponse> {
        return try {
            dbQuery.selectAllGenres(::mapGenreSelecting).executeAsList()
        } catch (ex: Throwable) {
            listOf()
        }
    }

    fun getGenreById(id: Long): GenreResponse? {
        return dbQuery.selectGenreById(id, ::mapGenreSelecting).executeAsOneOrNull()
    }

    fun insertGenres(genresResponse: GenresResponse) {
        insertGenres(genresResponse.genres)
    }

    fun insertGenres(genreResponses: List<GenreResponse>) {
        for (genre in genreResponses) {
            insertGenre(genre)
        }
    }

    fun insertGenre(genreResponse: GenreResponse) {
        if (dbQuery.selectGenreById(genreResponse.id).executeAsOneOrNull() == null) {
            dbQuery.insertGenre(
                id = genreResponse.id,
                name = genreResponse.name
            )
        }
    }

    fun removeAllGenres() {
        dbQuery.removeAllGenres()
    }
}