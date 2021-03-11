package com.arifahmadalfian.thesportsdb.core.domain.repository

import com.arifahmadalfian.thesportsdb.core.data.Resource
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface ISportRepository {
    fun getAllSport(): Flow<Resource<List<Sport>>>

    fun getFavoriteSport(): Flow<List<Sport>>

    fun setFavoriteSport(sport: Sport, state: Boolean)
}