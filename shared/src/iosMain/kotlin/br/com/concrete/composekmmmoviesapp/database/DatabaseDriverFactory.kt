package br.com.concrete.composekmmmoviesapp.database

import br.com.concrete.composekmmmoviesapp.cache.AppDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "movies.db")
    }
}
