package com.gamesage.marvel.data

import com.gamesage.marvel.data.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterDataSource {
    suspend fun addAll(characterList: List<Character>)
    fun observe(): Flow<Result<List<Character>>>
    suspend fun readAll(name: String? = ""): Result<List<Character>>
    suspend fun readOne(id: Long): Result<Character>
    suspend fun deleteOne(character: Character): Result<Int>
    suspend fun deleteAll(): Result<Int>
    suspend fun isError()
}