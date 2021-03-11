package com.arifahmadalfian.thesportsdb.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arifahmadalfian.thesportsdb.core.di.Injection
import com.arifahmadalfian.thesportsdb.core.domain.usecase.SportUseCase
import com.arifahmadalfian.thesportsdb.detail.DetailSportViewModel
import com.arifahmadalfian.thesportsdb.favorite.FavoriteViewModel
import com.arifahmadalfian.thesportsdb.home.HomeViewModel

class ViewModelFactory private constructor(private val sportUseCase: SportUseCase): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(
                            Injection.provideSportUseCase(context)
                    )
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(sportUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(sportUseCase) as T
            }
            modelClass.isAssignableFrom(DetailSportViewModel::class.java) -> {
                DetailSportViewModel(sportUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}