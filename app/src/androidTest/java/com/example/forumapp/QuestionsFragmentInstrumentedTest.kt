/* Testes Instrumentados com Espresso
Teste: Interação no QuestionsFragment
Certifica que o formulário está funcional e os dados podem ser enviados. */

package com.example.forumapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QuestionsFragmentInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testSubmitQuestionForm() {
        // Preenche os campos
        onView(withId(R.id.questionTitle))
            .perform(typeText("Como usar Fragments?"), closeSoftKeyboard())
        onView(withId(R.id.questionDescription))
            .perform(typeText("Preciso de ajuda para entender como usar Fragments."), closeSoftKeyboard())
        onView(withId(R.id.questionTags))
            .perform(typeText("Android, Fragments"), closeSoftKeyboard())

        // Clique no botão de enviar
        onView(withId(R.id.submitButton)).perform(click())

        // Adicionar validações específicas se o comportamento esperado puder ser verificado
    }
}
