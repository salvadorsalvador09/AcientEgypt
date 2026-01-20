package com.kmobile.ancientegypt.domain.model

class MediaContent (
    val type: TypoContentType,
    val url: String,
    val duration: Int
)

enum class TypoContentType{
    AUDIO,
    VIDEO
}