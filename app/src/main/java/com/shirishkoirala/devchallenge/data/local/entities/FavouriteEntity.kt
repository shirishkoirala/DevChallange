package com.shirishkoirala.devchallenge.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "favourites", indices = [Index(value = ["movieId"], unique = true)])
data class FavouriteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val favouriteId: Int? = null,
    @ColumnInfo(name = "movieId") val movieId: Int?,
)