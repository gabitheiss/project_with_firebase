package com.example.mvvm_whith_firebase.model

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot

data class Conta(
    var uid: String?,
    val nome: String?,
    val valor: Double?
) {

    fun validarConta(): Boolean {
        if (valor == null) {
            return false
        }
        if (valor < 0) {
            return false
        }
        return true
    }

    companion object {

        fun fromData(snapshot: QueryDocumentSnapshot): Conta {
            return Conta(
                uid = snapshot.id,
                nome = snapshot.data["nome"] as? String,
                valor = snapshot.data["valor"] as? Double
            )
        }

        //funcao para chamar somente uma conta para a tela detalhes
        fun fromDocument(doc: DocumentSnapshot): Conta {
            return Conta(
                uid = doc.id,
                nome = doc["nome"] as? String,
                valor = doc["valor"] as? Double
            )
        }
    }


}
