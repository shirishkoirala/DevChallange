package com.shirishkoirala.devchallenge.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genres")
data class GenreEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val genreId: Int,
    @ColumnInfo(name = "name") val genreName: String
)