package com.example.forumapp.model

/* Essa classe data class representa uma pergunta obtida da API do Stack Overflow.
Ela inclui apenas o título da pergunta e o link, mas você pode expandir com mais informações se
precisar. */

data class Question(
    val title: String,
    val link: String
)
