package com.kmobile.ancientegypt.data.repository

import com.kmobile.ancientegypt.data.remote.MetApiService
import com.kmobile.ancientegypt.data.remote.NetworkResult
import com.kmobile.ancientegypt.data.remote.dto.MetObjectDetailDto
import com.kmobile.ancientegypt.data.remote.dto.MetObjectDto
import com.kmobile.ancientegypt.data.remote.toNetworkResult
import java.io.IOException

class MuseumRepository ( private val api: MetApiService
) {
//Lógica para obtener los datos del repositorio
    suspend fun searchEgyptianArtifacts(query: String): NetworkResult<MetObjectDetailDto> {
        return try {
            api.searchEgyptianArtifacts(query).toNetworkResult()
        } catch (e: IOException) {
            NetworkResult.Error(message = "Error de red. Revisa tu conexión.")
        } catch (e: Exception) {
            NetworkResult.Error(message = e.message ?: "Error inesperado")
        }
    }

    suspend fun getObjectById(objectId: Int): NetworkResult<MetObjectDto> {
        return try {
            api.getObjectById(objectId).toNetworkResult()
        } catch (e: IOException) {
            NetworkResult.Error(message = "Error de red. Revisa tu conexión.")
        } catch (e: Exception) {
            NetworkResult.Error(message = e.message ?: "Error inesperado")
        }
    }
}
