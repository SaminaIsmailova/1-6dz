package com.example.rick_and_morty.domain.repository

import com.example.rick_and_morty.data.remote.dto.CharactersDto
import com.example.rick_and_morty.data.remote.dto.ResultDto
import io.reactivex.Single

interface CharacterRepository {

    fun getAllCharacters(pageNumber: Int): Single<CharactersDto>

    fun getCharacterById(id: Int): Single<ResultDto>
}