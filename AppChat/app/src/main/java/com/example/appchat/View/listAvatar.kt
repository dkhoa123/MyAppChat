package com.example.appchat.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appchat.R

@Composable
fun listAvatar(){
    LazyRow(modifier = Modifier
        .padding(horizontal = 10.dp)
        .fillMaxWidth().height(90.dp)
        .background(Color(0xFF121212)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item{
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painterResource(id = R.drawable.plusstory),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Text(
                    text = "Your Story",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
        items(5) { item ->
            Column(horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Hacker Girl",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}