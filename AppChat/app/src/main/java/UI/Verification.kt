package UI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun Verification(){
    Column(
        Modifier
        .width(360.dp)
        .height(800.dp)
        .background(Color(0xFF121212)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Enter your verification code",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "We have sent a verification code to +62 812 3456 7890",
            color = Color.LightGray,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(250.dp).height(44.dp)
        )

        OTPTextField { otp ->
            println("OTP: $otp")
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .padding(top = 30.dp)
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
        Row(
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Haven’t received the code? ",
                color = Color.White,
                fontSize = 12.sp
            )
            TextButton(onClick = {},
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("Resend code",
                    fontSize = 12.sp,
                    color = Color(0xFF428DFE)
                    )
            }
        }
    }
}


@Composable
fun OTPTextField(
    otpLength: Int = 4,
    onOtpComplete: (String) -> Unit
) {

    val focusRequesters = List(otpLength) { FocusRequester() }
    val otpValues = remember { mutableStateListOf("", "", "", "") }

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
    ) {

        repeat(otpLength) { index ->

            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(50.dp)
                    .background(Color.LightGray, RoundedCornerShape(5.dp)),
                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    value = otpValues[index],
                    onValueChange = { value ->

                        if (value.length <= 1) {

                            otpValues[index] = value

                            if (value.isNotEmpty() && index < otpLength - 1) {
                                focusRequesters[index + 1].requestFocus()
                            }

                            if (otpValues.joinToString("").length == otpLength) {
                                onOtpComplete(otpValues.joinToString(""))
                            }
                        }
                    },

                    modifier = Modifier
                        .focusRequester(focusRequesters[index]),

                    textStyle = TextStyle(
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center
                    ),

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),

                    singleLine = true
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Preview1(){
    AppChatTheme {
        Verification()
    }
}