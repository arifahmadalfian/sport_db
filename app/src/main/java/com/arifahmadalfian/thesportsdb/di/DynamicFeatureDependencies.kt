package com.arifahmadalfian.thesportsdb.di

import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface DynamicFeatureDependencies {

    fun provideDynamicFeatureFavorite(): SportUseCase
}