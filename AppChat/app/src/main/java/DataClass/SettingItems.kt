package DataClass

import android.media.Image
import androidx.compose.ui.graphics.Color

data class SettingItems(
    val iconbg: Color = Color.White,
    val icon: Int,
    val text: String,
    val value: String? = null,
    val hasSwitch: Boolean = false
)
