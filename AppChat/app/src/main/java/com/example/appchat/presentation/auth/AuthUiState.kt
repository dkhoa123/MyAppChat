package com.example.appchat.presentation.auth

data class AuthUiState(
    val countryCode: String = "+84",
    val phoneLocal: String = "",
    val phoneE164: String = "",
    val verificationId: String? = null,
    val otp: String = "",
    val isLoading: Boolean = false,
    val message: String? = null,
    val isLoggedIn: Boolean = false
)