package br.com.concrete.composekmmmoviesapp.androidApp.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_MOVIE = "FavoriteMovie"

@Entity(tableName = TABLE_NAME_MOVIE)
data class FavoriteMovieDbEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "release_year") val releaseYear: Int,
    @ColumnInfo(name = "genres") val genres: String
)