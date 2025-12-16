package com.gamesage.marvel.data.repository

import com.gamesage.marvel.data.CharacterDataSource
import com.gamesage.marvel.data.model.Character
import com.gamesage.marvel.di.LocalDataSource
import com.gamesage.marvel.di.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    @RemoteDataSource private val remoteDataSource: CharacterDataSource,
    @LocalDataSource private val localDataSource: CharacterDataSource,
    private val scope: CoroutineScope
): CharacterRepository {
    override suspend fun readOne(id: Long): Result<Character> {
        return remoteDataSource.readOne(id)
    }

    override suspend fun readAll(text: String): Result<List<Character>> {
        return remoteDataSource.readAll(text)
    }

    override fun observe(): Flow<Result<List<Character>>> {
        scope.launch {
            remoteDataSource.observe().collect { result ->
                if (result.isSuccess) {
                    localDataSource.addAll(characterList = result.getOrNull()!!)
                }
            }
        }
        return localDataSource.observe()
    }

    override suspend fun deleteOne(character: Character): Result<Int> {
        return localDataSource.deleteOne(character)
    }

    override suspend fun deleteAll(): Result<Int> {
        return localDataSource.deleteAll()
    }

    override suspend fun addAll(list: List<Character>) {
        localDataSource.addAll(list)
    }
}