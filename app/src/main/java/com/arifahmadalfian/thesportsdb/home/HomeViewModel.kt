package com.arifahmadalfian.thesportsdb.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase

class HomeViewModel(sportUseCase: SportUseCase): ViewModel() {
    val sport = sportUseCase.getAllSport().asLiveData()
}