package com.gamesage.marvel.data.repository

import com.gamesage.marvel.data.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun readOne(id: Long): Result<Character>
    suspend fun readAll(text: String): Result<List<Character>>
    suspend fun update(character: Character): Result<Int>
    fun observe(): Flow<Result<List<Character>>>
    suspend fun deleteOne(character: Character): Result<Int>
    suspend fun deleteAll(): Result<Int>
    suspend fun addAll(list: List<Character>)
}