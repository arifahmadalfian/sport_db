package com.arifahmadalfian.thesportsdb.favorite

import androidx.lifecycle.ViewModel
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase

class FavoriteViewModel(private val sportUseCase: SportUseCase): ViewModel() {
    val favoriteSport = sportUseCase.getFavoriteSport()
}