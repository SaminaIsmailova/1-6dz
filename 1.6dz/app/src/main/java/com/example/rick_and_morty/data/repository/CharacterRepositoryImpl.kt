package com.example.rick_and_morty.data.repository

import com.example.rick_and_morty.data.remote.CharacterApi
import com.example.rick_and_morty.data.remote.dto.CharactersDto
import com.example.rick_and_morty.data.remote.dto.ResultDto
import com.example.rick_and_morty.domain.repository.CharacterRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterApi: CharacterApi
) : CharacterRepository {

    override fun getAllCharacters(pageNumber: Int): Single<CharactersDto> {
        return characterApi.getAllCharacters(pageNumber)
            .subscribeOn(Schedulers.io())
    }

    override fun getCharacterById(id: Int): Single<ResultDto> {
        return characterApi.getCharacterById(id = id)
            .subscribeOn(Schedulers.io())
    }

}