package com.arifahmadalfian.thesportsdb.di

import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportInteractor
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideSportUseCase(sportInteractor: SportInteractor): SportUseCase
}