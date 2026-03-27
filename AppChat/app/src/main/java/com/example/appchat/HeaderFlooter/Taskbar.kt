package com.example.appchat.HeaderFlooter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appchat.R

val items = listOf(
    Triple(R.drawable.message, "", "home") ,
    Triple(R.drawable.people, "", "addfriend"),
    Triple(R.drawable.compassicon, "", "settings")
)
@Composable
fun Taskbar(modifier: Modifier = Modifier,
            currentRouter: String,
            navController: NavController) {
    Box(
        modifier = modifier
    ) {
            Row(
                Modifier
                    .fillMaxWidth().height(85.dp)
                    .background(Color(0xFF111111)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items.forEach { (iconRes,label, router) ->
                    val isSelection = currentRouter == router
                Image(
                    painterResource(id = iconRes),
                    null,
                    colorFilter = if (isSelection) {ColorFilter.tint(Color.White)} else{ ColorFilter.tint(Color(0xff676E75))},
                    modifier = if(isSelection){ Modifier.size(30.dp).shadow(
                        elevation = 10.dp,
                        shape = CircleShape,
                        ambientColor = Color.White,
                        spotColor = Color.White)
                    }
                        else{
                        Modifier.size(30.dp)
                        }
                        .clickable{
                            if(currentRouter != router){
                                navController.navigate(router){
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskbar(){
    Taskbar(modifier = Modifier, currentRouter = "home",
        navController = rememberNavController())
}