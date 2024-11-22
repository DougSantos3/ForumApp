package com.example.forumapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_form)

        val questionTitle = findViewById<EditText>(R.id.questionTitle)
        val questionDescription = findViewById<EditText>(R.id.questionDescription)
        val questionTags = findViewById<EditText>(R.id.questionTags)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val title = questionTitle.text.toString().trim()
            val description = questionDescription.text.toString().trim()
            val tags = questionTags.text.toString().trim()

            if (title.isEmpty() || description.isEmpty() || tags.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                submitQuestion(title, description, tags)
            }
        }
    }

    private fun submitQuestion(title: String, description: String, tags: String) {
        /* Aqui você pode enviar os dados para um servidor ou para um banco de dados
         Este é apenas um exemplo de Toast para mostrar a confirmação */
        Toast.makeText(this, "Pergunta enviada com sucesso!", Toast.LENGTH_SHORT).show()
    }
}
