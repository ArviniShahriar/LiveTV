package com.tvlive.launcher

data class Channel(
    val name: String,
    val live: Boolean,
    val youtube: String,
    val default: Boolean = false
)