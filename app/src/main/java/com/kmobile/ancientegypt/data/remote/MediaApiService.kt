package com.kmobile.ancientegypt.data.remote

import com.kmobile.ancientegypt.data.remote.dto.MetObjectDetailDto
import com.kmobile.ancientegypt.data.remote.dto.MetObjectDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response

interface MetApiService {

    @GET("search")
    suspend fun searchEgyptianArtifacts(
        @Query("q") query: String,
        @Query("departmentId") departmentId: Int = 10,
        @Query("hasImages") hasImages: Boolean = true
    ): Response<MetObjectDetailDto>

    @GET("objects/{objectId}")
    suspend fun getObjectById(
        @Path("objectId") objectId: Int
    ): Response<MetObjectDto>

    @GET("objects")
    suspend fun getObjectIdsByDepartment(
        @Query("departmentIds") departmentIds: Int
    ): Response<MetObjectDetailDto>
}

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(
        val code: Int? = null,
        val message: String? = null
    ) : NetworkResult<Nothing>()
}
