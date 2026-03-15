package UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appchat.R
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun PersionalChat(){
    Box(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff121212))
                .padding(top = 22.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()
                .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(Icons.Default.ArrowBack,
                    null,
                    tint = Color(0xff19A3FE),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(10.dp))
                Image(painterResource(id = R.drawable.image),
                    null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(10.dp))
                Column {
                    Text("Hacker Girl",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text("Hacker Girl",
                        fontSize = 13.sp,
                        color = Color.White
                    )
                }
                Spacer(Modifier.weight(1f))
                Row(Modifier.padding(end = 15.dp),
                    verticalAlignment = Alignment.CenterVertically ){
                    Icon(Icons.Default.Call,null,
                        modifier = Modifier.size(30.dp),
                        tint = Color(0xff19A3FE)
                    )
                    Spacer(Modifier.width(10.dp))
                    Image(painterResource(id = R.drawable.videocall),
                        null,
                        modifier = Modifier.size(35.dp),
                        colorFilter = ColorFilter.tint(Color(0xff19A3FE)))
                }
            }
        }
        FrameChat(Modifier.align(Alignment.BottomCenter))
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewPerChat(){
    AppChatTheme {
        PersionalChat()
    }
}