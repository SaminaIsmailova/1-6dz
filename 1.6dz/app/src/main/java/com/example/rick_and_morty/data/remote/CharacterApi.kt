package com.example.rick_and_morty.data.remote

import com.example.rick_and_morty.data.remote.dto.CharactersDto
import com.example.rick_and_morty.data.remote.dto.ResultDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET("character")
    fun getAllCharacters(
        @Query("page") pageNumber: Int?
    ): Single<CharactersDto>

    @GET("character/{id}")
    fun getCharacterById(
        @Path("id") id: Int
    ): Single<ResultDto>
}