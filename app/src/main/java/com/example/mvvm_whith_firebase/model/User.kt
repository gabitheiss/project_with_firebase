package com.example.mvvm_whith_firebase.model

data class User(
    var email: String,
    var senha: String,
    var senhaValidada: String,
    var nome: String
) {
    fun validarUser(): Boolean {
        if (!email.contains("@")) {
            return false
        }
        if (senha.length < 6 || senha != senhaValidada) {
            return false
        }
        if (nome.length <= 2) {
            return false
        }
        return true
    }
}


