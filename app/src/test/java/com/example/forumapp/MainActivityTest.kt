package com.example.forumapp

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun `clicking submit with all fields filled shows toast`() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                val nameField = activity.findViewById<EditText>(R.id.editTextName)
                val emailField = activity.findViewById<EditText>(R.id.editTextEmail)
                val dobField = activity.findViewById<EditText>(R.id.editTextDateOfBirth)
                val submitButton = activity.findViewById<Button>(R.id.buttonSubmit)

                nameField.setText("John Doe")
                emailField.setText("john.doe@example.com")
                dobField.setText("01/01/2000")
                submitButton.performClick()

                val toast = Toast.makeText(activity, "", Toast.LENGTH_SHORT)
                assertNotNull(toast)
            }
        }
    }
}
