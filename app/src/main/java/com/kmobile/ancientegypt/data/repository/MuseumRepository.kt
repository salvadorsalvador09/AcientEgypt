package com.kmobile.ancientegypt.data.repository

import com.kmobile.ancientegypt.data.remote.api.MetApiService
import com.kmobile.ancientegypt.data.remote.common.NetworkResult
import com.kmobile.ancientegypt.data.remote.common.toNetworkResult
import com.kmobile.ancientegypt.data.remote.dto.DepartmentsResponseDto
import java.io.IOException


class MuseumRepository(
    private val api: MetApiService,
) {
    //Lógica para obtener los datos del repositorio
    suspend fun getDepartments(): NetworkResult<DepartmentsResponseDto> {
        return try {
            api.getDepartments().toNetworkResult()
        } catch (e: IOException) {
            NetworkResult.Error(message = "Error de red. Revisa tu conexión.")
        } catch (e: Exception) {
            NetworkResult.Error(message = e.message ?: "Error inesperado")
        }
    }
}