package com.example.mvvm_whith_firebase.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class AuthenticationRepository {

    //comunica com o firebase
    private val auth = FirebaseAuth.getInstance()

    fun criarUsuario(email: String, senha: String, callback: (FirebaseUser?) -> Unit) {
        val task = auth.createUserWithEmailAndPassword(email, senha)
        task.addOnSuccessListener { authResult ->
            callback(authResult.user)
        }
    }


    fun loginEmailSenha(email: String, password: String, callback: (FirebaseUser?, String?) -> Unit) {
        val task = auth.signInWithEmailAndPassword(email, password)
        task.addOnSuccessListener { authResult ->
            if (authResult.user != null) {
                callback(authResult.user, null)
            } else {
                callback(null, "ERRO")
            }
        }
        task.addOnFailureListener {
            callback(null, it.message)
        }
    }

}