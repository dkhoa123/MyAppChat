package com.example.appchat.presentation.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appchat.presentation.auth.AuthViewModel
import com.example.appchat.View.Login
import com.example.appchat.View.UserSetting
import com.example.appchat.View.Verification

@Composable
fun AuthNavHost(navController: NavHostController) {
    val vm: AuthViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) {
            Login(
                vm = vm,
                onOtpSentGoVerify = { navController.navigate(Routes.VERIFY) }
            )
        }
        composable(Routes.VERIFY) {
            Verification(
                vm = vm,
                onVerified = {
                    navController.navigate(Routes.USER_SETTING) {
                        // xóa stack Login + Verify
                        popUpTo(Routes.LOGIN) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(Routes.USER_SETTING) {
            UserSetting()
        }
    }
}