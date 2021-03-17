package com.arifahmadalfian.thesportsdb

import android.app.Application
import com.arifahmadalfian.thesportsdb.core.di.databaseModule
import com.arifahmadalfian.thesportsdb.core.di.networkModule
import com.arifahmadalfian.thesportsdb.core.di.repositoryModule
import com.arifahmadalfian.thesportsdb.di.useCaseModule
import com.arifahmadalfian.thesportsdb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            fragmentFactory()
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}