/* Criamos um teste para validar se os campos de texto estão visíveis e habilitados: */

package com.example.forumapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QuestionsFragmentTest {

    @Test
    fun testFieldsAreVisibleAndEnabled() {
        val scenario = launchFragmentInContainer<QuestionsFragment>()

        scenario.onFragment { fragment ->
            val titleField = fragment.view?.findViewById<EditText>(R.id.questionTitle)
            val descriptionField = fragment.view?.findViewById<EditText>(R.id.questionDescription)
            val tagsField = fragment.view?.findViewById<EditText>(R.id.questionTags)
            val submitButton = fragment.view?.findViewById<Button>(R.id.submitButton)

            // Verifica se os campos estão visíveis e habilitados
            assertNotNull(titleField)
            assertNotNull(descriptionField)
            assertNotNull(tagsField)
            assertNotNull(submitButton)

            assertTrue(titleField!!.isEnabled)
            assertTrue(descriptionField!!.isEnabled)
            assertTrue(tagsField!!.isEnabled)
            assertTrue(submitButton!!.isEnabled)
        }
    }
}
