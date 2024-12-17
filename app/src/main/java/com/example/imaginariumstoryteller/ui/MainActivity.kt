package com.example.imaginariumstoryteller.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imaginariumstoryteller.R
import com.example.imaginariumstoryteller.data.Prompt
import com.example.imaginariumstoryteller.data.PromptWordType
import com.example.imaginariumstoryteller.ui.theme.ImaginariumStorytellerTheme
import kotlin.collections.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") { StartScreen(navController) }
                composable("prompt_edit") { PromptEditScreen(navController) }
            }
        }
    }
}

@Composable
fun StartScreen(navController: NavHostController) {
    val promptState = remember { mutableStateOf(Prompt(
        start = "", // Inizializza con una stringa vuota
        adjective1 = "", // Inizializza con una stringa vuota
        subject = "", // Inizializza con una stringa vuota
        verb = "", // Inizializza con una stringa vuota
        prepositionalPhrase = "", // Inizializza con una stringa vuota
        adjective2 = "", // Inizializza con una stringa vuota
        otherSubject = "" // Inizializza con una stringa vuota
    )) }

    val prompt = promptState.value
    val promptStart = stringResource(id = R.string.prompt1_start)
    val adjectiveOptions = stringArrayResource(id = R.array.adjective_options)
    val subject = stringResource(id = R.string.prompt1_subject)
    val verbOptions = stringArrayResource(id = R.array.verb_options)
    val prepositionalPhrase = stringResource(id = R.string.prompt1_action)
    val adjective2Options = stringArrayResource(id = R.array.adjective2_options)
    val otherSubject = stringResource(id = R.string.prompt1_other_subject)

    LaunchedEffect(Unit) {
        promptState.value = Prompt(
            start = promptStart,
            adjective1 = adjectiveOptions[0], // Inizializza con il primo aggettivo
            subject = subject,
            verb = verbOptions[0], // Inizializza con il primo verbo
            prepositionalPhrase = prepositionalPhrase,
            adjective2 = adjective2Options[0], // Inizializza con il primo aggettivo2
            otherSubject = otherSubject
        )
    }


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
        Spacer(modifier = Modifier.height(32.dp))
        // Display a simple prompt here
        PromptText(
            prompt = prompt,
            onWordClick = { wordType ->
                // Gestisci il click sulla parola modificabile
                when (wordType) {
                    PromptWordType.Adjective1 -> {
                        // Logica per aggiornare prompt.adjective1
                        // ...
                    }
                    PromptWordType.Verb -> {
                        // Logica per aggiornare prompt.verb
                        // ...
                    }
                    PromptWordType.Adjective2 -> {
                        // Logica per aggiornare prompt.adjective2
                        // ...
                    }

                    PromptWordType.Adjective1 -> TODO()
                    PromptWordType.Verb -> TODO()
                    PromptWordType.Adjective2 -> TODO()
                }
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { navController.navigate("prompt_edit") }) {
            Text("Begin to create a story!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImaginariumStorytellerTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "main") {
            composable("main") { StartScreen(navController) }
            composable("prompt_edit") { PromptEditScreen(navController) }
        }
    }
}