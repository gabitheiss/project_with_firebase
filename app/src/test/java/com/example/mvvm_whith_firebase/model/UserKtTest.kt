package com.example.mvvm_whith_firebase.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UserTest {

    @Test
    fun `email contem @`(){
        val resultado = User("t_gaaby@hotmail.com", "1234566", "1234566", "saaaa").validarUser()
        assertThat(resultado).isTrue()
    }
    @Test
    fun `senha tem mais que 6 caracteres`(){
        val resultadoSenha = User("","345","","").validarUser()
        assertThat(resultadoSenha).isFalse()
    }
    @Test
    fun `senhaValidada é igual a senha`(){
        val senhaValidada = User("t_gaaby@hotmail.com","123456","123456","aaaaaa").validarUser()
        assertThat(senhaValidada).isTrue()
    }
    @Test
    fun `nome contem mais que 2 caracteres`(){
        val nomeResult = User("","","","a").validarUser()
        assertThat(nomeResult).isFalse()
    }

}