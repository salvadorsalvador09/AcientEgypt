package com.kmobile.ancientegypt.data.auth.remote


import com.kmobile.ancientegypt.data.auth.dto.LoginRequestDto
import com.kmobile.ancientegypt.data.auth.dto.LoginResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("login")
    suspend fun login(@Body body: LoginRequestDto): Response<LoginResponseDto>
}