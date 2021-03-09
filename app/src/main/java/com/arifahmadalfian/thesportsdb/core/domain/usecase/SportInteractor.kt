package com.arifahmadalfian.thesportsdb.core.domain.usecase

import androidx.lifecycle.LiveData
import com.arifahmadalfian.thesportsdb.core.data.Resource
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport
import com.arifahmadalfian.thesportsdb.core.domain.repository.ISportRepository

class SportInteractor(private val sportRepository: ISportRepository): SportUseCase {
    override fun getAllSport(): LiveData<Resource<List<Sport>>> {
        return sportRepository.getAllSport()
    }

    override fun getFavoriteSport(): LiveData<List<Sport>> {
        return sportRepository.getFavoriteSport()
    }

    override fun setFavoriteSport(sport: Sport, state: Boolean) {
        sportRepository.setFavoriteSport(sport, state)
    }
}