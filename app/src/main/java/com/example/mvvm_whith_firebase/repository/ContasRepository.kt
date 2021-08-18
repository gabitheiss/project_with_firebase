package com.example.mvvm_whith_firebase.repository

import com.example.mvvm_whith_firebase.model.Conta
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



const val CONTAS_COLLETION = "Contas"

class ContasRepository {

    private val dataBase = Firebase.firestore

    fun buscarContas(callback: (List<Conta>?, String?) -> Unit) {
        dataBase.collection(CONTAS_COLLETION)
            .get()
            .addOnSuccessListener { result ->

                val listOf = arrayListOf<Conta>()
                result.forEach {
                    val conta = Conta.fromData(it)
                    listOf.add(conta)
                }
                callback(listOf, null)

            }
            .addOnFailureListener { exception ->
                callback(null, exception.message)
            }
    }

    fun addConta(conta: Conta, callback: (Conta?, String?) -> Unit) {
        dataBase.collection(CONTAS_COLLETION)
            .add(conta)
            .addOnSuccessListener {

                Conta.fromDocument(it).apply {
                    callback(this, null)
                }

            }
            .addOnFailureListener { exception ->
                callback(null, exception.message)
            }
    }
}