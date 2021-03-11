package com.arifahmadalfian.thesportsdb.core.data.source.local

import androidx.lifecycle.LiveData
import com.arifahmadalfian.thesportsdb.core.data.source.local.entity.SportEntity
import com.arifahmadalfian.thesportsdb.core.data.source.local.room.SportDao

class LocalDataSource private constructor(private val sportDao: SportDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(sportDao: SportDao): LocalDataSource =
                instance ?: synchronized(this) {
                    instance ?: LocalDataSource(sportDao)
                }
    }

    fun getAllSport(): LiveData<List<SportEntity>> = sportDao.getAllSport()

    fun getFavoriteSport(): LiveData<List<SportEntity>> = sportDao.getFavoriteSport()

    fun insertSport(sportList: List<SportEntity>) = sportDao.insertSport(sportList)

    fun setSportFavorite(sport: SportEntity, newState: Boolean) {
        sport.isFavorite = newState
        sportDao.updateFavoriteSport(sport)
    }
}