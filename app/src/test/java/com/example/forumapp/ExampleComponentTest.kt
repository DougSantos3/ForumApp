package com.example.forumapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *  # Testes de componentes
 * │   │   ├── repository/   # Integração de repositórios
 * │   │   ├── service/      # Integração de serviços/API
 * │   │   └── viewmodel/    # ViewModels com dependências
 * │   └── shared/           # Mocks, Fakes e Helpers
 */
class ExampleComponentTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}