package com.example.mvvm_whith_firebase.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_whith_firebase.R
import com.example.mvvm_whith_firebase.adapter.AdapterList
import com.example.mvvm_whith_firebase.model.Conta
import com.example.mvvm_whith_firebase.model.Navigation
import com.example.mvvm_whith_firebase.view_model.LogadoViewModel

class LogadoFragment(interfaceNavigate: Navigation) : Fragment(R.layout.logado_fragment) {



    private lateinit var viewModel: LogadoViewModel
    private lateinit var recyclerView: RecyclerView
    private val adapter = AdapterList()

    val observerContas = Observer<List<Conta>>{
        adapter.refresh(it)
    }
    val observerError = Observer<String> {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LogadoViewModel::class.java)
        recyclerView = view.findViewById(R.id.contasRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.error.observe(viewLifecycleOwner,observerError)
        viewModel.contas.observe(viewLifecycleOwner,observerContas)


        view.findViewById<Button>(R.id.buttonSalvar).setOnClickListener {
            val inputName = view.findViewById<EditText>(R.id.inputNome)
            val inputValor = view.findViewById<EditText>(R.id.inputValor)
            if (inputName.text.toString().isNotEmpty() && inputValor.text.toString().isNotEmpty()) {
                viewModel.addConta(
                    inputName.text.toString(),
                    inputValor.text.toString().toDoubleOrNull()
                )
            }
        }

        fun loadData(){
            viewModel.buscarConta()
        }
    }

}