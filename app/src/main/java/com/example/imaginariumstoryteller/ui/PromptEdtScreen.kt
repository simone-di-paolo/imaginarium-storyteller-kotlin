package com.example.imaginariumstoryteller.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imaginariumstoryteller.ui.theme.ImaginariumStorytellerTheme

@Composable
fun PromptEditScreen(navController: NavHostController) {

    BackHandler {
        navController.popBackStack()
    }

    var promptText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = promptText,
            onValueChange = { promptText = it },
            label = { Text("Prompt") }
        )
        Button(onClick = {}) {
            Text("Create")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PromptEditScreenPreview() {
    ImaginariumStorytellerTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "main") {
            composable("main") { StartScreen(navController) }
            composable("prompt_edit") { PromptEditScreen(navController) }
        }
    }
}