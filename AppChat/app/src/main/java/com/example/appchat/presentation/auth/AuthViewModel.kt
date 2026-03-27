package com.example.appchat.presentation.auth

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.example.appchat.domain.PhoneAuthRepository
import com.google.firebase.auth.PhoneAuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repo: PhoneAuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AuthUiState())
    val state: StateFlow<AuthUiState> = _state

    fun onPhoneChanged(value: String) {
        // chỉ lấy số, bạn có thể chặn ký tự không phải digit
        _state.update { it.copy(phoneLocal = value, message = null) }
    }

    fun onOtpChanged(value: String) {
        _state.update { it.copy(otp = value, message = null) }
    }

    private fun buildE164(countryCode: String, phoneLocal: String): String {
        // VN thường nhập 0xxx -> đổi thành +84xxx (bỏ số 0 đầu)
        val raw = phoneLocal.trim().replace(" ", "")
        val normalized = if (raw.startsWith("0")) raw.drop(1) else raw
        return countryCode + normalized
    }

    fun sendOtp(activity: Activity) {
        val s = _state.value
        val e164 = buildE164(s.countryCode, s.phoneLocal)

        if (s.phoneLocal.length < 8) {
            _state.update { it.copy(message = "Số điện thoại chưa hợp lệ", isLoading = false) }
            return
        }

        _state.update { it.copy(isLoading = true, message = null, phoneE164 = e164) }

        repo.sendOtp(
            activity = activity,
            phoneNumberE164 = e164,
            onCodeSent = { verificationId ->
                _state.update { it.copy(isLoading = false, verificationId = verificationId, message = "Đã gửi OTP") }
            },
            onAutoVerified = { credential: PhoneAuthCredential ->
                repo.signInWithCredential(
                    credential,
                    onSuccess = {
                        _state.update { it.copy(isLoading = false, isLoggedIn = true, message = "Đăng nhập thành công") }
                    },
                    onError = { e ->
                        _state.update { it.copy(isLoading = false, message = e.message ?: "Login error") }
                    }
                )
            },
            onError = { e ->
                _state.update { it.copy(isLoading = false, message = e.message ?: "Send OTP failed") }
            }
        )
    }

    fun verifyOtp() {
        val s = _state.value
        val vid = s.verificationId

        if (vid.isNullOrBlank()) {
            _state.update { it.copy(message = "Chưa gửi OTP hoặc thiếu verificationId") }
            return
        }
        if (s.otp.length < 6) {
            _state.update { it.copy(message = "OTP chưa đủ") }
            return
        }

        _state.update { it.copy(isLoading = true, message = null) }

        repo.verifyOtp(
            verificationId = vid,
            otp = s.otp,
            onSuccess = {
                _state.update { it.copy(isLoading = false, isLoggedIn = true, message = "Đăng nhập thành công") }
            },
            onError = { e ->
                _state.update { it.copy(isLoading = false, message = e.message ?: "Verify failed") }
            }
        )
    }
}