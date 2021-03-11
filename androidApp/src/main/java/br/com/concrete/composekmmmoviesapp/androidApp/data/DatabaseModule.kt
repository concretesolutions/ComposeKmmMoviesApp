package br.com.concrete.composekmmmoviesapp.androidApp.data

import androidx.room.Room
import br.com.concrete.composekmmmoviesapp.androidApp.data.db.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "moviesdb-database")
            .build()
    }
    factory {
        get<AppDatabase>().favoriteMoviesDao()
    }
}