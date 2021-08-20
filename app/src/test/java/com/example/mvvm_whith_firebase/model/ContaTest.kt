package com.example.mvvm_whith_firebase.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ContaTest {

    @Test
    fun `Valor é maior que zero e retornar false`() {
        val result = Conta(null,"", -10.0).validarConta()
        assertThat(result).isFalse()
    }

    @Test
    fun `Valor é maior que zero e retornar true`() {
        val result = Conta(null,"", 10.0).validarConta()
        assertThat(result).isTrue()
    }

    @Test
    fun `Valor é null retornar false`() {
        val result = Conta(null,"", null).validarConta()
        assertThat(result).isFalse()
    }
}