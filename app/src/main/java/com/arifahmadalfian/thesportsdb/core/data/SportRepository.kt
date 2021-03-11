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

class SportRepository private constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
): ISportRepository {

    companion object {
        @Volatile
        private var instance: SportRepository? = null

        fun getInstance(
                remoteData: RemoteDataSource,
                localData: LocalDataSource,
                appExecutors: AppExecutors
        ): SportRepository =
                instance ?: synchronized(this) {
                    instance ?: SportRepository(remoteData, localData, appExecutors)
                }
    }

    override fun getAllSport(): LiveData<Resource<List<Sport>>> {
        return object: NetworkBoundResource<List<Sport>, List<SportResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Sport>> {
                return Transformations.map(localDataSource.getAllSport()){
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Sport>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<SportResponse>>> {
                return remoteDataSource.getAllSports()
            }

            override fun saveCallResult(data: List<SportResponse>) {
                val sportList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSport(sportList)
            }

        }.asLiveData()
    }

    override fun getFavoriteSport(): LiveData<List<Sport>> {
        return Transformations.map(localDataSource.getFavoriteSport()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteSport(sport: Sport, state: Boolean) {
        val sportEntity = DataMapper.mapDomainToEntity(sport)
        appExecutors.diskIO().execute { localDataSource.setSportFavorite(sportEntity, state) }
    }
}