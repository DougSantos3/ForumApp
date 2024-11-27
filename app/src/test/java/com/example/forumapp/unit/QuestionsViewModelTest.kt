package com.example.forumapp.unit

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.forumapp.model.Question
import com.example.forumapp.viewmodel.QuestionsViewModel
import com.example.forumapp.viewmodel.StackExchangeApi
import com.example.forumapp.viewmodel.StackResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.*

@OptIn(ExperimentalCoroutinesApi::class)
class QuestionsViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val mockApi = mock<StackExchangeApi>()
    private val viewModel = QuestionsViewModel(mockApi)

    @Test
    fun `fetchQuestions updates LiveData with API results`() = runTest {
        // Arrange
        val questions = listOf(Question("Test Title", "https://example.com"))
        whenever(mockApi.getQuestions("kotlin")).thenReturn(StackResponse(questions))

        val observer = mock<Observer<List<Question>>>()
        viewModel.questionsLiveData.observeForever(observer)

        // Act
        viewModel.fetchQuestions("kotlin")

        // Assert
        verify(observer).onChanged(questions)
    }

    @Test
    fun `fetchQuestions handles API errors`() = runTest {
        // Arrange
        whenever(mockApi.getQuestions("kotlin")).thenThrow(RuntimeException("API error"))

        val observer = mock<Observer<List<Question>>>()
        viewModel.questionsLiveData.observeForever(observer)

        // Act
        viewModel.fetchQuestions("kotlin")

        // Assert
        verify(observer, never()).onChanged(any())
    }
}
