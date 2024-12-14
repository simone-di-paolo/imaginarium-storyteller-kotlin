package com.example.imaginariumstoryteller

import android.R.attr.max
import android.R.attr.min
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartScreen()
        }
    }
}

@Composable
fun StartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.baked_goods_1), // Replace with your logo
            contentDescription = "App Logo",
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Start creating a prompt",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(32.dp))
        // Display a simple prompt here
        Text(
            text = "The [quick] brown fox [jumps] over the [lazy] dog.",
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 40.sp, // Set line height to 30sp
                textAlign = TextAlign.Center, // Apply center alignment
                fontSize = 24.sp // Set font size to 24sp
            ),
            modifier = Modifier.widthIn(min = 175.dp, max = 250.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { /* Navigate to prompt creation screen */ }) {
            Text("Create")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StartScreen()
}