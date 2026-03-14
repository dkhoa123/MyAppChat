package UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appchat.R
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun AddFriend(){
    Box(){
        Column(modifier = Modifier
            .width(360.dp)
            .height(800.dp)
            .background(Color(0xFF121212))
        ){
            Text("Mọi người",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp,top = 22.dp)
            )
            listAvatar()
            AllWelcome()
            LazyColumn {
                items(100){item ->
                    listFriend()}
            }

        }
    }
}

@Composable
fun AllWelcome(){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center){
        Box(modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0x99373737))
            .padding(horizontal = 10.dp, vertical = 4.dp)
        ){
            Text("Tất cả",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.width(40.dp))
        Box(modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0x99373737))
            .padding(horizontal = 10.dp, vertical = 4.dp)
        ){
            Text("Lời mời kết bạn",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun listFriend(){
        // chat item
        Row(modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth().height(50.dp)

        ) {
            Image(
                painterResource(R.drawable.image),
                null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.height(50.dp),
                verticalArrangement = Arrangement.Center) {
                Text("Mr Yang", fontSize = 16.sp, color = Color.White)
                Spacer(modifier = Modifier.height(6.dp))
                Text("Alrighty.", fontSize = 12.sp, color = Color.Gray)
            }
        }
}
@Preview(showBackground = true)
@Composable
fun PreviewAddFriend(){
    AppChatTheme {
        AddFriend()
    }
}
