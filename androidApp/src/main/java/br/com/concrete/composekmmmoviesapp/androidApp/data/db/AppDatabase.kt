package br.com.concrete.composekmmmoviesapp.androidApp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteMovieDbEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteMoviesDao(): FavoriteMovieDbDao
}