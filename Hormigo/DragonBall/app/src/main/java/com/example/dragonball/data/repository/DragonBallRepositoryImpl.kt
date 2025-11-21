package com.example.dragonball.data.repository

import com.example.dragonball.data.model.Character
import com.example.dragonball.data.model.Planet
import com.example.dragonball.data.model.Transformation
import com.example.dragonball.data.DragonBallDataSource
import com.example.dragonball.di.LocalDataSource
import com.example.dragonball.di.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DragonBallRepositoryImpl @Inject constructor(
    @RemoteDataSource private val remoteDataSource: DragonBallDataSource,
    @LocalDataSource private val localDataSource: DragonBallDataSource,
    private val scope: CoroutineScope
): DragonBallRepository {
    //Characters
    override suspend fun readAllCharacters(): Result<List<Character>> {
        return remoteDataSource.readAllCharacters()
    }
    override suspend fun readOneCharacter(id: Long): Result<Character> {
       return  remoteDataSource.readOneCharacter(id)
    }
    override fun observeCharacters(): Flow<Result<List<Character>>> {
        TODO("Not yet implemented")
    }
    private suspend fun refreshCharacters() {

    }

    //Planets
    override suspend fun readAllPlanets(): Result<List<Planet>> {
        return remoteDataSource.readAllPlanets()
    }
    override suspend fun readOnePlanet(id: Long): Result<Planet> {
        return remoteDataSource.readOnePlanet(id)
    }
    override fun observePlanets(): Flow<Result<List<Planet>>> {
        TODO("Not yet implemented")
    }
    private suspend fun refreshPlanets() {

    }

    //Transformations
    override suspend fun readAllTransformation(): Result<List<Transformation>> {
        return remoteDataSource.readAllTransformation()
    }
    override suspend fun readOneTransformation(id: Long): Result<Transformation> {
        return remoteDataSource.readOneTransformation(id)
    }
    override fun observeTransformations(): Flow<Result<List<Transformation>>> {
        TODO("Not yet implemented")
    }
    private suspend fun refreshTransformations() {

    }
}