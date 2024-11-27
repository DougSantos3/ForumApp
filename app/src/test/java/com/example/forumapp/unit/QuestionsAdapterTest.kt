package com.example.forumapp.unit

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.TextView
import com.example.forumapp.adapter.QuestionsAdapter
import com.example.forumapp.model.Question
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.argumentCaptor

class QuestionsAdapterTest {

    @Test
    fun `bind sets title correctly`() {
        // Arrange
        val question = Question("Sample Title", "https://example.com")
        val mockView = mock(View::class.java)
        val mockTextView = mock(TextView::class.java)
        `when`(mockView.findViewById<TextView>(android.R.id.text1)).thenReturn(mockTextView)

        val viewHolder = QuestionsAdapter(mockListOf()).QuestionViewHolder(mockView)

        // Act
        viewHolder.bind(question)

        // Assert
        verify(mockTextView).text = "Sample Title"
    }

    @Test
    fun `bind sets click listener correctly`() {
        // Arrange
        val question = Question("Sample Title", "https://example.com")
        val mockContext = mock(Context::class.java)
        val mockView = mock(View::class.java)
        `when`(mockView.context).thenReturn(mockContext)
        val viewHolder = QuestionsAdapter(mockListOf()).QuestionViewHolder(mockView)

        // Act
        viewHolder.bind(question)
        viewHolder.itemView.performClick()

        // Assert
        val intentCaptor = argumentCaptor<Intent>()
        verify(mockContext).startActivity(intentCaptor.capture())
        assertEquals(Intent.ACTION_VIEW, intentCaptor.value.action)
        assertEquals(Uri.parse("https://example.com"), intentCaptor.value.data)
    }
}
