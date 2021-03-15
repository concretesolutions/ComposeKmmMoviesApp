package br.com.concrete.composekmmmoviesapp.androidApp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavoriteMovieDbDao {
    @Query("SELECT * FROM FavoriteMovie")
    fun getFavoriteMoviesLiveData(): LiveData<List<FavoriteMovieDbEntity>>

    @Query("SELECT * FROM FavoriteMovie")
    suspend fun getFavoriteMovies(): List<FavoriteMovieDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(movie: FavoriteMovieDbEntity)

    @Delete
    suspend fun deleteFavorite(movie: FavoriteMovieDbEntity)
}