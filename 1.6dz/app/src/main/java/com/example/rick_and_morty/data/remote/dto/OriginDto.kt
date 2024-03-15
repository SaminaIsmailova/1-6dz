package com.example.rick_and_morty.data.remote.dto

import com.example.rick_and_morty.domain.models.Origin

data class OriginDto(
    val name: String?,
    val url: String?
) {
    fun toOrigin(): Origin {
        return Origin(
            name = name,
            url = url
        )
    }
}