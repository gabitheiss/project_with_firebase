package com.example.mvvm_whith_firebase.model

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.QueryDocumentSnapshot

data class Conta(
    var uid: String?,
    val name: String?,
    val price: Double?
) {
    companion object {

        fun fromData(snapshot: QueryDocumentSnapshot): Conta {
            return Conta(
                uid = snapshot.id,
                name = snapshot.data["name"] as? String,
                price = snapshot.data["price"] as? Double
            )
        }

        fun fromDocument(doc: DocumentReference): Conta{
            return Conta(
                uid = doc.id,
                name = null,
                price = null
            )
        }
    }


}
