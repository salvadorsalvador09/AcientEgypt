package com.kmobile.ancientegypt.data.model

class MediaContent (
    val type: TypoContentType,
    val url: String,
    val duration: Int
)

enum class TypoContentType{
    AUDIO,
    VIDEO
}