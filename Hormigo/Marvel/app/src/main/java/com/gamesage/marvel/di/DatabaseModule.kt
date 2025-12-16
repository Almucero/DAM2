package com.gamesage.marvel.di

import android.content.Context
import androidx.room.Room
import com.gamesage.marvel.data.local.CharacterDao
import com.gamesage.marvel.data.local.MarvelDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext applicationContext: Context
    ): MarvelDatabase {
        val database = Room.databaseBuilder(
                context = applicationContext,
                klass = MarvelDatabase::class.java,
                name = "marvel-db"
            ).fallbackToDestructiveMigration(false).build()
        return database
    }
    @Provides
    fun providesCharacterDao(
        database: MarvelDatabase
    ): CharacterDao {
        return database.getCharacterDao()
    }
}