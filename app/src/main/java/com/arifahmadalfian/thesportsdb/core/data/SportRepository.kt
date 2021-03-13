package com.arifahmadalfian.thesportsdb.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.arifahmadalfian.thesportsdb.core.data.source.local.LocalDataSource
import com.arifahmadalfian.thesportsdb.core.data.source.remote.RemoteDataSource
import com.arifahmadalfian.thesportsdb.core.data.source.remote.network.ApiResponse
import com.arifahmadalfian.thesportsdb.core.data.source.remote.response.SportResponse
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport
import com.arifahmadalfian.thesportsdb.core.domain.repository.ISportRepository
import com.arifahmadalfian.thesportsdb.core.utils.AppExecutors
import com.arifahmadalfian.thesportsdb.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SportRepository(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
): ISportRepository {

    override fun getAllSport(): Flow<Resource<List<Sport>>> {
        return object: NetworkBoundResource<List<Sport>, List<SportResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Sport>> {
                return localDataSource.getAllSport().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Sport>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<SportResponse>>> {
                return remoteDataSource.getAllSports()
            }

            override suspend fun saveCallResult(data: List<SportResponse>) {
                val sportList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSport(sportList)
            }

        }.asFlow()
    }

    override fun getFavoriteSport(): Flow<List<Sport>> {
        return localDataSource.getFavoriteSport().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteSport(sport: Sport, state: Boolean) {
        val sportEntity = DataMapper.mapDomainToEntity(sport)
        appExecutors.diskIO().execute { localDataSource.setSportFavorite(sportEntity, state) }
    }
}