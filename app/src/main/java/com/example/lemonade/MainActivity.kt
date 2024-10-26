package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeView(modifier: Modifier = Modifier) {
    val result = remember { mutableStateOf(1) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        val imageResource = when (result.value) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        val txt = when (result.value) {
            1 -> "Tap the lemon tree to select a lemon"
            2 -> "Keep tapping the lemon to squeeze it"
            3 -> "Tap the lemonade to drink it"
            else -> "Tap the empty glass to start again"
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFCCFFC7)
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(8.dp),
            onClick = {
                result.value = if (result.value < 4) result.value + 1 else 1
            }
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = txt
            )
        }
        Text(
            text = txt,
            fontSize = 18.sp

        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        LemonadeView(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}

