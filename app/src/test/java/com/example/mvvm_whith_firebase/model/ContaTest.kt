package com.example.mvvm_whith_firebase.model

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ContaTest {

    val nomeContas = arrayListOf<String>()

    @Before
    fun setup(){
        nomeContas.add("energia")
        nomeContas.add("combustivel")
        nomeContas.add("multa")
        nomeContas.add("comida")
    }

    @Test
    fun `validar categoria`(){
        val conta  = Conta("","comida",0.0)
        //verificar se o nome está dentro do array de nomes
        assertThat(conta.nome).isIn(nomeContas)
    }

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