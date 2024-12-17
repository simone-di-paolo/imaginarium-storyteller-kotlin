package com.example.imaginariumstoryteller.data

data class Prompt(
    val start: String,
    var adjective1: String,
    val subject: String,
    var verb: String,
    val prepositionalPhrase: String,
    var adjective2: String,
    val otherSubject: String
)