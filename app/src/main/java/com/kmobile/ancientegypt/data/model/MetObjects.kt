package com.kmobile.ancientegypt.data.model
import com.fasterxml.jackson.annotation.JsonProperty


data class MetObject(
    val id: Int,
    val title: String,
    val subtitle: String,         // ej: "Dinastía XVIII • New Kingdom"
    val culture: String,
    val period: String,
    val dateRange: String,        // ej: "1550–1292 BCE"
    val imageUrl: String?,        // prefer high-res si existe
    val imageThumbUrl: String?,
    val tags: List<String>
)
