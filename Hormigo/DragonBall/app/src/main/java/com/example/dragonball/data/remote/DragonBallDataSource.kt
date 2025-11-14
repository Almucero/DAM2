package com.example.dragonball.data.remote

import com.example.dragonball.data.model.Character
import com.example.dragonball.data.model.Planet
import com.example.dragonball.data.model.Transformation

interface DragonBallDataSource {
    //Characters
    suspend fun readAllCharacters(): List<Character>
    suspend fun readOneCharacter(id: Long): Character?
    //Planets
    suspend fun readAllPlanets(): List<Planet>
    suspend fun readOnePlanet(id: Long): Planet?
    //Transformation
    suspend fun readAllTransformation(): List<Transformation>
    suspend fun readOneTransformation(id: Long): Transformation?
}