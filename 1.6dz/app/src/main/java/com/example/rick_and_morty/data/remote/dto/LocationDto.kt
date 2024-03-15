package com.example.rick_and_morty.data.remote.dto

import com.example.rick_and_morty.domain.models.Location

data class LocationDto(
    val name: String?,
    val url: String?
) {
    fun toLocation(): Location {
        return Location(
            name = name,
            url = url
        )
    }
}