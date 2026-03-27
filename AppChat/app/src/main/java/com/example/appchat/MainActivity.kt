package com.example.appchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.appchat.presentation.nav.AuthNavHost
import com.example.appchat.ui.theme.AppChatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppChatTheme {
                val navController = rememberNavController()
                AuthNavHost(navController)
            }
        }
    }
}