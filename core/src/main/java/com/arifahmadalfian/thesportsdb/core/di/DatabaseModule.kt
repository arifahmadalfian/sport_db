package com.arifahmadalfian.thesportsdb.core.di

import android.content.Context
import androidx.room.Room
import com.arifahmadalfian.thesportsdb.core.data.source.local.room.SportDao
import com.arifahmadalfian.thesportsdb.core.data.source.local.room.SportDatabase
import dagger.hilt.android.components.ApplicationComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SportDatabase = Room.databaseBuilder(
        context,
        SportDatabase::class.java, "Sport.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideSportDao(database: SportDatabase): SportDao = database.sportDao()
}