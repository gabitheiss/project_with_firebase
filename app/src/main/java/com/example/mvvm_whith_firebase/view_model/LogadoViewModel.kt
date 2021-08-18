package com.example.mvvm_whith_firebase.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mvvm_whith_firebase.model.Conta
import com.example.mvvm_whith_firebase.repository.ContasRepository
import com.google.firebase.auth.FirebaseUser

class LogadoViewModel : ViewModel() {

    private val _contas = MutableLiveData<List<Conta>>()
    val contas: LiveData<List<Conta>> = _contas

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    private val contasRepository = ContasRepository()


    fun buscarConta() {
        contasRepository.buscarContas() { contas, error ->
            if (error != null) {
                _error.value = error
            } else {
                _contas.value = contas
            }
        }
    }

    fun addConta(name: String, price: Double?) {
        Conta(null, name, price).apply {
            contasRepository.addConta(this) { bill, error ->
                if (error != null) {
                    _error.value = error
                } else {
                    buscarConta()
                }
            }
        }
    }
}