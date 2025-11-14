package com.example.dragonball.data.remote

import com.example.dragonball.data.model.Character
import com.example.dragonball.data.model.Planet
import com.example.dragonball.data.model.Transformation
import com.example.dragonball.data.remote.model.CharacterRemote
import com.example.dragonball.data.remote.model.PlanetRemote
import com.example.dragonball.data.remote.model.TransformationRemote
import javax.inject.Inject

class DragonBallRemoteDataSource @Inject constructor(
    private val api: DragonBallApi
): DragonBallDataSource {
    //Characters
    override suspend fun readAllCharacters(): List<Character> {
        val response = api.readAllCharacters()
        val finalList = mutableListOf<Character>()
        return if (response.isSuccessful) {
            val body = response.body()!!
            for (result in body.results) {
                val remoteCharacter = readOneCharacter(result.id)
                remoteCharacter?.let {
                    finalList.add(it)
                }
            }
            finalList
        }
        else {
            listOf<Character>()
        }
    }
    override suspend fun readOneCharacter(id: Long): Character? {
        val response = api.readOneCharacter(id)
        return if (response.isSuccessful) {
            response.body()!!.toExternal()
        }
        else {
            null
        }
    }

    //Planets
    override suspend fun readAllPlanets(): List<Planet> {
        val response = api.readAllPlanets()
        val finalList = mutableListOf<Planet>()
        return if (response.isSuccessful) {
            val body = response.body()!!
            for (result in body.results) {
                val remotePlanet = readOnePlanet(result.id)
                remotePlanet?.let {
                    finalList.add(it)
                }
            }
            finalList
        }
        else {
            listOf<Planet>()
        }
    }
    override suspend fun readOnePlanet(id: Long): Planet? {
        val response = api.readOnePlanet(id)
        return if (response.isSuccessful) {
            response.body()!!.toExternal()
        }
        else {
            null
        }
    }

    //Transformations
    override suspend fun readAllTransformation(): List<Transformation> {
        val response = api.readAllTransformations()
        val finalList = mutableListOf<Transformation>()
        return if (response.isSuccessful) {
            val body = response.body()!!
            for (result in body.results) {
                val remoteTransformation = readOneTransformation(result.id)
                remoteTransformation?.let {
                    finalList.add(it)
                }
            }
            finalList
        }
        else {
            listOf<Transformation>()
        }
    }
    override suspend fun readOneTransformation(id: Long): Transformation? {
        val response = api.readOneTransformation(id)
        return if (response.isSuccessful) {
            response.body()!!.toExternal()
        }
        else {
            null
        }
    }
}

fun CharacterRemote.toExternal(): Character {
    return Character(
        id = this.id,
        name = this.name,
        ki = this.ki,
        maxKi = this.maxKi,
        race = this.race,
        gender = this.gender,
        description = this.description,
        image = this.image,
        affiliation = this.affiliation
    )
}

fun PlanetRemote.toExternal(): Planet {
    return Planet(
        id = this.id,
        name = this.name,
        isDestroyed = this.isDestroyed,
        description = this.description,
        image = this.image
    )
}

fun TransformationRemote.toExternal(): Transformation {
    return Transformation(
        id = this.id,
        name = this.name,
        image = this.image,
        ki = this.ki
    )
}