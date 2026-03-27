package com.example.appchat.domain

import android.app.Activity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PhoneAuthRepository @Inject constructor(
    private val auth: FirebaseAuth
) {
    fun sendOtp(
        activity: Activity,
        phoneNumberE164: String,
        onCodeSent: (verificationId: String) -> Unit,
        onAutoVerified: (PhoneAuthCredential) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                onAutoVerified(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                onError(e)
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                onCodeSent(verificationId)
            }
        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumberE164)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(callbacks)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun signInWithCredential(
        credential: PhoneAuthCredential,
        onSuccess: (FirebaseUser) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        auth.signInWithCredential(credential)
            .addOnSuccessListener { result ->
                val user = result.user
                if (user != null) onSuccess(user) else onError(IllegalStateException("User null"))
            }
            .addOnFailureListener(onError)
    }

    fun verifyOtp(
        verificationId: String,
        otp: String,
        onSuccess: (FirebaseUser) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val credential = PhoneAuthProvider.getCredential(verificationId, otp)
        signInWithCredential(credential, onSuccess, onError)
    }
}