package com.example.appchat.View

import androidx.compose.animation.core.tween
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appchat.R
import com.example.appchat.ui.theme.AppChatTheme

enum class DragState { // vị trí của container
    Left,
    Center,
    Right
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeChatItem() {

    val density = LocalDensity.current

    val decaySpec = remember(density) { splineBasedDecay<Float>(density) }

    val state = remember {
        AnchoredDraggableState(
            initialValue = DragState.Center,
            positionalThreshold = { it * 0.5f },
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            snapAnimationSpec = tween(),
            decayAnimationSpec = decaySpec,
            confirmValueChange = { true }
        )
    }

    val maxSwipe = with(density) { 180.dp.toPx() }

    LaunchedEffect(maxSwipe) {
        state.updateAnchors(
            DraggableAnchors {
                DragState.Left at -maxSwipe
                DragState.Center at 0f
                DragState.Right at maxSwipe
            }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        // background icons
        Row(
            Modifier
                .fillMaxSize()
                .background(Color(0xFF121212)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(Modifier.padding(start = 20.dp)) {
                Box(Modifier.size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0x33FFFFFF)),
                    contentAlignment = Alignment.Center) {
                    Image(
                        painterResource(id = R.drawable.camera),
                        null,
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(Modifier.width(16.dp))
                Box(Modifier.size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF0084FE)),
                    contentAlignment = Alignment.Center) {
                    Icon(
                        Icons.Default.Call, null,
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(Modifier.width(16.dp))
                Box(Modifier.size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0x33FFFFFF)),
                    contentAlignment = Alignment.Center) {
                    Image(
                        painterResource(id = R.drawable.videocall), null,
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Row(Modifier.padding(end = 20.dp)) {
                Box(Modifier.size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0x33FFFFFF)),
                    contentAlignment = Alignment.Center) {
                    Icon(Icons.Default.Menu,
                        null,
                        tint = Color.White)
                }
                Spacer(Modifier.width(16.dp))
                Box(Modifier.size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0x33FFFFFF)),
                    contentAlignment = Alignment.Center) {
                    Icon(
                        Icons.Default.Notifications,
                        null,
                        tint = Color.White
                    )
                }
                Spacer(Modifier.width(16.dp))
                Box(Modifier.size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFE294D)),
                    contentAlignment = Alignment.Center) {
                    Icon(
                        Icons.Default.Delete,
                        null,
                        tint = Color.White
                    )
                }
            }
        }

        // chat item
        Row(
            modifier = Modifier
                .offset { IntOffset(state.offset.toInt(), 0) }
                .anchoredDraggable(
                    state = state,
                    orientation = Orientation.Horizontal
                )
                .fillMaxSize()
                .background(Color(0xFF121212))
                .padding(16.dp)
        ) {

            Image(
                painterResource(R.drawable.image),
                null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Spacer(Modifier.width(12.dp))

            Column() {
                Text("Mr Yang", color = Color.White)
                Text("Alrighty.", color = Color.Gray)
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(modifier = Modifier.height(50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text("12 min", fontSize = 10.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .size(16.dp)
                    .background(Color(0xFF0084FE)),
                    contentAlignment = Alignment.Center
                ){
                    Text("1", fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        lineHeight = 10.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview4(){
    AppChatTheme {
        SwipeChatItem()
    }
}