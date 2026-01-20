package com.kmobile.ancientegypt.data.auth.repository



import com.kmobile.ancientegypt.data.auth.dto.LoginRequestDto
import com.kmobile.ancientegypt.data.auth.local.SessionDataStore
import com.kmobile.ancientegypt.data.auth.remote.AuthApiService
import com.kmobile.ancientegypt.data.remote.common.NetworkResult
import com.kmobile.ancientegypt.data.remote.common.toNetworkResult
import java.io.IOException

class AuthRepository(
    private val api: AuthApiService,
    private val session: SessionDataStore
) {
    val tokenFlow = session.tokenFlow

    suspend fun login(email: String, password: String): NetworkResult<Unit> {
        return try {
            val response = api.login(LoginRequestDto(email, password)).toNetworkResult()
            when (response) {
                is NetworkResult.Success -> {
                    session.saveToken(response.data.data.uuid)
                    NetworkResult.Success(Unit)
                }
                is NetworkResult.Error -> response
            }
        } catch (e: IOException) {
            NetworkResult.Error(message = "Error de red. Revisa tu conexión.")
        } catch (e: Exception) {
            NetworkResult.Error(message = e.message ?: "Error inesperado")
        }
    }

    suspend fun logout() {
        session.clear()
    }
}