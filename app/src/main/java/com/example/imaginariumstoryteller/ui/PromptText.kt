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
fun PromptText(
    prompt: Prompt,
    onWordClick: (PromptWordType) -> Unit,
    modifier: Modifier = Modifier
) {
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

        // subject
        append(prompt.subject)

        // verb
        pushStringAnnotation(tag = "verb", annotation = "verb")
        withStyle(
            style = SpanStyle(
                color = Color.Blue, // TODO personalizzare stile link
                textDecoration = TextDecoration.Underline
            )) {
            append(" ${prompt.verb}")
        }
        pop()

        // prepositional phrase
        append(prompt.prepositionalPhrase)

        // adjective 2
        pushStringAnnotation(tag = "adjective2", annotation = "adjective2")
        withStyle(
            style = SpanStyle(
                color = Color.Blue, // TODO personalizzare stile link
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(" ${prompt.adjective2} ")
        }
        pop()

        // other subject
        append(prompt.otherSubject)
    }

    Text(
        text = annotatedString,
        modifier = modifier.clickable { // Modificato qui!
            val annotations = annotatedString.getStringAnnotations(start = 0, end = annotatedString.length)
            annotations.forEach { range ->
                when (range.tag) {
                    "adjective1" -> onWordClick(PromptWordType.Adjective1)
                    "verb" -> onWordClick(PromptWordType.Verb)
                    "adjective2" -> onWordClick(PromptWordType.Adjective2)
                }
            }
        }
    )
}