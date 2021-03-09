package com.arifahmadalfian.thesportsdb.core.domain.usecase

import androidx.lifecycle.LiveData
import com.arifahmadalfian.thesportsdb.core.data.Resource
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport

interface SportUseCase {
    fun getAllSport(): LiveData<Resource<List<Sport>>>
    fun getFavoriteSport(): LiveData<List<Sport>>
    fun setFavoriteSport(sport: Sport, state: Boolean)
}