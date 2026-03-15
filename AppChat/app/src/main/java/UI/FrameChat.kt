package UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appchat.R
import com.example.appchat.ui.theme.AppChatTheme

@Composable
fun FrameChat(modifier: Modifier){
    var text by remember { mutableStateOf("") }
    var isfocus by remember { mutableStateOf(false) }
    Box( modifier = modifier
    ){
        Row(Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
            if(!isfocus) {
                Image(
                    painterResource(id = R.drawable.fourcircle),
                    null,
                    colorFilter = ColorFilter.tint(Color(0xff19A3FE)),
                    modifier = Modifier.size(24.dp)
                )
                Image(
                    painterResource(id = R.drawable.camera),
                    null,
                    colorFilter = ColorFilter.tint(Color(0xff19A3FE)),
                    modifier = Modifier.size(24.dp)
                )
                Image(
                    painterResource(id = R.drawable.picture),
                    null,
                    modifier = Modifier.size(20.dp)
                )
                Image(
                    painterResource(id = R.drawable.audio),
                    null,
                    modifier = Modifier.size(20.dp)
                )
            } else {
                IconButton(onClick = { /* đóng keyboard */ }) {
                    Icon(Icons.Default.ArrowForward,
                        contentDescription = "",
                        tint = Color(0xff0084FE)
                    )
                }
            }
            Row(modifier = Modifier
                .weight(1f)
                .height(34.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(Color(0x33FFFFFF))
                .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                BasicTextField(
                    value = text,
                    onValueChange = {text = it},
                    modifier = Modifier
                        .onFocusChanged {
                        isfocus = it.isFocused
                    },
                    decorationBox = {innerTextField ->
                        if(text.isEmpty()){
                            Text("Nhập tin nhắn...", color = Color(0xff999999))
                        }
                        innerTextField()
                    }
                )
                Spacer(Modifier.weight(1f))
                Image(painterResource(id = R.drawable.icon),
                    null,
                    colorFilter = ColorFilter.tint(Color(0xff19A3FE)),
                    modifier = Modifier.size(23.dp))
            }
            Image(painterResource(id = R.drawable.like),
                null,
                modifier = Modifier.size(23.dp))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewFrameChat(){
    AppChatTheme {
        FrameChat(modifier = Modifier)
    }
}