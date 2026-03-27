package com.example.appchat.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appchat.R
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun Heading(modifier: Modifier = Modifier){
    Box(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color(0xFF121212))
                .padding(horizontal = 10.dp)
                .height(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Chatee",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF0062C0),
                            Color(0xFF48A7FF)
                        )
                    )
                )
            )
            Spacer(Modifier.weight(1f))
            Row() {
                Image(
                    painterResource(id = R.drawable.chat_plus_fill),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
                Image(
                    painterResource(id = R.drawable.more_vert),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreHead(){
    AppChatTheme {
        Heading(modifier = Modifier)
    }
}