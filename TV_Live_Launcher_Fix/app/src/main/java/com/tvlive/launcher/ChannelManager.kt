package com.tvlive.launcher

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

class ChannelManager(private val context: Context) {

    private val defaultChannel = Channel(
        name = "Iran International",
        live = true,
        youtube = "https://www.youtube.com/live/5JDxjsAVaGk?is=9k9ureil8hqB9cwj",
        default = true
    )

    fun handleChannels(channels: List<Channel>) {
        val activeChannels = if (channels.isNotEmpty()) channels else listOf(defaultChannel)

        if (activeChannels.size == 1) {
            launchYouTubeLive(activeChannels.first().youtube)
        } else {
            val defaultChan = activeChannels.find { it.default } ?: activeChannels.first()
            launchYouTubeLive(defaultChan.youtube)
        }
    }

    fun launchYouTubeLive(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                setPackage("com.google.android.youtube.tv")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            try {
                val fallbackIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(fallbackIntent)
            } catch (ex: Exception) {
                Toast.makeText(context, "امکان اجرا وجود ندارد", Toast.LENGTH_LONG).show()
            }
        }
    }
}