package com.example.mvvm_whith_firebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_whith_firebase.R
import com.example.mvvm_whith_firebase.model.Conta

class AdapterList: RecyclerView.Adapter<ContaViewHolder>() {

    private var listaContas: MutableList<Conta> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itens_list, parent,false)
        return ContaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContaViewHolder, position: Int) {
        listaContas[position].apply{
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listaContas.size


    fun refresh(newList: List<Conta>) {
        listaContas = arrayListOf()
        listaContas.addAll(newList)
        notifyDataSetChanged()
    }

}



class ContaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(conta: Conta) {
        setData(conta.name, R.id.textConta)
        setData(conta.price.toString(), R.id.textValor)
    }

    private fun setData(value: String?, @IdRes componentId: Int) {
        itemView.findViewById<TextView>(componentId).apply {
            text = value
        }
    }
}