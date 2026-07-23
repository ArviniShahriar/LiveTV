package com.tvlive.launcher

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val youtubeUrl = "https://www.youtube.com/live/5JDxjsAVaGk?is=9k9ureil8hqB9cwj"
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl)).apply {
                setPackage("com.google.android.youtube.tv")
            }
            startActivity(intent)
        } catch (e: Exception) {
            val fallbackIntent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            startActivity(fallbackIntent)
        }
        finish()
    }
}
