package com.shirishkoirala.devchallenge.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shirishkoirala.devchallenge.data.local.daos.GenreDao
import com.shirishkoirala.devchallenge.data.local.entities.GenreEntity

@Database(entities = [GenreEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getGenreDao(): GenreDao
}