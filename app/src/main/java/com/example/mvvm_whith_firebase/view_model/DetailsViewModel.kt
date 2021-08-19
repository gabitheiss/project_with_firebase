package com.example.mvvm_whith_firebase.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_whith_firebase.model.Conta
import com.example.mvvm_whith_firebase.repository.ContasRepository

class DetailsViewModel : ViewModel() {

    private val _conta = MutableLiveData<Conta>()
    val conta: LiveData<Conta> = _conta

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _deleteSuccess = MutableLiveData<Boolean>()
    val deleteSuccess: LiveData<Boolean> = _deleteSuccess


    private val contasRepository = ContasRepository()


    fun buscarConta(uid: String) {
        contasRepository.buscarUmaConta(uid) { conta, error ->
            if (error != null) {
                _error.value = error
            } else {
                _conta.value = conta
            }
        }
    }
    fun deleteItem(uid: String) {
        contasRepository.deleteConta(uid) { success ->
            _deleteSuccess.value = success
        }
    }
}