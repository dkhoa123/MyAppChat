package com.example.appchat.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun Home(navController: NavController){
    var text by remember { mutableStateOf("Search for a chat...") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)),
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Heading(modifier = Modifier.padding(top = 22.dp))
            Box(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .width(320.dp).height(30.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White),
                contentAlignment = Alignment.CenterStart
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.padding(start = 10.dp)

                )
            }
            listAvatar()
            LazyColumn {
                items(100) { item ->
                    SwipeChatItem()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview3(){
    AppChatTheme {
        val navController = rememberNavController()
        Home(navController)
    }
}
