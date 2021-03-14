package com.arifahmadalfian.thesportsdb.core.di

import com.arifahmadalfian.thesportsdb.core.data.SportRepository
import com.arifahmadalfian.thesportsdb.core.domain.repository.ISportRepository
import dagger.hilt.android.components.ApplicationComponent
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(sportRepository: SportRepository): ISportRepository
}