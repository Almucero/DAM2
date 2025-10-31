package com.example.lazyapp.di

import com.example.lazyapp.data.repository.ChampionInMemoryRepository
import com.example.lazyapp.data.repository.ChampionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindPokemonRepository(repository: ChampionInMemoryRepository): ChampionRepository
}