package UI

import DataClass.SettingItems
import HeaderFlooter.Taskbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appchat.R
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun Settings(navController: NavController,items: List<SettingItems>){
    Box(Modifier
        .fillMaxSize()
        .background(Color(0xFF121212))
    ){
       Column(Modifier.padding(top = 22.dp)
       ){
            HeadSetting()
           Spacer(Modifier.height(10.dp))
           items.forEach {
               OptionSetting(items = it)
               Spacer(Modifier.height(10.dp))
           }
       }
    }
}

@Composable
fun HeadSetting(){
        Spacer(Modifier.height(10.dp))
        Row(Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically){
            Image(painterResource(id = R.drawable.image1),null,
                Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(10.dp))
            Column() {
                Text("Stelle",
                    fontWeight = FontWeight.Bold,
                    color = Color.White )
                Text("+1 202 555 0147",
                    color = Color(0x80FFFFFF))
            }
        }
}

val settings = listOf(
    SettingItems(Color(0x99FFFFFF),R.drawable.darkmode, text = "Dark Mode", hasSwitch = true),
    SettingItems(Color(0xFF5AD439),R.drawable.useronline, text = "Active Status", "On"),
    SettingItems(Color(0xFFFE294D),R.drawable.email, text = "Username","Stella"),
    SettingItems(Color(0xFF0084FE),R.drawable.call, text = "Number Phone", "+1 202 555 0147"),
    SettingItems(Color(0xFF00BFFF),R.drawable.people, text = "People")


)
@Composable
fun OptionSetting(items: SettingItems){
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.Black)
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(Modifier
                .clip(CircleShape)
                .size(40.dp)
                .background(items.iconbg),
                contentAlignment = Alignment.Center
                ) {
                Image(
                    painterResource(id = items.icon), null,
                    Modifier.size(18.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
            Spacer(Modifier.width(10.dp))
            Text(items.text,
                fontSize = 17.sp,
                color = Color.White
            )
            Spacer(Modifier.weight(1f))
            if(items.hasSwitch){
                Switch(checked = true,
                    onCheckedChange = {},
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color(0xFF34C759),   // nền khi bật
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.Gray         // nền khi tắt
                    ))
            }
            else if(items.value != null){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(items.value, color = Color.Gray)
                    Spacer(Modifier.width(10.dp))
                    Image(painterResource(id =R.drawable.extend),null,
                        modifier = Modifier.width(8.dp).height(12.dp),
                        colorFilter = ColorFilter.tint(Color(0x80FFFFFF))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSetting(){
    AppChatTheme {
        val navController = rememberNavController()
        Settings(navController = navController,items = settings)
    }
}