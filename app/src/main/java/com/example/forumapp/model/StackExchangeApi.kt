package com.example.forumapp.model

import retrofit2.http.GET
import retrofit2.http.Query

/* Modelo de resposta para a API *

Esta interface define o serviço da API usando o Retrofit. Ela inclui um endpoint para buscar
perguntas com uma tag específica
StackExchangeApi: Interface para Retrofit com uma função getQuestions() que faz uma chamada à API
para buscar perguntas por tag. @Query("tagged") permite que você filtre as perguntas pela tag
desejada (por exemplo, kotlin). */

data class StackResponse(
    val items: List<Question>
)

interface StackExchangeApi {
    @GET("/2.3/questions?order=desc&sort=activity&site=stackoverflow")
    suspend fun getQuestions(@Query("tagged") tag: String): StackResponse
}
