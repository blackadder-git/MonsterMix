package com.example.monstermix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monstermix.ui.theme.MonsterMixTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonsterMixTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //val topImageList = listOf("top_green", "top_red", "top_yellow", "top_blue")
                    //val midImageList = listOf("mid_green", "mid_red", "mid_yellow", "mid_blue")
                    //val botImageList = listOf("bot_green", "bot_red", "bot_yellow", "bot_blue")

                    val topImageList = listOf("top_mummy", "top_fire")
                    val midImageList = listOf("mid_mummy", "mid_fire")
                    val botImageList = listOf("bot_mummy", "bot_fire")

                    ShowMonster(topImageList, midImageList, botImageList)
                }
            }
        }
    }
}

@Composable
fun ShowMonster(topImageList: List<String>, midImageList: List<String>, botImageList: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Text(text = "Test")

        // top image
        var topImageIndex by remember { mutableStateOf(0) }
        val topImageName = topImageList[topImageIndex]
        val topImage: Painter = painterResource(id = getResourceIdByName(topImageName))

        Image(
            painter = topImage, // painterResource(id = R.drawable.top_green),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clickable {
                    // ensure wrap around
                    topImageIndex = (topImageIndex + 1) % topImageList.size
                },
            contentScale = ContentScale.Crop
        )

        // middle image
        var midImageIndex by remember { mutableStateOf(0) }
        val midImageName = midImageList[midImageIndex]
        val midImage: Painter = painterResource(id = getResourceIdByName(midImageName))

        Image(
            painter = midImage, // painterResource(id = R.drawable.mid_green),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clickable {
                    midImageIndex = (midImageIndex + 1) % midImageList.size
                },
            contentScale = ContentScale.Crop
        )

        // bottom image
        var botImageIndex by remember { mutableStateOf(0) }
        val botImageName = botImageList[botImageIndex]
        val botImage: Painter = painterResource(id = getResourceIdByName(botImageName))
        Image(
            painter = botImage, // painterResource(id = R.drawable.bot_green),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clickable {
                    botImageIndex = (botImageIndex + 1) % botImageList.size
                },
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMonsterPreview() {
    MonsterMixTheme {
        // this feels redundant ???
        //val topImageList = listOf("top_green", "top_red", "top_yellow", "top_blue")
        //val midImageList = listOf("mid_green", "mid_red", "mid_yellow", "mid_blue")
        //val botImageList = listOf("bot_green", "bot_red", "bot_yellow", "bot_blue")

        val topImageList = listOf("top_mummy", "top_fire")
        val midImageList = listOf("mid_mummy", "mid_fire")
        val botImageList = listOf("bot_mummy", "bot_fire")

        ShowMonster(topImageList, midImageList, botImageList)
    }
}

fun getResourceIdByName(name: String): Int {
    return when (name) {
        "top_green" -> R.drawable.top_green
        "top_red" -> R.drawable.top_red
        "top_yellow" -> R.drawable.top_yellow
        "top_blue" -> R.drawable.top_blue
        "mid_green" -> R.drawable.mid_green
        "mid_red" -> R.drawable.mid_red
        "mid_yellow" -> R.drawable.mid_yellow
        "mid_blue" -> R.drawable.mid_blue
        "bot_green" -> R.drawable.bot_green
        "bot_red" -> R.drawable.bot_red
        "bot_yellow" -> R.drawable.bot_yellow
        "bot_blue" -> R.drawable.bot_blue
        "top_mummy" -> R.drawable.top_mummy
        "mid_mummy" -> R.drawable.mid_mummy
        "bot_mummy" -> R.drawable.bot_mummy
        "top_fire" -> R.drawable.top_fire
        "mid_fire" -> R.drawable.mid_fire
        "bot_fire" -> R.drawable.bot_fire
        else -> 0 // Handle the case when the image name is not found
    }
}