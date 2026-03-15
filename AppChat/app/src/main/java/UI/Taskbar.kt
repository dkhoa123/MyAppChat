package UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.appchat.R

@Composable
fun Taskbar(modifier: Modifier = Modifier){
    Box(modifier = modifier
    ){
        Row(Modifier
            .fillMaxWidth().height(85.dp)
            .background(Color(0x99111111)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.message),
                null,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.size(24.dp).shadow(
                    elevation =10.dp,
                    shape = CircleShape,
                    ambientColor = Color.White,
                    spotColor = Color.White)
            )
            Spacer(modifier = Modifier.width(45.dp))
            Image(
                painterResource(id = R.drawable.people),
                null,
                colorFilter = ColorFilter.tint(Color(0xff676E75)),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(45.dp))
            Image(
                painterResource(id = R.drawable.compassicon),
                null,
                colorFilter = ColorFilter.tint(Color(0xff676E75)),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskbar(){
    Taskbar(modifier = Modifier)
}