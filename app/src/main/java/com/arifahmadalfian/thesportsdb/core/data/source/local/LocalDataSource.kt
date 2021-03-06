package com.arifahmadalfian.thesportsdb.core.data.source.local

import androidx.lifecycle.LiveData
import com.arifahmadalfian.thesportsdb.core.data.source.local.entity.SportEntity
import com.arifahmadalfian.thesportsdb.core.data.source.local.room.SportDao

class LocalDataSource private constructor(private val sportDao: SportDao) {

    fun getAllSport(): LiveData<List<SportEntity>> = sportDao.getAllSport()

    fun getFavoriteSport(): LiveData<List<SportEntity>> = sportDao.getFavoriteSport()

    fun insertSport(sportList: List<SportEntity>) = sportDao.insertSport(sportList)

    fun setSportFavorite(sport: SportEntity, newState: Boolean) {
        sport.isFavorite = newState
        sportDao.updateFavoriteSport(sport)
    }
}