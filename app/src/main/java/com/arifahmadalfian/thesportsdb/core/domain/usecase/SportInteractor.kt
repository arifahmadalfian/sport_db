package com.arifahmadalfian.thesportsdb.core.domain.usecase

import com.arifahmadalfian.thesportsdb.core.domain.model.Sport
import com.arifahmadalfian.thesportsdb.core.domain.repository.ISportRepository
import javax.inject.Inject

class SportInteractor @Inject constructor(private val sportRepository: ISportRepository): SportUseCase {

    override fun getAllSport() = sportRepository.getAllSport()

    override fun getFavoriteSport() = sportRepository.getFavoriteSport()

    override fun setFavoriteSport(sport: Sport, state: Boolean) {
        sportRepository.setFavoriteSport(sport, state)
    }
}