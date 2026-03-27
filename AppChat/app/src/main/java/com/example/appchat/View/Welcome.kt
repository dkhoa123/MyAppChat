package com.example.appchat.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appchat.R
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun Welcome(){
    Column(Modifier
        .width(360.dp)
        .height(800.dp)
        .background(Color(0xFF121212)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(painterResource(id = R.drawable.illustration),
            contentDescription = "hinh minh hoa",
            modifier = Modifier
                .padding(top = 129.dp)
                .width(262.dp)
                .height(271.dp)
            )
        Text(text = "Break the boundaries and connect with people all over the world",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 28.dp)
                .width(256.dp)
        )

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .padding(top = 88.dp)
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
            Text(text = "Get Started")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    AppChatTheme {
        Welcome()
    }
}