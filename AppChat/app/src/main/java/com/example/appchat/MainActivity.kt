package com.example.appchat

import HeaderFlooter.Taskbar
import UI.AddFriend
import UI.Home
import UI.PersionalChat
import UI.Settings
import UI.settings
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appchat.ui.theme.AppChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            AppChatTheme {
                Surface(modifier = Modifier.fillMaxSize())
                {
                    NavHome()
                }
            }
        }
    }
}
@Composable
fun NavHome(){
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.value?.destination?.route ?: "home"
    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") { Home(navController) }
            composable("addfriend") { AddFriend(navController) }
            composable("persionalChat") { PersionalChat(navController) }
            composable("settings") { Settings(navController, items = settings) }
        }
        Taskbar(Modifier.align(Alignment.BottomCenter),
            currentRoute,
            navController = navController)
    }
}