package com.gamesage.marvel.data.local

import com.gamesage.marvel.data.CharacterDataSource
import com.gamesage.marvel.data.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterLocalDataSource @Inject constructor(
    private val characterDao: CharacterDao
): CharacterDataSource {
    override suspend fun addAll(characterList: List<Character>) {
        characterList.forEach { character ->
            val entity = character.toEntity()
            withContext(Dispatchers.IO) {
                characterDao.insert(entity)
            }
        }
    }

    override suspend fun update(character: Character): Result<Int> {
        val entity = character.toEntity()
        val id = characterDao.update(entity)
        return if (id > 0) {
            Result.success(id)
        } else {
            Result.failure(CharacterNotFoundException())
        }
    }

    override fun observe(): Flow<Result<List<Character>>> {
        val databaseFlow = characterDao.observeAll()
        return databaseFlow.map { entities ->
            Result.success(entities.toModel())
        }
    }

    override suspend fun readAll(name: String?): Result<List<Character>> {
        val result = Result.success(characterDao.getAll().toModel())
        return result
    }

    override suspend fun readOne(id: Long): Result<Character> {
        val entity = characterDao.readCharacterById(id)
        return if (entity==null)
            Result.failure(CharacterNotFoundException())
        else
            Result.success(entity.toModel())
    }

    override suspend fun deleteOne(character: Character): Result<Int> {
        val entity = character.toEntity()
        val id = characterDao.deleteOne(entity)
        return if (id>0)
            Result.success(id)
        else
            Result.failure(CharacterNotFoundException())
    }

    override suspend fun deleteAll(): Result<Int> {
        val deleted = characterDao.deleteAll()
        return if (deleted>0)
            Result.success(deleted)
        else
            Result.failure(CharacterNotFoundException())
    }

    override suspend fun isError() {
        TODO("Not yet implemented")
    }

}
