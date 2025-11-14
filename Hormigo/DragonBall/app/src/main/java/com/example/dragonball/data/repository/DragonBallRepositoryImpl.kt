package com.example.dragonball.data.repository

import com.example.dragonball.data.model.Character
import com.example.dragonball.data.model.Planet
import com.example.dragonball.data.model.Transformation
import com.example.dragonball.data.remote.DragonBallDataSource
import javax.inject.Inject

class DragonBallRepositoryImpl @Inject constructor(
    private val dataSource: DragonBallDataSource
): DragonBallRepository {
    //Characters
    override suspend fun readAllCharacters(): List<Character> {
        return dataSource.readAllCharacters()
    }
    override suspend fun readOneCharacter(id: Long): Character? {
       return  dataSource.readOneCharacter(id)
    }

    //Planets
    override suspend fun readAllPlanets(): List<Planet> {
        return dataSource.readAllPlanets()
    }
    override suspend fun readOnePlanet(id: Long): Planet? {
        return dataSource.readOnePlanet(id)
    }

    //Transformations
    override suspend fun readAllTransformation(): List<Transformation> {
        return dataSource.readAllTransformation()
    }
    override suspend fun readOneTransformation(id: Long): Transformation? {
        return dataSource.readOneTransformation(id)
    }
}