package com.tvlive.launcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var channelManager: ChannelManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        channelManager = ChannelManager(this)

        val defaultChannels = listOf(
            Channel(
                name = "Iran International",
                live = true,
                youtube = "https://www.youtube.com/live/5JDxjsAVaGk?is=9k9ureil8hqB9cwj",
                default = true
            )
        )

        channelManager.handleChannels(defaultChannels)
    }
}