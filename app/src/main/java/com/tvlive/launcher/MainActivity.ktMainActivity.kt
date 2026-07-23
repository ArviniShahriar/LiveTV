package com.tvlive.launcher

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val youtubeUrl = "https://www.youtube.com/live/5JDxjsAVaGk?is=9k9ureil8hqB9cwj"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))

        try {
            // 1. Försök öppna i SmartTube (reklamfritt)
            intent.setPackage("com.teamsmart.videomanager.tv")
            startActivity(intent)
        } catch (e1: Exception) {
            try {
                // 2. Om SmartTube saknas, öppna i officiella YouTube TV
                intent.setPackage("com.google.android.youtube.tv")
                startActivity(intent)
            } catch (e2: Exception) {
                // 3. Om inget av dem finns, öppna med standardwebbläsare/system
                intent.setPackage(null)
                startActivity(intent)
            }
        }
        
        finish()
    }
}
