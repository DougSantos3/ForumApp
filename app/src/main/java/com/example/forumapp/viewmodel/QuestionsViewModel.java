package com.example.forumapp.viewmodel;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/* Modelo de dados para perguntas
* Esta classe é um ViewModel que realiza uma chamada à API do Stack Exchange para buscar perguntas. Usamos a biblioteca Retrofit para a requisição de rede.
* Explicação
fetchQuestions(tag: String): Esta função é chamada para buscar perguntas que possuem a tag especificada (exemplo: "kotlin"). Ela usa o Retrofit para fazer a requisição e atualiza questionsLiveData com os resultados.
StackExchangeApi: Interface do Retrofit com um endpoint da API do Stack Exchange, configurado para obter perguntas.
StackResponse e Question: Representam a estrutura dos dados que a API retorna.
* */
data class Question(
        val title: String,
        val link: String
)

// Interface para Retrofit
interface StackExchangeApi {
    @GET("/2.3/questions?order=desc&sort=activity&site=stackoverflow")
    suspend fun getQuestions(@Query("tagged") tag: String): StackResponse
}

data class StackResponse(
        val items: List<Question>
)

class QuestionsViewModel : ViewModel() {
    private val _questionsLiveData = MutableLiveData<List<Question>>()
    val questionsLiveData: LiveData<List<Question>> = _questionsLiveData

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val api = retrofit.create(StackExchangeApi::class.java)

    fun fetchQuestions(tag: String) {
        viewModelScope.launch {
            try {
                val response = api.getQuestions(tag)
                _questionsLiveData.value = response.items
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
