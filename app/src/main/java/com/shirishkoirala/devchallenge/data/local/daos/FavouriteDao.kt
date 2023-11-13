package com.shirishkoirala.devchallenge.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shirishkoirala.devchallenge.data.local.entities.FavouriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favouriteEntity: FavouriteEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(favorites: List<FavouriteEntity>)

    @Delete
    suspend fun delete(favourite: FavouriteEntity)

    @Update
    suspend fun update(favourite: FavouriteEntity)

    @Query("SELECT * FROM favourites WHERE movieId = :movieId")
    fun getFavourite(movieId: Int): Flow<FavouriteEntity?>
}