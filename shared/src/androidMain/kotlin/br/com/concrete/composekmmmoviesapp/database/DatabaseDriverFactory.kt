package br.com.concrete.composekmmmoviesapp.database

import android.content.Context
import br.com.concrete.composekmmmoviesapp.cache.AppDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context, "movies.db")
    }
}
