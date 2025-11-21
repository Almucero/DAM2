package com.example.dragonball.di

import com.example.dragonball.data.remote.DragonBallApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Provides
    @Singleton
    fun provideDragonBallApi(): DragonBallApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.dragonball-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(DragonBallApi::class.java)
    }

    @Provides
    fun provideCoroutineScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.Default)
    }
}