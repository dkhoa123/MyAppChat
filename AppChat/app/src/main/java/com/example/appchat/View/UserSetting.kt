package com.example.appchat.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appchat.R
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun UserSetting(){
    var username by remember { mutableStateOf("Username") }
    Column(Modifier
        .fillMaxSize()
        .background(Color(0xFF121212)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box()
        {
            Image(painterResource(id = R.drawable.boy),
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
            )
            IconButton(onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = 10.dp, y = 10.dp)
            ){
                Image(painterResource(id = R.drawable.addpicture),
                    contentDescription = "icon",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Text("What should people call you?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top=10.dp, bottom = 10.dp)
        )
        Box(modifier = Modifier
            .width(300.dp)
            .height(35.dp)
            .background(Color.White),
            contentAlignment = Alignment.Center
        ){
            BasicTextField(
                value = username,
                onValueChange = {username = it},
                textStyle = TextStyle(
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    color = Color.Gray
                ),
                modifier = Modifier
                    .width(280.dp).height(22.dp)
            )
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
    }
}

@Preview(showBackground = true)
@Composable
fun Preview2(){
    AppChatTheme {
        UserSetting()
    }
}