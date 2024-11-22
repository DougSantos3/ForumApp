package com.example.forumapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 * fragmented/       # Testes de Fragmentos, Activities, etc.
 *     │   ├── fragment/     # Testes de Fragments
 *     │   └── activity/     # Testes de Activities
 */
@RunWith(AndroidJUnit4::class)
class ExampleFragmentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.forumapp", appContext.packageName)
    }
}