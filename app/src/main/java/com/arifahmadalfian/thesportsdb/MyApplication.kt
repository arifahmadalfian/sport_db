package com.arifahmadalfian.thesportsdb

import android.app.Application
import com.arifahmadalfian.thesportsdb.core.di.databaseModule
import com.arifahmadalfian.thesportsdb.core.di.networkModule
import com.arifahmadalfian.thesportsdb.core.di.repositoryModule
import com.arifahmadalfian.thesportsdb.di.useCaseModule
import com.arifahmadalfian.thesportsdb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
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