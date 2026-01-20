package com.kmobile.ancientegypt.data.remote.dto

import com.fasterxml.jackson.annotation.JsonProperty


data class DepartmentsResponseDto(
    @JsonProperty("departments")
    val departments: List<DepartmentDto> = emptyList()
)

data class DepartmentDto(
    @JsonProperty("departmentId")
    val departmentId: Int,
    @JsonProperty("displayName")
    val displayName: String
)
