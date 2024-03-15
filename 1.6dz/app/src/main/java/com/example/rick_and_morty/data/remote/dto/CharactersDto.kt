package com.example.rick_and_morty.data.remote.dto

import com.example.rick_and_morty.domain.models.Characters

data class CharactersDto(
    val info: InfoDto?,
    val results: List<ResultDto>?
) {
    fun toCharacter(): Characters {
        return Characters(
            info = info?.toInfo(),
            results = results?.map { it.toResult() }
        )
    }
}