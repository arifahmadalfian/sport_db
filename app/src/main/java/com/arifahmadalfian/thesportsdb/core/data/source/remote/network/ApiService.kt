package com.arifahmadalfian.thesportsdb.core.data.source.remote.network

import com.arifahmadalfian.thesportsdb.core.data.source.remote.response.ListSportResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/json/1/all_sports.php")
    suspend fun getList(): ListSportResponse
}