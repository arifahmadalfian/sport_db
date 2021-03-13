package com.arifahmadalfian.thesportsdb.core.data.source.remote

import android.util.Log
import com.arifahmadalfian.thesportsdb.core.data.source.remote.network.ApiResponse
import com.arifahmadalfian.thesportsdb.core.data.source.remote.network.ApiService
import com.arifahmadalfian.thesportsdb.core.data.source.remote.response.SportResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

   suspend fun getAllSports(): Flow<ApiResponse<List<SportResponse>>> {
      // get data from remote api
       return flow {
           try {
               val response = apiService.getList()
               val dataArray = response.sports
               if (dataArray.isNotEmpty()) {
                   emit(ApiResponse.Success(response.sports))
               } else {
                   emit(ApiResponse.Empty)
               }
           } catch (e: Exception) {
               emit(ApiResponse.Error(e.toString()))
               Log.e("RemoteDataSource", e.toString())
           }
       }.flowOn(Dispatchers.IO)
   }
}