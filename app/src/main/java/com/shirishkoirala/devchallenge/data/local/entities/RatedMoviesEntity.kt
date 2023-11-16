package com.shirishkoirala.devchallenge.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "rated_movies", indices = [Index(value = ["movieId"], unique = true)])
class RatedMoviesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val ratedMoviesId: Int? = null,
    @ColumnInfo(name = "movieId") val movieId: Int?,
)