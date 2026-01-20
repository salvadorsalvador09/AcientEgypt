package com.kmobile.ancientegypt.data.remote

import retrofit2.Response

fun <T> Response<T>.toNetworkResult(): NetworkResult<T> {
    return if (isSuccessful) {
        val body = body()
        if (body != null) {
            NetworkResult.Success(body)
        } else {
            NetworkResult.Error(code(), "Respuesta vacía del servidor")
        }
    } else {
        NetworkResult.Error(code(), message())
    }
}