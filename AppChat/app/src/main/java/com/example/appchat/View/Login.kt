package com.example.appchat.View

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appchat.presentation.auth.AuthViewModel
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun Login(vm: AuthViewModel, onOtpSentGoVerify: () -> Unit)
{
    val state by vm.state.collectAsState()
    val context = LocalContext.current
    val activity = context as? Activity

    // Nếu verificationId đã có -> chuyển màn Verify
    LaunchedEffect(state.verificationId) {
        if (state.verificationId != null) onOtpSentGoVerify()
    }
    Column(Modifier
        .fillMaxSize()
        .background(Color(0xFF121212)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Enter your phone number",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)

        CountryPicker(
            phone = state.phoneLocal,
            onPhoneChange = vm::onPhoneChanged
        )
        if (state.message != null) {
            Spacer(Modifier.height(12.dp))
            Text(state.message!!, color = Color(0xFF48A7FF))
        }
        Button(onClick = {if (activity != null) vm.sendOtp(activity)},
            enabled = !state.isLoading && activity != null,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .padding(top = 75.dp)
                .width(280.dp).height(50.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF0062C0),
                            Color(0xFF48A7FF)
                        )
                    )
                )
        )
        {
            Text(text = "Continue")
        }
    }
}

@Composable
fun CountryPicker(
    phone: String, onPhoneChange: (String) -> Unit
) {
    Row(Modifier.padding(top = 35.dp)) {
        Row(
            Modifier
                .width(70.dp)
                .height(35.dp)
                .background(Color(0xCCFFFFFF), RoundedCornerShape(8.dp))
                .padding(horizontal = 7.dp, vertical = 4.dp)
        ) {
            Text(text = "VN")
            Spacer(Modifier.weight(1f))
            Text(text = "+84")
        }
        Spacer(Modifier.width(10.dp))

        BasicTextField(
            value = phone,
            onValueChange = onPhoneChange,
            modifier = Modifier
                .width(220.dp)
                .height(35.dp)
                .background(Color.White, RoundedCornerShape(6.dp))
                .padding(horizontal = 8.dp),
            decorationBox = { innerTextField ->
                Box(
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (phone.isEmpty()) {
                        Text("Phone Number", color = Color.Gray)
                    }
                    innerTextField()
                }
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Preview(){
    AppChatTheme {
//        Login()
    }
}
