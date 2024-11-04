/* Aqui está como o MainActivity.kt ficaria para gerenciar o formulário que criamos em
    activity_main.xml. Esse código captura os dados de cada campo de entrada
    (nome, email e data de nascimento) e exibe uma mensagem de confirmação usando Toast quando o
     botão de envio é clicado.


    Configuração do Layout: setContentView(R.layout.activity_main) define activity_main.xml como o
    layout da atividade.

    Referência aos Elementos do Layout: Usamos findViewById para associar cada EditText e o Button
    do layout XML com variáveis Kotlin. Isso nos permite acessar e manipular os elementos
    diretamente no código.

    Ação de Clique no Botão: O método setOnClickListener define o que acontece quando o botão de
    envio é clicado:

    Capturamos os valores dos campos de texto.
    Verificamos se todos os campos estão preenchidos.
    Se tudo estiver preenchido, usamos um Toast para exibir os dados inseridos.
    Caso algum campo esteja vazio, mostramos uma mensagem solicitando o preenchimento completo do
    formulário.

    Observação
    Essa estrutura é básica para formular um comportamento simples. Mais tarde, você pode melhorar
    a validação, adicionar verificações específicas de formato (como para o email), ou até
    substituir o EditText da data de nascimento por um seletor de data para facilitar a entrada. */

package com.seuprojeto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referência aos elementos da interface
        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val dateOfBirthEditText = findViewById<EditText>(R.id.editTextDateOfBirth)
        val submitButton = findViewById<Button>(R.id.buttonSubmit)

        // Definir ação ao clicar no botão
        submitButton.setOnClickListener {
            // Capturar os valores dos campos
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val dateOfBirth = dateOfBirthEditText.text.toString()

            // Verificar se todos os campos estão preenchidos
            if (name.isNotEmpty() && email.isNotEmpty() && dateOfBirth.isNotEmpty()) {
                // Exibir mensagem com os dados preenchidos
                Toast.makeText(this, "Nome: $name\nEmail: $email\nData de Nascimento: $dateOfBirth", Toast.LENGTH_LONG).show()
            } else {
                // Mostrar mensagem de erro caso algum campo esteja vazio
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
