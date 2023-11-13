package com.shirishkoirala.devchallenge.data.local.daos

import androidx.room.Dao
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

    @Query("DELETE FROM favourites WHERE movieId=:movieId")
    suspend fun delete(movieId: Int)

    @Update
    suspend fun update(favourite: FavouriteEntity)

    @Query("SELECT * FROM favourites WHERE movieId = :movieId")
    fun getFavourite(movieId: Int): Flow<FavouriteEntity?>
}