package com.example.appchat

import UI.Home
import UI.PersionalChat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.appchat.ui.theme.AppChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            AppChatTheme {
                Surface(modifier = Modifier.fillMaxSize())
                {
                    PersionalChat()
                }
            }
        }
    }
}
