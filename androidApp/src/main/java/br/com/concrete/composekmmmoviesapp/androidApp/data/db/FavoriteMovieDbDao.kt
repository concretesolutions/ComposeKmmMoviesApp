package br.com.concrete.composekmmmoviesapp.androidApp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteMovieDbDao {
    @Query("SELECT * FROM FavoriteMovie")
    suspend fun getFavoriteMovies(): List<FavoriteMovieDbEntity>

    @Insert
    suspend fun insertFavorite(movie: FavoriteMovieDbEntity)

    @Delete
    suspend fun deleteFavorite(movie: FavoriteMovieDbEntity)
}