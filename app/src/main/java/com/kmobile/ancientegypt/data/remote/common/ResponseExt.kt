package com.kmobile.ancientegypt.data.remote.common


import retrofit2.Response

fun <T> Response<T>.toNetworkResult(): NetworkResult<T> =
    if (isSuccessful) {
        body()?.let { NetworkResult.Success(it) }
            ?: NetworkResult.Error(code(), "Respuesta vacía del servidor")
    } else {
        NetworkResult.Error(code(), message())
    }