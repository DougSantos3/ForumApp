/* Teste: Campos Obrigatórios no MainFragment
Simula a interação com o botão de envio e valida campos vazios: */

package com.example.forumapp.instrumented

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.forumapp.MainActivity
import com.example.forumapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testSubmitButtonWithoutData() {
        // Simula o clique no botão sem preencher os campos
        onView(withId(R.id.buttonSubmit)).perform(click())

        // Verifica se os campos ainda estão visíveis (indicando que o envio falhou)
        onView(withId(R.id.editTextName)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextDateOfBirth)).check(matches(isDisplayed()))
    }
}
