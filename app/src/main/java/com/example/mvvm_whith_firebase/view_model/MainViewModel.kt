package com.example.mvvm_whith_firebase.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_whith_firebase.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseUser

class MainViewModel : ViewModel(){

    private val _usuario = MutableLiveData<FirebaseUser?>()
    val usuario: LiveData<FirebaseUser?> = _usuario

    private val repository = AuthenticationRepository()


    //comunica com o repository
    fun criarNovoUser(email: String, senha: String) {
        repository.criarUsuario(email, senha) {
            _usuario.value = it
        }
    }


}

