package com.kmobile.ancientegypt.ui.screen.departments


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kmobile.ancientegypt.data.remote.dto.DepartmentDto

@Composable
fun DepartmentsScreen(
    viewModel: DepartmentsViewModel,
    onDepartmentClick: (DepartmentDto) -> Unit
) {
    LaunchedEffect(Unit) { viewModel.load() }

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when (state) {
        is DepartmentsUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is DepartmentsUiState.Error -> {
            val s = state as DepartmentsUiState.Error
            Column(Modifier.padding(16.dp)) {
                Text(s.message)
                Spacer(Modifier.height(12.dp))
                Button(onClick = { viewModel.load() }) { Text("Reintentar") }
            }
        }

        is DepartmentsUiState.Success -> {
            val s = state as DepartmentsUiState.Success
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(s.items) { dep ->
                    DepartmentRow(dep = dep, onClick = { onDepartmentClick(dep) })
                }
            }
        }
    }
}

@Composable
private fun DepartmentRow(dep: DepartmentDto, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(dep.displayName, style = MaterialTheme.typography.titleMedium)
            Text("ID: ${dep.departmentId}", style = MaterialTheme.typography.bodySmall)
        }
    }
}