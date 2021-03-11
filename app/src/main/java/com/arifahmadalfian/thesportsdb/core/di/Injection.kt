package com.arifahmadalfian.thesportsdb.core.di

import android.content.Context
import com.arifahmadalfian.thesportsdb.core.data.SportRepository
import com.arifahmadalfian.thesportsdb.core.data.source.local.LocalDataSource
import com.arifahmadalfian.thesportsdb.core.data.source.local.room.SportDatabase
import com.arifahmadalfian.thesportsdb.core.data.source.remote.RemoteDataSource
import com.arifahmadalfian.thesportsdb.core.data.source.remote.network.ApiConfig
import com.arifahmadalfian.thesportsdb.core.domain.repository.ISportRepository
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportInteractor
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase
import com.arifahmadalfian.thesportsdb.core.utils.AppExecutors

object Injection {

    fun provideRepository(context: Context): ISportRepository {
        val database = SportDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.sportDao())
        val appExecutors = AppExecutors()

        return SportRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideSportUseCase(context: Context): SportUseCase {
        val repository = provideRepository(context)
        return SportInteractor(repository)
    }
}
