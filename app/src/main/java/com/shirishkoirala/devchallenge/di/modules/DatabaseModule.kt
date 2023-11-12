package com.shirishkoirala.devchallenge.di.modules;

import android.content.Context
import androidx.room.Room
import com.shirishkoirala.devchallenge.data.local.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun movieDatabase(@ApplicationContext applicationContext: Context): MovieDatabase {
        return Room.databaseBuilder(
            applicationContext,
            MovieDatabase::class.java,
            "database"
        ).build()
    }

}
