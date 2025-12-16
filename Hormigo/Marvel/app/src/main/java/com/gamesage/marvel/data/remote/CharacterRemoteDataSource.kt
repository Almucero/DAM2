package com.gamesage.marvel.data.remote

import com.gamesage.marvel.data.CharacterDataSource
import com.gamesage.marvel.data.model.Character
import com.gamesage.marvel.data.remote.model.CharacterRemote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val api: CharacterApi,
    private val scope: CoroutineScope
): CharacterDataSource {
    override suspend fun addAll(characterList: List<Character>) {
        TODO("NO SE IMPLEMENTA EN REMOTE")
    }

    override suspend fun update(character: Character): Result<Int> {
        TODO("NO SE IMPLEMENTA EN REMOTE")
    }

    override fun observe(): Flow<Result<List<Character>>> {
        return flow {
            emit(Result.success(listOf<Character>()))
            val result = readAll()
            emit(result)
        }.shareIn(
            scope = scope,
            started = SharingStarted.WhileSubscribed(5_000L),
            replay = 1
        )
    }

    override suspend fun readAll(name: String?): Result<List<Character>> {
        try {
            val response = api.readAll(name = name ?: "")
            val finalList = mutableListOf<Character>()
            return if (response.isSuccessful) {
                val body = response.body()!!
                for (result in body.results) {
                    val remoteCharacter = result.toExternal()
                    remoteCharacter.let {
                        finalList.add(it)
                    }
                }
                Result.success(finalList)
            }
            else {
                val status = response.code()
                Result.failure(RuntimeException("Error code: $status"))
            }
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }

    override suspend fun readOne(id: Long): Result<Character> {
        val response = api.readOne(id)
        return if (response.isSuccessful) {
            val character = response.body()!!.toExternal()
            Result.success(character)
        } else {
            Result.failure(RuntimeException())
        }
    }

    override suspend fun deleteOne(character: Character): Result<Int> {
        TODO("NO SE IMPLEMENTA EN REMOTE")
    }

    override suspend fun deleteAll(): Result<Int> {
        TODO("NO SE IMPLEMENTA EN REMOTE")
    }

    override suspend fun isError() {
        TODO("Not yet implemented")
    }
}

fun CharacterRemote.toExternal(): Character {
    return Character(
        id = this.id,
        name = this.name,
        image = this.image,
        originName = this.origin.name
    )
}