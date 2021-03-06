package com.arifahmadalfian.thesportsdb.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arifahmadalfian.thesportsdb.core.data.source.local.entity.SportEntity

@Dao
interface SportDao {
    @Query("SELECT * FROM sport")
    fun getAllSport(): LiveData<List<SportEntity>>

    @Query("SELECT * FROM sport WHERE isFavorite = 1")
    fun getFavoriteSport(): LiveData<List<SportEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSport(sport: List<SportEntity>)

    @Update
    fun updateFavoriteSport(sport: SportEntity)
}