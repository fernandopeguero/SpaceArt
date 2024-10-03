package com.example.spaceart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceart.ui.theme.SpaceArtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceArtTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SpaceArtApp(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SpaceArtApp(modifier: Modifier = Modifier) {

    var currentPosition by remember { mutableIntStateOf(0) }

    val currentImage = when (currentPosition) {
        0 -> R.drawable.astronaut_moon
        1 -> R.drawable.beaitful_sunset
        2 -> R.drawable.rocket
        3 -> R.drawable.shooting_starts
        4 -> R.drawable.space_launch
        5 -> R.drawable.space_rocket
        else -> R.drawable.starry_sky
    }

    val description = when (currentPosition) {
        0 -> stringResource(id = R.string.astronaut_in_the_moon)
        1 -> stringResource(id = R.string.shooting_start_sunset)
        2 -> stringResource(id = R.string.space_rocket)
        3 -> stringResource(id = R.string.shooting_starts)
        4 -> stringResource(id = R.string.space_launch)
        5 -> stringResource(id = R.string.space_rocket_sky)
        else -> stringResource(id = R.string.starry_sky)

    }

    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = description,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = description,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Button(
                    onClick = {

                        if (currentPosition == 0) {
                            currentPosition = 6
                        } else {
                            currentPosition--
                        }
                    }
                ) {
                    Text(text = stringResource(R.string.previous_button))
                }

                Button(
                    onClick = {
                        if (currentPosition == 6) {
                            currentPosition = 0
                        } else {
                            currentPosition++
                        }
                    }
                ) {
                    Text(
                        text = stringResource(R.string.next_button)
                    )
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewSpaceArt() {

    SpaceArtTheme {

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSpaceArtDark() {

    SpaceArtTheme(darkTheme = true) {
        SpaceArtApp()
    }
}