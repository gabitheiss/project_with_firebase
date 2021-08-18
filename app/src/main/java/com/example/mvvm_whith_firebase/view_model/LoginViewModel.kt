package com.example.mvvm_whith_firebase.view_model

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_whith_firebase.repository.AuthenticationRepository
import com.example.mvvm_whith_firebase.model.Navigation
import com.google.firebase.auth.FirebaseUser


class LoginViewModel : ViewModel(), Navigation {


    private val _usuario = MutableLiveData<FirebaseUser>()
    val usuario: LiveData<FirebaseUser> = _usuario

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error



    private val authenticationRepository = AuthenticationRepository()

    fun signIn(email: String, password: String) {
        authenticationRepository.loginEmailSenha(email, password) { firebaseUser, error ->
            if (firebaseUser != null) {
                _usuario.value = firebaseUser
            } else {
                _error.value = error ?: "DADOS INCORRETOS!"
            }
        }
    }


    override fun goToFragment(fragment: Fragment) {

    }

}

