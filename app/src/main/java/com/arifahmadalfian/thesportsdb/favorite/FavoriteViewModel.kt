package com.arifahmadalfian.thesportsdb.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase

class FavoriteViewModel @ViewModelInject constructor(sportUseCase: SportUseCase): ViewModel() {
    val favoriteSport = sportUseCase.getFavoriteSport().asLiveData()
}