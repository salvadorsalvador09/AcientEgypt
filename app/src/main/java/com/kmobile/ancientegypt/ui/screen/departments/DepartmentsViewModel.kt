package com.kmobile.ancientegypt.ui.screen.departments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmobile.ancientegypt.data.remote.common.NetworkResult
import com.kmobile.ancientegypt.data.repository.MuseumRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
class DepartmentsViewModel(
    private val repository: MuseumRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DepartmentsUiState>(DepartmentsUiState.Loading)
    val uiState: StateFlow<DepartmentsUiState> = _uiState.asStateFlow()

    fun load() {
        viewModelScope.launch {
            _uiState.value = DepartmentsUiState.Loading
            when (val result = repository.getDepartments()) {
                is NetworkResult.Success -> {
                    _uiState.value = DepartmentsUiState.Success(result.data.departments)
                }
                is NetworkResult.Error -> {
                    _uiState.value = DepartmentsUiState.Error(result.message ?: "Error al cargar departamentos")
                }
            }
        }
    }
}