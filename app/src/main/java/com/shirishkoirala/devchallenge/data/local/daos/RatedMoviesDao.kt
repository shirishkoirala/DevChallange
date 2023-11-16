package com.shirishkoirala.devchallenge.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.shirishkoirala.devchallenge.data.local.entities.RatedMoviesEntity

@Dao
interface RatedMoviesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(favorites: List<RatedMoviesEntity>)
}