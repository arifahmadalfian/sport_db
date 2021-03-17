package com.arifahmadalfian.thesportsdb.di

import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportInteractor
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase
import com.arifahmadalfian.thesportsdb.detail.DetailSportViewModel
import com.arifahmadalfian.thesportsdb.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SportUseCase> { SportInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailSportViewModel(get()) }
}