package com.example.dragonball.data.remote

import com.example.dragonball.data.remote.model.CharacterListRemote
import com.example.dragonball.data.remote.model.CharacterRemote
import com.example.dragonball.data.remote.model.PlanetListRemote
import com.example.dragonball.data.remote.model.PlanetRemote
import com.example.dragonball.data.remote.model.TransformationListRemote
import com.example.dragonball.data.remote.model.TransformationRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DragonBallApi {
    //Characters
    @GET("/api/characters")
    suspend fun readAllCharacters(): Response<CharacterListRemote>
    @GET("/api/characters/{id}")
    suspend fun readOneCharacter(@Path("id") id: Long): Response<CharacterRemote>

    //Planets
    @GET("/api/planets")
    suspend fun readAllPlanets(): Response<PlanetListRemote>
    @GET("/api/planets/{id}")
    suspend fun readOnePlanet(@Path("id") id: Long): Response<PlanetRemote>
    
    //Transformations
    @GET("/api/transformations")
    suspend fun readAllTransformations(): Response<TransformationListRemote>
    @GET("/api/transformations/{id}")
    suspend fun readOneTransformation(@Path("id") id: Long): Response<TransformationRemote>
}