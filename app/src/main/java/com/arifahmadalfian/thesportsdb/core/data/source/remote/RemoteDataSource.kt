package com.arifahmadalfian.thesportsdb.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arifahmadalfian.thesportsdb.core.data.source.remote.network.ApiResponse
import com.arifahmadalfian.thesportsdb.core.data.source.remote.network.ApiService
import com.arifahmadalfian.thesportsdb.core.data.source.remote.response.ListSportResponse
import com.arifahmadalfian.thesportsdb.core.data.source.remote.response.SportResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(service)
                }
    }

   fun getAllSports(): LiveData<ApiResponse<List<SportResponse>>> {
       val resultData = MutableLiveData<ApiResponse<List<SportResponse>>>()

       val client = apiService.getList()
       client.enqueue(object: Callback<ListSportResponse>{
           override fun onResponse(
               call: Call<ListSportResponse>,
               response: Response<ListSportResponse>
           ) {
               val dataArray = response.body()?.sports
               resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
           }

           override fun onFailure(call: Call<ListSportResponse>, t: Throwable) {
               resultData.value = ApiResponse.Error(t.message.toString())
               Log.e("RemoteDataSource", t.message.toString())
           }

       })
       return resultData
   }
}