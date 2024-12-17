package com.example.imaginariumstoryteller.ui

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.example.imaginariumstoryteller.data.Prompt
import com.example.imaginariumstoryteller.data.PromptWordType

@Composable
fun PromptText(prompt: Prompt, onWordClick: (PromptWordType) -> Unit) {
    val annotatedString = buildAnnotatedString {
        append(prompt.start)
        // Aggiungi un LinkAnnotation per la parola cliccabile
        pushStringAnnotation(
            tag = "adjective1",
            annotation = "adjective1"
        )
        withStyle(
            style = SpanStyle(
                color = Color.Blue, // Personalizza lo stile del link
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(" ${prompt.adjective1} ")
        }
        pop()
        // ... continua per le altre parti del prompt ...
    }

    Text(
        text = annotatedString,
        modifier = Modifier.clickable {
            // Gestisci il click sul testo
            val adjective1Annotation = annotatedString
                .getStringAnnotations(tag = "adjective1", start = 0, end = annotatedString.length)
                .firstOrNull()
            if (adjective1Annotation != null) {
                onWordClick(PromptWordType.Adjective1)
            }
        }
    )
}