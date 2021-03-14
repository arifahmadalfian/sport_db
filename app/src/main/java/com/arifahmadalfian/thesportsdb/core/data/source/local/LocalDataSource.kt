package com.arifahmadalfian.thesportsdb.core.data.source.local

import com.arifahmadalfian.thesportsdb.core.data.source.local.entity.SportEntity
import com.arifahmadalfian.thesportsdb.core.data.source.local.room.SportDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val sportDao: SportDao) {

    fun getAllSport(): Flow<List<SportEntity>> = sportDao.getAllSport()

    fun getFavoriteSport(): Flow<List<SportEntity>> = sportDao.getFavoriteSport()

    suspend fun insertSport(sportList: List<SportEntity>) = sportDao.insertSport(sportList)

    fun setSportFavorite(sport: SportEntity, newState: Boolean) {
        sport.isFavorite = newState
        sportDao.updateFavoriteSport(sport)
    }
}