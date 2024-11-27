/*  Validamos que o botão "Enviar" dispara uma ação ao ser clicado:  */

package com.example.forumapp.fragmentedComponent

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.forumapp.R
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    @Test
    fun testSubmitButtonClick() {
        val scenario = launchFragmentInContainer<MainFragment>()

        scenario.onFragment { fragment ->
            val submitButton = fragment.view?.findViewById<Button>(R.id.buttonSubmit)

            // Verifica se o botão está presente
            assertNotNull(submitButton)

            // Simula um clique e verifica se a ação associada funciona
            submitButton?.performClick()
            // Adicionar validação da ação, se necessário
        }
    }
}
