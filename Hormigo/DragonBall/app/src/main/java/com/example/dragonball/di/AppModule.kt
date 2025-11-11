package com.example.dragonball.di

import com.example.dragonball.data.remote.DragonBallDataSource
import com.example.dragonball.data.repository.DragonBallRepository
import com.example.dragonball.data.repository.DragonBallRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun dragonBallRemoteDataSource(ds: DragonBallDataSource): DragonBallDataSource
    @Singleton
    @Binds
    abstract fun bindDragonBallRepository(repository: DragonBallRepositoryImpl): DragonBallRepository
}