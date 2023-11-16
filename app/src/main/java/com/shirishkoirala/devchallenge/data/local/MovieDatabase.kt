package com.shirishkoirala.devchallenge.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shirishkoirala.devchallenge.data.local.daos.FavouriteDao
import com.shirishkoirala.devchallenge.data.local.daos.GenreDao
import com.shirishkoirala.devchallenge.data.local.daos.RatedMoviesDao
import com.shirishkoirala.devchallenge.data.local.entities.FavouriteEntity
import com.shirishkoirala.devchallenge.data.local.entities.GenreEntity
import com.shirishkoirala.devchallenge.data.local.entities.RatedMoviesEntity

@Database(
    entities = [GenreEntity::class, FavouriteEntity::class, RatedMoviesEntity::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getGenreDao(): GenreDao
    abstract fun getFavouriteDao(): FavouriteDao

    abstract fun getRatedMoviesDao(): RatedMoviesDao
}