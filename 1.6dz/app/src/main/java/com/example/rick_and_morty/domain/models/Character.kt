package com.example.rick_and_morty.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Int?,
    val name: String?,
    val location: Location?,
    val origin: Origin?,
    val image: String?,
    val status: String?,
    val species: String?
) : Parcelable