package com.kmobile.ancientegypt.ui.screen.departments

import com.kmobile.ancientegypt.data.remote.dto.DepartmentDto

sealed class DepartmentsUiState {
    data object Loading : DepartmentsUiState()
    data class Success(val items: List<DepartmentDto>) : DepartmentsUiState()
    data class Error(val message: String) : DepartmentsUiState()
}