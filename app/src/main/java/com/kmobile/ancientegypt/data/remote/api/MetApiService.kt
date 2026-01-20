package com.kmobile.ancientegypt.data.remote.api

import com.kmobile.ancientegypt.data.remote.dto.DepartmentsResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MetApiService {
    @GET("departments")
    suspend fun getDepartments(): Response<DepartmentsResponseDto>
}
