package com.shirishkoirala.devchallenge.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shirishkoirala.devchallenge.data.local.entities.GenreEntity

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(genre: GenreEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(genres: List<GenreEntity>)

    @Delete
    suspend fun delete(genre: GenreEntity)

    @Query("Select * from genres order by id ASC")
    fun getGenres(): LiveData<List<GenreEntity>>

    @Update
    suspend fun update(genre: GenreEntity)

    @Query("SELECT * FROM genres WHERE id IN (:genreIds)")
    suspend fun getGenres(genreIds: ArrayList<Int>): List<GenreEntity>?

}