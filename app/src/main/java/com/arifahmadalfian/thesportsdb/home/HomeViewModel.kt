package com.arifahmadalfian.thesportsdb.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase

class HomeViewModel @ViewModelInject constructor(sportUseCase: SportUseCase): ViewModel() {
    val sport = sportUseCase.getAllSport().asLiveData()
}