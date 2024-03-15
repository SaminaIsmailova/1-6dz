package com.example.rick_and_morty.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class Location(
    val name: String?,
    val url: String?
) : Parcelable