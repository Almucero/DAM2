package com.gamesage.marvel.di

import com.gamesage.marvel.data.CharacterDataSource
import com.gamesage.marvel.data.local.CharacterLocalDataSource
import com.gamesage.marvel.data.remote.CharacterRemoteDataSource
import com.gamesage.marvel.data.repository.CharacterRepository
import com.gamesage.marvel.data.repository.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Singleton
    @Binds
    @RemoteDataSource
    abstract fun bindsRemoteCharacterDataSource(ds: CharacterRemoteDataSource): CharacterDataSource

    @Singleton
    @Binds
    @LocalDataSource
    abstract fun bindsLocalCharacterDataSource(ds: CharacterLocalDataSource): CharacterDataSource

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(repository: CharacterRepositoryImpl): CharacterRepository
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalDataSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDataSource