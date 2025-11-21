package com.example.dragonball.data

import com.example.dragonball.data.model.Character
import com.example.dragonball.data.model.Planet
import com.example.dragonball.data.model.Transformation
import kotlinx.coroutines.flow.Flow

interface DragonBallDataSource {
    //Characters
    suspend fun readAllCharacters(): Result<List<Character>>
    suspend fun readOneCharacter(id: Long): Result<Character>
    suspend fun addAllCharacters(characterList: List<Character>)
    fun observeCharacters(): Flow<Result<List<Character>>>

    //Planets
    suspend fun readAllPlanets(): Result<List<Planet>>
    suspend fun readOnePlanet(id: Long): Result<Planet>
    suspend fun addAllPlanets(planetList: List<Planet>)
    fun observePlanets(): Flow<Result<List<Planet>>>

    //Transformation
    suspend fun readAllTransformation(): Result<List<Transformation>>
    suspend fun readOneTransformation(id: Long): Result<Transformation>
    suspend fun addAllTransformations(transformationList: List<Transformation>)
    fun observeTransformations(): Flow<Result<List<Transformation>>>

    suspend fun isError()
}