package com.example.rick_and_morty.domain.use_cases

import com.example.rick_and_morty.domain.models.Characters
import com.example.rick_and_morty.domain.repository.CharacterRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(pageNumber: Int): Single<Characters> {
        return repository.getAllCharacters(pageNumber = pageNumber)
            .map { it.toCharacter() }
            .subscribeOn(Schedulers.io())
    }
}