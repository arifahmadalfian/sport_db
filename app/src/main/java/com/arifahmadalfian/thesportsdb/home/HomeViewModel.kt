package com.arifahmadalfian.thesportsdb.home

import androidx.lifecycle.ViewModel
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase

class HomeViewModel(private val sportUseCase: SportUseCase): ViewModel() {
    val sport = sportUseCase.getAllSport()
}