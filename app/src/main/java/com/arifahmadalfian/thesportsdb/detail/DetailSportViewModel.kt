package com.arifahmadalfian.thesportsdb.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase

class DetailSportViewModel @ViewModelInject constructor(private val sportUseCase: SportUseCase): ViewModel() {
    fun setFavoriteSport(sport: Sport, state: Boolean) {
        sportUseCase.setFavoriteSport(sport, state)
    }
}